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
	@Column(name="codigo_turno", nullable=false, length=10)
	private String codigo_turno;
	
	@Column(name="jornada", nullable=false, length=30)
	private String jornada;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="hora_inicio", nullable=false)
	private Date hora_inicio;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="hora_final", nullable=false)
	private Date hora_final;
	
	public Horario(){
		super();
	}

	public Horario(String codigo_turno, String jornada, Date hora_inicio, Date hora_final) {
		super();
		this.codigo_turno = codigo_turno;
		this.jornada = jornada;
		this.hora_inicio = hora_inicio;
		this.hora_final = hora_final;
	}



	/**
	 * @return the codigo_turno
	 */
	public String getCodigo_turno() {
		return codigo_turno;
	}

	/**
	 * @param codigo_turno the codigo_turno to set
	 */
	public void setCodigo_turno(String codigo_turno) {
		this.codigo_turno = codigo_turno;
	}

	/**
	 * @return the jornada
	 */
	public String getJornada() {
		return jornada;
	}

	/**
	 * @param jornada the jornada to set
	 */
	public void setJornada(String jornada) {
		this.jornada = jornada;
	}

	/**
	 * @return the hora_inicio
	 */
	public Date getHora_inicio() {
		return hora_inicio;
	}

	/**
	 * @param hora_inicio the hora_inicio to set
	 */
	public void setHora_inicio(Date hora_inicio) {
		this.hora_inicio = hora_inicio;
	}

	/**
	 * @return the hora_final
	 */
	public Date getHora_final() {
		return hora_final;
	}

	/**
	 * @param hora_final the hora_final to set
	 */
	public void setHora_final(Date hora_final) {
		this.hora_final = hora_final;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo_turno == null) ? 0 : codigo_turno.hashCode());
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
		Horario other = (Horario) obj;
		if (codigo_turno == null) {
			if (other.codigo_turno != null)
				return false;
		} else if (!codigo_turno.equals(other.codigo_turno))
			return false;
		return true;
	}

	
}
