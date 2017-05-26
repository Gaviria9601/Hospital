package co.edu.eam.ingesoft.pa.hospital.web.controladores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.sound.midi.Soundbank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;
import org.primefaces.context.RequestContext;

import co.edu.eam.ingesoft.hospital.entidades.Examen;
import co.edu.eam.ingesoft.hospital.entidades.Farmaceutico;
import co.edu.eam.ingesoft.hospital.entidades.Farmacia;
import co.edu.eam.ingesoft.hospital.entidades.Medicamento;
import co.edu.eam.ingesoft.hospital.entidades.Paciente;
import co.edu.eam.ingesoft.hospital.enumeraciones.CitaAvanzadaEnum;
import co.edu.eam.ingesoft.hospital.enumeraciones.EstratoEnumeracion;
import co.edu.eam.ingesoft.hospital.enumeraciones.LaboratorioEnum;
import co.edu.eam.ingesoft.hospital.enumeraciones.TipoUsuarioEnum;
import co.edu.eam.ingesoft.pa.negocio.beans.MedicamentosEJB;
import co.edu.eam.ingesoft.pa.negocio.excepciones.ExcepcionNegocio;

@Named("MedicamentosControlador")
@ViewScoped
public class MedicamentoController implements Serializable   {
	
	private Medicamento medi;
	
	@Pattern(regexp="[A-Za-z ]*",message="solo Letras")
	@Length(min=3,max=50,message="longitud entre 3 y 50")
	private String nombre;
	
	private int codigo;
	
	private Date fecha_expedicion;
	
	private Date fecha_expiracion;
	
	private LaboratorioEnum laboratorio;
	
	@Pattern(regexp="[0-9]*",message="solo numeros")
	@Length(min=1,max=2000,message="longitud entre 1 y 2000")
	private String cantidad;
	
	private boolean estado;
	
	private int codigofarmacia;
	
	private boolean busco = false;
	
    private List<Medicamento> medicamentos;
	
	private ArrayList<Medicamento> filtroMedi = new ArrayList<Medicamento>();
	
	public LaboratorioEnum[] getTipos(){
		return LaboratorioEnum.values();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
    public Medicamento getMedi() {
		return medi;
	}

	public void setMedi(Medicamento medi) {
		this.medi = medi;
	}

	public List<Medicamento> getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(List<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
	}

	public ArrayList<Medicamento> getFiltroMedi() {
		return filtroMedi;
	}

	public void setFiltroMedi(ArrayList<Medicamento> filtroMedi) {
		this.filtroMedi = filtroMedi;
	}

	public Date getFecha_expedicion() {
		return fecha_expedicion;
	}

	public void setFecha_expedicion(Date fecha_expedicion) {
		this.fecha_expedicion = fecha_expedicion;
	}

	public Date getFecha_expiracion() {
		return fecha_expiracion;
	}

	public void setFecha_expiracion(Date fecha_expiracion) {
		this.fecha_expiracion = fecha_expiracion;
	}

	

	public LaboratorioEnum getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(LaboratorioEnum laboratorio) {
		this.laboratorio = laboratorio;
	}


	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public int getCodigofarmacia() {
		return codigofarmacia;
	}

	public void setCodigofarmacia(int codigofarmacia) {
		this.codigofarmacia = codigofarmacia;
	}

	public boolean isBusco() {
		return busco;
	}

	public void setBusco(boolean busco) {
		this.busco = busco;
	}
	
	@PostConstruct
	public void inicializador(){
	medicamentos = mediEJB.listarMedicamentos();
		
	
	}
	/**
	 * Metodo para crear medicamento
	 */
	@EJB
	MedicamentosEJB mediEJB;
	
	/**
	 * 
	 */
	public void crearMedicamento(){
		try{
			
			Farmacia fa = mediEJB.buscarFarmacia(3434);
		    Medicamento m = new Medicamento(nombre, fecha_expedicion, fecha_expiracion,
		    		laboratorio, Integer.parseInt(cantidad), estado, fa);
		    
		    mediEJB.crearMedica(m);
		   limpiar();
		    Messages.addFlashGlobalInfo("MEDICAMENTO INGRESADO AL SISTEMA CORRECTAMENTE");
		    
		} catch (ExcepcionNegocio e) {
	       Messages.addGlobalError(e.getMessage());
		   }
		}
	/**
	 * Metodo que limpiar los campos de medicamento
	 */
public void limpiar(){
		
		nombre ="";
		fecha_expedicion = null;
		fecha_expiracion = null;
		cantidad = "";
		busco = false;
		
		
	}
   /**
    * Metodo para buscar un farmaceutico
    */
public void buscarMedicamento(){
	Medicamento f = mediEJB.buscarMedicamento(codigo);
	if(f!=null){
		nombre = f.getNombre();
		fecha_expedicion = f.getFechaExpedicion();
		fecha_expiracion = f.getFechaExpiracion();
		laboratorio = f.getLaboratorio();
		cantidad = f.getCantidad() + "";
		estado = f.isEstado();
		busco = true;
		Messages.addFlashGlobalInfo("MEDICAMENTO ENCONTRADO");
		
	}else{
		Messages.addFlashGlobalError("MEDICAMENTO  NO EXISTE");
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
 * Metodo paara modificcar un farmaceutico
 */
public void modificarMedicamento(Medicamento exa) {
	medi = exa;
	fecha_expedicion = exa.getFechaExpedicion();
	fecha_expiracion = exa.getFechaExpiracion();
	laboratorio = exa.getLaboratorio();
	cantidad = exa.getCantidad() + "";
	nombre = exa.getNombre();
	estado = exa.isEstado();
	busco = true;
}

public void editar() {
	medi.setNombre(nombre);
	medi.setLaboratorio(laboratorio);
	medi.setFechaExpedicion(fecha_expedicion);
	medi.setFechaExpiracion(fecha_expiracion);
	medi.setEstado(estado);
	medi.setCantidad(Integer.parseInt(cantidad));
	mediEJB.editarMedicamento(medi);
	limpiar();
	busco = false;
	Messages.addGlobalInfo("EL MEDICAMENTO FUE MODIFICADO CORRECTAMENTE");
	limpiar();
}


/**
 * Metodo que elimina un farmaceutico
 */
public void eliminar(Medicamento exa) {
	try {
		mediEJB.eliminarMedicamento(exa.getCodigo());
		busco = false;
		limpiar();
		Messages.addFlashGlobalInfo("SE HA ELIMINADO CORRECTAMENTE EL MEDICAMENTO");
		medicamentos = mediEJB.listarMedicamentos();
		resetearFitrosTabla("tablaExamenes");
	} catch (Exception e) {
		// TODO: handle exception
	}
}

}
