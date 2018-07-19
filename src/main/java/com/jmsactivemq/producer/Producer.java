package com.jmsactivemq.producer;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Producer {
	
	private static final String queue = "MESSAGE_QUEUE";
	
	private static final String url = ActiveMQConnection.DEFAULT_BROKER_URL;
	
	public void sendMessage() throws JMSException
	{
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
		
		Connection connection = connectionFactory.createConnection();
		
		connection.start();
		
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		Destination destination = session.createQueue(queue);
		
		MessageProducer producer = session.createProducer(destination);
		
		TextMessage message = session.createTextMessage("Hello World");
		
		producer.send(message);
		
		connection.close();
		
		
		
	}

}
