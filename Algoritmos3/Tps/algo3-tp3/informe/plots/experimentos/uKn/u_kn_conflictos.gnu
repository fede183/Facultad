#set terminal latex
set term pngcairo
set out 'u_kn_conflictos.png'

set xlabel 'Cantidad de vértices'
set ylabel 'Conflictos'
#set ylabel "\\rotatebox{90}{Conflictos}" 
set xrange [10:*]
set yrange [0:*]
set key left top inside

plot  \
'u_kn_busquedaLocal_v1_s2.out' using 3:5 smooth bezier lw 2 lc 1 title 'Vecindario 1: Colores random', \
	'' u 3:5 with points pt 2 lc 1 title '', \
'u_kn_busquedaLocal_v3_s2.out' using 3:5 smooth bezier lw 2 lc 6 title 'Vecindario 3: Colores random', \
	'' u 3:5 with points pt 2 lc 6 title '', \
'u_kn_golosa.out' using 1:3 smooth bezier lw 2 lc 8 title 'Heurística golosa', \
	'' u 1:3 with points pt 2 lc 8 title ''
set out