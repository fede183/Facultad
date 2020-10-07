#include <iostream>
#include <fstream>
#include <math.h>
#include <cmath>
#include <vector>
#include <utility>
#include <iomanip> 

using namespace std;
//Funciones Auxiliares
bool igual(double a, double b){
	return abs(a-b)<=0.0000005;
}

int ordenIncog(int i, int j, int n){
	return n*(i)+(j);
}

int xDevolver(int k, int n){
	return k/n;
}
int yDevolver(int k, int n){
	return k%n;
}

void cambiar_Posicion(vector<vector<double> > &matriz, vector<double> &res, unsigned int filasCant, unsigned int columnasCant, unsigned int prim, unsigned int secon){// Cambia posiciones de filas
	double aux;
	int i=0;
	while(i<columnasCant){
		aux= matriz[prim][i];
		matriz[prim][i]=matriz[secon][i];
		matriz[secon][i]= aux;
		i++;
	}
	aux= res[prim];
	res[prim]= res[secon];
	res[secon]= aux;
}

double tempPuntoCritico(vector<double> res, double a, double b, double h){
	int m=(b/h)+1,n=(a/h)+1;
	double xPC = a/2;
	double yPC = b/2;
	if(m%2==1 && n%2==1){
		return res[ordenIncog(m/2, n/2, n)];
	}
	if(m%2==0 && n%2==0){
		unsigned int k = m/2, i = n/2;
		double result = (res[ordenIncog(k-1,i-1,n)]+res[ordenIncog(k-1,i,n)]+res[ordenIncog(k,i-1,n)]+res[ordenIncog(k,i,n)])/4;
		return result;
	}
	if(m%2==0){
		int i = n/2, k = m/2;
		double result = (res[ordenIncog(k,i,n)]+res[ordenIncog(k-1,i,n)])/2;
		return result;
	}else{
		int i = n/2, k = m/2;
		double result = (res[ordenIncog(k,i,n)]+res[ordenIncog(k,i-1,n)])/2;
		return result;
	}
}

bool englobaSanguijuela(double i, double j, double x, double y, double r){ //Se fija si el punto (j, i) esta en el radio de la sanguijuela en el punto (x,y)
	return ( sqrt( (i-y)*(i-y) +(j-x)*(j-x) ) <=r ); //||(j,i)-(x,y)||=raizCuadrada((j-x)^2+(i-y)^2)<=Radio
}

bool haySang(int i, int j,const  vector<double> &x,const  vector<double> &y, double r, double h, unsigned int k){
	unsigned int a = 0;
	bool res = false;
	while(a<k && !res){
		res = res || englobaSanguijuela(i*h,j*h,x[a],y[a],r);
		a++;
	}
	return res;
}

int dameSang(double i, double j, vector<double> &x, vector<double> &y, double r, double h, unsigned int k, int n, int m, double radio){
    vector<double> sangX (x);
    vector<double> sangY (y);
    vector<bool> boolX;
    boolX.resize(k);
    for(int b = 0; b<k; b++){
        boolX[b] = false;
    }
	int s = 0;
	int res = 0;
	while (s<m)
    {
        int d = 0;
        while (d<n)
        {
            if ((((s*h)-j)*((s*h)-j))+(((d*h)-i)*((d*h)-i))<=(radio*radio))
            {
                int q=0;
                while(q<k)
                {
                    if (!(englobaSanguijuela(s*h, d*h, sangX[q], sangY[q], r)) && (boolX[q])==false )
                    {
                        x[q]=-1;
                        y[q]=-1;
                    }else{ 
                    	if(!(englobaSanguijuela(s*h, d*h, sangX[q], sangY[q], r)) && boolX[q]==true){}
                    	else{
                           res++;
                           x[q] = sangX[q];
                           y[q] = sangY[q];
                           boolX[q] = true;
                        }
                    }
                    q++;
                } 
            }
            d++;
        }
        s++;
    }
    return res;
}
// Funciones Eliminación Gauseana
void eliminacion_Gausiana(vector<vector<double> > &matriz, vector<double> &res, unsigned int filasCant, unsigned int columnasCant){ //mas precision
    unsigned int i=0, j, j2=0, i2;
    double aux;
    while(i<filasCant){
        i2= 0;
        j= i+1;
        while(j<filasCant){ 					
            aux= matriz[j][i]/matriz[i][i];
            matriz[j][i]=0;
            j2=i+1;
            while(j2<columnasCant){
                matriz[j][j2]= matriz[j][j2] - (aux*matriz[i][j2]);
                j2++;
            }
            res[j]= res[j] - (aux*res[i]);
            j++;
        }
        i++;
    }	
}

