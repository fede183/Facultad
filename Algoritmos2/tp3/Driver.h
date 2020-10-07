#ifndef DRIVER_H_
#define DRIVER_H_

#include "Tipos.h"
//#include "aed2.h"
#include "dcnet.h"
//#include ...

namespace aed2 {

class Driver
{
    public:

        Driver();

        ~Driver();

        /// Observadores Red //////////////////////////////////////////////////////////

        Nat CantidadComputadoras();
        const Computadora& IesimaComputadora(const Nat i);
        
        Nat CantidadInterfacesDe(const Computadora& c);
        const Interfaz& IesimaInterfazDe(const Computadora& c, const Nat i);

        const Interfaz& IntefazUsada(const Computadora& c1, const Computadora& c2);

        bool conectadas(const Computadora& c1, const Computadora& c2);

        /// Armado Red ////////////////////////////////////////////////////////////////

        void AgregarComputadora(const Computadora& ip, const Conj<Interfaz>& ci);
        
        void Conectar(const Computadora& c1, const Interfaz& i1, const Computadora& c2, const Interfaz& i2);
    

       /// Observadores DCNet //////////////////////////////////////////////////////////////
    
        Nat CantidadNodosRecorridosPor(const Paquete& p);
        const Computadora IesimoNodoRecorridoPor(const Paquete& p, const Nat i); //Sacandole el & no pierde memoria.

        Nat CantidadEnviadosPor(const Computadora& c);
    
        Nat CantidadEnEsperaEn(const Computadora& c);
        Nat IesimoEnEsperaEn(const Computadora& c, const Nat i);

        /// Acciones DCNet ////////////////////////////////////////////////////////////

        void CrearPaquete(const Computadora& origen, const Computadora& destino, Nat prioridad);
        
        void AvanzarSegundo();
        
        const Computadora& laQueMasEnvio() const;
        
        // Auxiliares para ver los paquetes
        const Computadora& origen(const Paquete& p) const; 
        const Computadora& destino(const Paquete& p) const; 
        Nat prioridad(const Paquete& p) const; 
        
    private:

    /*********************************************************************
     * TODO: Va a ser necesario instanciar privadamente un Modulo DCNet *
     * con el cuál interactuar. Además, pueden declarar todas las        *
     * funciones auxiliares que les hagan falta.                         *
     *********************************************************************/
    Nat _ID;            //Nos sirve de contador para ir asignando los id de los paquetes que agregamos.
    DiccNat<paquete> TodosLosPaquetes;              //Dado el id, me devuelve la estructura de paquete que nosotros usamos
    DiccString<compu> CompusPorHostname;            //Dado el hostname de una compu, me devuelve la estructura de compu que nosotros usamos
    Red driver_red;                                 //La red.
    DCNet *driver_dcnet;                            //Puntero al dcnet del driver. Es null hasta que le toca iniciarse usando la driver_red
    Lista<paquete*> ListaPaquetesABorrar;           //Lista que contiene los punteros a los paquetes que voy agregando y que, al momento de
                                                    //destruir el driver tengre que borrar cada uno.

}; // class Driver


} // namespace aed2

#endif // DRIVER_H_
