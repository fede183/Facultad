
#include "tp2.h"
#include <math.h>

#define MIN(x,y) ( x < y ? x : y )
#define MAX(x,y) ( x > y ? x : y )

#define P 2

void mblur_c(
		unsigned char *src,
		unsigned char *dst,
		int cols,
		int filas,
		int src_row_size,
		int dst_row_size) {
	unsigned char (*src_matrix)[src_row_size] = (unsigned char (*)[src_row_size]) src;
	unsigned char (*dst_matrix)[dst_row_size] = (unsigned char (*)[dst_row_size]) dst;
	bgra_t * src_pixel;
	bgra_t * dst_pixel;
	
	//float sum_a =0;
	for (int fila = 0; fila < filas; fila++) {
		for (int col = 0; col < cols; col++) {
			dst_pixel = (bgra_t*)&dst_matrix[fila][col * sizeof (bgra_t)];
			if (fila < 2 || col < 2 || (filas - fila) < 3 || (cols - col) < 3) { //caso borde
				dst_pixel->r = 0;
				dst_pixel->g = 0;
				dst_pixel->b = 0;
				dst_pixel->a = 255;
			} else {
				dst_pixel->r = 0;
				dst_pixel->g = 0;
				dst_pixel->b = 0;
				for (int i = -2; i < 3; i++) {
					src_pixel = (bgra_t*)&src_matrix[fila + i][(col + i) * sizeof (bgra_t)];
					dst_pixel->r += (int)(src_pixel->r * 0.2);
					dst_pixel->g += (int)(src_pixel->g * 0.2);
					dst_pixel->b += (int)(src_pixel->b * 0.2);
				}
				dst_pixel->a = 255;
			}
		}
	}

}