void EGBanda(vector<vector<double> > &eqlin, vector<double> &res, unsigned int n, unsigned int m){
	unsigned int f=0;
	unsigned int c = 0;
	while(f<n*m){
		while(c<n && eqlin[f][c]==0){
			c++;
		}
		if(c<n){
			double m = eqlin[f][c]/eqlin[f-(n-c)][n];
			eqlin[f][c]=0;
			for(unsigned int i = c+1; i<=c+n; i++){
				eqlin[f][i] = eqlin[f][i] - m*eqlin[f-(n-c)][n+(i-c)];
			}
			res[f] = res[f] - m*res[f-(n-c)];
			c++;
		}else{
			f++;
			c = 0;
		}
	}
}
// Funciones Resolver
void resolver(vector<vector<double> > &matriz, vector<double> &res, unsigned int filasCant, unsigned int columnasCant, vector<double> &result) {
    result.resize(filasCant);
    for( int i=filasCant-1;i>=0;i--){
            result[i]= res[i]/matriz[i][i];
            for( int j=i-1;j>=0;j--){
                res[j]= res[j]-(matriz[j][i]*result[i]);
            }
    }
}

void resolverMB(vector<vector<double> > &eqlin, vector<double> &res, unsigned int n, unsigned int m) {
	for(int i = n*m-1; i>=0; i--){
		res[i]=res[i]/eqlin[i][n];
		eqlin[i][n]=1;
		for(int j=i-1; j>=0; j--){
			if(n+i-j<2*n+1){
				res[j]=res[j]-eqlin[j][n+(i-j)]*res[i];
				eqlin[j][n+(i-j)]=0;
			}
		}
	}
}
//Función mostrar y cargar(para leer los datos de entrada del programa y devolverlos con el formato pedido)
void mostrar(ofstream& os, int n, int m, const vector<double> &res){
	for(int i = 0; i<n*m; i++){
		os << xDevolver(i,n) << "\t" << yDevolver(i,n) << "\t" << setprecision(10) << res[i] << endl;
	}
}

void cargar(ifstream& is, double &a, double &b, double &h, double &r, double &t, unsigned int &k, vector<double> &x, vector<double> &y){
	char aux; 		
	is>>a; 		 		//Cargo a		
	is>>b; 				//Cargo b
	is>>h; 				//Cargo h
	is>>r; 				//Cargo r
	is>>t; 				//Cargo t
	is>>k; 				//Cargo k
	x.resize(k); 		//Cambio los tamaños de x e y de acuerdo con el nuevo k
	y.resize(k);
	string m;
	for(unsigned int i=0;i<k;i++){ 		// Cargo los x e y(Coordenadas de las sanguijuelas)
		getline(is, m);
		is>>x[i];
		is>>y[i];
	}
}

