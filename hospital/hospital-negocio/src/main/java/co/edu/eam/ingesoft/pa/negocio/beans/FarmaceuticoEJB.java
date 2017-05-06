package co.edu.eam.ingesoft.pa.negocio.beans;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import co.edu.eam.ingesoft.hospital.entidades.Farmaceutico;
import co.edu.eam.ingesoft.hospital.entidades.Farmacia;
import co.edu.eam.ingesoft.pa.negocio.excepciones.ExcepcionNegocio;

@Stateless
@LocalBean
public class FarmaceuticoEJB {
	
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Metodo que sirve para crear un farmaceutico
	 * @param far, farmaceutico a crear
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void crearFarmaceutico (Farmaceutico far) {
		Farmaceutico f =buscarFarmaceutico(far.getCedula());
	if(f==null){
			em.persist(far);
	}else {
		throw new ExcepcionNegocio("Ya esta esta cedula de usuario registrado");
	}
	}
	
	/**
	 * Metodo que sirve para buscar farmaceutico
	 * @param cedula, cedula del farmaceutico a buscar
	 * @return el farmaceutico encontrado
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Farmaceutico buscarFarmaceutico(String cedula) {
    Farmaceutico far= em.find(Farmaceutico.class, cedula);
		return far;
	}
	
	/**
	 * Metodo que sirve para editar el farmaceutico
	 * @param far, farmacia a editar
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void modificarFarmaceutico(Farmaceutico pa){
		Farmaceutico far =buscarFarmaceutico(pa.getCedula());
		if(far!=null){
				em.merge(pa);
		}else {
			throw new ExcepcionNegocio("Ya esta esta cedula de usuario registrado");
		}
		
	}
	/**
	 * Metodo que sirve para eliminar un farmaceutico
	 * @param cedula, cedula del farmaceutico a eliminar
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void eliminarFarmaceutico(Farmaceutico pa){
		em.remove(buscarFarmaceutico(pa.getCedula()));
	}
	
	/**
	 * 
	 * @return
	 */
	
	public Date generarFechaActual() {
		Calendar fechaHora = Calendar.getInstance();
		Date fecha = fechaHora.getTime();
		return fecha;
	}
	/**
	 * 
	 * @param cedula
	 * @return
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Farmacia buscarFarmacia(int codigo) {
    Farmacia far= em.find(Farmacia.class, codigo);
		return far;
	}
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Farmacia> listarAFarmaceutico(){
		return em.createNamedQuery(Farmacia.LISTAR).getResultList();
	}
	
}





