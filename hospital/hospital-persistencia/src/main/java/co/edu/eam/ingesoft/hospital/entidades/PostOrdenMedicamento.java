package co.edu.eam.ingesoft.hospital.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="POST_ORDENMEDICAMENTO")
public class PostOrdenMedicamento {
	
	@Id
	@Column(name = "codigoEntrega", length =30)
	private String codigoEntrega;
	
	@Column(name = "cantidad", nullable=false)
	private int cantidad;
	
	@OneToOne
	@JoinColumn(name = "orden_cita_codigo", unique=true, nullable=false)
	private OrdenMedicamento ordenCitaCodigo;
	
	@OneToOne
	@JoinColumn(name = "orden_medicamento_codigo",unique=true, nullable=false)
	private OrdenMedicamento ordenMedicamentoCodigo;
	
    public PostOrdenMedicamento(){
    	super();
}

	public PostOrdenMedicamento(String codigoEntrega, int cantidad, OrdenMedicamento ordenCitaCodigo,
			OrdenMedicamento ordenMedicamentoCodigo) {
		super();
		this.codigoEntrega = codigoEntrega;
		this.cantidad = cantidad;
		this.ordenCitaCodigo = ordenCitaCodigo;
		this.ordenMedicamentoCodigo = ordenMedicamentoCodigo;
	}

	public String getCodigoEntrega() {
		return codigoEntrega;
	}

	public void setCodigoEntrega(String codigoEntrega) {
		this.codigoEntrega = codigoEntrega;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public OrdenMedicamento getOrdenCitaCodigo() {
		return ordenCitaCodigo;
	}

	public void setOrdenCitaCodigo(OrdenMedicamento ordenCitaCodigo) {
		this.ordenCitaCodigo = ordenCitaCodigo;
	}

	public OrdenMedicamento getOrdenMedicamentoCodigo() {
		return ordenMedicamentoCodigo;
	}

	public void setOrdenMedicamentoCodigo(OrdenMedicamento ordenMedicamentoCodigo) {
		this.ordenMedicamentoCodigo = ordenMedicamentoCodigo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ordenCitaCodigo == null) ? 0 : ordenCitaCodigo.hashCode());
		result = prime * result + ((ordenMedicamentoCodigo == null) ? 0 : ordenMedicamentoCodigo.hashCode());
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
		PostOrdenMedicamento other = (PostOrdenMedicamento) obj;
		if (ordenCitaCodigo == null) {
			if (other.ordenCitaCodigo != null)
				return false;
		} else if (!ordenCitaCodigo.equals(other.ordenCitaCodigo))
			return false;
		if (ordenMedicamentoCodigo == null) {
			if (other.ordenMedicamentoCodigo != null)
				return false;
		} else if (!ordenMedicamentoCodigo.equals(other.ordenMedicamentoCodigo))
			return false;
		return true;
	}
    
	
}
