set terminal pngcairo
set out 'ej4AbV2.png'

set xlabel 'Altura del arbol (2^x - 1 vertices)'
set ylabel 'Tiempo'
set yrange [0:*]
set key left top inside

plot 'TestsEj4_ab_sol0_v2.dat' using 1:2 smooth bezier title 'Vecindario 2 : Primer color', \
'TestsEj4_ab_sol1_v2.dat' using 1:2 smooth bezier title 'Vecindario 2 : Colores random'
set out