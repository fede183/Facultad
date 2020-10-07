// g++ -g tests.cpp -o tests
// valgrind --leak-check=full -v ./tests

#include "mini_test.h"
#include "avl.h"


template<typename T>
string to_s(const T& m) {
 	ostringstream os;
	os << m;
	return os.str();
 }


/*
 * Crea una carrera de int vacia y no agrega elementos
 */
void avl_con_un_elemento() {
    Avl<int> A,B;
    A.agregar(4);
    B.agregar(3);
    ASSERT_EQ(A.DarAltura(), 1);
    ASSERT_EQ(B.DarAltura(), 1);
    ASSERT(B.esta(3));
    ASSERT(A.esta(4));
    ASSERT(!(A == B));
}

/*
 * Agrega 3 elementos y verifica que esten agregados segun lo pedido
 */
void check_agregar_corredores() {

}

/*
 * Agrega corredores y verifica que esten agregados donde corresponde
 */
void check_agregar_corredores2() {

}


/*
 * Se copia una carrera y verifica que sus atributos sean iguales.
 * OJO! Este test puede pasar aun si implementan mal el constructor
 * por copia y tambien implementan mal el operator== y el metodo
 * dameCorredorEnPos, tengan mucho cuidado con esto
 */

void check_copiar_carrera() {


}

/*
 * Verifica que se canse el corredor correcto.
 */

void check_se_cansa() {

}

/*
 * Verifica que el sobrepaso sea correcto
 */

void check_sobrepasar() {

}

/*
 * Verifica que se filme al corredor correcto
 */

void check_corredor_filmado() {

}

/*
 * Verifica que el primero sea el que tiene que ser el primero
 */

void check_primero() {

}

/*
 * Verifica que los corredores esten en la posicion correcta
 */

void check_posicion() {

}
//Tests Nuestros:
void check_tamanio(){

}



int main() {
    RUN_TEST(avl_con_un_elemento);
    return 0;
}

