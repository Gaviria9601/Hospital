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
	

	
	@Column(name = "tarjeta_profesional", length =20)
	private String tarjeta_profesional;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_ingreso")
	private Date fecha_ingreso;
	
	@ManyToOne
	@JoinColumn(name = "farmacia_codigo", nullable=false)
	private Farmacia farmacia_codigo;


	public Farmaceutico(){
		super();
	}
	
	
	public Farmaceutico(String tarjeta_profesional, Date fecha_ingreso, Farmacia farmacia_codigo) {
		super();
		this.tarjeta_profesional = tarjeta_profesional;
		this.fecha_ingreso = fecha_ingreso;
		this.farmacia_codigo = farmacia_codigo;
	}


	public String getTarjeta_profesional() {
		return tarjeta_profesional;
	}

	public void setTarjeta_profesional(String tarjeta_profesional) {
		this.tarjeta_profesional = tarjeta_profesional;
	}

	public Date getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(Date fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}

	public Farmacia getFarmacia_codigo() {
		return farmacia_codigo;
	}

	public void setFarmacia_codigo(Farmacia farmacia_codigo) {
		this.farmacia_codigo = farmacia_codigo;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((farmacia_codigo == null) ? 0 : farmacia_codigo.hashCode());
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
		Farmaceutico other = (Farmaceutico) obj;
		if (farmacia_codigo == null) {
			if (other.farmacia_codigo != null)
				return false;
		} else if (!farmacia_codigo.equals(other.farmacia_codigo))
			return false;
		return true;
	}
	
	

}
