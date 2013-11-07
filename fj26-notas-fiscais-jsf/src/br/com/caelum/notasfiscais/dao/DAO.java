package br.com.caelum.notasfiscais.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;


public class DAO<T> {
	private final Class<T> classe;

	public DAO(Class<T> classe) {
		this.classe = classe;
	}

	public void adiciona(T t) {
		//consegue a entity manager
		EntityManager em = new JPAUtil().getEntityManager();
		//abre transacao
		em.getTransaction().begin();

		//persiste o objeto
		em.persist(t);

		//commita a transacao
		em.getTransaction().commit();

		//fecha a entity manager
		em.close();
	}

	public void remove(T t) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		em.remove(em.merge(t));

		em.getTransaction().commit();
		em.close();
	}

	public void atualiza(T t) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		em.merge(t);

		em.getTransaction().commit();
		em.close();
	}

	public List<T> listaTodos() {
		EntityManager em = new JPAUtil().getEntityManager();
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));

		List<T> lista = em.createQuery(query).getResultList();

		em.close();
		return lista;
	}

	public T buscaPorId(Long id) {
		EntityManager em = new JPAUtil().getEntityManager();
		return em.find(classe, id);
	}
	
	public int quantidadeRegistros() {
		EntityManager em = new JPAUtil().getEntityManager();
		String jpql = "select count(*) from NotaFiscal";
		Long singleResult = (Long) em.createQuery(jpql).getSingleResult();
		
		return singleResult.intValue(); 
	}
	
	@SuppressWarnings("unchecked")
	public List<T> listaTodosPaginado(int inicio, int quantidade) {
		EntityManager em = new JPAUtil().getEntityManager();
		
		Query query = em.createQuery("from " + classe.getName());
		query.setFirstResult(inicio);
		query.setMaxResults(quantidade);
		
		return query.getResultList();
	}
}
