package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;

public class ItemHorarioPK implements Serializable {
	
	private Medico medicoUsuarioCedula;
	private Horario horarioCodigoTurno;
	
	public ItemHorarioPK(){
		
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

	/**
	 * @return the horarioCodigoTurno
	 */
	public Horario getHorarioCodigoTurno() {
		return horarioCodigoTurno;
	}

	/**
	 * @param horarioCodigoTurno the horarioCodigoTurno to set
	 */
	public void setHorarioCodigoTurno(Horario horarioCodigoTurno) {
		this.horarioCodigoTurno = horarioCodigoTurno;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((horarioCodigoTurno == null) ? 0 : horarioCodigoTurno.hashCode());
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
		ItemHorarioPK other = (ItemHorarioPK) obj;
		if (horarioCodigoTurno == null) {
			if (other.horarioCodigoTurno != null)
				return false;
		} else if (!horarioCodigoTurno.equals(other.horarioCodigoTurno))
			return false;
		if (medicoUsuarioCedula == null) {
			if (other.medicoUsuarioCedula != null)
				return false;
		} else if (!medicoUsuarioCedula.equals(other.medicoUsuarioCedula))
			return false;
		return true;
	}
	
	

}
