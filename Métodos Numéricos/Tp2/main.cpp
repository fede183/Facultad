#include "MatrizEs.h"
#include <math.h>
#include <iomanip>
#include <time.h>
#include <algorithm>    //para sort
#include <fstream>
#include <iostream>
#include <stdio.h>
#include <string.h>
#include <cmath>
using namespace std;

double norma(vector<double> v){
    double norm=0;
    for(unsigned int i=0;i<v.size();i++){
        norm+=pow(v[i],2);
    }
    norm=sqrt(norm);
    return norm;
}

double norma1(vector<double> &x){
    double res = 0;
    for(int i = 0; i<x.size(); i++){
        res += abs(x[i]);
    }
    return res;
}

//Divide cada uno de los valores del vector por la norma 2 del mismo
void normalizarVector(vector<double> &v){
    double norm=norma(v);
    for(unsigned int i=0;i<v.size();i++){
        v[i]=v[i]/norm;
    }
}

void normalizarVector1(vector<double> &v){
    double norm=norma1(v);
    for(unsigned int i=0;i<v.size();i++){
        v[i]=v[i]/norm;
    }
}

void metodoPotencia(MatrizEs &P, vector<double> &x, double epsilon, double c){
    vector<double> y(x.size());
    double delta;
    do{
        y=P.multiplicar(x);
        for (int i = 0; i<y.size(); i++){
            y[i] = c*y[i];
        }
        double w = norma1(x)-norma1(y);
        for(int i = 0; i<y.size(); i++){
            y[i] = y[i]+(w/((double) P.CantC()));
        }
        normalizarVector1(y);
        vector<double> aux;
        aux.resize(x.size());
        for(int i = 0; i<aux.size(); i++){
            aux[i] = y[i] - x[i];
        }
        delta = norma1(aux);
        x = y;
    }
    while(delta>=epsilon);
}

void pagerank(MatrizEs &links, vector<double> &res, double epsilon, double c){
    //armo P
    vector<double> cantLinks(links.CantC(), 0);
    for(int i = 0; i<(links.valores()).size(); i++){
        cantLinks[links.columnas()[i]] += links.valores()[i];
    }
    for (int i = 0; i<(links.valores()).size(); i++){
        links.agValor((1.0/cantLinks[links.columnas()[i]]), i);
    }
    //inicializo a res en [1,...,1]
    res.resize(links.CantC());
    for (int i = 0; i<res.size(); i++){
        res[i] = 1.0;
    }
    normalizarVector1(res);

    //Hago el metodo de potencia para tener en res el autovector buscado
    metodoPotencia(links, res, epsilon, c);
}

void crearMatrizEsparza(MatrizEs &res, const vector<int> &xj, const vector<int> &yi, unsigned int m, unsigned int n ){ //m es la cantidad de lineas con pares i,j
//n es la cantidad de links distintos -- m es la cantidad de pares que nos dan
    int cantValores = 0;
    vector<vector<int> > resParciales;
    int max = 0;
    for(unsigned int i = 0; i<m; i++){
        if(xj[i]>max){
            max = xj[i];
        }
        if(yi[i]>max){
            max = yi[i];
        }
    }
    if(max < n){
	max = n;
    }
    resParciales.resize(max); //aca voy a guardar cada conjunto de i's de  yi que apuntan a un determinado xj
    for (unsigned int i = 0; i < m; i++){
        resParciales[yi[i]-1].push_back(xj[i]); //tomo todos los xi que apuntan a yi[i]
    }
    for (unsigned int i = 0; i < max; i++){
        sort(resParciales[i].begin(), resParciales[i].end());   //ordeno cada vector
    }
    vector<unsigned int> row_ptr;
    vector<unsigned int> col_ind;
    vector<double> vals;
    for (unsigned int i = 0; i < max; i++){
        if (resParciales[i].size() == 0){
            row_ptr.push_back(cantValores);
        } else {
            for (unsigned int j = 0; j < resParciales[i].size(); j++){
                col_ind.push_back((resParciales[i][j])-1);
                vals.push_back(1.0);
            }
            row_ptr.push_back(cantValores);
            cantValores += resParciales[i].size();
        }
    }
    row_ptr.push_back(col_ind.size());
    res = MatrizEs(col_ind, row_ptr, vals, max, max);
}

