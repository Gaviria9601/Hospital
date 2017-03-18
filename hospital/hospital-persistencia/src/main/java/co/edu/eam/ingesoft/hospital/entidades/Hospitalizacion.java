/**
 * 
 */
package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Alejandro Ortega
 *
 */
@Entity
@Table(name="Hospitalización")
public class Hospitalizacion extends CitaAvanzada implements Serializable{
	
	@Column(name="causas", nullable=false, length=500)
	private String causas;

	public Hospitalizacion(){
		
	}
	
	public Hospitalizacion(String causas) {
		super();
		this.causas = causas;
	}

	/**
	 * @return the causas
	 */
	public String getCausas() {
		return causas;
	}

	/**
	 * @param causas the causas to set
	 */
	public void setCausas(String causas) {
		this.causas = causas;
	}
	
	
	

}
