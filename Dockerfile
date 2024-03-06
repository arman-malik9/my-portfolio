FROM ubuntu
MAINTAINER Arman Malik          
RUN apt-get update -y && apt-get upgrade -y
RUN  apt-get install openjdk-17-jdk openjdk-17-jre -y
#RUN  apt-get -y install maven
WORKDIR /portfolio
COPY ./target/*.war /portfolio/web-app.war
EXPOSE 9090
ENTRYPOINT ["java","-jar","web-app.war"]
#CMD setsid mvn spring-boot:run




