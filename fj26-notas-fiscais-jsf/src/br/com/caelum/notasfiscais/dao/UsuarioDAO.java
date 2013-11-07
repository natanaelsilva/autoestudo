package br.com.caelum.notasfiscais.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.notasfiscais.modelo.Usuario;
import br.com.caelum.notasfiscais.qualificadores.BaseNotasFiscais;

public class UsuarioDAO {

	private EntityManager em;
	
	@Inject
	public UsuarioDAO(@BaseNotasFiscais EntityManager em) {
		this.em = em;
	}
	
	public boolean existe(Usuario usuario) {
		//em.getTransaction().begin();
		
		Query query = em.createQuery("from Usuario u where u.login = :pLogin and u.senha = :pSenha");
		query.setParameter("pLogin", usuario.getLogin());
		query.setParameter("pSenha", usuario.getSenha());

		boolean encontrado = !query.getResultList().isEmpty();
		//em.getTransaction().commit();
		//em.close();

		return encontrado;
	}
}