package com.threaddynamics.route;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

import com.threaddynamics.exception.CamelCustomException;
import com.threaddynamics.processor.SimpleProcessor;

public class SimpleRouteBuilder extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("file:C:/logs?noop=true")
		.doTry()
		.process(new SimpleProcessor())
		.to("file:D:/logs")
		.doCatch(CamelCustomException.class)
		.process(new Processor() {
			public void process(Exchange exchange) throws Exception {
				System.out.println("handling exception");
			}
		}).log("Received body ${body}");
	}
	

}
