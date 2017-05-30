package co.edu.eam.ingesoft.pa.hospital.web.controladores;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.validator.constraints.Length;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;
import org.primefaces.context.RequestContext;

import co.edu.eam.ingesoft.hospital.entidades.Cirugia;
import co.edu.eam.ingesoft.hospital.entidades.Cita;
import co.edu.eam.ingesoft.hospital.entidades.Especializacion;
import co.edu.eam.ingesoft.hospital.entidades.Medico;
import co.edu.eam.ingesoft.hospital.entidades.OrdenCirugia;
import co.edu.eam.ingesoft.hospital.entidades.TipoCirugia;
import co.edu.eam.ingesoft.hospital.entidades.Usuario;
import co.edu.eam.ingesoft.hospital.enumeraciones.CitaAvanzadaEnum;
import co.edu.eam.ingesoft.pa.negocio.beans.CirugiaEJB;
import co.edu.eam.ingesoft.pa.negocio.beans.CitaEJB;
import co.edu.eam.ingesoft.pa.negocio.beans.MedicoEJB;
import co.edu.eam.ingesoft.pa.negocio.beans.OrdenCirugiaEJB;
import co.edu.eam.ingesoft.pa.negocio.beans.QuirofanoEJB;

@Named("cirugiaController")
@ViewScoped
public class CirugiaController implements Serializable {

	private Cirugia cirugia;

	@Length(min = 4, max = 50, message = "Longitud entre 4 y 50")
	private String nombre;

	private String tiempoestimado;

	private String tiempo;

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

	private String observacionesOrdenPro;

	private String fecha;

	private String cedulaMedico;

	private List<Medico> medicos;

	private String horaInicio;
	
	private List<OrdenCirugia> ordenesCirugia;

	public List<OrdenCirugia> getOrdenesCirugia() {
		return ordenesCirugia;
	}

	public void setOrdenesCirugia(List<OrdenCirugia> ordenesCirugia) {
		this.ordenesCirugia = ordenesCirugia;
	}

	public String getTiempo() {
		return tiempo;
	}

	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Cirugia getCirugia() {
		return cirugia;
	}

	public void setCirugia(Cirugia cirugia) {
		this.cirugia = cirugia;
	}

	public String getCedulaMedico() {
		return cedulaMedico;
	}

	public void setCedulaMedico(String cedulaMedico) {
		this.cedulaMedico = cedulaMedico;
	}

	public List<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getObservacionesOrdenPro() {
		return observacionesOrdenPro;
	}

	public void setObservacionesOrdenPro(String observacionesOrdenPro) {
		this.observacionesOrdenPro = observacionesOrdenPro;
	}

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

	@EJB
	private QuirofanoEJB quirofanoEJB;

	@EJB
	private CitaEJB citaEJB;

	@EJB
	private OrdenCirugiaEJB ordenCirugiaEJB;
	
	@Inject
	private SessionController sesion;
	
	Usuario usu;

	@PostConstruct
	public void inicializar() {
		usu = sesion.getUsuario();
		especializaciones = medicoEJB.listarEspecializaciones();
		tipoCirugias = cirugiaEJB.listarTiposCirugias();
		cirugias = cirugiaEJB.listarCirugias();
		ordenesCirugia = ordenCirugiaEJB.listarOrdenes(usu.getCedula());
	}

	/**
	 * Crea la cirugia
	 */
	public void crear() {
		try {
			Cirugia cirugia = new Cirugia();
			cirugia.setNombre(nombre);
			cirugia.setObservaciones(observaciones);
			cirugia.setTiempoEstimado(tiempoestimado + " " + tiempo);
			cirugia.setTipo(CitaAvanzadaEnum.Cirugía);
			cirugia.setRecuperacion(recuperacion);
			cirugia.setAnestesia(anestesia);
			cirugia.setEspecializacionCodigo(especializacion);
			cirugia.setTipoCirugia(tipoCirugia);
			cirugiaEJB.crearCirugia(cirugia);
			cirugias = cirugiaEJB.listarCirugias();
			Messages.addFlashGlobalInfo("CIRUGIA INGRESADA AL SISTEMA CORRECTAMENTE");
			resetearFitrosTabla("tablaCirugias");
			nombre = "";
			tiempoestimado = "";
			observaciones = "";
			recuperacion = "";
			anestesia = false;
			tiempo = "";
		} catch (Exception e) {
			Messages.addFlashGlobalError("ERROR AL INGRESAR LA CIRUGIA");
		}

	}

