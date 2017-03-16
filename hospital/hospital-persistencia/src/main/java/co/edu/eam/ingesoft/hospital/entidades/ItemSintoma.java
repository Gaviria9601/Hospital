package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ITEM_SINTOMA")
public class ItemSintoma implements Serializable {
	
	@EmbeddedId
	protected itemSintomaPK itemSintomaPK;
	
	@ManyToOne
	@JoinColumn(name = "sintoma_codigo", nullable=false)
	private Sintoma sintoma_codigo;
	
	
	@ManyToOne
	@JoinColumn(name = "patologia_codigo", nullable=false)
	private Patologia patologia_codigo;
	
	public ItemSintoma(){
		super();
	}

	public ItemSintoma(Sintoma sintoma_codigo, Patologia patologia_codigo) {
		super();
		this.sintoma_codigo = sintoma_codigo;
		this.patologia_codigo = patologia_codigo;
	}
	
	

	public Sintoma getSintoma_codigo() {
		return sintoma_codigo;
	}

	public void setSintoma_codigo(Sintoma sintoma_codigo) {
		this.sintoma_codigo = sintoma_codigo;
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
		result = prime * result + ((sintoma_codigo == null) ? 0 : sintoma_codigo.hashCode());
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
		ItemSintoma other = (ItemSintoma) obj;
		if (patologia_codigo == null) {
			if (other.patologia_codigo != null)
				return false;
		} else if (!patologia_codigo.equals(other.patologia_codigo))
			return false;
		if (sintoma_codigo == null) {
			if (other.sintoma_codigo != null)
				return false;
		} else if (!sintoma_codigo.equals(other.sintoma_codigo))
			return false;
		return true;
	}
	


}
