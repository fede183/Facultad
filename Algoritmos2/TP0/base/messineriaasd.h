#ifndef MESSINERIA_H_
#define MESSINERIA_H_

#include <iostream>
#include <cassert>
using namespace std;

/*
 * Se puede asumir que el tipo T tiene constructor por copia y operator==
 * No se puede asumir que el tipo T tenga operator=
 */
template<typename T>
class Messineria {

  public:

	/*
	 * Crea una secta nueva sin adeptos.
	 */
	Messineria();

	/*
	 * Una vez copiada, ambas Messinerias deben ser independientes,
	 * es decir, cuando se borre una no debe borrar la otra.
	 */
	Messineria(const Messineria<T>&);

	/*
	 * Acordarse de liberar toda la memoria!
	 */
	~Messineria();

	/*
	 * Agrega un nuevo adepto a la Messineria. Si ya tenemos al Elegido
	 * el nuevo adepto deberá arrodillarse a la izquierda de él. En caso
	 * contrario, se arrodillará a la izquierda del que está alabando.
	 */
	void golDeMessi(const T&);

	/*
	 * Elimina de la secta al adepto pasado por parámetro. Si el mismo tenía
	 * el turno de alabar, debe pasar al siguiente (en caso de que haya).
	 */
	void golDeCristiano(const T&);

	/*
	 * Devuelve el adepto que está albando.
	 *
	 * PRE: Hay adeptos en la Messineria.
	 */
	const T& adeptoAlabando() const;

    /*
	 * Devuelve el próximo elemento según el orden dado.
	 * Quien alaba debe cambiar. Con lo cual sucesivas llamadas a esta función
	 * retornan distintos valores.
	 *
	 * PRE: Hay adeptos en la Messineria.
	 */
	const T& alabarMessi();

	/*
	 * Cambia el turno de alabar al inmediato anterior.
	 *
	 */
	void olvideAlabarloUnPocoMas();

	/*
	 * Selecciona al adepto que está alabando como el Elegido.
	 *
	 * PRE: Hay adeptos en la Messineria y no hay Elegido.
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
	 * PRE: Hay Elegido en la Messineria.
	 */
	const T& dameElegido() const;

	/*
	 * Dice si la Messineria tiene o no adeptos.
	 */
	bool esVacia() const;

	/*
	 * Devuelve la cantidad de adeptos a la Messineria.
	 */
	int tamanio() const;

	/*
	 * Devuelve true si las Messinerias son iguales.
	 */
	bool operator==(const Messineria<T>&) const;

	/*
	 * Debe mostrar la ronda por el ostream (y retornar el mismo).
	 * Messineria vacio: []
	 * Messineria con 2 elementos (e1 es el actual): [e1, e2]
	 * Messineria con 2 elementos (e2 es el actual y e1 es el Elegido): [e2, e1*]
	 * Messineria con 3 elementos (e3 es el actual, e2 fue agregado antes que e3,
	 * e1 fue agregado antes que e2): [e3, e2, e1]
	 */
	ostream& mostrarMessineria(ostream&) const;


  private:
	/*
	 * No se puede modificar esta funcion.
	 */
	Messineria<T>& operator=(const Messineria<T>& otra) {
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

	Nodo* alabando;
	T *elegido;
	int len;


};

template<class T>
ostream& operator<<(ostream& out, const Messineria<T>& a) {
	return a.mostrarMessineria(out);
}

// Implementación a hacer por los alumnos.
	template<typename T>
	Messineria<T>::Messineria(): len(0), elegido(NULL), alabando(NULL){

	}

template<typename T>
	Messineria<T>::Messineria(const Messineria<T>& c){
		if(c.len==0){
			this->len=0;
			this->elegido=NULL;
			this->alabando=NULL;
		}
		
		else{
            this->len=c.len;
            this->elegido = NULL;
            Nodo *nuevo, *recoC, *reco;
            recoC = c.alabando;
            for(unsigned int i=0;i<c.len;i++){
                nuevo = new Nodo;
                if(i==0){
                    nuevo->adepto = c.alabando->adepto;
                    this->alabando = nuevo;
                    this->alabando->ant = NULL;
                    this->alabando->sig = NULL;
                    if(c.alabando->adepto == *(c.elegido))
                        this->elegido = &(this->alabando->adepto);
                    recoC = c.alabando->sig;
                    reco = this->alabando;
                }
               	nuevo->adepto = recoC->adepto;
                nuevo->ant = reco;
               	nuevo->sig = this->alabando;
               	reco->sig = nuevo;
                this->alabando->ant = nuevo;
               	if(recoC->adepto == *(c.elegido))
                    this->elegido = &(reco->adepto);
               	reco = reco->sig;
               	recoC = recoC->sig;
                
            }
		}
	}

