#ifndef TRIED_HPP_
#define TRIED_HPP_

#include <assert.h>
#include "ListaCircular.h"
using namespace std;

template <class T, class F>
class Tried
{
	public:

		// Constructor. Valor cual quiera para el primero(solo es para el primer nodo inservible), para el segundo se pone el valor que se va a usar como fin de definición(como el simbolo '$').

		Tried(const T , const T);

		// Destructor. Debe dejar limpia la memoria.
		~Tried();

		// define una nueva clave y su significado, tam es el tamaño del diccionario tipo T que forma la clave, el tipo F su significado.
		// el diccionario no se modifica.
		void definir(const T*, unsigned int tam, const F&);

        //Cambia la definición de una clave en el diccionario(la clave debe estar definida)
        void cambiarDefinicion(const T*, unsigned int tam, const F&);

		// Decide si un elemento esta definido.
		bool estaDefinido(const T*, unsigned int tam) const;

		// borra un elemento del diccionario.
		// el diccionario no se modifica.
		void remover(const T*, unsigned int tam);

        //devuelve la definición de una clave en el diccionario(la clave tiene que estar definida)
        F obtener(const T*, unsigned int tam) const;

		// devuelve la cantidad de elementos que tiene el diccionario.
		unsigned int cantidad() const;

		// muestra el diccionario.
		void mostrar(std::ostream&) const;

	private:
		struct Nodo
        {
            Nodo(const T& g);
            Nodo(const T& g, const F& d);
            Nodo *sig;
            Nodo *ant;
            F definicion;
            T valor;
        };
		unsigned int cant;
        Nodo *prim;
		T finalPalabra;
};

template <class T, class F>
Tried<T, F>::Tried(const T primc, const T fin) : prim(new Nodo(primc)), cant(0), finalPalabra(fin)
{}

template <class T, class F>
Tried<T, F>::~Tried(){ 

}

template <class T, class F>
Tried<T, F>::Nodo::Nodo(const T& v): valor(v), sig(NULL), ant(NULL){}

template <class T, class F>
Tried<T, F>::Nodo::Nodo(const T& v, const F& d): valor(v), sig(NULL), ant(NULL), definicion(d){}

template <class T, class F>
bool Tried<T, F>::estaDefinido(const T *lis, unsigned int tam) const{
    Nodo *recorrico = this->prim->ant;
    bool estaLetra = false;
    unsigned int i = 0;
    while(tam>i){
        while(!estaLetra){
            if(recorrico == NULL){
                return false;
            }
            else if(recorrico->valor == lis[i]){
                estaLetra = true;
            }
            else{
                recorrico = recorrico->sig;
            }
        }
        recorrico = recorrico->ant;
        estaLetra = false;
        i++;
    }
    while(recorrico != NULL){
        if(recorrico->valor == this->finalPalabra){
            return true;
        }
        else{
            recorrico = recorrico->sig;
        }
    }
    return false;
    
}

template <class T, class F>
void Tried<T, F>::definir(const T *lis, unsigned int tam, const F& d){
    assert(!estaDefinido(lis, tam));
    Nodo *recorrico = this->prim;
    bool estaLetra = false;
    unsigned int i=0;
    if(recorrico->ant == NULL){
        Nodo *nuevo = new Nodo(lis[i]);
        recorrico->ant = nuevo;
        i++;
        if(i == tam){
            nuevo = new Nodo(this->finalPalabra, d);
            recorrico->ant->ant = nuevo;
        } 
    }
    recorrico = recorrico->ant;
    while(tam>i){
        while(!estaLetra){
            if(recorrico->valor == lis[i]){
                estaLetra = true;
            }
            else if(recorrico->sig == NULL){
                Nodo *nuevo = new Nodo(lis[i]);
                recorrico->sig = nuevo;
                recorrico = recorrico->sig;
                estaLetra = true;
            }
            else{
                recorrico = recorrico->sig;
            }
        }
        i++;
        if(recorrico->ant == NULL && tam > i){
            Nodo *nuevo2 = new Nodo(lis[i]);
            recorrico->ant = nuevo2;
            recorrico = recorrico->ant;
            i++;
        }

        if(i == tam){
            if(recorrico->ant != NULL){
                recorrico->ant->sig = recorrico->ant;
            }
            
            Nodo *nuevo3 = new Nodo(this->finalPalabra, d);
            recorrico->ant = nuevo3;
        }
        else{
            recorrico = recorrico->ant;  
        }
        
        estaLetra = (recorrico->ant == NULL);
    }
    this->cant++;
}

