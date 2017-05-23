package co.edu.eam.ingesoft.pa.hospital.web.controladores;

import java.io.Serializable;
import java.util.Date;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.hospital.entidades.Usuario;
import co.edu.eam.ingesoft.hospital.enumeraciones.TipoUsuarioEnum;
import co.edu.eam.ingesoft.pa.negocio.beans.SeguridadEJB;

@Named("sessionControl")
@SessionScoped
public class SessionController implements Serializable {

	private String user;
	private String pass;

	private Usuario usuario;
	private TipoUsuarioEnum tipoUsuario = TipoUsuarioEnum.Administrador;

	@EJB
	private SeguridadEJB segEJB;

	
	
	/**
	 * Logea un usuario al sistema
	 */
	public String login() {
		try {
			if (user.isEmpty() || pass.isEmpty()) {
				Messages.addFlashGlobalWarn("Digite los datos para ingresar");
			} else {
				Usuario userTemp = segEJB.buscarUsuario(user);
				tipoUsuario = userTemp.getTipoUsuario();
				if (userTemp != null) {
					if (userTemp.getClave().equals(pass)) {
						usuario = userTemp;
						setTipoUsuario(usuario.getTipoUsuario());
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
		} catch (Exception e) {
			Messages.addFlashGlobalError("Usuario no Registrado");
			return "/paginas/seguro/templates/template.xhtml?faces-redirect=true";
		}
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
		return "/templates/template.xhtml?faces-redirect=true";
	}

	public boolean isSesion() {
		return usuario != null;
	}

	public boolean isSesionFarmaceutico() {
		return tipoUsuario.equals(TipoUsuarioEnum.Farmaceutico) && usuario != null;
	}

	public boolean isSesionAdmin() {
		return tipoUsuario.equals(TipoUsuarioEnum.Administrador) && usuario != null;
	}

	public boolean isSesionMedico() {
		return tipoUsuario.equals(TipoUsuarioEnum.Medico) && usuario != null;
	}

	public boolean isSesionPaciente() {
		return tipoUsuario.equals(TipoUsuarioEnum.Paciente) && usuario != null;
	}

	public String getUser() {
		return user;
	}

	public TipoUsuarioEnum getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuarioEnum tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
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
