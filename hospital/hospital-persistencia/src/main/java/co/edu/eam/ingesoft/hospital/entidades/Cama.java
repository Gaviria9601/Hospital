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
public class Cama implements Serializable{

	@Id
	@Column(name="codigo", nullable=false, length=10)
	private String codigo;
	
	@Column(name="numero", nullable=false)
	private int numero;
	
	@Column(name="estado", nullable=false)
	private boolean estado;
	
	@Column(name="descripción", length=2000)
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name="instalaciones_codigo")
	private Habitacion instalacionesCodigo;
	
	public Cama(){
		
	}

	public Cama(String codigo, int numero, boolean estado, String descripcion, Habitacion instalacionesCodigo) {
		super();
		this.codigo = codigo;
		this.numero = numero;
		this.estado = estado;
		this.descripcion = descripcion;
		this.instalacionesCodigo = instalacionesCodigo;
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
	 * @return the estado
	 */
	public boolean isEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(boolean estado) {
		this.estado = estado;
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

	/**
	 * @return the instalacionesCodigo
	 */
	public Instalacion getInstalacionesCodigo() {
		return instalacionesCodigo;
	}

	/**
	 * @param instalacionesCodigo the instalacionesCodigo to set
	 */
	public void setInstalacionesCodigo(Habitacion instalacionesCodigo) {
		this.instalacionesCodigo = instalacionesCodigo;
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
		Cama other = (Cama) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	
	
}
