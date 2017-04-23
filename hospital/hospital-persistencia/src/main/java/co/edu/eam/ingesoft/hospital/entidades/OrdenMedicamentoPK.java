package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

public class OrdenMedicamentoPK implements Serializable {
	
	private Integer citaCodigo;

	private Integer medicamentosCodigo;
	
	public OrdenMedicamentoPK() {
		// TODO Auto-generated constructor stub
	}

	public OrdenMedicamentoPK(Integer citaCodigo, Integer medicamentosCodigo) {
		super();
		this.citaCodigo = citaCodigo;
		this.medicamentosCodigo = medicamentosCodigo;
	}

	
	
	public Integer getCitaCodigo() {
		return citaCodigo;
	}

	public void setCitaCodigo(Integer citaCodigo) {
		this.citaCodigo = citaCodigo;
	}

	public Integer getMedicamentosCodigo() {
		return medicamentosCodigo;
	}

	public void setMedicamentosCodigo(Integer medicamentosCodigo) {
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
