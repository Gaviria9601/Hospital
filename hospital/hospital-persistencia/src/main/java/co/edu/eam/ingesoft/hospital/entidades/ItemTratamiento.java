package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ITEM_TRATAMIENTO")
@IdClass(itemTratamientoPK.class)
public class ItemTratamiento implements Serializable {
	
	@Id
	@ManyToOne
	@JoinColumn(name = "tratamiento_codigo", nullable=false)
	private Tratamiento tratamientoCodigo;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "patologia_codigo", nullable=false)
	private Patologia patologiaCodigo;
	

	public ItemTratamiento(){
		super();
	}


	public ItemTratamiento(Tratamiento tratamientoCodigo, Patologia patologiaCodigo) {
		super();
		this.tratamientoCodigo = tratamientoCodigo;
		this.patologiaCodigo = patologiaCodigo;
	}


	public Tratamiento getTratamientoCodigo() {
		return tratamientoCodigo;
	}


	public void setTratamientoCodigo(Tratamiento tratamientoCodigo) {
		this.tratamientoCodigo = tratamientoCodigo;
	}


	public Patologia getPatologiaCodigo() {
		return patologiaCodigo;
	}


	public void setPatologiaCodigo(Patologia patologiaCodigo) {
		this.patologiaCodigo = patologiaCodigo;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((patologiaCodigo == null) ? 0 : patologiaCodigo.hashCode());
		result = prime * result + ((tratamientoCodigo == null) ? 0 : tratamientoCodigo.hashCode());
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
		ItemTratamiento other = (ItemTratamiento) obj;
		if (patologiaCodigo == null) {
			if (other.patologiaCodigo != null)
				return false;
		} else if (!patologiaCodigo.equals(other.patologiaCodigo))
			return false;
		if (tratamientoCodigo == null) {
			if (other.tratamientoCodigo != null)
				return false;
		} else if (!tratamientoCodigo.equals(other.tratamientoCodigo))
			return false;
		return true;
	}
	
	

}
