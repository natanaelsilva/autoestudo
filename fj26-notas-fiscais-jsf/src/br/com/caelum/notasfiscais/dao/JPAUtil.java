package br.com.caelum.notasfiscais.dao;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.notasfiscais.qualificadores.BaseNotasFiscais;

public class JPAUtil {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("notas");
	//private static EntityManagerFactory emfSeguranca = Persistence.createEntityManagerFactory("seguranca");
	
	@Produces
	@RequestScoped
	@BaseNotasFiscais
	@Default
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
//	@Produces
//	@RequestScoped
//	@BaseSeguranca
//	public EntityManager getEntityManagerSeguranca() {
//		return emfSeguranca.createEntityManager();
//	}
	
	public void close(@Disposes @Any EntityManager em){
		System.out.println("Fechando a entity manager " + em);
		if(em.isOpen())
			em.close();	
	}
}
