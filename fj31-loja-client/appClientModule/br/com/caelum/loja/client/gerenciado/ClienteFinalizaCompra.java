package br.com.caelum.loja.client.gerenciado;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.caelum.loja.entity.Livro;
import br.com.caelum.loja.session.Carrinho;

public class ClienteFinalizaCompra {
	public static void main(String[] args) throws NamingException {
		InitialContext ctx = new InitialContext();

		Carrinho carrinho = (Carrinho) ctx
				.lookup("fj31-loja-ear/CarrinhoBean/remote");

		Livro l1 = new Livro();
		l1.setNome("Fausto com Mensagem");
		l1.setPreco(150);

		carrinho.addLivro(l1);

		Livro l2 = new Livro();
		l2.setNome("Pais e Filhos com Mensagem");
		l2.setPreco(55);

		carrinho.addLivro(l2);

		System.out.println("TOtal: " + carrinho.getTotal());

		carrinho.finalizaCompra();
	}
}
