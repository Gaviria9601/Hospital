/**
 * 
 */
package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Alejandro Ortega
 *
 */
@Entity
@Table(name="Hospitalizacion")
public class Hospitalizacion extends CitaAvanzada implements Serializable{
	
	@ManyToOne
	@JoinColumn(name="tipo")
	private TipoHospitalizacion tipoHospitalizacion;

	public Hospitalizacion(){
		
	}

	public Hospitalizacion(TipoHospitalizacion tipoHospitalizacion) {
		super();
		this.tipoHospitalizacion = tipoHospitalizacion;
	}

	public TipoHospitalizacion getTipoHospitalizacion() {
		return tipoHospitalizacion;
	}

	public void setTipoHospitalizacion(TipoHospitalizacion tipoHospitalizacion) {
		this.tipoHospitalizacion = tipoHospitalizacion;
	}
	
		
	
	

}
