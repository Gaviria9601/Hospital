package co.edu.eam.ingesoft.hospital.entidades;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ORDEN_MEDICAMENTO")
public class OrdenMedicamento {

	@Id
	@Column(name = "id", nullable = false,length=20)
	private String id;

	@Column(name = "cantidad", nullable = false)
	private int cantidad;

	@Column(name = "formula", length = 2000)
	private String formula;

	@ManyToOne
	@JoinColumn(name = "cita_codigo", nullable = true)
	private Cita citaCodigo;

	@ManyToOne
	@JoinColumn(name = "medicamentos_codigo",nullable=false)
	private Medicamento medicamentosCodigo;
	
	@Column(name = "estado")
	private boolean estado;

	public OrdenMedicamento() {
		super();
	}

	public OrdenMedicamento(String id, int cantidad, String formula, Cita citaCodigo, Medicamento medicamentosCodigo
			,boolean estado) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.formula = formula;
		this.citaCodigo = citaCodigo;
		this.medicamentosCodigo = medicamentosCodigo;
		this.estado = estado;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public Cita getCitaCodigo() {
		return citaCodigo;
	}

	public void setCitaCodigo(Cita citaCodigo) {
		this.citaCodigo = citaCodigo;
	}

	public Medicamento getMedicamentosCodigo() {
		return medicamentosCodigo;
	}

	public void setMedicamentosCodigo(Medicamento medicamentosCodigo) {
		this.medicamentosCodigo = medicamentosCodigo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		OrdenMedicamento other = (OrdenMedicamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
}
