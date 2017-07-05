package br.com.alura.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.alura.modelo.HoraLancada;
import br.com.alura.modelo.Usuario;

@RequestScoped
public class HoraLancadaDAO {

	private EntityManager em;

	public HoraLancadaDAO() {
	}
	
	@Inject
	public HoraLancadaDAO(EntityManager em) {
		this.em = em;
	}
	
	public void salva(HoraLancada horaLancada){
		em.getTransaction().begin();
		em.persist(horaLancada);
		em.getTransaction().commit();
	}
	
	public List<HoraLancada> lista(){
		TypedQuery<HoraLancada> query = em.createQuery("select h from HoraLancada h", HoraLancada.class);
		return query.getResultList();
	}

	public List<HoraLancada> getRelatorioDeHoras(Usuario usuario) {
		TypedQuery<HoraLancada> query = em.createQuery("select h from HoraLancada h "
				+ "where h.usuario = :pUsuario order by h.data ", HoraLancada.class );
		query.setParameter("pUsuario", usuario);
		return query.getResultList();
	}
	
}
