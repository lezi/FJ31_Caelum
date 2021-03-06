package br.com.caelum.jms;

import java.util.Scanner;

import javax.jms.JMSException;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.Session;
import javax.jms.TopicSubscriber;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class RegistraTratadorNoTopico {
	public static void main(String[] args) throws NamingException, JMSException {
		InitialContext ctx = new InitialContext();

		TopicConnectionFactory topicConnectionFactory = (TopicConnectionFactory) ctx
				.lookup("ConnectionFactory");

		TopicConnection topicConnection = topicConnectionFactory
				.createTopicConnection();

		TopicSession topicSession = topicConnection.createTopicSession(false,
				Session.AUTO_ACKNOWLEDGE);

		Topic topic = (Topic) ctx.lookup("topic/loja-topico");

		TopicSubscriber topicSubscriber = topicSession.createSubscriber(topic);

		topicSubscriber.setMessageListener(new TratadorDeMensagem());
		topicConnection.start();

		Scanner teclado = new Scanner(System.in);

		System.out
				.println("Esperando as mensagens na fila JMS. APerte ENTER para parar");

		teclado.nextLine();

		topicConnection.close();

	}
}
