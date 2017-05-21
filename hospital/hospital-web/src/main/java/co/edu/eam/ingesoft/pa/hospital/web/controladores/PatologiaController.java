package co.edu.eam.ingesoft.pa.hospital.web.controladores;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
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
			Messages.addFlashGlobalError("INGRESE LA INFORMACIÓN PARA INGRESAR LA PATOLOGIA");
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
		try {
			ItemSintoma itemSin = new ItemSintoma();
			itemSin.setPatologiaCodigo(patolo);
			itemSin.setSintomaCodigo(sintoma);
			sintomaEJB.crearItemSintoma(itemSin);
			sintomasAgre = sintomaEJB.listarSintomasPatologia(patolo.getCodigo());
			Messages.addFlashGlobalInfo("SE HA AGREGADO EL SINTOMA");
		} catch (Exception e) {
			// TODO: handle exception
			Messages.addFlashGlobalError("YA SE ENCUENTRA AGREGADO EL SINTOMA");

		}
	}

	/**
	 * 
	 */
	public void agregarCausa() {
		try {
			ItemCausa itemCau = new ItemCausa(patolo, causa);
			causaEJB.crearItemCausa(itemCau);
			causasAgre = causaEJB.listarCausasPatologia(patolo.getCodigo());
			Messages.addFlashGlobalInfo("SE HA AGREGADO LA CAUSA");

		} catch (Exception e) {
			Messages.addFlashGlobalError("YA SE ENCUENTRA AGREGADA LA CAUSA");

		}

	}

	/**
	 * 
	 */
	public void agregarTratamiento() {
		try {
			ItemTratamiento itemTra = new ItemTratamiento();
			itemTra.setPatologiaCodigo(patolo);
			itemTra.setTratamientoCodigo(tratamiento);
			tratamientoEJB.crearItemTratamiento(itemTra);
			tratamientosAgre = tratamientoEJB.listarTratamietoPatologia(patolo.getCodigo());
			Messages.addFlashGlobalInfo("SE HA AGREGADO EL TRATAMIENTO");

		} catch (Exception e) {
			// TODO: handle exception
			Messages.addFlashGlobalError("YA SE ENCUENTRA AGREGADO EL TRATAMIENTO");

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

	public String terminar() {
		return "/paginas/seguro/crear-Patologia.xhtml?faces-redirect=true";
	}

}
