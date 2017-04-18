package co.edu.eam.ingesoft.pa.negocio.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.hospital.entidades.Medicamento;


@Stateless
@LocalBean
public class MedicamentosEJB {
	
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Metodo que sirve para crear medicamento
	 * @param med, medicamento a registrar
	 */
	public void crearMedicamento(Medicamento med){
		em.persist(med);
	}
	
	/**
	 * Metodo que sirve para buscar medicamento
	 * @param codigo, codigo del medicamento ha buscar
	 * @return el medicamento encontrado
	 */
	public Medicamento buscarMedicamento(String codigo){
		return em.find(Medicamento.class, codigo);
	}
	/**
	 * Metodo que sirve para editar un farmaceutico
	 * @param med, medicamento a editar
	 */
	
	public void editarMedicamentos(Medicamento med){
		em.merge(med);
	}
	/**
	 * Metodo que sirve para eliminar un farmaceutico
	 * @param codigo, codigo del farmaceutico para eliminar
	 */
	public void eliminarMedicamentos(String codigo){
		em.remove(em.find(Medicamento.class, codigo));
	}
	
}






