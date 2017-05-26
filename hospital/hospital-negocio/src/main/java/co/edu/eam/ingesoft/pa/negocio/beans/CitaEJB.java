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
import co.edu.eam.ingesoft.hospital.entidades.Especializacion;
import co.edu.eam.ingesoft.hospital.entidades.Horario;
import co.edu.eam.ingesoft.hospital.entidades.ItemHorarioPK;
import co.edu.eam.ingesoft.hospital.entidades.ItemMedicoPk;
import co.edu.eam.ingesoft.hospital.entidades.Medico;
import co.edu.eam.ingesoft.hospital.entidades.itemHorario;
import co.edu.eam.ingesoft.hospital.entidades.itemMedico;
import co.edu.eam.ingesoft.pa.negocio.excepciones.ExcepcionNegocio;

/**
 * @author Alejandro Ortega
 *
 */
@Stateless
@LocalBean
public class CitaEJB {
	
	@PersistenceContext
	private EntityManager em;
	
	@EJB
	HorarioEJB horarioejb;

	@EJB
	MedicoEJB medicoejb;
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Cita buscarCita(int cod) {
		Cita cita= em.find(Cita.class, cod);
		return cita;
	}
	
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void crearCita(Cita cita) {
	Cita citadef =buscarCita(cita.getCodigo());
	if(citadef==null){
			em.persist(cita);
	}else {
		throw new ExcepcionNegocio("Ya esta este codigo de turno registrado");
	}
	
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void modificarCita(Cita cita){
		Cita citadef =buscarCita(cita.getCodigo());
		if(citadef==null){
				em.merge(cita);
		}else {
			throw new ExcepcionNegocio("Ya esta este codigo de cita registrado");
		}
		
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void eliminarCita(Cita cita){
		em.remove(cita);
	}
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public itemHorario buscarItem(String med,int hor,Date fecha) {
		ItemHorarioPK pk = new ItemHorarioPK(med, hor, fecha);
		itemHorario item = em.find(itemHorario.class, pk);
		return item;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public boolean asignarHorarioMedico(itemHorario item) {
	itemHorario itemdef = buscarItem(item.getMedicoUsuarioCedula().getCedula(),
			item.getHorarioCodigoTurno().getCodigoTurno(),item.getFecha());
	if(itemdef==null){
	Horario hor= horarioejb.buscarHorario(item.getHorarioCodigoTurno().getCodigoTurno());
	Medico med = medicoejb.buscarMedico(item.getMedicoUsuarioCedula().getCedula());
	itemHorario asignacion = new itemHorario(med, hor, item.getFecha(), false);
		
			System.out.println(item.getHorarioCodigoTurno().getCodigoTurno()+"******"+item.getMedicoUsuarioCedula().getCedula()
					+"********"+item.getFecha());
			em.persist(asignacion);
			return true;
	}else {
		throw new ExcepcionNegocio("Este medico ya tiene este horario ocupado en la agenda");
	}
	}
	
	
}
