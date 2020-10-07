#set terminal latex
set term pngcairo
set out 'ab_t_v3.png'

set xlabel 'Cantidad de vértices'
set ylabel 'Tiempo'
#set ylabel "\\rotatebox{90}{Tiempo}" 
set xrange [10:500]
set yrange [0:*]
set key left top inside

plot 'ab_busquedaLocal_v3_s0.out' using 3:6 smooth bezier lw 2 lc 1 title 'Vecindario 3: Primer color', \
	'' u 3:6 with points pt 2 lc 1 title '', \
'ab_busquedaLocal_v3_s2.out' using 3:6 smooth bezier lw 2 lc 2 title 'Vecindario 3: Colores random', \
	'' u 3:6 with points pt 2 lc 2 title '', \
'ab_golosa.out' using 1:4 smooth bezier lw 2 lc 3title 'Heurística golosa', \
	'' u 1:4 with points pt 2 lc 3 title '', \
'ab_exacto.out' using 1:4 smooth bezier lw 2 lc 4title 'Algoritmo exacto' , \
	'' u 1:4 with points pt 2 lc 4 title ''
set out
