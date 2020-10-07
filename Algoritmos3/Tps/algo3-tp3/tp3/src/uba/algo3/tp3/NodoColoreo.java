package uba.algo3.tp3;

import java.util.ArrayList;
import java.util.List;

public class NodoColoreo extends Nodo<NodoColoreo> {

	// Los colores son numeros enteros.
	protected List<Integer> colores; 
	// Los colores son numeros enteros.
	protected List<Integer> coloresEliminados; 
	//Color seteado en el nodo.
	protected Integer color; 
	
	public NodoColoreo(int c, List<Integer> colores) {
		identificador = c;
		vecinos = new ArrayList<>();
		this.colores = colores;
		this.coloresEliminados = new ArrayList<>();
		visto = false;
		color = null;
	}
	
	public NodoColoreo(NodoColoreo n) {
		identificador = n.getId();
		vecinos = new ArrayList<>();
		this.colores = n.getColores();
		this.coloresEliminados = new ArrayList<>();
		visto = n.getVisto();
		color = n.getColor();
	}


	public List<Integer> getColores() {
		return colores;
	}

	public Integer getColor(){
		return color;
	}
	
	public void setColor(Integer _color){
		color = _color;
	}
	
	public void setColores(List<Integer> am) {
		colores = am;
	}

	public boolean estaColor(Integer color) {
		return colores.contains(color);
	}
	
	/** Busca en los colores posibles y si se encuentra el color lo elimina.**/
	public void quitarColor(Integer color) {
		for(int i = 0; i<colores.size() ;i++){
			if(colores.get(i).equals(color)){
				coloresEliminados.add(color);
				colores.remove(i);
			}
		}
		
	}

	/** Aplica la operacion anterior a todos los vecinos de ese nodo.**/ 
	public void quitarColorAdyacentes(Integer color) {
		for (int i = 0; i < vecinos.size(); i++) {
			(vecinos.get(i)).quitarColor(color);
		}
	}

	/** Devuelve la cantidad de veces que aparece un color en los nodos
	 adyacentes. */
	public int cantAparicionesAdyacente(Integer color) {
		int resultado = 0;
		for (int i = 0; i < vecinos.size(); i++) {
			if ((vecinos.get(i)).estaColor(color)) {
				resultado++;
			}
		}
		return resultado;
	}

	/** Devuelve el color que menos aparece en los adyacentes.*/
	public Integer colorMenosAparecido() {
		Integer resultado;
		
		//Si no me quedan colores validos para asignar voy a usar los eliminados.
		if(colores.isEmpty()){ 
			resultado = coloresEliminados.get(0);
		}
		else{
			resultado = colores.get(0);
		}
		

		for (int i = 1; i < colores.size(); i++) {
			if (cantAparicionesAdyacente(resultado) > cantAparicionesAdyacente(colores.get(i))) {
				resultado = colores.get(i);
			}
		}

		return resultado;
	}
	
	/** Devuelve el i-esimo color que menos aparece en los adyacentes.*/
	public Integer iesimoColorMenosAparecido(int i) {
		//Cuando i = 0, entonces resultado sera igual al color menos aparecido.
		Integer resultado = colorMenosAparecido();
		List<Integer> coloresAux = new ArrayList<Integer>(colores);
		List<Integer> coloresEliminadosAux = new ArrayList<Integer>(coloresEliminados);
		
		
		while(i > 0){
			boolean usamosEliminados = false;
			//Si no me quedan colores validos para asignar voy a usar los eliminados.
			if(coloresAux.isEmpty()){ 
				resultado = coloresEliminadosAux.get(0);
				usamosEliminados = true;
			}
			else{
				resultado = coloresAux.get(0);
			}
			
			int jAux = 1;
			//Encuentro el minimo.
			for (int j = 1; j < coloresAux.size(); j++) {
				if (cantAparicionesAdyacente(resultado) > cantAparicionesAdyacente(coloresAux.get(j))) {
					resultado = coloresAux.get(j);
					jAux = j;
				}
			}
			
			i--;
			if(i>0){
				//Mientras no sea el i-esimo quito el color.
				//Solo lo quito si no es de los eliminados.
				if(!usamosEliminados){
					coloresAux.remove(jAux);
				}
			}
		}
		return resultado;
	}

	public List<NodoColoreo> vecinosNoVisitados() {
		List<NodoColoreo> resultado = new ArrayList<>();

		for (int i = 0; i < vecinos.size(); i++) {
			if (!vecinos.get(i).getVisto()) {
				resultado.add(vecinos.get(i));

			}
		}

		return resultado;
	}
	
	/** Obtiene el minimo color que est� en la lista.**/
	public Integer getColorMinimo(){
		Integer result = null;
		for(int i = 0; i < colores.size(); i++){
			if(result != null){
				if(result < colores.get(i)){
					result = colores.get(i);
				}
			}else{
				result = colores.get(i);
			}
		}
		return result;
	}

	public List<Integer> getColoresEliminados() {
		return coloresEliminados;
	}

	public void setColoresEliminados(List<Integer> coloresEliminados) {
		this.coloresEliminados = coloresEliminados;
	}

}
