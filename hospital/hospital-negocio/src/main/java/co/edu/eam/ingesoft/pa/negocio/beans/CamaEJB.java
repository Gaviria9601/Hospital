package co.edu.eam.ingesoft.pa.negocio.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.hospital.entidades.Cama;
import co.edu.eam.ingesoft.pa.negocio.excepciones.ExcepcionNegocio;

@LocalBean
@Stateless
public class CamaEJB {
	
	@PersistenceContext
	private EntityManager em;
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Cama buscarCama(Integer cod) {
		Cama cama = em.find(Cama.class, cod);
		return cama;
	}
	
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void crearCama(Cama cama) {
	Cama Camadef = buscarCama(cama.getCodigo());
	if(Camadef==null){
			em.persist(cama);
	}else {
		throw new ExcepcionNegocio("Ya esta este codigo de cama registrado");
	}
	
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void modificarCama(Cama cama){
		Cama camadef =buscarCama(cama.getCodigo());
		if(camadef==null){
				em.merge(cama);
		}else {
			throw new ExcepcionNegocio("Ya esta este codigo de cama registrado");
		}
		
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void eliminarCama(Cama cama){
		em.remove(cama);
	}

}
