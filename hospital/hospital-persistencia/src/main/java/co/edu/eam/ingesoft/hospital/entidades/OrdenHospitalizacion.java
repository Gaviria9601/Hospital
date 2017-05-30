package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
	@NamedQuery(name = OrdenHospitalizacion.LISTAR_ORDEN_HOSPITALIZACION,query="select orden from OrdenHospitalizacion orden where orden.estado = true")
})
@Table(name = "OrdenHospitalizacion")
public class OrdenHospitalizacion extends OrdenProcedimiento implements Serializable {
	
	public static final String LISTAR_ORDEN_HOSPITALIZACION = "ListarOrdenHospitalizacion";

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="Hora_Inicio")
	private Date horaInicio;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="Hora_final")
	private Date horaFinal;
	
	
	@ManyToOne
	@JoinColumn(name="Hospitalizacion_Codigo")
	private Hospitalizacion hospitalizacion;
	
	@ManyToOne
	@JoinColumn(name = "Cama_Instalacion_Codigo")
	private Cama cama;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha")
	private Date fecha;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_final")
	private Date fechaFinal;
	
	
	public OrdenHospitalizacion() {
		// TODO Auto-generated constructor stub
	}

	
	public OrdenHospitalizacion(Date horaInicio, Date horaFinal, Hospitalizacion hospitalizacion, Cama cama, Date fecha,
			Date fechaFinal) {
		super();
		this.horaInicio = horaInicio;
		this.horaFinal = horaFinal;
		this.hospitalizacion = hospitalizacion;
		this.cama = cama;
		this.fecha = fecha;
		this.fechaFinal = fechaFinal;
	}

	public Date getHoraFinal() {
		return horaFinal;
	}


	public void setHoraFinal(Date horaFinal) {
		this.horaFinal = horaFinal;
	}


	public Date getFechaFinal() {
		return fechaFinal;
	}


	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
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
