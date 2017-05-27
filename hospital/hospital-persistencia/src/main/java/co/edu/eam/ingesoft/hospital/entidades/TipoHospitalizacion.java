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
	@NamedQuery(name = TipoHospitalizacion.LISTAR_TIPO_HOSPITALIZACION,query="select tipoHos from TipoHospitalizacion tipoHos")
})
@Table(name="tipohospitalizacion")
public class TipoHospitalizacion implements Serializable {

	public static final String LISTAR_TIPO_HOSPITALIZACION = "ListarTipoHospitalizacion";
	
	@Id
	@Column(name="codigo")
	private int codigo;
	
	@Column(name="nombre")
	private String nombre;

	public TipoHospitalizacion() {
		// TODO Auto-generated constructor stub
	}
	
	public TipoHospitalizacion(int codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
		TipoHospitalizacion other = (TipoHospitalizacion) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
	
	
	
	
}
