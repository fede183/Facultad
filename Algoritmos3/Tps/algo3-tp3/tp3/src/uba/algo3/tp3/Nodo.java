package uba.algo3.tp3;

import java.util.List;

public class Nodo<T> {
	// Numero del nodo asociado a el grafo que lo contiene.
	protected int identificador;
	// Los nodos que son adyacentes a este.
	protected List<T> vecinos;

	protected boolean visto; // Esto lo uso para el dfs.

	public List<T> getVecinos() {
		return vecinos;
	}

	public void setVecinos(List<T> am) {
		vecinos = am;
	}
	
	public int getId() {
		return identificador;
	}

	public void setId(int m) {
		identificador = m;
	}
	
	public boolean getVisto() {
		return visto;
	}

	public void setVisto(Boolean visto) {
		this.visto = visto;
	}
	
	@Override
	public String toString(){
		return "Id:"+getId();
	}
}
