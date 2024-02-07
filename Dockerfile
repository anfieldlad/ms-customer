
FROM tomcat:jre21

COPY /target/customer-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/customer.war

RUN sed -i 's/8080/5005/' /usr/local/tomcat/conf/server.xml
