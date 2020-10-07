global nodo_crear
global lista_crear
global lista_borrar
global lista_imprimir
global lista_imprimir_f
global crear_jugador
global menor_jugador
global normalizar_jugador
global pais_jugador
global borrar_jugador
global imprimir_jugador
global crear_seleccion
global menor_seleccion
global primer_jugador
global borrar_seleccion
global imprimir_seleccion
global insertar_ordenado
global mapear
global ordenar_lista_jugadores
global altura_promedio
global lexicograficamente_menor
global string_iguales
global insertar_antes_de
global string_copiar


extern insertar_ultimo
extern malloc
extern free
extern fprintf
extern fopen
extern open
extern fclose

; SE RECOMIENDA COMPLETAR LOS DEFINES CON LOS VALORES CORRECTOS
%define NULL 0
%define TRUE 1
%define FALSE 0

%define NODO_SIZE      24 
%define LISTA_SIZE     16 
%define JUGADOR_SIZE   21
%define SELECCION_SIZE 32

%define OFFSET_DATOS 0
%define OFFSET_SIG   8 
%define OFFSET_ANT   16 

%define OFFSET_PRIMERO 0
%define OFFSET_ULTIMO  8 

%define OFFSET_NOMBRE_J 0
%define OFFSET_PAIS_J   8 
%define OFFSET_NUMERO_J 16 
%define OFFSET_ALTURA_J 17 

%define OFFSET_PAIS_S      0
%define OFFSET_ALTURA_S    8 
%define OFFSET_JUGADORES_S 16 


section .rodata
vacia: db "<vacia>",10,0
append: db "a",0
imprimir_jugadorFormatText: db "%s %s %d %u ",10,0
imprimir_seleccionFormatText: db "%s %.2f ",10,0
pies: dq 30.48, 30.48, 30.48
section .data


section .text

; FUNCIONES OBLIGATORIAS. PUEDEN CREAR LAS FUNCIONES AUXILIARES QUE CREAN CONVENIENTES

nodo_crear: ;rdi=datos
push rbp
mov rbp, rsp
push rbx
sub rsp, 8

mov rbx, rdi							;rbx->datos
mov rdi, NODO_SIZE						;rdi = NODO_SIZE
call malloc								;nuevo=malloc(NODO_SIZE)
mov qword[rax+OFFSET_DATOS], rbx  		;nuevo.datos=datos
mov qword[rax+OFFSET_SIG], NULL			;nuevo.sig=NULL
mov qword[rax+OFFSET_ANT], NULL			;nuevo.ant=NULL

add rsp,8
pop rbx
pop rbp
ret
	

lista_crear:
push rbp
mov rbp, rsp

mov rdi, LISTA_SIZE						;rdi=LISTA_SIZE
call malloc								;nuevo=malloc(LISTA_SIZE)
mov qword[rax+OFFSET_PRIMERO], NULL 	;nuevo.primero=NULL
mov qword[rax+OFFSET_ULTIMO], NULL		;nuevo.ultimo=NULL

pop rbp
ret
	
lista_borrar: ;rdi->lista, rsi-> f
push rbp
mov rbp, rsp
push rbx
push r13
push r14
sub rsp, 8

mov r14, rdi 					;r14->lista
mov rbx, rsi 					;rbx->f	
mov r13, [r14+OFFSET_PRIMERO]	;r13->lista.primero
.ciclo:							
cmp r13, NULL 					;if(lista.primero==NULL)
jz .fin 						;then .fin
mov rdi, [r13+OFFSET_DATOS] 	;else rdi=r13.datos
call rbx 						;tipo_funcion_borrar(r13.datos)
mov rdi, r13 					;rdi=r13
mov r13, [r13+OFFSET_SIG] 		;r13=r13.sig
call free 						;free(rdi)
jmp .ciclo 						;

.fin:
mov rdi,r14
call free 						;free(lista)

add rsp,8
pop r14
pop r13 
pop rbx
pop rbp
ret
	; COMPLETAR AQUI EL CODIGO

lista_imprimir: ;rdi->lista, rsi->nombreDelArchivo, rdx->tipo_funcion_imprimir(*void, *FILE)
push rbp
mov rbp, rsp
push r13
push r14

