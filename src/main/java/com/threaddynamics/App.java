package com.threaddynamics;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

import com.threaddynamics.route.JmsSimpleRouteBuilder;

public class App {
	
	public static void main(String[] args) {
		final JmsSimpleRouteBuilder simpleRouteBuilder = new JmsSimpleRouteBuilder();
		final CamelContext camelContext = new DefaultCamelContext();
		final ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
		camelContext.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
		try{
			camelContext.addRoutes(simpleRouteBuilder);
			camelContext.start();
			Thread.sleep(10 * 1000);
			camelContext.stop();
		}catch(final Exception exception){
			exception.printStackTrace();
		}
	}
}
