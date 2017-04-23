/**
 * 
 */
package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Alejandro Ortega
 *
 */
@Entity
@Table(name="Item_medico")
@IdClass(ItemMedicoPk.class)
public class itemMedico implements Serializable{
	
	@Id
	@ManyToOne 
	@JoinColumn(name="especializacion_codigo")
	private Especializacion especializacionCodigo;
	
	@Id
	@ManyToOne
	@JoinColumn(name="medico_Cedula")
	private Medico medicoUsuarioCedula;
	
	public itemMedico(){
		
	}

	
	
	public itemMedico(Especializacion especializacionCodigo, Medico medicoUsuarioCedula) {
		super();
		this.especializacionCodigo = especializacionCodigo;
		this.medicoUsuarioCedula = medicoUsuarioCedula;
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
		itemMedico other = (itemMedico) obj;
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
