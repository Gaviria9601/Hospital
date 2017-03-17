package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CITA")
public class Cita implements Serializable {
	
    @Id
	@Column(name = "codigo", length = 20)
	private String codigo;
    
    @Temporal(TemporalType.DATE)
	@Column(name = "fecha", nullable=false)
	private Date fecha;
    
    @Temporal(TemporalType.TIMESTAMP)
	@Column(name = "hora_inicio", nullable=false)
	private Date horaInicio;
    
    @Column(name = "observacion", length = 2000)
	private String observacion;
    
    @Temporal(TemporalType.TIMESTAMP)
	@Column(name = "hora_final", nullable=false)
	private Date horaFinal;
    
    @ManyToOne
	@JoinColumn(name = "paciente_usuario_cedula", nullable=false)
	private Paciente pacienteUsuarioCedula;
    
    
    @ManyToOne
	@JoinColumn(name = "cita_codigo", nullable=false)
	private Cita citaCodigo;

    public Cita(){
    	super();
    }

	public Cita(String codigo, Date fecha, Date horaInicio, String observacion, Date horaFinal,
			Paciente pacienteUsuarioCedula, Cita citaCodigo) {
		super();
		this.codigo = codigo;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.observacion = observacion;
		this.horaFinal = horaFinal;
		this.pacienteUsuarioCedula = pacienteUsuarioCedula;
		this.citaCodigo = citaCodigo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Date getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(Date horaFinal) {
		this.horaFinal = horaFinal;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((citaCodigo == null) ? 0 : citaCodigo.hashCode());
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
		Cita other = (Cita) obj;
		if (citaCodigo == null) {
			if (other.citaCodigo != null)
				return false;
		} else if (!citaCodigo.equals(other.citaCodigo))
			return false;
		return true;
	}
    
    

}
