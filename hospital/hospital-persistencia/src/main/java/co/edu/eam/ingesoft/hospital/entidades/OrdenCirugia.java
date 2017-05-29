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
	@NamedQuery(name=OrdenCirugia.LISTAR_CIRUGIAS_MEDICO,query="select orden from OrdenCirugia orden where orden.medico.cedula=?1")
})
@Table(name = "OrdenCirugia")
public class OrdenCirugia extends OrdenProcedimiento implements Serializable {

	public static final String LISTAR_CIRUGIAS_MEDICO = "ListarCirugiasMedico";
	
	@ManyToOne
	@JoinColumn(name = "Cirugia_codigo")
	private Cirugia cirugia;
	
	@ManyToOne
	@JoinColumn(name = "Medico_Cedula")
	private Medico medico;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "horaInicio")
	private Date horaInicio;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "horaFinal")
	private Date horaFinal;
	
	@ManyToOne
	@JoinColumn(name="codigoInstalacion")
	private Quirofano quirofano;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha")
	private Date fecha;
	
	public OrdenCirugia() {
		// TODO Auto-generated constructor stub
	}


	public OrdenCirugia(Cirugia cirugia, Medico medico, Date horaInicio, Date horaFinal, Quirofano quirofano,
			Date fecha) {
		super();
		this.cirugia = cirugia;
		this.medico = medico;
		this.horaInicio = horaInicio;
		this.horaFinal = horaFinal;
		this.quirofano = quirofano;
		this.fecha = fecha;
	}

	


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
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
