#include "Tried.h"
#include "mini_test.h"

void a_la_lista_vacia_se_le_agrega_alumno() {
  char u = '0';
  Tried<char, int> l(u,'~');
  char dh = 'd';
  char dt[] = "ho";
  char *s = &dh;
  l.definir(s, 1, 15);
  ASSERT_EQ(l.cantidad(), 1);
  ASSERT_EQ(l.estaDefinido(s, 1), true);
  ASSERT_EQ(l.obtener(s, 1), 15);
  s = dt;
  l.definir(s, 2, 89);
  ASSERT_EQ(l.cantidad(), 2);
  ASSERT_EQ(l.estaDefinido(s, 2), true);
  ASSERT_EQ(l.obtener(s, 2), 89);
  l.remover(s, 2);
  ASSERT_EQ(l.estaDefinido(s, 2), false);
  ASSERT_EQ(l.cantidad(), 1);

}

int main() {
  RUN_TEST(a_la_lista_vacia_se_le_agrega_alumno);

  return 0;
}
