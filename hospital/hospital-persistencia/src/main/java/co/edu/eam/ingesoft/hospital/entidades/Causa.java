package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
	@NamedQuery(name=Causa.LISTAR_CAUSAS,query="select ca from Causa ca")
})
@Table(name="Causa")
public class Causa implements Serializable {
	
	public static final String LISTAR_CAUSAS = "ListarCausas";
	
	@Id
	@Column(name="codigo")
	private int codigo;
	
	@Column(name="descripcion")
	private String descripcion;

	public Causa() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Causa(Integer codigo, String descripcion) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
	}



	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
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
		Causa other = (Causa) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}

	
}
