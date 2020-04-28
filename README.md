Simple Apache Jena Fuseki embedded server to define SPARQL functions for the NCATS Translator project. 

## Build

```bash
docker build -t translator-sparql-service .
```
---

# Run

```bash
docker run -it --rm -p 3330:3330 translator-sparql-service
```

> Access at http://localhost:3330/translator?query=