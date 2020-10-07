#include "lista.h"

void insertar_ultimo (lista *l, nodo *nuevo);
extern bool string_iguales(char *p1, char *p2);
// Completar las funciones en C

bool buscarSeleccionConEsePais(lista *l, char* pais){
  nodo* recorrido=l->primero;
  while(recorrido!=NULL){
    if(string_iguales(pais,((seleccion*)recorrido->datos)->pais)){
      return true;
    }
    recorrido=recorrido->sig;
  }
  return false;

}

lista *generar_selecciones( lista *l ){
  nodo* recorrido=l->primero, *recorrido2, *auxiliar;
  seleccion* nuevaS;
  lista* resultado=lista_crear(), *aux1,*aux2;
  while(recorrido!=NULL){
   if(!buscarSeleccionConEsePais(resultado ,((jugador *)recorrido->datos)->pais)){
      aux1=filtrar_jugadores(l,(tipo_funcion_cmp)&pais_jugador,recorrido);
      aux2=mapear(aux1,normalizar_jugador);
      nuevaS=crear_seleccion(((jugador *)recorrido->datos)->pais, altura_promedio(aux2),ordenar_lista_jugadores(aux2));
      insertar_ordenado(resultado, nuevaS, menor_seleccion);
      lista_borrar(aux1,borrar_jugador);
      recorrido2=aux2->primero;
      while(recorrido2!=NULL){
        auxiliar=recorrido2;
        recorrido2=recorrido2->sig;
        free(auxiliar);
      }
      free(aux2);
      
      
    }
    recorrido=recorrido->sig; 
  }
  return resultado;  
}




// Funciones ya implementadas en C 

lista *filtrar_jugadores (lista *l, tipo_funcion_cmp f, nodo *cmp){
  lista *res = lista_crear();
  nodo *n = l->primero;
  while(n != NULL){
    if (f (n->datos, cmp->datos)){
      jugador *j = (jugador *) n->datos;
      nodo *p = nodo_crear ( (void *) crear_jugador (j->nombre, j->pais, j->numero, j->altura) );
      insertar_ultimo (res, p);
    }
    n = n->sig;
  }
  return res;
}

void insertar_ultimo (lista *l, nodo *nuevo){
  nodo *ultimo = l->ultimo;
  if (ultimo == NULL){
    l->primero = nuevo;
  }
  else{
    ultimo->sig = nuevo;
  }
  nuevo->ant = l->ultimo;
  l->ultimo = nuevo;
}