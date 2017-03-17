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
@Table(name="Examen")
public class Examen extends CitaAvanzada implements Serializable{

	@ManyToOne
	@JoinColumn(name = "tipoExamen_id")
	private TipoExamen tipoExamen;
	
	public Examen(){
		
	}
	

	public Examen(TipoExamen tipoExamen) {
		super();
		this.tipoExamen = tipoExamen;
	}



	/**
	 * @return the tipoExamen
	 */
	public TipoExamen getTipoExamen() {
		return tipoExamen;
	}

	/**
	 * @param tipoExamen the tipoExamen to set
	 */
	public void setTipoExamen(TipoExamen tipoExamen) {
		this.tipoExamen = tipoExamen;
	}
	
	
}
