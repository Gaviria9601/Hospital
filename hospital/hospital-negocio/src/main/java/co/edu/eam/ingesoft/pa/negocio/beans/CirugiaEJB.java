package co.edu.eam.ingesoft.pa.negocio.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.hospital.entidades.Cirugia;
import co.edu.eam.ingesoft.hospital.entidades.Especializacion;
import co.edu.eam.ingesoft.hospital.entidades.OrdenCirugia;
import co.edu.eam.ingesoft.hospital.entidades.TipoCirugia;

@Stateless
@LocalBean
public class CirugiaEJB {

	@PersistenceContext
	private EntityManager em;

	/**
	 * 
	 * @param ciru
	 */
	public void crearCirugia(Cirugia ciru) {
		em.persist(ciru);
	}

	/**
	 * 
	 * @param codigo
	 * @return
	 */
	public Cirugia buscarCirugia(Integer codigo) {
		return em.find(Cirugia.class, codigo);
	}

	/**
	 * Busca el tipo de cirugia
	 * 
	 * @param codigo,
	 *            codigo del tipo de cirugia
	 * @return
	 */
	public TipoCirugia buscarTipoCirugia(Integer codigo) {
		return em.find(TipoCirugia.class, codigo);
	}

	/**
	 * Lista los tipos de cirugias
	 * 
	 * @return
	 */
	public List<TipoCirugia> listarTiposCirugias() {
		return (List<TipoCirugia>) em.createNamedQuery(TipoCirugia.LISTAR_TIPO_CIRUGIA).getResultList();
	}

	/**
	 * 
	 */
	public void editarCirugia(Cirugia ciru) {
		em.merge(ciru);
	}

	/**
	 * 
	 * @param codigo
	 */
	public void eliminarCirugia(Integer codigo) {
		em.remove(em.find(Cirugia.class, codigo));
	}

	/**
	 * Lista las cirugias
	 * 
	 * @return
	 */
	public List<Cirugia> listarCirugias() {
		return (List<Cirugia>) em.createNamedQuery(Cirugia.LISTAR_CIRUGIAS).getResultList();
	}

	/**
	 * 
	 * @param codigo
	 * @return
	 */
	public Especializacion buscarEspecializacion(int codigo) {
		return (Especializacion) em.createNativeQuery(
				"select esp.* from cirugia ciru join especializacion esp on ciru.especializacion_codigo = esp.CODIGO where ciru.CODIGO = ?1",
				Especializacion.class).setParameter(1, codigo).getSingleResult();
	}
	
	
	

}
