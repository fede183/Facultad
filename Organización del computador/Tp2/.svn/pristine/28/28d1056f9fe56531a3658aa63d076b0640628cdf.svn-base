
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#include "tp2.h"
#include "opencv_wrapper.h"
#include "tiempo.h"

// uso: 
// unsigned long start, end;
// MEDIR_TIEMPO_START(start);
// ... codigo ...
// MEDIR_TIEMPO_STOP(end);
// unsigned long delta = end - start;

void cropflip_asm    (unsigned char *src, unsigned char *dst, int cols, int filas,
                      int src_row_size, int dst_row_size, int tamx, int tamy, int offsetx, int offsety);

void cropflip_c    (unsigned char *src, unsigned char *dst, int cols, int filas,
                      int src_row_size, int dst_row_size, int tamx, int tamy, int offsetx, int offsety);

typedef void (cropflip_fn_t) (unsigned char*, unsigned char*, int, int, int, int, int, int, int, int);

typedef struct cropflip_params_t {
	int tamx, tamy, offsetx, offsety;
} cropflip_params_t;


cropflip_params_t extra;
void leer_params_cropflip(configuracion_t *config, int argc, char *argv[]) {
	config->extra_config = &extra;
    extra.tamx    = atoi(argv[argc - 4]);
    extra.tamy    = atoi(argv[argc - 3]);
    extra.offsetx = atoi(argv[argc - 2]);
    extra.offsety = atoi(argv[argc - 1]);
}

void aplicar_cropflip(configuracion_t *config)
{
	cropflip_fn_t *cropflip = SWITCH_C_ASM ( config, cropflip_c, cropflip_asm ) ;
	cropflip_params_t *extra = (cropflip_params_t*)config->extra_config;
	unsigned long start, end;
	
	// Esto queda horrible aca, deberia estar llamandose antes de aplicar,
	// pero la unica forma limpia de hacerlo es que cada filtro tenga una funcion
	// para abrir el destino (podria ser una default para todas y si algun filtro
	// quiere definir una propia como este, la define).
	//
	// Esto es proque el destino de cropflip tiene distinto tamanio que el origen.
	opencv_abrir_destino(extra->tamx, extra->tamy, config);

	buffer_info_t info = config->src;
//	for (int x=0;x<100;x++){
		MEDIR_TIEMPO_START(start);
		cropflip(info.bytes, config->dst.bytes, info.width, info.height, info.width_with_padding,
			     config->dst.width_with_padding, extra->tamx, extra->tamy, extra->offsetx, extra->offsety);
		MEDIR_TIEMPO_STOP(end);
		printf("%lu\n", end-start);
//	}

}

void ayuda_cropflip()
{
	printf ( "       * cropflip\n" );
	printf ( "           Parámetros     : \n"
	         "                         tamx ancho del recuadro (debe ser multiplo de 16 y entrar en la imagen)\n"
	         "                         tamy alto del recuadro\n"
	         "                         offsetx pixels a partir de los cuales copiar del source\n"
	         "                         offsety pixels a partir de los cuales copiar del source\n");
	printf ( "           Ejemplo de uso : \n"
	         "                         cropflip -i c facil.bmp 32 32 40 50\n" );
}
