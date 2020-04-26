FROM alpine:3.11.5
MAINTAINER argentstew@gmail.com

EXPOSE 80 443

RUN apk add openjdk8 nginx certbot certbot-nginx

RUN mkdir /logs
COPY build/libs/argent-battle-simulator-*.war /abs.war
RUN echo "file.dir=/logs" > /abs.properties

RUN mkdir -p /ssl
COPY nginx/conf.nginx /etc/nginx/nginx.conf
COPY nginx/*.pem /ssl/

RUN mkdir -p /run/nginx
RUN echo "0 0,12 * * * root python -c 'import random; import time; time.sleep(random.random() * 3600)' && certbot renew -q" | tee -a /etc/crontab > /dev/null

RUN mkdir -p /var/www/letsencrypt
COPY run.sh /
RUN chmod +x /run.sh

ENTRYPOINT ["/run.sh"]