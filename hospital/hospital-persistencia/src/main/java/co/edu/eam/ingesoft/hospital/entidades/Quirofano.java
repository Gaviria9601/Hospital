/**
 * 
 */
package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author Alejandro Ortega
 *
 */
@Entity
@Table(name="Quirofano")
@NamedQueries({
@NamedQuery (name=Quirofano.LISTAR_QUIRO, query="select m from Quirofano m")
})
public class Quirofano extends Instalacion implements Serializable {
	
	
	public static final String LISTAR_QUIRO = "Listarquiro";
	
	@Column(name="numeroAparatos", nullable=false)
	private int numeroAparatos;
	
	@Column(name="cantidadMedico")
	private int cantidadMedico;
	
	
	public Quirofano(){
		
	}

	
	public Quirofano(boolean disponibilidad, String observacionDisponible, String tipo, int numeroAparatos,
			int cantidadMedico) {
		super(disponibilidad, observacionDisponible, tipo);
		this.numeroAparatos = numeroAparatos;
		this.cantidadMedico = cantidadMedico;
	}







	/**
	 * @return the numeroAparatos
	 */
	public int getNumeroAparatos() {
		return numeroAparatos;
	}

	/**
	 * @param numeroAparatos the numeroAparatos to set
	 */
	public void setNumeroAparatos(int numeroAparatos) {
		this.numeroAparatos = numeroAparatos;
	}

	/**
	 * @return the cantidadMedico
	 */
	public int getCantidadMedico() {
		return cantidadMedico;
	}

	/**
	 * @param cantidadMedico the cantidadMedico to set
	 */
	public void setCantidadMedico(int cantidadMedico) {
		this.cantidadMedico = cantidadMedico;
	}

	
	
	
	
}
