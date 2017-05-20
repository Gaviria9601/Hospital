/**
 * 
 */
package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
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
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequencee")
	@SequenceGenerator(name = "id_Sequencee", sequenceName = "SEQ_INSTALACION",allocationSize=1)
	@Column(name = "codigo")
	protected Integer codigo;
	
	@Column(name = "disponibilidad", nullable = false)
	protected boolean disponibilidad;
	
	
	@Column(name = "observacionDisponible", nullable = false, length=1000)
	protected String observacionDisponible;
	
	@Column(name = "tipo")
	protected String tipo;
	
	public Instalacion(){
		
	}

	public Instalacion(boolean disponibilidad, String observacionDisponible, String tipo) {
		super();
		this.disponibilidad = disponibilidad;
		this.observacionDisponible = observacionDisponible;
		this.tipo = tipo;
	}


	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the codigo
	 */
	public Integer getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(Integer codigo) {
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
