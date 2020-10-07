f(x) = x ** x *0.00002
set xlabel 'Cantidad de exploradoras'
#set ylabel 'Tiempo'
set ylabel "\\rotatebox{90}{Tiempo}" 
set xrange [5:12]
set yrange [0:32]
set terminal latex
set out 'Tp1Ej3Test3.tex'
plot 'Tp1Ej3Test3.out' using 1:2 title "Mejor caso" smooth bezier, \
'Tp1Ej3Test4.out' using 1:2 title "Peor caso" smooth bezier, \
f(x) with lines title "$O(e\^e)$"
set out 