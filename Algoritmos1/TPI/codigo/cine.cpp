#include <iostream>
#include "cine.h"
#include <fstream>
using namespace std;

Cine::Cine(Nombre n){
    nombre_ = n;
}

string Cine::nombreC() const{
    return nombre_;
}

Lista<Pelicula> Cine::peliculasC() const{
    Lista<Pelicula> p;
    int i=0;
    while(i<peliculas_.longitud()){
        p.agregar(peliculas_.iesimo(i).first);
        i++;
    }
    return p;
}

Lista<Sala> Cine::salasC() const{
    Lista<Sala> p;
    int i=0;
    while(i<peliculas_.longitud()){
        p.agregar(peliculas_.iesimo(i).second);
        i++;
    }
    p.concatenar(salasSinUsar_);
    return p;
}

Sala Cine::salaC(const Nombre &p) const{
    int i=0;
    int d;
    while(i<peliculas_.longitud()){
        if(peliculas_.iesimo(i).first.nombreP()==p){
            d=i;
        }
        i++;
    }
    return peliculas_.iesimo(d).second;
}

int Cine::espectadoresC(Sala s) const{
    int i=0;
    int d;
    while(i<espectadores_.longitud()){
        if(espectadores_.iesimo(i).first==s){
            d=i;
        }
        i++;
    }
    return espectadores_.iesimo(d).second;
}

Lista<pair<Sala,int> > salasConTicket(Lista<Ticket> hg, Lista<pair<Pelicula,Sala> > s){
    int i=0;
    Lista<std::pair<Sala,int> > fd;
    std::pair<Sala,int> gf;
    while(i<s.longitud()){
        Ticket t(s.iesimo(i).first,s.iesimo(i).second,false);
        gf.first=s.iesimo(i).second;
        gf.second=hg.cantidadDeApariciones(t);
        fd.agregarAtras(gf);
        i++;
    }
    return fd;
}

void Cine::mostrar(std::ostream& os) const{
    os<<"C |"<<nombre_<<"| "<<salasSinUsar_<<" "<<espectadores_<<" "<<salasConTicket(ticketsVendidos_,peliculas_)<<" [";
    int i=0;
    while(i<peliculas_.longitud()){
        os<<"(";
        os<<peliculas_.iesimo(i).second<<","<<peliculas_.iesimo(i).first<<")";
        if(i+1<peliculas_.longitud()){
            os<<",";
        }
        i++;
    }
    os<<"]";
}

void Cine::guardar(std::ostream& os) const{
    int i=0;
    os<<"C |"<<nombre_<<"| ";
    os<<salasSinUsar_;
    os<<" ";
    os<<espectadores_<<" ";
    os<<salasConTicket(ticketsVendidos_,peliculas_);
    os<<" [";
    while(i<peliculas_.longitud()){
        os<<"(";
        os<<peliculas_.iesimo(i).second<<",("<<peliculas_.iesimo(i).first<<"))";
        if(i+1<peliculas_.longitud()){
            os<<",";
        }
    i++;
    }
    os<<"]";
}

Pelicula Cine::peliculaC(Sala s) const{
    int i=0,e=-1;
    while(peliculas_.longitud()>i && e==-1){
        if(peliculas_.iesimo(i).second==s){
            e=i;
        }
        i++;
    }
    return peliculas_.iesimo(e).first;
}

