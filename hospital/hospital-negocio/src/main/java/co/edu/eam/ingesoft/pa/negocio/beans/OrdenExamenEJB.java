package co.edu.eam.ingesoft.pa.negocio.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.hospital.entidades.OrdenExamen;

@Stateless
@LocalBean
public class OrdenExamenEJB {

	@PersistenceContext
	private EntityManager em;
	
	/**
	 * 
	 * @param orden
	 */
	public void crearOrdenExamen(OrdenExamen orden){
		em.persist(orden);
	}
	
}
