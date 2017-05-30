package co.edu.eam.ingesoft.pa.negocio.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.hospital.entidades.Cita;
import co.edu.eam.ingesoft.hospital.entidades.DiagnosticoCita;
import co.edu.eam.ingesoft.hospital.entidades.DiagnosticoCitaPK;
import co.edu.eam.ingesoft.hospital.entidades.Examen;
import co.edu.eam.ingesoft.hospital.entidades.Medicamento;
import co.edu.eam.ingesoft.hospital.entidades.OrdenMedicamento;
import co.edu.eam.ingesoft.hospital.entidades.OrdenMedicamentoPK;
import co.edu.eam.ingesoft.hospital.entidades.Patologia;
import co.edu.eam.ingesoft.pa.negocio.excepciones.ExcepcionNegocio;

@LocalBean
@Stateless
public class OrdenMedicamentoEJB {


	@PersistenceContext
	private EntityManager em;
	
	public List<OrdenMedicamento> listarOrden(String cedula){
		return (List<OrdenMedicamento>) 
				em.createNativeQuery( " select o.* from paciente p join cita c on p.cedula = c.paciente_cedula  "+
						" join ORDEN_MEDICAMENTO o on c.codigo = o.cita_codigo "+
						" join medicamento m on o.medicamentos_codigo = m.CODIGO "+
					    " where p.cedula = ?1 ",OrdenMedicamento.class).setParameter(1, cedula).getResultList();
	}
	
	public void entregar(OrdenMedicamento om){
		em.merge(om);
	}
	

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public OrdenMedicamento buscarOrdenMedicamento(int citacodigo, int medicamentoCodigo) {
		OrdenMedicamentoPK pk = new OrdenMedicamentoPK(citacodigo, medicamentoCodigo);
		OrdenMedicamento item = em.find(OrdenMedicamento.class, pk);
		return item;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void crearOrdenMedicamento(int codigocita, int medicamentoCodigo,int cantidad,String formula) {
		System.out.println(codigocita+"*******HOLAA***********"+medicamentoCodigo);
		OrdenMedicamento itemdef = buscarOrdenMedicamento(codigocita, medicamentoCodigo);
		Cita cita = em.find(Cita.class, codigocita);
		Medicamento med = em.find(Medicamento.class, medicamentoCodigo);
		OrdenMedicamento orden = new OrdenMedicamento(cantidad, formula, cita, med, true);
		if (itemdef == null) {
			em.persist(orden);
		} else {
			throw new ExcepcionNegocio("Esta cita ya tiene orden de este medicamento");
		}
	}

}
