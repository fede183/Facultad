#ifndef DCNET_H_INCLUDED
#define DCNET_H_INCLUDED
//#include "aed2.h"
#include "avld.h"
#include "Red.h"
#include "Heap.h"

using namespace aed2;
using namespace std;
class DCNet{

private:

    const compu* _laQueMasEnvio;
    DiccString<Heap<paquete> > _enEspera;
    DiccString<Nat> _cantEnviados;
    DiccNat<typename Lista<compu>::const_Iterador> _paquetesEnTransitoNoOrigen;
    Red _red;


public:

    DCNet(Red&);

    ~DCNet();

    void CrearPaquete(const paquete&);

    void AvanzarSegundo();

    Red& DarRed();

    Heap<paquete>& EnEspera(const compu&);

    Lista<compu> CaminoRecorrido(const paquete&); //para mi deber�a ser const al final la funci�n, pero me parece que la implementaci�n que usaron cambia la estructura.

    Nat CantidadEnviados(const compu&);

    bool PaqueteEnTransito(const paquete&);

    const compu& LaQueMasEnvio() const;

};

#endif // DCNET_H_INCLUDED