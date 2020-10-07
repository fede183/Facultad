package uba.algo3.tp3;

import java.util.ArrayList;

public class NodoKosaraju extends Nodo<NodoKosaraju> {
	private Integer color;
	private Boolean negado;
	
	public NodoKosaraju(){}
	public NodoKosaraju(Nodo<?> n, Integer color){
		this.setId(n.getId());
		this.setVisto(Boolean.FALSE);
		this.setVecinos(new ArrayList<NodoKosaraju>());
		this.negado = Boolean.FALSE;
		this.color = color;
	}
	public NodoKosaraju(Nodo<?> n, Integer color, Boolean negado){
		this.setId(n.getId());
		this.setVisto(Boolean.FALSE);
		this.setVecinos(new ArrayList<NodoKosaraju>());
		this.negado = negado;
		this.color = color;
	}
	
	public Integer getColor() {
		return color;
	}

	public void setColor(Integer color) {
		this.color = color;
	}
	
	public Boolean getNegado() {
		return negado;
	}
	
	public void setNegado(Boolean negado) {
		this.negado = negado;
	}
	
	@Override
	public String toString(){
		return super.toString()+", color:"+color+", neg:"+negado;
	}
}
