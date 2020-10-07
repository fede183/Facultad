#set terminal latex
set term pngcairo
set out 'u_kmn_e.png'

set xlabel 'Cantidad de vértices'
set ylabel 'Tiempo (s)'
#set ylabel "\\rotatebox{90}{Tiempo}" 
set xrange [10:25]
set yrange [0:*]
set key left top inside

plot 'u_kmn_exacto.out' using 1:4 smooth bezier lw 2 lc 3 title 'Algorimo exacto', \
	'' u 1:4 with points pt 2 lc 3 title ''
set out
