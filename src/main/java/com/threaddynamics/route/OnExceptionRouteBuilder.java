package com.threaddynamics.route;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

import com.threaddynamics.exception.CamelCustomException;
import com.threaddynamics.processor.SimpleProcessor;

public class OnExceptionRouteBuilder extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		onException(CamelCustomException.class)
		.process(new Processor() {
			public void process(Exchange exchange) throws Exception {
				System.out.println("handling exception");
			}
		})
		.log("Received body ${body}").handled(true);
		
		
		from("file:C:/logs?noop=true")
		.process(new SimpleProcessor())
		.to("file:D:/logs");
	}

}
