package com.threaddynamics.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.threaddynamics.exception.CamelCustomException;

public class SimpleProcessor implements Processor{

	public void process(Exchange exchange) throws Exception {
		System.out.println("Throws Exception");
		throw new CamelCustomException("Error occurred while processing the camel route");
	}

}
