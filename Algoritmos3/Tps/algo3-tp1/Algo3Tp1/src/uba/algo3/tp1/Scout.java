package uba.algo3.tp1;

public class Scout implements Comparable<Scout> {

	Character letra;
	Integer pos;
	
	public Scout(Character letra){
		this.letra = letra;
		pos = -1;
	}

	@Override
	public boolean equals(Object other){
		if(other instanceof Scout){
			return this.letra.equals(((Scout)other).letra);
		}else{
			return false;
		}
		
	}
	
	@Override
	public int compareTo(Scout o) {
		return this.letra.compareTo(o.letra);
	}
	
	@Override
	public String toString(){
		return letra+":"+pos;
	}
}
