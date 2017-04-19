package co.edu.eam.ingesoft.pa.negocio.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.hospital.entidades.Horario;
import co.edu.eam.ingesoft.pa.negocio.excepciones.ExcepcionNegocio;

@LocalBean
@Stateless
public class HorarioEJB {
	
	@PersistenceContext
	private EntityManager em;
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Horario buscarHorario(String cod) {
		Horario horario = em.find(Horario.class, cod);
		return horario;
	}
	
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void crearHorario(Horario horario) {
	Horario horariodef =buscarHorario(horario.getCodigoTurno());
	if(horariodef==null){
			em.persist(horario);
	}else {
		throw new ExcepcionNegocio("Ya esta este codigo de turno registrado");
	}
	
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void modificarHorario(Horario horario){
		Horario horariodef =buscarHorario(horario.getCodigoTurno());
		if(horariodef==null){
				em.merge(horario);
		}else {
			throw new ExcepcionNegocio("Ya esta este codigo de turno registrado");
		}
		
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void eliminarHorario(Horario horario){
		em.remove(horario);
	}

}
