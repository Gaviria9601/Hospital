package co.edu.eam.ingesoft.pa.hospital.web.controladores;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.hospital.entidades.Afiliacion;
import co.edu.eam.ingesoft.hospital.entidades.Farmaceutico;
import co.edu.eam.ingesoft.hospital.entidades.Paciente;
import co.edu.eam.ingesoft.hospital.entidades.Usuario;
import co.edu.eam.ingesoft.hospital.enumeraciones.EstratoEnumeracion;
import co.edu.eam.ingesoft.hospital.enumeraciones.TipoUsuarioEnum;
import co.edu.eam.ingesoft.pa.negocio.beans.PacienteEJB;
import co.edu.eam.ingesoft.pa.negocio.excepciones.ExcepcionNegocio;

@Named("pacienteControlador")
@ViewScoped
public class PacienteController implements Serializable{
	
	@Pattern(regexp="[0-9]*",message="solo numeros")
	@Length(min=6,max=10,message="longitud entre 6 y 10")
	private String cedula;
	
	@Pattern(regexp="[A-Za-z ]*",message="solo Letras")
	@Length(min=3,max=50,message="longitud entre 3 y 50")
	private String nombre;
	
	@Pattern(regexp="[A-Za-z ]*",message="solo Letras")
	@Length(min=3,max=50,message="longitud entre 3 y 50")
	private String apellido;
	
	@Email
	private String correo;
	
	@Pattern(regexp="[0-9]*",message="solo numeros")
	@Length(max=20,message="maximo 20 digitos")
	private String telefono;
	
	@Pattern(regexp="[0-9]*",message="solo numeros")
	@Length(max=20,message="maximo 20 digitos")
	private String edad;
	
	@Length(max=20,message="maximo 20 digitos")
	private String nickname;
	
	private String contrasenia;
	
	
	private EstratoEnumeracion estrato;
	
	public EstratoEnumeracion[] getTipos(){
		return EstratoEnumeracion.values();
	}
	
	private Integer afiliacionCodigo;
	
	@Pattern(regexp="[A-Za-z ]*",message="Este campo solo acepta letras")
	@Length(min=4,max=150,message="longitud entre 4 y 150")
	private String trabajo;
	
	
	private List<Afiliacion> listaafiliaciones;
	private List<Paciente> listapaciente;
	
	private boolean busco = false;
	
	private Afiliacion afi;
	
	
	public Afiliacion getAfi() {
		return afi;
	}



	public void setAf(Afiliacion afi) {
		this.afi = afi;
	}



	public boolean isBusco() {
		return busco;
	}



	public void setBusco(boolean busco) {
		this.busco = busco;
	}

	@EJB
	private PacienteEJB paciEJB;
	
	@PostConstruct
	public void inicializador(){
		listaafiliaciones = paciEJB.listarAfiliacion();
		listapaciente = paciEJB.listarPaciente();
	}
	 
	
	
	public String getCedula() {
		return cedula;
	}



