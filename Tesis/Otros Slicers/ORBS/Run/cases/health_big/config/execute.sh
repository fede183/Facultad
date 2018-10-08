#!/bin/sh
ElapsedTimeLimit=2s
cd $1 # move to directory 
rm -rf orbs.output # remoe previous output
#python "C:\Users\Camilo\Desktop\Slicer\complete_configuration_example\ORBS\Run\execute_script\execute.py" $ElapsedTimeLimit "OLDEN.exe" 4 5 20
"C:\Users\Camilo\Desktop\Slicer\complete_configuration_example\ORBS\Run\execute_script\RunTimeout.exe" $ElapsedTimeLimit "OLDEN.exe" 4 5 20 > output.orbs
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
