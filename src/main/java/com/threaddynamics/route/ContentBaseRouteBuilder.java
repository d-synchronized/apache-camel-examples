package com.threaddynamics.route;

import org.apache.camel.builder.RouteBuilder;

public class ContentBaseRouteBuilder extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("file:C:/logs?noop=true")
		.split()
		.tokenize("\n")
		.to("direct:splittedString");
		
		from("direct:splittedString")
		.choice()
		.when(body().contains("demo1")).to("jms:queue:demoQueue1")
		.when(body().contains("demo2")).to("jms:queue:demoQueue2")
		.when(body().contains("demo3")).to("jms:queue:demoQueue3")
		.otherwise()
		.to("jms:queue:exceptionQueue");
		
	}

}