mov r13, rdx 					;r13=tipo_funcion_imprimir 
mov r14, rdi 					;r14->lista
mov rdi, rsi					;rdi->nombreDelArchivo
mov rsi, append 				;rsi="a"
call fopen 						;file=fopen(nombreDelArchivo, "a")
mov rdi, r14 					;rdi->lista
mov rsi, rax  					;rsi=file
mov rdx, r13 					;rdx=tipo_funcion_imprimir
mov r14, rax 					;r14=file
call lista_imprimir_f 			;lista_imprimir_f(lista, file, tipo_funcion_imprimir)
mov rdi, r14 					;rdi=file
call fclose 					;file.close()

pop r14
pop r13
pop rbp
ret
	; COMPLETAR AQUI EL CODIGO
 
lista_imprimir_f: ;rdi->lista, rsi->FILE, rdx->tipo_funcion_imprimir(*void, *FILE)
push rbp
mov rbp, rsp
push rbx
push r12
push r13
sub rsp, 8

mov rbx, [rdi+OFFSET_PRIMERO] 		;rbx->lista.primero
mov r12, rsi 						;r12->FILE
mov r13, rdx 						;r13->tipo_funcion_imprimir(*void, *FILE)

cmp rbx, NULL 						;if(rbx==NULL)
jz .imprimirVacia 					;then .imprimirVacia

.ciclo: 
cmp rbx, NULL 						;if(rbx==NULL)
jz .fin 							;then .fin
mov rdi, [rbx+OFFSET_DATOS] 		;rdi->rbx.datos
mov rsi, r12 						;rsi->FILE
call r13 							;tipo_funcion_imprimir(rbx.datos, FILE)
mov rbx, [rbx+OFFSET_SIG] 			;rbx->rbx.sig
jmp .ciclo

.imprimirVacia:
mov rsi, vacia 	 					;rdi->"<vacia>"
mov rdi, r12 						;rsi->FILE
call fprintf 							;tipo_funcion_imprimir(FILE,"<vacia>")

.fin:
add rsp, 8
pop r13
pop r12
pop rbx
pop rbp
ret
	; COMPLETAR AQUI EL CODIGO

crear_jugador: ;rdi= nombre, rsi=pais, dl= numero, ecx=altura
push rbp
mov rbp, rsp
push rbx
push r12
push r13
push r14

mov r14, rdi						;r14->nombre
mov r12, rsi 						;r12->pais 
mov r13b, dl 						;r13=numero
mov ebx, ecx 						;ebx=altura

xor rdi,rdi 						
mov rdi, JUGADOR_SIZE 				;rdi=JUGADOR_SIZE
call malloc 						;nuevo=malloc(JUGADOR_SIZE)

mov byte[rax+OFFSET_NUMERO_J], r13b ;nuevo.numero=numero
mov dword[rax+OFFSET_ALTURA_J], ebx ;nuevo.altura=altura
mov r13, rax						;r13=nuevo
mov rdi, r14 						;rdi->nombre
call string_copiar 					;string_copiar(nombre)
mov qword[r13+OFFSET_NOMBRE_J], rax ;nuevo.nombre=string_copiar(nombre)
mov rdi, r12  						;rdi->pais
call string_copiar 					;string_copiar(pais)
mov qword[r13+OFFSET_PAIS_J], rax 	;nuevo.pais=string_copiar(pais)
mov rax, r13

pop r14
pop r13
pop r12
pop rbx
pop rbp
ret
	; COMPLETAR AQUI EL CODIGO

menor_jugador:	;rdi=*jugador1 y rsi=*jugador2
push rbp
mov rbp, rsp
push r12
push r13

mov r12d, [rdi+OFFSET_ALTURA_J]  		;r12d=jugador1.altura
mov r13d, [rsi+OFFSET_ALTURA_J]			;r13d=jugador2.altura
mov rdi, [rdi+OFFSET_NOMBRE_J] 			;rdi=jugador1.nombre
mov rsi, [rsi+OFFSET_NOMBRE_J] 			;rsi=jugador2.nombre

