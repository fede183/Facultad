
#include "tp2.h"


void cropflip_c    (
	unsigned char *src,
	unsigned char *dst,
	int cols,
	int filas,
	int src_row_size,
	int dst_row_size,
	int tamx,
	int tamy,
	int offsetx,
	int offsety)
{
	unsigned char (*src_matrix)[src_row_size] = (unsigned char (*)[src_row_size]) src;
	unsigned char (*dst_matrix)[dst_row_size] = (unsigned char (*)[dst_row_size]) dst;

	for (int i=0; i<tamy; i+=1){
		for (int j=0; j<tamx; j+=1){
			
			dst_matrix[i][j*4] = src_matrix[tamy+offsety-i-1][4*(offsetx+j)];
			dst_matrix[i][(4*j)+1] = src_matrix[tamy+offsety-i-1][4*(offsetx+j)+1];
			dst_matrix[i][(4*j)+2] = src_matrix[tamy+offsety-i-1][4*(offsetx+j)+2];
		}
	}
// dst = src(tamy+offsety-i-1, offsetx+j)




}
