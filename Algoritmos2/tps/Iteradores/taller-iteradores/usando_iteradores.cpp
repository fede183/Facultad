/*
 * Solucion de la ejercitacion del uso de iteradores.
 */

#include "Lista.h"

#include <iostream>				// std::cout, std::endl
#include "mini_test.h"
using namespace aed2;

/**
 * Cantidad de elementos de l
 */
template<typename T>
int cant( const Lista<T>& l ) {
  // COMPLETAR ...
	return Longitud(l);
}

/**
 * String con el contenido de l
 */
template<typename T>
void mostrar( const Lista<T>& l ) {
  // COMPLETAR ...
	typename Lista<T>::const_Iterador recorrido = l.CrearIt();
	std::cout << '<';
	while(recorrido.HaySiguiente()){
		std::cout << recorrido.Siguiente();
		recorrido.Avanzar();
		if(recorrido.HaySiguiente()){
			std::cout << ',';
		}
	}
	std::cout << '>';
}

/**
 * Modifica una lista, duplicando todos los elementos 
 * de la lista original, y devuelve esa misma.
 */
template<typename T>
Lista<T>& dobles( Lista<T>& l ) {
  // COMPLETAR ...
	typename Lista<T>::Iterador recorrido = l.CrearIt();
	while(recorrido.HaySiguiente()){
		recorrido.AgregarComoSiguiente(recorrido.Siguiente());
		recorrido.Avanzar();
		recorrido.Avanzar();
	}
	return l;
}

/**
 * Devuelve una lista que tiene unicamente los elementos primos 
 * contenidos en la lista original.
 * Un numero entero se considera primo sii unicamente tiene 
 * dos divisores enteros, a si mismo y al numero 1.
 */
template<typename T>
Lista<T> primos( const Lista<T>& l ) {
  // COMPLETAR ...
	Lista<T> resultado;
	typename Lista<T>::const_Iterador recorrido = l.CrearIt();
	while(recorrido.HaySiguiente()){
		bool NoEncontroUnDivisor = false;

		int divisor = recorrido.Siguiente();
		int i = 1;
		if(divisor < 0){
			divisor = -divisor;
			i = -1;
		}
		divisor = divisor - i;
		while(!NoEncontroUnDivisor && divisor > 1){
			NoEncontroUnDivisor = (recorrido.Siguiente() % divisor == 0);
			divisor = divisor - i;
		}
		if(!NoEncontroUnDivisor){
			resultado.AgregarAtras(recorrido.Siguiente());
		}
		recorrido.Avanzar();
	}
	return resultado;
}


void normal() {
  
  ASSERT(true);
  Lista<int> l1;
  l1.AgregarAtras(5);
  l1.AgregarAtras(2);
  l1.AgregarAtras(69);
  l1.AgregarAtras(14);
  l1.AgregarAtras(13);
  mostrar(l1);

}


/*
 * Descripcion del test2
 */
void doble() {
  
  ASSERT(true);
  Lista<int> l1;
  l1.AgregarAtras(5);
  l1.AgregarAtras(2);
  l1.AgregarAtras(69);
  l1.AgregarAtras(14);
  l1.AgregarAtras(13);
  dobles(l1);
  mostrar(l1);
}

/*
 * Descripcion del test3
 */
void primo() {
  
  ASSERT(true);
  Lista<int> l1;
  l1.AgregarAtras(5);
  l1.AgregarAtras(2);
  l1.AgregarAtras(69);
  l1.AgregarAtras(14);
  l1.AgregarAtras(13);
  mostrar(primos(l1));
}

int main(int argc, char **argv) {
  // COMPLETAR CON TESTS ...
	RUN_TEST(normal);
  	RUN_TEST(doble);
  	RUN_TEST(primo); 
      
  return 0;
}

