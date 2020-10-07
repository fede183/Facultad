#ifndef CORREPOCOYO_H_
#define CORREPOCOYO_H_

#include <iostream>
#include <cassert>
using namespace std;

/* 
 * Se puede asumir que el tipo T tiene constructor por copia y operator==
 * No se puede asumir que el tipo T tenga operator=
 */
template<typename T>
class CorrePocoyo{

  public:

	/*
	 * Crea una nueva carrera
	 */	
	CorrePocoyo();

	/*
	 * Una vez copiada, ambas CorrePocoyos deben ser independientes, 
	 * es decir, cuando se borre una no debe borrar la otra.
	 */	
	CorrePocoyo(const CorrePocoyo<T>&);
	
	/*
	 * Acordarse de liberar toda la memoria!
	 */	 
	~CorrePocoyo();

	/*
	 * Agrega un nuevo corredor al CorrePocoyo. Lo agregar√° al final 
	 */
	void nuevoCorredor(const T&);
	
	/*
	 * Agrega un nuevo corredor al CorrePocoyo. El primer T es el corredor a agregar y lo hace delante del segundo
	 *
	 * PRE: Existe el segundo corredor 
	 */
	void nuevoCorredor(const T&, const T&);
	
	/*
	 * Elimina del pocoyo al que se env√≠a
	 *
	 * PRE: Existe el corredor
	 */
	void seCansa(const T&);
	/*
	 * El corredor pasa al que est√° adelante 
	 *
	 * PRE: Existe un corredor delante de √©l y T es un corredor 
	 */
	void sobrepasar(const T&);
	
	/*
	 * Devuelve el corredor que est√° siendo filmado.
	 *
	 * PRE: Hay adeptos en la CorrePocoyo.
	 */
	const T& corredorFilmado() const;
	
    /*
	 * Devuelve el pr√≥ximo elemento seg√∫n el orden dado.
	 * Pasa a filmar al corredor de at√°s 
	 *
	 * PRE: Hay corredore en la CorrePocoyo.
	 */
	void filmarProxPerdedor();
	    /*
	 * Devuelve el pr√≥ximo elemento seg√∫n el orden dado.
	 * Pasa a filmar al corredor de adelante 
	 *
	 * PRE: Hay corredore en la CorrePocoyo.
	 */
	void filmarProxExitoso();
	
	/*
	 * Devuelve al Primero. 
	 *
	 * PRE: Hay elementos 
	 */
	const T& damePrimero() const;	

	/*
	 * Devuelve la posici√≥n del elemento pasado por par√°metro. 
	 *
	 * PRE: Existe ese corredor 
	 */
	int damePosicion(const T& ) const;	

	/*
	 * Devuelve el corredor de la posici√≥n. 
	 *
	 * PRE: Existe al menos esa cantidad de corredores en la carrera
	 */
	const T& dameCorredorEnPos(int) const;	




	/*
	 * Dice si la CorrePocoyo tiene o no corredores.
	 */
	bool esVacia() const;

	
	/*
	 * Devuelve la cantidad de corredores de la CorrePocoyo.
	 */
	int tamanio() const;	

	/*
	 * Devuelve true si las CorrePocoyos son iguales.
	 */
	bool operator==(const CorrePocoyo<T>&) const;	
	
	/*
	 * Debe mostrar la carrera por el ostream (y retornar el mismo).
	 * CorrePocoyo vacio: []
	 */
	ostream& mostrarCorrePocoyo(ostream&) const;
	
	
  private:
	/*
	 * No se puede modificar esta funcion.
	 */
	CorrePocoyo<T>& operator=(const CorrePocoyo<T>& otra) {
		assert(false);
		return *this;
	}

	/*
	 * Aca va la implementaci√≥n del nodo.
	 */
	struct Nodo {
		T jugador;
		Nodo* atras;
		Nodo* adelante;
	};
	//La idea es poder encontrar un corredor determinado y ver si est·n en la carrera
	Nodo* getCorredor(const T& c);
	bool existeCorredor(const T& c);
	
