package com.threaddynamics.route;

import org.apache.camel.builder.RouteBuilder;

import com.threaddynamics.processor.SimpleProcessor;

public class SimpleRouteBuilder extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("file:C:/logs?noop=true")
		.process(new SimpleProcessor())
		.to("file:D:/logs");
		
	}
	

}
