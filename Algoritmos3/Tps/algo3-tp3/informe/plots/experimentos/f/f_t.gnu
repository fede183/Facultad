#set terminal latex
set term pngcairo
set out 'f_t.png'

set xlabel 'Cantidad de vértices'
set ylabel 'Tiempo (ms)'
#set ylabel "\\rotatebox{90}{Tiempo}"
set xrange [10:*]
set yrange [0:*]
set key left top inside

plot 'f_busquedaLocal_v1_s0.out' using 3:6 smooth bezier lw 2 lc 4 title 'Vecindario 1: Primer color', \
	'' u 3:6 with points pt 2 lc 4 title '', \
'f_busquedaLocal_v2_s0.out' using 3:6 smooth bezier lw 2 lc 2 title 'Vecindario 2: Primer color', \
	'' u 3:6 with points pt 2 lc 2 title '', \
'f_busquedaLocal_v3_s0.out' using 3:6 smooth bezier lw 2 lc 1 title 'Vecindario 3: Primer color', \
	'' u 3:6 with points pt 2 lc 1 title '' 
set out