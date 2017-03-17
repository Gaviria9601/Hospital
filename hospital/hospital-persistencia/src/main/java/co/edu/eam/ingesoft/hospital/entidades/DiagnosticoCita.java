package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DIAGNOSTICOCITA")
@IdClass(DiagnosticoCitaPK.class)
public class DiagnosticoCita implements Serializable {

	@Id
	@ManyToOne
	@JoinColumn(name = "cita_codigo", nullable = false)
	private Cita citaCodigo;

	@Id
	@ManyToOne
	@JoinColumn(name = "patologia_codigo", nullable = false)
	private Patologia patologiaCodigo;

	public DiagnosticoCita() {
		super();
	}

	public DiagnosticoCita(Cita cita_codigo, Patologia patologiaCodigo) {
		super();
		this.citaCodigo = cita_codigo;
		this.patologiaCodigo = patologiaCodigo;
	}

	public Cita getCitaCodigo() {
		return citaCodigo;
	}

	public void setCitaCodigo(Cita cita_codigo) {
		this.citaCodigo = cita_codigo;
	}

	public Patologia getPatologiaCodigo() {
		return patologiaCodigo;
	}

	public void setPatologiaCodigo(Patologia patologiaCodigo) {
		this.patologiaCodigo = patologiaCodigo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((citaCodigo == null) ? 0 : citaCodigo.hashCode());
		result = prime * result + ((patologiaCodigo == null) ? 0 : patologiaCodigo.hashCode());
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
		DiagnosticoCita other = (DiagnosticoCita) obj;
		if (citaCodigo == null) {
			if (other.citaCodigo != null)
				return false;
		} else if (!citaCodigo.equals(other.citaCodigo))
			return false;
		if (patologiaCodigo == null) {
			if (other.patologiaCodigo != null)
				return false;
		} else if (!patologiaCodigo.equals(other.patologiaCodigo))
			return false;
		return true;
	}

	
	
}
