Simple Apache Jena Fuseki embedded server to define SPARQL functions for the NCATS Translator project. 

## Run

```bash
mvn clean run
```

## Package

```bash
mvn clean package
java -jar target/translator-sparql-service-0.0.1-SNAPSHOT.jar
```

On Linux you can just:

```bash
./restart.sh
```

Try out:

```
http://localhost:3330/translator?query=SELECT%20*%20WHERE%20%7B%20%3Fs%20%3Chttps%3A%2F%2Fw3id.org%2Fd2s%2Ffunctions%23identify%3E%20%22holololo%22%20.%20%7D
```

<a href="http://yasgui.triply.cc/#query=PREFIX%20rdf%3A%20%3Chttp%3A%2F%2Fwww.w3.org%2F1999%2F02%2F22-rdf-syntax-ns%23%3E%0APREFIX%20rdfs%3A%20%3Chttp%3A%2F%2Fwww.w3.org%2F2000%2F01%2Frdf-schema%23%3E%0ASELECT%20*%20WHERE%20%7B%20%3Fs%20%3Chttps%3A%2F%2Fw3id.org%2Fd2s%2Ffunctions%23identify%3E%20%22holololo%22%20.%20%7D&endpoint=http%3A%2F%2Flocalhost%3A3330%2Ftranslator&requestMethod=POST&tabTitle=Query&headers=%7B%7D&contentTypeConstruct=application%2Fn-triples%2C*%2F*%3Bq%3D0.9&contentTypeSelect=application%2Fsparql-results%2Bjson%2C*%2F*%3Bq%3D0.9&outputFormat=table">Try it locally</a>

```SPARQL
PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
PREFIX bv: <https://w3id.org/d2s/functions#>

SELECT ?s (bv:identify("tototro") as ?b) WHERE { ?s ?p ?o . }
```



## Docker 

Build:

```bash
docker build -t translator-sparql-service .
```
Run on http://localhost:3330/translator?query=

```bash
docker run -it --rm -p 3330:3330 translator-sparql-service
```

