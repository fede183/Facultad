#include "Heap.h"
#include "mini_test.h"

struct compu
{
  string hostname;
};

struct paquete
{
  unsigned int id;
  unsigned int prioridad;
  //compu origen;
  //bcompu destino;
};

void heap_test() {
  Heap<paquete> l;
  ASSERT_EQ(l.cantidad(), 0);

  paquete p1, p2, p3, p4;
  p1.id = 1;
  p2.id = 2;
  p3.id = 3;
  p4.id = 4;
  p1.prioridad = 45;
  p2.prioridad = 4;
  p3.prioridad = 48;
  p4.prioridad = 85;

  l.encolar(p1);
  l.mostrar(std::cout);
  std::cout << '\n';
  ASSERT_EQ(l.cantidad(), 1);
  ASSERT_EQ(l.proximo().id, 1);
  l.encolar(p2);
  l.mostrar(std::cout);
  std::cout << '\n';
  ASSERT_EQ(l.cantidad(), 2);
  ASSERT_EQ(l.proximo().id, 2);
  l.encolar(p3);
  l.mostrar(std::cout);
  std::cout << '\n';
  ASSERT_EQ(l.cantidad(), 3);
  ASSERT_EQ(l.proximo().id, 2);
  l.encolar(p4);
  l.mostrar(std::cout);
  std::cout << '\n';
  ASSERT_EQ(l.cantidad(), 4);
  ASSERT_EQ(l.proximo().id, 2);
  l.desencolar();
  l.mostrar(std::cout);
  std::cout << '\n';
  ASSERT_EQ(l.cantidad(), 3);
  ASSERT_EQ(l.proximo().id, 1);
  l.desencolar();
  l.mostrar(std::cout);
  std::cout << '\n';
  ASSERT_EQ(l.cantidad(), 2);
  ASSERT_EQ(l.proximo().id, 3);
  l.desencolar();
  l.mostrar(std::cout);
  ASSERT_EQ(l.cantidad(), 1);
  ASSERT_EQ(l.proximo().id, 4);
}

int main() {
  RUN_TEST(heap_test);
 

  return 0;
}
