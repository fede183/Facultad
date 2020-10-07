#ifndef AVL_H_
#define AVL_H_

#include <iostream>
#include <cassert>
using namespace std;

template<typename T>
class Avl{

  public:
	
	Avl();

	Avl(const Avl<T>&);

	~Avl();

	Avl<T>& operator=(const Avl<T>&);

	int DarAltura();

	void agregar(const T&);

	void eliminar(const T&);

	bool esta(const T&);

	bool operator==(const Avl<T>&) const;

	ostream& mostrarAvlInorden(ostream&) const;

	ostream& mostrarAvlPreorden(ostream&) const;

	ostream& mostrarAvlPostorden(ostream&) const;

	int DarOrden();

	void ordenar();

  private:

struct Nodo
{
	T dato;
	Avl* izq;
	Avl* der;
	Nodo(const T& d): dato(d), izq(NULL), der(NULL){

	}
};
	int altura;
	Nodo* raiz;
	
};

template<class T>
ostream& operator<<(ostream& out, const Avl<T>& a) {
	return a.mostrarAvl(out);
}

template<typename T>
Avl<T>::Avl(): raiz(NULL), altura(0){}

template<typename T>
Avl<T>::Avl(const Avl<T>& c){
	altura = c.altura;
	if(c.raiz == NULL){
		raiz = NULL;
	}
	else{
		raiz = new Nodo(c.dato);
		if(c.raiz->izq != NULL){
			izq(c.raiz->izq);
		}
		if(c.raiz->der != NULL){
			der(c.raiz->der);
		}

	}
}

template<typename T>
Avl<T>::~Avl(){
	if(raiz != NULL){
		Avl* recorridoIzq = raiz->izq;
		Avl* recorridoDer = raiz->der;
		raiz->izq = NULL;
		raiz->der = NULL;

		if(recorridoIzq != NULL){
			delete recorridoIzq;
		}
		if(recorridoDer !=NULL){
			delete recorridoDer;
		}
		delete raiz;
	}
}

template<typename T>
Avl<T>& Avl<T>::operator=(const Avl<T>& a){
	this(a);
}


template<typename T>
bool Avl<T>::operator==(const Avl<T>& c) const{
	bool resul = (altura == c.altura);

	if((raiz == NULL) != (c.raiz == NULL)){
		resul = false;
	}
	else if(raiz != NULL){
		resul = resul && (raiz->dato == c.raiz->dato);

		if(raiz->izq != NULL){
			resul = resul && (raiz->izq == c.raiz->izq);
		}
		if(raiz->der != NULL){
			resul = resul && (raiz->der == c.raiz->der);
		}
	}

	return resul;
}

template<typename T>
ostream& Avl<T>::mostrarAvlInorden(ostream& os) const{
	if(raiz->izq != NULL){
		raiz->izq.mostrarAvlInorder(os);
	}
	os << raiz->dato;
	if(raiz->der != NULL){
		raiz->der.mostrarAvlInorder(os);
	}
}

template<typename T>
ostream& Avl<T>::mostrarAvlPreorden(ostream& os) const{
	
	os << raiz->dato;
	if(raiz->izq != NULL){
		raiz->izq.mostrarAvlInorder(os);
	}
	if(raiz->der != NULL){
		raiz->der.mostrarAvlInorder(os);
	}
}

template<typename T>
ostream& Avl<T>::mostrarAvlPostorden(ostream& os) const{
	if(raiz->izq != NULL){
		raiz->izq.mostrarAvlInorder(os);
	}
	if(raiz->der != NULL){
		raiz->der.mostrarAvlInorder(os);
	}
	os << raiz->dato;
	
}

template<typename T>
bool Avl<T>::esta(const T& t){
	bool resul = false;
	
	if(raiz != NULL){
		resul = resul || (t == raiz->dato);

		if(raiz->izq != NULL && raiz->izq->dato > t){
			resul = resul || (raiz->izq->esta(t));
		}
		if(raiz->der != NULL && raiz->izq->dato < t){
			resul = resul || (raiz->der->esta(t));
		}

	}
	
	return resul;
}

