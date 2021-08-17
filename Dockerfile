# For Java 8, try this
 FROM openjdk:8-jdk-alpine

# For Java 11, try this
#FROM adoptopenjdk/openjdk11:alpine-jre

# Refer to Maven build -> finalName
ARG JAR_FILE=target/RADBlk40-0.0.1-SNAPSHOT.jar

# cd /opt/app
WORKDIR /opt/app

# cp target/spring-boot-web.jar /opt/app/app.jar
COPY ${JAR_FILE} app.jar

# java -jar /opt/app/app.jar   
ENTRYPOINT ["java","-jar","app.jar","-web -webAllowOthers -tcp -tcpAllowOthers -browser"]

#docker build -t rad40 .

#docker run -p 8082:8082 --name rad40Api --net network0 -d rad40