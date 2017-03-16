package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="USUARIO")
@Inheritance(strategy=InheritanceType.JOINED)
public class Usuario implements Serializable {
	
	@Id
	@Column(name="cedula",length=20)
	protected String cedula;
	
	@Column(name = "nicknme", length =30)
	protected String nickname;
	
	@Column(name = "clave", length =20)
	protected String clave;
	
	@Column(name = "nombre", length = 30)
	protected String nombre;
	
	@Column(name = "apellido", length = 50)
	protected String apellido;
	
	@Column(name = "edad")
	protected int edad;
	
	@Column(name = "correo", length =100)
	protected String correo;
	
	@Column(name = "tipoUsuario", length =30)
	protected String tipoUsuario;
	

	public Usuario(){
		super();
	}
	
	public Usuario(String cedula, String nickname, String clave, String nombre, String apellido, int edad,
			String correo, String tipoUsuario) {
		super();
		this.cedula = cedula;
		this.nickname = nickname;
		this.clave = clave;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.correo = correo;
		this.tipoUsuario = tipoUsuario;
	}
	

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cedula == null) ? 0 : cedula.hashCode());
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
		Usuario other = (Usuario) obj;
		if (cedula == null) {
			if (other.cedula != null)
				return false;
		} else if (!cedula.equals(other.cedula))
			return false;
		return true;
	}

}
