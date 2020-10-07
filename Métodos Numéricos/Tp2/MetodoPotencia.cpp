#include "Hits.cpp"
#include <math.h>

double metodoPotencia(MatrizEs A, vector<double> x, unsigned int k){
	double resultado;
	vector<double> y;
	for(unsigned int i=0;i<k-1;i++){
		x=A.multiplicar(x);
	}
	y=x;
	x=A.multiplicar(x);
	resultado=norma(x)/norma(y);
	return resultado;
}