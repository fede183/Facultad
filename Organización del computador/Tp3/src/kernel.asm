; ** por compatibilidad se omiten tildes **
; ==============================================================================
; TRABAJO PRACTICO 3 - System Programming - ORGANIZACION DE COMPUTADOR II - FCEN
; ==============================================================================

%include "imprimir.mac"
%include "pantalla.mac"

global start
extern sched_inicializar
extern GDT_DESC
extern IDT_DESC
extern idt_inicializar
extern mmu_inicializar_dir_kernel
extern mmu_inicializar
extern mmu_mapear_pagina
extern idle
extern deshabilitar_pic
extern resetear_pic
extern habilitar_pic
;; Saltear seccion de datos
extern tss_inicializar
extern game_initialize
jmp start

;;
;; Seccion de datos.
;; -------------------------------------------------------------------------- ;;
iniciando_mr_msg db	 'Iniciando kernel (Modo Real)...'
iniciando_mr_len equ	$ - iniciando_mr_msg

iniciando_mp_msg db	 'Iniciando kernel (Modo Protegido)...'
iniciando_mp_len equ	$ - iniciando_mp_msg
nombre_grupo_msg db  'Lo de Charly / Bondiola'
nombre_grupo_len equ $ - nombre_grupo_msg
der_align_nombre equ 80 - (nombre_grupo_len )

relojes_zombis db '1 2 3 4 5 6 7 8'
relojes_zombis_len equ $-relojes_zombis
der_aling_relojes_zombis equ 70-(relojes_zombis_len)

;;
;; Seccion de código.
;; -------------------------------------------------------------------------- ;;
;extern GDT_DESC
;; Punto de entrada del kernel.
BITS 16
start:
	; Deshabilitar interrupciones
	cli

	; Cambiar modo de video a 80 X 50
	mov ax, 0003h
	int 10h ; set mode 03h
	xor bx, bx
	mov ax, 1112h
	int 10h ; load 8x8 font

	; Imprimir mensaje de bienvenida
	imprimir_texto_mr iniciando_mr_msg, iniciando_mr_len, 0x06, 0, 0
	
	; Habilitar A20
	call habilitar_A20
	
	; Cargar la GDT
	mov eax, GDT_DESC
	lgdt [GDT_DESC]
	
	; Setear el bit PE del registro CR0
	mov eax, cr0
	or eax, 1
	mov cr0, eax

	; Saltar a modo protegido
	jmp 0x40:codigoASMProtegido
	
BITS 32	
codigoASMProtegido:	
	; Establecer selectores de segmentos
	xor eax, eax
	mov ax, 0x50 
	mov ds, ax  
	mov es, ax
	mov gs, ax
	mov ss, ax
	mov ax, 0x60
	mov fs, ax

	; Establecer la base de la pila
	mov ebp, 0x27000
	mov esp, 0x27000

	; Imprimir mensaje de bienvenida
	imprimir_texto_mp iniciando_mp_msg, iniciando_mp_len, 0x2e, 2, 0

	; Inicializar pantalla
	imprimir_pantalla_inicial
	
	; Inicializar el manejador de memoria
	call  mmu_inicializar

	; Inicializar el directorio de paginas y Cargar directorio de paginas
	call  mmu_inicializar_dir_kernel

	; Inicializar la IDT
	call idt_inicializar

	; Cargar IDT
 	lidt [IDT_DESC]
	
	;Habilitar paginación
	mov eax, cr0
	or eax, 0x80000000
	mov cr0, eax
	
	;Pintar la linea negra y nombre del grupo
	imprimir_texto_mp nombre_grupo_msg, nombre_grupo_len, 0x0f, 0, der_align_nombre
	imprimir_texto_mp relojes_zombis, relojes_zombis_len, 0x0f, 46, 10
	imprimir_texto_mp relojes_zombis, relojes_zombis_len, 0x0f, 46, der_aling_relojes_zombis

	; Configurar controlador de interrupciones
	call mmu_inicializar
	call deshabilitar_pic
	call resetear_pic
	call habilitar_pic

	; Habilitar interrupciones(Empieza a correr el reloj)
	sti

	; Inicializar tss y tss de la tarea idle
	call tss_inicializar

	; Comienza el juego	Y se inicializa el sched
	call game_initialize

	; Cargar tarea inicial
	mov ax, 0x68
	ltr ax
	
	; Saltar a la primera tarea: Idle
	jmp 0x70:0
	
	; Ciclar infinitamente (por si algo sale mal...)
	mov eax, 0xFFFF
	mov ebx, 0xFFFF
	mov ecx, 0xFFFF
	mov edx, 0xFFFF
	jmp $
	jmp $

;; -------------------------------------------------------------------------- ;;

%include "a20.asm"
