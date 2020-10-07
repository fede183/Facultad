
global mblur_asm

section .data
coheficientes: dd 0.2,0.2,0.2,0.2



mascara_rojos: db  00h,80h,80h,80h,04h,80h,80h,80h,08h,80h,80h,80h,0Ch,80h,80h,80h
mascara_verdes: db 01h,80h,80h,80h,05h,80h,80h,80h,09h,80h,80h,80h,0Dh,80h,80h,80h
mascara_azules: db 02h,80h,80h,80h,06h,80h,80h,80h,0Ah,80h,80h,80h,0Eh,80h,80h,80h

mascara_rojo_volve: db  00h,80h,80h,80h,04h,80h,80h,80h,08h,80h,80h,80h,0Ch,80h,80h,80h
mascara_verde_volve: db 80h,00h,80h,80h,80h,04h,80h,80h,80h,08h,80h,80h,80h,0Ch,80h,80h
mascara_azule_volve: db 80h,80h,00h,80h,80h,80h,04h,80h,80h,80h,08h,80h,80h,80h,0Ch,80h

mascara_blanca: dq -1,-1,-1,-1

%define pixel_tam 4
%define dospixels_tam 2*pixel_tam
%define cuatropixels_tam 4*pixel_tam


%macro calcularSobreRDI 0
	;Suposiciones: 
	;	1. rsi y rdi apuntan a la misma posicion en las imagenes destindo y origen respectivamente
	; 	2. Puedo usar todos los registros SSE
	;	3. rax, y rbx no los usaron
	
	; rdi = &imOrigen[i][j]
	; rsi = &imDestino[i][j]
	xor rax, rax
	xor rbx, rbx
	pxor xmm2, xmm2
	mov rax, r8
	add rax, pixel_tam			; rax, tiene el tamanio del salto (+1,+1)
	sub rbx, rax 				; (-1, -1)
	shl rbx, 1					; (-2, -2)
	
	movdqu xmm1, [rdi + rbx]	; imOrigen[i-2][j-2]
	xmm1porpunto2
	movdqu xmm2, xmm1			; imOrigen[i-2][j-2] * .2
	
	sar rbx, 1					;  (-1, -1)
	movdqu xmm1, [rdi + rbx]	; imOrigen[i-1][j-1]
	xmm1porpunto2
	paddb xmm2, xmm1			; (imOrigen[i-2][j-2] * .2) + (imOrigen[i-1][j-1] * .2)
	
	movdqu xmm1, [rdi]			; imOrigen[i][j]
	xmm1porpunto2
	paddb xmm2, xmm1			; (imOrigen[i-2][j-2] * .2) + (imOrigen[i-1][j-1] * .2) + (imOrigen[i][j] * .2)
	
	neg rbx						; (+1)(+1)
	movdqu xmm1, [rdi + rbx]	; imOrigen[i+1][j+1]
	xmm1porpunto2
	paddb xmm2, xmm1			; (imOrigen[i-2][j-2] * .2) + (imOrigen[i-1][j-1] * .2)  + (imOrigen[i+1][j+1] * .2)
	
	shl rbx, 1					; (+2)(+2)
	movdqu xmm1, [rdi + rbx]	; imOrigen[i+1][j+1]
	xmm1porpunto2
	paddb xmm2, xmm1			; (imOrigen[i-2][j-2] * .2) + (imOrigen[i-1][j-1] * .2)  + (imOrigen[i+1][j+1] * .2)  + (imOrigen[i+2][j+2] * .2)
	
	movdqu [rsi], xmm2
	add rsi, cuatropixels_tam
	add rdi, cuatropixels_tam
	
%endmacro

