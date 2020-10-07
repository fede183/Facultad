
	list p=16f84a
	include "p16f84a.inc"
	__CONFIG   _CP_OFF & _WDT_OFF & _PWRTE_OFF & _XT_OSC ; Configuracion del Pic

	; Comienzo del programa

	org	0x000			; Org es un comando para el ensamblador NO genera codigo esta sentencia 
					; define el comienzo del cdigo que sigue a partir de la direccn de memoria 0x000
	goto	Inicio			; Salto al inicio del programa.

	org	0x005			; Origen del codigo del programa.

Inicio
	; Configuracion PORTB
	banksel	TRISB
	clrf	TRISB			; PORTB es Output

Main
	
	banksel	PORTB
	movlw	0xFF
	movwf	PORTB
	end
