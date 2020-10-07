#include <iostream>
#include "pelicula.h"
#include <fstream>

Pelicula::Pelicula(Nombre n,Lista<Genero> gs,Lista<Actor> as, bool b){
    nombre_=n;
    generos_=gs;
    actores_=as;
    es3D_=b;
}

Nombre Pelicula::nombreP() const{
    return nombre_;
}

Lista<Genero> Pelicula::generosP() const{
    return generos_;
}

Lista<Actor> Pelicula::actoresP() const{
    return actores_;
}

bool Pelicula::es3DP() const{
    return es3D_;
}

void Pelicula::mostrar(std::ostream& os) const{
    os<<"P |"<<nombre_<<"| ";
    os<<"[";
    int i=1;
    if(generos_.pertenece(Aventura)){
        os<<"|Aventura|";
        if(generos_.longitud()>i){
            os<<",";
            i++;
        }
    }
    if(generos_.pertenece(Comedia)){
        os<<"|Comedia|";
        if(generos_.longitud()>i){
            os<<",";
            i++;
        }
    }
    if(generos_.pertenece(Drama)){
        os<<"|Drama|";
        if(generos_.longitud()>i){
            os<<",";
            i++;
        }
    }
    if(generos_.pertenece(Romantica)){
        os<<"|Romantica|";
        if(generos_.longitud()>i){
            os<<",";
            i++;
        }
    }
    if(generos_.pertenece(Terror)){
        os<<"|Terror|";
        if(generos_.longitud()>i){
            os<<",";
            i++;
        }
    }
    os<<"] ";
    os << "[";
    i = 0;
    while(i < actores_.longitud()){
        os << "|";
        os << actores_.iesimo(i);
        os << "|";
        if ( i+1 < actores_.longitud() ){
            os << ",";
        }
        i++;
    }
    os<<"] ";
    os<<es3D_;
}

void Pelicula::guardar(std::ostream& salida) const{
    salida << "P |"<<nombre_<<"| ";
    salida << "[";
    int i=1;
    if(generos_.pertenece(Aventura)){
        salida<<"|Aventura|";
        if(generos_.longitud()>i){
            salida<<",";
            i++;
        }
    }
    if(generos_.pertenece(Comedia)){
        salida<<"|Comedia|";
        if(generos_.longitud()>i){
            salida<<",";
            i++;
        }
    }
    if(generos_.pertenece(Drama)){
        salida<<"|Drama|";
        if(generos_.longitud()>i){
            salida<<",";
            i++;
        }
    }
    if(generos_.pertenece(Romantica)){
        salida<<"|Romantica|";
        if(generos_.longitud()>i){
            salida<<",";
            i++;
        }
    }
    if(generos_.pertenece(Terror)){
        salida<<"|Terror|";
        if(generos_.longitud()>i){
            salida<<",";
            i++;
        }
    }
    salida << "]";
    salida << " ";
    salida << "[";
    i = 0;
    while(i < actores_.longitud()){
        salida << "|";
        salida << actores_.iesimo(i);
        salida << "|";
        if ( i+1 < actores_.longitud() ){
            salida << ",";
        }
        i++;
    }
    salida << "] ";
    if(es3D_ == true)
        salida << 'V';
    else
        salida << 'F';
}

void Pelicula::cargar(std::istream& is){
    char c;
    string d;
    Actor a;
    Lista<Genero> gf;
    Lista<Actor> af;
    is>>c;
    is>>c;
    getline(is,nombre_,'|');
    is>>c;
    if (is.peek() != ']'){
        while(c != ']'){
            is>>c;
            getline(is,d,'|');
            if(d=="Aventura"){
              gf.agregarAtras(Aventura);
            }
            else if(d=="Comedia"){
              gf.agregarAtras(Comedia);
            }
            else if(d=="Drama"){
              gf.agregarAtras(Drama);
            }
            else if(d=="Romantica"){
              gf.agregarAtras(Romantica);
            }
            else if(d=="Terror"){
              gf.agregarAtras(Terror);
            }
        is>>c;
        }
    }
    is>>c;
    if (is.peek() != ']'){
        while(c != ']'){
            is>>c;
            getline(is,a,'|');
            af.agregarAtras(a);
            is>>c;
        }
    }
    is>>c;
    if(c == 'V')
        es3D_ = true;
    else
        es3D_ = false;
    generos_ =gf;
    actores_=af;
}

