#ifndef MATRIZES_H_
#define MATRIZES_H_

#include <utility>
#include <vector>
using namespace std;

class MatrizEs {//Compressed Row Storage
    public:
        MatrizEs(){//Crea una matriz vacia
            this->filasCant=0;
            this->columnasCant=0;
        };
        //Crea la matriz con los datos pasados
        MatrizEs(const vector<unsigned int> &col, const vector<unsigned int> &ptr, const vector<double> &val, const unsigned int filas, const unsigned int columnas){//Constructor por copia
            this->filasCant=filas;
            this->columnasCant=columnas;
            this->row_ptr.resize(ptr.size());
            this->col_ind.resize(col.size());
            this->vals.resize(col.size());
            for(unsigned int i=0;i<this->row_ptr.size();i++){
                this->row_ptr[i]=ptr[i];
            }
            for(unsigned int i=0;i<this->vals.size();i++){
                this->vals[i]=val[i];
                this->col_ind[i]=col[i];
            }
        };

        //Precondición: El vector tiene que tener el tamaño correcto
        vector<double> multiplicar(vector<double> v){
            unsigned int principioFila, finalFila;
            vector<double> resultado(this->columnasCant,0);//resultado a devolver, le pongo el tamaño adecuado
            for(unsigned int i=0;i<this->filasCant;i++){
                principioFila=this->row_ptr[i];
                finalFila=this->row_ptr[i+1];
                for(unsigned int j=principioFila;j<finalFila;j++){
                    resultado[i]+=v[this->col_ind[j]]*(this->vals[j]);
                }
            }
            return resultado;
        };
        //Precondición: El vector tiene que tener el tamaño correcto
        //Multiplicaci\'on para traspuesta
        vector<double> multiplicarT(vector<double> v){
            int principioFila, finalFila;
            vector<double> resultado(this->columnasCant,0);//resultado a devolver, le pongo el tamaño adecuado
            for(unsigned int i=0;i<this->filasCant;i++){
                principioFila=this->row_ptr[i];
                finalFila=this->row_ptr[i+1];
                for(unsigned int j=principioFila;j<finalFila;j++){
                    resultado[this->col_ind[j]]+=v[i]*(this->vals[j]);
                }
            }
            return resultado;
        };
        //Funciones para devolver cada uno de los parametros
        const unsigned int CantF(){
            return this->filasCant;
        };
        const unsigned int CantC(){
            return this->columnasCant;
        };
        vector<double> valores(){
            return this->vals;
        };
        void agValor(const double &d, int pos){
            this->vals[pos] = d;
        }

        const vector<unsigned int>  columnas(){
            return this->col_ind;
        };

        const vector<unsigned int> primNoCero(){
            return this->row_ptr;
        };
        //La convierte en un arreglo de arreglos
       /* vector<vector<double> > convertir(){
            int principioFila, finalFila;
            vector<vector<double> > resultado(this->filasCant);
            for(unsigned int i=0;i<this->filasCant;i++){
                vector<double> aux(this->columnasCant,0);
                resultado[i]=aux;
            }
            for(unsigned int i=0;i<this->filasCant;i++){
                principioFila=this->row_ptr[i];
                finalFila=this->row_ptr[i+1];
                for(unsigned int j=principioFila;j<finalFila;j++){
                    resultado[i, col_ind[j]]=this->vals[j];
                }
            }
            return resultado;
        };*/
    private:
        vector<unsigned int> col_ind;
        vector<unsigned int> row_ptr;
        vector<double> vals;
        unsigned int filasCant;
        unsigned int columnasCant;
};


#endif // MATRIZES_H_
