package co.edu.eam.ingesoft.pa.hospital.web.controladores;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;
import org.primefaces.context.RequestContext;

import co.edu.eam.ingesoft.hospital.entidades.Hospitalizacion;
import co.edu.eam.ingesoft.hospital.enumeraciones.CitaAvanzadaEnum;
import co.edu.eam.ingesoft.pa.negocio.beans.HospitalizacionEJB;

@Named("hospitalizacionController")
@ViewScoped
public class HospitalizacionController implements Serializable {

	@Length(min = 4, max = 50, message = "Longitud entre 4 y 50")
	private String nombre;

	private String tiempoestimado;

	@Length(min = 5, max = 500, message = "Longitud entre 5 y 500")
	private String observaciones;

	@Pattern(regexp = "[A-Za-z ]*", message = "Solo Letras")
	@Length(min = 5, max = 500, message = "Longitud entre 5 y 500")
	private String causas;
	
	private String horaInicio;
	
	private String fecha;
	
	private String observacionesOrdenPro;
	
	

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

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getTiempoestimado() {
		return tiempoestimado;
	}

	public void setTiempoestimado(String tiempoestimado) {
		this.tiempoestimado = tiempoestimado;
	}

	public String getCausas() {
		return causas;
	}

	public void setCausas(String causas) {
		this.causas = causas;
	}

	@EJB
	private HospitalizacionEJB hospitalizacionEJB;
	


	/**
	 * Crea una hospitalización
	 */
	public void crear() {
		try {
			Hospitalizacion hospi = new Hospitalizacion();
			hospi.setNombre(nombre);
			hospi.setObservaciones(observaciones);
			hospi.setTiempoEstimado(tiempoestimado);
			hospi.setTipo(CitaAvanzadaEnum.Hospitalización);
			hospi.setCausas(causas);
			hospitalizacionEJB.crearHospitalizacion(hospi);
			Messages.addFlashGlobalInfo("HOSPITALIZACIÓN CREADA CORRECTAMENTE");
			nombre = "";
			observaciones = "";
			tiempoestimado = "";
			causas = "";
		} catch (Exception e) {
			Messages.addFlashGlobalError("ERRROR AL CREAR LA HOSPITALIZACIÓN");
		}

	}
	

	/**
	 * Limpia los campos de registro
	 */
	public void limpiar() {
		nombre = "";
		observaciones = "";
		tiempoestimado = "";
		causas = "";
	}

}
