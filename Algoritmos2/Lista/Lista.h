#ifndef LISTA_H_
#define LISTA_H_

#include <string>
#include <ostream>

typedef unsigned long Nat;

template <typename T>
class Lista
{
	public:

		/**
		 * Constructor por defecto.
		 * Crea una lista enlazada vacía. ( Operación Vacia() )
		 */
		Lista();

		/**
		 * Constructor por copia.
		 * Crea, por copia, una lista enlazada. (operación Copiar())
		 */
		Lista(const Lista& otra);

		/**
		 * Destructor.
		 * Destruye la lista, incluyendo los elementos 'T' alojados.
		 */
		~Lista();

		/**
		 * Operacion de asignacion.
		 * Recrea a la lista como una copia de la pasada como parámetro.
		 */
		Lista<T>& operator=(const Lista<T>& otra);

		//observadores

		/**
		 * Devuelve la cantidad de elementos almacenados en la lista.
		 */
		Nat longitud() const;

		/**
		 * Devuelve el i-esimo elemento (versión modificable)
		 */
		T& iesimo(Nat i);

		/**
		 * Devuelve el i-esimo elemento (versión no modificable)
		 */
		const T& iesimo(Nat i) const;

		/**
		 * Operacion de comparacion.
		 * Retorna verdadero si la lista es igual a otra pasada como
		 * parámetro, falso en caso contrario.
		 */
		bool operator==(const Lista<T>& otra) const;

		// algunas operaciones de lista

		/**
		 * Agrega un nuevo elemento como primer elemento de la lista.
		 */
		void agAdelante(const T& elem);

		/**
		 * Agrega un nuevo elemento como último elemento de la lista.
		 */
		void agAtras(const T& elem);

		/**
		 * Elimina al i-ésimo elemento de la lista.
		 */
		void eliminar(Nat i);

		/**
		 * Muestra la lista en un ostream
		 * formato de salida: [a_0, a_1, a_2, ...], donde a_i es
		 * el resultado del "mostrar" el elemento i de la lista
		 */
		void mostrar(std::ostream& o) const;

		template <typename S>
		friend std::ostream& operator<<(std::ostream& os, const Lista<S> &l);

	private:

		struct Nodo {
			T dato;
			Nodo* sig;
		};

		Nat len;
		Nodo* prim;
		Nodo* fin;
};

template <typename T>
Lista<T>::Lista()
	: len(0), prim(NULL), fin(NULL) {
}

template <typename T>
Lista<T>::Lista(const Lista& otra) {
	this->len==otra.len;
	if(otra.len==0){
		this->prim=NULL;
		this->fin=NULL;
	}
	else if(otra.len==1){
		this->prim=otra.prim;
		this->fin=otra.fin;
	}
	else{
		Nodo *recorridoO=otra.prim,*recorrido,*nuevo;
		for(unsigned int i=1;i<=this->len;i++){
			nuevo=new Nodo;
			nuevo->dato=recorridoO.dato;
			nuevo->sig=NULL;
			if(i==1){
				this->prim=nuevo;
				recorrido=this->prim;
				recorridoO=recorridoO->sig;
			}
			else{
				recorrido->sig=nuevo;
				recorrido=recorrido->sig;
				recorridoO=recorridoO->sig;
			}
		}
		this->fin=recorrido;

	}
}

template <typename T>
Lista<T>::~Lista() {
	Nodo *recorrido=this->prim, *borrar;
	for(unsigned int i=1;i<=this->len;i++){
		borrar=recorrido;
		if(i!=this->len){
			recorrido=recorrido->sig;
		}
		delete borrar;
	}
}

