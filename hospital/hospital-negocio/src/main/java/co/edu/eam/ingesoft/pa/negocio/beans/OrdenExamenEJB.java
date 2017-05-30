package co.edu.eam.ingesoft.pa.negocio.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.hospital.entidades.OrdenCirugia;
import co.edu.eam.ingesoft.hospital.entidades.OrdenExamen;
import co.edu.eam.ingesoft.hospital.entidades.ResultadoExamen;

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
	
	/**
	 * 
	 * @param orden
	 */
	public void actualizarOrden(OrdenExamen orden){
		em.merge(orden);
	}
	
	/**
	 * 
	 * @param cedulaCodigo
	 * @return
	 */
	public List<OrdenExamen> listarOrdenes() {
		List<OrdenExamen> lista = em.createNamedQuery(OrdenExamen.LISTAR_ORDEN_EXAMEN).getResultList();
		return lista;
	}
	
	/**
	 * 
	 * @param res
	 */
	public void agregarResultadoExamen(ResultadoExamen res){
		em.persist(res);
	}
	
	
}
