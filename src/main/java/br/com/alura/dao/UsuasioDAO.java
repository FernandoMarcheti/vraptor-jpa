package br.com.alura.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.alura.modelo.Usuario;

@RequestScoped
public class UsuasioDAO {

	private final EntityManager em;

	@Deprecated
	public UsuasioDAO() {
		this(null);
	}

	@Inject
	public UsuasioDAO(EntityManager em){
		this.em = em;
	}
	
	public void adiciona(Usuario usuario){
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
	}
	
	public List<Usuario> lista(){
		TypedQuery<Usuario> query = em.createQuery("select u from Usuario u", Usuario.class);
		return query.getResultList();
	}

	public Usuario obter(String login, String senha) {
		TypedQuery<Usuario> query = em.createQuery("select u from Usuario u "
				+ " where u.login = :pLogin and u.senha = :pSenha ", Usuario.class);
		query.setParameter("pLogin", login);
		query.setParameter("pSenha", senha);
		return query.getSingleResult();
	}
}
