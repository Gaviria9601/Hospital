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
	@JoinColumn(name="medico_cedula")
	private Medico medicoUsuarioCedula;
	
	@Id
	@ManyToOne
	@JoinColumn(name="horario_codigo_turno")
	private Horario horarioCodigoTurno;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha", nullable=false)
	private Date fecha;
	
	@Column(name = "estado")
	private boolean estado;
	
	public itemHorario(){
		
	}
	
	public itemHorario(Medico medicoUsuarioCedula, Horario horarioCodigoTurno, Date fecha, boolean estado) {
		super();
		this.medicoUsuarioCedula = medicoUsuarioCedula;
		this.horarioCodigoTurno = horarioCodigoTurno;
		this.fecha = fecha;
		this.estado = estado;
	}





	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
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
		itemHorario other = (itemHorario) obj;
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
