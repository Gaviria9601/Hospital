package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class itemSintomaPK implements Serializable{
	
	@Column(name = "Sintoma_Codigo")
	private String SintomaCodigo;
	
	@Column(name = "Patologia_Codigo")
	private String PatologiaCodigo;

	public itemSintomaPK() {
		// TODO Auto-generated constructor stub
	}

	public itemSintomaPK(String sintomaCodigo, String patologiaCodigo) {
		super();
		SintomaCodigo = sintomaCodigo;
		PatologiaCodigo = patologiaCodigo;
	}

	public String getSintomaCodigo() {
		return SintomaCodigo;
	}

	public void setSintomaCodigo(String sintomaCodigo) {
		SintomaCodigo = sintomaCodigo;
	}

	public String getPatologiaCodigo() {
		return PatologiaCodigo;
	}

	public void setPatologiaCodigo(String patologiaCodigo) {
		PatologiaCodigo = patologiaCodigo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((PatologiaCodigo == null) ? 0 : PatologiaCodigo.hashCode());
		result = prime * result + ((SintomaCodigo == null) ? 0 : SintomaCodigo.hashCode());
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
		itemSintomaPK other = (itemSintomaPK) obj;
		if (PatologiaCodigo == null) {
			if (other.PatologiaCodigo != null)
				return false;
		} else if (!PatologiaCodigo.equals(other.PatologiaCodigo))
			return false;
		if (SintomaCodigo == null) {
			if (other.SintomaCodigo != null)
				return false;
		} else if (!SintomaCodigo.equals(other.SintomaCodigo))
			return false;
		return true;
	}
	
	
	
	
}
