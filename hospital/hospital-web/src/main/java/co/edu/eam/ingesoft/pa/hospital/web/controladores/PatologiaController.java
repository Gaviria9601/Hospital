package co.edu.eam.ingesoft.pa.hospital.web.controladores;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.primefaces.event.FlowEvent;

import co.edu.eam.ingesoft.hospital.entidades.Causa;
import co.edu.eam.ingesoft.hospital.entidades.Sintoma;
import co.edu.eam.ingesoft.hospital.entidades.Tratamiento;
import co.edu.eam.ingesoft.pa.negocio.beans.SintomaEJB;
import co.edu.eam.ingesoft.pa.negocio.beans.TratamientoEJB;

@Named("patologiaController")
@ViewScoped
public class PatologiaController implements Serializable {

	private String nombre;

	private String descripcion;

	private String descripcionCausa;

	private String descripcionSintoma;

	private String descripcionTratamiento;

	private List<Sintoma> sintomas;

	private List<Causa> causas;

	private List<Tratamiento> tratamientos;

	public List<Causa> getCausas() {
		return causas;
	}

	public void setCausas(List<Causa> causas) {
		this.causas = causas;
	}

	public List<Tratamiento> getTratamientos() {
		return tratamientos;
	}

	public void setTratamientos(List<Tratamiento> tratamientos) {
		this.tratamientos = tratamientos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcionCausa() {
		return descripcionCausa;
	}

	public void setDescripcionCausa(String descripcionCausa) {
		this.descripcionCausa = descripcionCausa;
	}

	public String getDescripcionSintoma() {
		return descripcionSintoma;
	}

	public void setDescripcionSintoma(String descripcionSintoma) {
		this.descripcionSintoma = descripcionSintoma;
	}

	public String getDescripcionTratamiento() {
		return descripcionTratamiento;
	}

	public void setDescripcionTratamiento(String descripcionTratamiento) {
		this.descripcionTratamiento = descripcionTratamiento;
	}

	public List<Sintoma> getSintomas() {
		return sintomas;
	}

	public void setSintomas(List<Sintoma> sintomas) {
		this.sintomas = sintomas;
	}
	
	@EJB
	private SintomaEJB sintomaEJB;
	
	@EJB
	private TratamientoEJB tratamientoEJB;
	
	@PostConstruct
	public void inicializar(){
		sintomas = sintomaEJB.listarSintomas();
		tratamientos = tratamientoEJB.listarTratamientos();
	}
	

	public void agregarSintoma() {

	}

	public void limpiarCamposSintoma() {

	}

	public void agregarCausa() {

	}

	public void limpiarCamposCausa() {

	}

	public void agregarTratamiento() {

	}

	public void limpiarCamposTratamiento() {

	}

	public void quitarCausa(Causa cau) {

	}

	public void quitarSintoma(Sintoma sint) {

	}

	public void quitarTratamiento(Tratamiento tra) {

	}
}
