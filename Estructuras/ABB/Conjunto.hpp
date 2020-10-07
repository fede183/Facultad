#ifndef CONJUNTO_HPP_
#define CONJUNTO_HPP_

#include <assert.h>

using namespace std;

template <class T>
class Conjunto
{
    public:

        // Constructor. Genera un conjunto vacío.
        Conjunto();

        // Destructor. Debe dejar limpia la memoria.
        ~Conjunto();

        // Inserta un elemento en el conjunto. Si éste ya existe,
        // el conjunto no se modifica.
        void insertar(const T&);

        // Decide si un elemento pertenece al conjunto o no.
        bool pertenece(const T&) const;

        // borra un elemento del conjunto. Si éste no existe,
        // el conjunto no se modifica.
        void remover(const T&);

        // devuelve el mínimo elemento del conjunto según <.
        const T& minimo() const;

        // devuelve el máximo elemento del conjunto según <.
        const T& maximo() const;

        // devuelve la cantidad de elementos que tiene el conjunto.
        unsigned int cardinal() const;

        // muestra el conjunto.
        void mostrar(std::ostream&) const;

    private:

        // la representación de un nodo interno.
        struct Nodo
        {
            // el constructor, toma el elemento al que representa el nodo.
            Nodo(const T& v);
            // el elemento al que representa el nodo.
            T valor;
            // puntero a la raíz del subárbol izquierdo.
            Nodo* izq;
            // puntero a la raíz del subárbol derecho.
            Nodo* der; 
        };

        // puntero a la raíz de nuestro árbol.
        Nodo* raiz;

};

template <class T>
Conjunto<T>::Conjunto() : raiz(NULL)
{}

template <class T>
Conjunto<T>::~Conjunto(){ 

    if(raiz != NULL){
        if(raiz->izq != NULL){
            delete raiz->izq;  
        }
        if(raiz->der != NULL){
            delete raiz->der;  
        }
        delete raiz;
    }

}

template <class T>
bool Conjunto<T>::pertenece(const T& clave) const
{
    assert(true);
    bool resultado = false;
    Nodo* recorrido = raiz;
    while(!resultado && recorrido != NULL){
        if(recorrido->valor == clave){
            resultado = true;
        }
        else if(recorrido->valor < clave){
            recorrido = recorrido->der;
        }
        else if(recorrido->valor < clave){
            recorrido = recorrido->izq;
        }
    }
    return resultado;
}

template <class T>
void Conjunto<T>::insertar(const T& clave)
{
    assert(true);
    if(raiz == NULL){
        raiz = new Nodo(clave);
    }
    else{
        Nodo* recorrido = raiz;
        bool finRecorrido = false;
        while(!finRecorrido){
            if(recorrido -> valor < clave && recorrido -> der == NULL){
                recorrido -> der = new Nodo(clave);
                finRecorrido = true;
            }
            else if(recorrido -> valor > clave && recorrido -> izq == NULL){
                recorrido -> izq = new Nodo(clave);
                finRecorrido = true;
            }
            else if(recorrido -> valor < clave ){
                recorrido = recorrido->der;
            }
            else if(recorrido -> valor > clave ){
                recorrido = recorrido->izq;
            }
        }
    }
}

template <class T>
Conjunto<T>::Nodo::Nodo(const T& v)
     : valor(v), izq(NULL), der(NULL)
{}



template <class T>
void Conjunto<T>::remover(const T& v) {
    assert(false);
    Nodo * recorrido = raiz;
    Nodo * aBorrar; 
    bool finRecorrido = false;
    while(!finRecorrido && recorrido != NULL){
        if(recorrido->valor == v){
            aBorrar = recorrido;
            finRecorrido = true;
            if(recorrido -> izq == NULL){
                recorrido = recorrido -> der;
            }
            else if(recorrido ->der == NULL){
                recorrido = recorrido -> izq;
            }
            else{
                Nodo* recorridoAux = recorrido;
                Nodo* aAgregar;
                bool encontreHoja = false;
                while(!encontreHoja){
                    while(recorridoAux -> der != NULL){
                        recorridoAux = recorridoAux -> der;
                    } 
                    while(recorridoAux -> izq != NULL){
                        recorridoAux = recorridoAux -> izq;
                    } 
                    if(recorridoAux -> der == NULL && recorridoAux -> izq == NULL){
                        aAgregar = new Nodo(recorridoAux -> valor);
                        delete recorridoAux;
                        encontreHoja = true;
                    }
                }
                aAgregar -> izq = recorrido -> izq;
                aAgregar -> der = recorrido -> der;
                recorrido = &aAgregar;  //Esto está mal
            }           
        }
        else if(recorrido -> valor < v ){
            recorrido = recorrido->der;
        }
        else if(recorrido -> valor > v ){
            recorrido = recorrido->izq;
        }
    }
}

template <class T>
const T& Conjunto<T>::minimo() const {
    assert(raiz == NULL);
    Nodo* recorrido = raiz;
    while(recorrido->izq = NULL){
        recorrido = recorrido->izq;
    }
    return recorrido->valor;
}
template <class T>
const T& Conjunto<T>::maximo() const {
    assert(raiz == NULL);
    Nodo* recorrido = raiz;
    while(recorrido->der = NULL){
        recorrido = recorrido->der;
    }
    return recorrido->valor;
}

template <class T>
unsigned int Conjunto<T>::cardinal() const {
    assert(raiz == NULL);
    unsigned int resultado = 0;
    if(raiz != NULL){
        resultado = 1 + raiz->izq->cardinal() + raiz->der->cardinal();
    }   
    return resultado;
}

template <class T>
void Conjunto<T>::mostrar(std::ostream& os) const {
    assert(false);
}


#endif // CONJUNTO_HPP_
