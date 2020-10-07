/* ** por compatibilidad se omiten tildes **
================================================================================
 TRABAJO PRACTICO 3 - System Programming - ORGANIZACION DE COMPUTADOR II - FCEN
================================================================================
  definicion de funciones del manejador de memoria
 */
unsigned int offset_pagina_zombie_A[9] = {
	0,
	0x1000,
	0x1000 + 78 * 0x1000,
	0x1000 - 78 * 0x1000,
	78 * 0x1000,
	-78 * 0x1000,
	-0x1000,
	-0x1000 + -78 * 0x1000,
	-0x1000 + 78 * 0x1000
};
unsigned int offsets_paginas[9];
unsigned int offset_pagina_zombie_B[9] = {
	0,
	-0x1000,
	-0x1000 - 78 * 0x1000,
	-0x1000 + 78 * 0x1000,
	-78 * 0x1000,
	78 * 0x1000,
	0x1000,
	0x1000 + 78 * 0x1000,
	0x1000 + (-78) * 0x1000
};
#include "mmu.h"
#include "jugador.h"
unsigned int indice_pagina_libre;

void mmu_inicializar() {
	indice_pagina_libre = primera_pagina_libre;

}

void mmu_inicializar_dir_kernel() {
	page_dir * directorio = (page_dir *) page_dir_kernel;
	page_table * tabla = (page_table *) page_table_kernel_0;

	int x = 0;
	cr3 micr3 = (cr3){
		.ign_1 = 0,
		.pwt = 0,
		.pcd = 0,
		.ign_2 = 0,
		.base = (unsigned int) directorio >> 12
	};

	page_dir mipage_dir = (page_dir){
		.p = 1,
		.rw = 1,
		.us = 0,
		.pwt = 0,
		.pcd = 0,
		.a = 0,
		.cero = 0,
		.ps = 0,
		.g = 0,
		.avl = 0,
		.base = (unsigned int) tabla >> 12
	};

	lcr3(CR32UInt(micr3));

	for (x = 0; x < 1024; x++) {
		directorio[x] = (page_dir){
			.p = 0,
			.rw = 0,
			.us = 0,
			.pwt = 0,
			.pcd = 0,
			.a = 0,
			.cero = 0,
			.ps = 0,
			.g = 0,
			.avl = 0,
			.base = 0
		};
	}


	directorio[0] = mipage_dir;

	for (x = 0; x < 1024; x++) {
		tabla[x] = (page_table){
			.p = 1,
			.rw = 1,
			.us = 0,
			.pwt = 0,
			.pcd = 0,
			.a = 0,
			.d = 0,
			.pat = 0,
			.g = 0,
			.avl = 0,
			.base = x
		};
	}

}

unsigned int CR32UInt(cr3 uncr3) {
	unsigned int res = 0;
	res = res + (uncr3.ign_1);
	res = res + (uncr3.pwt << 3);
	res = res + (uncr3.pcd << 4);
	res = res + (uncr3.ign_2 << 5);
	res = res + (uncr3.base << 12);
	return res;
}

unsigned int obtener_pagina_libre() {
	unsigned int res = indice_pagina_libre;
	indice_pagina_libre += 0x1000;
	return res;
}

unsigned int mmu_inicializar_dir_zombie(unsigned int indiceTarea, unsigned int jugador) {
	unsigned int cr3_zombie = obtener_pagina_libre();

	int x = 0;
	for (x = 0; x < 0x400000; x += 0x1000) {
		mmu_mapear_pagina(x, cr3_zombie, x, 0);
	}

	if (jugador == 0) {
		mmu_inicializar_dir_zombieA(indiceTarea, cr3_zombie);
	} else if (jugador == 1) {

		mmu_inicializar_dir_zombieB(indiceTarea, cr3_zombie);
	}

	return cr3_zombie;
}

void mmu_inicializar_dir_zombieA(unsigned int indiceTarea, unsigned int cr3) {

	unsigned int pos_inicial_mapa = zombie_pos_memoria_jugador(0, indiceTarea);

	int x = 0;
	for (x = 0; x < 9; x++) {
		mmu_mapear_pagina(0x08000000 + (0x1000 * x), cr3, offset_pagina_zombie_A[x] + pos_inicial_mapa, 1);
	}

}

