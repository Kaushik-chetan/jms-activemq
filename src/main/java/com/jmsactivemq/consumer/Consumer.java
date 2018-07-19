package com.jmsactivemq.consumer;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Consumer {

	private static final String queue = "MESSAGE_QUEUE";

	private static final String url = ActiveMQConnection.DEFAULT_BROKER_URL;

	public void recieveMessage() throws JMSException {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);

		Connection connection = connectionFactory.createConnection();

		connection.start();

		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		Destination destination = session.createQueue(queue);

		MessageConsumer consumer = session.createConsumer(destination);
		
		//recieving mesaage from destination queue

		Message message = consumer.receive();

		if (message instanceof TextMessage) {
			TextMessage textMessage = (TextMessage) message;

			System.out.println("Received message '" + textMessage.getText() + "'");
		}

		connection.close();

	}

}
