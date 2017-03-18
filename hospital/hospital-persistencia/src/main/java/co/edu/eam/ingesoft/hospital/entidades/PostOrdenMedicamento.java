package co.edu.eam.ingesoft.hospital.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "POST_ORDENMEDICAMENTO")
public class PostOrdenMedicamento {

	@Id
	@Column(name = "codigoEntrega", length = 10)
	private String codigoEntrega;

	@Column(name = "cantidad", nullable = false)
	private int cantidad;
	
	@Column(name = "fecha", nullable=false)
	private Date fecha;

	@OneToOne
	@JoinColumn(name = "orden_medicamento_id", unique = true, nullable = false)
	private OrdenMedicamento ordenMedicamentoCodigo;

	public PostOrdenMedicamento() {
		super();
	}

	

	public PostOrdenMedicamento(String codigoEntrega, int cantidad, Date fecha,
			OrdenMedicamento ordenMedicamentoCodigo) {
		super();
		this.codigoEntrega = codigoEntrega;
		this.cantidad = cantidad;
		this.fecha = fecha;
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

	public OrdenMedicamento getOrdenMedicamentoCodigo() {
		return ordenMedicamentoCodigo;
	}

	public void setOrdenMedicamentoCodigo(OrdenMedicamento ordenMedicamentoCodigo) {
		this.ordenMedicamentoCodigo = ordenMedicamentoCodigo;
	}

	
	public Date getFecha() {
		return fecha;
	}



	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoEntrega == null) ? 0 : codigoEntrega.hashCode());
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
		if (codigoEntrega == null) {
			if (other.codigoEntrega != null)
				return false;
		} else if (!codigoEntrega.equals(other.codigoEntrega))
			return false;
		return true;
	}

	
	
}
