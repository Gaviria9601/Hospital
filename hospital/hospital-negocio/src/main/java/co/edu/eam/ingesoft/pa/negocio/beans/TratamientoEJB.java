package co.edu.eam.ingesoft.pa.negocio.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.hospital.entidades.ItemSintoma;
import co.edu.eam.ingesoft.hospital.entidades.ItemTratamiento;
import co.edu.eam.ingesoft.hospital.entidades.Tratamiento;
import co.edu.eam.ingesoft.hospital.entidades.itemSintomaPK;
import co.edu.eam.ingesoft.hospital.entidades.itemTratamientoPK;

@LocalBean
@Stateless
public class TratamientoEJB {

	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Crear el puto tratamiento
	 * @param trata
	 */
	public void crearTratamiento(Tratamiento trata){
		em.persist(trata);
	}
	
	/**
	 * Busca el puto tratamiento , perra
	 * @param itemTrata
	 */
	public void crearItemTratamiento(ItemTratamiento itemTrata){
		em.persist(itemTrata);
	}
	
	/**
	 * 
	 * @param codigo
	 * @return
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Tratamiento buscarTratamiento(int codigo){
		return em.find(Tratamiento.class,codigo);
	}
	
	/**
	 * 
	 * @param codigoTratamiento
	 * @param codigoPatologia
	 * @return
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ItemTratamiento buscarItemTratamiento(Integer codigoTratamiento,Integer codigoPatologia){
		itemTratamientoPK itemPK = new itemTratamientoPK(codigoPatologia, codigoTratamiento);
		return em.find(ItemTratamiento.class, itemPK);
	}
	
	/**
	 * 
	 * @param trata
	 */
	public void editar(Tratamiento trata){
		em.merge(trata);
	}
	
	/**
	 * 
	 * @param itemTrata
	 */
	public void editarItemTratamiento(ItemTratamiento itemTrata){
		em.merge(itemTrata);
	}
	
	/**
	 * 
	 * @param codigo
	 */
	public void eliminar(String codigo){
		em.remove(em.find(Tratamiento.class, codigo));
	}
	
	/**
	 * 
	 * @param codigoTratamiento
	 * @param codigoPatologia
	 */
	public void eliminar(Integer codigoTratamiento,Integer codigoPatologia){
		itemTratamientoPK itemPK = new itemTratamientoPK(codigoPatologia, codigoTratamiento);
		em.remove(em.find(ItemTratamiento.class, itemPK));
	}
	
	/**
	 * 
	 * @param codigoTratamiento
	 * @param codigoPatologia
	 */
	public void eliminarItemTratamiento(int codigoTratamiento,int codigoPatologia){
		itemTratamientoPK itemPK = new itemTratamientoPK(codigoPatologia,codigoTratamiento);
		em.remove(em.find(ItemTratamiento.class, itemPK));
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Tratamiento> listarTratamientos(){
		return (List<Tratamiento>) em.createNamedQuery(Tratamiento.LISTAR_TRATAMIENTO).getResultList();
	}
	
	/**
	 * 
	 * @param codigo
	 * @return
	 */
	public List<Tratamiento> listarTratamietoPatologia(int codigo){
		return (List<Tratamiento>) em.createNativeQuery("select tra.* from Tratamiento tra "
				+ " join Item_Tratamiento it on tra.codigo = it.tratamiento_Codigo join Patologia pa on pa.codigo = " +
				" it.patologia_Codigo where it.patologia_Codigo = ?1",Tratamiento.class).setParameter(1, codigo).getResultList();
	}
	
}
