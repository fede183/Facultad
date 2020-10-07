#include <iostream>
#include "Conjunto.hpp"

#include "mini_test.h"


void si_no_lo_agrego_no_pertenece() {
  Conjunto<char> c;
  ASSERT( !c.pertenece('a') );
}


void insertar_inserta() {
  Conjunto<int> c;
  c.insertar(42);
  ASSERT( c.pertenece(42) );
}



int main() {
    RUN_TEST(si_no_lo_agrego_no_pertenece);
    RUN_TEST(insertar_inserta);
    return 0;
}
