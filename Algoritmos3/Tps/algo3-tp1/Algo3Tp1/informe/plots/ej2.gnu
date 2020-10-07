f(x) = x * log(x) * 0.000000014
set xlabel 'Cantidad de valores del arreglo'
#set ylabel 'Tiempo'
set ylabel "\\rotatebox{90}{Tiempo}" 
#set xtics font ",10" 
set xrange [100000:1000000]
set yrange [0:0.5]
set terminal latex
set out 'Tp1Ej2.tex'
plot 'ej2.dat' using 1:3 smooth bezier title 'Mejor caso', \
'' using 1:2 smooth bezier title 'Peor caso', \
'' using 1:4 smooth bezier title 'Caso promedio', \
f(x) with lines title 'O(n log(n))'
set out