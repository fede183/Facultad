f(x) = x * 0.00000015
set xlabel 'Cantidad de valores del arreglo'
#set ylabel 'Tiempo'
set ylabel "\\rotatebox{90}{Tiempo}" 
set xrange [100000:1000000]
set yrange [0:0.2]
set terminal latex
set out 'Tp1Ej1.tex'
plot 'ej1.dat' using 1:2 smooth bezier title 'Mejor caso', \
'' using 1:3 smooth bezier title 'Peor caso', \
'' using 1:4 smooth bezier title 'Caso promedio', \
f(x) with lines title 'O(n)'
set out