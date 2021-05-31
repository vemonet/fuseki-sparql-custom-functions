Simple Apache Jena Fuseki embedded server to define custom SPARQL functions easily. 

<a href="https://yasgui.triply.cc/#query=PREFIX%20rdf%3A%20%3Chttp%3A%2F%2Fwww.w3.org%2F1999%2F02%2F22-rdf-syntax-ns%23%3E%0APREFIX%20rdfs%3A%20%3Chttp%3A%2F%2Fwww.w3.org%2F2000%2F01%2Frdf-schema%23%3E%0APREFIX%20biolink%3A%20%3Chttps%3A%2F%2Fw3id.org%2Fbiolink%2Fvocab%2F%3E%0APREFIX%20np%3A%20%3Chttp%3A%2F%2Fwww.nanopub.org%2Fnschema%23%3E%0APREFIX%20npx%3A%20%3Chttp%3A%2F%2Fpurl.org%2Fnanopub%2Fx%2F%3E%0Aprefix%20npa%3A%20%3Chttp%3A%2F%2Fpurl.org%2Fnanopub%2Fadmin%2F%3E%0APREFIX%20dct%3A%20%3Chttp%3A%2F%2Fpurl.org%2Fdc%2Fterms%2F%3E%0APREFIX%20orcid%3A%20%3Chttps%3A%2F%2Forcid.org%2F%3E%0APREFIX%20umtranslator%3A%20%3Chttps%3A%2F%2Fw3id.org%2Fum%2Ftranslator%2F%3E%0ASELECT%20DISTINCT%20%3Flabel%20%3Fsubject%20%3Fobject%20(umtranslator%3Aget_label(str(%3Fsubject))%20AS%20%3FsubjectLabel)%0AWHERE%20%7B%0A%20%20%7B%0A%20%20%09SERVICE%20%3Chttp%3A%2F%2Fvirtuoso.np.dumontierlab.137.120.31.101.nip.io%2Fsparql%3E%20%7B%0A%20%20%20%20%20%20%20%20graph%20%3Fnp_assertion%20%7B%0A%20%20%20%20%20%20%20%20%20%20%3Fassociation%20%0A%20%20%20%20%20%20%20%20%20%20%20%20rdfs%3Alabel%20%3Flabel%20%3B%0A%20%20%20%20%20%20%20%20%20%20%20%20rdf%3Asubject%20%3Fsubject%20%3B%0A%20%20%20%20%20%20%20%20%20%20%20%20rdf%3Apredicate%20%3Fpredicate%20%3B%0A%20%20%20%20%20%20%20%20%20%20%20%20rdf%3Aobject%20%3Fobject%20.%0A%20%20%20%20%20%20%20%20%20%20OPTIONAL%20%7B%0A%20%20%20%20%20%20%20%20%20%20%20%20%3Fassociation%20biolink%3Arelation%20%3Frelation%20.%0A%20%20%20%20%20%20%20%20%20%20%7D%0A%20%20%20%20%20%20%20%20%20%20OPTIONAL%20%7B%0A%20%20%20%20%20%20%20%20%20%20%20%20%3Fassociation%20biolink%3Aprovided_by%20%3Fprovided_by%20.%0A%20%20%20%20%20%20%20%20%20%20%7D%0A%20%20%20%20%20%20%20%20%20%20OPTIONAL%20%7B%0A%20%20%20%20%20%20%20%20%20%20%20%20%3Fassociation%20biolink%3Aassociation_type%20%3Fassociation_type%20.%0A%20%20%20%20%20%20%20%20%20%20%7D%0A%20%20%20%20%20%20%20%20%20%20%3Fsubject%20biolink%3Acategory%20%3Fsubject_category%20.%0A%20%20%20%20%20%20%20%20%20%20%3Fobject%20biolink%3Acategory%20%3Fobject_category%20.%0A%20%20%20%20%20%20%20%20%7D%0A%20%20%20%20%20%20%20%20FILTER%20(%20%3Fsubject_category%20%3D%20biolink%3ADrug%20%7C%7C%20%3Fsubject_category%20%3D%20biolink%3AChemicalSubstance%20)%0A%20%20%20%20%20%20FILTER%20(%20%3Fobject_category%20%3D%20biolink%3ADisease%20)%0A%20%20%20%20%20%20%23FILTER%20(%20%3Fsubject%20%3D%20%3Chttps%3A%2F%2Fidentifiers.org%2FDRUGBANK%3ADB00394%3E%20%7C%7C%20%3Fsubject%20%3D%20%3Chttps%3A%2F%2Fidentifiers.org%2FCHEBI%3A75725%3E%20)%0A%20%20%20%20%20%20%20%20graph%20%3Fnp_head%20%7B%0A%20%20%20%20%20%20%20%20%20%20%3Fnp_uri%20np%3AhasAssertion%20%3Fnp_assertion%20.%0A%20%20%20%20%20%20%20%20%7D%0A%20%20%20%20%20%20%20%20graph%20npa%3Agraph%20%7B%0A%20%20%20%20%20%20%20%20%20%20%3Fnp_uri%20npa%3AhasValidSignatureForPublicKey%20%3Fpubkey%20.%0A%20%20%20%20%20%20%20%20%7D%0A%20%20%20%20%20%20%20%20%7B%0A%20%20%20%20%20%20%20%20%20%20%3Fnp_uri%20dct%3Acreator%20orcid%3A0000-0002-7641-6446%20.%0A%20%20%20%20%20%20%20%20%7D%0A%20%20%20%20%20%20%20%20FILTER%20(%20str(%3Fpubkey)%20%3D%20%22MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCamPJb4SzqpLXn%2F%2FXJ5dlVfzz6QI%2BRPmiJTLXF%2Fby2JR7sHMKRsCQDFsYMlq8zGHghOIkjRP9dpLZUtZzUcHt3MXiFKEPo8eGzUe9p%2BJXKFC8xxkJr94z2vq6IdMf71Iu1GH8SeDAKt%2FDgYO4zNaw8VuXvxnZRewKZSA%2Bu8zWPVwIDAQAB%22)%0A%20%20%20%20%20%20%20%20FILTER%20NOT%20EXISTS%20%7B%20%3Fcreator%20npx%3Aretracts%20%3Fnp_uri%20%7D%0A%20%20%20%20%20%7D%0A%20%20%7D%0A%23%20%20%7B%0A%23%20%20%20%20BIND(umtranslator%3Aget_label(str(%3Fsubject))%20AS%20%3FsubjectLabel)%0A%23%20%20%20%20BIND(umtranslator%3Aget_label(str(%3Fobject))%20AS%20%3FobjectLabel)%0A%23%20%20%7D%0A%7D%20LIMIT%2010&endpoint=https%3A%2F%2Ffuseki.translator.137.120.31.102.nip.io%2Fsparql&requestMethod=POST&tabTitle=Query%20label%20from%20rdflib&headers=%7B%7D&contentTypeConstruct=application%2Fn-triples%2C*%2F*%3Bq%3D0.9&contentTypeSelect=application%2Fsparql-results%2Bjson%2C*%2F*%3Bq%3D0.9&outputFormat=table">Try a federated query to resolve labels from the nanopublication network from our test endpoint</a>

## Run

```bash
mvn clean package
java -jar target/fuseki-sparql-custom-functions-0.0.1-SNAPSHOT.jar
```

On Linux you can just:

```bash
./restart.sh
```

Try out with the URL http://localhost:3330/sparql?query=

<a href="http://localhost:3330/sparql?query=PREFIX%20rdf%3A%20%3Chttp%3A%2F%2Fwww.w3.org%2F1999%2F02%2F22-rdf-syntax-ns%23%3E%0APREFIX%20rdfs%3A%20%3Chttp%3A%2F%2Fwww.w3.org%2F2000%2F01%2Frdf-schema%23%3E%0APREFIX%20umtranslator%3A%20%3Chttps%3A%2F%2Fw3id.org%2Fum%2Ftranslator%2F%3E%0A%0ASELECT%20%3Flabel%20WHERE%20%7B%20BIND(umtranslator%3Aget_label(%22MONDO%3A0005146%22)%20as%20%3Flabel)%20%7D">Try it locally</a> with this SPARQL query:

```SPARQL
PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
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

