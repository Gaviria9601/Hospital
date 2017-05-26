package co.edu.eam.ingesoft.pa.negocio.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.hospital.entidades.Examen;
import co.edu.eam.ingesoft.hospital.entidades.Farmaceutico;
import co.edu.eam.ingesoft.hospital.entidades.Medicamento;
import co.edu.eam.ingesoft.hospital.entidades.Quirofano;
import co.edu.eam.ingesoft.pa.negocio.excepciones.ExcepcionNegocio;



@Stateless
@LocalBean
public class QuirofanoEJB {
	
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Metodo que sirve para crear un quirofano
	 * @param qui, quirofano a registrar
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void crear(Quirofano far) {
		
			em.persist(far);
	
	}
	/**
	 * Metodo que sirve para buscar un quirofano
	 * @param codigo, codigo del quirofano a buscar
	 * @return quirofano encontrado
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Quirofano buscar(int codigo) {
		Quirofano far= em.find(Quirofano.class, codigo);
		return far;
	}
	/**
	 * Metodo que sirve para editar un quirofano
	 * @param qui, quirofano a editar
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void modificar( Quirofano pa){
	
				em.merge(pa);
		
		
	}
	/**
	 * Metodo que sirve para elimianr un quirofano
	 * @param codigo, codigo del medicamento a eliminar
	 */
	public void eliminar(int codigo){
		em.remove(em.find(Quirofano.class, codigo));
	}
	
	public List<Quirofano> listarQuirofanos(){
		return (List<Quirofano>)em.createNamedQuery(Quirofano.LISTAR_QUIRO).getResultList();
	}
}


