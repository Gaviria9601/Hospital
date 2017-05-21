package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;

public class itemCausaPK implements Serializable{
	
	private int patologia;
	
	private int causa;
	
	public itemCausaPK() {
		// TODO Auto-generated constructor stub
	}

	public itemCausaPK(int patologia, int causa) {
		super();
		this.patologia = patologia;
		this.causa = causa;
	}

	public int getPatologia() {
		return patologia;
	}

	public void setPatologia(int patologia) {
		this.patologia = patologia;
	}

	public int getCausa() {
		return causa;
	}

	public void setCausa(int causa) {
		this.causa = causa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + causa;
		result = prime * result + patologia;
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
		if (causa != other.causa)
			return false;
		if (patologia != other.patologia)
			return false;
		return true;
	}

	
}
