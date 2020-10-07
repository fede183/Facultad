#include "Heap.h"
#include "mini_test.h"

void heap_test() {
  Heap<int> l;
  ASSERT_EQ(l.cantidad(), 0);
  l.encolar(45);
  ASSERT_EQ(l.cantidad(), 1);
  l.encolar(4);
  ASSERT_EQ(l.cantidad(), 2);
  ASSERT_EQ(l.proximo(), 45);
  l.encolar(46);
  ASSERT_EQ(l.cantidad(), 3);
  ASSERT_EQ(l.proximo(), 46);
  l.encolar(85);
  ASSERT_EQ(l.cantidad(), 4);
  ASSERT_EQ(l.proximo(), 85);
  l.desencolar();
  ASSERT_EQ(l.cantidad(), 3);
  ASSERT_EQ(l.proximo(), 46);
  l.desencolar();
  ASSERT_EQ(l.cantidad(), 2);
  ASSERT_EQ(l.proximo(), 45);
  l.desencolar();
  ASSERT_EQ(l.cantidad(), 1);
}

int main() {
  RUN_TEST(heap_test);
 

  return 0;
}
