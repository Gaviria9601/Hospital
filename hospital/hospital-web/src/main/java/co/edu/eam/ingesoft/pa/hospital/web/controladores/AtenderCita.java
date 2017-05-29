/**
 * 
 */
package co.edu.eam.ingesoft.pa.hospital.web.controladores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.hospital.entidades.Causa;
import co.edu.eam.ingesoft.hospital.entidades.Cita;
import co.edu.eam.ingesoft.hospital.entidades.DiagnosticoCita;
import co.edu.eam.ingesoft.hospital.entidades.Patologia;
import co.edu.eam.ingesoft.hospital.entidades.Sintoma;
import co.edu.eam.ingesoft.hospital.entidades.Tratamiento;
import co.edu.eam.ingesoft.pa.negocio.beans.CausaEJB;
import co.edu.eam.ingesoft.pa.negocio.beans.CitaEJB;
import co.edu.eam.ingesoft.pa.negocio.beans.DiagnosticoEJB;
import co.edu.eam.ingesoft.pa.negocio.beans.PatologiaEJB;
import co.edu.eam.ingesoft.pa.negocio.beans.SintomaEJB;
import co.edu.eam.ingesoft.pa.negocio.beans.TratamientoEJB;
import co.edu.eam.ingesoft.pa.negocio.excepciones.ExcepcionNegocio;

/**
 * @author Alejandro Ortega
 *
 */
@Named("AtenderCita")
@ViewScoped
public class AtenderCita implements Serializable {

	private List<Patologia> patologias;

	private List<Causa> causasAgre;

	private List<Sintoma> sintomasAgre;

	private List<Tratamiento> tratamientosAgre;

	private String descripcion;

	private ArrayList<DiagnosticoCita> diagnosticos = null;

	@EJB
	private PatologiaEJB patologiaEJB;

	@EJB
	private CausaEJB causaEJB;

	@EJB
	private SintomaEJB sintomaEJB;

	@EJB
	private TratamientoEJB tratamientoEJB;

	@EJB
	private DiagnosticoEJB diagnosticoejb;

	@EJB
	private CitaEJB citaejb;

	@PostConstruct
	public void inicializar() {
		patologias = patologiaEJB.listarPatologias();
	}

	public void listarTodo(Patologia patolo) {
		tratamientosAgre = tratamientoEJB.listarTratamietoPatologia(patolo.getCodigo());
		causasAgre = causaEJB.listarCausasPatologia(patolo.getCodigo());
		sintomasAgre = sintomaEJB.listarSintomasPatologia(patolo.getCodigo());
	}
	
	public String ordenarMedicamentos(){
		finalizarCita();
		return "/paginas/seguro/ordenMedica.xhtml?faces-redirect=true";
	}
	
	public String ordenarProcedimiento(){
		finalizarCita();
		return "/paginas/seguro/ordenProcedimiento.xhtml?faces-redirect=true";
	}

	public String finalizarCita() {
		try {
			for (int i = 0; i < diagnosticos.size(); i++) {
				System.out.println(diagnosticos.get(i).getCitaCodigo() + "***************"
						+ diagnosticos.get(i).getPatologiaCodigo().getCodigo());
				
				diagnosticoejb.asignarDiagnostico(diagnosticos.get(i).getCitaCodigo().getCodigo(),
						diagnosticos.get(i).getPatologiaCodigo().getCodigo(), descripcion);
			}
			Messages.addFlashGlobalInfo("Cita medica finalizada");
		} catch (ExcepcionNegocio e) {
			Messages.addGlobalError(e.getMessage());
		}
		return "/paginas/seguro/agenda-medico.xhtml?faces-redirect=true";
	}


	public void agregar(Patologia pat) {
		diagnosticos = new ArrayList<DiagnosticoCita>();
		Cita cita = citaejb.buscarCita(DatosManager.getCodigoCita());
		DiagnosticoCita diag = new DiagnosticoCita(cita, pat);
		diagnosticos.add(diag);
		Messages.addFlashGlobalInfo("Patologia agregada");
	}

	/**
	 * @return the patologias
	 */
	public List<Patologia> getPatologias() {
		return patologias;
	}

	/**
	 * @param patologias
	 *            the patologias to set
	 */
	public void setPatologias(List<Patologia> patologias) {
		this.patologias = patologias;
	}

	/**
	 * @return the causasAgre
	 */
	public List<Causa> getCausasAgre() {
		return causasAgre;
	}

	/**
	 * @param causasAgre
	 *            the causasAgre to set
	 */
	public void setCausasAgre(List<Causa> causasAgre) {
		this.causasAgre = causasAgre;
	}

	/**
	 * @return the sintomasAgre
	 */
	public List<Sintoma> getSintomasAgre() {
		return sintomasAgre;
	}

	/**
	 * @param sintomasAgre
	 *            the sintomasAgre to set
	 */
	public void setSintomasAgre(List<Sintoma> sintomasAgre) {
		this.sintomasAgre = sintomasAgre;
	}

	/**
	 * @return the tratamientosAgre
	 */
	public List<Tratamiento> getTratamientosAgre() {
		return tratamientosAgre;
	}

	/**
	 * @param tratamientosAgre
	 *            the tratamientosAgre to set
	 */
	public void setTratamientosAgre(List<Tratamiento> tratamientosAgre) {
		this.tratamientosAgre = tratamientosAgre;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion
	 *            the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the diagnosticos
	 */
	public ArrayList<DiagnosticoCita> getDiagnosticos() {
		return diagnosticos;
	}

	/**
	 * @param diagnosticos
	 *            the diagnosticos to set
	 */
	public void setDiagnosticos(ArrayList<DiagnosticoCita> diagnosticos) {
		this.diagnosticos = diagnosticos;
	}

}
