package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="FRAMACEUTICO")
public class Farmaceutico  extends Usuario implements Serializable {
	

	
	@Column(name = "Tarjeta_profesional", length =20)
	private String tarjetaProfesional;

	@Temporal(TemporalType.DATE)
	@Column(name = "Fecha_ingreso")
	private Date fechaIngreso;
	
	@ManyToOne
	@JoinColumn(name = "Farmacia_codigo", nullable=false)
	private Farmacia farmaciaCodigo;

    public Farmaceutico(){
    	super();
    	
    }

	public Farmaceutico(String tarjetaProfesional, Date fechaIngreso, Farmacia farmaciaCodigo) {
		super();
		this.tarjetaProfesional = tarjetaProfesional;
		this.fechaIngreso = fechaIngreso;
		this.farmaciaCodigo = farmaciaCodigo;
	}

	public String getTarjetaProfesional() {
		return tarjetaProfesional;
	}

	public void setTarjetaProfesional(String tarjetaProfesional) {
		this.tarjetaProfesional = tarjetaProfesional;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Farmacia getFarmaciaCodigo() {
		return farmaciaCodigo;
	}

	public void setFarmaciaCodigo(Farmacia farmaciaCodigo) {
		this.farmaciaCodigo = farmaciaCodigo;
	}
    
    
	
}
