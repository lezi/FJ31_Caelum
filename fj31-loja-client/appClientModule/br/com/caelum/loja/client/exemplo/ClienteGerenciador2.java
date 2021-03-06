package br.com.caelum.loja.client.exemplo;

import java.util.Date;

import javax.naming.InitialContext;

import br.com.caelum.loja.entity.Autor;
import br.com.caelum.loja.entity.Livro;
import br.com.caelum.loja.session.GerenciadorLoja;

public class ClienteGerenciador2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		InitialContext ctx = new InitialContext();
		GerenciadorLoja gerenciador = (GerenciadorLoja) ctx
				.lookup("fj31-loja-ear/GerenciadorLojaBean/remote");

		Autor autor = new Autor();
		autor.setNome("Osvaldo");

		Livro livro = new Livro();
		livro.setNome("Acordando no mundo da Alice");
		livro.setPreco(12.22);
		livro.setDataAlteracao(new Date());
		autor = gerenciador.salva(autor);
		System.out.println("Id do autor: " + autor.getId());

		livro.getAutores().add(autor);

		gerenciador.salva(livro);
	}

}
