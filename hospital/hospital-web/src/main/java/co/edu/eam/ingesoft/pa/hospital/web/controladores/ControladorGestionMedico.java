/**
 * 
 */
package co.edu.eam.ingesoft.pa.hospital.web.controladores;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.hospital.entidades.Medico;
import co.edu.eam.ingesoft.hospital.enumeraciones.TipoUsuarioEnum;
import co.edu.eam.ingesoft.pa.negocio.beans.MedicoEJB;
import co.edu.eam.ingesoft.pa.negocio.excepciones.ExcepcionNegocio;

/**
 * @author Alejandro Ortega
 *
 */
@Named("ControladorMedico")
@ViewScoped
public class ControladorGestionMedico implements Serializable{
	
	@Pattern(regexp="[0-9]*",message="solo numeros")
	@Length(min=4,max=15,message="longitud entre 4 y 15")
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
	
	private int edad;
	
	@Length(max=20,message="maximo 20 digitos")
	private String nickname;
	
	private String contrasenia;
	
	@Pattern(regexp="[0-9]*",message="solo numeros")
	private String carnet;
	
	@Pattern(regexp="[A-Za-z ]*",message="solo Letras")
	@Length(min=3,max=50,message="longitud entre 3 y 50")
	private String facultad;
	
	private boolean estado;
	
	private boolean busco = false;
	 
	
	@PostConstruct
	public void inicializar(){
	carnet = medicoejb.generarCarnet();	
	}
	
	@EJB
	private MedicoEJB medicoejb;
	
	public void limpiar(){
		
		nombre ="";
		apellido  ="";
		cedula ="";
		nickname ="";
		correo="";
		contrasenia = "";
		edad = 0;
		telefono = "";
		facultad = "";
		carnet = medicoejb.generarCarnet();
		busco = false;
		
	}
	
	public void crear(){
		try{
		Medico cli = new Medico(cedula, nickname, contrasenia, nombre, apellido, edad, 
				correo, TipoUsuarioEnum.Medico, telefono,carnet,facultad,estado);
				medicoejb.crearMedico(cli);
				
				// limpiar campos
				limpiar();
		
				Messages.addFlashGlobalInfo("MEDICO INGRESADO AL SISTEMA CORRECTAMENTE");
		}catch(ExcepcionNegocio e){
			Messages.addGlobalError(e.getMessage());
		}
	}
	
	public void modificar(){
		try{
		Medico cli = medicoejb.buscarMedico(cedula);
		cli.setNickname(nickname);
		cli.setClave(contrasenia);
		cli.setNombre(nombre);
		cli.setApellido(apellido);
		cli.setEdad(edad);
		cli.setCorreo(correo);
		cli.setTelefono(telefono);
		cli.setFacultadMedicina(facultad);
		cli.setEstado(estado);
		medicoejb.modificarMedico(cli);
		limpiar();
		Messages.addFlashGlobalInfo("MEDICO MODIFICADO CORRECTAMENTE");
		}catch (ExcepcionNegocio e) {
			Messages.addGlobalError(e.getMessage());
		}
	}
	
	public void eliminar(){
		try {
			Medico med = medicoejb.buscarMedico(cedula);
			if(med!=null){
				medicoejb.eliminarMedico(med);
				Messages.addFlashGlobalInfo("MEDICO ELIMINADO EXITOSAMENTE");
			}else{
				Messages.addGlobalError("ERROR AL ELIMINAR");
			}
		} catch (ExcepcionNegocio e) {
			Messages.addGlobalError(e.getMessage());
		}
	}
	
	public void buscar(){
		Medico med = medicoejb.buscarMedico(cedula);
		if(med!=null){
			nombre = med.getNombre();
			apellido  = med.getApellido();
			cedula = med.getCedula();
			nickname = med.getNickname();
			correo= med.getCorreo();
			contrasenia = med.getClave();
			edad = med.getEdad();
			telefono = med.getTelefono();
			facultad = med.getFacultadMedicina();
			carnet = med.getCarnet();
			estado = med.isEstado();
			busco = true;			
			Messages.addFlashGlobalInfo("MEDICO ENCONTRADO");
			
		}else{
			Messages.addFlashGlobalError("MEDICO NO EXISTE");
	 	}
	}

	/**
	 * @return the cedula
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * @param cedula the cedula to set
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * @param edad the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * @param nickname the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * @return the contrasenia
	 */
	public String getContrasenia() {
		return contrasenia;
	}

	/**
	 * @param contrasenia the contrasenia to set
	 */
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	/**
	 * @return the carnet
	 */
	public String getCarnet() {
		return carnet;
	}

	/**
	 * @param carnet the carnet to set
	 */
	public void setCarnet(String carnet) {
		this.carnet = carnet;
	}

	/**
	 * @return the facultad
	 */
	public String getFacultad() {
		return facultad;
	}

	/**
	 * @param facultad the facultad to set
	 */
	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}

	/**
	 * @return the estado
	 */
	public boolean isEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(boolean estado) {
		this.estado = estado;
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


	

}
