/* ** por compatibilidad se omiten tildes **
================================================================================
 TRABAJO PRACTICO 3 - System Programming - ORGANIZACION DE COMPUTADOR II - FCEN
================================================================================
  definicion de funciones del manejador de memoria
*/

#ifndef __MMU_H__
#define __MMU_H__

#include "defines.h"
#include "i386.h"
#include "tss.h"
#include "game.h"

typedef struct str_cr3 {
    unsigned char   ign_1:3;
    unsigned char   pwt:1;
    unsigned char   pcd:1;
    unsigned char   ign_2:7;
    unsigned int    base:20;
} __attribute__((__packed__)) cr3;

typedef struct str_page_dir {
    unsigned char   p:1;
    unsigned char   rw:1;
    unsigned char   us:1;
    unsigned char   pwt:1;
    unsigned char   pcd:1;
    unsigned char   a:1;
    unsigned char   cero:1;
    unsigned char   ps:1;
    unsigned char   g:1;
    unsigned char   avl:3;
    unsigned int    base:20;
} __attribute__((__packed__)) page_dir;

typedef struct str_page_table {
    unsigned char   p:1;
    unsigned char   rw:1;
    unsigned char   us:1;
    unsigned char   pwt:1;
    unsigned char   pcd:1;
    unsigned char   a:1;
    unsigned char   d:1;
    unsigned char   pat:1;
    unsigned char   g:1;
    unsigned char   avl:3;
    unsigned int    base:20;
} __attribute__((__packed__)) page_table;


unsigned int posiciones_paginas_zombie[9];

void mmu_inicializar();
void mmu_inicializar_dir_kernel();
unsigned int CR32UInt(cr3 uncr3);
unsigned int obtener_pagina_libre();

void mmu_mapear_pagina(unsigned int virtual, unsigned int cr3, unsigned int fisica, short nivel);
void mmu_unmapear_pagina(unsigned int virtual, unsigned int cr3);
void mmu_inicializar_dir_zombieA(unsigned int posicionY, unsigned int cr3);
void mmu_inicializar_dir_zombieB(unsigned int posicionY, unsigned int cr3);
unsigned int mmu_inicializar_dir_zombie(unsigned int posicionY, unsigned int jugador);
void mmu_copiar_pagina(unsigned int * origen, unsigned int * destino);

void  mmu_obtener_paginas_zombie(unsigned int jugador, unsigned int indicetarea, int * offsets);
//void mmu_obtener_offsets(unsigned int jugador, unsigned int altura);



#endif	/* !__MMU_H__ */