	int len;
	Nodo* primero;
	Nodo* camara;

};

template<class T>
ostream& CorrePocoyo::operator<<(ostream& out, const CorrePocoyo<T>& a) {
	return a.mostrarCorrePocoyo(out);
}

template<typename T>
CorrePocoyo::CorrePocoyo() 
	:len(0), primero(NULL), camara(NULL){

}

template<typename T>
CorrePocoyo::CorrePocoyo(const CorrePocoyo<T>& C){
	len = C.len;
	if(len == 0){
		primero = NULL;
		camara = NULL;
	}
	else{
		Nodo* recorrido = C.primero;
		Nodo* resultado = new Nodo;
		resultado->jugador = recorrido->jugador;
		resultado->adelante = NULL;
		primero = resultado;
		if(C.camara == C.primero){
			camara = resultado;
		}

		recorrido = recorrido->atras;
		while(recorrido != NULL){
			Nodo* nuevo = new Nodo;
			nuevo->jugador = recorrido->jugador;
			nuevo->adelante = resultado;
			resultado->atras = nuevo;
			if(C.camara == recorrido){
				camara = nuevo;
			}
			resultado = resultado->atras;
			recorrido = recorrido->atras;
		}
		resultado->atras = NULL;
	}
}
	
template<typename T>
CorrePocoyo::~CorrePocoyo(){
	if(len != 0){
		Nodo* recorrido = this->primero;
		while(recorrido != NULL){
			Nodo* aBorrar = recorrido;
			recorrido = recorrido->atras;
			delete aBorrar;
		}
	}
	delete this;
}

template<typename T>
void CorrePocoyo::nuevoCorredor(const T& jugador){
	this->len ++;
	Nodo* nuevo = new Nodo;
	nuevo->jugador = jugador;

	if(len == 1){
		nuevo->adelante = NULL;
		nuevo->atras = NULL;
		primero = nuevo;
		camara = nuevo;
	}
	else{
		Nodo* recorrido = primero;
		while(recorrido->atras != NULL){
			recorrido = recorrido->atras;
		}
		recorrido->atras = nuevo;
		nuevo->atras = NULL;
		nuevo->adelante = recorrido;
	}

}
	
template<typename T>
void CorrePocoyo::nuevoCorredor(const T& jugador, const T& delante){
	this->len ++;
	Nodo* nuevo = new Nodo;
	nuevo->jugador = jugador;

	if(primero->jugador == delante){
		nuevo->atras = primero;
		primero->adelante = nuevo;
		primero = nuevo;
	}
	else{
		Nodo* recorrido = primero;
		while(recorrido->atras->jugador != delante){
			recorrido = recorrido->atras;
		}
		recorrido->atras->adelante = nuevo;
		nuevo->atras = recorrido;
		nuevo->adelante = recorrido->atras;
		recorrido->atras = nuevo;
	}

}

template<typename T>
typename CorrePocoyo::Nodo* CorrePocoyo::getCorredor(const T& c) {
	// Antes de llamar a esta funcion se verifica que exista el coredor, si no existe devuelvo null

	bool encontre = false;
	int i = 0;
	Nodo* temporal = this->primero; //Ac· no estoy del todo segura de poner this->primero o this.primero

	while (!encontre && i < this->len) {
		if (temporal->jugador == c) {
			encontre = true;
		} else {
			temporal = temporal->adelante;
			i++;
		}
	}

	return i == this->len ? NULL : temporal;
}
template<typename T>
bool CorrePocoyo::existeCorredor(const T& c) {
	return getCorredor(c) != NULL ? true : false;
}	
/*
	 * Elimina del pocoyo al que se env√≠a
	 *
	 * PRE: Existe el corredor
	 */
