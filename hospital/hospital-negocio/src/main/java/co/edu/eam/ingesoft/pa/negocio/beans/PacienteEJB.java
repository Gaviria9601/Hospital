package co.edu.eam.ingesoft.pa.negocio.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.hospital.entidades.Paciente;



@Stateless
@LocalBean
public class PacienteEJB {

	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Metodo que sirve para crear un paciente
	 * @param pa, paciente crear
	 */
	public void crearPaciente(Paciente pa){
		em.persist(pa);
	}
	/**
	 * Metodo que sirve para buscar un paciente
	 * @param cedula, cedula del paciente a buscar
	 * @return paciente encontrado
	 */
	public Paciente buscarPaciente(String cedula){
		return em.find(Paciente.class, cedula);
	}
	/**
	 * Metodo que sirve para editar paciente
	 * @param pac, paciente a editar
	 */
	
	public void editarPaciente(Paciente pac){
		em.merge(pac);
	}
	/**
	 * Metodo que sirve para eliminar un paciente
	 * @param cedula, cedula del paciente a eliminar
	 */
	public void eliminarPaciente(String cedula){
		em.remove(em.find(Paciente.class, cedula));
	}
	
}







