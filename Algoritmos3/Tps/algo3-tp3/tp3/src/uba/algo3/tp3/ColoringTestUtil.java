package uba.algo3.tp3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ColoringTestUtil {
	
	/** Por cada nodo que tenga un vecino del mismo color, contamos un conflicto.**/
	public static Integer contarConflictos(GrafoColoreo g) {
		Integer conflictos = 0;
		for (NodoColoreo nodo : g.nodos) {
			for (NodoColoreo vecino : nodo.getVecinos()) {
				if (nodo.getColor().equals(vecino.getColor())) {
					conflictos++;
				}
			}
		}
		//Dividimos por dos ya que cada conflicto lo contamos dos veces (una por cada nodo). 
		return (conflictos / 2);
	}
	
	/** Cuenta los conflictos de un nodo especifico.**/
	public static Integer cantConflictos(NodoColoreo nodo) {
		Integer conflictos = 0;
		for (NodoColoreo vecino : nodo.vecinos) {
			if (vecino.getColor().equals(nodo.getColor()))
				conflictos++;
		}
		return conflictos;
	}
	
	
	public static void writeOutput(GrafoColoreo g, String path, String filename) throws IOException{
		BufferedWriter output = new BufferedWriter(new FileWriter(path+"/"+filename+".out"));
		if(g!=null){
			for(NodoColoreo nodo : g.getNodos()){
				output.append(nodo.getColor()+" ");
			}
		}else{
			output.append("X");
		}
		output.flush();
		output.close();
	}
}
