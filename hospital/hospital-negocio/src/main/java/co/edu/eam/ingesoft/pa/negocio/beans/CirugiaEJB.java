package co.edu.eam.ingesoft.pa.negocio.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.hospital.entidades.Cirugia;

@Stateless
@LocalBean
public class CirugiaEJB {

	@PersistenceContext
	private EntityManager em;
	
	/**
	 * 
	 * @param ciru
	 */
	public void crearCirugia(Cirugia ciru){
		em.persist(ciru);
	}
	
	/**
	 * 
	 * @param codigo
	 * @return
	 */
	public Cirugia buscarCirugia(String codigo){
		return em.find(Cirugia.class, codigo);
	}
	
	/**
	 * 
	 */
	public void editarCirugia(Cirugia ciru){
		em.merge(ciru);
	}
	
	/**
	 * 
	 * @param codigo
	 */
	public void eliminarCirugia(String codigo){
		em.remove(em.find(Cirugia.class, codigo));
	}
	
}
