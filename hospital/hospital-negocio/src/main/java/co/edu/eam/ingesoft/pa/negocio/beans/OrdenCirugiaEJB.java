package co.edu.eam.ingesoft.pa.negocio.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.hospital.entidades.OrdenCirugia;
import co.edu.eam.ingesoft.hospital.entidades.OrdenProcedimiento;

@Stateless
@LocalBean
public class OrdenCirugiaEJB {

	@PersistenceContext
	private EntityManager em;

	/**
	 * 
	 * @param orden
	 */
	public void crearOrden(OrdenCirugia orden) {
		em.persist(orden);
	}

	/**
	 * 
	 * @param cedulaCodigo
	 * @return
	 */
	public List<OrdenCirugia> listarOrdenes(String cedulaCodigo) {
		List<OrdenCirugia> lista = em.createNamedQuery(OrdenCirugia.LISTAR_CIRUGIAS_MEDICO)
				.setParameter(1, cedulaCodigo).getResultList();
		return lista;
	}

}
