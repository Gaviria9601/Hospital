/**
 * 
 */
package co.edu.eam.ingesoft.pa.hospital.web.controladores;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import co.edu.eam.ingesoft.hospital.entidades.Cita;
import co.edu.eam.ingesoft.hospital.entidades.Especializacion;
import co.edu.eam.ingesoft.hospital.entidades.Usuario;
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
	
	@Inject
	SessionController sessionEJB;

	@PostConstruct
	public void inicializar() {
		Usuario usu = sessionEJB.getUsuario();
		citas = citaejb.listarCitasMedicox(usu.getCedula());
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
