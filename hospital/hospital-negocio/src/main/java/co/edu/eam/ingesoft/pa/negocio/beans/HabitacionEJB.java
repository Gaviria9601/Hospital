package co.edu.eam.ingesoft.pa.negocio.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.hospital.entidades.Habitacion;
import co.edu.eam.ingesoft.pa.negocio.excepciones.ExcepcionNegocio;

@LocalBean
@Stateless
public class HabitacionEJB {

	@PersistenceContext
	private EntityManager em;
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Habitacion buscarHabitacion(Integer cod) {
		Habitacion habitacion = em.find(Habitacion.class, cod);
		return habitacion;
	}
	
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void crearHabitacion(Habitacion habitacion) {
	Habitacion habitaciondef =buscarHabitacion(habitacion.getCodigo());
	if(habitaciondef==null){
			em.persist(habitacion);
	}else {
		throw new ExcepcionNegocio("Ya esta este codigo de habitacion registrado");
	}
	
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void modificarHabitacion(Habitacion habitacion){
		Habitacion habitaciondef =buscarHabitacion(habitacion.getCodigo());
		if(habitaciondef==null){
				em.merge(habitacion);
		}else {
			throw new ExcepcionNegocio("Ya esta este codigo de habitacion registrado");
		}
		
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void eliminarHabitacion(Habitacion habitacion){
		em.remove(habitacion);
	}
}
