package co.edu.eam.ingesoft.pa.hospital.web.controladores;

import java.io.Serializable;


import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;


import co.edu.eam.ingesoft.hospital.entidades.Quirofano;

import co.edu.eam.ingesoft.pa.negocio.beans.QuirofanoEJB;
import co.edu.eam.ingesoft.pa.negocio.excepciones.ExcepcionNegocio;

@Named("quirofanoControlador")
@ViewScoped
public class QuirofanoController implements Serializable  {
	
	private boolean disponi;
	
	@Pattern(regexp="[A-Za-z ]*",message="solo Letras")
	@Length(min=3,max=2000,message="longitud entre 3 y 2000")
	private String observacion;
	
	private String tipo = "Quirofano";
	
	private int codigoQuiro;
	
	@Pattern(regexp="[0-9]*",message="solo numeros")
	@Length(min=1,max=200,message="longitud entre 1 y 200")
	private String numeroAparato;
	
	@Pattern(regexp="[0-9]*",message="solo numeros")
	@Length(min=1,max=200,message="longitud entre 1 y 200")
	private String cantidadMedico;


	public boolean isDisponi() {
		return disponi;
	}

	public void setDisponi(boolean disponi) {
		this.disponi = disponi;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getCodigoQuiro() {
		return codigoQuiro;
	}

	public void setCodigoQuiro(int codigoQuiro) {
		this.codigoQuiro = codigoQuiro;
	}


	
	
	public String getNumeroAparato() {
		return numeroAparato;
	}

	public void setNumeroAparato(String numeroAparato) {
		this.numeroAparato = numeroAparato;
	}

	public String getCantidadMedico() {
		return cantidadMedico;
	}

	public void setCantidadMedico(String cantidadMedico) {
		this.cantidadMedico = cantidadMedico;
	}




	@EJB
	private QuirofanoEJB quiroEJB;
	
	@PostConstruct
	public void inicializador(){
		
	
	}
	/**
	 * Metodo que crear el farmaceutico
	 */
	
	public void crearQuirofano(){
		try{
			 Quirofano farm = new Quirofano(disponi, observacion,tipo, Integer.parseInt( numeroAparato),
					 Integer.parseInt(cantidadMedico));
		     quiroEJB.crear(farm);
		     limpiar();
		   
		    Messages.addFlashGlobalInfo("QUIROFANO INGRESADO AL SISTEMA CORRECTAMENTE");
		    
		} catch (ExcepcionNegocio e) {
	       Messages.addGlobalError(e.getMessage());
		   }
		}
	/**
	 * Metodo que limpiar los campos del farmaceutico
	 */
public void limpiar(){
		observacion = "";
		tipo = "";
		numeroAparato = "";
		cantidadMedico="";
		
		
		
		
	}
   /**
    * Metodo para buscar un farmaceutico
    */
public void buscar(){
	Quirofano f = quiroEJB.buscar(codigoQuiro);
	if(f!=null){
		
		observacion = f.getObservacionDisponible();
		cantidadMedico = f.getCantidadMedico() + "";
		numeroAparato = f.getNumeroAparatos() + "";
		tipo = f.getTipo();
		disponi = f.isDisponibilidad();
		
			
		
		Messages.addFlashGlobalInfo("QUIROFANO ENCONTRADO");
		
	}else{
		Messages.addFlashGlobalError("FARMACEUTICO  NO EXISTE");
 	}
}
/**
 * Metodo paara modificcar un farmaceutico
 */
public void modificar(){
	try{
	Quirofano f = quiroEJB.buscar(codigoQuiro);
	f.setCantidadMedico(Integer.parseInt(cantidadMedico));
    f.setDisponibilidad(disponi);
	f.setNumeroAparatos(Integer.parseInt(numeroAparato));
	f.setObservacionDisponible(observacion);
	f.setTipo(tipo);
	quiroEJB.modificar(f);
	
	limpiar();
	Messages.addFlashGlobalInfo("QUIROFANO MODIFICADO CORRECTAMENTE");
	}catch (ExcepcionNegocio e) {
		Messages.addGlobalError(e.getMessage());
	}
}
/**
 * Metodo que elimina un farmaceutico
 */
public void eliminar(){
	try {
		Quirofano fa = quiroEJB.buscar(codigoQuiro);
		if(fa!=null){
			quiroEJB.eliminar(fa);
			Messages.addFlashGlobalInfo("QUIROFANO ELIMINADO EXITOSAMENTE");
		}else{
			Messages.addGlobalError("ERROR AL ELIMINAR");
		}
	} catch (ExcepcionNegocio e) {
		Messages.addGlobalError(e.getMessage());
	}
}








	

}
