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
@Table(name = "OrdenHospitalizacion")
public class OrdenHospitalizacion extends OrdenProcedimiento implements Serializable {

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="Hora_Inicio")
	private Date horaInicio;
	
	@ManyToOne
	@JoinColumn(name="Hospitalizacion_Codigo")
	private Hospitalizacion hospitalizacion;
	
	@ManyToOne
	@JoinColumn(name = "Cama_Instalacion_Codigo")
	private Cama cama;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha")
	private Date fecha;
	
	
	public OrdenHospitalizacion() {
		// TODO Auto-generated constructor stub
	}


	public OrdenHospitalizacion(Date horaInicio, Hospitalizacion hospitalizacion, Cama cama, Date fecha) {
		super();
		this.horaInicio = horaInicio;
		this.hospitalizacion = hospitalizacion;
		this.cama = cama;
		this.fecha = fecha;
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

	public Hospitalizacion getHospitalizacion() {
		return hospitalizacion;
	}

	public void setHospitalizacion(Hospitalizacion hospitalizacion) {
		this.hospitalizacion = hospitalizacion;
	}

	public Cama getCama() {
		return cama;
	}

	public void setCama(Cama cama) {
		this.cama = cama;
	}
	
	
	
}
