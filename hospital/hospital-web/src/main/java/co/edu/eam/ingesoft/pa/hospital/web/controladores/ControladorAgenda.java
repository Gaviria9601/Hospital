/**
 * 
 */
package co.edu.eam.ingesoft.pa.hospital.web.controladores;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import co.edu.eam.ingesoft.hospital.entidades.Cita;
import co.edu.eam.ingesoft.hospital.entidades.Especializacion;
import co.edu.eam.ingesoft.pa.negocio.beans.CitaEJB;
import co.edu.eam.ingesoft.pa.negocio.beans.MedicoEJB;

/**
 * @author Alejandro Ortega
 *
 */
@Named("controladorAgenda")
@ViewScoped
public class ControladorAgenda implements Serializable {

	@EJB
	CitaEJB citaejb;

	@PostConstruct
	public void inicializar() {
		citas = citaejb.listarCitasMedicox("1970");
	}

	public String atenderCita(Cita cita) {
		DatosManager.setCodigoCita(cita.getCodigo());
		return "/paginas/seguro/atender-cita.xhtml?faces-redirect=true";
	}

	private List<Cita> citas;

	/**
	 * @return the citas
	 */
	public List<Cita> getCitas() {
		return citas;
	}

	/**
	 * @param citas
	 *            the citas to set
	 */
	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}

}
