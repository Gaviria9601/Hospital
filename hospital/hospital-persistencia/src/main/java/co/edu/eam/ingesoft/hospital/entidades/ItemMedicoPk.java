package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;

public class ItemMedicoPk implements Serializable {
	
	private String especializacionCodigo;
	private String medicoUsuarioCedula;
	
	public ItemMedicoPk(){
		
	}

	public ItemMedicoPk(String especializacionCodigo, String medicoUsuarioCedula) {
		super();
		this.especializacionCodigo = especializacionCodigo;
		this.medicoUsuarioCedula = medicoUsuarioCedula;
	}

	public String getEspecializacionCodigo() {
		return especializacionCodigo;
	}

	public void setEspecializacionCodigo(String especializacionCodigo) {
		this.especializacionCodigo = especializacionCodigo;
	}

	public String getMedicoUsuarioCedula() {
		return medicoUsuarioCedula;
	}

	public void setMedicoUsuarioCedula(String medicoUsuarioCedula) {
		this.medicoUsuarioCedula = medicoUsuarioCedula;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((especializacionCodigo == null) ? 0 : especializacionCodigo.hashCode());
		result = prime * result + ((medicoUsuarioCedula == null) ? 0 : medicoUsuarioCedula.hashCode());
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
		ItemMedicoPk other = (ItemMedicoPk) obj;
		if (especializacionCodigo == null) {
			if (other.especializacionCodigo != null)
				return false;
		} else if (!especializacionCodigo.equals(other.especializacionCodigo))
			return false;
		if (medicoUsuarioCedula == null) {
			if (other.medicoUsuarioCedula != null)
				return false;
		} else if (!medicoUsuarioCedula.equals(other.medicoUsuarioCedula))
			return false;
		return true;
	}

	

}
