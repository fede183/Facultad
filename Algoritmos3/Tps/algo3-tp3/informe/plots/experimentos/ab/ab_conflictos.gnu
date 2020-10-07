#set terminal latex
set term pngcairo
set out 'ab_conflictos.png'

set xlabel 'Cantidad de vértices'
set ylabel 'Conflictos'
#set ylabel "\\rotatebox{90}{Conflictos}" 
set xrange [10:511]
set yrange [0:*]
set key left top inside

plot 'ab_busquedaLocal_v1_s2.out' using 3:5 smooth bezier lw 2 lc 1 title 'Vecindario 1: Colores random', \
	'' u 3:5 with points pt 2 lc 1 title '', \
'ab_busquedaLocal_v2_s2.out' using 3:5 smooth bezier lw 2 lc 3 title 'Vecindario 2: Colores random', \
	'' u 3:5 with points pt 2 lc 3 title '', \
'ab_busquedaLocal_v3_s2.out' using 3:5 smooth bezier lw 2 lc 4 title 'Vecindario 3: Colores random', \
	'' u 3:5 with points pt 2 lc 4 title '', \
'ab_golosa.out' using 1:3 smooth bezier lw 2 lc 5 title 'Heurística golosa', \
	'' u 1:3 with points pt 2 lc 5 title ''
set out