	/**
	 * 
	 * @param id
	 */
	public void resetearFitrosTabla(String id) {
		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.execute("PF('vtWidget').clearFilters()");
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
		tiempo = "";
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
			resetearFitrosTabla("tablaCirugias");
		} catch (Exception e) {
			Messages.addFlashGlobalError("ERROR AL ELIMINAR LA CIRUGIA, SE ENCUENTRA EN UNA ORDEN");
		}
	}

	/**
	 * 
	 */
	public void editar(Cirugia ciru) {
		cirugia = ciru;
		nombre = ciru.getNombre();
		observaciones = ciru.getObservaciones();
		String[] datos = ciru.getTiempoEstimado().split(" ");
		tiempoestimado = datos[0];
		tiempo = datos[1];
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
		cirugia.setTiempoEstimado(tiempoestimado + " " + tiempo);
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

	/**
	 * 
	 */
	public void seleccionarEspecializacion() {

		if (cirugia != null) {
			Especializacion esp = cirugiaEJB.buscarEspecializacion(cirugia.getCodigo());
			System.out.println(esp.getNombre());
			medicos = medicoEJB.listarMedicosxEspecializacion(esp.getCodigo());
		} else {
			medicos = null;
		}

	}

	/**
	 * 
	 */
	public void crearOrden() {
		try {
			OrdenCirugia orden = new OrdenCirugia();
			orden.setObservaciones(observacionesOrdenPro);
			orden.setEstado(true);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			Date horaIni = dateFormat.parse(fecha + " " + horaInicio);
			orden.setHoraInicio(horaIni);
			SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
			orden.setFecha((formatoDelTexto.parse(fecha)));
			orden.setCirugia(cirugia);
			Cita cita = citaEJB.buscarCita(DatosManager.getCodigoCita());
			orden.setCitaCodigo(cita);
			orden.setMedico(medicoEJB.buscarMedico(cedulaMedico));
			ordenCirugiaEJB.crearOrden(orden);
			Messages.addFlashGlobalInfo("ORDEN DE CIRUGIA CREADA CORRECTAMENTE");
			observacionesOrdenPro = "";
			fecha = "";
			horaInicio = "";
			cirugia = null;
			cedulaMedico = "";
		} catch (Exception e) {
			Messages.addFlashGlobalError("ERRROR AL CREAR LA ORDEN DE CIRUGIA");
		}

	}

	/**
	 * 
	 */
	public void limpiarOrden() {
		observacionesOrdenPro = "";
		fecha = "";
		horaInicio = "";
		cirugia = null;
		cedulaMedico = "";
	}
	
	/**
	 * 
	 * @param ord
	 */
	public void finalizarOrdenCirugia(OrdenCirugia ord){
		ord.setEstado(false);
		ord.setHoraFinal(generarFechaActual());
		ord.getQuirofano().setDisponibilidad(true);
		ordenCirugiaEJB.actualizarOrden(ord);
		ordenesCirugia = ordenCirugiaEJB.listarOrdenes(usu.getCedula());
		Messages.addFlashGlobalInfo("ORDEN DE CIRUGIA FINALIZADA CORRECTAMENTE, EL QUIROFANO N° " +
		 ord.getQuirofano().getCodigo() + " ESTA DISPONIBLE NUEVAMENTE");

	}
	
	/**
	 * Genera la fecha actual del sistema
	 * @return
	 */
	public Date generarFechaActual() {
		Calendar fechaHora = Calendar.getInstance();
		Date fecha = fechaHora.getTime();
		return fecha;
	}
	
	

}
