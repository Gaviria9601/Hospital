/**
 * 
 */
package co.edu.eam.ingesoft.pa.hospital.web.controladores;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.hospital.entidades.Habitacion;
import co.edu.eam.ingesoft.hospital.entidades.Medico;
import co.edu.eam.ingesoft.hospital.enumeraciones.TipoUsuarioEnum;
import co.edu.eam.ingesoft.pa.negocio.beans.HabitacionEJB;
import co.edu.eam.ingesoft.pa.negocio.excepciones.ExcepcionNegocio;

/**
 * @author Alejandro Ortega
 *
 */
@Named("ControladorHabitacion")
@ViewScoped
public class ControladorHabitacion implements Serializable {

	@Length(max = 1000, message = "maximo 100 digitos")
	private String descripcion;

	private int numero;

	private int piso;
	
	private boolean busco = false;

	@PostConstruct
	public void inicializar() {

	}

	@EJB
	private HabitacionEJB habitacionejb;

	public void limpiar() {
		piso = 0;
		numero = 0;
		descripcion = "";
		busco = false;
	}

	public void crear() {
		try {
			Habitacion hab = new Habitacion(0, numero, piso, descripcion);
			habitacionejb.crearHabitacion(hab);

			// limpiar campos
			limpiar();

			Messages.addFlashGlobalInfo("HABITACIÓN INGRESADA AL SISTEMA CORRECTAMENTE");
		} catch (ExcepcionNegocio e) {
			Messages.addGlobalError(e.getMessage());
		}
	}
	
	public void modificar(){
		try{
		Habitacion hab = habitacionejb.buscarHabitacion(numero);
		hab.setNumero(numero);
		hab.setPiso(piso);
		hab.setDescripcion(descripcion);
		
		habitacionejb.modificarHabitacion(hab);
		limpiar();
		Messages.addFlashGlobalInfo("HABITACIÓN MODIFICADO CORRECTAMENTE");
		}catch (ExcepcionNegocio e) {
			Messages.addGlobalError(e.getMessage());
		}
	}
	
	public void eliminar(){
		try {
			Habitacion hab = habitacionejb.buscarHabitacion(numero);
			if(hab!=null){
				habitacionejb.eliminarHabitacion(hab);
				limpiar();
				Messages.addFlashGlobalInfo("HABITACIÓN ELIMINADA EXITOSAMENTE");
			}else{
				Messages.addGlobalError("ERROR AL ELIMINAR");
			}
		} catch (ExcepcionNegocio e) {
			Messages.addGlobalError(e.getMessage());
		}
	}
	
	public void buscar(){
		try{
		Habitacion hab = habitacionejb.buscarHabitacion(numero);
		if(hab!=null){
			numero = hab.getNumero();
			piso = hab.getPiso();
			descripcion  = hab.getDescripcion();	
			busco = true;
			Messages.addFlashGlobalInfo("HABIACIÓN ENCONTRADA");
			
		}else{
			Messages.addFlashGlobalError("HABIACIÓN NO EXISTE");
	 	}
		}catch (ExcepcionNegocio e) {
			Messages.addGlobalError(e.getMessage());
		}
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion
	 *            the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @param numero
	 *            the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * @return the piso
	 */
	public int getPiso() {
		return piso;
	}

	/**
	 * @param piso
	 *            the piso to set
	 */
	public void setPiso(int piso) {
		this.piso = piso;
	}

	/**
	 * @return the busco
	 */
	public boolean isBusco() {
		return busco;
	}

	/**
	 * @param busco the busco to set
	 */
	public void setBusco(boolean busco) {
		this.busco = busco;
	}

}
