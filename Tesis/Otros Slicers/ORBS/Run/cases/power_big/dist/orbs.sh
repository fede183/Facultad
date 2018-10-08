bash -x config/setup.sh orig
#Setup the path for the system
cat config/OrbsFramework.properties | sed -e "3s@.*@PATH = $PATH;@" > config/tmp_file
mv config/tmp_file config/OrbsFramework.properties
rm -rf work logs time.log run.log
echo 'Starting PORBS';
{ time java -Dlog4j.configurationFile=dist/log4j2.xml -jar dist/orbs.jar ; } 2> time.log
