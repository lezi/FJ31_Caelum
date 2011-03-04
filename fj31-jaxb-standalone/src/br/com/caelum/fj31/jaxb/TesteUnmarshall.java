package br.com.caelum.fj31.jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class TesteUnmarshall {
	public static void main(String[] args) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(Produto.class);
		Unmarshaller unmarsheller = context.createUnmarshaller();

		Produto produto = (Produto) unmarsheller
				.unmarshal(new File("bola.xml"));

		System.out.println(produto.getNome());
	}
}
