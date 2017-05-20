package co.edu.eam.ingesoft.hospital.web.convertidores;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import co.edu.eam.ingesoft.hospital.entidades.Sintoma;
import co.edu.eam.ingesoft.pa.negocio.beans.SintomaEJB;

@FacesConverter(value = "sintomaConverter", forClass = Sintoma.class)
@Named("sintomaConverter")
public class SintomaConverter implements Converter {

	@EJB
	private SintomaEJB sintomaEJB;

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String string) {
		if (string == null || string.trim().length() == 0 || string.equals("Seleccione...")) {
			return null;
		}
		return sintomaEJB.buscarSintoma(Integer.parseInt(string));
	
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object obj) {
		if (obj instanceof Sintoma) {
			Sintoma sin = (Sintoma) obj;
			return sin.getCodigo()+"";
		}
		
		return null;
	}
	
	
}