call lexicograficamente_menor 			;lexicograficamente_menor(jugador1, jugador2)	
cmp rax, 0 								;if(lexicograficamente_menor(jugador1, jugador2)>0)	
jg .es_menor_jugador 					;then .es_mayor_jugador
jz .lexIgual 							;elseif(lexicograficamente_menor(jugador1, jugador2)==0)
jmp .es_mayor_jugador 					;then .lexIgual
										;else then .es_menor_jugador
.lexIgual:
cmp r13d, r12d							;if(jugador2.altura>=jugador1.altura)
jge .es_menor_jugador					;then .es_menor_jugador
jmp .es_mayor_jugador 					;else .es_mayor_jugador


.es_mayor_jugador: 
mov rax, FALSE 							;return FALSE
jmp .fin_menor_jugador 					;
.es_menor_jugador: 						;
mov rax, TRUE 							;return TRUE


.fin_menor_jugador:
pop r13   				;rdi esta j1, rsi esta j2
pop r12
pop rbp
ret
	; COMPLETAR AQUI EL CODIGO

normalizar_jugador: 	;rdi=*jugador 
push rbp
mov rbp, rsp
push rbx
push r12
push r13
push r14


xor r13, r13 					;r13=0
mov r13b, 90    				;ascii de "Z"
mov r14b, 255 					;ascii de " "
mov rbx, rdi 					;rbx->jugador
mov rdi, [rbx+OFFSET_NOMBRE_J] 	;rdi->jugador.nombre
mov rsi, [rbx+OFFSET_PAIS_J] 	;rsi->jugador.pais
mov dl, [rbx+OFFSET_NUMERO_J] 	;dl=jugador.numero
mov ecx, [rbx+OFFSET_ALTURA_J] 	;ecx=jugador.altura
call crear_jugador 				;rax=jugadorN(copia del pasado)
mov r12, [rax+OFFSET_NOMBRE_J] 	;r12=jugadorN.nombre
.ciclo:
cmp byte[r12], NULL 			;if(jugadorN.nombre[r12]==NULL)
jz .pasarAPies 						
cmp r13b, [r12]					;if(jugadorN.nombre[r12]<="Z")
jge .sigLetra					;then .pasarAPies
cmp r14b, [r12] 				;if(jugadorN.nombre[r12]<=" ")
jz .sigLetra
sub byte[r12], 32				;else jugadorN.nombre[r12]=jugadorN.nombre[r12]-32
.sigLetra: 					
add r12, 1						;r12++
jmp .ciclo

.pasarAPies:
mov r12, rax 							;r12=jugadorN
pxor xmm1, xmm1 						;xmm1=0
pxor xmm0, xmm0 						;xmm0=0
xor rcx, rcx 							;rcx=0
mov ecx, [r12 + OFFSET_ALTURA_J] 		;eax=jugadorN.altura
cvtsi2sd xmm0, rcx 						;xmm0=double(rcx)
movdqu xmm1, [pies] 					;xmm1=30.48
divsd xmm0, xmm1 						;xmm0=xmm0/30.48
cvttsd2si rcx, xmm0 					;rcx=int(xmm0)
mov dword[r12+OFFSET_ALTURA_J], ecx 	;jugadorN.altura=ecx(jugadorN.altura/30.80)
mov rax, r12 							;return jugadorN

pop r14
pop r13
pop r12
pop rbx
pop rbp
ret
	; COMPLETAR AQUI EL CODIGO

pais_jugador: ;rdi=*jugador1 y rsi=*jugador2
push rbp
mov rbp, rsp

mov rdi, [rdi+OFFSET_PAIS_J]	;rdi=jugador1.pais
mov rsi, [rsi+OFFSET_PAIS_J]	;rsi=jugador2.pais
call string_iguales 			;return string_iguales(jugador1.pais, jugador2.pais)

pop rbp
ret
	; COMPLETAR AQUI EL CODIGO

borrar_jugador: ;rdi->jugador
push rbp
mov rbp, rsp
push rbx
sub rsp,8

