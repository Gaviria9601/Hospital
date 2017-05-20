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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author Alejandro Ortega
 *
 */
@NamedQueries({
	@NamedQuery(name = Cama.buscarCama, query = "select e from Cama e where e.numero=?1 and e.habitacionCodigo.numero=?2")})

@Entity
@Table(name="Cama")
public class Cama extends Instalacion implements Serializable{
	
	public static final String buscarCama = "buscarCam";

	
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
	
	

	public Cama(boolean disponibilidad, String observacionDisponible, String tipo,
			int numero,String descripcion, Habitacion habitacionCodigo) {
		super(disponibilidad, observacionDisponible, tipo);
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + numero;
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
		Cama other = (Cama) obj;
		if (numero != other.numero)
			return false;
		return true;
	}

	
	
	
}
