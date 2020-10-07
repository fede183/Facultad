/* ** por compatibilidad se omiten tildes **
================================================================================
 TRABAJO PRACTICO 3 - System Programming - ORGANIZACION DE COMPUTADOR II - FCEN
================================================================================
  definicion de funciones del scheduler
*/

#ifndef __ZOMBIE_H__
#define __ZOMBIE_H__

typedef struct str_zombie_descriptor {
    char tipo;
    unsigned int vivo;
	unsigned short gdt_index;
	int x;
	int y;
	unsigned int pos_reloj;
} zombie_descriptor;


zombie_descriptor zombiesA[8];
zombie_descriptor zombiesB[8];

unsigned int zombie_pos_pantalla(unsigned int x, unsigned int y);
unsigned int zombie_pos_memoria(unsigned int x, unsigned int y);
unsigned int zombie_pos_pantalla_jugador(unsigned int jugador, unsigned int indice);
unsigned int zombie_pos_memoria_jugador(unsigned int jugador, unsigned int indice);
void zombie_actualizar_reloj();
void zombie_mover();
zombie_descriptor * zombie_dame_zombies_jugador(int jugador);
int zombie_matar_zombie();

#endif	/* !__SCHED_H__ */
