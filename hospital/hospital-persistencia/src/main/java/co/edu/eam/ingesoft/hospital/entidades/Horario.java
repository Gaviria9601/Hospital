/**
 * 
 */
package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Alejandro Ortega
 *
 */
@Entity
@Table(name="Horario")
public class Horario implements Serializable{

	@Id
	@Column(name="codigo_turno")
	private Integer codigoTurno;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="hora_inicio", nullable=false)
	private Date horaInicio;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="hora_final", nullable=false)
	private Date horaFinal;
	
	public Horario(){
		
	}

	public Horario(Integer codigoTurno,Date horaInicio, Date horaFinal) {
		super();
		this.codigoTurno = codigoTurno;
		this.horaInicio = horaInicio;
		this.horaFinal = horaFinal;
	}



	/**
	 * @return the codigoTurno
	 */
	public Integer getCodigoTurno() {
		return codigoTurno;
	}

	/**
	 * @param codigoTurno the codigoTurno to set
	 */
	public void setCodigoTurno(Integer codigoTurno) {
		this.codigoTurno = codigoTurno;
	}


	/**
	 * @return the horaInicio
	 */
	public Date getHoraInicio() {
		return horaInicio;
	}

	/**
	 * @param horaInicio the horaInicio to set
	 */
	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	/**
	 * @return the horaFinal
	 */
	public Date getHoraFinal() {
		return horaFinal;
	}

	/**
	 * @param horaFinal the horaFinal to set
	 */
	public void setHoraFinal(Date horaFinal) {
		this.horaFinal = horaFinal;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoTurno == null) ? 0 : codigoTurno.hashCode());
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
		Horario other = (Horario) obj;
		if (codigoTurno == null) {
			if (other.codigoTurno != null)
				return false;
		} else if (!codigoTurno.equals(other.codigoTurno))
			return false;
		return true;
	}

	

	
	
}
