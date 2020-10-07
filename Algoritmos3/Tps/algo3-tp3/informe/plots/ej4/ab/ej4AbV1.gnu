set terminal pngcairo
set out 'ej4AbV1.png'

set xlabel 'Altura del arbol (2^x - 1 vertices)'
set ylabel 'Tiempo'

set key left top inside

plot 'TestsEj4_ab_sol0_v1.dat' using 1:2 smooth bezier title 'Vecindario 1 : Primer color' ,\
'TestsEj4_ab_sol1_v1.dat' using 1:2 smooth bezier title 'Vecindario 1 : Colores random'
set out