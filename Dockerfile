FROM 9.0.34-jdk11-openjdk
RUN rm -rf /usr/local/tomcat/webapps/*
ADD target/world.war /usr/local/tomcat/webapps/
CMD ["catalina.sh","run"]