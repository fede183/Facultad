; ** por compatibilidad se omiten tildes **
; ==============================================================================
; TRABAJO PRACTICO 3 - System Programming - ORGANIZACION DE COMPUTADOR II - FCEN
; ==============================================================================
; definicion de rutinas de atencion de interrupciones

%include "imprimir.mac"
extern syscall_mover
extern datos_debug 
extern zombie_estado_reloj
extern zombie_actualizar_reloj

BITS 32


mascara_interrupciones_errorcode: dd 0x00027d00
sched_tarea_offset:     dd 0x00
sched_tarea_selector:   dw 0x00

msg_reg: db "0x00000000"
msg_reg_len: equ	10

mapa_interrupcion_error_code: dd 00000000000000100111110100000000b


msg_int_0: db "Divide Error"
msg_int_0_len: equ	$ - msg_int_0
msg_int_2: db "NMI Interrupt"
msg_int_2_len: equ	$ - msg_int_2
msg_int_3: db "Breakpoint"
msg_int_3_len: equ	$ - msg_int_3
msg_int_4: db "Overflow"
msg_int_4_len: equ	$ - msg_int_4
msg_int_5: db "BOUND Range Exceeded"
msg_int_5_len: equ	$ - msg_int_5
msg_int_6: db "Invalid Opcode"
msg_int_6_len: equ	$ - msg_int_6
msg_int_7: db "Device Not Available"
msg_int_7_len: equ	$ - msg_int_7
msg_int_8: db "Double Fault"
msg_int_8_len: equ	$ - msg_int_8
msg_int_9: db "Coprocessor Segment Overrun"
msg_int_9_len: equ	$ - msg_int_9
msg_int_10: db "Invalid TSS"
msg_int_10_len: equ	$ - msg_int_10
msg_int_11: db "Segment Not Present"
msg_int_11_len: equ	$ - msg_int_11
msg_int_12: db "Stack-Segment Fault"
msg_int_12_len: equ	$ - msg_int_12
msg_int_13: db "General Protection"
msg_int_13_len: equ	$ - msg_int_13
msg_int_14: db "Page Fault"
msg_int_14_len: equ	$ - msg_int_14
msg_int_16: db "x87 FPU Floating-Point Error"
msg_int_16_len: equ	$ - msg_int_16
msg_int_17: db "Alignment Check"
msg_int_17_len: equ	$ - msg_int_17
msg_int_18: db "Machine Check"
msg_int_18_len: equ	$ - msg_int_18
msg_int_19: db "SIMD Floating-Point Exception"
msg_int_19_len: equ	$ - msg_int_19
;; PIC
extern fin_intr_pic1

;; Sched
extern sched_proximo_indice
extern convertir_scancode
extern print_hex
extern sched_jugador
extern sched_indice_actual
extern jugadores
extern debug_zombie
extern guardar_pantalla
extern zombie_matar_zombie
extern pantalla_debug_activa
extern debug_on
extern no_jump
extern zombie_mover

global _isr32
global _isr33
global _isr102
;;
;; Definición de MACROS
;; -------------------------------------------------------------------------- ;;


%macro DEBUG_ESTRUCTURA 0 ;Funcion para completar la estructura datos_debug para despues mostrarla con la pantalla de debug
	push eax

	mov [datos_debug], eax
    mov [datos_debug+4], ebx
    mov [datos_debug+8], ecx
    mov [datos_debug+12], edx
    mov [datos_debug+16], esi
    mov [datos_debug+20], edi
    mov [datos_debug+24], ebp
    mov eax, [esp+16]
    mov [datos_debug+28], eax
    mov eax, [esp+4]
    mov [datos_debug+32], eax
    mov eax, [esp+8]
    mov [datos_debug+36], ax
    mov eax, [esp+20]
    mov [datos_debug+38], ax
    mov [datos_debug+40], ds
    mov [datos_debug+42], fs
    mov [datos_debug+44], gs
    mov [datos_debug+46], es
    mov eax, [esp+12]
    mov [datos_debug+48], ax

	pop eax
