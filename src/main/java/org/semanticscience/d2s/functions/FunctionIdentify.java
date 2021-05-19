package org.semanticscience.d2s.functions;

import org.apache.jena.sparql.expr.NodeValue;
import org.apache.jena.sparql.function.FunctionBase1;

public class FunctionIdentify extends FunctionBase1
{

    String dataset;
    public FunctionIdentify(String dataset) {
        super();
	    this.dataset = dataset;
    }

    public NodeValue exec(NodeValue nv1)
    {
        if (!nv1.isString())
        {
            return nv1;
        }

        String hey = nv1.toString();
        int mid = hey.length() / 2;
        String nay = hey.substring(0, mid);

        return NodeValue.makeString(this.dataset);
    }
}