set terminal pngcairo
set out 'ej1Tiempos.png'

f(x) = ((x**2 * 15000))
set xlabel 'Cantidad de vértices'
set ylabel "\\rotatebox{90}{Tiempos}" 
set xrange [20:2200]
set yrange [0.0:57000000000.0]
set key left top inside

plot 'ej1Tiempos.dat' using 1:2 smooth bezier title 'Instancias', \
f(x) with lines title 'O($n^2$)'
set out
