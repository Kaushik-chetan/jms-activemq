package com.jmsactivemq.main;

import javax.jms.JMSException;

import com.jmsactivemq.consumer.Consumer;
import com.jmsactivemq.producer.Producer;

public class AppMain {
	
	public static void main(String[] args) throws JMSException {
		
		Producer messageProducer = new Producer();
		
		Consumer messageConsumer = new Consumer();
		
		messageProducer.sendMessage();
		
		messageConsumer.recieveMessage();
		
		
		
	}

}
