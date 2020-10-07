set terminal pngcairo
set out 'ej4KnV1.png'

set xlabel 'Cantidad de vértices'
set ylabel 'Tiempo'
set xrange [20:200]
set yrange [0:*]
set key left top inside

plot 'TestsEj4_0_sol0_v1.dat' using 1:2 smooth bezier title 'Vecindario 1 : Primer color', \
 'TestsEj4_0_sol1_v1.dat' using 1:2 smooth bezier title 'Vecindario 1 : Colores random'
set out