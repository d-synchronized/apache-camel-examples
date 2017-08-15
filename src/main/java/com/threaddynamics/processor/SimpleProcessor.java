package com.threaddynamics.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class SimpleProcessor implements Processor{

	public void process(Exchange exchange) throws Exception {
		System.out.println("This would be my simple route processor");
	}

}
