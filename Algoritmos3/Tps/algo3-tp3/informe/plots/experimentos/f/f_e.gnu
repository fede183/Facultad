#set terminal latex
set term pngcairo
set out 'f_e.png'

set xlabel 'Cantidad de vértices'
set ylabel 'Tiempo (s)'
#set ylabel "\\rotatebox{90}{Tiempo}"
set xrange [10:*]
set yrange [0:*]
set key left top inside

plot 'f_exacto.out' using 1:4 smooth bezier lw 2 lc 4 title 'Algoritmo exacto', \
	'' u 1:4 with points pt 2 lc 4 title ''

set out