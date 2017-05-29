/**
 * 
 */
package co.edu.eam.ingesoft.pa.negocio.beans;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.hospital.entidades.Cita;
import co.edu.eam.ingesoft.hospital.entidades.DiagnosticoCita;
import co.edu.eam.ingesoft.hospital.entidades.DiagnosticoCitaPK;
import co.edu.eam.ingesoft.hospital.entidades.Patologia;
import co.edu.eam.ingesoft.hospital.entidades.itemHorario;
import co.edu.eam.ingesoft.pa.negocio.excepciones.ExcepcionNegocio;

/**
 * @author Alejandro Ortega
 *
 */
@LocalBean
@Stateless
public class DiagnosticoEJB {

	@PersistenceContext
	private EntityManager em;

	@EJB
	private CitaEJB citaejb;

	@EJB
	private PatologiaEJB patoejb;

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public DiagnosticoCita buscarDiagnostico(int citacodigo, int patologiacodigo) {
		DiagnosticoCitaPK pk = new DiagnosticoCitaPK(citacodigo, patologiacodigo);
		DiagnosticoCita item = em.find(DiagnosticoCita.class, pk);
		return item;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void asignarDiagnostico(int codigocita, int codigoPatologia, String descripcion) {
		DiagnosticoCita itemdef = buscarDiagnostico(codigocita, codigoPatologia);
		Cita cita = em.find(Cita.class, codigocita);
		Patologia pat = em.find(Patologia.class, codigoPatologia);
		DiagnosticoCita diagnos = new DiagnosticoCita(cita, pat);
		if (itemdef == null) {
			//itemHorario item = citaejb.buscarItem(cita.getHorario().getMedicoUsuarioCedula().getCedula(),
			//		cita.getHorario().getHorarioCodigoTurno().getCodigoTurno(), cita.getHorario().getFecha());
			//item.setEstado(true);
			cita.setObservacion(descripcion);
			em.merge(cita);
			em.persist(diagnos);
		} else {
			throw new ExcepcionNegocio("Esta cita ya tiene esta patologia");
		}
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void eliminarDiagnos(DiagnosticoCita diagnostico) {
		em.remove(diagnostico);
	}

}