mov rbx, rdi 						;rbx->jugador
mov rdi,[rbx+OFFSET_NOMBRE_J] 		;rdi->jugador.nombre
call free 							;free(jugador.nombre) 
mov rdi, [rbx+OFFSET_PAIS_J] 		;rdi->jugador.pais
call free 							;free(jugador.pais)
mov rdi, rbx 						;rdi->jugador
call free 							;free(jugador)

add rsp,8
pop rbx
pop rbp
ret
	; COMPLETAR AQUI EL CODIGO

imprimir_jugador: ;rdi->jugador, rsi->FILE
push rbp
mov rbp, rsp
push r12
push r13

mov r12, rdi 						;r12->jugador
mov r13, rsi 						;r13->FILE
mov rdi, rsi 						;rdi->FILE
xor r8, r8 							;r8=0
mov rsi, imprimir_jugadorFormatText ;rsi="%s %s %d %d "
mov rdx, [r12+OFFSET_NOMBRE_J] 		;rdx=jugador.nombre
mov rcx, [r12+OFFSET_PAIS_J] 		;rcx=jugador.pais
mov r8b, [r12+OFFSET_NUMERO_J] 		;r8b=jugador.numero
mov r9d, [r12+OFFSET_ALTURA_J] 		;r9d=jugador.altura
call fprintf 						;fprintf(jugador.nombre,jugador.pais,jugador.numero,jugador.altura)


pop r13
pop r12
pop rbp
ret
	; COMPLETAR AQUI EL CODIGO

crear_seleccion: ;rdi=pais, xmm0=alturaPromedio, rsi=jugadores
push rbp
mov rbp, rsp
push r12
push rbx
push r13
sub rsp, 8

mov rbx , rdi								;rbx->pais
mov r12, rsi 								;r12->jugadores
mov rdi, SELECCION_SIZE 					;rdi=SELECCION_SIZE
movupd xmm8, xmm0  							;xmm8=xmm0
call malloc 								;nuevo=malloc(SELECCION_SIZE)
movups [rax+OFFSET_ALTURA_S], xmm8 			;nuevo.alturaPromedio=alturaPromedio
mov r13, rax 								;r13->nuevo
mov rdi, rbx 								;rdi->pais
call string_copiar 							;string_copiar(rdi)
mov qword[r13+OFFSET_PAIS_S], rax 			;nuevo.pais=string_copiar(pais)
mov qword[r13+OFFSET_JUGADORES_S], r12 		;nuevo.jugadores=jugadores						
mov rax, r13 								;return nuevo

.fin:
add rsp, 8
pop r13
pop rbx
pop r12
pop rbp
ret
	; COMPLETAR AQUI EL CODIGO

menor_seleccion: ;rdi=*seleccion1 y rsi=*seleccion2
push rbp
mov rbp, rsp

mov rdi, [rdi+OFFSET_PAIS_S]	;rdi=seleccion1.pais
mov rsi, [rsi+OFFSET_PAIS_S]	;rsi=seleccion2.pais
call lexicograficamente_menor 	;lexicograficamente_menor(seleccion1.pais, seleccion2.pais)

cmp rax, 0 						;if(lexicograficamente_menor(seleccion1.pais, seleccion2.pais)>=0)
jge .es_mayor 					;then .es_mayor
mov rax, FALSE					;return TRUE
jmp .fin 						;

.es_mayor: 		
mov rax, TRUE 					;else then return FALSE

.fin:
pop rbp
ret
	; COMPLETAR AQUI EL CODIGO

primer_jugador: ;rdi=seleccion 
push rbp
mov rbp, rsp
push r12

sub rsp, 8

mov r12, [rdi+OFFSET_JUGADORES_S]	;r12->seleccion.jugadores
mov r12, [r12+OFFSET_PRIMERO]       ;r12->seleccion.jugadores.primero
mov r12, [r12+OFFSET_DATOS] 		;r12->r12.datos
mov rdi, [r12+OFFSET_NOMBRE_J] 		;rdi=seleccion.jugadores.primero.nombre
mov rsi, [r12+OFFSET_PAIS_J] 		;rsi=string_copiar(seleccion.jugadores.primero.pais)
mov dl, [r12+OFFSET_NUMERO_J] 		;dl=seleccion.jugadores.primero.numero
mov ecx, [r12+OFFSET_ALTURA_J]		;ecx=seleccion.jugadores.primero.altura
call crear_jugador 					;return crear_jugador(rdi, rsi, dl ,ecx)

