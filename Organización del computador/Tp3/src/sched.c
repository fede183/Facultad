/* ** por compatibilidad se omiten tildes **
================================================================================
 TRABAJO PRACTICO 3 - System Programming - ORGANIZACION DE COMPUTADOR II - FCEN
================================================================================
  definicion de funciones del scheduler
 */

#include "sched.h"  


void sched_inicializar() {
	sched_jugador = -1;
	sched_indice_tarea_A = 0;
	sched_indice_tarea_B = 0;
	sched_indice_tarea = 0;
	sched_indice_actual = GDT_IDX_TAREA_IDLE * 8; // arrancamos con la idle (creo)
}

unsigned short sched_proximo_indice() {
	zombie_descriptor * primeros_zombies = 0;
	zombie_descriptor * segundos_zombies = 0;
	int primer_indice;
	int segundo_indice;
	int x;
	int indice;	
	unsigned short proximo;
	
	/* Seteo del proximo jugador */
	int jugador = (1 - sched_jugador);
	if (sched_jugador == -1) jugador = 0; // por si venia de idle (parche)

	/* Seteo el orden de las estrucuturas a ser revisadas */
	if (jugador == 1) {
		primeros_zombies = zombiesB;
		primer_indice = sched_indice_tarea_B;
		segundos_zombies = zombiesA;
		segundo_indice = sched_indice_tarea_A;
	} else {
		primeros_zombies = zombiesA;
		primer_indice = sched_indice_tarea_A;
		segundos_zombies = zombiesB;
		segundo_indice = sched_indice_tarea_B;
	}
	
	/* Reviso las estructuras */
	sched_jugador = -1;
	for (x = 0; x < 8; x++) {
		indice = (x + 1 + primer_indice) % 8;
		//debug(indice);
		//debug(primeros_zombies[indice].vivo);
		if (primeros_zombies[indice].vivo == 1) {
			
			sched_jugador = jugador;
			sched_indice_tarea = indice;
			break;
		}
	}
	if (sched_jugador == -1) {
		jugador = 1 - jugador;
		for (x = 0; x < 8; x++) {
			indice = (x + 1 + segundo_indice) % 8;
			if (segundos_zombies[indice].vivo == 1) {
				sched_jugador = jugador;
				sched_indice_tarea = indice;
				break;
			}
		}
	}
	proximo = 0;
	/* Recupero la info */
	if (sched_jugador == 0) {
		sched_indice_tarea_A = indice;
		//debug((unsigned int) zombiesA[indice].gdt_index);
		proximo = zombiesA[indice].gdt_index;
	}
	if (sched_jugador == 1) {
		sched_indice_tarea_B = indice;
		proximo = zombiesB[indice].gdt_index;
	}

	if(proximo == 0){
		/* Si no encontramos zombies para correr tonces correra idle */
		proximo = GDT_IDX_TAREA_IDLE * 8;
	}
	
	if (proximo == sched_indice_actual){
		return 0;
	}else{
		sched_indice_actual = proximo;
		return proximo;
	}

}
