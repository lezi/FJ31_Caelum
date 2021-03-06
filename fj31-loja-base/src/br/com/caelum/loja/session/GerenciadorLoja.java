package br.com.caelum.loja.session;

import java.util.List;

import br.com.caelum.loja.entity.Autor;
import br.com.caelum.loja.entity.Livro;

public interface GerenciadorLoja {
	void salva(Livro livro);

	Livro procura(String isbn);

	Autor salva(Autor autor);

	List<Livro> buscaLivrosPeloNomeDoAutor(String nome);

}
