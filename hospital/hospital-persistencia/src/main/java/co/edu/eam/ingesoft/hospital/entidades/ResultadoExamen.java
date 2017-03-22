/**
 * 
 */
package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Alejandro Ortega
 *
 */
@Entity
@Table(name="ResultadoExamen")
public class ResultadoExamen implements Serializable{

	@Id
	@Column(name="id", nullable=false, length=20)
	private String id;
	
	@Column(name="observaciones", nullable=false, length=2000)
	String observaciones;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha", nullable=false)
	Date fecha;
	
	@OneToOne
	@JoinColumn(name = "OrdenCitaAvanzada_Codigo", unique = true)
	private OrdenCitaAvanzada ordenCitaAvanzada;
	
	public ResultadoExamen(){
		
	}
	

	public ResultadoExamen(String id, String observaciones, Date fecha, OrdenCitaAvanzada ordenCitaAvanzada) {
		super();
		this.id = id;
		this.observaciones = observaciones;
		this.fecha = fecha;
		this.ordenCitaAvanzada = ordenCitaAvanzada;
	}





	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	

	public String getObservaciones() {
		return observaciones;
	}


	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}


	public OrdenCitaAvanzada getOrdenCitaAvanzada() {
		return ordenCitaAvanzada;
	}


	public void setOrdenCitaAvanzada(OrdenCitaAvanzada ordenCitaAvanzada) {
		this.ordenCitaAvanzada = ordenCitaAvanzada;
	}


	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResultadoExamen other = (ResultadoExamen) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
}
