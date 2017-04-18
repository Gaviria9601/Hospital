package co.edu.eam.ingesoft.pa.negocio.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.hospital.entidades.Quirofano;



@Stateless
@LocalBean
public class QuirofanoEJB {
	
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Metodo que sirve para crear un quirofano
	 * @param qui, quirofano a registrar
	 */
	public void crearQuirofano(Quirofano qui){
		em.persist(qui);
	}
	/**
	 * Metodo que sirve para buscar un quirofano
	 * @param codigo, codigo del quirofano a buscar
	 * @return quirofano encontrado
	 */
	public Quirofano buscarQuirofano(String codigo){
		return em.find(Quirofano.class, codigo);
	}
	/**
	 * Metodo que sirve para editar un quirofano
	 * @param qui, quirofano a editar
	 */
	
	public void editarQuirofano(Quirofano qui){
		em.merge(qui);
	}
	/**
	 * Metodo que sirve para elimianr un quirofano
	 * @param codigo, codigo del medicamento a eliminar
	 */
	public void eliminarQuirofano(String codigo){
		em.remove(em.find(Quirofano.class, codigo));
	}
	
}