add rsp, 8
pop r12
pop rbp
ret
	; COMPLETAR AQUI EL CODIGO

borrar_seleccion: ;rdi=seleccion
push rbp
mov rbp, rsp
push r12
sub rsp,8

mov r12, rdi 						;r12->seleccion
mov rdi, [rdi+OFFSET_PAIS_S] 		;rdi->seleccion.pais
call free  							;free(seleccion.pais)
mov rdi, [r12+OFFSET_JUGADORES_S] 	;rbx->seleccion.jugadores
mov rsi, borrar_jugador 			;rsi->borrar_jugador
call lista_borrar 					;lista_borrar(seleccion.jugadores, borrar_jugador)
mov rdi, r12 						;rdi->seleccion
call free 							;free(seleccion)

add rsp,8
pop r12
pop rbp
ret
	; COMPLETAR AQUI EL CODIGO

imprimir_seleccion: ;rdi->seleccion, rsi->FILE
push rbp
mov rbp, rsp
push r12
push r13

mov r12, rdi 							;r12->seleccion
mov r13, rsi 							;r13->FILE
mov rdi, r13 							;rdi->FILE
mov rsi, imprimir_seleccionFormatText 	;rsi="%s %.2f \n"
mov rdx, [r12+OFFSET_PAIS_S]			;rdx->seleccion.pais
movups xmm0, [r12+OFFSET_ALTURA_S] 		;xmm0=seleccion.alruraPromedio
call fprintf 							;fprintf("%s %.2f \n",seleccion.pais,seleccion.alturaPromedio)
mov r12, [r12+OFFSET_JUGADORES_S] 		;r12=seleccion->jugadores
mov r12, [r12+OFFSET_PRIMERO] 			;r12=seleccion->jugadores->primero
.ciclo:
cmp r12, NULL 							;if(r12==NULL)
jz .fin 								;then .fin
mov rdi, [r12+OFFSET_DATOS]  			;rdi=r12->datos
mov rsi, r13 							;rsi=FILE
call imprimir_jugador 					;imprimir_jugador(r12->datos, FILE)
mov r12, [r12+OFFSET_SIG] 				;r12=r12->sig
jmp .ciclo

.fin:
pop r13
pop r12
pop rbp
ret
	; COMPLETAR AQUI EL CODIGO

insertar_ordenado: ;rdi->lista, rsi->datos, rdx->tipo_funcion_cmp
push rbp
mov rbp, rsp
push rbx
push r13
push r14
push r15

mov rbx, [rdi+OFFSET_PRIMERO] 	;rbx=lista->primero
mov r13, rdx 					;r13=rdx
mov r14, rsi 					;r14->datos
mov r15, rdi 					;r15->lista
.ciclo:
cmp rbx, NULL 					;if(rbx==NULL)
jz .insertarU 					;then .insertarU
mov rsi, [rbx+OFFSET_DATOS] 	;rsi=rbx.datos
mov rdi, r14 					;rdi->datos
call r13 						;tipo_funcion_cmp(datos,rbx.datos)
cmp rax, TRUE 					;if(tipo_funcion_cmp(datos,rbx.datos)==TRUE)
jz .insertar 					;then .insertar
mov rbx, [rbx+OFFSET_SIG] 		;rbx=rbx.sig
jmp .ciclo

.insertar: 						
mov rdi, r14 					;rdi->datos
call nodo_crear 				;nuevo=nodo_crear(datos)
cmp qword[rbx+OFFSET_ANT],NULL
jz .insertarP 				
;caso en que se deba insertar entre medio de la lista
mov r13, [rbx+OFFSET_ANT] 		;r13=rbx.ant 		
mov qword[r13+OFFSET_SIG], rax 	;rbx.ant.sig=nuevo
mov qword[rax+OFFSET_ANT], r13 	;nuevo.ant=rbx.ant
mov qword[rax+OFFSET_SIG], rbx 	;nuevo.sig=rbx
mov qword[rbx+OFFSET_ANT], rax 	;rbx.ant=nuevo
jmp .fin

