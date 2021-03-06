package br.com.caelum.loja.client.gerenciado;

import java.util.List;

import javax.naming.InitialContext;

import br.com.caelum.loja.entity.Livro;
import br.com.caelum.loja.session.GerenciadorLoja;

public class ClienteGerenciadorPesquisaPeloNome {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		InitialContext ctx = new InitialContext();

		GerenciadorLoja gerenciador = (GerenciadorLoja) ctx
				.lookup("fj31-loja-ear/GerenciadorLojaBean/remote");

		List<Livro> livros = gerenciador.buscaLivrosPeloNomeDoAutor("Osvaldo");

		System.out.println("LIVROS ENCONTRADOS");
		for (Livro livro : livros) {
			System.out.println(livro.getNome());
		}

	}

}
