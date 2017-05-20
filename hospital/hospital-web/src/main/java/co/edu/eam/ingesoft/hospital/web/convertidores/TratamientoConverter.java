package co.edu.eam.ingesoft.hospital.web.convertidores;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import co.edu.eam.ingesoft.hospital.entidades.Tratamiento;
import co.edu.eam.ingesoft.pa.negocio.beans.TratamientoEJB;

@FacesConverter(value = "tratamientoConverter", forClass = Tratamiento.class)
@Named("tratamientoConverter")
public class TratamientoConverter implements Converter {

	@EJB
	private TratamientoEJB tratamientoEJB;

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String string) {
		if (string == null || string.trim().length() == 0 || string.equals("Seleccione...")) {
			return null;
		}
		return tratamientoEJB.buscarTratamiento(Integer.parseInt(string));
	
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object obj) {
		if (obj instanceof Tratamiento) {
			Tratamiento tra = (Tratamiento) obj;
			return tra.getCodigo()+"";
		}
		
		return null;
	}
	
}