std::ostream & operator<<(std::ostream & os,const Pelicula & p){
    p.guardar(os);
    return os;
}

std::istream & operator>>(std::istream & is, Pelicula & p){
    p.cargar(is);
    return is;
}

Lista<Pelicula> sacarPeliculasDeGenero(Lista<Pelicula> gp,Genero g){
    int i=0;
    Lista<Pelicula> ps;
    while(i<gp.longitud()){
        if(((gp.iesimo(i)).generosP()).pertenece(g)){
            ps.agregar(gp.iesimo(i));
        }
    i++;
    }
    return ps;
}

Lista<std::pair<Genero,Lista<Pelicula> > > Pelicula::agruparPelisPorGeneroP(Lista<Pelicula> ps) const{
    Lista<std::pair<Genero,Lista<Pelicula> > > l;
    std::pair<Genero,Lista<Pelicula> > pe;
    if(sacarPeliculasDeGenero(ps,Aventura).longitud()>0){
        pe.first=Aventura;
        pe.second=sacarPeliculasDeGenero(ps,Aventura);
        l.agregar(pe);
    }
    if(sacarPeliculasDeGenero(ps,Comedia).longitud()>0){
        pe.first=Comedia;
        pe.second=sacarPeliculasDeGenero(ps,Comedia);
        l.agregar(pe);
    }
    if(sacarPeliculasDeGenero(ps,Terror).longitud()>0){
        pe.first=Terror;
        pe.second=sacarPeliculasDeGenero(ps,Terror);
        l.agregar(pe);
    }
    if(sacarPeliculasDeGenero(ps,Drama).longitud()>0){
        pe.first=Drama;
        pe.second=sacarPeliculasDeGenero(ps,Drama);
        l.agregar(pe);
    }
    if(sacarPeliculasDeGenero(ps,Romantica).longitud()>0){
        pe.first=Romantica;
        pe.second=sacarPeliculasDeGenero(ps,Romantica);
        l.agregar(pe);
    }
    return l;
}

Lista<Actor>sacarRepA(Lista<Actor> e){
    int i=0;
    Lista<Actor> a;
    while(i<e.longitud()){
        if(e.cantidadDeApariciones(e.iesimo(i))>1 && a.pertenece(e.iesimo(i))){
        }
        else if(e.cantidadDeApariciones(e.iesimo(i))>1 ){
            a.agregar(e.iesimo(i));
        }
        else{
            a.agregar(e.iesimo(i));
        }
    i++;
    }
    return a;
}

Lista<Genero>sacarRepG(Lista<Genero> e){
    int i=0;
    Lista<Genero> a;
    while(i<e.longitud()){
        if(e.cantidadDeApariciones(e.iesimo(i))>1 && a.pertenece(e.iesimo(i))){
        }
        else if(e.cantidadDeApariciones(e.iesimo(i))>1 ){
            a.agregar(e.iesimo(i));
        }
        else{
            a.agregar(e.iesimo(i));
        }
    i++;
    }
    return a;
}

Lista<Pelicula>Pelicula::generarSagaDePeliculasP(Lista<Actor> as, Lista<Genero> gs, Lista<Nombre> nombres) const{
    int i=0;
    Lista<Pelicula> p;
    while(i<nombres.longitud()){
        p.agregar(Pelicula(nombres.iesimo(i),sacarRepG(gs),sacarRepA(as),false));
        i++;
    }
    return p;
}
