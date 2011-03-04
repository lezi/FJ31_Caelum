package br.com.caelum.loja.session;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.caelum.loja.entity.Livro;
import br.com.caelum.loja.ws.ConsultaLivros;

@WebService
@Stateless
@Remote(ConsultaLivros.class)
public class ConsultaDeLivrosBean implements ConsultaLivros {

	@PersistenceContext
	private EntityManager manager;

	@Override
	@WebMethod
	public List<Livro> buscaLivro(String nome) {
		Query query = manager
				.createQuery("select l Livro as l where l.nome like :nome");
		query.setParameter("nome", nome);

		return query.getResultList();
	}

}