	template<typename T>
	Messineria<T>::~Messineria(){
	    Nodo *d=this->alabando,*e;
		for(unsigned int i=1;i<this->len;i++){
			e=d;
			d=d->sig;
			delete e;
		}

		delete this->elegido;
		this->len=0;

	}

	template<typename T>
	void Messineria<T>::golDeMessi(const T& c){
		Nodo nuevo;
		nuevo.adepto=c;
		if(this->elegido==NULL){
			nuevo.sig=this->alabando;
			nuevo.ant=this->alabando->ant;
			this->alabando->ant->sig=&nuevo;
			this->alabando->ant=&nuevo;
		}
		else{
			Nodo *recorrido=alabando;
			for(unsigned int i=1;i<=this->len;i++){
				if(*(this->elegido)==recorrido->adepto){
					nuevo.sig=recorrido;
					nuevo.ant=recorrido->ant;
					recorrido->ant->sig=&nuevo;
					recorrido->ant=&nuevo;
				}
			}
		}
		this->len+=1;

	}

	template<typename T>
	void Messineria<T>::golDeCristiano(const T& c){
		Nodo* d=alabando;
		for(unsigned int i=1;i<=this->len;i++){
			if(d->adepto==c){
				d->ant->sig=d->sig->ant;
				delete d;
				i=this->len;
			}
			else{
				d=d->sig;
			}
		}
		this->len-=1;
	}

	template<typename T>
	const T& Messineria<T>::adeptoAlabando() const{
		return this->alabando->adepto;
	}

    template<typename T>
	const T& Messineria<T>::alabarMessi(){
		this->alabando=this->alabando->sig;
		return this->alabando->adepto;
	}

	template<typename T>
	void Messineria<T>::olvideAlabarloUnPocoMas(){
		this->alabando=this->alabando->ant;

	}

	template<typename T>
	void Messineria<T>::escogerElegido(){
		this->elegido=&(this->alabando->adepto);
	}

    template<typename T>
	bool Messineria<T>::hayElegido() const{
		if(this->elegido==NULL){
			return false;
		}
		return true;
	}

	template<typename T>
	void Messineria<T>::traidor(){
		Nodo *recorrido=alabando;
		for(unsigned int i=1;i<=this->len;i++){
			if(recorrido->adepto==*(this->elegido)){
				recorrido->ant->sig=recorrido->sig;
				recorrido->sig->ant=recorrido->ant;
				delete recorrido;
				i=(this->len)+1;
			}
			else{
				recorrido=recorrido->sig;
			}
		}
		this->len-=1;
		this->elegido=NULL;
	}

	template<typename T>
	void Messineria<T>::interrumpirTurno(){
		Nodo *recorrido=this->alabando;
		for(unsigned int i=1;i<=this->len;i++){
			if(recorrido->adepto==*(this->elegido)){
				recorrido->sig->ant=recorrido->ant;
				recorrido->ant->sig=recorrido->sig;
				this->alabando->ant=alabando;
				this->alabando->adepto=*(this->elegido);
				delete recorrido;
			}
			else{
				recorrido=recorrido->sig;
			}
		}

	}
	template<typename T>
	const T& Messineria<T>::dameElegido() const{
		return *(this->elegido);

	}
	template<typename T>
	bool Messineria<T>::esVacia() const{
		if(this->len==0){
			return true;
		}
		return false;

	}

	template<typename T>
	int Messineria<T>::tamanio() const{
		return this->len;
	}

	template<typename T>
	bool Messineria<T>::operator==(const Messineria<T>& c) const{
		if(*(this->elegido)==*(c.elegido) && this->len==c.len){
			Nodo *recorrido1=this->alabando;
			Nodo *recorrido2=c;
			for(unsigned int i=1;i<=this->len;i++){
				if(recorrido1->adepto==recorrido2->adepto){
					recorrido1=recorrido1->sig;
					recorrido2=recorrido2->sig;
				}
				else{
					return false;
				}
			}
		}
		return true;

	}

	template<typename T>
	ostream& Messineria<T>::mostrarMessineria(ostream& os) const{
		if(len==0){
			os<<"[]";
		}
		else if(this->elegido==NULL){
			os<<"["<<(this->alabando->adepto)<<", ";
			Nodo *recorrido = this->alabando->sig;
			for(unsigned int i=1;i<=this->len-1;i++){
				os<<recorrido->adepto<<", ";
				recorrido=recorrido->sig;

			}
			os<<recorrido->adepto<<" ]";

		}
		else{
			os<<"["<<this->alabando->adepto<<", ";
			Nodo *recorrido = this->alabando->sig;
			for(unsigned int i=1;i<=this->len-1;i++){
				if(recorrido->adepto==*(this->elegido)){
					os<<recorrido->adepto<<"*, ";
					recorrido=recorrido->sig;
				}
				else{
					os<<recorrido->adepto<<", ";
					recorrido=recorrido->sig;
				}
			}
			os<<recorrido->adepto<<" ]";

		}
	}


#endif //MESSINERIA_H_
