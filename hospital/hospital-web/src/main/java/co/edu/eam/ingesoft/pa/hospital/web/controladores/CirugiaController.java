package co.edu.eam.ingesoft.pa.hospital.web.controladores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import org.hibernate.validator.constraints.Length;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.hospital.entidades.Cirugia;
import co.edu.eam.ingesoft.hospital.entidades.Especializacion;
import co.edu.eam.ingesoft.hospital.entidades.TipoCirugia;
import co.edu.eam.ingesoft.hospital.enumeraciones.CitaAvanzadaEnum;
import co.edu.eam.ingesoft.pa.negocio.beans.CirugiaEJB;
import co.edu.eam.ingesoft.pa.negocio.beans.MedicoEJB;

@Named("cirugiaController")
@ViewScoped
public class CirugiaController implements Serializable {
	
	private Cirugia cirugia;

	@Length(min = 4, max = 50, message = "Longitud entre 4 y 50")
	private String nombre;

	private String tiempoestimado;

	@Length(min = 5, max = 500, message = "Longitud entre 5 y 500")
	private String observaciones;

	@Length(min = 5, max = 500, message = "Longitud entre 5 y 500")
	private String recuperacion;

	private boolean anestesia;

	private Especializacion especializacion;

	private TipoCirugia tipoCirugia;

	private List<Especializacion> especializaciones;

	private List<TipoCirugia> tipoCirugias;

	private List<Cirugia> cirugias;
	
	private ArrayList<Cirugia> filtroCirugias = new ArrayList<Cirugia>();

	private boolean busco = false;
	
	

	public ArrayList<Cirugia> getFiltroCirugias() {
		return filtroCirugias;
	}


	public void setFiltroCirugias(ArrayList<Cirugia> filtroCirugias) {
		this.filtroCirugias = filtroCirugias;
	}


	public List<Cirugia> getCirugias() {
		return cirugias;
	}
	

	public void setCirugias(List<Cirugia> cirugias) {
		this.cirugias = cirugias;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTiempoestimado() {
		return tiempoestimado;
	}

	public void setTiempoestimado(String tiempoestimado) {
		this.tiempoestimado = tiempoestimado;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getRecuperacion() {
		return recuperacion;
	}

	public void setRecuperacion(String recuperacion) {
		this.recuperacion = recuperacion;
	}

	public boolean isAnestesia() {
		return anestesia;
	}

	public void setAnestesia(boolean anestesia) {
		this.anestesia = anestesia;
	}

	public Especializacion getEspecializacion() {
		return especializacion;
	}

	public void setEspecializacion(Especializacion especializacion) {
		this.especializacion = especializacion;
	}

	public TipoCirugia getTipoCirugia() {
		return tipoCirugia;
	}

	public void setTipoCirugia(TipoCirugia tipoCirugia) {
		this.tipoCirugia = tipoCirugia;
	}

	public List<Especializacion> getEspecializaciones() {
		return especializaciones;
	}

	public void setEspecializaciones(List<Especializacion> especializaciones) {
		this.especializaciones = especializaciones;
	}

	public List<TipoCirugia> getTipoCirugias() {
		return tipoCirugias;
	}

	public void setTipoCirugias(List<TipoCirugia> tipoCirugias) {
		this.tipoCirugias = tipoCirugias;
	}

	@EJB
	private CirugiaEJB cirugiaEJB;

	@EJB
	private MedicoEJB medicoEJB;

	@PostConstruct
	public void inicializar() {
		especializaciones = medicoEJB.listarEspecializaciones();
		tipoCirugias = cirugiaEJB.listarTiposCirugias();
		cirugias = cirugiaEJB.listarCirugias();
	}

	/**
	 * Crea la cirugia
	 */
	public void crear() {
		try {
			Cirugia cirugia = new Cirugia();
			cirugia.setNombre(nombre);
			cirugia.setObservaciones(observaciones);
			cirugia.setTiempoEstimado(tiempoestimado);
			cirugia.setTipo(CitaAvanzadaEnum.Cirugía);
			cirugia.setRecuperacion(recuperacion);
			cirugia.setAnestesia(anestesia);
			cirugia.setEspecializacionCodigo(especializacion);
			cirugia.setTipoCirugia(tipoCirugia);
			cirugiaEJB.crearCirugia(cirugia);
			Messages.addFlashGlobalInfo("CIRUGIA INGRESADA AL SISTEMA CORRECTAMENTE");
			nombre = "";
			tiempoestimado = "";
			observaciones = "";
			recuperacion = "";
			anestesia = false;
		} catch (Exception e) {
			Messages.addFlashGlobalError("ERROR AL INGRESAR LA CIRUGIA");
		}

	}

	/**
	 * Limpia los campos del registro de la cirugia
	 */
	public void limpiar() {
		nombre = "";
		tiempoestimado = "";
		observaciones = "";
		recuperacion = "";
		anestesia = false;
		busco = false;
	}

	/**
	 * 
	 * @param ciru
	 */
	public void eliminar(Cirugia ciru) {
		try {
			cirugiaEJB.eliminarCirugia(ciru.getCodigo());
			Messages.addFlashGlobalInfo("SE HA ELIMINADO CORRECTAMENTE LA CIRUGIA");
			cirugias = cirugiaEJB.listarCirugias();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * 
	 */
	public void editar(Cirugia ciru) {
		cirugia = ciru;
		nombre = ciru.getNombre();
		observaciones = ciru.getObservaciones();
		tiempoestimado = ciru.getTiempoEstimado();
		recuperacion = ciru.getRecuperacion();
		anestesia = ciru.isAnestesia();
		especializacion = ciru.getEspecializacionCodigo();
		tipoCirugia = ciru.getTipoCirugia();
		busco = true;
	}

	/**
	 * 
	 * @param ciru
	 */
	public void modificar() {
		cirugia.setNombre(nombre);
		cirugia.setObservaciones(observaciones);
		cirugia.setTiempoEstimado(tiempoestimado);
		cirugia.setTipo(CitaAvanzadaEnum.Cirugía);
		cirugia.setRecuperacion(recuperacion);
		cirugia.setAnestesia(anestesia);
		cirugia.setEspecializacionCodigo(especializacion);
		cirugia.setTipoCirugia(tipoCirugia);
		cirugiaEJB.editarCirugia(cirugia);
		Messages.addGlobalInfo("LA CIRUGIA FUE MODIFICADA CORRECTAMENTE");
		limpiar();
	}

	public boolean isBusco() {
		return busco;
	}

}
