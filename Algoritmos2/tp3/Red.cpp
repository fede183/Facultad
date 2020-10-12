#include "Red.h"


Red::Red(){}

Red::~Red(){
}

Red::Red( Red& r)
	:Compus(r.Compus),  Conexiones(r.Conexiones), InterfacesQueConectan(r.InterfacesQueConectan), caminosMinimos(r.caminosMinimos){
	//Compus = r.Compus;
	//Conexiones = r.Conexiones;
	//InterfacesQueConectan = r.InterfacesQueConectan;
	//caminosMinimos = r.caminosMinimos;
}


void Red::AgregarComputadora(const compu& c){
	
	typename Conj<compu>::Iterador iteradorCompu = Compus.AgregarRapido(c);
	Conj<compu> l1;
	DiccString<interfaz> l2;
	DiccString<Conj<Lista<compu> > > l;

	Conexiones.definir(c.hostname, l1);
	InterfacesQueConectan.definir(c.hostname, l2);
	caminosMinimos.definir(c.hostname, l);

	while (iteradorCompu.HaySiguiente()){
		if (iteradorCompu.Siguiente().hostname != c.hostname){
			Conj<Lista<compu> > vacia1;
			Conj<Lista<compu> > vacia2;
			Lista<compu> Aux1;
			Lista<compu> Aux2;
			vacia1.AgregarRapido(Aux1);
			vacia2.AgregarRapido(Aux2);
			caminosMinimos.obtener(c.hostname)->definir(iteradorCompu.Siguiente().hostname, vacia1);
			caminosMinimos.obtener(iteradorCompu.Siguiente().hostname)->definir(c.hostname, vacia2);
		}
		iteradorCompu.Avanzar();
	}

}

void Red::Conectar(const compu& c1, const compu& c2, interfaz i1, interfaz i2){
	#ifdef DEBUG
    assert(Compus.Pertenece(c1) && Compus.Pertenece(c2) && c1.hostname != c2.hostname && !Conectadas(c1, c2) && !UsaInterfaz(c1, i1) && !UsaInterfaz(c2, i2));
    #endif
    //Pone la computadora en las conexiones de la otra.
	Conexiones.obtener(c1.hostname)->AgregarRapido(c2);
	Conexiones.obtener(c2.hostname)->AgregarRapido(c1);
	//Si no esta definida InterfacesQueConectan, la define.
	if (!InterfacesQueConectan.definido(c1.hostname)){
		DiccString<interfaz> vacio1;
		InterfacesQueConectan.definir(c1.hostname, vacio1);
	}
	if (!InterfacesQueConectan.definido(c2.hostname)){
		DiccString<interfaz> vacio2;
		InterfacesQueConectan.definir(c2.hostname, vacio2);
	}
	//Obtiene el diccionario anteriormente definido y le asigna al hostname de la otra computadora la interfaz con las
	//que se conecta.
	InterfacesQueConectan.obtener(c1.hostname)->definir(c2.hostname, i1);
	InterfacesQueConectan.obtener(c2.hostname)->definir(c1.hostname, i2);
	//Recorremos todas las computadoras para recalcular los caminos minimos entre cada una de ellas.
	typename Conj<compu>::Iterador iteradorCompu1 = Compus.CrearIt();
	while (iteradorCompu1.HaySiguiente()){
		typename Conj<compu>::Iterador iteradorCompu2 = Compus.CrearIt();
		while (iteradorCompu2.HaySiguiente()){
			if (iteradorCompu1.Siguiente().hostname != iteradorCompu2.Siguiente().hostname){
				Conj<Lista<compu> > cl1 = ConstruirCaminosMinimos(iteradorCompu1.Siguiente(), iteradorCompu2.Siguiente());
				Conj<Lista<compu> > cl2 = ConstruirCaminosMinimos(iteradorCompu2.Siguiente(), iteradorCompu1.Siguiente());
	
				//DiccString<Conj<Lista<compu> > >* cam1 = caminosMinimos.obtener(iteradorCompu1.Siguiente().hostname);
				//DiccString<Conj<Lista<compu> > >* cam2 = caminosMinimos.obtener(iteradorCompu2.Siguiente().hostname);
				
				caminosMinimos.obtener(iteradorCompu1.Siguiente().hostname)->definir(iteradorCompu2.Siguiente().hostname, cl1);
				caminosMinimos.obtener(iteradorCompu2.Siguiente().hostname)->definir(iteradorCompu1.Siguiente().hostname, cl2);
			}
			iteradorCompu2.Avanzar();
		}
		iteradorCompu1.Avanzar();
	}

}

Conj<compu>& Red::Computadoras(){
	return Compus;
}


bool Red::Conectadas(const compu &c1, const compu &c2){
	#ifdef DEBUG
    assert(Compus.Pertenece(c1) && Compus.Pertenece(c2));
    #endif
	return Conexiones.obtener(c1.hostname)->Pertenece(c2);
}

