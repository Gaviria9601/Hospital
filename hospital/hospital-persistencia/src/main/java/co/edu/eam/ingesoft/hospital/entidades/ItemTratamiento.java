package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ITEM_TRATAMIENTO")
public class ItemTratamiento implements Serializable {

	@EmbeddedId
	protected itemTratamientoPK itemTratamientoPK;
	
	@ManyToOne
	@JoinColumn(name = "tratamiento_codigo", nullable=false)
	private Tratamiento tratamiento_codigo;
	
	@ManyToOne
	@JoinColumn(name = "patologia_codigo", nullable=false)
	private Patologia patologia_codigo;
	

	public ItemTratamiento(){
		super();
	}

	public ItemTratamiento(itemTratamientoPK itemTratamientoPK){
		this.itemTratamientoPK =  itemTratamientoPK;
	}
	
	public ItemTratamiento(String tratamientoCodigo, String patologiaCodigo) {
		super();
		this.itemTratamientoPK = new itemTratamientoPK(patologiaCodigo, tratamientoCodigo);
	}

	
	public itemTratamientoPK getItemTratamientoPK() {
		return itemTratamientoPK;
	}

	public void setItemTratamientoPK(itemTratamientoPK itemTratamientoPK) {
		this.itemTratamientoPK = itemTratamientoPK;
	}

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
		ItemTratamiento other = (ItemTratamiento) obj;
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
