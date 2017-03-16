package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OrdenMedicamentoPK implements Serializable {
	
	@Column(name = "Cita_Codigo")
	private String citaCodigo;

	@Column(name = "Medicamentos_Codigo")
	private String medicamentoCodigo;
	
	public OrdenMedicamentoPK() {
		// TODO Auto-generated constructor stub
	}

	public OrdenMedicamentoPK(String citaCodigo, String medicamentoCodigo) {
		super();
		this.citaCodigo = citaCodigo;
		this.medicamentoCodigo = medicamentoCodigo;
	}

	public String getCitaCodigo() {
		return citaCodigo;
	}

	public void setCitaCodigo(String citaCodigo) {
		this.citaCodigo = citaCodigo;
	}

	public String getMedicamentoCodigo() {
		return medicamentoCodigo;
	}

	public void setMedicamentoCodigo(String medicamentoCodigo) {
		this.medicamentoCodigo = medicamentoCodigo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((citaCodigo == null) ? 0 : citaCodigo.hashCode());
		result = prime * result + ((medicamentoCodigo == null) ? 0 : medicamentoCodigo.hashCode());
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
		if (medicamentoCodigo == null) {
			if (other.medicamentoCodigo != null)
				return false;
		} else if (!medicamentoCodigo.equals(other.medicamentoCodigo))
			return false;
		return true;
	}
	
	
	
}