.insertarP: 							;caso en que se deba insertar al primero de la lista
mov qword[rax+OFFSET_SIG], rbx 			;nuevo.sig=rbx
mov qword[rbx+OFFSET_ANT], rax 			;rbx.ant=nuevo
mov qword[r15+OFFSET_PRIMERO], rax 		;lista.primero=nuevo
jmp .fin

.insertarU: 					;;caso en que se deba insertar al ultimo de la lista
mov rdi, r14 					;rdi->datos
call nodo_crear 				;nuevo=nodo_crear(datos)
mov rsi, rax 					;rsi=nuevo
mov rdi, r15 					;rdi=lista
call insertar_ultimo 			;insertar_ultimo(lista, nuevo)
.fin:

pop r15
pop r14
pop r13
pop rbx
pop rbp
ret
	; COMPLETAR AQUI EL CODIGO

altura_promedio:	;rdi=*l
push rbp
mov rbp, rsp
push r12
push r13
push r14
sub rsp,8

mov r13, [rdi+OFFSET_PRIMERO]	;r13->l.primero
xor r12, r12
xor rax, rax 					;rax=0

.ciclo:
cmp r13, NULL					;if(l.primero==NULL) ;ultimo.sig==NULL
jz .calculo						;then .fin
mov r14, [r13+OFFSET_DATOS]		;else r14=r13.datos
add eax, [r14+OFFSET_ALTURA_J]	;rax=rax+r14.altura
mov r13, [r13+OFFSET_SIG]		;r13=r13.sig
add r12, 1 						;r12++
jmp .ciclo

.calculo:
pxor xmm0, xmm0					;xmm0=0	
pxor xmm1, xmm1	 				;xmm1=0
cmp r12, 0 						;if(cantidadDeElementos(lista)==0)
jz .fin 						;then .fin
cvtsi2sd xmm0, eax 				;xmm0=double(eax)
cvtsi2sd xmm1, r12 				;xmm1=double(r12)
divsd xmm0, xmm1 				;xmm0=xmm0/xmm1

.fin:
add rsp, 8
pop r14
pop r13
pop r12
pop rbp
ret
	; COMPLETAR AQUI EL CODIGO

ordenar_lista_jugadores: ;rdi->lista
push rbp
mov rbp, rsp
push r12
push rbx

mov r12, [rdi+OFFSET_PRIMERO]  	;r12=lista.primero
call lista_crear 				;nuevoL=lista_crear()
mov rbx, rax 					;rbx=nuevoL
.ciclo:
cmp r12, NULL 					;if(r12==NULL)
jz .fin 						;then .fin
mov rdi, rbx 					;rdi=nuevoL
mov rsi, [r12+OFFSET_DATOS] 	;rsi=r12.datos
mov rdx, menor_jugador 			;rbx=menor_jugador
call insertar_ordenado 			;insertar_ordenado(nuevoL,r12.datos,menor_jugador)
mov r12, [r12+OFFSET_SIG] 		;r12=r12.sig
jmp .ciclo

.fin:
mov rax, rbx
pop rbx
pop r12
pop rbp
ret
	; COMPLETAR AQUI EL CODIGO


mapear: 		;rdi->lista, rsi->tipo_funcion_mapear
push rbp
mov rbp, rsp
push rbx
push r12
push r13
sub rsp, 8

mov rbx, [rdi+OFFSET_PRIMERO]	;rbx=lista.primero
mov r12, rsi 					;r12=tipo_funcion_mapear
call lista_crear 				;nuevaL=lista_crear
mov r13, rax 					;r13->nuevoL
.ciclo: 				
cmp rbx, NULL  					;if(rbx==NULL)
jz .fin 						;then .fin
mov rdi,[rbx+OFFSET_DATOS] 		;rdi=rbx.datos
call r12 						;tipo_funcion_mapear(rbx.datos)
mov rdi, rax 					;rdi=tipo_funcion_mapear(rbx.datos)
call nodo_crear 				;nuevoN=nodo_crear(tipo_funcion_mapear(rbx.datos))
mov rsi, rax 					;rsi->nuevoN
mov rdi, r13 					;rdi->nuevoL
call insertar_ultimo 			;insertar_ultimo(nuevoL, nuevoN)
mov rbx, [rbx+OFFSET_SIG] 		;rbx=rbx.sig
jmp .ciclo


