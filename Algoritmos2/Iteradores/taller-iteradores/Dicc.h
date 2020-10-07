/**
 * Modulo Diccionario
 * Algoritmos y Estructuras de Datos 2
 */

#ifndef AED2_DICC_H_INCLUDED
#define	AED2_DICC_H_INCLUDED

#include "Lista.h"

#include <ostream>

/* Descomentar este flag para habilitar los chequeos internos de PRE
 * OJO que invalida las complejidades exportadas de algunas funciones
 */
#define DEBUG 1

namespace aed2
{

template<class K,class S>
class Dicc
{
	public:

		// Forward declarations. Las definiciones estan mas abajo.
		class Iterador;
		class const_Iterador;

		Dicc();

		Dicc(const Dicc<K,S>& otro);

		Dicc<K,S>& operator = (const Dicc<K,S>& otro);

		Iterador Definir(const K& clave, const S& significado);
		Iterador DefinirRapido(const K& clave, const S& significado);

		bool Definido(const K& clave) const;

		const S& Significado(const K& clave) const;
		S& Significado(const K& clave);

		void Borrar(const K& clave);

		Nat CantClaves() const;

		Iterador CrearIt();
		const_Iterador CrearIt() const;

		/** 
		 * Estas funciones son utiles para saber si algo esta definido
		 * y ver cual es su signficado, sin recorrer dos veces.
		 * Si la clave no esta definida, Iterador.HaySiguiente() 
		 * retorna falso. Si la clave esta definida, Iterador.Siguiente()
		 * retorna el elemento buscado.
		 */
		Iterador Buscar(const K&);
		const_Iterador Buscar(const K&) const;

		// COMPLETAR ...
		class Iterador
		{
			public:

				Iterador();

				Iterador(const typename Dicc<K, S>::Iterador& otro);

				Iterador& operator = (const typename Dicc<K, S>::Iterador& otro);

				bool HayAnterior() const;
				bool HaySiguiente() const;

				K& AnteriorClave() const;
				K& SiguienteClave() const;

				S& AnteriorSignificado() const;
				S& SiguienteSignificado() const;

				void Avanzar();
				void Retroceder();

				void EliminarAnterior();
				void EliminarSiguiente();

				void AgregarComoAnterior(const K& clave, const S& significado);
				void AgregarComoSiguiente(const K& clave, const S& significado);

				bool operator==(const typename Dicc<K, S>::Iterador& otro) const;

			private:

				/// El constructor es privado, necesitamos el friend.
				Iterador(Dicc<K, S>* _diccionario, typename Lista<K>::Iterador* _proximoClave, typename Lista<S>::Iterador* _proximoSignificado)
				: diccionario(_diccionario), siguienteC(_proximoClave), siguienteS(_proximoSignificado) {};
				friend typename Dicc<K, S>::Iterador Dicc<K, S>::CrearIt();
				//friend typename Dicc<K, S>::Iterador Dicc<K, S>::CrearItUlt();
				friend class Dicc<K, S>::const_Iterador;

				Dicc<K, S>* diccionario;
				typename Lista<K>::Iterador* siguienteC;
				typename Lista<S>::Iterador* siguienteS;


		}; // class Iterador

		class const_Iterador
		{
			public:

				const_Iterador();

				const_Iterador(const typename Dicc<K, S>::const_Iterador& otro);

				const_Iterador(const typename Dicc<K, S>::Iterador& otro);

				const_Iterador& operator=(const typename Dicc<K, S>::const_Iterador& otro);

				bool HayAnterior() const;
				bool HaySiguiente() const;

				const K& AnteriorClave() const;
				const K& SiguienteClave() const;

				const S& AnteriorSignificado() const;
				const S& SiguienteSignificado() const;


				void Avanzar();
				void Retroceder();

				bool operator == (const typename Dicc<K, S>::const_Iterador& otro) const;

			private:

