/* ** por compatibilidad se omiten tildes **
================================================================================
 TRABAJO PRACTICO 3 - System Programming - ORGANIZACION DE COMPUTADOR II - FCEN
================================================================================
*/

#ifndef __GAME_H__
#define __GAME_H__
#include <stdbool.h>
#include <stdbool.h>
#include "defines.h"
#include "screen.h"
#include "mmu.h"
#include "tss.h"
#include "sched.h"
#include "zombie.h"

bool debug_on;  //Indica si el modo debug esta activado
bool pantalla_debug_activa;   //Indica si la pantalla del modo debug fue activada(Entro en excepcion con el modo debug activo)
bool no_jump;   //Variable auxiliar para la rutina de atencion de excepciones
unsigned short respaldo_pantalla[4000];  //Vatiable usada para respaldar la pantalla

//Variables del modo debug

unsigned int jugA_pos;
unsigned int jugB_pos;

unsigned int jugA_ztype;
unsigned int jugB_ztype;


char * zombie_letra;


typedef enum zombie_type_e { G = 0, M = 1, C = 2 } zombie_type;
typedef enum direccion_e { IZQ = 0xAAA, DER = 0x441, ADE = 0x83D, ATR = 0x732 } direccion;

void game_jugador_mover(unsigned int jugador, int value);

void game_lanzar_zombi(unsigned int jugador);
char * puntaje_letra(unsigned int puntaje);
void game_move_current_zombi(direccion dir);

void game_switch_zombie_type_izq(int jugador);
void game_switch_zombie_type_der(int jugador);

void game_initialize();
void game_pintar_jugador(int jugador);
void game_initialize_zombies();

void game_pintar_zombie(int jugador, int indiceZombie);
void game_cargar_codigo_zombie(int jugador, int x, int ztype);


#endif  /* !__GAME_H__ */
