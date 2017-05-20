/**
 * 
 */
package co.edu.eam.ingesoft.pa.hospital.web.controladores;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import org.hibernate.validator.constraints.Length;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.hospital.entidades.Cama;
import co.edu.eam.ingesoft.hospital.entidades.Especializacion;
import co.edu.eam.ingesoft.hospital.entidades.Habitacion;
import co.edu.eam.ingesoft.pa.negocio.beans.CamaEJB;
import co.edu.eam.ingesoft.pa.negocio.beans.HabitacionEJB;
import co.edu.eam.ingesoft.pa.negocio.excepciones.ExcepcionNegocio;

/**
 * @author Alejandro Ortega
 *
 */
@Named("ControladorCama")
@ViewScoped
public class ControladorCama implements Serializable{
	
	@Length(max = 1000, message = "maximo 100 digitos")
	private String descripcion;
	
	@Length(max = 1000, message = "maximo 100 digitos")
	private String observacion;

	private int numero;

	private int habitacion;
	
	private List<Habitacion> habitaciones;

	private boolean busco = false;
	
	private String disponibilidad;
	
	private boolean disponibilidaddef;

	@PostConstruct
	public void inicializar() {
		habitaciones = habiejb.listarHabitaciones();

	}
	
	@EJB
	private CamaEJB camaejb;
	
	@EJB
	private HabitacionEJB habiejb;
	
	public void limpiar() {
		numero = 0;
		descripcion = "";
		observacion="";
		busco = false;
	}
	
	
	public void crear() {
		try {
			disponibilidaddef=true;
			observacion = "DISPONIBLE";
			Habitacion habit = habiejb.buscarHabitacion(habitacion);
			Cama cama = new Cama(disponibilidaddef, observacion, "CAMA", numero, descripcion, habit);
			cama.setDescripcion(descripcion);
			camaejb.crearCama(cama);
			// limpiar campos
			limpiar();
			Messages.addFlashGlobalInfo("CAMA INGRESADA AL SISTEMA CORRECTAMENTE");
		} catch (ExcepcionNegocio e) {
			Messages.addGlobalError(e.getMessage());
		}
	}
	
	public void modificar(){
		try{
		Cama cama = camaejb.buscarCama(numero,habitacion);
		cama.setNumero(numero);
		cama.setDescripcion(descripcion);
		cama.setDisponibilidad(disponibilidaddef);
		cama.setHabitacionCodigo(habiejb.buscarHabitacion(habitacion));
		cama.setObservacionDisponible(observacion);
		camaejb.modificarCama(cama);
		limpiar();
		Messages.addFlashGlobalInfo("CAMA MODIFICADA CORRECTAMENTE");
		}catch (ExcepcionNegocio e) {
			Messages.addGlobalError(e.getMessage());
		}
	}
	
	public void eliminar(){
		try {
			// CAMBIAR EL MODO DE BUSCAR, QUE BUSQUE POR NUMERO Y HABITACION
			Cama cam = camaejb.buscarCama(numero,habitacion);
			if(cam!=null){
				camaejb.eliminarCama(cam);
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
		Cama cam = camaejb.buscarCama(numero,habitacion);
		if(cam!=null){
			numero = cam.getNumero();
			descripcion  = cam.getDescripcion();
			disponibilidaddef = cam.isDisponibilidad();
			habitacion = cam.getHabitacionCodigo().getNumero();
			observacion = cam.getObservacionDisponible();
			busco = true;
			Messages.addFlashGlobalInfo("CAMA ENCONTRADA");
			
		}else{
			Messages.addFlashGlobalError("CAMA NO EXISTE");
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
	 * @param descripcion the descripcion to set
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
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * @return the habitacion
	 */
	public int getHabitacion() {
		return habitacion;
	}

	/**
	 * @param habitacion the habitacion to set
	 */
	public void setHabitacion(int habitacion) {
		this.habitacion = habitacion;
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


	/**
	 * @return the observacion
	 */
	public String getObservacion() {
		return observacion;
	}


	/**
	 * @param observacion the observacion to set
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}


	/**
	 * @return the habitaciones
	 */
	public List<Habitacion> getHabitaciones() {
		return habitaciones;
	}


	/**
	 * @param habitaciones the habitaciones to set
	 */
	public void setHabitaciones(List<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}


	/**
	 * @return the disponibilidad
	 */
	public String getDisponibilidad() {
		return disponibilidad;
	}


	/**
	 * @param disponibilidad the disponibilidad to set
	 */
	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}


	/**
	 * @return the disponibilidaddef
	 */
	public boolean isDisponibilidaddef() {
		return disponibilidaddef;
	}


	/**
	 * @param disponibilidaddef the disponibilidaddef to set
	 */
	public void setDisponibilidaddef(boolean disponibilidaddef) {
		this.disponibilidaddef = disponibilidaddef;
	}
	
	
}
