#!/bin/bash

mvn clean package
java -jar target/fuseki-sparql-custom-functions-0.0.1-SNAPSHOT.jar
