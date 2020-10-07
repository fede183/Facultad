package uba.algo3.tp2.ej1;

import java.util.List;

public class Piso {
	
	protected Integer numero;
	protected List<Integer> antecesores;
	
	public Piso(Integer num, List<Integer> destinos){
		numero = num;
		antecesores = destinos;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public List<Integer> getAntecesores() {
		return antecesores;
	}

	public void setAntecesores(List<Integer> antecesores) {
		this.antecesores = antecesores;
	}
	

}
