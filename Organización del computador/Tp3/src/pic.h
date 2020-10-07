/* ** por compatibilidad se omiten tildes **
================================================================================
 TRABAJO PRACTICO 3 - System Programming - ORGANIZACION DE COMPUTADOR II - FCEN
================================================================================
  funciones del controlador de interrupciones
*/

#ifndef __PIC_H__
#define __PIC_H__


typedef struct str_aux_debug {
    unsigned int eax;
    unsigned int ebx;
    unsigned int ecx;
    unsigned int edx;
    unsigned int esi;
    unsigned int edi;
    unsigned int ebp;
    unsigned int esp;
    unsigned int eip;
    unsigned short cs;
    unsigned short ss;
    unsigned short ds;
    unsigned short fs;
    unsigned short gs;
    unsigned short es;
    unsigned int eflags;
} __attribute__((__packed__, aligned (8))) aux_debug;

aux_debug datos_debug;

void debug_zombie();

void resetear_pic(void);
void habilitar_pic();
void deshabilitar_pic();

static __inline __attribute__((always_inline)) void outb(int port, unsigned char data);

__inline __attribute__((always_inline)) void fin_intr_pic1(void);
__inline __attribute__((always_inline)) void fin_intr_pic2(void);


char convertir_scancode(unsigned char scode);
void guardar_pantalla(int accion);
#endif	/* !__PIC_H__ */
