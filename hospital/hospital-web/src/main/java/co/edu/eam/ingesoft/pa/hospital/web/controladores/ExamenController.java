package co.edu.eam.ingesoft.pa.hospital.web.controladores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.hibernate.validator.constraints.Length;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.context.RequestContext;

import co.edu.eam.ingesoft.hospital.entidades.Examen;
import co.edu.eam.ingesoft.hospital.entidades.TipoExamen;
import co.edu.eam.ingesoft.hospital.enumeraciones.CitaAvanzadaEnum;
import co.edu.eam.ingesoft.pa.negocio.beans.ExamenEJB;

@Named("examenController")
@ViewScoped
public class ExamenController implements Serializable {
	
	private Examen examen;

	@Length(min = 4, max = 50, message = "Longitud entre 4 y 50")
	private String nombre;

	private String tiempoestimado;

	@Length(min = 5, max = 500, message = "Longitud entre 5 y 500")
	private String observaciones;

	private TipoExamen tipoExamen;
	
	private List<TipoExamen> tipoExamenes ;

	private List<Examen> examenes;
	
	private ArrayList<Examen> filtroExamenes = new ArrayList<Examen>();

	private boolean busco = false;
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTiempoestimado() {
		return tiempoestimado;
	}

	public void setTiempoestimado(String tiempoestimado) {
		this.tiempoestimado = tiempoestimado;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Examen getExamen() {
		return examen;
	}

	public void setExamen(Examen examen) {
		this.examen = examen;
	}

	public TipoExamen getTipoExamen() {
		return tipoExamen;
	}

	public void setTipoExamen(TipoExamen tipoExamen) {
		this.tipoExamen = tipoExamen;
	}

	public List<TipoExamen> getTipoExamenes() {
		return tipoExamenes;
	}

	public void setTipoExamenes(List<TipoExamen> tipoExamenes) {
		this.tipoExamenes = tipoExamenes;
	}

	public List<Examen> getExamenes() {
		return examenes;
	}

	public void setExamenes(List<Examen> examenes) {
		this.examenes = examenes;
	}

	public ArrayList<Examen> getFiltroExamenes() {
		return filtroExamenes;
	}

	public void setFiltroExamenes(ArrayList<Examen> filtroExamenes) {
		this.filtroExamenes = filtroExamenes;
	}



	@EJB
	private ExamenEJB examenEJB;

	

	@PostConstruct
	public void inicializar() {
		examenes = examenEJB.listarExamenes();
		tipoExamenes = examenEJB.listarTipoExamenes();
	}

	/**
	 * Crea el examen
	 */
	public void crear() {
		try {
			Examen examen = new Examen();
			examen.setNombre(nombre);
			examen.setObservaciones(observaciones);
			examen.setTiempoEstimado(tiempoestimado);
			examen.setTipo(CitaAvanzadaEnum.Examen);
			examen.setTipoExamen(tipoExamen);
			examenEJB.crearExamen(examen);
			Messages.addFlashGlobalInfo("EXAMEN INGRESADO AL SISTEMA CORRECTAMENTE");
			nombre = "";
			tiempoestimado = "";
			observaciones = "";
		} catch (Exception e) {
			Messages.addFlashGlobalError("ERROR AL INGRESAR EL EXAMEN");
		}

	}

	/**
	 * Limpia los campos del registro del examen
	 */
	public void limpiar() {
		nombre = "";
		tiempoestimado = "";
		observaciones = "";
		busco = false;
	}

	/**
	 * 
	 * @param exa
	 */
	public void eliminar(Examen exa) {
		try {
			examenEJB.eliminarExamen(exa.getCodigo());
			Messages.addFlashGlobalInfo("SE HA ELIMINADO CORRECTAMENTE EL EXAMEN");
			examenes = examenEJB.listarExamenes();
			resetearFitrosTabla("tablaExamenes");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/**
	 * 
	 * @param id
	 */
	public void resetearFitrosTabla(String id) {
		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.execute("PF('vtWidget').clearFilters()");
    }

	/**
	 * 
	 */
	public void editar(Examen exa) {
		examen = exa;
		nombre = exa.getNombre();
		observaciones = exa.getObservaciones();
		tiempoestimado = exa.getTiempoEstimado();
		tipoExamen = exa.getTipoExamen();
		busco = true;
	}

	/**
	 * 
	 * @param ciru
	 */
	public void modificar() {
		examen.setNombre(nombre);
		examen.setObservaciones(observaciones);
		examen.setTiempoEstimado(tiempoestimado);
		examen.setTipo(CitaAvanzadaEnum.Examen);
		examen.setTipoExamen(tipoExamen);
		Messages.addGlobalInfo("EL EXAMEN FUE MODIFICADO CORRECTAMENTE");
		limpiar();
	}

	public boolean isBusco() {
		return busco;
	}

	
	

}