template<typename T>
int Avl<T>::DarAltura(){
	return altura;
}

template<typename T>
int Avl<T>::DarOrden(){
	int resul;
	if(raiz->izq == NULL && raiz->der == NULL){
		resul = 0;
	}
	else if(raiz->izq == NULL){
		resul = raiz->der->altura;
	}
	else if(raiz->der == NULL){
		resul = raiz->izq->altura;
	}
	else{
		resul = raiz->der->altura - raiz->izq->altura;
	}
	return resul;
}

template<typename T>
void Avl<T>::agregar(const T& t){
	if(altura == 0){
		raiz = new Nodo(t);
	}
	else if(raiz->dato<t && raiz->izq == NULL){
		raiz->izq = new Avl;
		raiz->izq->raiz = new Nodo(t);
	}
	else if(raiz->dato>t && raiz->der == NULL){
		raiz->izq = new Avl;
		raiz->izq->raiz = new Nodo(t);
	}
	else if(raiz->dato<t){
		raiz->izq->agregar(t);
	}
	else{
		raiz->der->agregar(t);
	}

	if(raiz->izq == NULL && raiz->der == NULL){
		altura++;
	}
	else if(raiz->izq == NULL){
		altura = raiz->der->altura + 1;
	}
	else if(raiz->der == NULL){
		altura = raiz->izq->altura + 1;
	}
	else if(raiz->izq->altura < raiz->der->altura){
		altura = raiz->der->altura + 1;
	}
	else{
		altura = raiz->izq->altura + 1;
	}	
	this->ordenar();
}

template<typename T>
void Avl<T>::ordenar(){
	if(DarOrden() == -2){
		Avl *Q = raiz->izq;
		if(Q->DarOrden() == -1){
			raiz->izq = Q->raiz->der;
			Q->raiz->der = this;
			raiz = Q->raiz;
		}
		else{
			Avl *R = Q->raiz->der;
			if(R->DarOrden() == 1){
				Q->raiz->der = R->raiz->der;
				this->raiz->izq = R->raiz->izq;
				R->raiz->izq = Q;
				R->raiz->der = this;
				raiz = R->raiz;
			}
			else{
				Q->raiz->der = R->raiz->izq;
				this->raiz->izq = R->raiz->der;
				R->raiz->izq = Q;
				R->raiz->der = this;
				raiz = R->raiz;
			}
		}
	}
	else if(DarOrden() == 2){
		Avl *Q = raiz->der;
		if(Q->DarOrden() == 1){
			this->raiz->der = Q->raiz->izq;
			Q->raiz->izq = this;
			raiz = Q->raiz;
		}
		else{
			Avl *R = Q->raiz->izq;
			if(R->DarOrden() == 1){
				Q->raiz->izq = R->raiz->der;
				this->raiz->der = R->raiz->izq;
				R->raiz->der = Q;
				R->raiz->izq = this;
				raiz = R->raiz;
			}
			else{
				Q->raiz->izq = R->raiz->izq;
				this->raiz->der = R->raiz->der;
				R->raiz->der = Q;
				R->raiz->izq = this;
				raiz = R->raiz;
			}
		}
	}
}

template<typename T> 
void Avl<T>::eliminar(const T& t){
	if(raiz->dato != t){
		if(t < raiz->dato){
			raiz->izq->eliminar(t);
		}
		else{
			raiz->der->eliminar(t);
		}
	}
	else{
		Avl* aBorrar = this;
		if(raiz->izq == NULL && raiz->der == NULL){

		}
		else if(raiz->izq == NULL){
			this = this->raiz->der;
		}
		else if(raiz->der == NULL){
			this = this->raiz->izq;
		}
		else{

		}
		delete aBorrar;
	}
	this->ordenar();
}

#endif //AVL_H_