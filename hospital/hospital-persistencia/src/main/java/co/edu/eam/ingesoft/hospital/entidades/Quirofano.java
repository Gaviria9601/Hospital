/**
 * 
 */
package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Alejandro Ortega
 *
 */
@Entity
@Table(name="Quirofano")
public class Quirofano extends Instalacion implements Serializable {
	
	@Column(name="caracteristicas", nullable=false, length=2000)
	private String caracteristicas;
	
	@Column(name="numero_aparatos", nullable=false)
	private int numero_aparatos;
	
	@Column(name="cantidad_medico", nullable=false)
	private int cantidad_medico;
	
	public Quirofano(){
		
	}

	/**
	 * @return the caracteristicas
	 */
	public String getCaracteristicas() {
		return caracteristicas;
	}

	/**
	 * @param caracteristicas the caracteristicas to set
	 */
	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	/**
	 * @return the numero_aparatos
	 */
	public int getNumero_aparatos() {
		return numero_aparatos;
	}

	/**
	 * @param numero_aparatos the numero_aparatos to set
	 */
	public void setNumero_aparatos(int numero_aparatos) {
		this.numero_aparatos = numero_aparatos;
	}

	/**
	 * @return the cantidad_medico
	 */
	public int getCantidad_medico() {
		return cantidad_medico;
	}

	/**
	 * @param cantidad_medico the cantidad_medico to set
	 */
	public void setCantidad_medico(int cantidad_medico) {
		this.cantidad_medico = cantidad_medico;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + cantidad_medico;
		result = prime * result + ((caracteristicas == null) ? 0 : caracteristicas.hashCode());
		result = prime * result + numero_aparatos;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Quirofano other = (Quirofano) obj;
		if (cantidad_medico != other.cantidad_medico)
			return false;
		if (caracteristicas == null) {
			if (other.caracteristicas != null)
				return false;
		} else if (!caracteristicas.equals(other.caracteristicas))
			return false;
		if (numero_aparatos != other.numero_aparatos)
			return false;
		return true;
	}
	
	

}
