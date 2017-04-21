package co.edu.eam.ingesoft.pa.negocio.beans;

import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.hospital.entidades.Medico;
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
	
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void crearMedico(Medico medico) {
	Medico Medicodef =buscarMedico(medico.getCedula());
	if(Medicodef==null){
			em.persist(medico);
	}else {
		throw new ExcepcionNegocio("Ya esta esta cedula de usuario registrado");
	}
	
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void modificarMedico(Medico medico){
		Medico Medicodef =buscarMedico(medico.getCedula());
		if(Medicodef==null){
				em.merge(medico);
		}else {
			throw new ExcepcionNegocio("Ya esta esta cedula de usuario registrado");
		}
		
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void eliminarMedico(Medico medico){
		em.remove(medico);
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

}
