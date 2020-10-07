global sierpinski_asm

section .data

sierpinski_float: dd 255.00,255.00,255.00,255.00
aumentos_i_j: dd 0,1,2,3


section .text

;void sierpinski_asm (unsigned char *src,  	RDI
;                     unsigned char *dst,	RSI
;                     int cols, int rows,	EDX ECX
;                     int src_row_size,		R8d
;                     int dst_row_size)		R9d

sierpinski_asm:

	push rbp
	mov rbp, rsp
	push r12 ;uso para columnas (j)
	push r13 ;uso para filas (i)
	push r14 ;guardo src
	push r15 ;guardo dst
	push r11 
	push rbx
	
	
	mov r14, rdi ; src
	mov r15, rsi ; dst
	
	mov r12d, edx ;cols
	mov r13d, ecx ;filas
	
	xor r11d, r11d ; para recorrer
	xor ebx, ebx ; para recorrer
	
	.ciclo:
		
		cmp r11d, r13d
		jz .fin
		cmp ebx, r12d
		jz .aumentarI
	
	
			;opero:
			
			movdqu xmm1, [r14]	;xmm1 = |Pixel4|Pixel3|Pixel2|Pixel1|
			
			pxor xmm7, xmm7
			
			movdqu xmm2, xmm1
			punpcklbw xmm1, xmm7	;xmm1=|Pixel2|Pixel1|
			punpckhbw xmm2, xmm7	;xmm2=|Pixel4|Pixel3|
			
			movdqu xmm3, xmm1       
			punpcklwd xmm1, xmm7	;xmm1=|Pixel1|
			punpckhwd xmm3, xmm7	;xmm3=|Pixel2|
			
			movdqu xmm4, xmm2
			punpcklwd xmm2, xmm7	;xmm2=|Pixel3|
			punpckhwd xmm4, xmm7	;xmm4=|Pixel4|
			
			;Tengo 4 pixeles en registros xmm, cada canal de color como dword
			
					;calculo los 4 coeficientes:
					mov edi, r11d ; i como parametro
					mov esi, ebx ; j como parametro
					mov edx, r13d ; cant filas
					mov ecx, r12d ; cant de columnas
					call coef_sierpinski ;función auxiliar que calcula coef
					
					;xmm0 = |coeficiente4|coeficiente3|coficiente2|coeficiente1|
					
					
					;broadcast de los ceficientes en 4 registros para multiplicar a cada pixel
					movdqu xmm15, xmm0
					shufps xmm15, xmm15 , 0h

					movdqu xmm14, xmm0
					shufps xmm14, xmm14 , 55h

					movdqu xmm13, xmm0
					shufps xmm13, xmm13, 0xAA

					movdqu xmm12, xmm0
					shufps xmm12, xmm12, 0xFF


					
				;convierto a float para multiplicar por coeficientes
				
				CVTDQ2PS xmm1, xmm1
				CVTDQ2PS xmm2, xmm2
				CVTDQ2PS xmm3, xmm3
				CVTDQ2PS xmm4, xmm4
				
				mulps xmm1, xmm15
				mulps xmm3, xmm14
				mulps xmm2, xmm13
				mulps xmm4, xmm12
				
				CVTtPS2DQ xmm1, xmm1
				CVTtPS2DQ xmm3, xmm3
				CVTtPS2DQ xmm2, xmm2
				CVTtPS2DQ xmm4, xmm4
				
				
				;Empaqueto nuevamente.
				
				
				packusdw xmm2, xmm4	;xmm2= |Pixel4|Pixel3|
				packusdw xmm1, xmm3	;xmm1= |Pixel2|Pixel1|
				
				packuswb xmm1, xmm2 ;xmm1= |Pixel4|Pixel3|Pixel2|Pixel1| //recupere los 4 pixeles con el filtro ya aplicado
				
				
				
				movdqu [r15], xmm1 
					
	add r15, 16
	add r14, 16
	add ebx, 4
	jmp .ciclo
	

	
.aumentarI:
	add r11d, 1
	xor ebx, ebx
	jmp .ciclo
	.fin:

	pop rbx
	pop r11
	pop r15
	pop r14
	pop r13
	pop r12
	pop rbp
    ret







coef_sierpinski:
;float coer_sierpinski(int i, int j, int filas, int cols)

	push rbp
	mov rbp, rsp
	
	;EDI: i - ESI: j - EDX: filas - ECX: cols
	;coef: 1/255([i/filas*255]xor[j/cols*255])
	
	

	pxor xmm0, xmm0; pongo en 0 en registro a retornar

	movd xmm8, edi
	shufps xmm8, xmm8, 0h ;xmm8: |i|i|i|i|
	
	movd xmm9, esi
	shufps xmm9, xmm9, 0h
	paddd xmm9, [aumentos_i_j] ;xmm9: |j+3|j+2|j+1|j+0|

	movd xmm10, edx
	shufps xmm10, xmm10, 0h ;xmm10: |filas|filas|filas|filas|

	movd xmm11, ecx
	shufps xmm11, xmm11, 0h	;xmm11: |cols|cols|cols|cols|

	
	cvtdq2ps xmm8, xmm8
	cvtdq2ps xmm9, xmm9
	cvtdq2ps xmm10, xmm10
	cvtdq2ps xmm11, xmm11


	divps xmm8, xmm10	;xmm8: |i/filas|i/filas|i/filas|i/filas|
	divps xmm9, xmm11 	;xmm9: |j+3/columnas|j+2/columnas|j+1/columnas|j+0/columnas|

	
	mulps xmm8, [sierpinski_float]
	mulps xmm9, [sierpinski_float]

	cvttps2dq xmm8, xmm8
	cvttps2dq xmm9, xmm9
	
	pxor xmm8, xmm9

	cvtdq2ps xmm8, xmm8

	divps xmm8, [sierpinski_float]

	movdqu xmm0, xmm8

	pop rbp
	ret
