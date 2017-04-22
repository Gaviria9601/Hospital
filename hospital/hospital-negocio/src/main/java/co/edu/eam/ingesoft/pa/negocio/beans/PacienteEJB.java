package co.edu.eam.ingesoft.pa.negocio.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.hospital.entidades.Afiliacion;
import co.edu.eam.ingesoft.hospital.entidades.Medico;
import co.edu.eam.ingesoft.hospital.entidades.Paciente;
import co.edu.eam.ingesoft.pa.negocio.excepciones.ExcepcionNegocio;




@Stateless
@LocalBean
public class PacienteEJB {

	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Metodo que sirve para crear un paciente
	 * @param pa, paciente crear
	 */

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void crearPaciente(Paciente pa) {
	Paciente p =buscarPaciente(pa.getCedula());
	if(p==null){
			em.persist(pa);
	}else {
		throw new ExcepcionNegocio("Ya esta esta cedula de usuario registrado");
	}
	}
	
	
	/**
	 * Metodo que sirve para buscar un paciente
	 * @param cedula, cedula del paciente a buscar
	 * @return paciente encontrado
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Paciente buscarPaciente(String cedula) {
		Paciente pa = em.find(Paciente.class, cedula);
		return pa;
	}

	/**
	 * Metodo que sirve para editar paciente
	 * @param pac, paciente a editar
	 */
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void modificarPaciente(Paciente pa){
		Paciente p =buscarPaciente(pa.getCedula());
		if(p==null){
				em.merge(pa);
		}else {
			throw new ExcepcionNegocio("Ya esta esta cedula de usuario registrado");
		}
		
	}
	/**
	 * Metodo que sirve para eliminar un paciente
	 * @param cedula, cedula del paciente a eliminar
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void eliminarPaciente(Paciente pa){
		em.remove(pa);
	}
	/**
	 * Metodo que sirve para buscar una afiliacion
	 * @param codigo, codigo de la afiliacion a buscar
	 * @return la afiliación
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Afiliacion buscarAfiliacion(String codigo) {
		Afiliacion pa = em.find(Afiliacion.class, codigo);
		return pa;
	}
	/**
	 * Metodo que sirve para listar las afiliaciones
	 * @return las afiliaciones
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Afiliacion> listarAfiliacion(){
		return em.createNamedQuery(Afiliacion.LISTAR).getResultList();
	}
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Paciente> listarPaciente(){
		return em.createNamedQuery(Paciente.LISTAR).getResultList();
	}
	
}







