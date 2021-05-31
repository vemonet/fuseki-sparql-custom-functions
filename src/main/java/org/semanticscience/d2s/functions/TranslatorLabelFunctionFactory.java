package org.semanticscience.d2s.functions;

import org.apache.jena.sparql.function.Function;
import org.apache.jena.sparql.function.FunctionFactory;

public class TranslatorLabelFunctionFactory implements FunctionFactory {

	// Stub variable, not used	
    String dataset;
    
    public TranslatorLabelFunctionFactory(String dataset) {
	    this.dataset = dataset;
    }

    public Function create(String uri) {
	    return new TranslatorLabelFunction(this.dataset);
    }
}
