package org.semanticscience.d2s;

import org.apache.jena.fuseki.embedded.FusekiServer;
import org.apache.jena.riot.RDFDataMgr;

import org.apache.jena.query.DatasetFactory;
import org.apache.jena.query.Dataset;

// import org.apache.jena.atlas.logging.LogCtl;

// https://stackoverflow.com/questions/18262164/how-do-you-use-user-defined-functions-in-fuseki/18329654
public class TranslatorFuseki {

    int port = 3330;
    
    public void run() {
		// LogCtl.setJavaLogging();

		// Create empty dataset
		// Dataset fusekiDataset = DatasetFactory.createGeneral();
		// Dataset fusekiDataset = DatasetFactory.create();
		
		// Import URI or file
		Dataset fusekiDataset = RDFDataMgr.loadDataset("https://raw.githubusercontent.com/MaastrichtU-IDS/d2s-scripts-repository/master/resources/biolink.ttl");
		// Dataset fusekiDataset = RDFDataMgr.loadDataset("/app/init.nt");

		FusekiServer.Builder fsb = FusekiServer.create()
		    .setPort(this.port)
		    .add("/translator", fusekiDataset);

		// final PropertyFunctionRegistry reg = PropertyFunctionRegistry
		//     .chooseRegistry(ARQ.getContext());

		// FunctionRegistry.get().put("https://w3id.org/d2s/functions#identify",
		// 	new FunctionIdentify(???));

		// reg.put("https://w3id.org/d2s/functions#identifyPropFct",
		// 	    new FunctionIdentifyPropFct(???));
		// PropertyFunctionRegistry.set(ARQ.getContext(), reg);

		FusekiServer fs = fsb.build();
		fs.start();
    }

    public static void main(String[] args) throws Exception {
		TranslatorFuseki translatorFuseki = new TranslatorFuseki();

		try {
			translatorFuseki.run();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
    }
}
