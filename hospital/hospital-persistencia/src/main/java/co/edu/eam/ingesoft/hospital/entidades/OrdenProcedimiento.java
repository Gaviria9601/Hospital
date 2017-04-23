/**
 * 
 */
package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Alejandro Ortega
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name = "OrdenProcedimiento")
public class OrdenProcedimiento implements Serializable {

	@Id
	@Column(name = "codigo")
	private Integer codigo;

	@Column(name="observaciones")
	private String observaciones;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha", nullable = false)
	private Date fecha;

	@Column(name = "estado")
	private boolean estado;
	
	@ManyToOne
	@JoinColumn(name = "cita_codigo", nullable = false)
	private Cita citaCodigo;


	public OrdenProcedimiento() {

	}

	public OrdenProcedimiento(Integer codigo, String observaciones, Date fecha, boolean estado, Cita citaCodigo) {
		super();
		this.codigo = codigo;
		this.observaciones = observaciones;
		this.fecha = fecha;
		this.estado = estado;
		this.citaCodigo = citaCodigo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Cita getCitaCodigo() {
		return citaCodigo;
	}

	public void setCitaCodigo(Cita citaCodigo) {
		this.citaCodigo = citaCodigo;
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
		OrdenProcedimiento other = (OrdenProcedimiento) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	

	
}
