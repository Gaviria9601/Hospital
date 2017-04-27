package co.edu.eam.ingesoft.pa.negocio.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.hospital.entidades.ItemSintoma;
import co.edu.eam.ingesoft.hospital.entidades.Sintoma;
import co.edu.eam.ingesoft.hospital.entidades.itemSintomaPK;

@LocalBean
@Stateless
public class SintomaEJB {

	@PersistenceContext
	private EntityManager em;
	
	
	/**
	 * Crea el Sintoma
	 * @param sinto
	 */
	public void crearSintoma(Sintoma sinto){
		em.persist(sinto);
	}
	
	/**
	 * 
	 * @param itemSintoma
	 */
	public void crearItemSintoma(ItemSintoma itemSintoma){
		em.persist(itemSintoma);
	}
	
	/**
	 * 
	 * @param codigo
	 * @return
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Sintoma buscarSintoma(String codigo){
		return em.find(Sintoma.class, codigo);
	}
	
	/**
	 * 
	 * @param codigoSintoma
	 * @param codigoPatologia
	 * @return
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ItemSintoma buscarItemSintoma(Integer codigoSintoma,Integer codigoPatologia){
		itemSintomaPK itemPK = new itemSintomaPK(codigoSintoma, codigoPatologia);
		return em.find(ItemSintoma.class, itemPK);
	}
	
	/**
	 * 
	 * @param sinto
	 */
	public void editarSintoma(Sintoma sinto){
		em.merge(sinto);
	}
	
	/**
	 * 
	 * @param itemSinto
	 */
	public void editarItemSintoma(ItemSintoma itemSinto){
		em.merge(itemSinto);
	}
	
	
	/**
	 * 
	 * @param codigo
	 */
	public void eliminarSintoma(String codigo){
		em.remove(em.find(Sintoma.class, codigo));
	}
	
	/**
	 * 
	 * @param codigoSintoma
	 * @param codigoPatologia
	 */
	public void eliminarItemSintoma(Integer codigoSintoma,Integer codigoPatologia){
		itemSintomaPK itemPK = new itemSintomaPK(codigoSintoma, codigoPatologia);
		em.remove(em.find(ItemSintoma.class, itemPK));
	}
	
}
