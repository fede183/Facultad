#include "Driver.h"
#include "ArbolSintactico.h"

namespace aed2 {

Driver::Driver(){
    // TODO
    _ID = 0;   //El primer paquete va a tener id igual a 0.
    driver_dcnet = NULL;        
}

Driver::~Driver() {
    // TODO
    if(driver_dcnet != NULL){           //Si esta inicializado el driver_dcnet lo borro.
        delete driver_dcnet;
    }
    
    for(Nat i = 0; i < ListaPaquetesABorrar.Longitud(); i++){  //Borro cada uno de los paquetes que cree.
        delete ListaPaquetesABorrar[i];
    }
}

// TAD RED
Nat Driver::CantidadComputadoras() {
    // TODO
    return driver_red.Computadoras().Cardinal();

}

const Computadora& Driver::IesimaComputadora(const Nat i) {
    // TODO
    typename Conj<compu>::const_Iterador iter = driver_red.Computadoras().CrearIt();
    Nat j = i;
    while(j > 0){
        iter.Avanzar();
        j--;
    }
    return iter.Siguiente().hostname;
}
        
Nat Driver::CantidadInterfacesDe(const Computadora& c) {
    // TODO
    typename Conj<compu>::const_Iterador iter = driver_red.Computadoras().CrearIt();
    while(iter.Siguiente().hostname != c){
        iter.Avanzar();
    }
    return iter.Siguiente().interfaces.Cardinal();

}

const Interfaz& Driver::IesimaInterfazDe(const Computadora& c, const Nat i){
    // TODO
    typename Conj<compu>::const_Iterador iter = driver_red.Computadoras().CrearIt();

    while(iter.Siguiente().hostname != c){
        iter.Avanzar();
    }
    typename Conj<interfaz>::const_Iterador interfazIter = iter.Siguiente().interfaces.CrearIt();
    Nat j = i;
    while(j > 0){
        interfazIter.Avanzar();
        j--;
    }
    return interfazIter.Siguiente();

} 

const Interfaz& Driver::IntefazUsada(const Computadora& c1, const Computadora& c2)  {
    // TODO

    return driver_red.interfazUsada(*CompusPorHostname.obtener(c1), *CompusPorHostname.obtener(c2));

}

bool Driver::conectadas(const Computadora& c1, const Computadora& c2)  {
    // TODO

    return driver_red.Conectadas((*CompusPorHostname.obtener(c1)), (*CompusPorHostname.obtener(c2)));
}

// TAD DCNET
void Driver::AgregarComputadora(const Computadora& ip, const Conj<Interfaz>& ci) {
    // TODO
    compu c(ip, ci);                //Creo la compu con el ip y las interfaces
    CompusPorHostname.definir(ip, c);   //La agrego al DiccString para poder acceder a su estructura.
    driver_red.AgregarComputadora(c);       //La agrego a la red.
}
        
void Driver::Conectar(const Computadora& c1, const Interfaz& i1, const Computadora& c2, const Interfaz& i2) {
    // TODO
    return driver_red.Conectar(*CompusPorHostname.obtener(c1), *CompusPorHostname.obtener(c2), i1, i2);
}
    
    
Nat Driver::CantidadNodosRecorridosPor(const Paquete& p) {
    // TODO
    return driver_dcnet->CaminoRecorrido(TodosLosPaquetes.SignificadoNat(p)).Longitud();
}

const Computadora Driver::IesimoNodoRecorridoPor(const Paquete& p, const Nat i)  {
    // TODO
    string resu = (driver_dcnet->CaminoRecorrido(TodosLosPaquetes.SignificadoNat(p)))[i].hostname;
    return resu;
}

Nat Driver::CantidadEnviadosPor(const Computadora& c) {
    // TODO
    return driver_dcnet->CantidadEnviados(*CompusPorHostname.obtener(c));
}
    
Nat Driver::CantidadEnEsperaEn(const Computadora& c) {
    // TODO
    return driver_dcnet->EnEspera(*CompusPorHostname.obtener(c)).cantidad();
}

Nat Driver::IesimoEnEsperaEn(const Computadora& c, const Nat i) {
    // TODO 
    return ((driver_dcnet->EnEspera(*CompusPorHostname.obtener(c)).aLista())[i]).id;
}

void Driver::CrearPaquete(const Computadora& origen, const Computadora& destino, Nat prioridad) {
    // TODO
    if(driver_dcnet == NULL){                   //Tenemos que definir la dcnet usando la red, esta no se modificara en el futuro, en 
                                                //el caso que no este definida.
        driver_dcnet = new DCNet(driver_red);
    }
    paquete* p1 = new paquete((*CompusPorHostname.obtener(origen)), (*CompusPorHostname.obtener(destino))); //Creo el paquete con su 
                                                    //compu origen y destino.
    p1->id = _ID;
    _ID ++;                                         //Aumento el contador de los id. Con esto me aseguro que el siguiente paquete no   
                                                    //tendra la misma id que este.
    p1->prioridad = prioridad;                      //Le asigno la prioridad al paquete.
    TodosLosPaquetes.DefinirNat(p1->id, *p1);       //Guardo la referencia del paquete en TodosLosPaquetes para poder tener un rapido
                                                    //aceso a ella
    driver_dcnet->CrearPaquete(*p1);            //Creo el paquete en el dcnet.
    ListaPaquetesABorrar.AgregarAtras(p1);   //Me aseguro que el puntero a paquete sea liberado cuando el driver se destruya.
}
        
void Driver::AvanzarSegundo() {
    // TODO
    if(driver_dcnet == NULL){                       //Tenemos que definir la dcnet usando la red, esta no se modificara en el futuro.
        driver_dcnet = new DCNet(driver_red);
    }
    driver_dcnet->AvanzarSegundo();
}
        
const Computadora& Driver::laQueMasEnvio() const {
    // TODO 
    return (driver_dcnet->LaQueMasEnvio()).hostname;
}

const Computadora& Driver::origen(const Paquete& p) const {
    // TODO 
    
    return TodosLosPaquetes.SignificadoNat(p).origen.hostname;
} 

const Computadora& Driver::destino(const Paquete& p) const { 
    // TODO 
    return TodosLosPaquetes.SignificadoNat(p).destino.hostname;
}

Nat Driver::prioridad(const Paquete& p) const { 
    // TODO 
    return TodosLosPaquetes.SignificadoNat(p).prioridad;
}
        

} // namespace aed2
