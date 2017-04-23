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
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name="CitaAvanzada")
public class CitaAvanzada implements Serializable {


	@Id
	@Column(name="codigo")
	protected Integer codigo;
	
	@Column(name="nombre", nullable=false, length=20)
	protected String nombre;
	
	@Column(name="observaciones", nullable=false, length=1000)
	protected String observaciones;
	
	@Column(name="tiempoEstimado", nullable=false, length=50)
	protected String tiempoEstimado;
	
	@Column(name = "tipo")
	protected String tipo;
	
	public CitaAvanzada(){
		
	}

	public CitaAvanzada(Integer codigo, String nombre, String observaciones, String tiempoEstimado, String tipo) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.observaciones = observaciones;
		this.tiempoEstimado = tiempoEstimado;
		this.tipo = tipo;
	}


	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the codigo
	 */
	public Integer getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(Integer codigo) {
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
		CitaAvanzada other = (CitaAvanzada) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	
}
