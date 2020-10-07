/* ** por compatibilidad se omiten tildes **
================================================================================
 TRABAJO PRACTICO 3 - System Programming - ORGANIZACION DE COMPUTADOR II - FCEN
================================================================================
 */

#include "game.h"
#include "jugador.h"

void game_jugador_mover(unsigned int jugador, int value) {
	unsigned int pos = jugadores[jugador].pos;
	if (pos == 0 && value == -1) {
		pos = 43;
	} else if (pos == 43 && value == 1) {
		pos = 0;
	} else {
		pos += value;
	}
	jugadores[jugador].pos = pos;


	game_pintar_jugador(jugador);

}

char * puntaje_letra(unsigned int puntaje){
	char* c;
	switch(puntaje){
		case 0:{
			c="0";
			break;
		}
		case 1:{
			c="1";
			break;
		}
		case 2:{
			c="2";
			break;
		}
		case 3:{
			c="3";
			break;
		}
		case 4:{
			c="4";
			break;
		}
		case 5:{
			c="5";
			break;
		}
		case 6:{
			c="6";
			break;
		}
		case 7:{
			c="7";
			break;
		}
		case 8:{
			c="8";
			break;
		}
		case 9:{
			c="9";
			break;
		}
		case 10:{
			c="10";
			break;
		}
		case 11:{
			c="11";
			break;
		}
		case 12:{
			c="12";
			break;
		}
		case 13:{
			c="13";
			break;
		}
		case 14:{
			c="14";
			break;
		}
		case 15:{
			c="15";
			break;
		}
		case 16:{
			c="16";
			break;
		}
		case 17:{
			c="17";
			break;
		}
		case 18:{
			c="18";
			break;
		}
		case 19:{
			c="19";
			break;
		}
		case 20:{
			c="20";
			break;
		}

	}

	return c;
}

void game_lanzar_zombi(unsigned int jugador) {
	int x = 0;
	zombie_descriptor * zombies = jugadores[jugador].zombies;
	//breakpoint();
	if (jugadores[jugador].zombies_lanzados < 20) {
		for (x = 0; x < 8; x++) {
			if (zombies[x].vivo == 0) {

				zombies[x].vivo = 1;
				zombies[x].tipo = zombie_letra[jugadores[jugador].tipo_zombie];
				zombies[x].y = jugadores[jugador].pos;

				zombies[x].x = jugadores[jugador].colinicial;
				completar_tss_zombie(jugador, x);
				game_cargar_codigo_zombie(jugador, x, jugadores[jugador].tipo_zombie);
				game_pintar_zombie(jugador, x);
				jugadores[jugador].zombies_lanzados ++;
				unsigned int zombie_restante=20-jugadores[jugador].zombies_lanzados;
				int color_jugador=0x40-(jugador*0x30);
				int pos_jugador=32 +(jugador*14);
				print(puntaje_letra(zombie_restante), pos_jugador, 47, color_jugador); 
				if(zombie_restante<10){
					print(" ", pos_jugador+1, 47, 0x00); 
				}
				break;
			}
		}
	}
}
void game_switch_zombie_type_izq(int jugador) {

	int tipo = jugadores[jugador].tipo_zombie;
	if (tipo == 0) {
		tipo = 2;
	} else {
		tipo--;
	}
	jugadores[jugador].tipo_zombie = tipo;
	game_pintar_jugador(jugador);

}

void game_switch_zombie_type_der(int jugador) {
	int tipo = jugadores[jugador].tipo_zombie;
	if (tipo == 2) {
		tipo -= 2;
	} else {
		tipo++;
	}
	jugadores[jugador].tipo_zombie = tipo;
	game_pintar_jugador(jugador);
}

void game_initialize() {
	zombie_letra = "GMC";
	jugA_pos = 0;
	jugB_pos = 0;

	jugA_ztype = 0;
	jugB_ztype = 0;

	debug_on = FALSE;
	pantalla_debug_activa = FALSE;
	game_pintar_jugador(0);
	game_pintar_jugador(1);
	game_initialize_zombies();
	sched_inicializar();
	jugador_inicilizar();
	print("0", 42, 47, 0x10); //Puntaje incial
	print("0", 37, 47, 0x40);
	print("20", 46, 47, 0x10); //Cantidad de zombies inicial
	print("20", 32, 47, 0x40);

}

void game_pintar_jugador(int jugador) {

	unsigned char* jugador_token;
	unsigned short* tile;
	int x = 0;
	jugB_pos = jugadores[1].pos;
	jugA_pos = jugadores[0].pos;
	jugB_ztype = jugadores[1].tipo_zombie;
	jugA_ztype = jugadores[0].tipo_zombie;


	if (jugador == 1) {
		for (x = 0; x < 44; x++) {
			tile = (unsigned short*) (VIDEO + (160 + 158) + (160 * x));
			tile[0] = 0x1020;

		}
		jugador_token = (unsigned char*) (VIDEO + (160 + 158) + (160 * jugB_pos));
		jugador_token[0] = zombie_letra[jugB_ztype];
		jugador_token[1] = 0x1f;
	}
	if (jugador == 0) {
		for (x = 0; x < 44; x++) {
			tile = (unsigned short*) (VIDEO + (160) + (160 * x));
			tile[0] = 0x4020;
		}
		jugador_token = (unsigned char*) (VIDEO + (160) + (160 * jugA_pos));
		jugador_token[0] = zombie_letra[jugA_ztype];
		jugador_token[1] = 0x4f;
	}
}

void game_initialize_zombies() {
	int x;
	for (x = 0; x < 8; x++) {
		zombiesA[x].gdt_index = ((x + 15)*8);
		zombiesA[x].vivo = 0;
		zombiesA[x].tipo = 0;
		zombiesB[x].gdt_index = ((x + 23)*8);
		zombiesB[x].vivo = 0;
		zombiesB[x].tipo = 0;
	}
}

void game_pintar_zombie(int jugador, int indiceZombie) {
	zombie_descriptor * zombies = jugadores[jugador].zombies;

	unsigned char * pos;
	pos = (unsigned char *) zombie_pos_pantalla(zombies[indiceZombie].x, zombies[indiceZombie].y);
	pos[0] = zombies[indiceZombie].tipo;
	pos[1] = 0x7f;

}

void game_cargar_codigo_zombie(int jugador, int indice, int ztype) {
	unsigned int * indice_codigo_original_zombie;
	unsigned int * indice_codigo_pagina_zombie;

	indice_codigo_original_zombie = (unsigned int *) (0x10000 + (jugador * 0x3000) + (ztype * 0x1000));

	indice_codigo_pagina_zombie = (unsigned int *) zombie_pos_memoria_jugador(jugador, indice);
	mmu_mapear_pagina((unsigned int) 0x400000, rcr3(), (unsigned int) indice_codigo_pagina_zombie, 0);
	mmu_copiar_pagina(indice_codigo_original_zombie, (unsigned int *) 0x400000);
	mmu_unmapear_pagina((unsigned int) 0x400000, rcr3());

}