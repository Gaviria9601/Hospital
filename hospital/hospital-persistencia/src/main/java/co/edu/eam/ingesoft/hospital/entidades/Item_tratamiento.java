package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ITEM_TRATAMIENTO")
public class Item_tratamiento implements Serializable {
	@Id
	@ManyToOne
	@JoinColumn(name = "tratamiento_codigo", nullable=false)
	private Tratamiento tratamiento_codigo;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "patologia_codigo", nullable=false)
	private Patologia patologia_codigo;

	public Tratamiento getTratamiento_codigo() {
		return tratamiento_codigo;
	}

	public void setTratamiento_codigo(Tratamiento tratamiento_codigo) {
		this.tratamiento_codigo = tratamiento_codigo;
	}

	public Patologia getPatologia_codigo() {
		return patologia_codigo;
	}

	public void setPatologia_codigo(Patologia patologia_codigo) {
		this.patologia_codigo = patologia_codigo;
	}

	public Item_tratamiento(Tratamiento tratamiento_codigo, Patologia patologia_codigo) {
		super();
		this.tratamiento_codigo = tratamiento_codigo;
		this.patologia_codigo = patologia_codigo;
	}
	
	public Item_tratamiento(){
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((patologia_codigo == null) ? 0 : patologia_codigo.hashCode());
		result = prime * result + ((tratamiento_codigo == null) ? 0 : tratamiento_codigo.hashCode());
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
		Item_tratamiento other = (Item_tratamiento) obj;
		if (patologia_codigo == null) {
			if (other.patologia_codigo != null)
				return false;
		} else if (!patologia_codigo.equals(other.patologia_codigo))
			return false;
		if (tratamiento_codigo == null) {
			if (other.tratamiento_codigo != null)
				return false;
		} else if (!tratamiento_codigo.equals(other.tratamiento_codigo))
			return false;
		return true;
	}
	

}
