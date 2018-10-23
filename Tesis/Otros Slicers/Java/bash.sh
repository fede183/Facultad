#!/bin/sh

# NROS DE PROGRAMA (1er INPUT):
# BH = 1
# BiSort = 2
# Em3d = 3
# Health = 4
# Perimeter = 5
# Power = 6
# TSP = 7

# INPUTS (el resto de los parámetros)
# BH // Inputs originales { 40, 10 } // Inputs chicos { 2, 10 }
# BiSort = 2 // Utilicemos 1000 y 2000
# Em3d // Inputs originales { 50, 10, 3 }
# Health // Inputs originales { 5, 20 } // Inputs chicos { 2, 8 }
# Perimeter // Inputs originales { 12 } // Inputs chicos { 10 }
# Power // Inputs originales { 10, 20, 5, 10 } // Inputs chicos { 2, 4, 1, 2 }
# TSP // Inputs originales { 20 } // Hagamos un caso con 100

# ARCHIVO Y LÍNEA DE SLICE:
# BH bh.BH.main:65
# BiSort bisort.BiSort.main:69
# Em3d em3d.Em3d.main:72
# Health health.Health.main:61
# Perimeter perimeter.Perimeter.main:56
# Power power.Power.main:62
# TSP tsp.TSP.main:53
# MST mst.MST.main:57

PROGNAME[0]=""
PROGNAME[1]="BH"
PROGNAME[2]="BiSort"
PROGNAME[3]="Em3d"
PROGNAME[4]="Health"
PROGNAME[5]="Perimeter"
PROGNAME[6]="Power"
PROGNAME[7]="TSP"
PROGNAME[8]="MST"

CRITERIA[0]="bh.BH.main:65"
CRITERIA[1]="bh.BH.main:65"
CRITERIA[2]="bisort.BiSort.main:69"
CRITERIA[3]="bisort.BiSort.main:69"
CRITERIA[4]="em3d.Em3d.main:73"
CRITERIA[5]="health.Health.main:61"
CRITERIA[6]="health.Health.main:61"
CRITERIA[7]="tsp.TSP.main:53"
CRITERIA[8]="tsp.TSP.main:53"
CRITERIA[9]="perimeter.Perimeter.main:56"
CRITERIA[10]="perimeter.Perimeter.main:56"
CRITERIA[11]="power.Power.main:65"
CRITERIA[12]="power.Power.main:65"
CRITERIA[13]="mst.MST.main:57"
CRITERIA[14]="mst.MST.main:57"
CRITERIA[15]="mst.MST.main:57"

PARAMS[0]="40 10"
PARAMS[1]="2 10"
PARAMS[2]="1000"
PARAMS[3]="2000"
PARAMS[4]="50 10 3"
PARAMS[5]="5 20"
PARAMS[6]="2 8"
PARAMS[7]="20"
PARAMS[8]="100"
PARAMS[9]="12"
PARAMS[10]="10"
PARAMS[11]="2 4 1 2"
PARAMS[12]="10 20 5 10"
PARAMS[13]="20"
PARAMS[14]="40"
PARAMS[15]="400"

PROGRAMNUMBER[0]=1
PROGRAMNUMBER[1]=1
PROGRAMNUMBER[2]=2
PROGRAMNUMBER[3]=2
PROGRAMNUMBER[4]=3
PROGRAMNUMBER[5]=4
PROGRAMNUMBER[6]=4
PROGRAMNUMBER[7]=7
PROGRAMNUMBER[8]=7
PROGRAMNUMBER[9]=5
PROGRAMNUMBER[10]=5
PROGRAMNUMBER[11]=6
PROGRAMNUMBER[12]=6
PROGRAMNUMBER[13]=8
PROGRAMNUMBER[14]=8
PROGRAMNUMBER[15]=8

var1=7
while [ $var1 -lt 9 ]
do
   varArguments=${PARAMS[var1]}
   varCriteria=${CRITERIA[var1]}
   varProgNumber=${PROGRAMNUMBER[var1]}
   varProgName=${PROGNAME[varProgNumber]}
   echo "EXECUTING PROGRAM $varProgNumber WITH ARGUMENTS $varArguments"
   
   START_TIME=$SECONDS
   java -cp JoldenCompleto.jar main.Program $varProgNumber $varArguments
   TIEMPOORIGINAL=$(($SECONDS - $START_TIME))
   
   START_TIME=$SECONDS
   java -noverify -javaagent:tracer.jar=tracefile:JTESTS/test$var1.trace -cp JoldenCompleto.jar main.Program $varProgNumber $varArguments
   TIEMPOTRAZA=$(($SECONDS - $START_TIME))  
   
   START_TIME=$SECONDS
   java -Xmx2g -jar slicer.jar -p JTESTS/test$var1.trace $varCriteria:{sliceVariable} > JTESTS/test$var1.slice
   TIEMPOSLICE=$(($SECONDS - $START_TIME))
   
   # ASÍ YA QUEDA MEJOR EL ARCHIVO
   ./JavaslicerTranslator.exe JTESTS/test$var1.slice JTESTS/test$var1.result JTESTS/test$var1.trace SummaryResultsFile $TIEMPOORIGINAL $TIEMPOTRAZA $TIEMPOSLICE $varProgName $varProgNumber $varArguments
		
	var1=`expr $var1 + 1`
done
