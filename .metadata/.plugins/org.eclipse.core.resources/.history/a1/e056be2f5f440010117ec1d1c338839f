package br.com.caelum.loja.session;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.caelum.loja.entity.Autor;
import br.com.caelum.loja.entity.Livro;

@Stateless
@Remote(GerenciadorLoja.class)
public class GerenciadorLojaBean implements GerenciadorLoja {

	private Map<String, Livro> repositorio;

	@PersistenceContext
	private EntityManager manager;

	public GerenciadorLojaBean() {
		this.repositorio = new HashMap<String, Livro>();

		Livro l1 = new Livro();
		l1.setNome("Pais e Filhos");
		l1.setPreco(200.00);

		Livro l2 = new Livro();
		l2.setNome("Noites Brancas");
		l2.setPreco(200.00);

		this.repositorio.put("1111", l1);
		this.repositorio.put("2222", l2);
	}

	@Override
	public Livro procura(String isbn) {
		return this.repositorio.get(isbn);
	}

	public void salva(Livro livro) {
		this.manager.persist(livro);
		System.out.println("Livro salvo. ID: " + livro.getId());
	}

	@Override
	public Autor salva(Autor autor) {
		this.manager.persist(autor);
		System.out.println("Salvao novo autor ID: " + autor.getId());
		return autor;

	}

	@Override
	public List<Livro> buscaLivrosPeloNomeDoAutor(String nome) {
		System.out.println("Buscando livro pelo nome: " + nome);
		String jpql = "select livro from Livro as livro join fetch "
				+ "livro.autores as autor where autor.nome like :busca";

		Query query = this.manager.createQuery(jpql);
		query.setParameter("busca", "%" + nome + "%");

		return query.getResultList();
	}

}
