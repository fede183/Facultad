/* ** por compatibilidad se omiten tildes **
================================================================================
 TRABAJO PRACTICO 3 - System Programming - ORGANIZACION DE COMPUTADOR II - FCEN
================================================================================
  definicion de funciones del scheduler
*/

#ifndef __SCHED_H__
#define __SCHED_H__

#include "screen.h"
#include "tss.h"
#include "game.h"
#include "i386.h"

int sched_jugador; //0 si es el primero, 1 si es el segundo, -1 idle
int sched_indice_tarea; // indice del zombie vivo
int sched_indice_tarea_A; // indice del ultimo zombie de A
int sched_indice_tarea_B; // indice del ultimo zombie de B
int sched_indice_actual; //indice de la gdt que se esta ejecutando

void sched_inicializar();
unsigned short sched_proximo_indice();


#endif	/* !__SCHED_H__ */
