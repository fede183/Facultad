#ifndef RED_
#define RED_

#include <vector>
#include <map>
#include <assert.h>
#include <iostream>
#include <cassert>
#include <math.h>
#include "aed2.h"

using namespace std;



class Red
{
	public:
		// Constructor. Genera una red sin computadoras.
		Red();
		//Constructor por copia
		Red( Red&);

		// Destructor. Debe dejar limpia la memoria.
		~Red();

		//Agrega una computadora a la red.
		void AgregarComputadora(const compu&);

		//Conecta dos computadoras en una red.
		void Conectar(const compu&, const compu&,  interfaz,  interfaz);

		//Devuelve un conjunto con todas las computadoras de la red.
		Conj<compu>& Computadoras();

		//Devuelve true si y solo si las dos computadoras estan conectadas.
		bool Conectadas(const compu&, const compu&);

		//Devuelve la interfaz que conecta dos computadoras.
		const interfaz& interfazUsada(const compu&, const compu&);

		//Devuelve el conjunto de computadoras conectadas a compu pasada.
		Conj<compu>& Vecinos(const compu&);

		//Devuelve true si y solo si la interfaz de la compu esta siendo usada.
		bool UsaInterfaz(const compu&, const interfaz&);

		//Devuelve todos los caminos minimos para llegar de la primera computadora a la segunda.
		Conj<Lista<compu> >& CaminoMinimo(const compu&, const compu&);

		//Devuelve true si y solo si existe uno o mas caminos por los cuales se puede llegar desde la primer compu hasta la segunda.
		bool HayCamino(const compu& ,const compu&);


	private:
		
		Conj<compu> Compus;
		DiccString<Conj<compu> > Conexiones;
		DiccString<DiccString<interfaz> > InterfacesQueConectan;
		DiccString<DiccString<Conj<Lista<compu> > > > caminosMinimos;

		//Funciones auxiliares
		Conj<Lista<compu> > AuxCaminos(const compu &, const compu &, Lista<compu> &, Conj<compu> &);
		Conj<Lista<compu> > ConstruirCaminosMinimos(const compu &, const compu &);
};




#endif // RED_
