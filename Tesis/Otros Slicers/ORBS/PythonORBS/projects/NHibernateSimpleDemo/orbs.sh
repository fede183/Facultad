#!/bin/bash

# This file is part of the ORBS distribution.
# See the file LICENSE.TXT for more information.

# Invoke ORBS.

# Configure ORBS for this project.
. config/config.sh

#export ORBS_SCRIPT="orbs.py"

# The ORBS working space
#export ORBS="$PWD"

# The list of files to be sliced
#export ORBS_FILES="orig/src/main/java/lafhis/NHibernateSimpleDemo/main/Program.java orig/src/main/java/lafhis/NHibernateSimpleDemo/main/Address.java orig/src/main/java/lafhis/NHibernateSimpleDemo/main/Controller.java orig/src/main/java/lafhis/NHibernateSimpleDemo/main/Customer.java orig/src/main/java/lafhis/NHibernateSimpleDemo/main/Order.java orig/src/main/java/lafhis/NHibernateSimpleDemo/main/OrderSystem.java orig/src/main/java/lafhis/NHibernateSimpleDemo/main/PersistenceManager.java orig/src/main/java/lafhis/NHibernateSimpleDemo/main/Product.java orig/src/main/java/lafhis/NHibernateSimpleDemo/main/SessionAction.java"

# Pass the arguments to ORBS together with the list of files to be sliced.
python3  "$ORBS_SCRIPT" $* $ORBS_FILES

