#!/bin/sh
rm -rf $1 #Remove existing setup
cp -r code $1 #Setup of the program
cd $1 #Move to the setup
#Setup of test script
#cat > orbstest.sh <<EOF
#!/bin/sh
#LC_ALL="en_US" python glue.py 1 00 
#LC_ALL="en_US" python glue.py 10 00
#EOF
