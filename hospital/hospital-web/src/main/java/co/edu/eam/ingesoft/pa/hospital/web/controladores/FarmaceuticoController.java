package co.edu.eam.ingesoft.pa.hospital.web.controladores;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.hospital.entidades.Farmaceutico;
import co.edu.eam.ingesoft.hospital.entidades.Farmacia;
import co.edu.eam.ingesoft.hospital.entidades.Medico;
import co.edu.eam.ingesoft.hospital.enumeraciones.TipoUsuarioEnum;
import co.edu.eam.ingesoft.pa.negocio.beans.FarmaceuticoEJB;
import co.edu.eam.ingesoft.pa.negocio.excepciones.ExcepcionNegocio;
@Named("farmaceuticoControlador")
@ViewScoped
public class FarmaceuticoController implements Serializable  {
	
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
	@Length(min=7,max=10,message="longitud entre 7 y 10")
	private String telefono;
	
	@Pattern(regexp="[0-9]*",message="solo numeros")
	@Length(min=2,max=4,message="longitud entre 2 y 4")
	private String edad;
	
	@Pattern(regexp="[A-Za-z ]*",message="solo Letras")
	@Length(min=3,max=50,message="longitud entre 3 y 50")
	private String nickname;
	
	private String contrasenia;
	
	@Pattern(regexp="[0-9]*",message="solo numeros")
	@Length(min=5,max=15,message="longitud entre 5 y 15")
	private String tarjetapro;
	
	private Date fecha;
	
	private int codigofarmacia;
	
	private boolean busco = false;
	
	
	
	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public boolean isBusco() {
		return busco;
	}

	public void setBusco(boolean busco) {
		this.busco = busco;
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

	public String getTarjetapro() {
		return tarjetapro;
	}

	public void setTarjetapro(String tarjetapro) {
		this.tarjetapro = tarjetapro;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}



	public int getCodigofarmacia() {
		return codigofarmacia;
	}

	public void setCodigofarmacia(int codigofarmacia) {
		this.codigofarmacia = codigofarmacia;
	}

	public FarmaceuticoEJB getFarEJB() {
		return farEJB;
	}

	public void setFarEJB(FarmaceuticoEJB farEJB) {
		this.farEJB = farEJB;
	}

	@EJB
	private FarmaceuticoEJB farEJB;
	
	@PostConstruct
	public void inicializador(){
		
	
	}
	/**
	 * Metodo que crear el farmaceutico
	 */
	
	public void crearFarmaceutico(){
		try{
			Date fecha = farEJB.generarFechaActual();
			Farmacia fa = farEJB.buscarFarmacia(3434);
		    Farmaceutico farm = new Farmaceutico(cedula, nickname, contrasenia, nombre, apellido,Integer.parseInt(edad),
					correo, TipoUsuarioEnum.Farmaceutico, telefono, tarjetapro, fecha, fa);
		   farEJB.crearFarmaceutico(farm);
		   limpiar();
		    Messages.addFlashGlobalInfo("FARMACEUTICO INGRESADO AL SISTEMA CORRECTAMENTE");
		    
		} catch (ExcepcionNegocio e) {
	       Messages.addGlobalError(e.getMessage());
		   }
		}
	/**
	 * Metodo que limpiar los campos del farmaceutico
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
		tarjetapro= "";
		busco = false;
		}
   /**
    * Metodo para buscar un farmaceutico
    */
public void buscarFarmaceutico(){
	Farmaceutico f = farEJB.buscarFarmaceutico(cedula);
	if(f!=null){
		nombre = f.getNombre();
		apellido  = f.getApellido();
		cedula = f.getCedula();
		nickname = f.getNickname();
		correo= f.getCorreo();
		contrasenia = f.getClave();
		edad = f.getEdad() + "";
		telefono = f.getTelefono();
		tarjetapro = f.getTarjetaProfesional();	
		busco = true;
		Messages.addFlashGlobalInfo("FARMACEUTICO ENCONTRADO");
		
	}else{
		Messages.addFlashGlobalError("FARMACEUTICO  NO EXISTE");
 	}
}
/**
 * Metodo paara modificcar un farmaceutico
 */
public void modificarFarmaceutico(){
	try{
	Farmaceutico f = farEJB.buscarFarmaceutico(cedula);
	f.setNickname(nickname);
	f.setClave(contrasenia);
	f.setNombre(nombre);
	f.setApellido(apellido);
	f.setEdad(Integer.parseInt(edad));
	f.setCorreo(correo);
	f.setTelefono(telefono);
	f.setTarjetaProfesional(tarjetapro);
	farEJB.modificarFarmaceutico(f);
	limpiar();
	busco = false;
	Messages.addFlashGlobalInfo("FARMACEUTICO MODIFICADO CORRECTAMENTE");
	}catch (ExcepcionNegocio e) {
		Messages.addGlobalError(e.getMessage());
	}
}
/**
 * Metodo que elimina un farmaceutico
 */
public void eliminarFarmaceutico(){
	try {
		Farmaceutico fa = farEJB.buscarFarmaceutico(cedula);
		if(fa!=null){
			farEJB.eliminarFarmaceutico(fa);
			busco = false;
			Messages.addFlashGlobalInfo("FARMACEUTICO ELIMINADO EXITOSAMENTE");
		}else{
			Messages.addGlobalError("ERROR AL ELIMINAR");
		}
	} catch (ExcepcionNegocio e) {
		Messages.addGlobalError(e.getMessage());
	}
}

	}



