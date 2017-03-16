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
@Table(name="Habitacion")
public class Habitacion extends Instalacion implements Serializable {

	@Column(name="numero", nullable=false)
	private int numero;
	
	@Column(name="piso", nullable=false)
	private int piso;
	
	@Column(name="descripcion", nullable=false, length=2000)
	String descripcion;
	
	public Habitacion() {
		super();
	}
	
	

	public Habitacion(int numero, int piso, String descripcion) {
		super();
		this.numero = numero;
		this.piso = piso;
		this.descripcion = descripcion;
	}



	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * @return the piso
	 */
	public int getPiso() {
		return piso;
	}

	/**
	 * @param piso the piso to set
	 */
	public void setPiso(int piso) {
		this.piso = piso;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	
}
