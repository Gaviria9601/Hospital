package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;

public class itemCausaPK implements Serializable{
	
	private Integer patologia;
	
	private Integer causa;
	
	public itemCausaPK() {
		// TODO Auto-generated constructor stub
	}

	public itemCausaPK(Integer patologia, Integer causa) {
		super();
		this.patologia = patologia;
		this.causa = causa;
	}

	public Integer getPatologia() {
		return patologia;
	}

	public void setPatologia(Integer patologia) {
		this.patologia = patologia;
	}

	public Integer getCausa() {
		return causa;
	}

	public void setCausa(Integer causa) {
		this.causa = causa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((causa == null) ? 0 : causa.hashCode());
		result = prime * result + ((patologia == null) ? 0 : patologia.hashCode());
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
		itemCausaPK other = (itemCausaPK) obj;
		if (causa == null) {
			if (other.causa != null)
				return false;
		} else if (!causa.equals(other.causa))
			return false;
		if (patologia == null) {
			if (other.patologia != null)
				return false;
		} else if (!patologia.equals(other.patologia))
			return false;
		return true;
	}
	
	
	

}
