/* ** por compatibilidad se omiten tildes **
================================================================================
 TRABAJO PRACTICO 3 - System Programming - ORGANIZACION DE COMPUTADOR II - FCEN
================================================================================
  definicion de funciones del scheduler
 */
#include "defines.h"
#include "zombie.h"
#include "i386.h"
#include "jugador.h"
#include "sched.h"
#include "game.h"


unsigned int zombie_pos_pantalla(unsigned int x, unsigned int y) {
	unsigned int pos = ((y * 80) + x) * 2; //pos matriz
	pos = pos + 160; //segunda fila
	pos = pos + 2; // corrido de linea del jugador A
	pos = pos + VIDEO; // lugar de memoria de la pantalla
	return pos;
}

unsigned int zombie_pos_memoria(unsigned int x, unsigned int y) {
	unsigned int pos = ((y * 78) + x) * 0x1000; //pos matriz
	pos = pos + base_mapa; // lugar de memoria del mapa de juego
	return pos;
}

unsigned int zombie_pos_pantalla_jugador(unsigned int jugador, unsigned int indice) {
	zombie_descriptor * zombies = zombie_dame_zombies_jugador(jugador);

	return zombie_pos_pantalla(zombies[indice].x, zombies[indice].y);
}

unsigned int zombie_pos_memoria_jugador(unsigned int jugador, unsigned int indice) {
	zombie_descriptor * zombies = zombie_dame_zombies_jugador(jugador);

	return zombie_pos_memoria(zombies[indice].x, zombies[indice].y);
}

zombie_descriptor * zombie_dame_zombies_jugador(int jugador) {
	if (jugador == 0) {
		return zombiesA;
	}
	if (jugador == 1) {
		return zombiesB;
	}
	return 0;
}

int posicion_reloj_zombie() {

	if (sched_jugador == 0) {
		return 10 + (sched_indice_tarea * 2);
	} else {
		return (70 - 15)+ (sched_indice_tarea * 2);
	}
}

int zombie_matar_zombie() {
	int res = 0;
	if (jugadores[sched_jugador].zombies[sched_indice_tarea].vivo == 1) {
		jugadores[sched_jugador].zombies[sched_indice_tarea].vivo = 0;
		unsigned char * pos = (unsigned char *) zombie_pos_pantalla_jugador(sched_jugador, sched_indice_tarea);
		pos[0] = 0x58; // Letra X
		pos[1] = 0x20; //Fondo verde y letra en negro
		res = 1;
		print("x", posicion_reloj_zombie(), 47, 0x04);
	}
	return res;
}

void zombie_estado_reloj() {

	if (sched_jugador > -1) {

		if (jugadores[sched_jugador].zombies[sched_indice_tarea].vivo == 1) {


			int estado_reloj = jugadores[sched_jugador].zombies[sched_indice_tarea].pos_reloj;
			switch (estado_reloj) {
				case 0:
					print("-", posicion_reloj_zombie(sched_jugador, sched_indice_tarea), 47, 0x0f);
					break;
				case 1:
					print("/", posicion_reloj_zombie(sched_jugador, sched_indice_tarea), 47, 0x0f);
					break;
				case 2:
					print("|", posicion_reloj_zombie(sched_jugador, sched_indice_tarea), 47, 0x0f);
					break;
				case 3:
					print("\\", posicion_reloj_zombie(sched_jugador, sched_indice_tarea), 47, 0x0f);
					break;
			}
		}


	}
}

void zombie_actualizar_reloj() {
	if (sched_jugador > -1 && jugadores[sched_jugador].zombies[sched_indice_tarea].vivo == 1) {

		int estado_reloj = jugadores[sched_jugador].zombies[sched_indice_tarea].pos_reloj;
		estado_reloj++;

		estado_reloj = estado_reloj & 3;

		jugadores[sched_jugador].zombies[sched_indice_tarea].pos_reloj = estado_reloj;
	}

}



void zombie_mover(int parametro_zombie) {
	if (sched_jugador != -1) {
		int adelante = 1 - (2 * sched_jugador); 
		int derecha = 1 - (2 * sched_jugador); 
		int izquierda = - derecha; 
		int atras = - adelante; 
		int altura=jugadores[sched_jugador].zombies[sched_indice_tarea].y;
		if (altura == 0 && sched_jugador == 0 ){
			izquierda = 43;
		}
		if (altura == 0 && sched_jugador == 1) {
			derecha =  43;
		}
		if (altura == 43 && sched_jugador == 0) {
			derecha = - 43;
		}
		if (altura == 43 && sched_jugador == 1) {
			izquierda = - 43;
		}

		//BABA:
		unsigned char * pos = (unsigned char *) zombie_pos_pantalla_jugador(sched_jugador, sched_indice_tarea);
		pos[0] = 'X'; // X
		pos[1] = 0x27;

		//Elegir a donde mover:
		switch (parametro_zombie) {
			case IZQ:
				mmu_copiar_pagina((unsigned int *) 0x8000000, (unsigned int *) 0x8005000);
				jugadores[sched_jugador].zombies[sched_indice_tarea].y += izquierda;
				break;
			case DER:
				mmu_copiar_pagina((unsigned int *) 0x8000000, (unsigned int *) 0x8004000);
				jugadores[sched_jugador].zombies[sched_indice_tarea].y += derecha;
				break;
			case ADE:
				mmu_copiar_pagina((unsigned int *) 0x8000000, (unsigned int *) 0x8001000);
				jugadores[sched_jugador].zombies[sched_indice_tarea].x += adelante;
				break;
			case ATR:
				//debug(parametro_zombie);
				mmu_copiar_pagina((unsigned int *) 0x8000000, (unsigned int *) 0x8006000);
				jugadores[sched_jugador].zombies[sched_indice_tarea].x += atras;
				break;
		}
		game_pintar_zombie(sched_jugador, sched_indice_tarea);

		//Caso en que el zombie llegue a la zona de lanzamiento de un jugador:
		if (jugadores[sched_jugador].zombies[sched_indice_tarea].x == 0) {
			jugadores[1].puntaje++;
			print(puntaje_letra(jugadores[1].puntaje), 42, 47, 0x10);
			zombie_matar_zombie();
		}
		
		if (jugadores[sched_jugador].zombies[sched_indice_tarea].x == 77) {
			jugadores[0].puntaje++;
			print(puntaje_letra(jugadores[0].puntaje), 37, 47, 0x40);
			zombie_matar_zombie();
		}
		
		// Remapeo:
		if (jugadores[sched_jugador].zombies[sched_indice_tarea].vivo == 1) {
			unsigned int cr3_actual = rcr3();
			int offsets[9];
			mmu_obtener_paginas_zombie(sched_jugador, sched_indice_tarea,offsets);
			int x = 0;
			for (x = 0; x < 9; x++) {
				mmu_mapear_pagina(0x08000000 + (x * 0x1000), cr3_actual, offsets[x], 1);
			}
		}
	}
}


