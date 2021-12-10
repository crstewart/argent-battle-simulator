FROM alpine:3.14.2
LABEL author="argentstew@gmail.com"

EXPOSE 80

RUN apk add openjdk8

RUN mkdir /logs
COPY build/libs/argent-battle-simulator-*.war /abs.war
RUN echo "file.dir=/logs" > /abs.properties

ENTRYPOINT ["java", "-jar", "/abs.war"]