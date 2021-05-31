package org.semanticscience.d2s.functions;

import org.apache.jena.sparql.expr.NodeValue;
import org.apache.jena.sparql.function.FunctionBase1;

import org.springframework.web.reactive.function.client.WebClient;
import java.util.LinkedHashMap;
import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.JSONObject;

import org.apache.commons.lang3.StringUtils;

// Docs: https://jena.apache.org/documentation/query/writing_functions.html
// FunctionBase1 for function with one argument, up to FunctionBase4

public class TranslatorLabelFunction extends FunctionBase1
{

    String dataset;
    public TranslatorLabelFunction(String dataset) {
        super();
	    this.dataset = dataset;
    }

    public NodeValue exec(NodeValue nv1)
    {
        if (!nv1.isString())
        {
            return nv1;
        }

        String curieToResolve = StringUtils.strip(nv1.toString(), "\"")
            .replace("https://identifiers.org/", "")
            .replace("https://go.drugbank.com/drugs/", "DRUGBANK:")
            .replace("http://purl.obolibrary.org/obo/HP_", "HP:")
            .replace("http://purl.obolibrary.org/obo/MONDO_", "MONDO:");

        String outputStr = curieToResolve;

        String query_uri = "https://nodenormalization-sri.renci.org/get_normalized_nodes?curie=" + curieToResolve;
        System.out.println(query_uri);
        
        try {
	        // https://stackoverflow.com/questions/62822976/how-to-get-response-json-from-spring-webclient
	        WebClient webClient = WebClient.create();
	        JSONObject responseJson = (JSONObject) webClient.get()
	            .uri(query_uri)
	            .retrieve()
	            .bodyToMono(JSONObject.class)
	            .block();
	        System.out.println(responseJson.toString());
	        
	        LinkedHashMap curieObj = (LinkedHashMap) responseJson.get(curieToResolve);
	        LinkedHashMap idObj = (LinkedHashMap) curieObj.get("id");
			outputStr = (String) idObj.get("label");
			System.out.println(outputStr);
        
         } catch (Exception e){
             e.printStackTrace();
         }

        return NodeValue.makeString(outputStr);
    }
}