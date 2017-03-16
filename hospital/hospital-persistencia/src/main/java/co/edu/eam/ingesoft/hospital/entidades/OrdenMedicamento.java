package co.edu.eam.ingesoft.hospital.entidades;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ORDEN_MEDICAMENTO")
public class OrdenMedicamento {
	
	@EmbeddedId
	private OrdenMedicamentoPK ordenMedicamentoPK;
	
	@Column(name = "cantidad")
	private int cantidad;
	
	@Column(name = "formula", length =2000)
	private String formula;
	
	@ManyToOne
	@JoinColumn(name = "cita_codigo", nullable=true)
	private Cita cita_codigo;
	
	@ManyToOne
	@JoinColumn(name = "medicamentos_codigo", nullable=true)
	private Medicamento medicamentos_codigo;


	public OrdenMedicamento(int cantidad, String formula, Cita cita_codigo, Medicamento medicamentos_codigo) {
		super();
		this.cantidad = cantidad;
		this.formula = formula;
		this.cita_codigo = cita_codigo;
		this.medicamentos_codigo = medicamentos_codigo;
	}
	
	
	public OrdenMedicamentoPK getOrdenMedicamentoPK() {
		return ordenMedicamentoPK;
	}



	public void setOrdenMedicamentoPK(OrdenMedicamentoPK ordenMedicamentoPK) {
		this.ordenMedicamentoPK = ordenMedicamentoPK;
	}



	public OrdenMedicamento(){
		super();
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

	public Cita getCita_codigo() {
		return cita_codigo;
	}

	public void setCita_codigo(Cita cita_codigo) {
		this.cita_codigo = cita_codigo;
	}

	public Medicamento getMedicamentos_codigo() {
		return medicamentos_codigo;
	}

	public void setMedicamentos_codigo(Medicamento medicamentos_codigo) {
		this.medicamentos_codigo = medicamentos_codigo;
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
		OrdenMedicamento other = (OrdenMedicamento) obj;
		if (cantidad != other.cantidad)
			return false;
		return true;
	} 
	

}
