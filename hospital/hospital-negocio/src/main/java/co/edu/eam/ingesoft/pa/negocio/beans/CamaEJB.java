package co.edu.eam.ingesoft.pa.negocio.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.edu.eam.ingesoft.hospital.entidades.Cama;
import co.edu.eam.ingesoft.hospital.entidades.Habitacion;
import co.edu.eam.ingesoft.pa.negocio.excepciones.ExcepcionNegocio;

@LocalBean
@Stateless
public class CamaEJB {

	@PersistenceContext
	private EntityManager em;

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Cama buscarCama(int num, int habitacion) {
		if (num != 0) {
			// e.DESCRIPCION,e.HABITACION_CODIGO,e.INSTALACION_CODIGO,e.NUMERO,
			// i.DISPONIBILIDAD,i.OBSERVACIONDISPONIBLE
			List<Cama> cama = em.createNativeQuery(
					"select * from Cama e join HABITACION h on h.CODIGO ="
							+ " e.CODIGO JOIN INSTALACION i ON i.CODIGO = e.CODIGO WHERE e.NUMERO=?1 AND h.NUMERO=?2",
					Cama.class).setParameter(1, num).setParameter(2, habitacion).getResultList();
			if (!cama.isEmpty()) {
				return cama.get(0);
			} else {
				return null;
			}
		} else {
			throw new ExcepcionNegocio("INGRESE NUMERO DE CAMA A BUSCAR");
		}
	}

	/**
	 * 
	 * @param codigo
	 * @return
	 */
	public Cama buscarCamaNormal(int codigo) {
		return em.find(Cama.class, codigo);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void crearCama(Cama cama) {
		Cama Camadef = buscarCama(cama.getNumero(), cama.getHabitacionCodigo().getNumero());
		if (Camadef == null) {
			em.persist(cama);
		} else {
			throw new ExcepcionNegocio("Ya esta este codigo de cama registrado");
		}

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void modificarCama(Cama cama) {
		Cama camadef = buscarCama(cama.getNumero(), cama.getHabitacionCodigo().getNumero());
		if (camadef != null) {
			em.merge(cama);
		} else {
			throw new ExcepcionNegocio("Ya esta este codigo de cama registrado");
		}

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void eliminarCama(Cama cama) {
		em.remove(buscarCama(cama.getNumero(), cama.getHabitacionCodigo().getNumero()));
	}

}
