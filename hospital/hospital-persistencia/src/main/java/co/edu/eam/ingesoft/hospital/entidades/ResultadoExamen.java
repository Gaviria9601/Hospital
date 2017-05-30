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
	@Column(name="codigo")
	private int id;
	
	@Column(name="Observaciones", nullable=false, length=2000)
	String observaciones;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha", nullable=false)
	Date fecha;
	
	@OneToOne
	@JoinColumn(name = "OrdenProce_codigo", unique = true)
	private OrdenProcedimiento ordenCitaAvanzada;
	
	public ResultadoExamen(){
		
	}
	

	public ResultadoExamen(Integer id, String observaciones, Date fecha, OrdenProcedimiento ordenCitaAvanzada) {
		super();
		this.id = id;
		this.observaciones = observaciones;
		this.fecha = fecha;
		this.ordenCitaAvanzada = ordenCitaAvanzada;
	}



	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	

	public String getObservaciones() {
		return observaciones;
	}


	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}


	public OrdenProcedimiento getOrdenCitaAvanzada() {
		return ordenCitaAvanzada;
	}


	public void setOrdenCitaAvanzada(OrdenProcedimiento ordenCitaAvanzada) {
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResultadoExamen other = (ResultadoExamen) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
	
	
	
}