template <typename T>
Lista<T>& Lista<T>::operator=(const Lista<T>& otra) {
	if(this->len==otra.len){
		bool iguales=true;
		Nodo *recorrido=this->prim,recorridoO=otra->prim;
		for(unsigned int i=1;i<=otra.len;i++){
			iguales=iguales &&(recorrido->dato==recorridoO->dato);
			recorridoO=recorridoO->sig;
			recorrido=recorrido->sig;
		}
		if(iguales==true) return *this;
	}
	else{
		Nodo *recorrido=this->prim,*borrar;		
		for(unsigned int i=1;i<=this->len;i++){
			borrar=recorrido;
			if(i!=this->len){
				recorrido=recorrido->sig;
			}
			delete borrar;
		}
		this->prim=NULL;
		this->fin=NULL;
		Nodo *nuevo, *recorridoO=otra.prim;

		for(unsigned int i=1;i<=this->len;i++){
			nuevo=new Nodo;
			nuevo->dato=recorridoO.dato;
			nuevo->sig=NULL;
			if(i==1){
				this->prim=nuevo;
				recorrido=this->prim;
				recorridoO=recorridoO->sig;
			}
			else{
				recorrido->sig=nuevo;
				recorrido=recorrido->sig;
				recorridoO=recorridoO->sig;
			}
		}
		this->fin=recorrido;

	}
}

template <typename T>
Nat Lista<T>::longitud() const {
	return len;
}

template <typename T>
T& Lista<T>::iesimo(Nat i) {
	if(i==1){
		if(this->fin==NULL){
			return this->prim->dato;
		}
		else{
			return this->fin->dato;
		}
	}
	else if(i==this->len){
		return this->fin->dato;
	}
	else{
		Nodo *recorrido=this->prim;
		for(unsigned int s=1;s<=this->len;s++){
			if(s==i){
				return recorrido->dato;
			}
			recorrido=recorrido->sig;
		}
	}
}

template <typename T>
const T& Lista<T>::iesimo(Nat i) const {
	if(i==1){
		return this->prim->dato;
	}
	else if(i==this->len){
		return this->fin->dato;
	}
	else{
		Nodo *recorrido=this->prim;
		for(unsigned int s=1;s<=this->len;s++){
			if(s==i){
				return recorrido->dato;
			}
			recorrido=recorrido->sig;
		}
	}
}

template <typename T>
bool Lista<T>::operator==(const Lista<T>& otra) const {
	if(this->len==otra.len){
		Nodo *recorrido1=this->prim,*recorrido2=otra.prim;
		for(unsigned int s=1;s<=this->len;s++){
			if(recorrido1->dato!=recorrido2->dato){
				return false;
			}
			recorrido1=recorrido1->sig;
			recorrido2=recorrido2->sig;
		}
		return true;
	}
	return false;
}

template <typename T>
void Lista<T>::agAdelante(const T& elem) {
	Nodo *nuevo=new Nodo;
	nuevo->dato=elem;
	nuevo->sig=NULL;
	if(this->prim!=NULL){
		nuevo->sig=this->prim;
	}
	this->prim=nuevo;
}

template <typename T>
void Lista<T>::agAtras(const T& elem) {
	if(this->len==0){
		this->agAdelante(elem);
	}
	else{
		Nodo *nuevo=new Nodo;
		nuevo->dato=elem;
		nuevo->sig=NULL;
		if(this->fin!=NULL){
			this->fin->sig=nuevo;
		}
		this->fin=nuevo;
	}
}

template <typename T>
void Lista<T>::eliminar(Nat i) {
	if(this->len==1){
		delete this->prim;
		this->prim=NULL;
	}
	else{
		Nodo *recorrido=this->prim;
		if(i==1){
			this->prim=this->prim->sig;
			delete recorrido;
		}
		else{
			for(unsigned int s=2;s<=this->len;s++){
				if(i==s){
					if(s!=this->len){
						recorrido->sig=recorrido->sig->sig;
						delete recorrido->sig;
					}
					else{
						this->fin=recorrido;
						delete recorrido->sig;
					}	
				}
				else{
					recorrido=recorrido->sig;
				}
			}
		}
		
	}
	this->len-=1;
}

template <typename T>
void Lista<T>::mostrar(std::ostream& o) const {
	/**
	 * COMPLETAR!!!
	 */
}

template <typename T>
std::ostream& std::operator<<(ostream& os, const Lista<T> &l) {
	l.mostrar(os);
	return os;
}

#endif // LISTA_H_
