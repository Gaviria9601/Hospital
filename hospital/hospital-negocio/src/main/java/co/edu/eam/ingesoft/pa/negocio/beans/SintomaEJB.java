package co.edu.eam.ingesoft.pa.negocio.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.hospital.entidades.ItemSintoma;
import co.edu.eam.ingesoft.hospital.entidades.Patologia;
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
	public void crearItemSintoma(Patologia pato,Sintoma sin){
		Patologia patolo = em.find(Patologia.class, pato.getCodigo());
		Sintoma sinto = em.find(Sintoma.class, sin.getCodigo());
		ItemSintoma itemSin = new ItemSintoma(sinto,patolo);
		em.persist(itemSin);
	}
	
	/**
	 * 
	 * @param codigo
	 * @return
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Sintoma buscarSintoma(int codigo){
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
	public void eliminarItemSintoma(int codigoSintoma,int codigoPatologia){
		itemSintomaPK itemPK = new itemSintomaPK(codigoSintoma, codigoPatologia);
		em.remove(em.find(ItemSintoma.class, itemPK));
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Sintoma> listarSintomas(){
		return (List<Sintoma>) em.createNamedQuery(Sintoma.LISTAR_SINTOMAS).getResultList();
	}
	
	/**
	 * 
	 * @param codigo
	 * @return
	 */
	public List<Sintoma> listarSintomasPatologia(int codigo){
		return (List<Sintoma>) em.createNativeQuery("select sin.* from Sintoma sin "
				+ " join Item_Sintoma im on sin.codigo = im.sintoma_Codigo join Patologia pa on pa.codigo = " +
				" im.patologia_Codigo where im.patologia_Codigo = ?1",Sintoma.class).setParameter(1, codigo).getResultList();
	}
	
}
