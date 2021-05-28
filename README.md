Simple Apache Jena Fuseki embedded server to define custom SPARQL functions easily. 

<a href="https://yasgui.triply.cc/#query=PREFIX%20umtranslator%3A%20%3Chttps%3A%2F%2Fw3id.org%2Fum%2Ftranslator%2F%3E%0A%0ASELECT%20%3Flabel%20WHERE%20%7B%20BIND(umtranslator%3Aget_label(%22MONDO%3A0005146%22)%20as%20%3Flabel)%20%7D&endpoint=https%3A%2F%2Ffuseki.translator.137.120.31.102.nip.io%2Fsparql&requestMethod=POST&tabTitle=Local&headers=%7B%7D&contentTypeConstruct=application%2Fn-triples%2C*%2F*%3Bq%3D0.9&contentTypeSelect=application%2Fsparql-results%2Bjson%2C*%2F*%3Bq%3D0.9&outputFormat=table">Try it with YASGUI</a>, endpoint available at https://fuseki.translator.137.120.31.102.nip.io/sparql


## Run

```bash
mvn clean package
java -jar target/fuseki-sparql-custom-functions-0.0.1-SNAPSHOT.jar
```

On Linux you can just:

```bash
./restart.sh
```

Query with the URL  http://localhost:3330/sparql?query=

<a href="http://yasgui.triply.cc/#query=PREFIX%20umtranslator%3A%20%3Chttps%3A%2F%2Fw3id.org%2Fum%2Ftranslator%2F%3E%0A%0ASELECT%20%3Flabel%20WHERE%20%7B%20BIND(umtranslator%3Aget_label(%22MONDO%3A0005146%22)%20as%20%3Flabel)%20%7D&endpoint=http%3A%2F%2Flocalhost%3A3330%2Fsparql&requestMethod=POST&tabTitle=Query&headers=%7B%7D&contentTypeConstruct=application%2Fn-triples%2C*%2F*%3Bq%3D0.9&contentTypeSelect=application%2Fsparql-results%2Bjson%2C*%2F*%3Bq%3D0.9&outputFormat=table">Try the query with YASGUI</a>:

```SPARQL
PREFIX umtranslator: <https://w3id.org/um/translator/>

SELECT ?label WHERE { BIND(umtranslator:get_label("MONDO:0005146") as ?label) }
```

## With docker 

Build:

```bash
docker build -t fuseki-sparql-custom-functions .
```

Run on http://localhost:3330/sparql?query=

```bash
docker run -it --rm -p 3330:3330 fuseki-sparql-custom-functions
```

