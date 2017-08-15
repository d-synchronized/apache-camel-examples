package com.threaddynamics.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.threaddynamics.exception.CamelCustomException;

public class SimpleProcessor implements Processor {

	public void process(Exchange exchange) throws Exception {
		final String messageBody = exchange.getIn().getBody(String.class);
		System.out.println("Message within body => " + messageBody);
		if (messageBody.equalsIgnoreCase("test")) {
			throw new CamelCustomException("Error occurred while processing the camel route");
		}
	}

}
