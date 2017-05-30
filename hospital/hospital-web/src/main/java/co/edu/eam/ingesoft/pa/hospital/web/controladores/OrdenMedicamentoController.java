package co.edu.eam.ingesoft.pa.hospital.web.controladores;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.hospital.entidades.Cita;
import co.edu.eam.ingesoft.hospital.entidades.Medicamento;
import co.edu.eam.ingesoft.hospital.entidades.OrdenMedicamento;
import co.edu.eam.ingesoft.hospital.entidades.Paciente;
import co.edu.eam.ingesoft.pa.negocio.beans.CitaEJB;
import co.edu.eam.ingesoft.pa.negocio.beans.MedicamentosEJB;
import co.edu.eam.ingesoft.pa.negocio.beans.OrdenMedicamentoEJB;
import co.edu.eam.ingesoft.pa.negocio.excepciones.ExcepcionNegocio;

@Named("ordenMedicamentoControlador")
@ViewScoped
public class OrdenMedicamentoController implements Serializable {

	private String medicamentoCodigo;

	private String citaCodigo;

	private String cantidad;

	private String formula;

	private boolean estado;

	private String pacientes;

	private boolean busco = false;

	private OrdenMedicamento ormedi;

	private List<OrdenMedicamento> lista;

	private List<Medicamento> listaMedicamento;

	@EJB
	private OrdenMedicamentoEJB ormeEJB;

	@EJB
	private CitaEJB citaEJB;

	@EJB
	private MedicamentosEJB mediEJB;

	@PostConstruct
	public void inicializar() {
		listaMedicamento = mediEJB.listarMedicamentos();
	}

	public void listarOrden() {

		if (estado == false) {
			lista = ormeEJB.listarOrden(pacientes);
		} else
			Messages.addFlashGlobalInfo("EL PACIENTE NO TIENE MEDICAMENTOS PARA ENTREGAR");

	}

	public void entregarMedi(OrdenMedicamento med) {
		try {
			med.setEstado(false);
			ormeEJB.entregar(med);
			Messages.addFlashGlobalInfo("MEDICAMENTO ENTREGADO");

		} catch (ExcepcionNegocio e) {
			Messages.addGlobalError(e.getMessage());
		}

	}

	public String crearOrden(Medicamento om) {
		try {
			ormeEJB.crearOrdenMedicamento(DatosManager.getCodigoCita(), om.getCodigo(),
					Integer.parseInt(cantidad), formula);
			Messages.addFlashGlobalInfo("ORDEN DE MEDICAMENTO REALIZADO");

		} catch (ExcepcionNegocio e) {
			Messages.addGlobalError(e.getMessage());
		}
		return "/paginas/seguro/agenda-medico.xhtml?faces-redirect=true";
	}

	/**
	 * @return the listaMedicamento
	 */
	public List<Medicamento> getListaMedicamento() {
		return listaMedicamento;
	}

	/**
	 * @param listaMedicamento
	 *            the listaMedicamento to set
	 */
	public void setListaMedicamento(List<Medicamento> listaMedicamento) {
		this.listaMedicamento = listaMedicamento;
	}

	public List<OrdenMedicamento> getLista() {
		return lista;
	}

	public void setLista(List<OrdenMedicamento> lista) {
		this.lista = lista;
	}

	public boolean isBusco() {
		return busco;
	}

	public void setBusco(boolean busco) {
		this.busco = busco;
	}

	public String getMedicamentoCodigo() {
		return medicamentoCodigo;
	}

	public void setMedicamentoCodigo(String medicamentoCodigo) {
		this.medicamentoCodigo = medicamentoCodigo;
	}

	public String getCitaCodigo() {
		return citaCodigo;
	}

	public void setCitaCodigo(String citaCodigo) {
		this.citaCodigo = citaCodigo;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public OrdenMedicamento getOrmedi() {
		return ormedi;
	}

	public void setOrmedi(OrdenMedicamento ormedi) {
		this.ormedi = ormedi;
	}

	public CitaEJB getCitaEJB() {
		return citaEJB;
	}

	public void setCitaEJB(CitaEJB citaEJB) {
		this.citaEJB = citaEJB;
	}

	public MedicamentosEJB getMediEJB() {
		return mediEJB;
	}

	public void setMediEJB(MedicamentosEJB mediEJB) {
		this.mediEJB = mediEJB;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getPacientes() {
		return pacientes;
	}

	public void setPacientes(String pacientes) {
		this.pacientes = pacientes;
	}

	public OrdenMedicamentoEJB getOrmeEJB() {
		return ormeEJB;
	}

	public void setOrmeEJB(OrdenMedicamentoEJB ormeEJB) {
		this.ormeEJB = ormeEJB;
	}

}
