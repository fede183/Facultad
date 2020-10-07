/* ** por compatibilidad se omiten tildes **
================================================================================
 TRABAJO PRACTICO 3 - System Programming - ORGANIZACION DE COMPUTADOR II - FCEN
================================================================================
  definicion de funciones del scheduler
 */
#include "defines.h"
#include "jugador.h"
#include "i386.h"

void jugador_inicilizar(){
	
	int x;
	
	for (x=0;x<2;x++){
		jugadores[x].pos = 0;
		jugadores[x].tipo_zombie = 0;
		jugadores[x].zombies_lanzados = 0;
		jugadores[x].puntaje = 0;
	}
	jugadores[0].zombies = zombiesA;
	jugadores[1].zombies = zombiesB;
	jugadores[0].colinicial = 1;
	jugadores[1].colinicial = 76;
}
