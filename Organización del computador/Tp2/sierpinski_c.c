
#include "tp2.h"



float coefic_sierpinski(int i, int j, int cols, int filas){
	
	float f = 255.00;
	
	int a = ((float)i/(float)filas)*f;
	int b = ((float)j/(float)cols)*f;
	
	float res = (a ^ b)*1/f;
	
	return res;
	
}



void sierpinski_c    (
	unsigned char *src,
	unsigned char *dst,
	int cols,
	int filas,
	int src_row_size,
	int dst_row_size)
{
	unsigned char (*src_matrix)[src_row_size] = (unsigned char (*)[src_row_size]) src;
	unsigned char (*dst_matrix)[dst_row_size] = (unsigned char (*)[dst_row_size]) dst;
	
	for (int i=0; i<filas; i+=1){
		for (int j=0; j<cols; j+=1){
			
			float coef = coefic_sierpinski(i,j,cols,filas);
			dst_matrix[i][j*4] = src_matrix[i][4*j]*coef;
			dst_matrix[i][(4*j)+1] = src_matrix[i][(4*j)+1]*coef;
			dst_matrix[i][(4*j)+2] = src_matrix[i][(4*j)+2]*coef;
		}
	}
	
	
	
}


