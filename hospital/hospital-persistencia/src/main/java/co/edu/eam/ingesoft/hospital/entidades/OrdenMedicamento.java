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


	public OrdenMedicamento(){
		super();
	}
	
	public OrdenMedicamento(OrdenMedicamentoPK ordenMedicamentoPK){
		this.ordenMedicamentoPK = ordenMedicamentoPK;
	}

	public OrdenMedicamento(int cantidad, String formula,String citaCodigo, String medicamentoCodigo) {
		super();
		this.cantidad = cantidad;
		this.formula = formula;
		this.ordenMedicamentoPK = new OrdenMedicamentoPK(citaCodigo, medicamentoCodigo);
	}
	
	
	public OrdenMedicamentoPK getOrdenMedicamentoPK() {
		return ordenMedicamentoPK;
	}



	public void setOrdenMedicamentoPK(OrdenMedicamentoPK ordenMedicamentoPK) {
		this.ordenMedicamentoPK = ordenMedicamentoPK;
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
		result = prime * result + ((cita_codigo == null) ? 0 : cita_codigo.hashCode());
		result = prime * result + ((medicamentos_codigo == null) ? 0 : medicamentos_codigo.hashCode());
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
		if (cita_codigo == null) {
			if (other.cita_codigo != null)
				return false;
		} else if (!cita_codigo.equals(other.cita_codigo))
			return false;
		if (medicamentos_codigo == null) {
			if (other.medicamentos_codigo != null)
				return false;
		} else if (!medicamentos_codigo.equals(other.medicamentos_codigo))
			return false;
		return true;
	}


	

}
