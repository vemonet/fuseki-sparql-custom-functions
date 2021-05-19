package org.semanticscience.d2s.functions;

import org.apache.jena.sparql.function.Function;
import org.apache.jena.sparql.function.FunctionFactory;
import java.util.Map;

public class FunctionIdentifyFactory implements FunctionFactory {

    String dataset;
    
    public FunctionIdentifyFactory(String dataset) {
	    this.dataset = dataset;
    }

    public Function create(String uri) {
	    return new FunctionIdentify(this.dataset);
    }
}




// public class FunctionIdentify extends FunctionBase1
// {
//     public FunctionIdentify() {
//         super() ; 
//     }

//     public NodeValue exec(NodeValue nv1)
//     {
//         if (!nv1.isString())
//         {
//             return nv1;
//         }

//         String hey = nv1.toString();
//         int mid = hey.length() / 2;
//         String nay = hey.substring(0, mid);

//         return NodeValue.makeString(nay);
//     }
// }