template<typename T>
void CorrePocoyo::seCansa(const T& c){ //no se si est· bien esto de pedir uno en particular
	assert(existeCorredor(c)); // Hay que hacer una funcion auxiliar para esto y respetar la Pre
	//La pre condicion ya te lo dice. Podes asimilar que el caso no se da ya que no te importa lo que pase
	Nodo* temporal = getCorredor(c); 
	this->len--;
	Nodo* recorrido = primero;
			while((recorrido->adelante)->jugador != c){ //Para recorrer la "carrera" hay que ir para atr·s o adelante?
				recorrido = recorrido->atras;
			}
			recorrido->adelante = temporal->adelante;//No estoy segura de estar asignando bien
			recorrido->atras =temporal->atras; 
}

template<typename T>
void CorrePocoyo::sobrepasar(const T& c){
	assert(existeCorredor(c)&& existeCorredor((getCorredor(c)->adelante)->jugador)) // getCorredor(c)->adelante)->jugador para hablar del nombre del jugador de adelante del dado
	Nodo* C = getCorredor(c); 
	Nodo* aPasar = C->adelante;  
	if(len==2){
		if(aPasar==this->primero ){ //No creo que a la guarda del if haya q agregarle && (this->primero)->anterior==C por como elegimos aPasar
			primero->anterior=aPasar;
			primero=C;
		}	
		
	}else{ // ie:if(len>=2)
	
		Nodo* antC=C->atras; 
		Nodo* adAPasar= aPasar->adelante; //Puede ser null en el caso de que aPasar sea el primero.
		
		C->adelante=adAPasar;
		aPasar->adelante=C;
		C->atras=aPasar;
		aPasar->atras=antC;
		antC->adelante=aPasar;
		adAPasar->atras=C; 
		
	}

	
}

	
template<typename T>
const T& CorrePocoyo::corredorFilmado() const{
	return camara->jugador;
}
	
template<typename T>
void CorrePocoyo::filmarProxPerdedor(){
	if(camara->atras != NULL){
		camara = camara->atras;
	}
}

template<typename T>
void CorrePocoyo::filmarProxExitoso(){
	if(camara->adelante != NULL){
		camara = camara->adelante;
	}
}
	
template<typename T>
const T& CorrePocoyo::damePrimero() const{
	return primero->jugador;
}	

template<typename T>
int CorrePocoyo::damePosicion(const T& c) const{
	int resultado = 1;
	Nodo* recorrido = primero;
	while(recorrido->jugador != c){
		resultado++;
		recorrido=recorrido->atras; //agregado para que siga recorriendo la lista!
	}
	return resultado;
}	

template<typename T>
const T& CorrePocoyo::dameCorredorEnPos(int i) const{ //No tengo idea de lo que querÈs hacer ac·?
	/* Nodo* recorrido = primero; 
	while(i==1){
		
		i--;
	}
	return recorrido->jugador; */
	//No deberÌa ser asÌ
	Nodo* recorrido = primero; 
	int j=1;
	while(j!=i){
		recorrido=recorrido->atras;
		j++;
	}
	return recorrido->jugador;
}	


template<typename T>
bool CorrePocoyo::esVacia() const{
	return len == 0;
}

	
template<typename T>
int CorrePocoyo::tamanio() const{
	return len;
}	

template<typename T>
bool CorrePocoyo::operator==(const CorrePocoyo<T>& c) const{
	bool resultado = false;
	if(c.len == len){
		Nodo* recorrido1 = primero;
		Nodo* recorrido2 = c.primero;

		while(recorrido1 != NULL){
			resultado = resultado && (recorrido1->jugador == recorrido2->jugador);
			recorrido1 = recorrido1->atras;
			recorrido2 = recorrido2->atras;
		}
	}
	return (resultado && camara->jugador == c.camara->jugador);  
}	
	
template<typename T>
ostream& CorrePocoyo::mostrarCorrePocoyo(ostream& os) const{
	os<<'[';
	if(len !=0){
		os<< primero->jugador;
		Nodo* recorrido = primero->atras;
		while(recorrido != NULL){
			os<< ',' <<recorrido->jugador;

			if(camara == recorrido){
				os<< '(camara)';
			}

			recorrido = recorrido->atras;
		}
	}
	os<<']';
}



#endif //CORREPOCOYO_H_