void cargar(ifstream& in, int &alg, double &c, int &tipoInstancia, int &cantLinks, int &cantPares, vector<int> &xj, vector<int> &yi, double &tolerancia){
    in >> alg;
    in >> c;
    in >> tipoInstancia;
    string lala;
    char a;
    in.get(a);
    getline(in,lala,'.');
    lala += ".txt";
    in.get(a);
    in.get(a);
    in.get(a);
    in >> tolerancia;
    char e[lala.size()];
    strcpy(e, lala.c_str());
    ifstream file;
    file.open(e);
    string aux;
    getline(file, aux);
    file.get(a);
    file.get(a);
    file.get(a);
    if (!(a=='N')){
        getline(file, aux);
    }
    file.ignore(256, ':');
    file>>cantLinks;
    file.ignore(256, ':');
    file>>cantPares;
    getline(file, aux);
    xj.resize(cantPares);
    yi.resize(cantPares);
    for (int i = 0; i < cantPares; i++){
        getline(file, aux);
        file>>xj[i];
        file>>yi[i];
    }
    file.close();
}


//si no es HITs habria que poner dos veces el vector xj como entrada porque igualmente no se tomaria
void mostrar(ofstream& os, vector<double> xj, vector<double> yi, int cantPares, int alg){
    //cant pares es el m
    if(alg==1){ //es HITS
        for (int i = 0; i < cantPares; i++){
            os << setprecision(10) << xj[i] << endl;
        }
        for (int i = 0; i < cantPares; i++){
            os << setprecision(10) << yi[i] << endl;
        }
    } else {
         for (int i = 0; i < cantPares; i++){
            os << setprecision(10) << xj[i] << endl;
        }
    }
}

void Iterative(MatrizEs src, unsigned int k, vector<double> &xr, vector<double> &yr){
        
        vector<double> x(src.CantF(),1), y(src.CantF(),1);
        for(unsigned int i=0;i<k-1;i++){
            x=src.multiplicarT(y);
            y=src.multiplicar(x);
            normalizarVector(x);
            normalizarVector(y);
        }
        xr=x;
        yr=y;
        
}

void indeg(MatrizEs &links, vector<double> &res){
	//Calcular en res la cantidad de links que apuntan a cada pagina
	res.resize(links.CantC(), 0);
	int principioFila, finalFila;
	for(unsigned int i=0;i<links.CantC();i++){
                principioFila=links.primNoCero()[i];
                finalFila=links.primNoCero()[i+1];
                for(unsigned int j=principioFila;j<finalFila;j++){
                	res[i] += 1;
                }
	}
}

void sacarMaximos(vector<double> &v, int k){//Saca la cantidad de outliers pasada en k
    for(int j=0;j<k;j++){
        int resul=0;
        for(int i=1;i<v.size();i++){
            if(v[resul]<v[i]){
                resul=i;
            }
        }
        v.erase(v.begin()+resul);
    }
}
void sacarMinimos(vector<double> &v, int k){//Saca la cantidad de outliers pasada en k
    for(int j=0;j<k;j++){
        int resul=0;
        for(int i=1;i<v.size();i++){
            if(v[resul]>v[i]){
                resul=i;
            }
        }
        v.erase(v.begin()+resul);
    }
}

double promedio(vector<double> v){
    double resultado=0;
    for(int i=0;i<v.size();i++){
        resultado+=v[i];
    }
    resultado=resultado/v.size();
    return resultado;
}

vector<double> diferencia(vector<double> v1, vector<double> v2){
    vector<double> resultado(v1.size());
    for(int i=0;i<v1.size();i++){
        resultado[i]=abs(v1[i]-v2[i]);
    }
    return resultado;
}

double sumatoria(vector<double> v){
    double resultado=0;
    for(int i=0;i<v.size();i++){
        resultado+=v[i];
    }
    return resultado;
}

int main(int argc, char *argv[]){
    ifstream arcEntrada;
    arcEntrada.open(argv[1]);   //Pongo en arcEntrada el archivo donde estan los datos a cargar
    ofstream arcSalida;
    arcSalida.open(argv[2]);    //Pongo en arcSalida el archivo donde se va a escribir el resultado
    int alg;
    double c;
    int tipoInstancia;
    int cantPares;
    int cantLinks;
    vector<int> xj;
    vector<int> yi;
    double tolerancia;
    cargar(arcEntrada, alg, c, tipoInstancia, cantLinks, cantPares, xj, yi, tolerancia);
    MatrizEs links;
    vector<double> res;
    crearMatrizEsparza(links, xj, yi, cantPares, cantLinks);
    if(alg == 0){
        pagerank(links, res, tolerancia, c);
        mostrar(arcSalida, res, res, res.size(), alg);
    }else{
        if(alg == 1){
            vector<double> resHits1, resHits2;
            Iterative(links, 50, resHits1, resHits2);
            mostrar(arcSalida, resHits2, resHits1, resHits2.size(), alg);  
        }else{
            indeg(links, res);
            mostrar(arcSalida, res, res, res.size(), alg);
        }
    }
    arcEntrada.close();     //cierro el arcEntrada
    arcSalida.close();  //cierro el arcSalida
    return 0;
}
