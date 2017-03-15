package co.edu.eam.ingesoft.hospital.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ORDEN_MEDICAMENTO")
public class Orden_medicamento {
	
	@Column(name = "cantidad")
	private int cantidad;
	
	@Column(name = "formula", length =2000)
	private String formula;
	
	@ManyToOne
	@JoinColumn(name = "cita_codigo", nullable=true)
	private Cita cita_codigo;
	
	@ManyToOne
	@JoinColumn(name = "medicamentos_codigo", nullable=true)
	private Medicamentos medicamentos_codigo;

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

	public Cita getCita_codigo() {
		return cita_codigo;
	}

	public void setCita_codigo(Cita cita_codigo) {
		this.cita_codigo = cita_codigo;
	}

	public Medicamentos getMedicamentos_codigo() {
		return medicamentos_codigo;
	}

	public void setMedicamentos_codigo(Medicamentos medicamentos_codigo) {
		this.medicamentos_codigo = medicamentos_codigo;
	}

	public Orden_medicamento(int cantidad, String formula, Cita cita_codigo, Medicamentos medicamentos_codigo) {
		super();
		this.cantidad = cantidad;
		this.formula = formula;
		this.cita_codigo = cita_codigo;
		this.medicamentos_codigo = medicamentos_codigo;
	}
	  
	public Orden_medicamento(){
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cantidad;
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
		Orden_medicamento other = (Orden_medicamento) obj;
		if (cantidad != other.cantidad)
			return false;
		return true;
	} 
	

}
