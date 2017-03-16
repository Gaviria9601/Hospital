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

	
	public Paciente(){
		super();
	}

	
	public Paciente(int estrato, Afiliacion afiliacion_codigo) {
		super();
		
		this.estrato = estrato;
		this.afiliacion_codigo = afiliacion_codigo;
	}


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


	
}
