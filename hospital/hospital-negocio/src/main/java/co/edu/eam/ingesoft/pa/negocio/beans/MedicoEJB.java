package co.edu.eam.ingesoft.pa.negocio.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.hospital.entidades.Cama;
import co.edu.eam.ingesoft.hospital.entidades.Especializacion;
import co.edu.eam.ingesoft.hospital.entidades.ItemMedicoPk;
import co.edu.eam.ingesoft.hospital.entidades.Medico;
import co.edu.eam.ingesoft.hospital.entidades.itemMedico;
import co.edu.eam.ingesoft.pa.negocio.excepciones.ExcepcionNegocio;

@LocalBean
@Stateless
public class MedicoEJB {

	@PersistenceContext
	private EntityManager em;

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Medico buscarMedico(String cod) {
		Medico medico = em.find(Medico.class, cod);
		return medico;
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Especializacion buscarEspecializacion(Integer cod) {
		Especializacion esp = em.find(Especializacion.class, cod);
		return esp;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void crearMedico(Medico medico) {
		Medico Medicodef = buscarMedico(medico.getCedula());
		if (Medicodef == null) {
			em.persist(medico);
		} else {
			throw new ExcepcionNegocio("Ya esta esta cedula de usuario registrado");
		}

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void modificarMedico(Medico medico) {
		Medico Medicodef = buscarMedico(medico.getCedula());
		if (Medicodef != null) {
			em.merge(medico);
		} else {
			throw new ExcepcionNegocio("ERROR");
		}

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void eliminarMedico(Medico medico) {
		em.remove(buscarMedico(medico.getCedula()));
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public String generarCarnet() {
		String total = "";
		for (int i = 0; i < 8; i++) {
			int valorx = (int) ((Math.random() * 9) + 1);
			total = total + valorx;
		}
		return total;
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ArrayList<Especializacion> listarEspecializaciones() {
		ArrayList<Especializacion> list;
		list = (ArrayList<Especializacion>) em.createNamedQuery(Especializacion.especializaciones).getResultList();
		return list;
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ArrayList<Medico> listarMedicos() {
		ArrayList<Medico> list;
		list = (ArrayList<Medico>) em.createNamedQuery(Medico.medicos).getResultList();
		return list;
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Medico> listarMedicosxEspecializacion(int codigoEsp) {
		List<Medico> lista = em
				.createNativeQuery(
						"select * from MEDICO m join ITEM_MEDICO i on i.MEDICO_CEDULA = m.CEDULA join USUARIO u on u.CEDULA = m.CEDULA "
								+ "where i.ESPECIALIZACION_CODIGO =?1 ",
						Medico.class)
				.setParameter(1, codigoEsp).getResultList();
		return lista;
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public itemMedico buscarItem(String med, int esp) {
		ItemMedicoPk pk = new ItemMedicoPk(esp, med);
		itemMedico item = em.find(itemMedico.class, pk);
		return item;
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Especializacion buscarEspeclializacion(int cod) {
		Especializacion esp = em.find(Especializacion.class, cod);
		return esp;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void asignarEspecializacion(itemMedico item) {
		itemMedico itemdef = buscarItem(item.getMedicoUsuarioCedula().getCedula(),
				item.getEspecializacionCodigo().getCodigo());
		Especializacion esp = buscarEspecializacion(item.getEspecializacionCodigo().getCodigo());
		Medico med = buscarMedico(item.getMedicoUsuarioCedula().getCedula());
		itemMedico asignacion = new itemMedico(esp, med);
		if (itemdef == null) {
			System.out.println(
					item.getEspecializacionCodigo().getCodigo() + "******" + item.getMedicoUsuarioCedula().getCedula());
			em.persist(asignacion);
		} else {
			throw new ExcepcionNegocio("Este medico ya tiene asignada esta especializacion");
		}
	}

	/**
	 * 
	 * @param cedula
	 * @return
	 */
	public List<itemMedico> buscarespMedico(String cedula) {
		return (List<itemMedico>) em.createNamedQuery(itemMedico.LISTAR_MEDICO_ESP).setParameter(1, cedula)
				.getResultList();
	}

}
