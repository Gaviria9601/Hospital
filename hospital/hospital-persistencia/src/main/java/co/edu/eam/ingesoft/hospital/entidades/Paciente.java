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
	
	@Column(name = "estrato", nullable=false)
	private int estrato;

	@ManyToOne
	@JoinColumn(name = "afiliacion_codigo", nullable=false)
	private Afiliacion afiliacionCodigo;
	
	@Column(name = "Trabajo",length =50)
	private int trabajo;

	
	public Paciente(){
		super();
	}


	public Paciente(int estrato, Afiliacion afiliacionCodigo, int trabajo) {
		super();
		this.estrato = estrato;
		this.afiliacionCodigo = afiliacionCodigo;
		this.trabajo = trabajo;
	}


	public int getEstrato() {
		return estrato;
	}


	public void setEstrato(int estrato) {
		this.estrato = estrato;
	}


	public Afiliacion getAfiliacionCodigo() {
		return afiliacionCodigo;
	}


	public void setAfiliacionCodigo(Afiliacion afiliacionCodigo) {
		this.afiliacionCodigo = afiliacionCodigo;
	}


	public int getTrabajo() {
		return trabajo;
	}


	public void setTrabajo(int trabajo) {
		this.trabajo = trabajo;
	}

	
	
	
}
