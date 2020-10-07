/* ** por compatibilidad se omiten tildes **
================================================================================
 TRABAJO PRACTICO 3 - System Programming - ORGANIZACION DE COMPUTADOR II - FCEN
================================================================================
  definicion de funciones del scheduler
*/

#ifndef __JUGADOR_H__
#define __JUGADOR_H__

#include "zombie.h"


typedef struct str_jugador_descriptor {
    int tipo_zombie;
    unsigned int pos;
	unsigned int zombies_lanzados;
	zombie_descriptor * zombies;
	int colinicial;
	int puntaje;
} jugador_descriptor;

jugador_descriptor jugadores[2];

void jugador_inicilizar();

#endif	/* !__SCHED_H__ */
