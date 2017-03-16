/**
 * 
 */
package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * @author Alejandro Ortega
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="Instalacion")
public class Instalacion implements Serializable{

	@Id
	@Column(name = "codigo", nullable = false, length=10)
	protected String codigo;
	
	@Column(name = "disponibilidad", nullable = false)
	protected boolean disponibilidad;
	
	@Column(name = "tipo", nullable = false, length=50)
	protected String tipo;
	
	@Column(name = "observacionDisponible", nullable = false, length=1000)
	protected String observacionDisponible;
	
	public Instalacion(){
		
	}
	
	

	public Instalacion(String codigo, boolean disponibilidad, String tipo, String observacionDisponible) {
		super();
		this.codigo = codigo;
		this.disponibilidad = disponibilidad;
		this.tipo = tipo;
		this.observacionDisponible = observacionDisponible;
	}



	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the disponibilidad
	 */
	public boolean isDisponibilidad() {
		return disponibilidad;
	}

	/**
	 * @param disponibilidad the disponibilidad to set
	 */
	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the observacionDisponible
	 */
	public String getObservacionDisponible() {
		return observacionDisponible;
	}

	/**
	 * @param observacionDisponible the observacionDisponible to set
	 */
	public void setObservacionDisponible(String observacionDisponible) {
		this.observacionDisponible = observacionDisponible;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Instalacion other = (Instalacion) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}



	
}
