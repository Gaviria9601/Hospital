package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

public class OrdenMedicamentoPK implements Serializable {
	
	private String citaCodigo;

	private String medicamentosCodigo;
	
	public OrdenMedicamentoPK() {
		// TODO Auto-generated constructor stub
	}

	public OrdenMedicamentoPK(String citaCodigo, String medicamentosCodigo) {
		super();
		this.citaCodigo = citaCodigo;
		this.medicamentosCodigo = medicamentosCodigo;
	}

	public String getCitaCodigo() {
		return citaCodigo;
	}

	public void setCitaCodigo(String citaCodigo) {
		this.citaCodigo = citaCodigo;
	}

	public String getMedicamentosCodigo() {
		return medicamentosCodigo;
	}

	public void setMedicamentosCodigo(String medicamentosCodigo) {
		this.medicamentosCodigo = medicamentosCodigo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((citaCodigo == null) ? 0 : citaCodigo.hashCode());
		result = prime * result + ((medicamentosCodigo == null) ? 0 : medicamentosCodigo.hashCode());
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
		OrdenMedicamentoPK other = (OrdenMedicamentoPK) obj;
		if (citaCodigo == null) {
			if (other.citaCodigo != null)
				return false;
		} else if (!citaCodigo.equals(other.citaCodigo))
			return false;
		if (medicamentosCodigo == null) {
			if (other.medicamentosCodigo != null)
				return false;
		} else if (!medicamentosCodigo.equals(other.medicamentosCodigo))
			return false;
		return true;
	}

	
	
}
