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
	
	//enumeracion
	@Column(name = "estrato", nullable=false,length=20)
	private String estrato;

	@ManyToOne
	@JoinColumn(name = "afiliación_codigo", nullable=false)
	private Afiliacion afiliacionCodigo;
	
	@Column(name = "Trabajo",length =50)
	private String trabajo;

	
	public Paciente(){
		super();
	}


	public Paciente(String estrato, Afiliacion afiliacionCodigo, String trabajo) {
		super();
		this.estrato = estrato;
		this.afiliacionCodigo = afiliacionCodigo;
		this.trabajo = trabajo;
	}





	public String getEstrato() {
		return estrato;
	}



	public void setEstrato(String estrato) {
		this.estrato = estrato;
	}



	public Afiliacion getAfiliacionCodigo() {
		return afiliacionCodigo;
	}


	public void setAfiliacionCodigo(Afiliacion afiliacionCodigo) {
		this.afiliacionCodigo = afiliacionCodigo;
	}



	public String getTrabajo() {
		return trabajo;
	}



	public void setTrabajo(String trabajo) {
		this.trabajo = trabajo;
	}


	
	
	
}
