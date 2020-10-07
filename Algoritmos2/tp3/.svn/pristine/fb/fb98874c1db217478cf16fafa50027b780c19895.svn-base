#include "dcnet.h"

DCNet::DCNet(Red& r) : _red(r){
    typename Conj<compu>::const_Iterador iteradorCompu = _red.Computadoras().CrearIt();
    _laQueMasEnvio = NULL;
    if(iteradorCompu.HaySiguiente()){
        _laQueMasEnvio = &iteradorCompu.Siguiente(); // CONSULTAR!!!!
    }
    while(iteradorCompu.HaySiguiente()){
        Nat i = 0;
        _cantEnviados.definir(iteradorCompu.Siguiente().hostname, i);// cambiar _cantEnviados por enviados
        Heap<paquete> Aux; // ver que onda
        _enEspera.definir(iteradorCompu.Siguiente().hostname, Aux); 
        iteradorCompu.Avanzar();
    }
}

DCNet::~DCNet(){
    _laQueMasEnvio = NULL;
}

void DCNet::CrearPaquete(const paquete& p){

    _enEspera.obtener(p.origen.hostname)->encolar(p);  
}


void DCNet::AvanzarSegundo(){

    Lista<tupla> listaAEnviar;          //Lista de tuplas, estas me dicen el hostname de la compu a la que le debo asignar algun paquete.
    typename Conj<compu>::Iterador itCompu = _red.Computadoras().CrearIt();
    while(itCompu.HaySiguiente()){
        if(!(_enEspera.obtener(itCompu.Siguiente().hostname)->vacia())){        //Si no tengo nada que desencolar entonces no entro.

            //Aca busco la cantidad de paquetes enviados que tenia la computadora y le sumo 1, dado que ahora se que va a enviar uno.
            Nat i = (*_cantEnviados.obtener(itCompu.Siguiente().hostname)) + 1 ; 
            _cantEnviados.definir(itCompu.Siguiente().hostname, i);
            //En el caso que la computadora actual alla enviado mas paquetes que la que mas envio, tengo que cambiar _laQueMasEnvio.
            if( *(_cantEnviados.obtener(itCompu.Siguiente().hostname)) >= *(_cantEnviados.obtener(_laQueMasEnvio->hostname))){
                _laQueMasEnvio = &(itCompu.Siguiente());
            }

            //Obtiene el paquete que quiere enviar de su cola de prioridad y lo desencola.
            const paquete aEnviar = _enEspera.obtener(itCompu.Siguiente().hostname)->proximo();
            _enEspera.obtener(itCompu.Siguiente().hostname)->desencolar(); 

            //Tenemos dos casos:
            //El primero es cuando el paquete no esta en el origen.
            //Y el otro es cuando si esta.
            //Para ambos casos lo que hago es hacerme una tupla que tenga el hostname de la computadora a la que enviar el paquete
            //y el mismo paquete.
            if( _paquetesEnTransitoNoOrigen.DefinidoNat(aEnviar.id) ){
                typename Lista<compu>::const_Iterador camino = _paquetesEnTransitoNoOrigen.SignificadoNat(aEnviar.id); 
                _paquetesEnTransitoNoOrigen.SignificadoNat(aEnviar.id).Avanzar();
                camino.Avanzar();
                if(camino.HaySiguiente()){ 
                    tupla tup1 = tupla(camino.Siguiente().hostname, aEnviar); 
                    listaAEnviar.AgregarAtras(tup1);         
                }else{
                    _paquetesEnTransitoNoOrigen.BorrarNat(aEnviar.id);
                }
            }else{
                typename Lista<compu>::const_Iterador camino = _red.CaminoMinimo(aEnviar.origen,aEnviar.destino).CrearIt().Siguiente().CrearIt();
                camino.Avanzar();
                if(camino.HaySiguiente()){
                    camino.Avanzar();
                    //Esto lo hago dos veces porque en el caso que la computadora a la que tengo que enviar el paquete sea destino
                    //no la tengo que encolar en esta ya que deja de ser observable.
                    if(camino.HaySiguiente()){  
                        camino.Retroceder();
                        tupla tup2 = tupla(camino.Siguiente().hostname, aEnviar);
                        listaAEnviar.AgregarAtras(tup2);
                        _paquetesEnTransitoNoOrigen.DefinirNat(aEnviar.id, camino);
                    }
                    
                }

            }

        }
        itCompu.Avanzar();
    }
    //Todos los paquetes que fui acumulando en listaAEnviar los procedo a encolar en las computadoras que les corresponden.
    typename Lista<tupla >::Iterador itEnviar = listaAEnviar.CrearIt();
    while(itEnviar.HaySiguiente()) {

        _enEspera.obtener(itEnviar.Siguiente().prim)->encolar(itEnviar.Siguiente().seg);
        itEnviar.Avanzar();
    }
}

Red& DCNet::DarRed(){
    return _red;
}


Heap<paquete>& DCNet::EnEspera(const compu& c){
    #ifdef DEBUG
    assert(_red.Computadoras().Pertenece(c));
    #endif

    return *_enEspera.obtener(c.hostname);
}


Lista<compu> DCNet::CaminoRecorrido(const paquete& p){
    // #ifdef DEBUG
    // typename Conj<compu>::const_Iterador iterDebug = _red.Computadoras().CrearIt();
    // bool resul = false;
    // while(iterDebug.HaySiguiente() && !resul){
    //    resul = EnEspera(iterDebug.Siguiente()).pertenece(p);
    //    iterDebug.Avanzar();
    // }
    // assert(resul);
    // #endif


    Lista<compu> res; 
    if(_paquetesEnTransitoNoOrigen.DefinidoNat(p.id) ){
        Nat i = 0 ;
        typename Lista<compu>::const_Iterador cam =  _paquetesEnTransitoNoOrigen.SignificadoNat(p.id);
        while(cam.HayAnterior()){
            res.AgregarAdelante(cam.Siguiente());
            cam.Retroceder();
            i++;
        }
        while(i != 0){
            cam.Avanzar();
            i--;
        }
    }
    res.AgregarAdelante(p.origen);
    return res;
}


Nat DCNet::CantidadEnviados(const compu& c){
    #ifdef DEBUG
    assert(_red.Computadoras().Pertenece(c));
    #endif

    return *_cantEnviados.obtener(c.hostname);
}


bool DCNet::PaqueteEnTransito(const paquete& p) {
    bool res = false;
    typename Conj<compu>::const_Iterador itCompu = _red.Computadoras().CrearIt();
    while(itCompu.HaySiguiente() && !res ){
        res = (_enEspera.obtener(itCompu.Siguiente().hostname))->pertenece(p);
        itCompu.Avanzar();
    }
    return res;
}


const compu& DCNet::LaQueMasEnvio() const{
    return *_laQueMasEnvio;
}
