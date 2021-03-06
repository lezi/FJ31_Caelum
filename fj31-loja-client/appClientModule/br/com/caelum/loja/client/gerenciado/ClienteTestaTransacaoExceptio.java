package br.com.caelum.loja.client.gerenciado;

import javax.naming.InitialContext;

import br.com.caelum.loja.entity.Livro;
import br.com.caelum.loja.session.GerenciadorLoja;

public class ClienteTestaTransacaoExceptio {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		InitialContext ctx = new InitialContext();

		GerenciadorLoja gerenciador = (GerenciadorLoja) ctx
				.lookup("fj31-loja-ear/GerenciadorLojaBean/remote");

		Livro livro = new Livro();
		livro.setNome("Pais e Filhos com exception 2");
		livro.setPreco(1.99);

		gerenciador.salva(livro);
		System.out.println("Salvei do gerenciador!!");
	}

}
