package br.com.alura.produces;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class EntityManagerProducer {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
	
	@Produces @RequestScoped
	public EntityManager getEntityManager(){
		return emf.createEntityManager();
	}
	
	public void close(@Disposes EntityManager em){
		em.close();
	}
}
