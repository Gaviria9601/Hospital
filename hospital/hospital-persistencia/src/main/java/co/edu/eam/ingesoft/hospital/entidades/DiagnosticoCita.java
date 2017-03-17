package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DIAGNOSTICOCITA")
public class DiagnosticoCita implements Serializable {

	@EmbeddedId
	protected DiagnosticoCitaPK diagnosticoCitaPK;

	@ManyToOne
	@JoinColumn(name = "cita_codigo", nullable = false)
	private Cita cita_codigo;

	@ManyToOne
	@JoinColumn(name = "patologia_codigo", nullable = false)
	private Patologia patologiaCodigo;

	public DiagnosticoCita() {
		super();
	}

	public DiagnosticoCita(DiagnosticoCitaPK diagnosticoCitaPK, Cita cita_codigo, Patologia patologiaCodigo) {
		super();
		this.diagnosticoCitaPK = diagnosticoCitaPK;
		this.cita_codigo = cita_codigo;
		this.patologiaCodigo = patologiaCodigo;
	}

	public DiagnosticoCitaPK getDiagnosticoCitaPK() {
		return diagnosticoCitaPK;
	}

	public void setDiagnosticoCitaPK(DiagnosticoCitaPK diagnosticoCitaPK) {
		this.diagnosticoCitaPK = diagnosticoCitaPK;
	}

	public Cita getCita_codigo() {
		return cita_codigo;
	}

	public void setCita_codigo(Cita cita_codigo) {
		this.cita_codigo = cita_codigo;
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
		result = prime * result + ((diagnosticoCitaPK == null) ? 0 : diagnosticoCitaPK.hashCode());
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
		if (diagnosticoCitaPK == null) {
			if (other.diagnosticoCitaPK != null)
				return false;
		} else if (!diagnosticoCitaPK.equals(other.diagnosticoCitaPK))
			return false;
		if (patologiaCodigo == null) {
			if (other.patologiaCodigo != null)
				return false;
		} else if (!patologiaCodigo.equals(other.patologiaCodigo))
			return false;
		return true;
	}

	
}
