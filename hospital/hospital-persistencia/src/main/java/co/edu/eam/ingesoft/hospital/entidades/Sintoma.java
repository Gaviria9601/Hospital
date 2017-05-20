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
	@NamedQuery(name=Sintoma.LISTAR_SINTOMAS,query="select sin from Sintoma sin")
})
@Table(name="SINTOMA")
public class Sintoma implements Serializable{
	
	public static final String LISTAR_SINTOMAS = "ListarSintomas";
	
	@Id
    @Column(name = "codigo")
	private int codigo;
	
    @Column(name = "descripcion")
	private String descripcion;
    

	public Sintoma(){
		super();
	}
    
    public Sintoma(Integer codigo,String descripcion) {
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
		Sintoma other = (Sintoma) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}

	

	
    

}
