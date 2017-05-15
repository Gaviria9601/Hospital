package co.edu.eam.ingesoft.hospital.web.convertidores;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import co.edu.eam.ingesoft.hospital.entidades.Especializacion;
import co.edu.eam.ingesoft.pa.negocio.beans.MedicoEJB;

@FacesConverter(value = "espConverter", forClass = Especializacion.class)
@Named("espConverter")
public class EspecializacionCoverter implements Converter {
	
	@EJB
	private MedicoEJB medicoEJB;

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String string) {
		if (string == null || string.trim().length() == 0 || string.equals("Seleccione...")) {
			return null;
		}
		return medicoEJB.buscarEspecializacion(Integer.parseInt(string));
	
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object obj) {
		if (obj instanceof Especializacion) {
			Especializacion esp = (Especializacion) obj;
			return esp.getCodigo()+"";
		}
		
		return null;
	}

}
