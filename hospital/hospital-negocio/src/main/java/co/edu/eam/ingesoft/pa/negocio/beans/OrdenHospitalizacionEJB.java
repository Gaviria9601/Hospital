package co.edu.eam.ingesoft.pa.negocio.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.hospital.entidades.OrdenHospitalizacion;

@LocalBean
@Stateless
public class OrdenHospitalizacionEJB {
	
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * 
	 * @param orden
	 */
	public void crearOrdenHospitalizacion(OrdenHospitalizacion orden){
		em.persist(orden);
	}
	

}
