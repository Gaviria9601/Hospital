package co.edu.eam.ingesoft.pa.negocio.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.hospital.entidades.Cita;
import co.edu.eam.ingesoft.hospital.entidades.OrdenExamen;
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
	public void crearOrdenHospitalizacion(OrdenHospitalizacion orden) {
		em.persist(orden);
	}

	public void actualizarOrden(OrdenHospitalizacion orden) {
		em.merge(orden);
	}

	/**
	 * 
	 * @return
	 */
	public List<OrdenHospitalizacion> listarOrdenes() {
		List<OrdenHospitalizacion> lista = em.createNamedQuery(OrdenHospitalizacion.LISTAR_ORDEN_HOSPITALIZACION)
				.getResultList();
		return lista;
	}

}
