set terminal pngcairo
set out 'ej3Familia1.png'

set xlabel 'Cantidad de vértices'
set ylabel 'Fallos'
#set ylabel "\\rotatebox{90}{Fallos}" 
set xrange [10:65540]
set yrange [0:33000]
set key left top inside

plot 'ej3Familia1.dat' using 1:2 smooth bezier title 'Familia de árbol', \
