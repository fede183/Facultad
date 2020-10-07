// g++ -g tests.cpp -o tests
// valgrind --leak-check=full ./tests

#include "mini_test.h"
#include "messineria.h"

/*
 * Crea una messineria de int vacia y no agrega elementos
 */
void check_crear_messineria_vacia() {
  Messineria<int> messi;
  ASSERT_EQ(messi.esVacia(), true);
  ASSERT_EQ(messi.tamanio(), 0);
  Messineria<int> messi2;
  ASSERT_EQ(messi==messi2, true);
}
void messineria_con_un_solo_elemento(){
	Messineria<int> messi;
	messi.golDeMessi(4);
	ASSERT_EQ(messi.tamanio(),1);
	ASSERT_EQ(messi.adeptoAlabando(),4);
	messi.golDeCristiano(4);
	ASSERT_EQ(messi.esVacia(),true);
  	
}
void messineria_con_dos_elemento(){
	Messineria<int> messi;
	messi.golDeMessi(4);
	messi.golDeMessi(10);
	ASSERT_EQ(messi.tamanio(),2);
	ASSERT_EQ(messi.adeptoAlabando(),4);
	messi.golDeCristiano(4);
	ASSERT_EQ(messi.tamanio(),1);
	messi.golDeCristiano(10);
	ASSERT_EQ(messi.esVacia(),true);
}
void messineria_con_tres_elemento(){
	Messineria<int> messi;
	messi.golDeMessi(4);
	messi.golDeMessi(10);
	messi.golDeMessi(7);
	ASSERT_EQ(messi.tamanio(),3);
	ASSERT_EQ(messi.adeptoAlabando(),4);
	messi.golDeCristiano(4);
	messi.golDeCristiano(10);
	messi.golDeCristiano(7);
	ASSERT_EQ(messi.esVacia(),true);
}
void elegido_prueba(){
	Messineria<int> messi;
	messi.golDeMessi(4);
	messi.golDeMessi(2);
	messi.golDeMessi(7);
	messi.escogerElegido();
	ASSERT_EQ(messi.hayElegido(),true);
	ASSERT_EQ(messi.dameElegido(),4);
	messi.alabarMessi();
	ASSERT_EQ(messi.adeptoAlabando(),2);
	ASSERT_EQ(messi.hayElegido(),true);
	messi.interrumpirTurno();
	ASSERT_EQ(messi.adeptoAlabando(),4);
	messi.traidor();
	ASSERT_EQ(messi.hayElegido(),false);
	ASSERT_EQ(messi.adeptoAlabando(),2);
	
}
void sacar_elemento_prueba(){
	Messineria<int> messi;
	messi.golDeMessi(4);
	messi.golDeMessi(5);
	messi.golDeMessi(9);
	messi.golDeCristiano(5);
	ASSERT_EQ(messi.tamanio(),2);
	ASSERT_EQ(messi.esVacia(),false);
}

void messineria_por_copia(){
	Messineria<int> messi;
	messi.golDeMessi(4);
	messi.golDeMessi(10);
	messi.golDeMessi(7);
	messi.golDeMessi(18);
	messi.golDeMessi(9);
	messi.escogerElegido();
	messi.alabarMessi();
	Messineria<int> messi2(messi);
	ASSERT_EQ(messi==messi2, true);
}

int main() {
  RUN_TEST(check_crear_messineria_vacia);
  RUN_TEST(messineria_con_un_solo_elemento);
  RUN_TEST(messineria_con_dos_elemento);
  RUN_TEST(sacar_elemento_prueba);
  RUN_TEST(elegido_prueba);
  RUN_TEST(messineria_con_tres_elemento);
  RUN_TEST(messineria_por_copia);
  //Prueba del mostrar
  Messineria<int> messi;
  cout<<messi<<endl;
  messi.golDeMessi(4);
  cout<<messi<<endl;
  messi.golDeMessi(5);
  cout<<messi<<endl;
  messi.golDeMessi(6);
  cout<<messi<<endl;
  messi.escogerElegido();
  cout<<messi<<endl;
  messi.alabarMessi();
  cout<<messi<<endl;
  messi.traidor();
  cout<<messi<<endl;
  return 0;
}

