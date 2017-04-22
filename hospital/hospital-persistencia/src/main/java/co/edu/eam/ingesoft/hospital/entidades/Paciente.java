package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import co.edu.eam.ingesoft.hospital.enumeraciones.EstratoEnumeracion;

@Entity
@Table(name="PACIENTE")
@NamedQueries({
	@NamedQuery(name=Paciente.LISTAR,query= "Select c from Paciente c")
})
public class Paciente extends Usuario implements Serializable {
	
	public static final String LISTAR = "Paciente.lista";
	
	@Enumerated(EnumType.STRING)
	@Column(name = "estrato", nullable=false,length=20)
	private EstratoEnumeracion estrato;

	@ManyToOne
	@JoinColumn(name = "afiliación_codigo", nullable=false)
	private Afiliacion afiliacionCodigo;
	
	@Column(name = "Trabajo",length =50)
	private String trabajo;

	
	public Paciente(){
		super();
	}
	
	
	
	public Paciente(String cedula, String nickname, String clave, String nombre, String apellido, int edad,
			String correo, String tipoUsuario, String telefono, EstratoEnumeracion estrato, Afiliacion afiliacionCodigo,
			String trabajo) {
		super(cedula, nickname, clave, nombre, apellido, edad, correo, tipoUsuario, telefono);
		this.estrato = estrato;
		this.afiliacionCodigo = afiliacionCodigo;
		this.trabajo = trabajo;
	}



	public Paciente(EstratoEnumeracion estrato, Afiliacion afiliacionCodigo, String trabajo) {
		super();
		this.estrato = estrato;
		this.afiliacionCodigo = afiliacionCodigo;
		this.trabajo = trabajo;
	}

	public EstratoEnumeracion getEstrato() {
		return estrato;
	}


	public void setEstrato(EstratoEnumeracion estrato) {
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
