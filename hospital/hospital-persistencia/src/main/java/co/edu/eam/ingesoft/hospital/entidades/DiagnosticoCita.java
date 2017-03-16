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
	private Patologia patologia_codigo;

	public DiagnosticoCita() {
		super();
	}

	public DiagnosticoCita(DiagnosticoCitaPK diagnosticoCitaPK) {
		this.diagnosticoCitaPK = diagnosticoCitaPK;
	}

	public DiagnosticoCita(String citaCodigo, String patologiaCodigo) {
		this.diagnosticoCitaPK = new DiagnosticoCitaPK(citaCodigo, patologiaCodigo);
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

	public Patologia getPatologia_codigo() {
		return patologia_codigo;
	}

	public void setPatologia_codigo(Patologia patologia_codigo) {
		this.patologia_codigo = patologia_codigo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cita_codigo == null) ? 0 : cita_codigo.hashCode());
		result = prime * result + ((patologia_codigo == null) ? 0 : patologia_codigo.hashCode());
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
		if (cita_codigo == null) {
			if (other.cita_codigo != null)
				return false;
		} else if (!cita_codigo.equals(other.cita_codigo))
			return false;
		if (patologia_codigo == null) {
			if (other.patologia_codigo != null)
				return false;
		} else if (!patologia_codigo.equals(other.patologia_codigo))
			return false;
		return true;
	}

}
