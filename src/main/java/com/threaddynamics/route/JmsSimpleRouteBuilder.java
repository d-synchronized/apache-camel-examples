package com.threaddynamics.route;

import org.apache.camel.builder.RouteBuilder;

public class JmsSimpleRouteBuilder extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("file:C:/logs")
		.split()
		.tokenize("\n")
		.to("jms:queue:javainuse");
	}

}