void Cine::cargar(std::istream& is){
    char c;
    int i,j,k;
    Sala s;
    Lista<Sala> salas;
    std::pair<Sala, int> eps;
    Lista<std::pair<Sala, int> > epss;
    std::pair<int, int> tps;
    Lista<std::pair<int, int> > tpss;
    pair<Pelicula,Sala> ps;
    Lista<pair<Pelicula,Sala> > pss;
    Ticket t;
    is>>c;
    is>>c;
    getline(is,nombre_,'|');
    is>>c;
    if (is.peek() != ']'){
        while(c!=']'){
            is>>s;
            salas.agregarAtras(s);
            is>>c;
        }
    }
    else
        is>>c;
    salasSinUsar_ = salas;
    is>>c;
    if (is.peek() != ']'){
        while(c!=']'){
            is>>c;
            is>>eps.first;
            is>>c;
            is>>eps.second;
            epss.agregarAtras(eps);
            is>>c;
            is>>c;
        }
    }
    espectadores_ = epss;
    is>>c;
    if (is.peek() != ']'){
        while(c!=']'){
            is>>c;
            is>>tps.first;
            is>>c;
            is>>tps.second;
            tpss.agregarAtras(tps);
            is>>c;
            is>>c;
        }
    }
    is>>c;
    if (is.peek() != ']'){
        while(c!=']'){
            is>>c;
            is>>ps.second;
            is>>c;
            is>>c;
            ps.first.cargar(is);
            is>>c;
            pss.agregarAtras(ps);
            is>>c;
            is>>c;
        }
    }
    peliculas_ = pss;
    i = 0;
    while(i < tpss.longitud()){
        if (tpss.iesimo(i).second != 0){
            j = 0;
            while(j < pss.longitud()){
                if(pss.iesimo(j).second == tpss.iesimo(i).first){
                    k = 0;
                    while(k < tpss.iesimo(i).second){
                        t = Ticket(pss.iesimo(j).first, pss.iesimo(j).second, false);
                        ticketsVendidos_.agregarAtras(t);
                        k++;
                    }
                }
                j++;
            }
        }
        i++;
    }
    while(i < epss.longitud()){
        if (epss.iesimo(i).second != 0){
            j = 0;
            while(j < pss.longitud()){
                if(pss.iesimo(j).second == tpss.iesimo(i).first){
                    k = 0;
                    while(k < epss.iesimo(i).second){
                        t = Ticket(pss.iesimo(j).first, pss.iesimo(j).second, true);
                        ticketsVendidos_.agregarAtras(t);
                        k++;
                    }
                }
                j++;
            }
        }
        i++;
    }
}

Lista<Ticket> Cine::ticketsVendidosSinUsarC() const{
    int i=0;
    Lista<Ticket> d;
    while(i<ticketsVendidos_.longitud()){
        if(ticketsVendidos_.iesimo(i).usadoT()==false){
            d.agregar(ticketsVendidos_.iesimo(i));
        }
        i++;
    }
    return d;
}

void Cine::abrirSalaC(Sala s){
    std::pair<Sala, int> k;
    k.first = s;
    k.second = 0;
    salasSinUsar_.agregar(s);
    espectadores_.agregar(k);
}

void Cine::agregarPeliculaC(const Pelicula &c, Sala s){
    std::pair<Pelicula, Sala> d;
    d.first=c;
    d.second=s;
    int i=0;
    while(i<salasSinUsar_.longitud()){
        if(salasSinUsar_.iesimo(i)==s){
            salasSinUsar_.eliminarPosicion(i);
        }
    i++;
    }
    peliculas_.agregar(d);
}

void Cine::cerrarSalaC(Sala s){
    int i=0, e=0, n=0;
    bool res1=true, res2=true, res3=false;
    if(salasSinUsar_.pertenece(s)){
        salasSinUsar_.sacar(s);
        while(res1==true&&(ticketsVendidos_.longitud()<e)){
            if(ticketsVendidos_.iesimo(e).salaT()==s){
                res1=false;
                espectadores_.sacar(espectadores_.iesimo(e));
            }
            e++;
        }
    }
    else if(salasC().pertenece(s)){
        while(res1){
            if(peliculas_.iesimo(i).second==s){
                peliculas_.sacar(peliculas_.iesimo(i));
                res1=false;
                while(res2){
                    if(espectadores_.iesimo(e).first==s){
                        res2=false;
                        espectadores_.sacar(espectadores_.iesimo(e));
                        while(res3 && n<ticketsVendidos_.longitud()){
                            if(ticketsVendidos_.iesimo(n).salaT()==s){
                                res2=false;
                                ticketsVendidos_.sacar(ticketsVendidos_.iesimo(n));
                            }
                            n++;
                        }
                    }
                    e++;
                }
            }
        i++;
        }
    }
}

