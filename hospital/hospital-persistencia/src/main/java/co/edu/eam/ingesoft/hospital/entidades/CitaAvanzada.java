/**
 * 
 */
package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * @author Alejandro Ortega
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="CitaAvanzada")
public class CitaAvanzada implements Serializable {


	@Id
	@Column(name="codigo", nullable=false, length=10)
	protected String codigo;
	
	@Column(name="nombre", nullable=false, length=20)
	protected String nombre;
	
	@Column(name="observaciones", nullable=false, length=1000)
	protected String observaciones;
	
	@Column(name="tiempoEstimado", nullable=false, length=50)
	protected String tiempoEstimado;
	
	public CitaAvanzada(){
		
	}

	
		
	public CitaAvanzada(String codigo, String nombre, String observaciones, String tiempoEstimado) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.observaciones = observaciones;
		this.tiempoEstimado = tiempoEstimado;
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
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the observaciones
	 */
	public String getObservaciones() {
		return observaciones;
	}

	/**
	 * @param observaciones the observaciones to set
	 */
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	/**
	 * @return the tiempoEstimado
	 */
	public String getTiempoEstimado() {
		return tiempoEstimado;
	}

	/**
	 * @param tiempoEstimado the tiempoEstimado to set
	 */
	public void setTiempoEstimado(String tiempoEstimado) {
		this.tiempoEstimado = tiempoEstimado;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((observaciones == null) ? 0 : observaciones.hashCode());
		result = prime * result + ((tiempoEstimado == null) ? 0 : tiempoEstimado.hashCode());
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
		CitaAvanzada other = (CitaAvanzada) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (observaciones == null) {
			if (other.observaciones != null)
				return false;
		} else if (!observaciones.equals(other.observaciones))
			return false;
		if (tiempoEstimado == null) {
			if (other.tiempoEstimado != null)
				return false;
		} else if (!tiempoEstimado.equals(other.tiempoEstimado))
			return false;
		return true;
	}
		
	
	
}
