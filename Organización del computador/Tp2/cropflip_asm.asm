global cropflip_asm

section .text
;void tiles_asm(unsigned char *src, rdi
;              	unsigned char *dst, rsi
;				int cols, rows 		edx, ecx
;              	int src_row_size,   r8d
;             	int dst_row_size,   r9d
;				int tamx, int tamy, [rsp] ,  [rsp+8]
;		int offsetx, int offsety); [rsp+16] ,  [rsp+24] 

cropflip_asm:
	push rbp
	mov rbp, rsp
	push r12
	push r13
	push r14
	push r15
	push rbx	

	mov r12d, [rbp+16] 	;r12=tamx
	mov r13d, [rbp+24] 	;r13=tamy
	mov r14d, [rbp+32]	;r14=offsetx
	mov r15d, [rbp+40] 	;r15=offsety
	xor rdx, rdx 		;edx=0 es i
	xor rcx, rcx 		;ecx=0 es j

.ciclo:
	
	cmp edx, r13d
	jz .fin
	cmp ecx, r12d
	jz .aumentarI

	mov rbx, rdx
	mov r11, rcx
	
	xor rax, rax
;quiero obtener: tamy+offsety-i-1
	neg edx			; -i	
	sub edx,1 		; -i - 1
	add edx, r13d	; -i - 1 + tamy 
	add edx, r15d	; -i - 1 + tamy + offsety
	mov eax, r8d 	; pongo en eax src_row_size
	mul edx 		
	xor edx, edx
	mov edx, eax 	; (-i - 1 + tamy + offsety) * ancho imagen origen
	
	add ecx, r14d	; j + offsetx
	shl ecx, 2		; (j + offsetx)*4
	add ecx, edx	; (j + offsetx)*4 + (-i - 1 + tamy + offsety) * ancho imagen origen)
	movdqu xmm0, [rdi + rcx]
	movdqu [rsi], xmm0

	mov rdx, rbx
	mov rcx, r11

	add rsi, 16
	add ecx, 4
	jmp .ciclo
.aumentarI:
	add edx, 1
	xor ecx, ecx
	jmp .ciclo

	.fin:
	pop rbx
	pop r15
	pop r14
	pop r13 
	pop r12
	pop rbp
    ret
