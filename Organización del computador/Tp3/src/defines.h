/* ** por compatibilidad se omiten tildes **
================================================================================
 TRABAJO PRACTICO 3 - System Programming - ORGANIZACION DE COMPUTADOR II - FCEN
================================================================================

    Definiciones globales del sistema.
*/

#ifndef __DEFINES_H__
#define __DEFINES_H__

/* Bool */
/* -------------------------------------------------------------------------- */
#define TRUE                    0x00000001
#define FALSE                   0x00000000
#define ERROR                   1


/* Misc */
/* -------------------------------------------------------------------------- */
#define CANT_ZOMBIS             8

#define SIZE_W                  78
#define SIZE_H                  44


/* Indices en la gdt */
/* -------------------------------------------------------------------------- */
#define GDT_COUNT 32

#define GDT_IDX_NULL_DESC           0
#define GDT_IDX_CODIGO_1           8
#define GDT_IDX_CODIGO_2           9
#define GDT_IDX_DATOS_1           10
#define GDT_IDX_DATOS_2           11
#define GDT_IDX_PANTALLA          12
#define GDT_IDX_TAREA_INICIAL		13
#define GDT_IDX_TAREA_IDLE		14
    
#define GDT_IDX_ZOMBI_A_1     	15
#define GDT_IDX_ZOMBI_A_2     	16
#define GDT_IDX_ZOMBI_A_3     	17
#define GDT_IDX_ZOMBI_A_4     	18
#define GDT_IDX_ZOMBI_A_5     	19
#define GDT_IDX_ZOMBI_A_6     	20
#define GDT_IDX_ZOMBI_A_7     	21
#define GDT_IDX_ZOMBI_A_8     	22

#define GDT_IDX_ZOMBI_B_1     	23
#define GDT_IDX_ZOMBI_B_2     	24
#define GDT_IDX_ZOMBI_B_3     	25
#define GDT_IDX_ZOMBI_B_4     	26
#define GDT_IDX_ZOMBI_B_5     	27
#define GDT_IDX_ZOMBI_B_6     	28
#define GDT_IDX_ZOMBI_B_7     	29
#define GDT_IDX_ZOMBI_B_8     	30

/* Offsets en la gdt */
/* -------------------------------------------------------------------------- */
#define GDT_OFF_NULL_DESC           (GDT_IDX_NULL_DESC      << 3)

/* Indices en la idt */
/* -------------------------------------------------------------------------- */
#define IDT_COUNT 255

#define IDT_IDX_GENERAL_PROTECTION 13

/* Paginacion */
/* -------------------------------------------------------------------------- */ 
#define page_dir_kernel  0x27000
#define page_table_kernel_0  0x28000
#define page_table_kernel_1  0x29000

/* Direcciones de memoria */
/* -------------------------------------------------------------------------- */
#define VIDEO                   0x000B8000 /* direccion fisica del buffer de video */
#define primera_pagina_libre	0x00100000
#define base_mapa				0x00400000


#endif  /* !__DEFINES_H__ */
