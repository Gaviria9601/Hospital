package co.edu.eam.ingesoft.pa.negocio.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.hospital.entidades.Examen;
import co.edu.eam.ingesoft.hospital.entidades.Farmacia;
import co.edu.eam.ingesoft.hospital.entidades.Medicamento;
import co.edu.eam.ingesoft.hospital.entidades.Paciente;
import co.edu.eam.ingesoft.pa.negocio.excepciones.ExcepcionNegocio;


@Stateless
@LocalBean
public class MedicamentosEJB {
	
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Metodo que sirve para crear medicamento
	 * @param med, medicamento a registrar
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void crearMedica(Medicamento med){
		Medicamento f =buscarMedicamento(med.getCodigo());
		if(f==null){
				em.persist(med);
		}else {
			throw new ExcepcionNegocio("Ya esta esta nombre de medicamento registrado");
		}
	}
	
	
	
	
	/**
	 * Metodo que sirve para buscar medicamento
	 * @param codigo, codigo del medicamento ha buscar
	 * @return el medicamento encontrado
	 */
	public Medicamento buscarMedicamento(int codigo){
		return em.find(Medicamento.class, codigo);
	}
	/**
	 * Metodo que sirve para editar un farmaceutico
	 * @param med, medicamento a editar
	 */
	
	public void editarMedicamentos(Medicamento med){
		Medicamento far =buscarMedicamento(med.getCodigo());
		if(far!=null){
				em.merge(far);
		}else {
			throw new ExcepcionNegocio("Ya esta esta codigo de medicamento registrado");
		}
	}
	/**
	 * Metodo que sirve para eliminar un farmaceutico
	 * @param codigo, codigo del farmaceutico para eliminar
	 */
	public void eliminarMedicamentos(Medicamento m){
		em.remove(buscarMedicamento(m.getCodigo()));
	}
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Farmacia buscarFarmacia(int codigo) {
    Farmacia far= em.find(Farmacia.class, codigo);
		return far;
	}
	
	public List<Medicamento> listarMedicamentos(){
		return em.createNamedQuery(Medicamento.LISTAR_MEDI).getResultList();
	}
	
}






