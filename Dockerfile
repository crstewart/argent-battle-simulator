FROM alpine:3.11.5
MAINTAINER argentstew@gmail.com

EXPOSE 80

RUN apk add openjdk8

RUN mkdir /logs
COPY build/libs/argent-battle-simulator-1.0.1-SNAPSHOT.war /abs.war
RUN echo "file.dir=/logs" > /abs.properties

ENTRYPOINT ["java", "-jar", "/abs.war"]