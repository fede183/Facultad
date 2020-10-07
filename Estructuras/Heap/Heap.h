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

		// Devuelve el elemento de mayor prioridad.
		T proximo();

		// Encolar un elemento en el cola de prioridad. 
		void encolar(T&);

		// Quita el elemento proximo de la cola de prioridad.
		void desencolar();

		// devuelve la cantidad de elementos que tiene el conjunto.
		unsigned int cantidad() const;

		//Devuelve true si y solo si el heap no posee elementos.
		bool vacia() const;

		// muestra el conjunto.
		void mostrar(std::ostream &) const;

	private:
		
		unsigned int cantidadElementos;
		T* raiz;
        Heap* izq;
        Heap* der;
};

template <class T>
Heap<T>::Heap() :  cantidadElementos(0), raiz(NULL), izq(NULL), der(NULL)
{}

template <class T>
Heap<T>::~Heap(){ 
	if(raiz != NULL){
		//delete raiz;
		if(izq != NULL){
			delete izq;
		}
		if(der != NULL){
			delete der;
		}
	}
}


template <class T>
T Heap<T>::proximo(){
	return *(this->raiz);
}


template <class T>
void Heap<T>::encolar(T& p){
		T *aPoner = &p; 		
		if(raiz == NULL){				
			raiz = aPoner; 			
		  	cantidadElementos = 1; 	
		}	
		else{ 			
			Heap<T> *recorrido = this; 		
			bool llegoAPosicion = false; 		
			while(!llegoAPosicion){ 		
				recorrido->cantidadElementos = recorrido->cantidadElementos + 1; 			
			    if(recorrido->izq == NULL){ 					
			      	llegoAPosicion = true;			     			
			     	if(recorrido->raiz->prioridad > aPoner->prioridad){        
					 	T *aux = recorrido->raiz; 			
					 	Heap<T> *nuevoHeap = new Heap;
					 	nuevoHeap->cantidadElementos = 1;
					 	nuevoHeap->raiz = aux;   			//nuevoHeap = <aux,NULL,NULL,1> 		
					 	recorrido->izq = nuevoHeap; 		
					 	recorrido->raiz = aPoner; 		
			      	}
			      	else{	   					
				 		Heap<T> *nuevoHeap = new Heap;
				 		nuevoHeap->cantidadElementos = 1;
					 	nuevoHeap->raiz = aPoner;   			//nuevoHeap = <aPoner,NULL,NULL,1>
				 		recorrido->izq = nuevoHeap; 		
			      	}
			    }
			    else if(recorrido->der == NULL){ 					
			      	llegoAPosicion = true;			     					
			      	if(recorrido->raiz->prioridad > aPoner->prioridad){ 		
				 		T* aux1 = recorrido->raiz; 				
				 		T* aux2 = recorrido->izq->raiz; 

				 		Heap* nuevoHeap1 = new Heap;
				 		nuevoHeap1->raiz = aux1;
				 		nuevoHeap1->cantidadElementos = 1;     //nuevoHeap1 = <aux1,NULL,NULL,1>

				 		Heap* nuevoHeap2 = new Heap;
				 		nuevoHeap1->raiz = aux2;
				 		nuevoHeap1->cantidadElementos = 1;     //nuevoHeap2 = <aux2,NULL,NULL,1> 

				 		recorrido->izq = nuevoHeap1; 			
				 		recorrido->der = nuevoHeap2;			
				 		recorrido->raiz = aPoner; 			
				 	}
			      	else{
				 		Heap<T> *nuevoHeap = new Heap;
				 		nuevoHeap->cantidadElementos = 1;
					 	nuevoHeap->raiz = aPoner;   			//nuevoHeap = <aPoner,NULL,NULL,1>		
				 		recorrido->der = nuevoHeap;			
			      	}
			    }
			    else{
			      	bool nivelCompleto = (2 * recorrido->der->cantidadElementos) + 1 >= recorrido->izq->cantidadElementos;
			      	if(recorrido->raiz->prioridad > aPoner->prioridad){
						T *aux1  = recorrido->raiz;
						T *aux2  = recorrido->izq->raiz;
						T *aux3  = recorrido->der->raiz;
						recorrido->raiz = aPoner;
						recorrido->izq->raiz = aux1;
						recorrido->der->raiz = aux2;
						aPoner = aux3;
			      	}
			      	if(nivelCompleto){ 		
				  		recorrido = recorrido->izq;
				  	}
			      	else{				
				  		recorrido = recorrido->der;
			      	}
			    }     	
			}
		}
}

