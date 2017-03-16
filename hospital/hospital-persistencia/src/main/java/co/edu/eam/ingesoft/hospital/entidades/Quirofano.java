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
		super();
	}
	

	public Quirofano(String caracteristicas, int numero_aparatos, int cantidad_medico) {
		super();
		this.caracteristicas = caracteristicas;
		this.numero_aparatos = numero_aparatos;
		this.cantidad_medico = cantidad_medico;
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

	
	
	

}
