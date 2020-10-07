#set terminal latex
set term pngcairo
set out 'f_conf.png'

set xlabel 'Cantidad de vértices'
set ylabel 'Conflictos'
#set ylabel "\\rotatebox{90}{Tiempo}"
set xrange [10:*]
set yrange [0:*]
set key left top inside

plot 'f_busquedaLocal_v1_s2.out' using 3:5 smooth bezier lw 2 lc 1 title 'Vecindario 1: Primer color', \
'' u 3:5 with points pt 2 lc 1 title '', \
'f_busquedaLocal_v3_s2.out' using 3:5 smooth bezier lw 2 lc 2 title 'Vecindario 3: Colores Random', \
'' u 3:5 with points pt 2 lc 2 title '', \
'f_golosa.out' using 1:3 smooth bezier lw 2 lc 3 title 'Heurística golosa', \
	'' u 1:3 with points pt 2 lc 3 title ''

set out