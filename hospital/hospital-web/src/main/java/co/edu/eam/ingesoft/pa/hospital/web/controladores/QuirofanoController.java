package co.edu.eam.ingesoft.pa.hospital.web.controladores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;
import org.primefaces.context.RequestContext;

import co.edu.eam.ingesoft.hospital.entidades.Examen;
import co.edu.eam.ingesoft.hospital.entidades.Medicamento;
import co.edu.eam.ingesoft.hospital.entidades.Quirofano;

import co.edu.eam.ingesoft.pa.negocio.beans.QuirofanoEJB;
import co.edu.eam.ingesoft.pa.negocio.excepciones.ExcepcionNegocio;

@Named("quirofanoControlador")
@ViewScoped
public class QuirofanoController implements Serializable  {
	
	private Quirofano quiro;
	
	 private List<Quirofano> listaQuirofano;
		
	private ArrayList<Quirofano> filtroQuiro = new ArrayList<Quirofano>();
	
	private boolean disponi;
	
	private String observacion;
	
	private String tipo = "Quirofano";
	
	private int codigoQuiro;
	
	@Pattern(regexp="[0-9]*",message="solo numeros")
	@Length(min=1,max=200,message="longitud entre 1 y 200")
	private String numeroAparato;
	
	@Pattern(regexp="[0-9]*",message="solo numeros")
	@Length(min=1,max=200,message="longitud entre 1 y 200")
	private String cantidadMedico;

	
	private boolean busco = false;
	
	
	

	public boolean isBusco() {
		return busco;
	}

	public void setBusco(boolean busco) {
		this.busco = busco;
	}

	public Quirofano getQuiro() {
		return quiro;
	}

	public void setQuiro(Quirofano quiro) {
		this.quiro = quiro;
	}

	public List<Quirofano> getListaQuirofano() {
		return listaQuirofano;
	}

	public void setListaQuirofano(List<Quirofano> listaQuirofano) {
		this.listaQuirofano = listaQuirofano;
	}

	public ArrayList<Quirofano> getFiltroQuiro() {
		return filtroQuiro;
	}

	public void setFiltroQuiro(ArrayList<Quirofano> filtroQuiro) {
		this.filtroQuiro = filtroQuiro;
	}

	public QuirofanoEJB getQuiroEJB() {
		return quiroEJB;
	}

	public void setQuiroEJB(QuirofanoEJB quiroEJB) {
		this.quiroEJB = quiroEJB;
	}

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
	listaQuirofano = quiroEJB.listarQuirofanos();
	
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
		busco = false;
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
		busco=true;
		Messages.addFlashGlobalInfo("QUIROFANO ENCONTRADO");
		
	}else{
		Messages.addFlashGlobalError("FARMACEUTICO  NO EXISTE");
 	}
}

public void resetearFitrosTabla(String id) {
	RequestContext requestContext = RequestContext.getCurrentInstance();
	requestContext.execute("PF('vtWidget').clearFilters()");
}

public void modificar(Quirofano exa) {
	quiro = exa;
	cantidadMedico= exa.getCantidadMedico() + "";
	numeroAparato= exa.getNumeroAparatos() + "";
	disponi= exa.isDisponibilidad();
	observacion= exa.getObservacionDisponible();
	busco = true;
}
/**
 * Metodo paara modificcar un farmaceutico
 */
public void editar(){
	try{
	quiro.setCantidadMedico(Integer.parseInt(cantidadMedico));
    quiro.setDisponibilidad(disponi);
	quiro.setNumeroAparatos(Integer.parseInt(numeroAparato));
	quiro.setObservacionDisponible(observacion);
	quiroEJB.modificar(quiro);
	busco = false;
	limpiar();
	Messages.addFlashGlobalInfo("QUIROFANO MODIFICADO CORRECTAMENTE");
	}catch (ExcepcionNegocio e) {
		Messages.addGlobalError(e.getMessage());
	}
}
/**
 * Metodo que elimina un farmaceutico
 */
public void eliminar(Quirofano exa) {
	try {
		quiroEJB.eliminar(exa.getCodigo());
		Messages.addFlashGlobalInfo("SE HA ELIMINADO CORRECTAMENTE EL QUIROFANO");
		listaQuirofano = quiroEJB.listarQuirofanos();
		resetearFitrosTabla("tablaExamenes");
	} catch (Exception e) {
		// TODO: handle exception
	}
}
}
