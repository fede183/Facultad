set xlabel 'Cantidad de valores del arreglo'
#set ylabel 'Tiempo'
set ylabel "\\rotatebox{90}{Tiempo}" 
#set xtics font ",10" 
set xrange [100000:1000000]
set yrange [0:0.000000000001]
set terminal latex
set out 'Tp1Ej2.2.tex'
plot 'ej2.2.dat' using 1:3 smooth bezier title 'Mejor caso', \
'' using 1:2 smooth bezier title 'Peor caso', \
'' using 1:4 smooth bezier title 'Caso promedio'
set out