				/// El constructor es privado, necesitamos el friend.
				const_Iterador(const Dicc<K, S>* _diccionario, const typename Lista<K>::Iterador* _proximoClave, const typename Lista<S>::Iterador* _proximoSignificado)
				: diccionario(_diccionario), siguienteC(_proximoClave), siguienteS(_proximoSignificado) {};
				friend typename Dicc<K, S>::const_Iterador Dicc<K, S>::CrearIt() const;
				//friend typename Dicc<K, S>::const_Iterador Dicc<K, S>::CrearItUlt() const;

				const Dicc<K, S>* diccionario;
				const typename Lista<K>::Iterador* siguienteC;
				const typename Lista<S>::Iterador* siguienteS;

		}; // class const_iterador

	private:

		Lista<K> claves_;


		Lista<S> significados_;

}; // class Dicc

/**
 * Operador ostream de Dicc
 */
template<class K, class S>
std::ostream& operator << (std::ostream& os, const Dicc<K,S>& d);

/**
 * Operador comparacion
 */
template<class K, class S>
bool operator == (const Dicc<K,S>& d1, const Dicc<K,S>& d2);

	// ---------------------------------------------------------
	//  class Dicc
	// ---------------------------------------------------------

template<class K, class S>
Dicc<K,S>::Dicc()
{}

template<class K, class S>
Dicc<K,S>::Dicc(const Dicc<K,S>& otro)
	: claves_(otro.claves_), significados_(otro.significados_)
{}

template<class K, class S>
Dicc<K,S>& Dicc<K,S>::operator=(const Dicc<K,S>& otro)
{
	claves_ = otro.claves_;
	significados_ = otro.significados_;

	return *this;
}



template<class K, class S>
typename Dicc<K,S>::Iterador Dicc<K,S>::Definir(const K& clave, const S& significado)
{
	Iterador it = Buscar(clave);

	// Si la clave existe, cambio el significado
	if(it.HaySiguiente()) {
		it.SiguienteSignificado() = significado;
	// Si la clave no existe, agrego la definicion
	} else {
		it = DefinirRapido(clave, significado);
	}

	return it;
}

template<class K, class S>
typename Dicc<K,S>::Iterador Dicc<K,S>::DefinirRapido(const K& clave, const S& significado)
{
	// Me aseguro que se cumpla la precondicion
	// OJO que esto invalida la complejidad
	#ifdef DEBUG
	assert( !Definido(clave) );
	#endif

	claves_.AgregarAdelante(clave);
	significados_.AgregarAdelante(significado);

	return CrearIt();
}

template<class K, class S>
bool Dicc<K,S>::Definido(const K& clave) const
{
	return Buscar(clave).HaySiguiente();
}

template<class K, class S>
const S& Dicc<K,S>::Significado(const K& clave)const
{
	// Me aseguro que se cumpla la precondicion
	#ifdef DEBUG
	assert( Definido(clave) );
	#endif

	return Buscar(clave).Siguiente().significado;
}

template<class K, class S>
S& Dicc<K,S>::Significado(const K& clave)
{
	// Me aseguro que se cumpla la precondicion
	#ifdef DEBUG
	assert( Definido(clave) );
	#endif

	return Buscar(clave).Siguiente().significado;
}

template<class K, class S>
void Dicc<K,S>::Borrar(const K& clave)
{
	// Me aseguro que se cumpla la precondicion
	#ifdef DEBUG
	assert( Definido(clave) );
	#endif

	Buscar(clave).EliminarSiguiente();
}

template<class K, class S>
Nat Dicc<K,S>::CantClaves() const
{
	return claves_.Longitud();
}

template<class K, class S>
typename Dicc<K,S>::Iterador Dicc<K,S>::CrearIt()
{
	typename Lista<K>::Iterador Cla = claves_.CrearIt();
	typename Lista<K>::Iterador* Cl = &Cla;
	typename Lista<S>::Iterador Sign = significados_.CrearIt();
	typename Lista<S>::Iterador* Sig = &Sign;
	return Iterador(this, Cl, Sig);
}

template<class K, class S>
typename Dicc<K,S>::const_Iterador Dicc<K,S>::CrearIt() const
{
	typename Lista<K>::Iterador Cla = claves_.CrearIt();
	typename Lista<K>::Iterador* Cl = &Cla;
	typename Lista<S>::Iterador Sign = significados_.CrearIt();
	typename Lista<S>::Iterador* Sig = &Sign;
	return const_Iterador(this, Cl, Sig);
}


