/**
 * 
 */
package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author Alejandro Ortega
 *
 */
@NamedQueries({
	@NamedQuery(name = Habitacion.buscarhabitacion, query = "select e from Habitacion e where e.numero=?1"),
	@NamedQuery(name = Habitacion.listarHabitaciones, query = "select e from Habitacion e")})
@Entity
@Table(name="Habitacion")
public class Habitacion implements Serializable {
	
	public static final String buscarhabitacion = "buscarhab";
	public static final String listarHabitaciones = "listarhab";

	@Id
	@Column(name="codigo")
	private int codigo;
	
	@Column(name="numero", nullable=false)
	private int numero;
	
	@Column(name="piso", nullable=false)
	private int piso;
	
	@Column(name="descripcion", nullable=false, length=1000)
	private String descripcion;
	
	public Habitacion(){
		
	}
	

	public Habitacion(Integer codigo, int numero, int piso, String descripcion) {
		super();
		this.codigo = codigo;
		this.numero = numero;
		this.piso = piso;
		this.descripcion = descripcion;
	}
	
	

	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
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


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + numero;
		result = prime * result + piso;
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
		Habitacion other = (Habitacion) obj;
		if (codigo != other.codigo)
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (numero != other.numero)
			return false;
		if (piso != other.piso)
			return false;
		return true;
	}


	
}
