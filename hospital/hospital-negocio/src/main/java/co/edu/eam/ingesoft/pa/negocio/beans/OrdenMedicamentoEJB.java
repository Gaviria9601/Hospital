package co.edu.eam.ingesoft.pa.negocio.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import co.edu.eam.ingesoft.hospital.entidades.OrdenMedicamento;

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
	
	
}
