f(x) = x *0.001
set xlabel 'Cantidad amistades'
#set ylabel 'Tiempo'
set ylabel "\\rotatebox{90}{Tiempo}" 
set xrange [5:40]
set yrange [0:0.1]
set terminal latex
set out 'Tp1Ej3Test2.tex'
plot 'Tp1Ej3Test2.out' using 1:2 title "Resultado experimental" smooth bezier, \
f(x) with lines title "O(a)"
set out 