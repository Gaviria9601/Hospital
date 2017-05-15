package co.edu.eam.ingesoft.hospital.web.convertidores;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import co.edu.eam.ingesoft.hospital.entidades.TipoCirugia;
import co.edu.eam.ingesoft.pa.negocio.beans.CirugiaEJB;

@FacesConverter(value = "tipoCiruConverter",forClass = TipoCirugia.class)
@Named("tipoCiruConverter")
public class TipoCirugiaConverter implements Converter {
	
	@EJB
	private CirugiaEJB cirugiaEJB;

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String string) {
		if (string == null || string.trim().length() == 0 || string.equals("Seleccione...")) {
			return null;
		}
		return cirugiaEJB.buscarTipoCirugia(Integer.parseInt(string));
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object obj) {
		if (obj instanceof TipoCirugia) {
			TipoCirugia tipoCiru = (TipoCirugia) obj;
			return tipoCiru.getCodigo()+"";
		}
		
		return null;
	}

	
	
}