const interfaz& Red::interfazUsada(const compu& c1, const compu& c2){
	#ifdef DEBUG
    assert(Conectadas(c1, c2));
    #endif

	return *((*(InterfacesQueConectan.obtener(c1.hostname))).obtener(c2.hostname));
}

Conj<compu>& Red::Vecinos(const compu& c){
	#ifdef DEBUG
    assert(Compus.Pertenece(c));
    #endif

	return *(Conexiones.obtener(c.hostname));
}

bool Red::UsaInterfaz(const compu& c, const interfaz& i){
	#ifdef DEBUG
    assert(Compus.Pertenece(c));
    #endif

	vector<string> clav = (*(InterfacesQueConectan.obtener(c.hostname))).claves();
	bool encontre = false;
	unsigned int j = 0;
	while (j < clav.size() && !encontre){
		if (*(*InterfacesQueConectan.obtener(c.hostname)).obtener(clav[j]) == i){
			encontre = true;
		}
		j++;
	}
	return encontre;
}

Conj<Lista<compu> >& Red::CaminoMinimo(const compu& c1, const compu& c2){
	#ifdef DEBUG
    assert(Compus.Pertenece(c1) && Compus.Pertenece(c2));
    #endif

	return *(*caminosMinimos.obtener(c1.hostname)).obtener(c2.hostname);
}

bool Red::HayCamino(const compu& c1, const compu& c2){
	#ifdef DEBUG
    assert(Compus.Pertenece(c1) && Compus.Pertenece(c2));
    #endif

	return !(*(*caminosMinimos.obtener(c1.hostname)).obtener(c2.hostname)).CrearIt().Siguiente().EsVacia();
}

Conj<Lista<compu> > Red::AuxCaminos(const compu &c1, const compu &c2, Lista<compu> &recorrido, Conj<compu> &candidatos){
	if (candidatos.EsVacio()){
		Conj<Lista<compu> > res;
		return res;
	}
	else if (recorrido.Ultimo().hostname == c2.hostname){ 
		Conj<Lista<compu> > res;
		res.AgregarRapido(recorrido);
		return res;
	}
	else{
		typename Lista<compu>::Iterador iterador = recorrido.CrearIt();
		compu dameUno = candidatos.CrearIt().Siguiente();
		bool loEncontre = false;
		while (iterador.HaySiguiente() && !loEncontre){
			if (dameUno.hostname == iterador.Siguiente().hostname){
				loEncontre = true;
			}
			iterador.Avanzar();
		}
		if(!loEncontre){
			Lista<compu> recorridoAux = recorrido;
			recorridoAux.AgregarAtras(dameUno);
			Conj<compu> candidadosAux = *(Conexiones.obtener(dameUno.hostname));
			Conj<Lista<compu> > camino1 = AuxCaminos(c1 , c2 , recorridoAux, candidadosAux);
			candidatos.Eliminar(dameUno);
			Conj<Lista<compu> > camino2 = AuxCaminos(c1 , c2 , recorrido, candidatos);
			typename Conj<Lista<compu> >::Iterador iteradorCamino = camino2.CrearIt();
			while (iteradorCamino.HaySiguiente()){
				camino1.AgregarRapido(iteradorCamino.Siguiente());
				iteradorCamino.Avanzar();
			}
			return camino1;
		}
		else{
			candidatos.Eliminar(dameUno);
			return AuxCaminos(c1 , c2 , recorrido, candidatos);
		}
	}
}

Conj<Lista<compu> > Red::ConstruirCaminosMinimos(const compu &c1, const compu &c2){
	Lista<compu> recorrido;
	recorrido.AgregarAdelante(c1);
	Conj<compu> candidatos = *(Conexiones.obtener(c1.hostname));
	Conj<Lista<compu > > camino = AuxCaminos(c1, c2, recorrido, candidatos);	//Obtengo todos los caminos.

	//Saco todos los que no sean minimos. 
	typename Conj<Lista<compu> >::Iterador iterador = camino.CrearIt();
	if(iterador.HaySiguiente()){
		Lista<compu> minimoActual  = iterador.Siguiente();
		iterador.Avanzar();

		while (iterador.HaySiguiente()){
			if (minimoActual.Longitud() > iterador.Siguiente().Longitud()){
				minimoActual = iterador.Siguiente();
			}
			iterador.Avanzar();
		}
		typename Conj<Lista<compu> >::Iterador iterador2 = camino.CrearIt();
		while (iterador2.HaySiguiente()){
			if (minimoActual.Longitud() < iterador2.Siguiente().Longitud()){
				iterador2.EliminarSiguiente();
			}
			else{
				iterador2.Avanzar();
			}
		}
	}
	
	return camino;
}