template <class T>
void Heap<T>::desencolar(){
	if(this->izq == NULL){ 					 
		this->raiz = NULL; 				 
		this->cantidadElementos = 0;
	}			 
	else{ 				 
		Heap<T> *recorrido = this; 		
		Heap<T> *Aux;			 
		bool final = false; 					 
		while(!final){ 		//Busco la hoja que pretendo poner en la raiz.				
			if(recorrido->izq == NULL){ 				 
				final = true;
				recorrido->cantidadElementos = recorrido->cantidadElementos - 1; 
			} 				 
			else if(recorrido->der == NULL){ 		
				Aux = recorrido;				 
				final = true; 						 
				recorrido->cantidadElementos = recorrido->cantidadElementos - 1; 	 
				recorrido = recorrido->izq; 				 
			}
			else{ 
				Aux = recorrido;		 
				bool nivelCompleto = (recorrido->izq->cantidadElementos - 2*recorrido->der->cantidadElementos) > 0; 	 
				recorrido->cantidadElementos = recorrido->cantidadElementos - 1; 		 
				if(!nivelCompleto){ 						 
					recorrido = recorrido->izq; 
				}			 
				else{ 								 
					recorrido = recorrido->der; 		 
				}
			}
		}
		
			  
		this->raiz = recorrido->raiz; 				 
		//delete recorrido; 			//Borra la hoja a la que llegue.	
		/*if(recorrido->raiz->id == 3){
			std::cout << "ds" << '\n';
		}*/
		if(Aux->izq == recorrido){
			Aux->izq = NULL;	
		}
		else{
			Aux->der = NULL;
		}	 
		
		
		Heap<T> *recorrido2 = this; 						 
		bool llegoAPosicion = false; 					 
			  
		while(!llegoAPosicion){ 			//Posiciono la hoja en el lugar correcto para no romper el invariante.		 
		    if(recorrido2->izq == NULL){ 					 
		        llegoAPosicion = true;
			}			       
		    else if(recorrido2->der == NULL){ 					 
			    llegoAPosicion = true; 				 
				if(recorrido2->izq->raiz->prioridad < recorrido2->raiz->prioridad){ 	 
					T *aux = recorrido2->raiz; 				 
					recorrido2->raiz = recorrido2->izq->raiz; 		 
					recorrido2->izq->raiz  = aux; 			 
				}
			}
			else{   
				if(recorrido2->raiz->prioridad > recorrido2->izq->raiz->prioridad){ 		 
					T *aux = recorrido2->raiz; 				 
					recorrido2->raiz = recorrido2->izq->raiz; 	 
					recorrido2->izq->raiz = aux; 
					if(recorrido2->izq->raiz->prioridad > recorrido2->der->raiz->prioridad){
						T *aux2 = recorrido2->izq->raiz;
						recorrido2->izq->raiz = recorrido2->der->raiz;
						recorrido2->der->raiz = aux2;
					}	 
					recorrido2 = recorrido2->izq;
				}	  
				else if(recorrido2->raiz->prioridad > recorrido2->der->raiz->prioridad){ 	 
					T *aux = recorrido2->raiz; 	 
					recorrido2->raiz = recorrido2->der->raiz; 	  
					recorrido2->der->raiz = aux;  
					recorrido2 = recorrido2->der;
				}  
				else{  
				  	llegoAPosicion = true;  	 
				}
			}
		}
	}	 
}


template <class T>
unsigned int Heap<T>::cantidad() const{
    return this->cantidadElementos;
}

template <class T>
bool Heap<T>::vacia() const{
	return this->raiz == NULL;
}

template <class T>
void Heap<T>::mostrar(std::ostream &o) const{
    o << this->raiz->id<< '\n';
    if(this->izq != NULL){
    	o << "izq:"<< '\n';
    	(*this->izq).mostrar(o);
    }
    if(this->der != NULL){
    	o << "der:"<< '\n';
    	(*this->der).mostrar(o);
    }
}


#endif // HEAP_HPP_
