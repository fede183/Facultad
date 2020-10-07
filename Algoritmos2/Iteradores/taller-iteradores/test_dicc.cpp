// g++ -g tests.cpp -o tests
// valgrind --leak-check=full -v ./tests

#include "mini_test.h"
#include "Dicc.h"
#include "TiposBasicos.h"
using namespace aed2;

/*template<typename T>
String to_s(const T& m) {
 	ostringstream os;
	os << m;
	return os.str();
 }

/*
 * Descripcion del test1
 */
void test1() {
  Dicc<int, char> dic;
  typename Dicc<int, char>::Iterador iter1 = dic.Definir(1, 'a');
  //typename Dicc<int, char>::Iterador iter2 = dic.Definir(2, 'b');
  /*typename aed2::Dicc<int, char>::Iterador iter3 = dic.Definir(3, 'c');
  typename aed2::Dicc<int, char>::Iterador iter4 = dic.Definir(4, 'd');
  typename aed2::Dicc<int, char>::Iterador iter5 = dic.Definir(5, 'e');
  typename aed2::Dicc<int, char>::Iterador iter6 = dic.Definir(6, 'f');
  typename aed2::Dicc<int, char>::Iterador iter7 = dic.Definir(7, 'g');
  typename aed2::Dicc<int, char>::Iterador iter8 = dic.Definir(8, 'h');
  typename aed2::Dicc<int, char>::Iterador iter9 = dic.Definir(9, 'i');
  typename aed2::Dicc<int, char>::Iterador iter10 = dic.Definir(10, 'j');



  ASSERT(iter1.Siguiente() == 1);
  ASSERT(iter1.Siguiente() == 2);
  ASSERT(iter1.Siguiente() == 3);
  ASSERT(iter1.Siguiente() == 4);
  ASSERT(iter1.Siguiente() == 5);
  ASSERT(iter1.Siguiente() == 6);
  ASSERT(iter1.Siguiente() == 7);
  ASSERT(iter1.Siguiente() == 8);
  ASSERT(iter1.Siguiente() == 9);
  ASSERT(iter1.Siguiente() == 10);*/
}


/*
 * Descripcion del test2
 */
void test2() {
  
  ASSERT(false);
}



int main() {
  RUN_TEST(test1);
  RUN_TEST(test2); 
  return 0;
}

