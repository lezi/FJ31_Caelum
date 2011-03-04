package br.com.caelum.webservices.publicador;

import javax.xml.ws.Endpoint;

import br.com.caelum.webservices.CalculadorDeParcela;

public class Publicador {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:10000/CalculadorDeParcela",
				new CalculadorDeParcela());

	}

}
