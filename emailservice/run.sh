sudo docker build -t tomcat tomcat/.
cd service
mvn tomcat7:deploy
