#ifndef LISTACIRCULAR_H_
#define LISTACIRCULAR_H_

#include <iostream>
#include <cassert>
using namespace std;

/*
 * Se puede asumir que el tipo T tiene constructor por copia y operator==
 * No se puede asumir que el tipo T tenga operator=
 */
template<typename T>
class ListaCircular{

  public:

	/*
	 * Crea una secta nueva sin adeptos.
	 */
	ListaCircular();

	/*
	 * Una vez copiada, ambas Messinerias deben ser independientes,
	 * es decir, cuando se borre una no debe borrar la otra.
	 */
	ListaCircular(const ListaCircular<T>&);

	/*
	 * Acordarse de liberar toda la memoria!
	 */
	~ListaCircular();

	/*
	 * Agrega un nuevo adepto a la ListaCircular Si ya tenemos al Elegido
	 * el nuevo adepto deberá arrodillarse a la izquierda de él. En caso
	 * contrario, se arrodillará a la izquierda del que está alabando.
	 */
	void agregar(const T&);

	/*
	 * Elimina de la secta al adepto pasado por parámetro. Si el mismo tenía
	 * el turno de alabar, debe pasar al siguiente (en caso de que haya).
	 */
	void quitar(const T&);

	/*
	 * Devuelve el adepto que está albando.
	 *
	 * PRE: Hay adeptos en la ListaCircular.
	 */
	const T& principio() const;

    /*
	 * Devuelve el próximo elemento según el orden dado.
	 * Quien alaba debe cambiar. Con lo cual sucesivas llamadas a esta función
	 * retornan distintos valores.
	 *
	 * PRE: Hay adeptos en la ListaCircular.
	 */
	const T& apuntarAlSiguiente();

	/*
	 * Cambia el turno de alabar al inmediato anterior.
	 *
	 */
	void apuntarAlAnterior();

	/*
	 * Selecciona al adepto que está alabando como el Elegido.
	 *
	 * PRE: Hay adeptos en la ListaCircular y no hay Elegido.
	 */
	void escogerElegido();

    /*
	 * Indica si esta presente el Elegido entre los adeptos.
	 */
	bool hayElegido() const;

	/*
	* Elimina de la secta al Elegido.
	*
	* PRE: hay Elegido en la Messinería.
	*/
	void traidor();

	/*
	* El Elegido interrumpe el tuno y pasa a ser el que está alabando
	*
	* PRE: hay Elegido en la Messinería.
	*/
	void interrumpirTurno();

	/*
	 * Devuelve al Elegido.
	 *
	 * PRE: Hay Elegido en la ListaCircular.
	 */
	const T& dameElegido() const;

	/*
	 * Dice si la ListaCircular tiene o no adeptos.
	 */
	bool esVacia() const;

	/*
	 * Devuelve la cantidad de adeptos a la ListaCircular.
	 */
	int tamanio() const;

	/*
	 * Devuelve true si las Messinerias son iguales.
	 */
	bool operator==(const ListaCircular<T>&) const;

	/*
	 * Debe mostrar la ronda por el ostream (y retornar el mismo).
	 * ListaCircular vacio: []
	 * ListaCircular con 2 elementos (e1 es el actual): [e1, e2]
	 * ListaCircularcon 2 elementos (e2 es el actual y e1 es el Elegido): [e2, e1*]
	 * ListaCircular con 3 elementos (e1 es el actual, e2 fue agregado antes que e3,
	 * e1 fue agregado antes que e2): [e1, e2, e3]
	 */
	ostream& mostrarListaCircular(ostream&) const;


  private:
	/*
	 * No se puede modificar esta funcion.
	 */
	ListaCircular<T>& operator=(const ListaCircular<T>& otra) {
		assert(false);
		return *this;
	}

	/*
	 * Aca va la implementación del nodo.
	 */
	struct Nodo {
		T adepto;
		Nodo* sig;
		Nodo* ant;
	};
	Nodo *interrupcion;
	Nodo* alabando;
	Nodo* elegido;
	int len;


};

template<class T>
ostream& operator<<(ostream& out, const ListaCircular<T>& a) {
	return a.mostrarMessineria(out);
}