	public void setCedula(String cedula) {
		this.cedula = cedula;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public String getCorreo() {
		return correo;
	}



	public void setCorreo(String correo) {
		this.correo = correo;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	



	public String getEdad() {
		return edad;
	}



	public void setEdad(String edad) {
		this.edad = edad;
	}



	public String getNickname() {
		return nickname;
	}



	public void setNickname(String nickname) {
		this.nickname = nickname;
	}



	public String getContrasenia() {
		return contrasenia;
	}



	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}



	public EstratoEnumeracion getEstrato() {
		return estrato;
	}



	public void setEstrato(EstratoEnumeracion estrato) {
		this.estrato = estrato;
	}





	public Integer getAfiliacionCodigo() {
		return afiliacionCodigo;
	}



	public void setAfiliacionCodigo(Integer afiliacionCodigo) {
		this.afiliacionCodigo = afiliacionCodigo;
	}



	public String getTrabajo() {
		return trabajo;
	}



	public void setTrabajo(String trabajo) {
		this.trabajo = trabajo;
	}




	public List<Afiliacion> getListaafiliaciones() {
		return listaafiliaciones;
	}



	public void setListaafiliaciones(List<Afiliacion> listaafiliaciones) {
		this.listaafiliaciones = listaafiliaciones;
	}



	public List<Paciente> getListapaciente() {
		return listapaciente;
	}



	public void setListapaciente(List<Paciente> listapaciente) {
		this.listapaciente = listapaciente;
	}



	public PacienteEJB getPaciEJB() {
		return paciEJB;
	}



	public void setPaciEJB(PacienteEJB paciEJB) {
		this.paciEJB = paciEJB;
	}
 /**
  * Metodo para crear un paciente
  */
    public void crearPaciente(){
	try{
		Afiliacion a = paciEJB.buscarAfiliacion(afiliacionCodigo);
		Paciente pa = new Paciente (cedula, nickname, contrasenia, nombre, apellido,Integer.parseInt(edad),
				correo, TipoUsuarioEnum.Paciente, telefono,estrato, a, trabajo);
		
		paciEJB.crearPaciente(pa);
		limpiar();
		Messages.addFlashGlobalInfo("PACIENTE INGRESADO AL SISTEMA CORRECTAMENTE");
			
	} catch (ExcepcionNegocio e) {
	       Messages.addGlobalError(e.getMessage());
		   }
	}
	/**
	 *Metodo para limpiar los campos del paciente
	 */
	public void limpiar(){
		
		nombre ="";
		apellido  ="";
		cedula ="";
		nickname ="";
		correo="";
		contrasenia = "";
		edad = "";
		telefono = "";
	    trabajo = "";
	    busco = false;
		}
	
public void buscarPaciente(){
		
		Paciente pa = paciEJB.buscarPaciente(cedula);
		if(pa!=null){
			nombre = pa.getNombre();
			apellido  = pa.getApellido();
			cedula = pa.getCedula();
			nickname = pa.getNickname();
			correo=pa.getCorreo();
			contrasenia = pa.getClave();
			edad = pa.getEdad()  + "";
			telefono = pa.getTelefono();
			estrato = pa.getEstrato();
			trabajo= pa.getTrabajo();
		    afiliacionCodigo =pa.getAfiliacionCodigo().getCodigo();
			busco = true;
			Messages.addFlashGlobalInfo("PACIENTE ENCONTRADO");
			
		}else{
			Messages.addFlashGlobalError("PACIENTE  NO EXISTE");
	 	}
	}



public void borrarPaciente() {
	try {
		Paciente pac = paciEJB.buscarPaciente(cedula);
		if(pac!=null){
			paciEJB.eliminarPaciente(pac);
			   busco = false;
			   limpiar();
			   cedula = "";
			Messages.addFlashGlobalInfo("PACIENTE ELIMINADO EXITOSAMENTE");
		}else{
			Messages.addGlobalError("ERROR AL ELIMINAR");
		}
	} catch (ExcepcionNegocio e) {
		Messages.addGlobalError(e.getMessage());
	}

}
public void modificarPaciente(){
	try{
	Paciente f = paciEJB.buscarPaciente(cedula);
	f.setNickname(nickname);
	f.setClave(contrasenia);
	f.setNombre(nombre);
	f.setApellido(apellido);
	f.setEdad(Integer.parseInt(edad) );
	f.setCorreo(correo);
	f.setTelefono(telefono);
	f.setEstrato(estrato);
	f.setTrabajo(trabajo);
	paciEJB.modificarPaciente(f);
	limpiar();
	cedula = "";
	   busco = false;
	Messages.addFlashGlobalInfo("PACIENTE MODIFICADO CORRECTAMENTE");
	}catch (ExcepcionNegocio e) {
		Messages.addGlobalError(e.getMessage());
	}
}
}
	
	
	
	
	
	
	
	
	


