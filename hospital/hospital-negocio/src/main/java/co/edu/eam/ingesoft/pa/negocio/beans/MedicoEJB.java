package co.edu.eam.ingesoft.pa.negocio.beans;

import java.util.ArrayList;
import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.hospital.entidades.Especializacion;
import co.edu.eam.ingesoft.hospital.entidades.ItemMedicoPk;
import co.edu.eam.ingesoft.hospital.entidades.Medico;
import co.edu.eam.ingesoft.hospital.entidades.itemMedico;
import co.edu.eam.ingesoft.pa.negocio.excepciones.ExcepcionNegocio;

@LocalBean
@Stateless
public class MedicoEJB {
	
	@PersistenceContext
	private EntityManager em;
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Medico buscarMedico(String cod) {
		Medico medico = em.find(Medico.class, cod);
		return medico;
	}
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Especializacion buscarEspecializacion(Integer cod) {
		Especializacion esp = em.find(Especializacion.class, cod);
		return esp;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void crearMedico(Medico medico) {
	Medico Medicodef =buscarMedico(medico.getCedula());
	if(Medicodef==null){
			em.persist(medico);
	}else {
		throw new ExcepcionNegocio("Ya esta esta cedula de usuario registrado");
	}
	
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void modificarMedico(Medico medico){
		Medico Medicodef =buscarMedico(medico.getCedula());
		if(Medicodef!=null){
				em.merge(medico);
		}else {
			throw new ExcepcionNegocio("ERROR");
		}
		
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void eliminarMedico(Medico medico){
		em.remove(medico);
	}
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public String generarCarnet() {
		String total = "";
		for (int i = 0; i < 8; i++) {
			int valorx = (int) ((Math.random() * 9) + 1);
			total = total + valorx;
		}
		 return total;
	}
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ArrayList<Especializacion> listarEspecializaciones() {
		ArrayList<Especializacion> list;
		list = (ArrayList<Especializacion>) em.createNamedQuery(Especializacion.especializaciones).getResultList();
		return list;
	}
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public itemMedico buscarItem(String med,int esp) {
		ItemMedicoPk pk = new ItemMedicoPk(esp, med);
		itemMedico item = em.find(itemMedico.class, pk);
		return item;
	}
	

	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void asignarEspecializacion(itemMedico item) {
	itemMedico itemdef = buscarItem(item.getMedicoUsuarioCedula().getCedula(),
			item.getEspecializacionCodigo().getCodigo());
		if(itemdef==null){
			System.out.println(item.getEspecializacionCodigo().getCodigo()+"******"+item.getMedicoUsuarioCedula().getCedula());
			em.persist(item);	
	}else {
		throw new ExcepcionNegocio("Este medico ya tiene asignada esta especializacion");
	}
	}
	
	

}
