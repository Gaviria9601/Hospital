package co.edu.eam.ingesoft.hospital.web.convertidores;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import co.edu.eam.ingesoft.hospital.entidades.Causa;
import co.edu.eam.ingesoft.pa.negocio.beans.CausaEJB;

@FacesConverter(value = "causaConverter", forClass = Causa.class)
@Named("causaConverter")
public class CausaConverter implements Converter {
	
	@EJB
	private CausaEJB causaEJB;

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String string) {
		if (string == null || string.trim().length() == 0 || string.equals("Seleccione...")) {
			return null;
		}
		return causaEJB.buscarCausa(Integer.parseInt(string));
	
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object obj) {
		if (obj instanceof Causa) {
			Causa cau = (Causa) obj;
			return cau.getCodigo()+"";
		}
		
		return null;
	}
	
	
}
