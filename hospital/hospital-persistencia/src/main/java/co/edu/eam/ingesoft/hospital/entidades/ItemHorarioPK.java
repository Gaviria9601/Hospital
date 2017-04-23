package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;

public class ItemHorarioPK implements Serializable {
	
	private String medicoUsuarioCedula;
	private Integer horarioCodigoTurno;
	
	public ItemHorarioPK(){
		
	}

	public ItemHorarioPK(String medicoUsuarioCedula, Integer horarioCodigoTurno) {
		super();
		this.medicoUsuarioCedula = medicoUsuarioCedula;
		this.horarioCodigoTurno = horarioCodigoTurno;
	}

	public String getMedicoUsuarioCedula() {
		return medicoUsuarioCedula;
	}

	public void setMedicoUsuarioCedula(String medicoUsuarioCedula) {
		this.medicoUsuarioCedula = medicoUsuarioCedula;
	}

	public Integer getHorarioCodigoTurno() {
		return horarioCodigoTurno;
	}

	public void setHorarioCodigoTurno(Integer horarioCodigoTurno) {
		this.horarioCodigoTurno = horarioCodigoTurno;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((horarioCodigoTurno == null) ? 0 : horarioCodigoTurno.hashCode());
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
