/**
 * 
 */
package co.edu.eam.ingesoft.pa.hospital.web.controladores;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.hospital.entidades.Especializacion;
import co.edu.eam.ingesoft.hospital.entidades.Medico;
import co.edu.eam.ingesoft.hospital.entidades.itemMedico;
import co.edu.eam.ingesoft.hospital.enumeraciones.TipoUsuarioEnum;
import co.edu.eam.ingesoft.pa.negocio.beans.MedicoEJB;
import co.edu.eam.ingesoft.pa.negocio.excepciones.ExcepcionNegocio;

/**
 * @author Alejandro Ortega
 *
 */
@Named("controladorEspecializacion")
@ViewScoped
public class ControladorAsignarEspecializacion implements Serializable{

	@EJB
	MedicoEJB medejb;
	
	@PostConstruct
	public void inicializar() {
		especializaciones = medejb.listarEspecializaciones();
	}
	
	@Pattern(regexp="[0-9]*",message="solo numeros")
	@Length(min=4,max=15,message="longitud entre 4 y 15")
	private String cedula;
	
	private List<Especializacion> especializaciones;
	private Integer codigoEsp;
	
	public void asignar(){
		try{
			Medico med =medejb.buscarMedico(cedula);
			Especializacion esp = medejb.buscarEspecializacion(codigoEsp);
			if(med!=null){
			itemMedico item = new itemMedico(esp, med);
					medejb.asignarEspecializacion(item);
					
					// limpiar campos	
					cedula="";
			
					Messages.addFlashGlobalInfo("Especializacion asignada correctamente al medico"
							+ " "+med.getNombre()+" "+med.getApellido());
			}else{
				Messages.addGlobalError("Este medico con esta cedula no existe");
			}
			}catch(ExcepcionNegocio e){
				Messages.addGlobalError(e.getMessage());
			}
	}

	/**
	 * @return the cedula
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * @param cedula the cedula to set
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	/**
	 * @return the especializaciones
	 */
	public List<Especializacion> getEspecializaciones() {
		return especializaciones;
	}

	/**
	 * @param especializaciones the especializaciones to set
	 */
	public void setEspecializaciones(List<Especializacion> especializaciones) {
		this.especializaciones = especializaciones;
	}

	/**
	 * @return the codigoEsp
	 */
	public Integer getCodigoEsp() {
		return codigoEsp;
	}

	/**
	 * @param codigoEsp the codigoEsp to set
	 */
	public void setCodigoEsp(Integer codigoEsp) {
		this.codigoEsp = codigoEsp;
	}

	
	
	
}
