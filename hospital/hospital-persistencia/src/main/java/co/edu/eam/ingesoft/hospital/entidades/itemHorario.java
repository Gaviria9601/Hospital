/**
 * 
 */
package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Alejandro Ortega
 *
 */
@Entity
@Table(name="item_horario")
@IdClass(ItemHorarioPK.class)
public class itemHorario implements Serializable{
	
	@Id
	@ManyToOne
	@JoinColumn(name="medico_usuario_cedula", nullable= false)
	private Medico medicoUsuarioCedula;
	
	@Id
	@ManyToOne
	@JoinColumn(name="horario_codigo_turno", nullable= false)
	private Horario horarioCodigoTurno;
	
	@Temporal(TemporalType.TIME)
	@Column(name="fecha", nullable=false)
	private Date fecha;
	
	public itemHorario(){
		
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
		itemHorario other = (itemHorario) obj;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
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