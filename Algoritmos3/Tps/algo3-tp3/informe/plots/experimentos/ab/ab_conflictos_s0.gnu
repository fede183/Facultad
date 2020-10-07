#set terminal latex
set term pngcairo
set out 'ab_conflictos_s0.png'

set xlabel 'Cantidad de vértices'
set ylabel 'Conflictos'
#set ylabel "\\rotatebox{90}{Conflictos}" 
set xrange [10:511]
set yrange [0:*]
set key left top inside

plot 'ab_busquedaLocal_v1_s0.out' using 3:5 with lines lw 2 lc 1 title 'Vecindario 1: Primer color', \
	'' u 3:5 with points pt 2 lc 1 title ''
set out