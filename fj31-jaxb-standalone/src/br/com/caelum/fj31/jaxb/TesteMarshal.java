package br.com.caelum.fj31.jaxb;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class TesteMarshal {
	public static void main(String[] args) throws JAXBException, IOException {
		Categoria categoria = new Categoria();
		
		Produto produto = new Produto();
		produto.setDescricao("uma bola quadrada");
		produto.setNome("Bola");
		produto.setPreco(20.25);
		produto.setCategoria(categoria);

		JAXBContext context = JAXBContext.newInstance(Produto.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.marshal(produto, new FileOutputStream("bola.xml"));
	}
}
