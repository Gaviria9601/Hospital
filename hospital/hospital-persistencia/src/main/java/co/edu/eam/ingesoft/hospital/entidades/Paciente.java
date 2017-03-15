package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="PACIENTE")
public class Paciente extends Usuario implements Serializable {
	
	
	
	@Column(name = "estrato")
	private int estrato;


	@ManyToOne
	@JoinColumn(name = "afiliacion_codigo", nullable=false)
	private Afiliacion afiliacion_codigo;


	public int getEstrato() {
		return estrato;
	}


	public void setEstrato(int estrato) {
		this.estrato = estrato;
	}


	public Afiliacion getAfiliacion_codigo() {
		return afiliacion_codigo;
	}


	public void setAfiliacion_codigo(Afiliacion afiliacion_codigo) {
		this.afiliacion_codigo = afiliacion_codigo;
	}


	public Paciente(int estrato, Afiliacion afiliacion_codigo) {
		super();
		
		this.estrato = estrato;
		this.afiliacion_codigo = afiliacion_codigo;
	}
	
	public Paciente(){
		super();
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((afiliacion_codigo == null) ? 0 : afiliacion_codigo.hashCode());
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
		Paciente other = (Paciente) obj;
		if (afiliacion_codigo == null) {
			if (other.afiliacion_codigo != null)
				return false;
		} else if (!afiliacion_codigo.equals(other.afiliacion_codigo))
			return false;
		return true;
	}
	
}
