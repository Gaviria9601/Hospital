package co.edu.eam.ingesoft.pa.negocio.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import co.edu.eam.ingesoft.hospital.entidades.Farmaceutico;

@Stateless
@LocalBean
public class FarmaceuticoEJB {
	
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Metodo que sirve para crear un farmaceutico
	 * @param far, farmaceutico a crear
	 */
	public void crearFarmaceutico(Farmaceutico far){
		em.persist(far);
	}
	
	/**
	 * Metodo que sirve para buscar farmaceutico
	 * @param cedula, cedula del farmaceutico a buscar
	 * @return el farmaceutico encontrado
	 */
	public Farmaceutico buscarFarmaceutico(String cedula){
		return em.find(Farmaceutico.class, cedula);
	}
	
	/**
	 * Metodo que sirve para editar el farmaceutico
	 * @param far, farmacia a editar
	 */
	public void editarFarmaceutico(Farmaceutico far){
		em.merge(far);
	}
	/**
	 * Metodo que sirve para eliminar un farmaceutico
	 * @param cedula, cedula del farmaceutico a eliminar
	 */
	
	public void eliminarFarmaceutico(String cedula){
		em.remove(em.find(Farmaceutico.class, cedula));
	}
	
}



