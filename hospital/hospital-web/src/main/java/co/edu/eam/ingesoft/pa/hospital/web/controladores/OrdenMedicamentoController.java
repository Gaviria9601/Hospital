package co.edu.eam.ingesoft.pa.hospital.web.controladores;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.hospital.entidades.Medicamento;
import co.edu.eam.ingesoft.hospital.entidades.OrdenMedicamento;
import co.edu.eam.ingesoft.hospital.entidades.Paciente;
import co.edu.eam.ingesoft.pa.negocio.beans.OrdenMedicamentoEJB;
import co.edu.eam.ingesoft.pa.negocio.excepciones.ExcepcionNegocio;

@Named("ordenMedicamentoControlador")
@ViewScoped
public class OrdenMedicamentoController implements Serializable{

	private  int medicamentoCodigo ;
	
	private int citaCodigo;
	
	private int cantidad;
	
	private String formula;
	
	private boolean estado;
	
	private String pacientes;
	
	private boolean busco = false;
	
	private OrdenMedicamento ormedi;
	
	private List<OrdenMedicamento> lista;
	
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

	public int getMedicamentoCodigo() {
		return medicamentoCodigo;
	}

	public void setMedicamentoCodigo(int medicamentoCodigo) {
		this.medicamentoCodigo = medicamentoCodigo;
	}

	public int getCitaCodigo() {
		return citaCodigo;
	}

	public void setCitaCodigo(int citaCodigo) {
		this.citaCodigo = citaCodigo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
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



	@EJB
	private OrdenMedicamentoEJB ormeEJB;
	
	@PostConstruct
	public void inicializar() {
		
		
	}
	
	public void listarOrden (){
		
		if(estado == false){
			lista = ormeEJB.listarOrden(pacientes);
		}else
			Messages.addFlashGlobalInfo("EL PACIENTE NO TIENE MEDICAMENTOS PARA ENTREGAR");
			
	}
	
	public void entregarMedi(OrdenMedicamento med){
		try{
		med.setEstado(false);
		ormeEJB.entregar(med);
		Messages.addFlashGlobalInfo("MEDICAMENTO ENTREGADO");
			
		}catch (ExcepcionNegocio e) {
			Messages.addGlobalError(e.getMessage());
		}
		
	}
	
}
