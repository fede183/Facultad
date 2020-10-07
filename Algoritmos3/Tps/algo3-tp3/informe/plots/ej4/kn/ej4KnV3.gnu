set terminal pngcairo
set out 'ej4KnV3.png'

set xlabel 'Cantidad de vértices'
set ylabel 'Tiempo'
set xrange [20:200]
set yrange [0:*]
set key left top inside

plot 'TestsEj4_0_sol0_v3.dat' using 1:2 smooth bezier title 'Vecindario 3 : Primer color', \
'TestsEj4_0_sol1_v3.dat' using 1:2 smooth bezier title 'Vecindario 3 : Colores random'
set out