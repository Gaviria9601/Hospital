package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

public class DiagnosticoCitaPK implements Serializable {
	
	
	private int citaCodigo;

	private int patologiaCodigo;
	
	public DiagnosticoCitaPK(){
		
	}

	public DiagnosticoCitaPK(int citaCodigo, int patologiaCodigo) {
		super();
		this.citaCodigo = citaCodigo;
		this.patologiaCodigo = patologiaCodigo;
	}

	public int getCitaCodigo() {
		return citaCodigo;
	}

	public void setCitaCodigo(int citaCodigo) {
		this.citaCodigo = citaCodigo;
	}

	public int getPatologiaCodigo() {
		return patologiaCodigo;
	}

	public void setPatologiaCodigo(int patologiaCodigo) {
		this.patologiaCodigo = patologiaCodigo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + citaCodigo;
		result = prime * result + patologiaCodigo;
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
		DiagnosticoCitaPK other = (DiagnosticoCitaPK) obj;
		if (citaCodigo != other.citaCodigo)
			return false;
		if (patologiaCodigo != other.patologiaCodigo)
			return false;
		return true;
	}


	
	
}
