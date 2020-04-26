#!/usr/bin/env ash

certbot --nginx --non-interactive --agree-tos -m "argentstew@gmail.com" -d argentfightingleague.com -d argentbattlesimulator.com

java -jar /abs.war