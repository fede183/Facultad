set terminal pngcairo
set out 'ej4KnmV2.png'

set xlabel 'Cantidad de vértices'
set ylabel 'Tiempo'
set xrange [20:200]
set yrange [0:*]
set key left top inside

plot 'TestsEj4_1_sol0_v2.dat' using 1:2 smooth bezier title 'Vecindario 2 : Primer color', \
'TestsEj4_1_sol1_v2.dat' using 1:2 smooth bezier title 'Vecindario 2 : Colores random'
set out