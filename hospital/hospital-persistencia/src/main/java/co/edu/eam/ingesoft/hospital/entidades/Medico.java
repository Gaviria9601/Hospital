/**
 * 
 */
package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Alejandro Ortega
 *
 */
@Entity
@Table(name="Medico")
public class Medico extends Usuario implements Serializable {

	@Column(name="carnet", nullable=false, length=30)
	private String carnet;
	
	@Column(name="facultadMedicina", length=60)
	private String facultadMedicina;

	@Column(name = "estado")
	private boolean estado;
	
	public Medico(){
		
	}

	
	public Medico(String carnet, String facultadMedicina, boolean estado) {
		super();
		this.carnet = carnet;
		this.facultadMedicina = facultadMedicina;
		this.estado = estado;
	}

	public boolean isEstado() {
		return estado;
	}


	public void setEstado(boolean estado) {
		this.estado = estado;
	}


	/**
	 * @return the carnet
	 */
	public String getCarnet() {
		return carnet;
	}

	/**
	 * @param carnet the carnet to set
	 */
	public void setCarnet(String carnet) {
		this.carnet = carnet;
	}

	/**
	 * @return the facultadMedicina
	 */
	public String getFacultadMedicina() {
		return facultadMedicina;
	}

	/**
	 * @param facultadMedicina the facultadMedicina to set
	 */
	public void setFacultadMedicina(String facultadMedicina) {
		this.facultadMedicina = facultadMedicina;
	}
	
}
