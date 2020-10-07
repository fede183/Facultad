#include "MatrizEs.h"
#include <math.h>

//Calcula la norma 2 del vector pasado y la devuelve
double norma(vector<double> v){
	double norm=0;
	for(unsigned int i=0;i<v.size();i++){
		norm+=pow(v[i],2);
	}
	norm=sqrt(norm);
	return norm;
}
//Divide cada uno de los valores del vector por la norma 2 del mismo
void normalizarVector(vector<double> v){
	double norm=norma(v);
	for(unsigned int i=0;i<v.size();i++){
		v[i]=v[i]/norm;
	}
}

pair<vector<double>,vector<double> > Iterative(MatrizEs src, unsigned int k){
	 	vector<double> x(src.CantF(),1), y(src.CantF(),1);
	 	for(unsigned int i=0;i<k;i++){
	 		x=src.multiplicarT(y);
	 		y=src.multiplicar(x);
	 		normalizarVector(x);
	 		normalizarVector(y);
	 	}
	 	return make_pair(x,y);
}
//Devuelve los c elementos mayores de el arreglo fs
vector<double> maximasC(vector<double> fs, unsigned int c){
	vector<double> resultado(c,0);
	unsigned int recorrido, aux;
	for(unsigned int i=0;i<c;i++){
		recorrido=fs.size();
		for(unsigned int j=0;j<recorrido;j++){
			if(resultado[i]<fs[j]){
				aux=j;
				resultado[i]=fs[j];
			}
		}
		fs.erase(fs.begin()+aux-1);
	}
	return resultado;
}
//Filtra las c autoridades y hubs mayores
pair<vector<double>, vector<double> > Filter(MatrizEs src, unsigned int k, unsigned int c){
	vector<double> x(src.CantF()), y(src.CantF());
	pair<vector<double>, vector<double> > res;
	res.first=x;
	res.second=y;
	res=Iterative(src, k);
	res.first=maximasC(res.first, c);
	res.second=maximasC(res.second, c);
	return res;
}