void mmu_inicializar_dir_zombieB(unsigned int indiceTarea, unsigned int cr3) {

	unsigned int pos_inicial_mapa = zombie_pos_memoria_jugador(1, indiceTarea);

	int x = 0;
	for (x = 0; x < 9; x++) {
		mmu_mapear_pagina(0x08000000 + (0x1000 * x), cr3, offset_pagina_zombie_B[x] + pos_inicial_mapa, 1);
	}

}

void mmu_mapear_pagina(unsigned int virtual, unsigned int cr3, unsigned int fisica, short nivel) {
	unsigned int directory_index = virtual;
	directory_index = directory_index >> 22;
	unsigned int table_index = virtual;
	table_index = table_index << 10;
	table_index = table_index >> 22;

	cr3 = cr3 >> 12;
	cr3 = cr3 << 12;

	page_dir* page_dir_programa = (page_dir*) cr3;
	page_dir * entrada_directorio = &(page_dir_programa[directory_index]);
	if (entrada_directorio->p == 0) {
		unsigned int entrada = obtener_pagina_libre();
		entrada_directorio->p = 1;
		entrada_directorio->base = (entrada >> 12);

	}
	entrada_directorio->us = nivel;
	entrada_directorio->rw = 1;
	page_table * page_table_programa = (page_table*) (entrada_directorio->base << 12);

	page_table * entrada_tabla = &(page_table_programa[table_index]);
	entrada_tabla->p = 1;
	entrada_tabla->us = nivel;
	entrada_tabla->rw = 1;
	entrada_tabla->base = fisica >> 12;
	tlbflush();
}

void mmu_unmapear_pagina(unsigned int virtual, unsigned int cr3) {
	unsigned int directory_index = virtual;
	directory_index = directory_index >> 22;
	unsigned int table_index = virtual;
	table_index = table_index << 10;
	table_index = table_index >> 22;

	cr3 = cr3 & 0xfffff000;


	page_dir * page_dir_programa = (page_dir*) cr3;
	page_dir * entrada_directorio = &page_dir_programa[directory_index];
	page_table * page_table_programa = (page_table*) (entrada_directorio->base << 12);

	page_table * entrada_tabla = &page_table_programa[table_index];

	entrada_tabla->p = 0;
	if (table_index == 0) {
		entrada_directorio->p = 0;
	}

	tlbflush();
}

void mmu_copiar_pagina(unsigned int * origen, unsigned int * destino) {
	int x;
	for (x = 0; x < 1024; x++) {
		destino[x] = origen[x];
	}
}


void  mmu_obtener_paginas_zombie(unsigned int jugador, unsigned int indicetarea, int * offsets){
	int altura = jugadores[jugador].zombies[indicetarea].y;
	int adelante = 1 - (2 * jugador); 
	int derecha = 78 - (156 * jugador); 
	int izquierda = - derecha; 
	if (altura == 0 && jugador == 0 ){
		izquierda = 78 * 43;
	}
	if (altura == 0 && jugador == 1 ){
		derecha = 78 * 43;
	}
	if (altura == 43 && jugador == 0 ){
		derecha = -(78 * 43);
	}
	if (altura == 43 && jugador == 1 ){
		izquierda = -(78 * 43);
	}
	
	offsets[0] = 0 ;
	offsets[1] = adelante;
	offsets[2] = adelante + derecha;
	offsets[3] = adelante + izquierda;
	offsets[4] = derecha;
	offsets[5] = izquierda;
	offsets[6] = -adelante;
	offsets[7] = -adelante + izquierda;
	offsets[8] = -adelante + derecha;

	int x = 0;
	for(x=0;x<9;x++){
		offsets[x] = offsets[x] * 0x1000;
	}
	
	
	zombie_descriptor zombie = jugadores[jugador].zombies[indicetarea];
	
	unsigned int * pos = (unsigned int *) zombie_pos_memoria(zombie.x,zombie.y);
	for (x = 0;x < 9; x++){
		offsets[x] = offsets[x] + (int)pos;
	}
	
}
