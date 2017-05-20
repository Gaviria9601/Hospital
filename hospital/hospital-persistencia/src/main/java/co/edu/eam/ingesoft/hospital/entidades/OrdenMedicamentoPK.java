package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

public class OrdenMedicamentoPK implements Serializable {
	
	private int citaCodigo;

	private int medicamentosCodigo;
	
	public OrdenMedicamentoPK() {
		// TODO Auto-generated constructor stub
	}

	public OrdenMedicamentoPK(int citaCodigo, int medicamentosCodigo) {
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
		result = prime * result + citaCodigo;
		result = prime * result + medicamentosCodigo;
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
		if (citaCodigo != other.citaCodigo)
			return false;
		if (medicamentosCodigo != other.medicamentosCodigo)
			return false;
		return true;
	}

	

	
	
}
