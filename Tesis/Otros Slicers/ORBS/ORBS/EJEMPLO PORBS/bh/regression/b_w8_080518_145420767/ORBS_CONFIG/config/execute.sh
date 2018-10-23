#!/bin/sh
ElapsedTimeLimit=1s
cd $1 # move to directory 
rm -rf orbs.output # remoe previous output
time timeout -s KILL $ElapsedTimeLimit java -cp . main.Program 1 40 10 > output.orbs 2>&1 #execute
rc=$? #capture return code
if [ -f output.orbs ]; then
	if [ "$4" = "GA" ] 
	then
		grep -m1 "" output.orbs
	else
		grep -m1 "" output.orbs | md5sum #capture hash of return
	fi    	
else
    echo FAIL
fi

rm -rf output.orbs # clear output file

exit $rc # return
