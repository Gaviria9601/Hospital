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
	
	@Column(name = "cantidad")
	private int cantidad;
	
	@OneToOne
	@JoinColumn(name = "orden_cita_codigo",unique=true, nullable=false)
	private OrdenMedicamento orden_cita_codigo;
	
	@OneToOne
	@JoinColumn(name = "orden_medicamento_codigo",unique=true, nullable=false)
	private OrdenMedicamento orden_medicamento_codigo;

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

	public OrdenMedicamento getOrden_cita_codigo() {
		return orden_cita_codigo;
	}

	public void setOrden_cita_codigo(OrdenMedicamento orden_cita_codigo) {
		this.orden_cita_codigo = orden_cita_codigo;
	}

	public OrdenMedicamento getOrden_medicamento_codigo() {
		return orden_medicamento_codigo;
	}

	public void setOrden_medicamento_codigo(OrdenMedicamento orden_medicamento_codigo) {
		this.orden_medicamento_codigo = orden_medicamento_codigo;
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

	public PostOrdenMedicamento(String codigoEntrega, int cantidad, OrdenMedicamento orden_cita_codigo,
			OrdenMedicamento orden_medicamento_codigo) {
		super();
		this.codigoEntrega = codigoEntrega;
		this.cantidad = cantidad;
		this.orden_cita_codigo = orden_cita_codigo;
		this.orden_medicamento_codigo = orden_medicamento_codigo;
	}
	
	public PostOrdenMedicamento(){
		super();
	}

}
