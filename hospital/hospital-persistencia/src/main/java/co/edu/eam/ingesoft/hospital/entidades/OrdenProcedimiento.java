/**
 * 
 */
package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
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
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequenceee")
	@SequenceGenerator(name = "id_Sequenceee", sequenceName = "SEQ_ORDEN_PROCEDIMIENTO",allocationSize=1)
	@Column(name = "codigo")
	private Integer codigo;

	@Column(name="observaciones")
	private String observaciones;

	@Column(name = "estado")
	private boolean estado;
	
	@ManyToOne
	@JoinColumn(name = "cita_codigo", nullable = false)
	private Cita citaCodigo;


	public OrdenProcedimiento() {

	}

	public OrdenProcedimiento(Integer codigo, String observaciones,boolean estado, Cita citaCodigo) {
		super();
		this.codigo = codigo;
		this.observaciones = observaciones;
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
