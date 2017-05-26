package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;
import java.util.Date;

public class ItemHorarioPK implements Serializable {
	
	private String medicoUsuarioCedula;
	private int horarioCodigoTurno;
	private Date fecha;
	
	public ItemHorarioPK(){
		
	}

	public ItemHorarioPK(String medicoUsuarioCedula, int horarioCodigoTurno, Date fecha) {
		super();
		this.medicoUsuarioCedula = medicoUsuarioCedula;
		this.horarioCodigoTurno = horarioCodigoTurno;
		this.fecha = fecha;
	}



	public String getMedicoUsuarioCedula() {
		return medicoUsuarioCedula;
	}

	public void setMedicoUsuarioCedula(String medicoUsuarioCedula) {
		this.medicoUsuarioCedula = medicoUsuarioCedula;
	}

	public int getHorarioCodigoTurno() {
		return horarioCodigoTurno;
	}

	public void setHorarioCodigoTurno(int horarioCodigoTurno) {
		this.horarioCodigoTurno = horarioCodigoTurno;
	}

	
	
	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + horarioCodigoTurno;
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
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (horarioCodigoTurno != other.horarioCodigoTurno)
			return false;
		if (medicoUsuarioCedula == null) {
			if (other.medicoUsuarioCedula != null)
				return false;
		} else if (!medicoUsuarioCedula.equals(other.medicoUsuarioCedula))
			return false;
		return true;
	}

	
}