void Cine::cerrarSalasC(int e){
    int i=0;
    while(i<espectadores_.longitud()){
        if(espectadores_.iesimo(i).second<e){
            cerrarSalaC(espectadores_.iesimo(i).first);
        }
        i++;
    }
}

void Cine::cerrarSalasDeLaCadenaC(Lista<Cine> &cs, int e) const{
    int i=0;
    Lista<Cine> ct;
    while(cs.longitud()>i){
        Cine c(cs.iesimo(i));
        c.cerrarSalasC(e);
        ct.agregarAtras(c);
        i++;
    }
    i=0;
    while(ct.longitud()>i){
        cs.eliminarPosicion(0);
        cs.agregarAtras(ct.iesimo(i));
        i++;
    }
}

Pelicula peliConNombre(Lista<Pelicula> pc, Nombre p){
    int e=0, i=-1;
    while(e<pc.longitud()&& i==-1){
        if(pc.iesimo(e).nombreP()==p){
            i=e;
        }
        e++;
    }
    return pc.iesimo(i);
}

Ticket Cine::venderTicketC(const Nombre &p){
    Ticket t(peliConNombre(peliculasC(),p),salaC(p),false);
    ticketsVendidos_.agregar(t);
    return t;
}

Ticket Cine::ingresarASalaC(Sala s, const Ticket &t){
    int i=0;
    bool fd=true;
    Ticket t1(peliculaC(s),s,true);
    std::pair<Sala,int> sd;
    sd.first=s;
    while(i<espectadores_.longitud()&&fd){
        if(espectadores_.iesimo(i).first==s){
            sd.second=espectadores_.iesimo(i).second+1;
            espectadores_.eliminarPosicion(i);
            espectadores_.agregar(sd);
            fd=false;
        }
        i++;
    }
    i=0;
    fd=true;
    while(i<ticketsVendidos_.longitud()&&fd){
        if(ticketsVendidos_.iesimo(i)==t){
            ticketsVendidos_.eliminarPosicion(i);
            ticketsVendidos_.agregar(t1);
            fd=false;
        }
        i++;
    }
    return t1;
}

Pelicula Cine::pasarA3DUnaPeliculaC(Nombre n){
    Pelicula ps(n,peliConNombre(peliculasC(),n).generosP(),peliConNombre(peliculasC(),n).actoresP(),true);
    Ticket t(peliConNombre(peliculasC(),n),salaC(n),false);
    int i=0;
    bool fd=true;
    pair<Pelicula,Sala> ds;
    ds.first=ps;
    ds.second=salaC(n);
    while(i<peliculas_.longitud()&&fd){
        if(peliculas_.iesimo(i).second==salaC(n)){
            peliculas_.eliminarPosicion(i);
            peliculas_.agregar(ds);
            fd=false;
        }
        i++;
    }
    i=0;
    fd=true;
    int e;
    while(i<ticketsVendidos_.longitud()&&fd){
        if(ticketsVendidos_.iesimo(i)==t){
            e=ticketsVendidos_.cantidadDeApariciones(t);
            ticketsVendidos_.sacar(t);
            t.usarT();
            while(e>0){
                ticketsVendidos_.agregar(t);
                e--;
            }
            fd=false;
        }
        i++;
    }
    return ps;
}

std::ostream & operator<<(std::ostream & os, const Cine & c){
    c.guardar(os);
    return os;
}

std::istream & operator>>(std::istream & is, Cine& c){
    c.cargar(is);
    return is;
}
