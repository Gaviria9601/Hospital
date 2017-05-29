package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "OrdenExamen")
public class OrdenExamen extends OrdenProcedimiento implements Serializable {

	@ManyToOne
	@JoinColumn(name = "Examen_codigo")
	private Examen examen;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "hora_Final")
	private Date horaFinal;
	
	@Temporal(TemporalType.DATE)
	@Column(name= "fecha")
	private Date fecha;
	

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "hora_Inicio")
	private Date horaInicio;
	
	public OrdenExamen() {
		// TODO Auto-generated constructor stub
	}


	public OrdenExamen(Examen examen, Date horaFinal, Date fecha, Date horaInicio) {
		super();
		this.examen = examen;
		this.horaFinal = horaFinal;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
	}



	public Examen getExamen() {
		return examen;
	}

	public void setExamen(Examen examen) {
		this.examen = examen;
	}


	public Date getHoraFinal() {
		return horaFinal;
	}


	public void setHoraFinal(Date horaFinal) {
		this.horaFinal = horaFinal;
	}


	public Date getHoraInicio() {
		return horaInicio;
	}


	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}


	public Date getFecha() {
		return fecha;
	}



	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
}