//Funciones Crear Matriz
void CrearMatriz(vector<vector<double> > &eqlin, vector<double> &res, double a, double b, double h, double r, double t, unsigned int k, const vector<double> &x, const vector<double> &y){
	int m=(b/h)+1,n=(a/h)+1, i=0,j=0;
	eqlin.resize(m*n);
    for ( int i = 0 ; i < m*n ; i++ ){
        eqlin[i].resize(m*n);
    }
    res.resize(n*m);
	while(i<m){
        j = 0;
		while(j<n){
			int ordenIn = ordenIncog(i,j,n);
			if(i==0 || j==0 || i==m-1 || j==n-1 || haySang(i,j,x,y,r,h,k)){
				int col = 0;
				while(col<n*m){
					if(col != ordenIn){
						eqlin[ordenIn][col] = 0;
					}else{
						eqlin[ordenIn][col] = 1;
					}
					col++;
				}
				if(i==0 || j==0 || i==m-1 || j==n-1){
					res[ordenIn] = -100;
				}else{
					res[ordenIn] = t;
				}
			}else{
				int col = 0;
				while(col<n*m){
					if(col == ordenIn){
						eqlin[ordenIn][col] = -4;
					}else{
						if(col==ordenIn+1 || col==ordenIn-1 || col==ordenIn-n || col==ordenIn+n){
							eqlin[ordenIn][col] = 1;
						}else{
							eqlin[ordenIn][col] = 0;
						}
					}
					col++;
				}
				res[ordenIn] = 0;
			}
			j++;
		}
		i++;
	}
}

void CrearMatrizBanda(vector<vector<double> > &eqlin, vector<double> &res, double a, double b, double h, double r, double t, unsigned int k, const vector<double> &x, const vector<double> &y){
	int m=(b/h)+1,n=(a/h)+1, i=0,j=0;
	eqlin.resize(m*n);
	for ( int i = 0 ; i < m*n ; i++ ){ //creo vector de (n*2)+1 columnas con m*n filas
		eqlin[i].resize((2*n)+1);
	}
	res.resize(m*n);
	while(i<m){
        	j = 0;
		while(j<n){
			int ordenIn = ordenIncog(i,j,n);
			if(i==0 || j==0 || i==m-1 || j==n-1 || haySang(i,j,x,y,r,h,k)){
                		eqlin[ordenIn][n] = 1;
				if(i==0 || j==0 || i==m-1 || j==n-1){
					res[ordenIn] = -100;
				}else{
					res[ordenIn] = t;
				}
			}else{
				eqlin[ordenIn][0] = 1;
				eqlin[ordenIn][n-1] = 1;
				eqlin[ordenIn][n] = -4;
				eqlin[ordenIn][n+1] = 1;
				eqlin[ordenIn][2*n] = 1;
				res[ordenIn] = 0;
			}
			j++;
		}
		i++;
	}
}

