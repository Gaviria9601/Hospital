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
	@Column(name = "hora")
	private Date hora;
	
	public OrdenExamen() {
		// TODO Auto-generated constructor stub
	}

	public OrdenExamen(Examen examen, Date hora) {
		super();
		this.examen = examen;
		this.hora = hora;
	}

	public Examen getExamen() {
		return examen;
	}

	public void setExamen(Examen examen) {
		this.examen = examen;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}
	
	
	
}
