package co.edu.eam.ingesoft.hospital.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
	@NamedQuery(name=Tratamiento.LISTAR_TRATAMIENTO,query="select tra from Tratamiento tra")
})
@Table(name="TRATAMIENTO")
public class Tratamiento {
	
	public static final String LISTAR_TRATAMIENTO = "ListarTratamiento";
	
	@Id
    @Column(name = "codigo")
	private int codigo;
	
	@Column(name = "descripcion")
	private String descripcion;
	
    

    public Tratamiento(){
    	super();
    }

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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
		Tratamiento other = (Tratamiento) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}


    
}
