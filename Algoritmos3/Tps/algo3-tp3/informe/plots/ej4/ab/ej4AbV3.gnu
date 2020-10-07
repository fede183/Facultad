set terminal pngcairo
set out 'ej4AbV3.png'

set xlabel 'Altura del arbol (2^x - 1 vertices)'
set ylabel 'Tiempo'
set yrange [0:*]
set key left top inside

plot 'TestsEj4_ab_sol0_v3.dat' using 1:2 smooth bezier title 'Vecindario 3 : Primer color', \
'TestsEj4_ab_sol1_v3.dat' using 1:2 smooth bezier title 'Vecindario 3 : Colores random'
set out