package co.edu.eam.ingesoft.hospital.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TRATAMIENTO")
public class Tratamiento {
	
	@Id
    @Column(name = "codigo",length =20 )
	private String codigo;
	
	@Column(name = "tipo", length =50)
	private String tipo;
	
    @Column(name = "farmacos_aplicar", length =50)
	private String farmacos_aplicar;

    @Column(name = "problema", length =500)
	private String problema;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getFarmacos_aplicar() {
		return farmacos_aplicar;
	}

	public void setFarmacos_aplicar(String farmacos_aplicar) {
		this.farmacos_aplicar = farmacos_aplicar;
	}

	public String getProblema() {
		return problema;
	}

	public void setProblema(String problema) {
		this.problema = problema;
	}

	public Tratamiento(String codigo, String tipo, String farmacos_aplicar, String problema) {
		super();
		this.codigo = codigo;
		this.tipo = tipo;
		this.farmacos_aplicar = farmacos_aplicar;
		this.problema = problema;
	}
    
    public Tratamiento(){
    	super();
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	} 
    
    
}
