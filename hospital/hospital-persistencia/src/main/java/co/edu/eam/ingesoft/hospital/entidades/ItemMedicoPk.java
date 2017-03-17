package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;

public class ItemMedicoPk implements Serializable {
	
	private Especializacion especializacionCodigo;
	private Medico medicoUsuarioCedula;
	
	public ItemMedicoPk(){
		
	}

	/**
	 * @return the especializacionCodigo
	 */
	public Especializacion getEspecializacionCodigo() {
		return especializacionCodigo;
	}

	/**
	 * @param especializacionCodigo the especializacionCodigo to set
	 */
	public void setEspecializacionCodigo(Especializacion especializacionCodigo) {
		this.especializacionCodigo = especializacionCodigo;
	}

	/**
	 * @return the medicoUsuarioCedula
	 */
	public Medico getMedicoUsuarioCedula() {
		return medicoUsuarioCedula;
	}

	/**
	 * @param medicoUsuarioCedula the medicoUsuarioCedula to set
	 */
	public void setMedicoUsuarioCedula(Medico medicoUsuarioCedula) {
		this.medicoUsuarioCedula = medicoUsuarioCedula;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((especializacionCodigo == null) ? 0 : especializacionCodigo.hashCode());
		result = prime * result + ((medicoUsuarioCedula == null) ? 0 : medicoUsuarioCedula.hashCode());
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
