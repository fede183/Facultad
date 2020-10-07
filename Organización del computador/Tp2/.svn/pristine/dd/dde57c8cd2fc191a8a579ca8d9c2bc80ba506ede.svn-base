
#include "tp2.h"

void bandas_c(
		unsigned char *src,     
		unsigned char *dst,
		int m,
		int n,
		int src_row_size,
		int dst_row_size
		) { 
	unsigned char (*src_matrix)[src_row_size] = (unsigned char (*)[src_row_size]) src;
	unsigned char (*dst_matrix)[dst_row_size] = (unsigned char (*)[dst_row_size]) dst;
	bgra_t * src_pixel;
	bgra_t * dst_pixel;
	int suma = 0;
	for (int fila =0 ; fila < n ; fila ++){
		for (int col =0 ; col < m ; col ++){
			src_pixel = &src_matrix[fila][col*sizeof(bgra_t)];
			dst_pixel = &dst_matrix[fila][col*sizeof(bgra_t)];
			suma = src_pixel->r + src_pixel->b +src_pixel->g;
			if (suma < 96){
				dst_pixel->r = 0;
				dst_pixel->g = 0;
				dst_pixel->b = 0;
				dst_pixel->a = 255;
			}
			if (suma >= 96 && suma < 288){
				dst_pixel->r = 64;
				dst_pixel->g = 64;
				dst_pixel->b = 64;
				dst_pixel->a = 255;
			}
			if (suma >= 288 && suma < 480){
				dst_pixel->r = 128;
				dst_pixel->g = 128;
				dst_pixel->b = 128;
				dst_pixel->a = 255;
			}
			if (suma >= 480 && suma < 672){
				dst_pixel->r = 192;
				dst_pixel->g = 192;
				dst_pixel->b = 192;
				dst_pixel->a = 255;
			}
			if (suma >= 672){
				dst_pixel->r = 255;
				dst_pixel->g = 255;
				dst_pixel->b = 255;
				dst_pixel->a = 255;
			}
		}
	}
	// TODO: Implementar

}
