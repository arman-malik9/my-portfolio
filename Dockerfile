FROM ubuntu
MAINTAINER Arman Malik
RUN apt-get update -y && apt-get upgrade -y
RUN  apt-get install openjdk-17-jdk openjdk-17-jre -y
#RUN  apt-get -y install maven
WORKDIR /portfolio
COPY ./target/portfolio-0.0.1-SNAPSHOT.war /portfolio/portfolio-0.0.1-SNAPSHOT.war
EXPOSE 9090
ENTRYPOINT ["java","-jar","portfolio-0.0.1-SNAPSHOT.war"]
#CMD setsid mvn spring-boot:run




