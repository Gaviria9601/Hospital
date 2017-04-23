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
@Table(name = "OrdenCirugia")
public class OrdenCirugia extends OrdenProcedimiento implements Serializable {

	@ManyToOne
	@JoinColumn(name = "Cirugia_codigo")
	private Cirugia cirugia;
	
	@ManyToOne
	@JoinColumn(name = "Medico")
	private Medico medico;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "horaInicio")
	private Date horaInicio;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "horaFinal")
	private Date horaFinal;
	
	@ManyToOne
	@JoinColumn(name="Quirofanoo_Instalacion_Codigo")
	private Quirofano quirofano;
	
	public OrdenCirugia() {
		// TODO Auto-generated constructor stub
	}

	public OrdenCirugia(Cirugia cirugia, Medico medico, Date horaInicio, Date horaFinal, Quirofano quirofano) {
		super();
		this.cirugia = cirugia;
		this.medico = medico;
		this.horaInicio = horaInicio;
		this.horaFinal = horaFinal;
		this.quirofano = quirofano;
	}

	public Cirugia getCirugia() {
		return cirugia;
	}

	public void setCirugia(Cirugia cirugia) {
		this.cirugia = cirugia;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Date getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Date getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(Date horaFinal) {
		this.horaFinal = horaFinal;
	}

	public Quirofano getQuirofano() {
		return quirofano;
	}

	public void setQuirofano(Quirofano quirofano) {
		this.quirofano = quirofano;
	}
	
	
	
	
	
}
