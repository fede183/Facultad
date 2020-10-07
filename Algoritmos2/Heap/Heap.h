#ifndef HEAP_HPP_
#define HEAP_HPP_

#include <assert.h>
#include <iostream>
#include <cassert>

using namespace std;

template <class T>
class Heap
{
	public:

		// Constructor. Genera un conjunto vacío.
		Heap();

		// Destructor. Debe dejar limpia la memoria.
		~Heap();

		// Inserta un elemento en el conjunto. Si éste ya existe,
		// el conjunto no se modifica.
		T proximo();

		void encolar(const T&);

		// borra un elemento del conjunto. Si éste no existe,
		// el conjunto no se modifica.
		void desencolar();

		// devuelve la cantidad de elementos que tiene el conjunto.
		unsigned int cantidad() const;

		// muestra el conjunto.
		void mostrar(std::ostream &) const;

	private:
		
		unsigned int cant;
        T *prim;
};

template <class T>
Heap<T>::Heap() : prim(NULL), cant(0)
{}

template <class T>
Heap<T>::~Heap(){ 
	delete this->prim;
}


template <class T>
T Heap<T>::proximo(){
	return this->prim[0];
}
template <class T>
void Heap<T>::encolar(const T& prio){
	unsigned int d=0, i = this->cant;
	T prob[this->cant], prob2;
	while(d<this->cant){
		prob[d]=this->prim[d];
		d++;
	}
	prob[this->cant] = prio;
	d=0;
	this->prim =new T(this->cant);
	while(d<this->cant+1){
		this->prim[d]=prob[d];
		d++;
	}
   	bool llegueP = false;
   	while(!llegueP && i>0){
   		if(i % 2 != 0){
   			if(this->prim[((i-1)/2)] < this->prim[i]){
   				prob2 = this->prim[((i-1)/2)];
	   			this->prim[((i-1)/2)] = this->prim[i];
	   			this->prim[i] = prob2;
	   			i= (i-1)/2;
   			}
   			else{
   				llegueP = true;
   			}	
   		}
   		else if(this->prim[((i-2)/2)] < this->prim[i]){
   			prob2 = this->prim[((i-2)/2)];
   			this->prim[((i-2)/2)] = this->prim[i];
   			this->prim[i] = prob2;
   			i= (i-2)/2;
   		}
   		else{
   			llegueP = true;
   		}
   	}
   	
   	this->cant++;
}

template <class T>
void Heap<T>::desencolar() {
	if(this->cant==1){
		delete this->prim;
		this->prim=NULL;
		this->cant--;
	}
	else{
	    unsigned int d=1, i = 0;
		T prob[this->cant-1], prob2;
		prob[0] = this->prim[this->cant-1];
		while(d<this->cant-1){
			prob[d]=this->prim[d];
			d++;
		}
		this->prim = new T(this->cant-1);
		d=0;
		while(d<this->cant){
			this->prim[d]=prob[d];
			d++;
		}
		this->cant--;
	   	while(i < this->cant-1){
	   		if(this->cant >= (2*i)+2){
	   			if(this->prim[(2*i)+2]<this->prim[(2*i)+1] && this->prim[(2*i)+1]>this->prim[i]){
					prob2=this->prim[i];
					this->prim[i]=this->prim[(2*i)+1];
					this->prim[(2*i)+1]=prob2;
					i=(2*i)+1;
	   			}
	   			else if(this->prim[(2*i)+2]>this->prim[(2*i)+1] && this->prim[(2*i)+2]>this->prim[i]){
					prob2=this->prim[i];
					this->prim[i]=this->prim[(2*i)+2];
					this->prim[(2*i)+2]=prob2;
					i=(2*i)+2;
	   			}
	   			else{
	   				i=this->cant;
	   			}
	   		}
	   		else if(this->cant >= i+1){
	   			if(this->prim[(2*i)+1]>this->prim[i]){
	   				prob2=this->prim[i];
					this->prim[i]=this->prim[(2*i)+1];
					this->prim[(2*i)+1]=prob2;
					i=(2*i)+1;
	   			}
	   			else{
	   				i=this->cant;
	   			}
	   		}
	   		else{
	   			i=this->cant;
	   		}
	   	}
	   	
	}
   	

}


template <class T>
unsigned int Heap<T>::cantidad() const {
    return this->cant;
}

template <class T>
void Heap<T>::mostrar(std::ostream &o) const {
    assert(false);
}


#endif // HEAP_HPP_
