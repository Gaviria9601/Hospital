package co.edu.eam.ingesoft.pa.negocio.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.hospital.entidades.Hospitalizacion;

@LocalBean
@Stateless
public class HospitalizacionEJB {

	@PersistenceContext
	private EntityManager em;
	
	/**
	 * 
	 * @param hospi
	 */
	public void crearHospitalizacion(Hospitalizacion hospi){
		em.persist(hospi);
	}
	
	/**
	 * 
	 * @param codigo
	 * @return
	 */
	public Hospitalizacion buscarHospitalizacion(String codigo){
		return em.find(Hospitalizacion.class, codigo);
	}
	
	/**
	 * 
	 * @param hospi
	 */
	public void editarHospitalizacion(Hospitalizacion hospi){
		em.merge(hospi);
	}
	
	/**
	 * 
	 * @param codigo
	 */
	public void eliminarHospitalizacion(String codigo){
		em.remove(em.find(Hospitalizacion.class, codigo));
	}
	
}
