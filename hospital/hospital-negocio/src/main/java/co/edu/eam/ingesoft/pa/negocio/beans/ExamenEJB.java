package co.edu.eam.ingesoft.pa.negocio.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.hospital.entidades.Examen;

@LocalBean
@Stateless
public class ExamenEJB {

	@PersistenceContext
	private EntityManager em;
	
	/**
	 * 
	 * @param exa
	 */
	public void crearExamen(Examen exa){
		em.persist(exa);
	}
	
	/**
	 * 
	 * @param codigo
	 * @return
	 */
	public Examen buscarExamen(String codigo){
		return em.find(Examen.class, codigo);
	}
	
	/**
	 * 
	 * @param exa
	 */
	public void editarExamen(Examen exa){
		em.merge(exa);
	}
	
	/**
	 * 
	 * @param codigo
	 */
	public void eliminarExamen(String codigo){
		em.remove(em.find(Examen.class, codigo));
	}
	
}
