FROM 9.0.34-jdk11-openjdk
RUN rm -rf /usr/local/tomcat/webapps/*
COPY ./target/world.war /usr/local/tomcat/webapps/world.war
CMD ["catalina.sh","run"]