package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="item_causa")
@IdClass(itemCausaPK.class)
public class ItemCausa implements Serializable {

	@Id
	@ManyToOne
	@JoinColumn(name="patologa_codigo")
	private Patologia patologia;
	
	@Id
	@ManyToOne
	@JoinColumn(name="causa_codigo")
	private Causa causa;
	
	public ItemCausa() {
		// TODO Auto-generated constructor stub
	}

	public ItemCausa(Patologia patologia, Causa causa) {
		super();
		this.patologia = patologia;
		this.causa = causa;
	}

	public Patologia getPatologia() {
		return patologia;
	}

	public void setPatologia(Patologia patologia) {
		this.patologia = patologia;
	}

	public Causa getCausa() {
		return causa;
	}

	public void setCausa(Causa causa) {
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
		ItemCausa other = (ItemCausa) obj;
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
