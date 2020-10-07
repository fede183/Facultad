#include "lista_alumnos.h"

ListaAlumnos::ListaAlumnos()
  : len(0), prim(NULL), fin(NULL) {
}

ListaAlumnos::ListaAlumnos(const ListaAlumnos& l){
    Nodo* nuevo;
    for(int a = 0 ; a< l.longitud() ; a++){
        nuevo = new Nodo;
        nuevo->alumno = l.iesimo(a);
        nuevo->sig = NULL;
        len = l.longitud();
        if(a == 0){
            prim = nuevo;
            fin = nuevo;
        }
        else{
            fin->sig = nuevo;
            fin = nuevo;
        }
    }
}

ListaAlumnos::~ListaAlumnos() {
    for(int a = 0 ; a< len ; a++){
        fin = prim->sig;
        delete prim;
        prim = fin;
    }
  // Esto soluciona el problema de memoria
  // para listas de longitud 1
  // if (prim != NULL) {
  //   delete prim;
  // }
}

ListaAlumnos& ListaAlumnos::operator=(const ListaAlumnos& aCopiar){
    Nodo* nuevo;
    for(int a = 0 ; a< aCopiar.longitud() ; a++){
        nuevo = new Nodo;
        nuevo->alumno = aCopiar.iesimo(a);
        nuevo->sig = NULL;
        len = aCopiar.longitud();
        if(a == 0){
            prim = nuevo;
            fin = nuevo;
        }
        else{
            fin->sig = nuevo;
            fin = nuevo;
        }
    }
    return *this;
    }

int ListaAlumnos::longitud() const {
  return len;
}

void ListaAlumnos::agAdelante(const Alumno& elem) {
  // Completar/Arreglar
  Nodo* nuevo = new Nodo;
  nuevo->alumno = elem;
  nuevo->sig = prim;
  len ++;
  prim = nuevo;
}
 const Alumno& ListaAlumnos::iesimo(Nat i) const{
    Nodo* aux = prim;
    for(Nat j = 0 ; j < i ; j++)
        aux = aux->sig;
    return aux->alumno;
}

Alumno& ListaAlumnos::iesimo(Nat i){
    Nodo* aux = prim;
    for(Nat j = 0 ; j < i ; j++)
        aux = aux->sig;
    return aux->alumno;
}

void ListaAlumnos::agAtras(const Alumno& elem){
  // Completar/Arreglar
  Nodo* nuevo = new Nodo;
  nuevo->alumno = elem;
  nuevo->sig = NULL;
  len ++;
  fin->sig = nuevo;
  fin = nuevo;
}

void ListaAlumnos::eliminar(Nat i){
    Nodo* aux = prim;
    for(Nat j = 0 ; j < i-1 ; j++)
        aux = aux->sig;
    aux->sig = aux->sig->sig;
    delete aux->sig;
}

void ListaAlumnos::mostrar(ostream& o) const{
    Nodo* aux = prim;
    o << "[";
    for(Nat a = 0 ; a < len ; a++){
        o << aux->alumno;
        if(a != len-1)
            o << ", ";
        aux = aux->sig;
    }
    o << "]";
}
