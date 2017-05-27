package co.edu.eam.ingesoft.pa.hospital.web.controladores;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;
import org.primefaces.context.RequestContext;

import co.edu.eam.ingesoft.hospital.entidades.Cita;
import co.edu.eam.ingesoft.hospital.entidades.Hospitalizacion;
import co.edu.eam.ingesoft.hospital.entidades.OrdenHospitalizacion;
import co.edu.eam.ingesoft.hospital.entidades.TipoHospitalizacion;
import co.edu.eam.ingesoft.hospital.enumeraciones.CitaAvanzadaEnum;
import co.edu.eam.ingesoft.pa.negocio.beans.CamaEJB;
import co.edu.eam.ingesoft.pa.negocio.beans.CitaEJB;
import co.edu.eam.ingesoft.pa.negocio.beans.HospitalizacionEJB;
import co.edu.eam.ingesoft.pa.negocio.beans.OrdenHospitalizacionEJB;

@Named("hospitalizacionController")
@ViewScoped
public class HospitalizacionController implements Serializable {

	@Length(min = 4, max = 50, message = "Longitud entre 4 y 50")
	private String nombre;

	private String tiempoestimado;

	private TipoHospitalizacion tipoHospitalizacion;
	
	private String horaInicio;
	
	private String fecha;
	
	@Length(min = 5, max = 1000, message = "Longitud entre 5 y 1000")
	private String observacionesOrdenPro;
	
	private List<TipoHospitalizacion> tipoHospitalizaciones;

	
	
	public List<TipoHospitalizacion> getTipoHospitalizaciones() {
		return tipoHospitalizaciones;
	}

	public void setTipoHospitalizaciones(List<TipoHospitalizacion> tipoHospitalizaciones) {
		this.tipoHospitalizaciones = tipoHospitalizaciones;
	}

	public String getObservacionesOrdenPro() {
		return observacionesOrdenPro;
	}

	public void setObservacionesOrdenPro(String observacionesOrdenPro) {
		this.observacionesOrdenPro = observacionesOrdenPro;
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

	

	public TipoHospitalizacion getTipoHospitalizacion() {
		return tipoHospitalizacion;
	}

	public void setTipoHospitalizacion(TipoHospitalizacion tipoHospitalizacion) {
		this.tipoHospitalizacion = tipoHospitalizacion;
	}

	@EJB
	private CitaEJB citaEJB;


	@EJB
	private HospitalizacionEJB hospitalizacionEJB;
	
	@EJB
	private CamaEJB camaEJB;
	
	@EJB
	private OrdenHospitalizacionEJB ordenHoEJB;
	
	
	@PostConstruct
	public void inicializar(){
		tipoHospitalizaciones = hospitalizacionEJB.listarTipoHospitalizacion();
	}
	


	/**
	 * Crea una hospitalización
	 */
	public void crear() {
		DatosManager.setCodigoCita(5);
		try {
			Hospitalizacion hospi = new Hospitalizacion();
			hospi.setNombre(nombre);
			hospi.setObservaciones(observacionesOrdenPro);
			hospi.setTiempoEstimado(tiempoestimado);
			hospi.setTipo(CitaAvanzadaEnum.Hospitalización);
			hospi.setTipoHospitalizacion(tipoHospitalizacion);
			hospitalizacionEJB.crearHospitalizacion(hospi);
			OrdenHospitalizacion ordHos = new OrdenHospitalizacion();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm");
			Date horaIni = dateFormat.parse(fecha + " " + horaInicio);	
			ordHos.setHoraInicio(horaIni);
			ordHos.setHospitalizacion(hospi);
			ordHos.setCama(camaEJB.buscarCamaNormal(2));
			SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-mm-dd");
			ordHos.setFecha(formatoDelTexto.parse(fecha));
			ordHos.setObservaciones(observacionesOrdenPro);
			ordHos.setEstado(true);
			Cita cita = citaEJB.buscarCita(5);
			ordHos.setCitaCodigo(cita);
			ordenHoEJB.crearOrdenHospitalizacion(ordHos);
			Messages.addFlashGlobalInfo("HOSPITALIZACIÓN CREADA CORRECTAMENTE");
			nombre = "";
			observacionesOrdenPro = "";
			tiempoestimado = "";
		} catch (Exception e) {
			e.printStackTrace();
			Messages.addFlashGlobalError("ERRROR AL CREAR LA HOSPITALIZACIÓN");
		}

	}
	

	/**
	 * Limpia los campos de registro
	 */
	public void limpiar() {
		nombre = "";
		observacionesOrdenPro = "";
		tiempoestimado = "";
	}

}
