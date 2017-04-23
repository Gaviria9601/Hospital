package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;

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
@IdClass(OrdenMedicamentoPK.class)
public class OrdenMedicamento implements Serializable {

	@Id
	@ManyToOne
	@JoinColumn(name = "cita_codigo", nullable = true)
	private Cita citaCodigo;

	@Id
	@ManyToOne
	@JoinColumn(name = "medicamentos_codigo",nullable=false)
	private Medicamento medicamentosCodigo;


	@Column(name = "cantidad", nullable = false)
	private int cantidad;

	@Column(name = "formula", length = 2000)
	private String formula;

		
	@Column(name = "estado")
	private boolean estado;

	public OrdenMedicamento() {
		super();
	}

	public OrdenMedicamento(int cantidad, String formula, Cita citaCodigo, Medicamento medicamentosCodigo
			,boolean estado) {
		super();
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
		result = prime * result + ((citaCodigo == null) ? 0 : citaCodigo.hashCode());
		result = prime * result + ((medicamentosCodigo == null) ? 0 : medicamentosCodigo.hashCode());
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
		if (citaCodigo == null) {
			if (other.citaCodigo != null)
				return false;
		} else if (!citaCodigo.equals(other.citaCodigo))
			return false;
		if (medicamentosCodigo == null) {
			if (other.medicamentosCodigo != null)
				return false;
		} else if (!medicamentosCodigo.equals(other.medicamentosCodigo))
			return false;
		return true;
	}

	
	
	
}
