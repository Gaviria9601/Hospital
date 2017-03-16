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
	
	@Column(name="descripcion", nullable=false, length=2000)
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name="instalaciones_codigo")
	private Instalacion instalaciones_codigo;
	
	public Cama(){
		super();
	}

	public Cama(String codigo, int numero, boolean estado, String descripcion, Instalacion instalaciones_codigo) {
		super();
		this.codigo = codigo;
		this.numero = numero;
		this.estado = estado;
		this.descripcion = descripcion;
		this.instalaciones_codigo = instalaciones_codigo;
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
	 * @return the instalaciones_codigo
	 */
	public Instalacion getInstalaciones_codigo() {
		return instalaciones_codigo;
	}

	/**
	 * @param instalaciones_codigo the instalaciones_codigo to set
	 */
	public void setInstalaciones_codigo(Instalacion instalaciones_codigo) {
		this.instalaciones_codigo = instalaciones_codigo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

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
