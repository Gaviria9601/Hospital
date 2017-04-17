package co.edu.eam.ingesoft.pa.negocio.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.hospital.entidades.Patologia;

@LocalBean
@Stateless
public class PatologiaEJB {
	
	
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * 
	 * @param pato
	 */
	public void crearPatologia(Patologia pato){
		em.persist(pato);
	}
	
	/**
	 * 
	 * @param codigo
	 * @return
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Patologia buscarPatologia(String codigo){
		return em.find(Patologia.class, codigo);
	}
	
	/**
	 * 
	 * @param pato
	 */
	public void editarPatologia(Patologia pato){
		em.merge(pato);
	}
	
	/**
	 * 
	 * @param codigo
	 */
	public void eliminarPatologia(String codigo){
		em.remove(em.find(Patologia.class, codigo));
	}
	
	

}