	// ---------------------------------------------------------
	//  class Dicc::Iterador
	// ---------------------------------------------------------
	
	// COMPLETAR ...
template<class K, class S>
Dicc<K,S>::Iterador::Iterador()
:  diccionario(NULL) , siguienteC(NULL), siguienteS(NULL)
{}

template<class K, class S>
Dicc<K,S>::Iterador::Iterador(const typename Dicc<K, S>::Iterador& otro)
: diccionario(otro.diccionario), siguienteC(otro.siguienteC), siguienteS(otro.siguienteS)
{}

template<class K, class S>
typename Dicc<K,S>::Iterador&  Dicc<K,S>::Iterador::operator = (const typename Dicc<K, S>::Iterador& otro)
{
	diccionario = otro.diccionario;
	siguienteC = otro.siguienteC;
	siguienteS = otro.siguienteS;
	return *this;
}

template<class K, class S>
bool Dicc<K,S>::Iterador::HaySiguiente() const
{
	return (*siguienteC).HaySiguiente();
}

template<class K, class S>
bool Dicc<K,S>::Iterador::HayAnterior() const
{
	return (*siguienteC).HayAnterior();
}

template<class K, class S>
K& Dicc<K,S>::Iterador::SiguienteClave() const
{
	return (*siguienteC).Siguiente();
}

template<class K, class S>
S& Dicc<K,S>::Iterador::SiguienteSignificado() const
{
	return (*siguienteS).Siguiente();
}

template<class K, class S>
K& Dicc<K,S>::Iterador::AnteriorClave() const
{
	return (*siguienteC).Anterior();
}

template<class K, class S>
S& Dicc<K,S>::Iterador::AnteriorSignificado() const
{
	return (*siguienteS).Anterior();
}

template<class K, class S>
void Dicc<K,S>::Iterador::Avanzar() 
{
	(*siguienteC).Avanzar();
	(*siguienteS).Avanzar();
}

template<class K, class S>
void Dicc<K,S>::Iterador::Retroceder() 
{
	(*siguienteC).Retroceder();
	(*siguienteS).Retroceder();
}

template<class K, class S>
void Dicc<K,S>::Iterador::EliminarSiguiente() 
{
	(*siguienteC).EliminarSiguiente();
	(*siguienteS).EliminarSiguiente();
}

template<class K, class S>
void Dicc<K,S>::Iterador::EliminarAnterior() 
{
	(*siguienteC).EliminarAnterior();
	(*siguienteS).EliminarAnterior();
}

template<class K, class S>
void Dicc<K,S>::Iterador::AgregarComoAnterior(const K& clave, const S& significado)
{
	(*siguienteC).AgregarComoAnterior(clave);
	(*siguienteS).AgregarComoAnterior(significado);
}

template<class K, class S>
void Dicc<K,S>::Iterador::AgregarComoSiguiente(const K& clave, const S& significado)
{
	(*siguienteC).AgregarComoSiguiente(clave);
	(*siguienteS).AgregarComoSiguiente(significado);
}

template<class K, class S>
bool Dicc<K,S>::Iterador::operator==(const typename Dicc<K, S>::Iterador& otro) const
{
	return (otro.siguienteS == siguienteS) && (otro.siguienteC == siguienteC);
}
	// ---------------------------------------------------------
	//  class Dicc::const_Iterador
	// ---------------------------------------------------------

