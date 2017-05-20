package co.edu.eam.ingesoft.pa.negocio.beans;

import java.util.ArrayList;
import java.util.List;

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
	public Habitacion buscarHabitacion(Integer numero) {
		if(numero!=0){
			List<Habitacion> habitacion = em.createNamedQuery(Habitacion.buscarhabitacion).setParameter(1, numero)
					.getResultList();
			if(!habitacion.isEmpty()){
				return habitacion.get(0);
			}else{
				return null;
		}
	}else{
		throw new ExcepcionNegocio("Ingrese numero de habitación a buscar");
	}
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void crearHabitacion(Habitacion habitacion) {
		Habitacion habitaciondef = buscarHabitacion(habitacion.getNumero());
		if (habitaciondef == null) {
			em.persist(habitacion);
		} else {
			throw new ExcepcionNegocio("Ya esta este codigo de habitacion registrado");
		}

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void modificarHabitacion(Habitacion habitacion) {
		Habitacion habitaciondef = buscarHabitacion(habitacion.getNumero());
		if (habitaciondef != null) {
			em.merge(habitacion);
		} else {
			throw new ExcepcionNegocio("Ya esta esta habitacion registrada");
		}

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void eliminarHabitacion(Habitacion habitacion) {
		em.remove(buscarHabitacion(habitacion.getNumero()));
	}
	
	public List<Habitacion> listarHabitaciones(){
		return em.createNamedQuery(Habitacion.listarHabitaciones).getResultList();
	}
}
