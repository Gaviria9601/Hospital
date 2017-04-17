package co.edu.eam.ingesoft.pa.hospital.web.controladores;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.hospital.entidades.Usuario;
import co.edu.eam.ingesoft.pa.negocio.beans.SeguridadEJB;

@Named("sessionControl")
@SessionScoped
public class SessionController implements Serializable {
	
	private String user;
	private String pass;
	
	private Usuario usuario;
	
	@EJB
	private SeguridadEJB segEJB;
	
	/**
	 * Logea un usuario al sistema
	 */
	public String login() {
		if (user.isEmpty() || pass.isEmpty()) {
			Messages.addFlashGlobalWarn("Digite los datos para ingresar");
		} else {
			Usuario userTemp = segEJB.buscarUsuario(user);
			if (userTemp != null) {
				if (userTemp.getClave().equals(pass)) {
					usuario = userTemp;
					Faces.setSessionAttribute("user", usuario);
					return "/paginas/seguro/inicio.xhtml?faces-redirect=true";

				} else {
					Messages.addFlashGlobalError("Usuario o  Pass Incorrecto");
				}

			} else {
				Messages.addFlashGlobalError("Usuario o  Pass Incorrecto");
			}
		}
		return null;

	}

	/**
	 * 
	 * @return
	 */
	public String cerrarSesion() {
		usuario = null;
		HttpSession sesion;
		sesion = (HttpSession) Faces.getSession();
		sesion.invalidate();
		return "/paginas/publico/login.xhtml?faces-redirect=true";
	}

	public boolean isSesion() {
		return usuario != null;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
	

}
