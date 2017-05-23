package co.edu.eam.ingesoft.pa.hospital.web.controladores;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;
import org.primefaces.context.RequestContext;

import co.edu.eam.ingesoft.hospital.entidades.Causa;
import co.edu.eam.ingesoft.hospital.entidades.ItemCausa;
import co.edu.eam.ingesoft.hospital.entidades.ItemSintoma;
import co.edu.eam.ingesoft.hospital.entidades.ItemTratamiento;
import co.edu.eam.ingesoft.hospital.entidades.Patologia;
import co.edu.eam.ingesoft.hospital.entidades.Sintoma;
import co.edu.eam.ingesoft.hospital.entidades.Tratamiento;
import co.edu.eam.ingesoft.hospital.entidades.itemCausaPK;
import co.edu.eam.ingesoft.pa.negocio.beans.CausaEJB;
import co.edu.eam.ingesoft.pa.negocio.beans.PatologiaEJB;
import co.edu.eam.ingesoft.pa.negocio.beans.SintomaEJB;
import co.edu.eam.ingesoft.pa.negocio.beans.TratamientoEJB;

@Named("patologiaController")
@ViewScoped
public class PatologiaController implements Serializable {

	private Causa causa;

	private Sintoma sintoma;

	private Tratamiento tratamiento;

	private Patologia patolo;

	private String nombre;

	private String descripcion;

	private String descripcionCausa;

	private String descripcionSintoma;

	private String descripcionTratamiento;

	private List<Sintoma> sintomas;

	private List<Causa> causas;

	private List<Causa> causasAgre;

	private List<Sintoma> sintomasAgre;

	private List<Tratamiento> tratamientosAgre;

	private List<Tratamiento> tratamientos;

	public Sintoma getSintoma() {
		return sintoma;
	}

	public void setSintoma(Sintoma sintoma) {
		this.sintoma = sintoma;
	}

	public Tratamiento getTratamiento() {
		return tratamiento;
	}

	public void setTratamiento(Tratamiento tratamiento) {
		this.tratamiento = tratamiento;
	}

	public Causa getCausa() {
		return causa;
	}

	public void setCausa(Causa causa) {
		this.causa = causa;
	}

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

	public List<Causa> getCausasAgre() {
		return causasAgre;
	}

	public void setCausasAgre(List<Causa> causasAgre) {
		this.causasAgre = causasAgre;
	}

	public List<Sintoma> getSintomasAgre() {
		return sintomasAgre;
	}

	public void setSintomasAgre(List<Sintoma> sintomasAgre) {
		this.sintomasAgre = sintomasAgre;
	}

	public List<Tratamiento> getTratamientosAgre() {
		return tratamientosAgre;
	}

	public void setTratamientosAgre(List<Tratamiento> tratamientosAgre) {
		this.tratamientosAgre = tratamientosAgre;
	}

	@EJB
	private PatologiaEJB patologiaEJB;

	@EJB
	private CausaEJB causaEJB;

	@EJB
	private SintomaEJB sintomaEJB;

	@EJB
	private TratamientoEJB tratamientoEJB;

	@PostConstruct
	public void inicializar() {
		causas = causaEJB.listarCausas();
		sintomas = sintomaEJB.listarSintomas();
		tratamientos = tratamientoEJB.listarTratamientos();
	}

	/**
	 * 
	 */
	public void agregarPatologia() {
		if (nombre.isEmpty() || descripcion.isEmpty()) {
			Messages.addFlashGlobalWarn("INGRESE LA INFORMACIÓN PARA INGRESAR LA PATOLOGIA");
		} else {
			try {
				RequestContext requestContext = RequestContext.getCurrentInstance();
				Patologia pato = new Patologia(nombre, descripcion);
				patologiaEJB.crearPatologia(pato);
				patolo = patologiaEJB.buscarPatologiaNom(nombre);
				requestContext.execute("PF('terminationWizard').next()");
				Messages.addFlashGlobalInfo("SE HA INGRESADO CORRECTAMENTE LA PATOLOGIA");
			} catch (Exception e) {
				Messages.addFlashGlobalError("YA SE ENCUENTRA AGREGADA LA PATOLOGIA");

			}
		}
	}

	/**
	 * 
	 */
	public void agregarSintoma() {
		if (sintoma == null) {
			Messages.addFlashGlobalWarn("DEBE ESCOJER EL SINTOMA PARA AGREGARLA");
		} else {
			try {
				sintomaEJB.crearItemSintoma(patolo, sintoma);
				sintomasAgre = sintomaEJB.listarSintomasPatologia(patolo.getCodigo());
				Messages.addFlashGlobalInfo("SE HA AGREGADO EL SINTOMA");
			} catch (Exception e) {
				// TODO: handle exception
				Messages.addFlashGlobalError("YA SE ENCUENTRA AGREGADO EL SINTOMA");

			}
		}
	}