	// COMPLETAR ...
template<class K, class S>
Dicc<K,S>::const_Iterador::const_Iterador()
: diccionario(NULL), siguienteC(NULL), siguienteS(NULL)
{}

template<class K, class S>
Dicc<K,S>::const_Iterador::const_Iterador(const typename Dicc<K, S>::const_Iterador& otro)
: diccionario(otro.diccionario), siguienteC(otro.siguienteC), siguienteS(otro.siguienteS)
{}

template<class K, class S>
Dicc<K,S>::const_Iterador::const_Iterador(const typename Dicc<K, S>::Iterador& otro)
: diccionario(otro.diccionario), siguienteC(otro.siguienteC), siguienteS(otro.siguienteS)
{}

template<class K, class S>
typename Dicc<K,S>::const_Iterador& Dicc<K,S>::const_Iterador::operator=(const typename Dicc<K, S>::const_Iterador& otro)
{
	diccionario = otro.diccionario;
	siguienteC = otro.siguienteC;
	siguienteS = otro.siguienteS;
	return *this;
}

template<class K, class S>
bool Dicc<K,S>::const_Iterador::HaySiguiente() const
{
	return (*siguienteC).HaySiguiente();
}

template<class K, class S>
bool Dicc<K,S>::const_Iterador::HayAnterior() const
{
	return (*siguienteC).HayAnterior();
}

template<class K, class S>
const K& Dicc<K,S>::const_Iterador::SiguienteClave() const
{
	return (*siguienteC).Siguiente();
}

template<class K, class S>
const S& Dicc<K,S>::const_Iterador::SiguienteSignificado() const
{
	return (*siguienteS).Siguiente();
}

template<class K, class S>
const K& Dicc<K,S>::const_Iterador::AnteriorClave() const
{
	return (*siguienteC).Anterior();
}

template<class K, class S>
const S& Dicc<K,S>::const_Iterador::AnteriorSignificado() const
{
	return (*siguienteS).Anterior();
}

template<class K, class S>
bool Dicc<K,S>::const_Iterador::operator == (const typename Dicc<K, S>::const_Iterador& otro) const
{
	return (otro.siguienteS == siguienteS) && (otro.siguienteC == siguienteC);
}
	// ---------------------------------------------------------
	//  funciones auxiliares
	// ---------------------------------------------------------

template<class K, class S>
typename Dicc<K,S>::Iterador Dicc<K,S>::Buscar(const K& clave)
{
	typename Dicc<K,S>::Iterador it = CrearIt();

	while(it.HaySiguiente() && it.SiguienteClave() != clave)
	{
		it.Avanzar();
	}

	return it;
}

template<class K, class S>
typename Dicc<K,S>::const_Iterador Dicc<K,S>::Buscar(const K& clave) const
{
	typename Dicc<K,S>::const_Iterador it = CrearIt();

	while(it.HaySiguiente() && it.SiguienteClave() != clave)
	{
		it.Avanzar();
	}

	return it;
}

template<class K, class S>
std::ostream& operator<<(std::ostream& os, const Dicc<K,S>& d)
{
	return Mostrar(os, d, '{', '}');
}

template<class K, class S>
bool operator == (const Dicc<K,S>& d1, const Dicc<K,S>& d2)
{
	bool retval = d1.CantClaves() == d2.CantClaves();

	typename Dicc<K,S>::const_Iterador it1 = d1.CrearIt();

	while(retval and it1.HaySiguiente())
	{
		typename Dicc<K,S>::const_Iterador it2 = d2.Buscar(it1.SiguienteClave());

		retval = it2.HaySiguiente() and it1.SiguienteSignificado() == it2.SiguienteSignificado();

		it1.Avanzar();
	}

	return retval;
}

} // namespace aed2

#endif	//AED2_DICC_H_INCLUDED
