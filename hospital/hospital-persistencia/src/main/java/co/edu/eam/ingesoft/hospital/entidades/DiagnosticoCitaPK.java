package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DiagnosticoCitaPK implements Serializable {
	
	@Column(name = "Cita_Codigo")
	private String citaCodigo;

	@Column(name = "Patologia_Codigo")
	private String patologiaCodigo;
	
	public DiagnosticoCitaPK(){
		
	}

	public DiagnosticoCitaPK(String citaCodigo, String patologiaCodigo) {
		super();
		this.citaCodigo = citaCodigo;
		this.patologiaCodigo = patologiaCodigo;
	}

	public String getCitaCodigo() {
		return citaCodigo;
	}

	public void setCitaCodigo(String citaCodigo) {
		this.citaCodigo = citaCodigo;
	}

	public String getPatologiaCodigo() {
		return patologiaCodigo;
	}

	public void setPatologiaCodigo(String patologiaCodigo) {
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
		DiagnosticoCitaPK other = (DiagnosticoCitaPK) obj;
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
