#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <math.h>

#include "lista.h"
void f (void * v){}
void g (void * v, FILE* f){}
bool siempreVerdadero(void * j, void* h){
  return true;
}
bool siempreFalso(void * j, void* h){
  return false;
}
int main() {
  remove("salida.txt");
  //test1
  lista *lvacia=lista_crear();
  lista_imprimir(lvacia,"salida.txt",(tipo_funcion_imprimir)&g); 
  lista_borrar(lvacia,(tipo_funcion_borrar)&f);

  //test2
  lista *lUnJugador=lista_crear();
  jugador *jUnJugador=crear_jugador("Pepe","Australia",14,196);
  insertar_ordenado(lUnJugador,jUnJugador, (tipo_funcion_cmp)&menor_jugador);
  lista_imprimir(lUnJugador, "salida.txt",(tipo_funcion_imprimir)&imprimir_jugador);
  lista_borrar(lUnJugador, (tipo_funcion_borrar)&borrar_jugador);

  //test3
  lista *lOrdenado=lista_crear();
  jugador *jOrdenado=crear_jugador("Pepea","Australia",16,178);
  jugador *jOrdenado1=crear_jugador("Pepeb","Australia",16,178);
  jugador *jOrdenado2=crear_jugador("Pepec","Australia",16,178);
  jugador *jOrdenado3=crear_jugador("Peped","Australia",16,178);
  insertar_ordenado(lOrdenado,jOrdenado, (tipo_funcion_cmp)&siempreVerdadero);
  insertar_ordenado(lOrdenado,jOrdenado2, (tipo_funcion_cmp)&siempreFalso);
  insertar_ordenado(lOrdenado,jOrdenado1, (tipo_funcion_cmp)&menor_jugador);
  insertar_ordenado(lOrdenado,jOrdenado3, (tipo_funcion_cmp)&siempreVerdadero);
  lista_imprimir(lOrdenado, "salida.txt",(tipo_funcion_imprimir)&imprimir_jugador);
  lista_borrar(lOrdenado, (tipo_funcion_borrar)&borrar_jugador);
  //test4
  //a)
  lista *ltest4=lista_crear();
  seleccion * stest4=crear_seleccion("Uruguay",0,ltest4);
  lista *ltest42=lista_crear();
  insertar_ordenado(ltest42,stest4,(tipo_funcion_cmp)&menor_seleccion);
  lista_imprimir(ltest42,"salida.txt",(tipo_funcion_imprimir)&imprimir_seleccion);
  lista_borrar(ltest42, (tipo_funcion_borrar)&borrar_seleccion);
  //b)
  lista *ltest43=lista_crear();
  jugador *jtest4=crear_jugador("Jose","Uruguay",8,156);
  insertar_ordenado(ltest43,jtest4,(tipo_funcion_cmp)&menor_jugador);
  seleccion * stest42=crear_seleccion("Uruguay",altura_promedio(ltest43),ltest43);
  lista *ltest44=lista_crear();
  insertar_ordenado(ltest44,stest42,(tipo_funcion_cmp)&menor_seleccion);
  lista_imprimir(ltest44,"salida.txt",(tipo_funcion_imprimir)&imprimir_seleccion);
  lista_borrar(ltest44, (tipo_funcion_borrar)&borrar_seleccion);
  //c)
  lista *ltest45=lista_crear();
  jugador *jtest42=crear_jugador("Carlos","Peru",8,156);
  jugador *jtest43=crear_jugador("Jorge","Peru",8,187);
  insertar_ordenado(ltest45,jtest42,(tipo_funcion_cmp)&menor_jugador);
  insertar_ordenado(ltest45,jtest43,(tipo_funcion_cmp)&menor_jugador);
  seleccion * stest43=crear_seleccion("Peru",altura_promedio(ltest45),ltest45);
  lista *ltest46=lista_crear();
  insertar_ordenado(ltest46,stest43,(tipo_funcion_cmp)&menor_seleccion);
  lista_imprimir(ltest46,"salida.txt",(tipo_funcion_imprimir)&imprimir_seleccion);
  lista_borrar(ltest46, (tipo_funcion_borrar)&borrar_seleccion);



  //test5
  //a)
  lista *ltest5=lista_crear();
  lista* lstest5=ordenar_lista_jugadores(ltest5);
  lista_imprimir(lstest5,"salida.txt",(tipo_funcion_imprimir)&imprimir_jugador);
  lista *lstest52= mapear(lstest5,(tipo_funcion_mapear)&f);
  lista_imprimir(lstest52,"salida.txt",(tipo_funcion_imprimir)&imprimir_jugador);
  lista_borrar(ltest5, f);
  lista_borrar(lstest5, f);
  lista_borrar(lstest52, (tipo_funcion_borrar)&borrar_jugador);

  lista *ltest52=lista_crear();
  jugador *jtest5=crear_jugador("Federico","Holanda",10,165);
  insertar_ordenado(ltest52,jtest5,(tipo_funcion_cmp)&menor_jugador);
  lista* lstest53=ordenar_lista_jugadores(ltest52);
  lista_imprimir(lstest53,"salida.txt",(tipo_funcion_imprimir)&imprimir_jugador);
  lista *lstest54= mapear(lstest53,(tipo_funcion_mapear)&normalizar_jugador);
  lista_imprimir(lstest54,"salida.txt",(tipo_funcion_imprimir)&imprimir_jugador);
  lista_borrar(ltest52, f);
  lista_borrar(lstest53, (tipo_funcion_borrar)&borrar_jugador);
  lista_borrar(lstest54, (tipo_funcion_borrar)&borrar_jugador);

  lista *ltest53=lista_crear();
  jugador *jtest52=crear_jugador("Federico","Holanda",10,165);
  jugador *jtest53=crear_jugador("Javier","Holanda",5,178);
  insertar_ordenado(ltest53,jtest52,(tipo_funcion_cmp)&menor_jugador);
  insertar_ordenado(ltest53,jtest53,(tipo_funcion_cmp)&menor_jugador);
  lista* lstest55=ordenar_lista_jugadores(ltest53);
  lista_imprimir(lstest55,"salida.txt",(tipo_funcion_imprimir)&imprimir_jugador);
  lista *lstest56= mapear(lstest55,(tipo_funcion_mapear)&normalizar_jugador);
  lista_imprimir(lstest56,"salida.txt",(tipo_funcion_imprimir)&imprimir_jugador);
  lista_borrar(ltest53, f);
  lista_borrar(lstest55, (tipo_funcion_borrar)&borrar_jugador);
  lista_borrar(lstest56, (tipo_funcion_borrar)&borrar_jugador);
  //b)
  jugador *jtest54=crear_jugador("Koko","Brazil",20,182);
  jugador *jtest55=crear_jugador("Roco","Holanda",45,197);
  jugador *jtest56=crear_jugador("Ricardo","Holanda",89,147);
  assert(!pais_jugador(jtest54,jtest55));
  assert(pais_jugador(jtest55,jtest56));
  borrar_jugador(jtest54);
  borrar_jugador(jtest55);
  borrar_jugador(jtest56);
  
  return 0;
}