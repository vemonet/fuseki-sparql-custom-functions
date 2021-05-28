#!/bin/bash

git add .
git commit -m "Improvements"
git push

ssh ids2 'cd /data/deploy-ids-tests/fuseki-sparql-custom-functions ; git pull ; docker-compose down ; docker-compose up -d --build'
