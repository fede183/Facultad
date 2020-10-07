/* ** por compatibilidad se omiten tildes **
================================================================================
 TRABAJO PRACTICO 3 - System Programming - ORGANIZACION DE COMPUTADOR II - FCEN
================================================================================
  funciones del controlador de interrupciones
*/

#include "pic.h"
#include "game.h"
#include "sched.h"

#define PIC1_PORT 0x20
#define PIC2_PORT 0xA0

static __inline __attribute__((always_inline)) void outb(int port, unsigned char data) {
    __asm __volatile("outb %0,%w1" : : "a" (data), "d" (port));
}
__inline __attribute__((always_inline)) void fin_intr_pic1(void) { outb(0x20, 0x20); }
__inline __attribute__((always_inline)) void fin_intr_pic2(void) { outb(0x20, 0x20); outb(0xA0, 0x20); }

void resetear_pic() {
    outb(PIC1_PORT+0, 0x11); /* IRQs activas x flanco, cascada, y ICW4 */
    outb(PIC1_PORT+1, 0x20); /* Addr */
    outb(PIC1_PORT+1, 0x04); /* PIC1 Master, Slave ingresa Int.x IRQ2 */
    outb(PIC1_PORT+1, 0x01); /* Modo 8086 */
    outb(PIC1_PORT+1, 0xFF); /* Enmasca todas! */

    outb(PIC2_PORT+0, 0x11); /* IRQs activas x flanco, cascada, y ICW4 */
    outb(PIC2_PORT+1, 0x28); /* Addr */
    outb(PIC2_PORT+1, 0x02); /* PIC2 Slave, ingresa Int x IRQ2 */
    outb(PIC2_PORT+1, 0x01); /* Modo 8086 */
    outb(PIC2_PORT+1, 0xFF); /* Enmasca todas! */
}

void habilitar_pic() {
    outb(PIC1_PORT+1, 0x00);
    outb(PIC2_PORT+1, 0x00);
}

void deshabilitar_pic() {
    outb(PIC1_PORT+1, 0xFF);
    outb(PIC2_PORT+1, 0xFF);
}



void guardar_pantalla(int accion){ 
	int x;
	unsigned short *pantalla=(unsigned short*)VIDEO;
	if(accion==1){ 
		for(x=0;x<4000;x++){
			pantalla[x]=respaldo_pantalla[x];//Restauro la pantalla guardada
		}
	}
	else if(accion==0){ 
		for(x=0;x<4000;x++){
			respaldo_pantalla[x]=pantalla[x];//Guardo la pantalla
		}
	}
}

char convertir_scancode(unsigned char scode){
	char  res;
	switch(scode){
		case 0xaa:
			if(!pantalla_debug_activa){
				res = 'Z';
				game_lanzar_zombi(0);
			}
			
			break;
		case 0xb6:
			if(!pantalla_debug_activa){
				res = 'R';
				game_lanzar_zombi(1);
			}
			break;
		case 0x9e:
			if(!pantalla_debug_activa){
				res = 'A';
				game_switch_zombie_type_izq(0);
			}
			break;
		case 0x9f:
			if(!pantalla_debug_activa){
				res = 'S';
				game_jugador_mover(0,1);
			}
			break;
		case 0xa0:
			if(!pantalla_debug_activa){
				res = 'D';
				game_switch_zombie_type_der(0);
			}
			break;
		case 0x91:
			if(!pantalla_debug_activa){
				res = 'W';
				game_jugador_mover(0,-1);
			}
			break;
		case 0xa4:
			if(!pantalla_debug_activa){
				res = 'J';
				game_switch_zombie_type_izq(1);
			}
			break;
		case 0xa5:
			if(!pantalla_debug_activa){
				res = 'K';
				game_jugador_mover(1,1);
			}
			break;
		case 0xa6:
			if(!pantalla_debug_activa){
				res = 'L';
				game_switch_zombie_type_der(1);
			}
			break;
		case 0x97:
			if(!pantalla_debug_activa){
				res = 'I';
				game_jugador_mover(1,-1);
			}
			break;
		case 0x15: //Hay que hacer que el sched no haga nada cuando debug=true
			res = 'Y';
			if(pantalla_debug_activa){
				pantalla_debug_activa=false;
				guardar_pantalla(1);
			}
			else{
				debug_on=!debug_on;
			}
			if(debug_on) print("debug", 50, 0, 0x0C);
			else print("     ", 50, 0, 0x00);
			break;
		default :
			res = 0;
			break;
	}
	return res;
}

