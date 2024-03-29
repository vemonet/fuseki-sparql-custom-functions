package org.semanticscience.d2s;

import org.semanticscience.d2s.functions.TranslatorLabelFunctionFactory;

import org.apache.jena.fuseki.embedded.FusekiServer;
import org.apache.jena.sparql.function.FunctionFactory;
import org.apache.jena.sparql.function.FunctionRegistry;
import org.apache.jena.sparql.pfunction.PropertyFunctionRegistry;
import org.apache.jena.query.DatasetFactory;
import org.apache.jena.query.Dataset;
import org.apache.jena.query.ARQ;
//import org.apache.jena.riot.RDFDataMgr;

// import org.apache.jena.atlas.logging.LogCtl;

// https://stackoverflow.com/questions/18262164/how-do-you-use-user-defined-functions-in-fuseki/18329654
public class FusekiEndpoint {

    int port = 3330;
    
    public void run() {
//		 LogCtl.setJavaLogging();

		// Create empty dataset
		Dataset fusekiDataset = DatasetFactory.createGeneral();
		// Dataset fusekiDataset = DatasetFactory.create();
		
		// Import URI or file
		// Dataset fusekiDataset = RDFDataMgr.loadDataset("https://raw.githubusercontent.com/MaastrichtU-IDS/d2s-scripts-repository/master/resources/biolink.ttl");
		// Dataset fusekiDataset = RDFDataMgr.loadDataset("/app/init.nt");

		FusekiServer.Builder fsb = FusekiServer.create()
		    .setPort(this.port)
		    .add("/sparql", fusekiDataset);

		final PropertyFunctionRegistry reg = PropertyFunctionRegistry
		    .chooseRegistry(ARQ.getContext());

		FunctionRegistry.get().put("https://w3id.org/um/translator/get_label", (FunctionFactory) new TranslatorLabelFunctionFactory("get_label"));

		// reg.put("https://w3id.org/d2s/functions#identifyPropFct",
		// 	    new FunctionIdentifyPropFct(???));
		// PropertyFunctionRegistry.set(ARQ.getContext(), reg);

		FusekiServer fs = fsb.build();
		fs.start();
    }

    public static void main(String[] args) throws Exception {
		FusekiEndpoint fusekiEndpoint = new FusekiEndpoint();

		try {
			fusekiEndpoint.run();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
    }
}
