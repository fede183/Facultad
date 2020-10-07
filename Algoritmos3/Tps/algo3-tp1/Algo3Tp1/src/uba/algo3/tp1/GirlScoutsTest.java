package uba.algo3.tp1;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class GirlScoutsTest {

	/** Parseo de la entrada en el formato de la catedra para el Ej3.</br>
	 *  Queda en esta clase para reutilizarlo en los tests y separarlo al medir tiempos.*/
	protected Object[] parseInput(String input){
		List<Scout> scouts = new ArrayList<Scout>();
		List<Amistad> amistades = new ArrayList<Amistad>();

		StringTokenizer st = new StringTokenizer(input, ";");
		while (st.hasMoreTokens()) {
			String parScoutAmistades = st.nextToken();
			String amistadesString = parScoutAmistades.substring(1).trim();
			
			Character scoutLetra = parScoutAmistades.charAt(0);
			Scout scout = new Scout(scoutLetra);
			
			if(!scouts.contains(scout)){
				scouts.add(scout);
			}else{
				scout = scouts.get(scouts.indexOf(scout));
			}
			
			for(Character amigaLetra : amistadesString.toCharArray()){
				Scout amiga = new Scout(amigaLetra);
				
				if(!scouts.contains(amiga)){
					scouts.add(amiga);
				}else{
					amiga = scouts.get(scouts.indexOf(amiga));
				}
				
				amistades.add(new Amistad(scout, amiga));
			}
		}
		return new Object[]{scouts,amistades};
	}
}
