package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="ITEM_SINTOMA")
@IdClass(itemSintomaPK.class)
public class ItemSintoma implements Serializable {
	
	public static final String LISTAR_SINTOMAS_PATOLOGIA = "ListarSintomasPatologia";
	
	@Id
	@ManyToOne
	@JoinColumn(name = "sintoma_codigo")
	private Sintoma sintomaCodigo;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "patologia_codigo")
	private Patologia patologiaCodigo;
	
	public ItemSintoma(){
		super();
	}

	

	public Sintoma getSintomaCodigo() {
		return sintomaCodigo;
	}



	public void setSintomaCodigo(Sintoma sintomaCodigo) {
		this.sintomaCodigo = sintomaCodigo;
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
		ItemSintoma other = (ItemSintoma) obj;
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
