/* ** por compatibilidad se omiten tildes **
================================================================================
 TRABAJO PRACTICO 3 - System Programming - ORGANIZACION DE COMPUTADOR II - FCEN
================================================================================
  definicion de estructuras para administrar tareas
 */

#include "tss.h"
#include "mmu.h"

tss tss_inicial;


tss tss_idle;


tss tss_zombisA[CANT_ZOMBIS];
tss tss_zombisB[CANT_ZOMBIS];

void tss_inicializar() {

	unsigned int base = (unsigned int) &tss_inicial;
	base = base << 16;
	base = base >> 16;
	gdt[GDT_IDX_TAREA_INICIAL].base_0_15 = (unsigned short) (base);
	base = (unsigned int) &tss_inicial << 8;
	base = base >> 24;
	gdt[GDT_IDX_TAREA_INICIAL].base_23_16 = (unsigned char) (base);
	base = (unsigned int) &tss_inicial >> 24;
	gdt[GDT_IDX_TAREA_INICIAL].base_31_24 = (unsigned char) (base);

	tss_idle_inicializar();
	

}

void tss_idle_inicializar() {
	unsigned int base = (unsigned int) &tss_idle;
	base = base << 16;
	base = base >> 16;
	gdt[GDT_IDX_TAREA_IDLE].base_0_15 = (unsigned short) (base);
	base = (unsigned int) &tss_idle << 8;
	base = base >> 24;
	gdt[GDT_IDX_TAREA_IDLE].base_23_16 = (unsigned char) (base);
	base = (unsigned int) &tss_idle >> 24;
	gdt[GDT_IDX_TAREA_IDLE].base_31_24 = (unsigned char) (base);

	tss_idle.ptl = 0;
	tss_idle.unused0 = 0;
	tss_idle.esp0 = 0x17000; 
	tss_idle.ss0 = 0x50;
	tss_idle.unused1 = 0;
	tss_idle.esp1 = 0;
	tss_idle.ss1 = 0;
	tss_idle.unused2 = 0;
	tss_idle.esp2 = 0;
	tss_idle.ss2 = 0;
	tss_idle.unused3 = 0;
	tss_idle.cr3 = 0x27000; //mismo que kernel
	tss_idle.eip = 0x00016000; //ip del enunciado
	tss_idle.eflags = 0x00000202; //interrupciones deshabilitadas
	tss_idle.eax = 0;
	tss_idle.ecx = 0;
	tss_idle.edx = 0;
	tss_idle.ebx = 0;
	tss_idle.esp = 0x27000; //misma pila que el kernel -.-
	tss_idle.ebp = 0x27000;
	tss_idle.esi = 0;
	tss_idle.edi = 0;
	tss_idle.es = 0x50;
	tss_idle.unused4 = 0;
	tss_idle.cs = 0x40;
	tss_idle.unused5 = 0;
	tss_idle.ss = 0x50;
	tss_idle.unused6 = 0;
	tss_idle.ds = 0x50;
	tss_idle.unused7 = 0;
	tss_idle.fs = 0x50;
	tss_idle.unused8 = 0;
	tss_idle.gs = 0x50;
	tss_idle.unused9 = 0;
	tss_idle.ldt = 0;
	tss_idle.unused10 = 0;
	tss_idle.dtrap = 0;
	tss_idle.iomap = 0xFFFF;

}

void completar_tss_zombie(unsigned int jugador, unsigned int indiceTarea) {
	
	tss * t = 0;
	unsigned int indiceTareaGDT;
	if (jugador == 0) {
		t = &(tss_zombisA[indiceTarea]);
	} else {
		t = &(tss_zombisB[indiceTarea]);
	}
	indiceTareaGDT = indiceTarea + 15 + (jugador * 8); //indiceTarea es de 1 a 8
	
	unsigned int base = (unsigned int) t << 16;
	base = base >> 16;
	gdt[indiceTareaGDT].base_0_15 = (unsigned short) (base);
	base = (unsigned int) t << 8;
	base = base >> 24;
	gdt[indiceTareaGDT].base_23_16 = (unsigned char) (base);
	base = (unsigned int) t >> 24;
	gdt[indiceTareaGDT].base_31_24 = (unsigned char) (base);


	t->ptl = 0;
	t->unused0 = 0;
	t->esp0 = obtener_pagina_libre()+0x1000;
	t->ss0 = 0x50;
	t->unused1 = 0;
	t->esp1 = 0;
	t->ss1 = 0;
	t->unused2 = 0;
	t->esp2 = 0;
	t->ss2 = 0;
	t->unused3 = 0;
	t->cr3 = mmu_inicializar_dir_zombie(indiceTarea, jugador);
	t->eip = 0x08000000;
	t->eflags = 0x00000202;
	t->eax = 0;
	t->ecx = 0;
	t->edx = 0;
	t->ebx = 0;
	t->esp = 0x08001000;
	t->ebp = 0x08001000;
	t->esi = 0;
	t->edi = 0;
	t->es = 0x5B;
	t->unused4 = 0;
	t->cs = 0x4B;
	t->unused5 = 0;
	t->ss = 0x5B;
	t->unused6 = 0;
	t->ds = 0x5B;
	t->unused7 = 0;
	t->fs = 0x5B;
	t->unused8 = 0;
	t->gs = 0x5B;
	t->unused9 = 0;
	t->ldt = 0;
	t->unused10 = 0;
	t->dtrap = 0;
	t->iomap = 0xFFFF;

}