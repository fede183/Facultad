#include <iostream>
#include "ticket.h"
#include <fstream>
using namespace std;

Ticket::Ticket(const Pelicula &p, Sala s, bool u){
	sala_=s;
	usado_=u;
	pelicula_=p;
}

const Pelicula& Ticket::peliculaT() const{
      return pelicula_;
}

Sala Ticket::salaT() const{
      return sala_;
}

bool Ticket::usadoT() const{
      return usado_;
}

void Ticket::usarT(){
    usado_=true;
}

void Ticket::mostrar(std::ostream& os) const{
    os<<"T ("<<pelicula_<<") "<<sala_<<" "<<usado_;
}

void Ticket::guardar(std::ostream& os) const{
    os<<"T ("<<pelicula_<<") "<<sala_<<" ";
    if(usado_ == true)
        os<<'V';
    else
        os<<'F';
}

void Ticket::cargar(std::istream& is){
    Pelicula p;
    char c;
    is>>c;
    is>>c;
    p.cargar(is);
    is>>c;
    is>>sala_;
    is>>c;
    if(c == 'V')
        usado_ = true;
    else
        usado_ = false;
    pelicula_=p;
}

std::ostream & operator<<(std::ostream & os,const Ticket & t){
    t.guardar(os);
    return os;
}

std::istream & operator>>(std::istream & is, Ticket & t){
    t.cargar(is);
    return is;
}

bool minimaCantidadDeApariciones(Lista<Pelicula> ps, Pelicula p){
    int e=0;
    while(e<ps.longitud()&&(ps.cantidadDeApariciones(ps.iesimo(e))>= ps.cantidadDeApariciones(p))){
        e++;
    }
    return e==ps.longitud();
}

Pelicula Ticket::peliculaMenosVistaT(const Lista<Ticket> &ts) const{
    Lista<Pelicula> p;
    int i=0, d=0;
    while(i<ts.longitud()){
        if(ts.iesimo(i).usado_){
            p.agregar(ts.iesimo(i).peliculaT());
        }
        i++;
    }
    i=0;
    while(i<ts.longitud()){
        if(minimaCantidadDeApariciones(p, p.iesimo(i))){
            d=i;
        }
        i++;
    }
    return p.iesimo(d);
}

bool todosIgualesInt(Lista<int> i){
    int e=0;
    bool res;
    if(i.longitud()==1){
     res=true;
    }
    else{
        while(e<i.longitud()-1 && i.iesimo(e)==i.iesimo(e+1)){
            e++;
        }
        res=(e==i.longitud()-1);
    }
    return res;
 }

bool Ticket::todosLosTicketsParaLaMismaSalaT(const Lista<Ticket> &ts) const{
    int i=0;
    Lista<int> g33;
    while(i<ts.longitud()){
        g33.agregar(ts.iesimo(i).sala_);
        i++;
    }
    return todosIgualesInt(g33);
}

Lista<Ticket> Ticket::cambiarSalaT(const Lista<Ticket> &ts, Sala vieja, Sala nueva) const{
    int i=0;
    Lista<Ticket> y;
    while(i<ts.longitud()){
        if(ts.iesimo(i).sala_==vieja){
            y.agregarAtras(Ticket(ts.iesimo(i).pelicula_, nueva, ts.iesimo(i).usado_));
        }
        else{
            y.agregarAtras(ts.iesimo(i));
        }
        i++;
    }
    return y;
}
