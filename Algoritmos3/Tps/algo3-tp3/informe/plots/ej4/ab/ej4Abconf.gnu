set terminal pngcairo
set out 'ej4AbConf.png'

set xlabel 'Altura del arbol (2^x - 1 vertices)'
set ylabel 'Conflictos'
set yrange [0:*]
set key left top inside

plot 'TestsEj4_ab_sol0_v1.dat' using 1:3 with lines title 'Vecindario 1 : Primer color', \
'TestsEj4_ab_sol1_v1.dat' using 1:3 with lines title 'Vecindario 1 : Colores random' , \
'TestsEj4_ab_sol0_v2.dat' using 1:3 with lines title 'Vecindario 2 : Primer color' , \
'TestsEj4_ab_sol1_v2.dat' using 1:3 with lines title 'Vecindario 2 : Colores random', \
'TestsEj4_ab_sol0_v3.dat' using 1:3 with lines title 'Vecindario 3 : Primer color' , \
'TestsEj4_ab_sol1_v3.dat' using 1:3 with lines title 'Vecindario 3 : Colores random'
set out