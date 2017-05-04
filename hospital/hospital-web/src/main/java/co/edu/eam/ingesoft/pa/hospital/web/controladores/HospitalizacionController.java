package co.edu.eam.ingesoft.pa.hospital.web.controladores;

import java.io.Serializable;

import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

@Named("hospitalizacionController")
@ViewScoped
public class HospitalizacionController implements Serializable {

	private String nombre;
	
	private String tiempoestimado;
	
	private String observaciones;
	
	private String causas;

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
	
	
	
}
