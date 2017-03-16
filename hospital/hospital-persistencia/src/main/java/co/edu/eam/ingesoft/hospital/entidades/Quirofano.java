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
	private int numeroAparatos;
	
	@Column(name="cantidad_medico", nullable=false)
	private int cantidadMedico;
	
	public Quirofano(){
		
	}

	public Quirofano(String caracteristicas, int numeroAparatos, int cantidadMedico) {
		super();
		this.caracteristicas = caracteristicas;
		this.numeroAparatos = numeroAparatos;
		this.cantidadMedico = cantidadMedico;
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
	 * @return the numeroAparatos
	 */
	public int getNumeroAparatos() {
		return numeroAparatos;
	}

	/**
	 * @param numeroAparatos the numeroAparatos to set
	 */
	public void setNumeroAparatos(int numeroAparatos) {
		this.numeroAparatos = numeroAparatos;
	}

	/**
	 * @return the cantidadMedico
	 */
	public int getCantidadMedico() {
		return cantidadMedico;
	}

	/**
	 * @param cantidadMedico the cantidadMedico to set
	 */
	public void setCantidadMedico(int cantidadMedico) {
		this.cantidadMedico = cantidadMedico;
	}

	
	
	
	
}
