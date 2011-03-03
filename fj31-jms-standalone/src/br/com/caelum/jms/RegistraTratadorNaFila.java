package br.com.caelum.jms;

import java.util.Scanner;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class RegistraTratadorNaFila {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws NamingException, JMSException {
		InitialContext ctx = new InitialContext();

		QueueConnectionFactory queueConnectionFactory = (QueueConnectionFactory) ctx
				.lookup("ConnectionFactory");

		QueueConnection queueConnection = queueConnectionFactory
				.createQueueConnection();

		QueueSession queueSession = queueConnection.createQueueSession(false,
				Session.AUTO_ACKNOWLEDGE);

		Queue queue = (Queue) ctx.lookup("queue/loja-fila");

		QueueReceiver queueReceiver = queueSession.createReceiver(queue);

		queueReceiver.setMessageListener(new TratadorDeMensagem());
		queueConnection.start();

		Scanner teclado = new Scanner(System.in);

		System.out
				.println("Esperando as mensagens na fila JMS. APerte ENTER para parar");

		teclado.nextLine();

		queueConnection.close();

	}

}
