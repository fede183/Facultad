set terminal pngcairo
set out 'ej2Tiempos.png'

f(x) = ((x*x)**(x*x))*0.0000000000000000000000000000000000000001
set xlabel 'Cantidad de vértices'
set ylabel 'Tiempo'
set xrange [2:11]
set yrange [0:13460]
set key left top inside

plot 'ej2Tiempos.dat' using 1:2 smooth bezier title 'Peor caso', \
f(x) with lines title 'Complejidad'
set out
