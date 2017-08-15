package com.threaddynamics;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

import com.threaddynamics.route.ContentBaseRouteBuilder;

public class ContentBasedRoutingTest {
	
	public static void main(String[] args) {
		final ContentBaseRouteBuilder contentBaseRouteBuilder = new ContentBaseRouteBuilder();
		final CamelContext camelContext = new DefaultCamelContext();
		
		final ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
		camelContext.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
		try {
			camelContext.addRoutes(contentBaseRouteBuilder);
			camelContext.start();
			Thread.sleep(10 * 1000);
			camelContext.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
