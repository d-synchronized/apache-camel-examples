package com.threaddynamics;

import org.apache.camel.CamelContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
		final CamelContext camelContext = (CamelContext)applicationContext.getBean("defaultCamelContext");
		try{
			camelContext.start();
			Thread.sleep(10 * 1000);
			camelContext.stop();
		}catch(final Exception exception){
			exception.printStackTrace();
		}finally {
			applicationContext = null;
		}
	}
}
