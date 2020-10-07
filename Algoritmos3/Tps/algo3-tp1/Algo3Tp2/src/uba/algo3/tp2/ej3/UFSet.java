package uba.algo3.tp2.ej3;

import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

public class UFSet {
	Vector<Integer> padres;
	Vector<Integer> rangos;
	int size;
	
	public UFSet(Integer size){
		// Inicializamos cada elemento en su propio conjunto
		// con rango 0
		padres = new Vector<Integer>();
		rangos = new Vector<Integer>();
		
		for(Integer i = 0; i< size; i++){
			padres.add(i);
			rangos.add(0);
		}
	}
	
	Integer find(Integer elem){
		Integer padre = padres.get(elem);
		//Hacemos path compression
		while(!padre.equals(padres.get(padre))){
			padre = padres.get(padre);
		}
		padres.set(elem, padre);
		return padres.get(elem);
	}
	
	void union(Integer a, Integer b){
		Integer aRaiz = find(a);
		Integer bRaiz = find(b);

		// Si tienen la misma raiz ya estan unidos
		if(!aRaiz.equals(bRaiz)){

			//Hacemos la union pesada
			Integer aRango = rangos.get(a);
			Integer bRango = rangos.get(b);
			
			if(aRango < bRango){
				padres.set(aRaiz, bRaiz);
			}else if(aRango > bRango){
				padres.set(bRaiz, aRaiz);
			}else{
				//Desempatamos en favor de a
				padres.set(bRaiz, aRaiz);
				rangos.set(aRaiz, rangos.get(aRaiz)+1);
			}
		}
	}
	
	Boolean connected(Integer a, Integer b){
		return find(a).equals(find(b));
	}
}
