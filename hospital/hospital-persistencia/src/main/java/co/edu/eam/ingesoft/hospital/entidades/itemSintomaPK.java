package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

public class itemSintomaPK implements Serializable{
	
	private String sintomaCodigo;
	
	private String patologiaCodigo;

	public itemSintomaPK() {
		super();
	}

	public itemSintomaPK(String sintomaCodigo, String patologiaCodigo) {
		super();
		this.sintomaCodigo = sintomaCodigo;
		this.patologiaCodigo = patologiaCodigo;
	}

	public String getSintomaCodigo() {
		return sintomaCodigo;
	}

	public void setSintomaCodigo(String sintomaCodigo) {
		this.sintomaCodigo = sintomaCodigo;
	}

	public String getPatologiaCodigo() {
		return patologiaCodigo;
	}

	public void setPatologiaCodigo(String patologiaCodigo) {
		this.patologiaCodigo = patologiaCodigo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((patologiaCodigo == null) ? 0 : patologiaCodigo.hashCode());
		result = prime * result + ((sintomaCodigo == null) ? 0 : sintomaCodigo.hashCode());
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
		if (patologiaCodigo == null) {
			if (other.patologiaCodigo != null)
				return false;
		} else if (!patologiaCodigo.equals(other.patologiaCodigo))
			return false;
		if (sintomaCodigo == null) {
			if (other.sintomaCodigo != null)
				return false;
		} else if (!sintomaCodigo.equals(other.sintomaCodigo))
			return false;
		return true;
	}

	
	
	
}
