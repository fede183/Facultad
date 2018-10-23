#!/bin/sh

# This file is part of the ORBS distribution.
# See the file LICENSE.TXT for more information.

# The compilation script.
#
# This script is called from ORBS to actually compile (build) the system.
#
# The script must return a generated signature if compilation was
# successful and must return "FAIL" if compilation was not
# successful. The signature should be, for example, an md5 hash over
# the generated binary.

# Configure ORBS for this project.
. config/config.sh

cd work

# cleanup from previous run (just to make sure)
rm -f Program.class
#rm -f src/main/java/lafhis/NHibernateSimpleDemo/main/Program.class src/main/java/lafhis/NHibernateSimpleDemo/main/Address.class src/main/java/lafhis/NHibernateSimpleDemo/main/Controller.class src/main/java/lafhis/NHibernateSimpleDemo/main/Customer.class src/main/java/lafhis/NHibernateSimpleDemo/main/Order.class src/main/java/lafhis/NHibernateSimpleDemo/main/OrderSystem.class src/main/java/lafhis/NHibernateSimpleDemo/main/PersistenceManager.class src/main/java/lafhis/NHibernateSimpleDemo/main/Product.class src/main/java/lafhis/NHibernateSimpleDemo/main/SessionAction.class

# The actual compilation.  This can be replaced by any mechanism to
# build the system, e.g. by invoking make.

javac src/main/java/lafhis/NHibernateSimpleDemo/main/Program.java 2>> compile.log

#javac -cp "src/main:../repos/*" src/main/java/lafhis/NHibernateSimpleDemo/main/Program.java src/main/java/lafhis/NHibernateSimpleDemo/main/Address.java src/main/java/lafhis/NHibernateSimpleDemo/main/Controller.java src/main/java/lafhis/NHibernateSimpleDemo/main/Customer.java src/main/java/lafhis/NHibernateSimpleDemo/main/Order.java src/main/java/lafhis/NHibernateSimpleDemo/main/OrderSystem.java src/main/java/lafhis/NHibernateSimpleDemo/main/PersistenceManager.java src/main/java/lafhis/NHibernateSimpleDemo/main/Product.java src/main/java/lafhis/NHibernateSimpleDemo/main/SessionAction.java 2>> compile.log #Build
#gcc $CFLAGS -o reader reader.c 2> compile.log
#javac checker.java 2>> compile.log

if [ -f src/main/java/lafhis/NHibernateSimpleDemo/main/Program.class ]; then 
	echo `md5sum src/main/java/lafhis/NHibernateSimpleDemo/main/Program.class`
else
	echo FAIL
fi

#if [ -f src/main/java/lafhis/NHibernateSimpleDemo/main/Program.class -a -f src/main/java/lafhis/NHibernateSimpleDemo/main/Address.class -a -f src/main/java/lafhis/NHibernateSimpleDemo/main/Controller.class -a -f src/main/java/lafhis/NHibernateSimpleDemo/main/Customer.class -a -f src/main/java/lafhis/NHibernateSimpleDemo/main/Order.class -a -f src/main/java/lafhis/NHibernateSimpleDemo/main/OrderSystem.class -a -f src/main/java/lafhis/NHibernateSimpleDemo/main/PersistenceManager.class -a -f src/main/java/lafhis/NHibernateSimpleDemo/main/Product.class -a -f src/main/java/lafhis/NHibernateSimpleDemo/main/SessionAction.class ]; then #check build
#    echo `md5sum src/main/java/lafhis/NHibernateSimpleDemo/main/Program.class` `md5sum src/main/java/lafhis/NHibernateSimpleDemo/main/Address.class` `md5sum src/main/java/lafhis/NHibernateSimpleDemo/main/Controller.class` `md5sum src/main/java/lafhis/NHibernateSimpleDemo/main/Customer.class` `md5sum src/main/java/lafhis/NHibernateSimpleDemo/main/Order.class` `md5sum src/main/java/lafhis/NHibernateSimpleDemo/main/OrderSystem.class` `md5sum src/main/java/lafhis/NHibernateSimpleDemo/main/PersistenceManager.class` `md5sum src/main/java/lafhis/NHibernateSimpleDemo/main/Product.class` `md5sum src/main/java/lafhis/NHibernateSimpleDemo/main/SessionAction.class`
#else
#    echo FAIL
#fi


