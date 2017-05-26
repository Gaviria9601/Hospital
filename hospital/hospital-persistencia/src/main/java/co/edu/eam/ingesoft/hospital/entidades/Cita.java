	package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CITA")
public class Cita implements Serializable {
	
    @Id
	@Column(name = "codigo")
	private int codigo;
    
    @Column(name = "observacion", length = 2000)
	private String observacion;
    
    @ManyToOne
	@JoinColumn(name = "paciente_cedula", nullable=false)
	private Paciente pacienteUsuarioCedula;
    
    @ManyToOne
    @JoinColumn(name = "medico_cedula", nullable=false)
    private Medico medicoUsuarioCedula;
    
    @ManyToOne
	@JoinColumn(name = "cita_codigo", nullable=true)
	private Cita citaCodigo;

    @JoinColumns({

		@JoinColumn(name = "medicoHorario", referencedColumnName = "medico_cedula"),
		@JoinColumn(name = "horarioCodigoTurno", referencedColumnName = "horario_codigo_turno"),
		@JoinColumn(name = "fecha", referencedColumnName = "fecha")})
@ManyToOne
private itemHorario horario;
    public Cita(){
    	super();
    }


	public Cita(int codigo, String observacion, Paciente pacienteUsuarioCedula,
			Medico medicoUsuarioCedula, Cita citaCodigo, itemHorario horario) {
		super();
		this.codigo = codigo;
		this.observacion = observacion;
		this.pacienteUsuarioCedula = pacienteUsuarioCedula;
		this.medicoUsuarioCedula = medicoUsuarioCedula;
		this.citaCodigo = citaCodigo;
		this.horario = horario;
	}


	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}


	public Paciente getPacienteUsuarioCedula() {
		return pacienteUsuarioCedula;
	}

	public void setPacienteUsuarioCedula(Paciente pacienteUsuarioCedula) {
		this.pacienteUsuarioCedula = pacienteUsuarioCedula;
	}

	public Cita getCitaCodigo() {
		return citaCodigo;
	}

	public void setCitaCodigo(Cita citaCodigo) {
		this.citaCodigo = citaCodigo;
	}

	public Medico getMedicoUsuarioCedula() {
		return medicoUsuarioCedula;
	}

	


	public void setMedicoUsuarioCedula(Medico medicoUsuarioCedula) {
		this.medicoUsuarioCedula = medicoUsuarioCedula;
	}

	/**
	 * @return the horario
	 */
	public itemHorario getHorario() {
		return horario;
	}


	/**
	 * @param horario the horario to set
	 */
	public void setHorario(itemHorario horario) {
		this.horario = horario;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((citaCodigo == null) ? 0 : citaCodigo.hashCode());
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
		Cita other = (Cita) obj;
		if (citaCodigo == null) {
			if (other.citaCodigo != null)
				return false;
		} else if (!citaCodigo.equals(other.citaCodigo))
			return false;
		return true;
	}
    
    

}
