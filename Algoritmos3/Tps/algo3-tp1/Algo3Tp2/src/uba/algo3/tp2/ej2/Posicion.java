package uba.algo3.tp2.ej2;

import java.util.LinkedList;
import java.util.List;

public class Posicion {

	public Posicion(Integer piso, Integer metro) {
		this.piso = piso;
		this.metro = metro;
		distancia = 0;
		vecinos = new LinkedList<Posicion>();
	}

	Integer piso;
	Integer metro;
	Integer distancia;
	List<Posicion> vecinos;

	public Integer getPiso() {
		return piso;
	}

	public void setPiso(Integer piso) {
		this.piso = piso;
	}

	public Integer getMetro() {
		return metro;
	}

	public void setMetro(Integer metro) {
		this.metro = metro;
	}

	public Integer getDistancia() {
		return distancia;
	}

	public void setDistancia(Integer distancia) {
		this.distancia = distancia;
	}

	public List<Posicion> getVecinos() {
		return vecinos;
	}

	public void setVecinos(List<Posicion> vecinos) {
		this.vecinos = vecinos;
	}

	public String toString() {
		String s = "(" + piso + "," + metro + ")\n";
		s += " {";
		for (Posicion pos : vecinos) {
			s += "(" + pos.piso + "," + pos.metro + ") ";
		}
		s += " }";
		return s;

	}

}
