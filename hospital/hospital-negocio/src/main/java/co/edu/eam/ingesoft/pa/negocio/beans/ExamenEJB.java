package co.edu.eam.ingesoft.pa.negocio.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.hospital.entidades.Examen;
import co.edu.eam.ingesoft.hospital.entidades.TipoExamen;

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
	 * @param codigo
	 * @return
	 */
	public TipoExamen buscarTipoExamen(Integer codigo){
		return em.find(TipoExamen.class, codigo);
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
	public void eliminarExamen(Integer codigo){
		em.remove(em.find(Examen.class, codigo));
	}
	
	/**
	 * Lista los examenes
	 * @return
	 */
	public List<Examen> listarExamenes(){
		return (List<Examen>) em.createNamedQuery(Examen.LISTAR_EXAMEN).getResultList();
	}
	
	/**
	 * Lista los tipo de examenes
	 * @return
	 */
	public List<TipoExamen> listarTipoExamenes(){
		return (List<TipoExamen>) em.createNamedQuery(TipoExamen.LISTAR_TIPO_EXAMEN).getResultList();
	}
	
}
