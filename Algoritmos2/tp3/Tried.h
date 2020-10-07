#ifndef TRIED_HPP_
#define TRIED_HPP_

#include <assert.h>
#include <iostream>
#include <cassert>
#include <math.h>
#include "aed2.h"
using namespace std;

//Agrego el tipo lista del taller, si te parece lo cambiamos.


template <class T,class K>
class Tried 
{
	public:
		// Constructor. Genera el tried vacío
		Tried();
		//Destructor. Debe dejar vacía la memoria.
		~Tried();
		//Definir.Dados una clave y significado los agrega al tried. 
		void Definir(T&, K&);
		//Definido?. 
		bool Def(T&) const;
		//Si Def da true, va a dar el significado del nodoTrie asociado a la clave pasada por referencia.
		K& Significado(T&);
		//Borra la clave y nodoTried asociados a la clave pasada por parámetro
		void Borrar(T&);
		// Da la lista de claves. 
		Conj<T> Claves() const; //no estoy segura si acá va const
		//#Claves
		int cantClaves();
		//debería poner una punción mostrar??
	private:
		class nodoTrie
		{
		//constructor del nodoTried a partir de clave y significado 
			nodoTrie(const T& clave, const bool f, const Lista<nodoTrie> l, const K& signif) : letra(clave), final(f), siguientes(l),significado(signif) {}; //Duda: No sé si esto va a hacer falta y tampoco si final debería ser false o no.
			
			T letra; // no estoy segura si no debería ser  T*
			bool final;
			Lista<nodoTrie> siguientes;
			K* significado;
		};

		Lista<nodoTrie> diccionario;  //deberían ser punteros?
		Conj<T> claves;
};
//Constructor vacío:
template <class T,class K>
Tried<T,K>::Tried(){} //No estoy segura si  es así o  diccionario(NULL), claves(NULL) 
//Desructor:
//FALTA COMPLETAR
template <class T,class K>
Tried<T,K>::~Tried(){

}
//Definir

template <class T,class K>
void Tried<T,K>::Definir(T& clave, K& signif){

	claves.AgregarRapido(clave);
	T kAux = copy(clave);
	typename Lista<nodoTrie>::Iterador recorrido = diccionario.crearIT();
	while(kAux.length() > 0){
		bool encontrado = false;
		while(recorrido.HaySiguiente() && !encontrado){
			if (recorrido.Siguiente() = kAux[0]){
				encontrado = true;
			}
			recorrido.Avanzar();
		}
		if (!encontrado){
			Lista<nodoTrie> nueva;
			K *aAgregar = signif;
			nodoTrie *Aux = nodoTrie(kAux[0], kAux.length() == 1, nueva, aAgregar);
			recorrido.AgregarComoSiguiente(*Aux);
			recorrido = recorrido.Siguiente().siguientes.crearIT();
		}
		else if (encontrado && kAux.length() == 1){
			recorrido.Siguiente().final = true;
			*recorrido.Siguiente().significado = signif;
		}
		else if (encontrado){
			recorrido = recorrido.Siguiente().siguientes.crearIT();
		}
		kAux.erase(0);
	}
}
//Definido?
template <class T,class K>
bool  Tried<T,K>::Def(T& clave) const{
	T kAux = copy(clave);

	typename Lista<nodoTrie>::Iterador recorrido = diccionario.crearIT();
	bool res = false;
	while (kAux.length() > 0 && !res && recorrido.HaySiguiente()){
	
		bool encontrado = false;
		while (recorrido.HaySiguiente() && !encontrado){ 
			if (recorrido.Siguiente().letra == kAux[0]){
				encontrado = true;
			}
			recorrido.Avanzar();
		}
		if (!encontrado){
			res = false;
		}
		else if(encontrado && kAux.length() == 1){
			res = recorrido.Siguiente().final;
		}
		else if (encontrado){
			recorrido = recorrido.Siguiente().siguientes.crearIT();
		}
		kAux.erase(0);
	}
}
//Sigificado.
template<class T, class K>
K& Tried<T,K>::Significado(T& clave){

	#ifdef DEBUG
    assert(Def(clave));
    #endif

	T kAux = copy(clave);
	K *resultado = NULL;
	typename Lista<nodoTrie>::Iterador recorrido = diccionario.crearIT();
	while (kAux.length() > 0){
		bool encontrado = false;
		while (recorrido.HaySiguiente() && !encontrado){ 
			if (recorrido.Siguiente() == kAux[0]){
				encontrado = true;
			}
			recorrido.Avanzar();
		}
		if (encontrado && kAux.length() == 1){
			resultado = recorrido.Siguiente().significado;
		}
		else{
			recorrido = recorrido.Siguiente().siguientes.crearIT();
		}
		kAux.erase(0);

	}
	return *resultado;
}
//Completar
//Borrar
template<class T, class K>
void Tried<T,K>::Borrar(T& clave){

	#ifdef DEBUG
    assert(Def(clave));
    #endif
    
	claves.Eliminar(clave);
	T kAux = copy(clave);
	typename Lista<nodoTrie>::Iterador recorrido = diccionario.crearIT();

	while (kAux.length() > 0){
		bool encontrado  = false;

		while (recorrido.HaySiguiente() && !encontrado){ 
			if (recorrido.Siguiente().letra == kAux[0]){
				encontrado = true;
			}
			recorrido.Avanzar();
		}
		if (kAux.length() == 1){
			recorrido.Siguiente().final = false;
		}
		else{
			recorrido = recorrido.Siguiente().siguientes.crearIT();
		}
		kAux.erase(0);

	}
}
//Completar
//Claves:
template <class T,class K>
Conj<T> Tried<T,K>::Claves() const{
	return claves;
}
//#Claves
template <class T,class K>
int Tried<T,K>::cantClaves(){
	return claves.Cardinal();
}




		
#endif // TRIED_HPP_