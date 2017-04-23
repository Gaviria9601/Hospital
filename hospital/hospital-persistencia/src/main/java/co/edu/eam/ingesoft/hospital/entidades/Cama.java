/**
 * 
 */
package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Alejandro Ortega
 *
 */
@Entity
@Table(name="Cama")
public class Cama extends Instalacion implements Serializable{

	
	@Column(name="numero", nullable=false)
	private int numero;
	
	
	@Column(name="descripcion", length=2000)
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name="habitacion_codigo")
	private Habitacion habitacionCodigo;
	
	public Cama(){
		
	}

	public Cama(int numero,String descripcion, Habitacion habitacionCodigo) {
		super();
		this.numero = numero;
		this.descripcion = descripcion;
		this.habitacionCodigo = habitacionCodigo;
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

	
	public Habitacion getHabitacionCodigo() {
		return habitacionCodigo;
	}

	public void setHabitacionCodigo(Habitacion habitacionCodigo) {
		this.habitacionCodigo = habitacionCodigo;
	}

	
	
}
