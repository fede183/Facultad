set terminal pngcairo
set out 'Ej3TiemposM.png'

f(x) = (x)*(120**5) * 0.0000000002
set xlabel 'Cantidad de vértices'
set ylabel 'Tiempo'
#set ylabel "\\rotatebox{90}{Tiempo}" 
set xrange [0:9]
set yrange [0:40]
set key left top inside

plot 'ej3TiemposM.dat' using 1:2 smooth bezier title 'Peor caso', \
f(x) with lines title 'O(mn^3c^2)'
set out