%macro xmm1porpunto2 0
	movdqu xmm3, xmm1 
	pshufb  xmm3, xmm10	;separo rojos
	movdqu xmm4, xmm1 
	pshufb  xmm4, xmm11	;separo verdes
	movdqu xmm5, xmm1 
	pshufb  xmm5, xmm12	;separo azules
	
	; los paso a float para multiplicar
	cvtdq2ps xmm3,xmm3
	cvtdq2ps xmm4,xmm4
	cvtdq2ps xmm5,xmm5
	
	;multiplico
	mulps xmm3, xmm9
	mulps xmm4, xmm9
	mulps xmm5, xmm9
	
	;los paso a enteros truncados
	cvttps2dq xmm3,xmm3
	cvttps2dq xmm4,xmm4
	cvttps2dq xmm5,xmm5
	
	pshufb  xmm3, xmm13	;reacomodo rojos
	pshufb  xmm4, xmm14	;reacomodo verdes
	pshufb  xmm5, xmm15	;reacomodo azules
	
	; junto las partes
	movdqu xmm1, xmm3
	por xmm1, xmm4
	por xmm1, xmm5
	
%endmacro

%macro cargarMascaras 0
	movdqu xmm10, [mascara_rojos]
	movdqu xmm11, [mascara_verdes]
	movdqu xmm12, [mascara_azules]
	movdqu xmm13, [mascara_rojo_volve]
	movdqu xmm14, [mascara_verde_volve]
	movdqu xmm15, [mascara_azule_volve]
	movdqu xmm9,  [coheficientes] 
%endmacro


section .text
;void mblur_asm    (
	;unsigned char *src, 	rdi
	;unsigned char *dst, 	rsi
	;int filas, 			edx
	;int cols, 				ecx
	;int src_row_size,		r8
	;int dst_row_size)		r9

mblur_asm:
	push rbp
	mov rbp, rsp
	push r12
	push r13
	push r14
	push r15
	push rbx
	cargarMascaras
	xor rax, rax
	mov eax, r8d
	mov r8, rax ; mequedo con una version limpia de 64 bits del ancho :)
	mov r12, rdi
	mov r13, rsi
	xor r14,r14
	mov r14d, ecx
	xor r15,r15
	mov r15d, edx
	

	
	;escribo 2 lineas negras
	mov rcx, r8
	
	pxor xmm0, xmm0
	shl rcx, 1; escribo 2 lineas
	shr rcx, 4; escribo de a 4 pixels de 4 bytes cada uno 

.lineasTop:
	movdqu [rsi], xmm0
	add rsi, cuatropixels_tam
	add rdi, cuatropixels_tam
	loop .lineasTop	
		
	;copio imagen borroneada
	mov rdx, r14
	add rsi, dospixels_tam
	add rdi, dospixels_tam
	sub rdx, 4 					; le saco superior e inferior
.empezarFila:
	mov rcx, r15
	sub rcx, 4 	; saco bordes
	shr rcx, 2	; trabajo de a 4 pixels
.ciclarPixels:
	calcularSobreRDI
	
	
	dec rcx
	jz .terminarCicloPixels
	jmp .ciclarPixels
.terminarCicloPixels:
	add rsi, cuatropixels_tam	;salto el borde
	add rdi, cuatropixels_tam	;salto el borde
	dec rdx
	jz .terminarCicloFilas
	jmp .empezarFila
.terminarCicloFilas:

	;escribo 2 lineas negras
	mov rsi, r13
	mov rax, r14
	sub rax, 2
	mul r8
	add rsi, rax
	;add rsi, cuatropixels_tam 	; + 4 para salir de la zona de dibujo
	;add rsi, dospixels_tam		; + 2 para llegar a la fila de abajo
	mov rcx, r15
	shl rcx, 1; escribo 2 lineas
	shr rcx, 2; escribo de a 4 pixels
	pxor xmm0, xmm0
.lineasBot:
	movdqu [rsi], xmm0
	add rsi, cuatropixels_tam
	loop .lineasBot	





	;escribo bordes negros
	mov rcx, r14
	sub ecx, 4 					;ciclo filas-4(superiores + inferiores) veces 
	
	mov rdi, r13
	add rdi, r8
	add rdi, r8 				;bajo 2 filas - obtengo fila izq
	
	mov rsi, rdi
	add rsi, r8
	sub rsi, dospixels_tam		; obtengo fila der
.cicloLaterales:	
	movq [rdi], mm0
	movq [rsi], mm0				;pinto negro ambos lados
	add rdi, r8
	add rsi, r8
	loop .cicloLaterales
	
	pop rbx
	pop r15
	pop r14
	pop r13 
	pop r12
	pop rbp
    ret
 