	/**
	 * 
	 */
	public void agregarCausa() {
		if (causa == null) {
			Messages.addFlashGlobalWarn("DEBE ESCOJER LA CAUSA PARA AGREGARLA");
		} else {
			try {
				causaEJB.crearItemCausa(patolo, causa);
				causasAgre = causaEJB.listarCausasPatologia(patolo.getCodigo());
				Messages.addFlashGlobalInfo("SE HA AGREGADO LA CAUSA");
			} catch (Exception e) {
				Messages.addFlashGlobalError("YA SE ENCUENTRA AGREGADA LA CAUSA");

			}
		}
	}

	/**
	 * 
	 */
	public void ingresaCausa() {
		if (descripcionCausa.isEmpty()) {
			Messages.addFlashGlobalWarn("INGRESE LA INFORMACIÓN PARA INGRESAR LA CAUSA");
		} else {
			try {
				Causa cau = new Causa();
				cau.setDescripcion(descripcionCausa);
				causaEJB.crearCausa(cau);
				causas = causaEJB.listarCausas();
				Messages.addFlashGlobalInfo("SE HA INGRESADO CORRECTAMENTE LA CAUSA AL SISTEMA");
				descripcionCausa = "";
			} catch (Exception e) {
				Messages.addFlashGlobalError("YA SE ENCUENTRA INGRESADA LA CAUSA EN EL SISTEMA");

			}
		}
	}

	/**
	 * 
	 */
	public void ingresaSintoma() {
		if (descripcionSintoma.isEmpty()) {
			Messages.addFlashGlobalWarn("INGRESE LA INFORMACIÓN PARA INGRESAR EL SINTOMA");
		} else {
			try {
				Sintoma sinto = new Sintoma();
				sinto.setDescripcion(descripcionSintoma);
				sintomaEJB.crearSintoma(sinto);
				sintomas = sintomaEJB.listarSintomas();
				Messages.addFlashGlobalInfo("SE HA INGRESADO CORRECTAMENTE EL SINTOMA AL SISTEMA");
				descripcionSintoma = "";
			} catch (Exception e) {
				Messages.addFlashGlobalError("YA SE ENCUENTRA INGRESADO EL SINTOMA EN EL SISTEMA");
			}
		}
	}

	/**
	 * 
	 */
	public void ingresaTratamiento() {
		if (descripcionTratamiento.isEmpty()) {
			Messages.addFlashGlobalWarn("INGRESE LA INFORMACIÓN PARA INGRESAR EL TRATAMIENTO");
		} else {
			try {
				Tratamiento tra = new Tratamiento();
				tra.setDescripcion(descripcionTratamiento);
				tratamientoEJB.crearTratamiento(tra);
				tratamientos = tratamientoEJB.listarTratamientos();
				Messages.addFlashGlobalInfo("SE HA INGRESADO CORRECTAMENTE EL TRATAMIENTO AL SISTEMA");
				descripcionTratamiento = "";
			} catch (Exception e) {
				Messages.addFlashGlobalError("YA SE ENCUENTRA INGRESADO EL TRATAMIENTO EN EL SISTEMA");
			}
		}
	}

	/**
	 * 
	 */
	public void agregarTratamiento() {
		if (tratamiento == null) {
			Messages.addFlashGlobalWarn("DEBE ESCOJER EL TRATAMIENTO PARA AGREGARLO");
		} else {
			try {
				tratamientoEJB.crearItemTratamiento(patolo, tratamiento);
				tratamientosAgre = tratamientoEJB.listarTratamietoPatologia(patolo.getCodigo());
				Messages.addFlashGlobalInfo("SE HA AGREGADO EL TRATAMIENTO");

			} catch (Exception e) {
				// TODO: handle exception
				Messages.addFlashGlobalError("YA SE ENCUENTRA AGREGADO EL TRATAMIENTO");

			}
		}
	}

	/**
	 * 
	 * @param cau
	 */
	public void quitarCausa(Causa cau) {
		causaEJB.eliminarItemCausa(cau.getCodigo(), patolo.getCodigo());
		causasAgre = causaEJB.listarCausasPatologia(patolo.getCodigo());
		Messages.addFlashGlobalInfo("SE HA QUITADO LA CAUSA");
	}

	/**
	 * 
	 * @param sint
	 */
	public void quitarSintoma(Sintoma sint) {
		sintomaEJB.eliminarItemSintoma(sint.getCodigo(), patolo.getCodigo());
		sintomasAgre = sintomaEJB.listarSintomasPatologia(patolo.getCodigo());
		Messages.addFlashGlobalInfo("SE HA QUITADO EL SINTOMA");

	}

	/**
	 * 
	 * @param tra
	 */
	public void quitarTratamiento(Tratamiento tra) {
		tratamientoEJB.eliminarItemTratamiento(tra.getCodigo(), patolo.getCodigo());
		tratamientosAgre = tratamientoEJB.listarTratamietoPatologia(patolo.getCodigo());
		Messages.addFlashGlobalInfo("SE HA QUITADO EL TRATAMIENTO");

	}

	/**
	 * 
	 * @return
	 */
	public String terminar() {
		Messages.addFlashGlobalInfo("FINALIZADO LA GESTION DE LA PATOLOGIA");
		return "/paginas/seguro/crear-Patologia.xhtml?faces-redirect=true";
	}

}
