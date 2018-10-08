#!/bin/sh
ElapsedTimeLimit=3s
cd $1 # move to directory 
rm -rf orbs.output # remoe previous output
python "C:\Users\Camilo\Desktop\Slicer\complete_configuration_example\ORBS\Run\execute_script\execute.py" $ElapsedTimeLimit "OLDEN.exe" 2 2000
rc=$? #capture return code
if [ -f output.orbs ]; then
	grep -m1 "" output.orbs | md5sum 
else
    echo FAIL
fi

rm -rf output.orbs # clear output file

exit $rc # return
