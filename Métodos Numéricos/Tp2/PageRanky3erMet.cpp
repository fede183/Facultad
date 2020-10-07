#include <cmath>
#include "Hits.cpp"
#include <fstream>

void indeg(MatrizEs &links, vector<double> &res){
	//Calcular en res la cantidad de links que apuntan a cada pagina
	res.resize(links.CantC());
	for(int i = 0; i<res.size(); i++){
		res[i] = 0;
	}
	for(int i = 0; i<(links.valores()).size(); i++){
		res[links.columnas()[i]] += links.valores()[i];
	}
}

double norma1(vector<double> &x){
	double res = abs(x[0]);
	for(int i = 1; i<x.size(); i++){
		if(abs(x[i])>res){
			res = abs(x[i]);
		}
	}
	return res;
}

void metodoPotencia(MatrizEs &P, vector<double> &x, double epsilon, double c){
	vector<double> y(x.size());
	double delta;
	do{
		y=P.multiplicar(x);
		double w = norma1(x)-c*norma1(y);
		for(int i = 0; i<y.size(); i++){
			y[i] = c*y[i]+w/((double) P.CantC());
		}
		normalizarVector(y);
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
		links.valores()[i]=1/cantLinks[links.columnas()[i]];
	}

	//inicializo a res en [1,...,1]
	res.resize(links.CantC());
	for (int i = 0; i<res.size(); i++){
		res[i] = 1;
	}
	normalizarVector(res);

	//Hago el metodo de potencia para tener en res el autovector buscado
	metodoPotencia(links, res, epsilon, c);
}

int main(int argc, char *argv[]){
	ifstream arcEntrada;
	arcEntrada.open(argv[1]); 	//Pongo en arcEntrada el archivo donde estan los datos a cargar
	ofstream arcSalida;
	arcSalida.open(argv[2]); 	//Pongo en arcSalida el archivo donde se va a escribir el resultado
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
	}
	mostrar(arcSalida, res, res, res.size(), alg);
	arcEntrada.close(); 	//cierro el arcEntrada
	arcSalida.close(); 	//cierro el arcSalida
	return 0;
}