template <class T, class F>
void Tried<T, F>::cambiarDefinicion(const T *lis, unsigned int tam, const F& d){
    assert(estaDefinido(lis, tam));
    unsigned int i = 0;
    bool estaLetra = false;
    Nodo *recorrico = this->prim->ant;
    while(i<tam){
        while(!estaLetra){
            if(recorrico->valor == lis[i]){
                estaLetra = true;
            }
            else{
                recorrico = recorrico->sig;
            }
        }
        if(!(recorrico->ant->valor == this->finalPalabra)){
            recorrico = recorrico->ant;
        }
        i++;
    }

    Nodo *nuevo = new Nodo(this->finalPalabra, d), *aBorrar;

    if(recorrico->valor == lis[tam-1]){
        nuevo->sig = recorrico->ant->sig;
        aBorrar = recorrico->ant;
        recorrico->ant = nuevo;
    }
    else{
        recorrico = recorrico->ant;
        while(recorrico->sig->valor != this->finalPalabra){
            recorrico = recorrico->sig;
        }
        nuevo->sig = recorrico->sig->sig;
        aBorrar = recorrico->sig;
        recorrico->sig = nuevo;
    }
    delete aBorrar;
    
}

template <class T, class F>
void Tried<T, F>::remover(const T* lis, unsigned int tam) {
    assert(estaDefinido(lis, tam));
    Nodo *recorrico = this->prim, *aux, *aBorrar, *aBorrarL[tam];
    bool estaLetra = false;
    unsigned int i = 0;
    while(tam > i){
        if(recorrico->ant->valor == lis[i]){
            estaLetra = true;
            aBorrarL[i] = recorrico;
        }
        recorrico = recorrico->ant;
        while(!estaLetra){
            if(recorrico->sig->valor == lis[i]){
                estaLetra = true;
                aBorrarL[i] = recorrico;
                recorrico = recorrico->sig;
            }
            else{
                recorrico = recorrico->sig;
            }
        }
        estaLetra = false;
        i++;
    }
    i = tam;
    aBorrar = aBorrarL[i-1]->ant;
    if(aBorrar->ant->valor == this->finalPalabra){
        aux= aBorrar->ant;
        aBorrar->ant = aBorrar->ant->sig;
        aBorrar = aux;
    }
    else{
        aBorrar = aBorrar->ant;
        while(aBorrar->valor != this->finalPalabra){
            aux = aBorrar;
            aBorrar = aBorrar->sig;
        }
        aux->sig = aux->sig->sig;
    }
    delete aBorrar;
    bool noBorrarMas = false, noHuboSig = false;
    while(i>0 && !noBorrarMas){
        if(aBorrarL[i-1]->sig != NULL){
            if(aBorrarL[i-1]->sig->valor == lis[i-1]){
                aBorrar = aBorrarL[i-1]->sig;
                aBorrarL[i-1]->sig = aBorrarL[i-1]->sig->sig;   
                delete aBorrar; 
                noHuboSig = true;
            }
        }
        if(!noHuboSig){
            if(aBorrarL[i-1]->ant->ant != NULL){
                if(aBorrarL[i-1]->ant->ant->sig != NULL){
                    noBorrarMas = true;

                }
            }
            if(!noBorrarMas){
                aBorrar = aBorrarL[i-1]->ant;
                aBorrarL[i-1]->ant = aBorrarL[i-1]->ant->sig;   
                delete aBorrar; 
            } 
        }
    
        i--;
        noHuboSig = false;
    }
    this->cant--;
}

template <class T, class F>
F Tried<T, F>::obtener(const T* lis, unsigned int tam) const{
    assert(estaDefinido(lis, tam));
    Nodo *recorrico = this->prim->ant;
    bool estaLetra = false;
    unsigned int i=0;
    while(tam>i){
        while(!estaLetra){
            if(recorrico->valor == lis[i]){
                estaLetra = true;
            }
            else{
                recorrico = recorrico->sig;
            }
        }
        recorrico = recorrico->ant;
        estaLetra = false;
        i++;
    }
    while(recorrico != NULL){
        if(recorrico->valor == this->finalPalabra){
            return recorrico->definicion;
        }
        else{
            recorrico = recorrico->sig;
        }
    }
}

template <class T, class F>
unsigned int Tried<T, F>::cantidad() const {
    return this->cant;
}

template <class T, class F>
void Tried<T, F>::mostrar(std::ostream&) const {
        
}


#endif // TRIED_HPP_
