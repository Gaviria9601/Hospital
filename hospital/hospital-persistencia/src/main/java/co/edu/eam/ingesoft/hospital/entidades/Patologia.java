package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
	@NamedQuery(name=Patologia.Buscar_PATOLOGIA,query="select pa from Patologia pa where pa.nombre=?1")
})
@Table(name="PATOLOGIA")
public class Patologia implements Serializable{
	
	public static final String Buscar_PATOLOGIA = "BuscarPatologia";
	
	@Id
    @Column(name = "codigo")
	private int codigo;
	
	@Column(name = "nombre", length =50, nullable=false)
	private String nombre;
	
    @Column(name = "descripcion", length= 1000)
	private String descripcion;


    public Patologia(){
    	super();
    }
    
    public Patologia(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
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
		Patologia other = (Patologia) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}

	
	

	
}