%endmacro

%macro ISR 1

global _isr%1

_isr%1:
	cli

	mov dword[no_jump], 0   ;valor predeterminado de no_jump

	pushad
    call zombie_matar_zombie
	test eax, eax
	popad
	jnz .jump

	mov dword[no_jump], 1

.jump:	
	cmp dword [debug_on], 0
	je .noDebugger
	bt dword[mapa_interrupcion_error_code], %1
	jnc .sinError
	add esp,4 			;Cambiamos la pila para no contar el error code

.sinError:

	DEBUG_ESTRUCTURA  ;Guardo los datos en la estructura datos_debug

	push 0
	call guardar_pantalla   ;guardar_pantalla(0) esto respalda la pantalla
	add esp, 4

	mov dword [pantalla_debug_activa], 1
	pushad
	call debug_zombie
	popad

.noDebugger:
	imprimir_texto_mp msg_int_%1, msg_int_%1_len, 0x2e, 0, 2 ;Mensaje de que excepcion es
	cmp dword[no_jump], 0  ;Si no cambio el valor predeterminado entronces terminaremos la excepcion
	jz .fin
	mov dword [sched_indice_actual], 0x70
	jmp 0x70:0 ; 

.fin:
	sti
    jmp $

%endmacro

;;
;; Datos
;; -------------------------------------------------------------------------- ;;

; Scheduler
isrnumero:           dd 0x00000000
isrClock:            db "|/-\"

;;
;; Rutina de atención de las EXCEPCIONES
;; -------------------------------------------------------------------------- ;;

ISR 0
ISR 2
ISR 3
ISR 4
ISR 5
ISR 6
ISR 7
ISR 8
ISR 9
ISR 10
ISR 11
ISR 12
ISR 13
ISR 14
ISR 16
ISR 17
ISR 18
ISR 19

;;
;; Rutina de atención del RELOJ
;; -------------------------------------------------------------------------- ;;


_isr32:
	
	cli 
	pushad
	call fin_intr_pic1

	call zombie_estado_reloj
	
	cmp byte[pantalla_debug_activa], 0   ;Si la pantalla de debug esta activa entonces no saltamos a ninguna tarea y continuamos con la idle
	jne .nojump
	call proximo_reloj
	call sched_proximo_indice
	
	push eax
	call zombie_actualizar_reloj
	pop eax
	
	test ax, ax
	jz .nojump
	
	mov [sched_tarea_selector], ax
	jmp far [sched_tarea_offset]
	
.nojump:
	
	popad
	sti
	iret

;;
;; Rutina de atención del TECLADO
;; -------------------------------------------------------------------------- ;;

_isr33:
	cli
	DEBUG_ESTRUCTURA
	pushad
	call fin_intr_pic1
	
    xor eax, eax

	in al, 0x60     			;Obtenemos la tecla que se presiono
	push eax
	call convertir_scancode		
	add esp, 4
	test eax, eax
	jz .fin
	push eax
	mov eax, esp
	imprimir_texto_mp eax, 1, 0x2e, 0, 0   ;Imprime la tecla presionada
	add esp,4
	
	.fin:
	
	popad
	sti
	iret


_isr102:
	cli
	push eax 
	call zombie_mover
	pop eax
	
	mov dword [sched_indice_actual], 0x70
	
	jmp 0x70:0
	
	sti
	iret


;;
;; Rutinas de atención de las SYSCALLS
;; -------------------------------------------------------------------------- ;;

%define IZQ 0xAAA
%define DER 0x441
%define ADE 0x83D
%define ATR 0x732


;; Funciones Auxiliares
;; -------------------------------------------------------------------------- ;;
proximo_reloj:
        pushad
        inc DWORD [isrnumero]
        mov ebx, [isrnumero]
        cmp ebx, 0x4
        jl .ok
                mov DWORD [isrnumero], 0x0
                mov ebx, 0
        .ok:
                add ebx, isrClock
                imprimir_texto_mp ebx, 1, 0x0f, 49, 79
                popad
        ret
        