void debug_zombie(){
	int x=0;
	//Dibujar borde
	print("Zombie                        ", 25, 8, 0x0F);
	if (sched_jugador==0){
		
		if(zombiesA[sched_indice_tarea_A].tipo=='G'){
			print("A Guerrero", 31, 8, 0x0F);
		}
		else if(zombiesA[sched_indice_tarea_A].tipo=='M'){
			print("A Mago", 31, 8, 0x0F);
		}
		else if(zombiesA[sched_indice_tarea_A].tipo=='C'){
			print("A Clerigo", 31, 8, 0x0F);
		}
		
	}
	else {
		if(zombiesB[sched_indice_tarea_B].tipo=='G'){
			print("B Guerrero", 31, 8, 0x0F);
		}
		else if(zombiesB[sched_indice_tarea_B].tipo=='M'){
			print("B Mago", 31, 8, 0x0F);
		}
		else if(zombiesA[sched_indice_tarea_B].tipo=='C'){
			print("B Clerigo", 31, 8, 0x0F);
		}
	}


	for(x=0;x<33;x++){
		print("                              ", 25, 9+x, 0x70);	
		print(" ", 24, 8+x, 0x0F);
		print(" ", 55, 8+x, 0x0F);
	}
	for(x=0;x<2;x++){
		print(" ", 24, 41+x, 0x0F);
		print(" ", 55, 41+x, 0x0F);	
	}

	print("                              ", 25, 42, 0x0F);
	// Dibujar registros
	print("eax:", 26, 10, 0x70);
	print("ebx:", 26, 12, 0x70);
	print("ecx:", 26, 14, 0x70);
	print("edx:", 26, 16, 0x70);
	print("esi:", 26, 18, 0x70);
	print("edi:", 26, 20, 0x70);
	print("ebp:", 26, 22, 0x70);
	print("esp:", 26, 24, 0x70);
	print("eip:", 26, 26, 0x70);
	print("cs:", 26, 28, 0x70);
	print("ss:", 26, 30, 0x70);
	print("ds:", 26, 32, 0x70);
	print("fs:", 26, 34, 0x70);
	print("gs:", 26, 36, 0x70);
	print("es:", 26, 38, 0x70);
	print("eflags:", 26, 40, 0x70);
	print("stack:", 40, 30, 0x70);
	print("tarea_actual", 40, 20, 0x70);
	print_hex(sched_indice_actual, 2, 40, 22, 0x70);
	print("cr0:", 40, 10, 0x70);
	print("cr2:", 40, 12, 0x70);
	print("cr3:", 40, 14, 0x70);
	print("cr4:", 40, 16, 0x70);


	
	print_hex(datos_debug.eax,8, 30, 10, 0x7F);
	print_hex(datos_debug.ebx,8, 30, 12, 0x7F);
	print_hex(datos_debug.ecx,8, 30, 14, 0x7F);
	print_hex(datos_debug.edx,8, 30, 16, 0x7F);
	print_hex(datos_debug.esi,8, 30, 18, 0x7F);
	print_hex(datos_debug.edi,8, 30, 20, 0x7F);
	print_hex(datos_debug.ebp,8, 30, 22, 0x7F);
	print_hex(datos_debug.esp,8, 30, 24, 0x7F);
	print_hex(datos_debug.eip,8, 30, 26, 0x7F);
	print_hex(datos_debug.cs,4, 29, 28, 0x7F);
	print_hex(datos_debug.ss,4, 29, 30, 0x7F);
	print_hex(datos_debug.ds,4, 29, 32, 0x7F);
	print_hex(datos_debug.fs,4, 29, 34, 0x7F);
	print_hex(datos_debug.gs,4, 29, 36, 0x7F);
	print_hex(datos_debug.es,4, 29, 38, 0x7F);
	print_hex(datos_debug.eflags,8, 33, 40, 0x7F);
	print_hex(*(unsigned int *)(datos_debug.esp+8),8, 45, 32, 0x7F);
	print_hex(*(unsigned int *)(datos_debug.esp+12),8, 45, 34, 0x7F);
	print_hex(*(unsigned int *)(datos_debug.esp+16),8, 45, 36, 0x7F);
	print_hex(*(unsigned int *)(datos_debug.esp+20),8, 45, 38, 0x7F);
	print_hex(*(unsigned int *)(datos_debug.esp+24),8, 45, 40, 0x7F);

	print_hex(rcr0(),8, 44, 10, 0x7F);
	print_hex(rcr2(),8, 44, 12, 0x7F);
	print_hex(rcr3(),8, 44, 14, 0x7F);
	print_hex(rcr4(),8, 44, 16, 0x7F);
}


