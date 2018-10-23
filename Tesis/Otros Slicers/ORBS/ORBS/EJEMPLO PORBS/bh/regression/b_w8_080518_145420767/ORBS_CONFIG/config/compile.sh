cd $1 #Move to system directory
rm -f main/Program.class bh/BH.class bh/Body.class bh/Cell.class bh/HG.class bh/MathVector.class bh/Node.class bh/Tree.class # Remove existing output
javac main/Program.java bh/BH.java bh/Body.java bh/Cell.java bh/HG.java bh/MathVector.java bh/Node.java bh/Tree.java 2>> compile.log #Build
if [ -f main/Program.class -a -f bh/BH.class -a -f bh/Body.class -a -f bh/Cell.class -a -f bh/HG.class -a -f bh/MathVector.class -a -f bh/Node.class -a -f bh/Tree.class ]; then #check build
    echo `md5sum main/Program.class` `md5sum bh/BH.class` `md5sum bh/Body.class` `md5sum bh/Cell.class` `md5sum bh/HG.class` `md5sum bh/MathVector.class` `md5sum bh/Node.class` `md5sum bh/Tree.class`
else
    echo FAIL
fi