// Implementación a hacer por los alumnos.
	template<typename T>
	ListaCircular<T>::ListaCircular(): len(0), elegido(NULL), alabando(NULL),interrupcion(NULL){

	}

	template<typename T>
	ListaCircular<T>::ListaCircular(const ListaCircular<T>& c){
		this->elegido=NULL;
		this->alabando=NULL;
		this->interrupcion=NULL;
		if(c.len==0){
			this->len=0;
		}
		else if(c.len==1){
			this->len=1;
			Nodo *nuevo=new Nodo;
			nuevo->adepto=c.alabando->adepto;
			this->alabando=nuevo;
			this->alabando->ant=this->alabando;
			this->alabando->sig=this->alabando;
			if(c.elegido==c.alabando){
				this->elegido=this->alabando;
			}
		}
		else{
			this->len=c.len;
			Nodo *nuevo,*recorrido,*recorridoC=c.alabando;
			for(unsigned int i=1;i<=c.len;i++){
				nuevo=new Nodo;
				if(i==1){
					nuevo->adepto=recorridoC->adepto;
					this->alabando=nuevo;
					this->alabando->sig=NULL;
					this->alabando->ant=NULL; 
					if(c.elegido==recorridoC){
						this->elegido=this->alabando;
					}
					if(c.interrupcion==recorridoC){
						this->interrupcion=this->alabando;
					}
					recorridoC=recorridoC->sig;
					recorrido=this->alabando;
				}
				else{
					nuevo->adepto=recorridoC->adepto;
					nuevo->ant =recorrido;
					nuevo->sig=NULL;   
					recorrido->sig=nuevo;
					if(c.elegido==recorridoC){
						this->elegido=nuevo;
					}
					if(c.interrupcion==recorridoC){
						this->interrupcion=this->alabando;
					}
					recorridoC=recorridoC->sig;
					recorrido=recorrido->sig;
				}
			}
			this->alabando->ant=nuevo;
			nuevo->sig=this->alabando;
		}
	}

	template<typename T>
	ListaCircular<T>::~ListaCircular(){
	    Nodo *d=this->alabando,*e;
		for(unsigned int i=1;i<=this->len;i++){ // No seria menor estricto?
			e=d;
			if(i<this->len){
				d=d->sig;
			}
			delete e;
		}
	}

	template<typename T>
	void ListaCircular<T>::agregar(const T& c){
		Nodo *nuevo=new Nodo();
		nuevo->adepto=c;
		if(this->elegido==NULL){
			if(this->len==0){
				this->alabando=nuevo;
				this->alabando->sig=this->alabando;
				this->alabando->ant=this->alabando;
			}
			else if(this->len==1){
				nuevo->sig=this->alabando;
				nuevo->ant=this->alabando;
				this->alabando->ant=nuevo;
				this->alabando->sig=nuevo;
			}
			else{
				nuevo->sig=this->alabando;
				nuevo->ant=this->alabando->ant;
				this->alabando->ant->sig=nuevo;
				this->alabando->ant=nuevo;
			}
		}
		else{
			nuevo->ant=this->elegido->ant;
			nuevo->sig=this->elegido;
			this->elegido->ant->sig=nuevo;
			this->elegido->ant=nuevo;
		}
		this->len+=1;
	}

	template<typename T>
	void ListaCircular<T>::quitar(const T& c){
		if(this->len==1){
			this->elegido=NULL;
			this->interrupcion=NULL;
			delete this->alabando;
			this->alabando=NULL;
		}
		else if(this->len==2){
			this->interrupcion=NULL;
			if(this->alabando->adepto==c){
				if(this->elegido==this->alabando){
					this->elegido=NULL;
				}
				this->alabando=this->alabando->sig;
				this->alabando->sig=this->alabando;
				delete this->alabando->ant;
				this->alabando->ant=this->alabando;
			}
			else{
				if(this->elegido==this->alabando->sig){
					this->elegido=NULL;
				}
				this->alabando->sig=this->alabando;
				delete this->alabando->ant;
				this->alabando->ant=this->alabando;
			}
		}
		else{
			Nodo *borrar=this->alabando;
			for(unsigned int i=1;i<=this->len;i++){
				if(borrar->adepto==c){
					if(i==1){
						if(this->elegido==borrar){
							if(this->interrupcion!=NULL){
								this->alabando=this->interrupcion;
								this->interrupcion=NULL;
							}
							else{
								this->alabando=borrar->sig;
							}
							this->elegido=NULL;
						}
						else{
							if(borrar==this->interrupcion){
								this->interrupcion=this->interrupcion->sig;
							}
							this->alabando=borrar->sig;
						}
					}
					borrar->ant->sig=borrar->sig;
					borrar->sig->ant=borrar->ant;
					delete borrar;
					i=this->len+1;
				}
				else{
					borrar=borrar->sig;
				}
			}
		}

	this->len-=1;
}

	template<typename T>
	const T& ListaCircular<T>::principio() const{
		assert(this->esVacia()==false);
		return this->alabando->adepto;
	}

    template<typename T>
	const T& ListaCircular<T>::apuntarAlSiguiente(){
		assert(this->esVacia()==false);
		if(this->interrupcion==NULL){
			this->alabando=this->alabando->sig;
		}
		else{
			this->alabando=this->interrupcion;
			this->interrupcion=NULL;
		}
		return this->alabando->adepto;
	}

	template<typename T>
	void ListaCircular<T>::apuntarAlAnterior(){
		assert(this->esVacia()==false);
		if(this->interrupcion==NULL){
			this->alabando=this->alabando->ant;
		}
		else{
			this->alabando=this->interrupcion->ant;
		}
	}

	template<typename T>
	void ListaCircular<T>::escogerElegido(){
		assert(this->hayElegido()==false);
		this->elegido=this->alabando;
	}

    template<typename T>
	bool ListaCircular<T>::hayElegido() const{
		if(this->elegido==NULL){
			return false;
		}
		return true;
	}

	template<typename T>
	void ListaCircular<T>::traidor(){
		assert(this->hayElegido());
		this->golDeCristiano(this->elegido->adepto);
	}

	template<typename T>
	void ListaCircular<T>::interrumpirTurno(){
		assert(this->hayElegido());
		if(this->elegido!=this->alabando){
			this->interrupcion=this->alabando;
			this->alabando=this->elegido;
		}

	}
	template<typename T>
	const T& ListaCircular<T>::dameElegido() const{
		assert(this->hayElegido());
		return this->elegido->adepto;

	}
	template<typename T>
	bool ListaCircular<T>::esVacia() const{
		if(this->len==0){
			return true;
		}
		return false;

	}

	template<typename T>
	int ListaCircular<T>::tamanio() const{
		return this->len;
	}

	template<typename T>
	bool ListaCircular<T>::operator==(const ListaCircular<T>& c) const{
		if(this->len==0 && c.len==0){
			return true;
		}
		else{
			if(this->len == c.len){
				Nodo *recorrido1=this->alabando;
				Nodo *recorrido2=c.alabando;
				for(unsigned int i=1;i<=this->len;i++){
					if(recorrido1->adepto==recorrido2->adepto){
						if(recorrido1==this->interrupcion && c.interrupcion!=recorrido2){
							return false;
						}
						else if(recorrido1!=this->interrupcion && c.interrupcion==recorrido2){
							return false;
						}
						if(recorrido1==this->elegido && c.elegido!=recorrido2){
							return false;
						}
						else if(recorrido1!=this->elegido && c.elegido==recorrido2){
							return false;
						}

						recorrido1=recorrido1->sig;
						recorrido2=recorrido2->sig;
					}
					else{
						return false;
					}
				}
			}
		}

		return true;

	}

	template<typename T>
	ostream& ListaCircular<T>::mostrarListaCircular(ostream& os) const{
		if(len==0){
			os<<"[]";
		}
		else{
			os<<"[";
			Nodo *recorrido = this->alabando;
			for(unsigned int i=1;i<this->len;i++){
				if(recorrido==this->elegido){
					os<<recorrido->adepto<<"*, ";
				}
				else{
					os<<recorrido->adepto<<", ";
				}
				recorrido=recorrido->sig;
			}
			os<<recorrido->adepto;
			if(recorrido==this->elegido) os<<"*]";
			else os<<"]";
		}
	}


#endif //LISTACIRCULAR_H_
