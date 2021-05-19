#!/bin/bash

mvn clean package
java -jar target/translator-sparql-service-0.0.1-SNAPSHOT.jar