.fin:
mov rax, r13 					;return nuevoL
add rsp, 8
pop r13
pop r12
pop rbx
pop rbp
ret
	; COMPLETAR AQUI EL CODIGO

lexicograficamente_menor: ;rdi=*palabra1 y rsi=*palabra2
push rbp
mov rbp, rsp
push r12
push r13
push r14
sub rsp, 8

xor rax, rax 				;rax=0
xor r13, r13 				;r13=0
.ciclo_menor_lex:
mov r14b, byte[rdi+r13] 	;r14b=palabra1[r13]
mov r12b, byte[rsi+r13] 	;r12b=palabra2[r13]

cmp r14b, r12b    			;if(rsi[r13]>rdi[r13])
jg .es_menor  				;then .es_menor
cmp r12b, r14b 				;elseif (rdi[r13]>rsi[r13])
jg .es_mayor	    		;then .es_mayor
cmp r12b, NULL				;elseif(rdi[r13]==NULL)
jz .sonIgualesLex			;then .sonIgualesLex1
jmp .reasignar				;else .reasignar

.sonIgualesLex:
cmp r12b, NULL				;if(rsi[r13]==NULL)
jz .fin_lex					;then .fin_lex

.reasignar:
add r13, 1 					;r13++
jmp .ciclo_menor_lex 		

.es_menor:
sub rax, 1 					;rax<0
jmp .fin_lex

.es_mayor:
add rax, 1 					;rax>0

.fin_lex:

add rsp, 8
pop r14
pop r13
pop r12
pop rbp
ret

string_iguales: ;rdi=*palabra1 y rsi=*palabra2
push rbp
mov rbp, rsp

call lexicograficamente_menor
cmp rax, 0
jz .iguales
mov rax, FALSE
jmp .fin

.iguales:
mov rax, TRUE
.fin:

pop rbp
ret

insertar_antes_de:  ;rdi ->l, rsi ->nuevo y rdx =n
push rbp
mov rbp, rsp
push r12
push r13

mov r12, [rdi+OFFSET_PRIMERO] 		;r12=l.primero

.ciclo:
cmp r12, rdx 				;if(r12==n)
jz .insertar 				;then .insertar 
mov r12, [r12+OFFSET_SIG] 	;else then r12=r12.sig 
jmp .ciclo 					


.insertar:
mov r13, [r12+OFFSET_ANT] 				;r13=r12.ant
mov qword[r13+OFFSET_SIG], rsi 			;r12.ant.sig=nuevo
mov qword[r12+OFFSET_ANT], rsi 			;r12.ant=nuevo
jmp .fin

.fin:
pop r13
pop r12
pop rbp
ret

string_copiar: ;rdi->palabra
push rbp
mov rbp, rsp
push rbx
push r12
push r13
sub rsp, 8

mov r12, rdi    ;r12->palabra
xor rbx, rbx 	;rbx=0
xor r13,r13
.ciclo1:
cmp byte[r12+rbx],NULL 	;if(palabra[rbx]==NULL) 
jz .salir 				;then .salir
add rbx, 1 				;rbx++
jmp .ciclo1 			

.salir:
add rbx,1 				;rbx++ (El NULL también cuenta)
mov rdi, rbx 			;rdi=rbx
call malloc 			;nuevo=malloc(rbx)
xor rbx, rbx	 		;rbx=0
					
.ciclo:
mov r13b, [r12+rbx] 		;r13b=palabra[rbx]
cmp r13b, NULL 				;if(palabra[rbx]==NULL)
jz .fin  					;then .fin
mov byte[rax+rbx],r13b 		;nuevo[rbx]=palabra[rbx]
add rbx,1 					;rbx++
jmp .ciclo


.fin:
mov byte[rax+rbx],NULL

add rsp,8
pop r13
pop r12
pop rbx
pop rbp
ret