//Función para eliminar las sanguijuelas de las coordenadas
void borrar(vector<double>& x, vector<double>& y, double v1, double v2, unsigned int k)
{
    for(int i=0; i<k ;i++)
    {
        if (x[i] == v1 && y[i] == v2)
        {
            x.erase(x.begin()+i);
            y.erase(y.begin()+i);
            i=k;
        } 
    }
}
//Función para eliminar sanguijuelas(las menos posibles y para asegurar con alta presicion que la ventanilla no se rompera)
void elimina_sangui(vector<vector<double> > &eqlin, vector<double> &res, double a, double b, double h, double r, double t, unsigned int &k, vector<double> &x, vector<double> &y, bool esBanda)
{
    int m=(b/h)+1,n=(a/h)+1;
    vector<double> result;
    result.resize(m*n);
    double temp;
    vector<vector<double> > ma;
    vector<double> re;
    if((esBanda)==false)
    {
        CrearMatriz(ma, re, a, b, h, r, t, k, x, y);
        CrearMatriz(eqlin, res, a, b, h, r, t, k, x, y);
        eliminacion_Gausiana(ma, re, m*n, n*m);
        resolver(ma, re, n*m, n*m, result);
        temp = tempPuntoCritico(result, a, b, h);
    }else {
        CrearMatrizBanda(ma, re, a, b, h, r, t, k, x, y);
        CrearMatrizBanda(eqlin, res, a, b, h, r, t, k, x, y);
        EGBanda(ma, re, n, m);
        resolverMB(ma, re, n, m);
        temp = tempPuntoCritico(re, a, b, h);
    }

    double radio = h;
    double pci = a/2;
    double pcj = b/2;
    if(temp>=235 && m%2==1 && n%2==1){  //debo ver si hay sanguijuelas en el punto critico
        vector<double> borrarEnX (x);
        vector<double> borrarEnY (y);
        int cantK = k;
        for (int i = 0; i<cantK; i++){
            if (englobaSanguijuela(pci, pcj, borrarEnX[i], borrarEnY[i], r)){
                    borrar(x, y, borrarEnX[i], borrarEnY[i], k);
                    k--;
            }
        }
    	if((esBanda)==false)
    	{
		CrearMatriz(ma, re, a, b, h, r, t, k, x, y);
		CrearMatriz(eqlin, res, a, b, h, r, t, k, x, y);
		eliminacion_Gausiana(ma, re, m*n, n*m);
		resolver(ma, re, n*m, n*m, result);
		temp = tempPuntoCritico(result, a, b, h);
    	} else {
		CrearMatrizBanda(eqlin, res, a, b, h, r, t, k, x, y);
		CrearMatrizBanda(ma, re, a, b, h, r, t, k, x, y);
		EGBanda(ma, re, n, m);
		resolverMB(ma, re, n, m);
		temp = tempPuntoCritico(re, a, b, h);
    	}
    }
    while(temp>=235)
    {
        vector<double> sangEnX (x);
        vector<double> sangEnY (y);
        int cantS = dameSang(pci, pcj, sangEnX, sangEnY, r, h, k, n, m, radio);
        if (0<=cantS)
        {
          int g = 0;
          while (g<k){
                if(!(sangEnX[g]==-1)){
                    borrar(x, y, sangEnX[g], sangEnY[g], k);
                    k--;
                    cantS--;
                    g = k;
                    if((esBanda)==false)
                    {
                        CrearMatriz(eqlin, res, a, b, h, r , t, k, x, y);
                        CrearMatriz(ma, re, a, b, h, r, t, k, x, y);                        
                        eliminacion_Gausiana(ma, re, m*n, n*m);
                        resolver(ma, re, n*m, n*m, result);
                        temp = tempPuntoCritico(result, a, b, h);
                    }else{
			CrearMatrizBanda(eqlin, res, a, b, h, r, t, k, x, y);
                        CrearMatrizBanda(ma, re, a, b, h, r, t, k, x, y);
                        EGBanda(ma, re, n, m);
                        resolverMB(ma, re, n, m);
                        temp = tempPuntoCritico(re, a, b, h);
                    }
                } else {
		    g++;			
		}
            }
            if (cantS == 0)
            {
                radio = radio + h/4;
            }
        }else{
            radio = radio + h/4;
        }
    }
    res = re;
}

int main(int argc, char *argv[]){
	ifstream arcEntrada;
	arcEntrada.open(argv[1]); 	//Pongo en arcEntrada el archivo donde estan los datos a cargar
	ofstream arcSalida;
	arcSalida.open(argv[2]); 	//Pongo en arcSalida el archivo donde se va a escribir el resultado
	bool es_EGBanda = ((*argv[3])!='0');
	double a, b, h, r, t;
	unsigned int k;
	vector<vector<double> > matriz;
	vector<double> x, y, res, result;
	cargar(arcEntrada, a, b, h, r, t, k, x, y);  //Cargo el contenido del arcEntrada en las variables pasadas
	int m=(b/h)+1,n=(a/h)+1;
	if(!es_EGBanda){ 	//Elijo con que algoritmos resolver el problema(común ó banda)
		CrearMatriz(matriz, res, a, b, h, r, t, k, x, y); 	//Creo la matriz y cargo sus datos en matriz y res
		eliminacion_Gausiana(matriz, res, n*m, n*m); 		//Hago la eliminación gaussiana sobre matriz y res
		resolver(matriz, res,  m*n,  n*m, result); 			//Resuelvo el sistema con la matriz ya triagulada
		mostrar(arcSalida, n, m, result); 					//Escribo el resultado en arcSalida con el formato pedido
	}
	else{ 				//Idem anterior pero siendo matriz banda
		CrearMatrizBanda(matriz, res, a, b, h, r, t, k, x, y); 
		EGBanda(matriz, res, n, m);
		resolverMB(matriz, res, n, m);
		mostrar(arcSalida, n, m, res);
	}
	arcEntrada.close(); 		//cierro el arcEntrada
	arcSalida.close(); 			//cierro el arcSalida
	return 0;
}
