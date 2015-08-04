Here is how to setup:
---------------------

checkout the code and buid a war out of it.

Maven command

	mvn clean install
	
Copy the war and put in webapps directory of a tomcat.

This project uses mysql database and expects db username and password to be root/root respectively.

login to mysql and create schema named "hospital"

start tomcat and in your browser's address bar type 

http://localhost:8080/hospital

Awesome!!!