set terminal pngcairo
set out 'ej2TiemposC.png'

f(x) = ((x*x)**(x*x))*0.0000000000000000000000000000000000000001
set xlabel 'Cantidad de vértices'
set ylabel 'Tiempos' 
set xrange [2:10]
set yrange [0:11190]
set key left top inside

plot 'ej2TiemposC.dat' using 1:2 smooth bezier title 'Peor caso', \
f(x) with lines title 'Complejidad'
set out