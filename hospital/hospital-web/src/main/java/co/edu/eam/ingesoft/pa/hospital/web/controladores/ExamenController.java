package co.edu.eam.ingesoft.pa.hospital.web.controladores;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import org.hibernate.validator.constraints.Length;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;
import org.primefaces.context.RequestContext;

import co.edu.eam.ingesoft.hospital.entidades.Cita;
import co.edu.eam.ingesoft.hospital.entidades.Examen;
import co.edu.eam.ingesoft.hospital.entidades.OrdenExamen;
import co.edu.eam.ingesoft.hospital.entidades.TipoExamen;
import co.edu.eam.ingesoft.hospital.enumeraciones.CitaAvanzadaEnum;
import co.edu.eam.ingesoft.pa.negocio.beans.CitaEJB;
import co.edu.eam.ingesoft.pa.negocio.beans.ExamenEJB;
import co.edu.eam.ingesoft.pa.negocio.beans.OrdenExamenEJB;

@Named("examenController")
@ViewScoped
public class ExamenController implements Serializable {
	
	private Examen examen;

	@Length(min = 4, max = 50, message = "Longitud entre 4 y 50")
	private String nombre;

	private String tiempoestimado;
	
	private String tiempo;

	@Length(min = 5, max = 500, message = "Longitud entre 5 y 500")
	private String observaciones;

	private TipoExamen tipoExamen;
	
	private List<TipoExamen> tipoExamenes ;

	private List<Examen> examenes;
	
	private ArrayList<Examen> filtroExamenes = new ArrayList<Examen>();

	private boolean busco = false;
	
	private String observacionesOrdenPro;
	
	private String fecha;
	
	private String horaInicio;
	

	public String getTiempo() {
		return tiempo;
	}

	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getObservacionesOrdenPro() {
		return observacionesOrdenPro;
	}

	public void setObservacionesOrdenPro(String observacionesOrdenPro) {
		this.observacionesOrdenPro = observacionesOrdenPro;
	}

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

	@EJB
	private CitaEJB citaEJB;
	
	@EJB
	private OrdenExamenEJB ordenExamenEJB;
	

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
			examen.setTiempoEstimado(tiempoestimado + " " + tiempo);
			examen.setTipo(CitaAvanzadaEnum.Examen);
			examen.setTipoExamen(tipoExamen);
			examenEJB.crearExamen(examen);
			examenes = examenEJB.listarExamenes();
			Messages.addFlashGlobalInfo("EXAMEN INGRESADO AL SISTEMA CORRECTAMENTE");
			resetearFitrosTabla("tablaExamenes");
			nombre = "";
			tiempoestimado = "";
			observaciones = "";
			tiempo = "";
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
		tiempo = "";
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
		String[] datos = exa.getTiempoEstimado().split(" ");
		tiempoestimado = datos[0];
		tiempo = datos[1];
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
		examen.setTiempoEstimado(tiempoestimado + " " + tiempo);
		examen.setTipo(CitaAvanzadaEnum.Examen);
		examen.setTipoExamen(tipoExamen);
		examenEJB.editarExamen(examen);
		Messages.addGlobalInfo("EL EXAMEN FUE MODIFICADO CORRECTAMENTE");
		limpiar();
	}

	public boolean isBusco() {
		return busco;
	}
	
	/**
	 * 
	 */
	public void crearOrden(){
		DatosManager.setCodigoCita(6);
		try{
		OrdenExamen orExa = new OrdenExamen();
		orExa.setObservaciones(observacionesOrdenPro);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date horaIni = dateFormat.parse(fecha + " " + horaInicio);	
		orExa.setHora(horaIni);
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
		orExa.setFecha(formatoDelTexto.parse(fecha));
		orExa.setEstado(true);
		orExa.setExamen(examen);
		Cita cita = citaEJB.buscarCita(DatosManager.getCodigoCita());
		orExa.setCitaCodigo(cita);
		ordenExamenEJB.crearOrdenExamen(orExa);
		Messages.addFlashGlobalInfo("ORDEN DE EXAMEN CREADA CORRECTAMENTE");
		observacionesOrdenPro = "";
		fecha = "";
		horaInicio = "";
		examen = null;
		}catch (Exception e) {
			Messages.addFlashGlobalError("ERRROR AL CREAR LA ORDEN DE EXAMEN");
		}
	}
	
	/**
	 * 
	 */
	public void limpiarOrden(){
		observacionesOrdenPro = "";
		fecha = "";
		horaInicio = "";
		examen = null;
	}

	
	

}
