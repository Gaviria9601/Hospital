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
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void crearPatologia(Patologia pato){
		em.persist(pato);
	}
	
	/**
	 * 
	 * @param codigo
	 * @return
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Patologia buscarPatologia(int codigo){
		return em.find(Patologia.class, codigo);
	}
	
	/**
	 * 
	 * @param nombre
	 * @return
	 */
	public Patologia buscarPatologiaNom(String nombre){
		return (Patologia)em.createNamedQuery(Patologia.Buscar_PATOLOGIA).setParameter(1, nombre).getSingleResult();
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
