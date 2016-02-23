# Recuperation de l'image de base
FROM tomcat:8-jre8

# Maintainer
MAINTAINER "Jocelyn Tonnelier <jocelyn.tonnelier@gmail.com@gmail.com">

# Copie des wars sur le tomcat
ADD gifSearch.war /usr/local/tomcat/webapps/
ADD sgbdService.war /usr/local/tomcat/webapps/
ADD connexion.war /usr/local/tomcat/webapps/
ADD userGif.war /usr/local/tomcat/webapps/

# On expose le port 8080
EXPOSE 8080