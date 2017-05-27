package co.edu.eam.ingesoft.hospital.web.convertidores;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import co.edu.eam.ingesoft.hospital.entidades.TipoCirugia;
import co.edu.eam.ingesoft.hospital.entidades.TipoHospitalizacion;
import co.edu.eam.ingesoft.pa.negocio.beans.CirugiaEJB;
import co.edu.eam.ingesoft.pa.negocio.beans.HospitalizacionEJB;

@FacesConverter(value = "tipoHosConverter",forClass = TipoHospitalizacion.class)
@Named("tipoHosConverter")
public class TipoHospitalizacionConverter implements Converter {

	@EJB
	private HospitalizacionEJB hospitalizacionEJB;

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String string) {
		if (string == null || string.trim().length() == 0 || string.equals("Seleccione...")) {
			return null;
		}
		return hospitalizacionEJB.buscarTipoHospitalizacion(Integer.parseInt(string));
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object obj) {
		if (obj instanceof TipoHospitalizacion) {
			TipoHospitalizacion tipoHos = (TipoHospitalizacion) obj;
			return tipoHos.getCodigo()+"";
		}
		
		return null;
	}

	
}
