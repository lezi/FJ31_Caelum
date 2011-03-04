package br.com.caelum.fj31.jaxb;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

public class TestaGeradorSchema {

	/**
	 * @param args
	 */

	public static void main(String[] args) throws Exception {
		JAXBContext context = JAXBContext.newInstance(Produto.class);
		context.generateSchema(new SchemaOutputResolver() {

			@Override
			public Result createOutput(String namespaceUri,
					String suggestedFileName) throws IOException {
				StreamResult result = new StreamResult(new File("teste.xsd"));
				return result;
			}
		});
	}

}
