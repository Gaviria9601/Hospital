package co.edu.eam.ingesoft.pa.negocio.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.hospital.entidades.Causa;
import co.edu.eam.ingesoft.hospital.entidades.ItemCausa;
import co.edu.eam.ingesoft.hospital.entidades.ItemSintoma;
import co.edu.eam.ingesoft.hospital.entidades.Patologia;
import co.edu.eam.ingesoft.hospital.entidades.Sintoma;
import co.edu.eam.ingesoft.hospital.entidades.itemCausaPK;
import co.edu.eam.ingesoft.hospital.entidades.itemSintomaPK;

@LocalBean
@Stateless
public class CausaEJB {
	
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * 
	 * @param cau
	 */
	public void crearCausa(Causa cau){
		em.persist(cau);
	}
	
	/**
	 * 
	 * @param codigo
	 * @return
	 */
	public Causa buscarCausa(int codigo){
		return em.find(Causa.class, codigo);
	}
	
	/**
	 * 
	 * @param itemCausa
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void crearItemCausa(ItemCausa itemCausa){
		em.persist(itemCausa);
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Causa> listarCausas(){
		return (List<Causa>) em.createNamedQuery(Causa.LISTAR_CAUSAS).getResultList();
	}
	
	/**
	 * 
	 * @param codigo
	 * @return
	 */
	public List<Causa> listarCausasPatologia(int codigo){
		return (List<Causa>) em.createNativeQuery("select cau.* from Causa cau "
				+ " join Item_Causa ic on cau.codigo = ic.causa_Codigo join Patologia pa on pa.codigo = " +
				" ic.patologia_Codigo where ic.patologia_Codigo = ?1",Causa.class).setParameter(1, codigo).getResultList();
	}
	
	/**
	 * 
	 * @param codigoCausa
	 * @param codigoPatologia
	 */
	public void eliminarItemCausa(int codigoCausa,int codigoPatologia){
		itemCausaPK itemPK = new itemCausaPK(codigoPatologia, codigoCausa);
		em.remove(em.find(ItemCausa.class, itemPK));
	}
	

}
