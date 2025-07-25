package com.pedrohk;


import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

public class JMSSender {
    public static void main(String[] args) {
        Connection connection = null;
        try {

            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            connection = connectionFactory.createConnection();
            connection.start();


            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);


            Queue queue = session.createQueue("minha.fila");


            MessageProducer producer = session.createProducer(queue);


            TextMessage message = session.createTextMessage("Olá, JMS!");


            producer.send(message);
            System.out.println("Mensagem enviada: " + message.getText());


            session.close();
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}