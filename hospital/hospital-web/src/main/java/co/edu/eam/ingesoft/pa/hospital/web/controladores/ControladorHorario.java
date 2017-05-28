package co.edu.eam.ingesoft.pa.hospital.web.controladores;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.hospital.entidades.Cita;
import co.edu.eam.ingesoft.hospital.entidades.Especializacion;
import co.edu.eam.ingesoft.hospital.entidades.Horario;
import co.edu.eam.ingesoft.hospital.entidades.Medico;
import co.edu.eam.ingesoft.hospital.entidades.Paciente;
import co.edu.eam.ingesoft.hospital.entidades.itemHorario;
import co.edu.eam.ingesoft.pa.negocio.beans.CitaEJB;
import co.edu.eam.ingesoft.pa.negocio.beans.HorarioEJB;
import co.edu.eam.ingesoft.pa.negocio.beans.MedicoEJB;
import co.edu.eam.ingesoft.pa.negocio.beans.PacienteEJB;
import co.edu.eam.ingesoft.pa.negocio.excepciones.ExcepcionNegocio;

/**
 * @author Alejandro Ortega
 *
 */
@Named("ControladorHorario")
@ViewScoped
public class ControladorHorario implements Serializable {

	private String fechaString;
	private Date fecha;
	private int codigoHorario;
	private int codigoHorario2;
	private String cedulaMedico;
	private String cedulaMedico2;
	private List<Medico> medicos2;
	private List<Medico> medicos;
	private int especializacion;
	private List<Especializacion> especializaciones;
	private int numero;
	private int numero2;
	private boolean primeracita = false;
	private Paciente paciente;

	@EJB
	MedicoEJB medicoejb;

	@EJB
	HorarioEJB horarioejb;

	@EJB
	CitaEJB citaejb;

	@EJB
	PacienteEJB pacienteejb;

	@Inject
	private SessionController sesion;

	@PostConstruct
	public void inicializar() {
		especializaciones = medicoejb.listarEspecializaciones();
		medicos = medicoejb.listarMedicos();

	}

	public void seleccionarEspecializacion() {

		if (especializacion != 0) {
			Especializacion esp = medicoejb.buscarEspecializacion(especializacion);
			System.out.println(esp.getNombre());
			medicos2 = medicoejb.listarMedicosxEspecializacion(especializacion);
		} else {
			medicos2 = null;
		}

	}

	public void asignarGeneral() {
		try {
			SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
			fecha = formatoDelTexto.parse(fechaString);
			Paciente paciente1 = pacienteejb.buscarPaciente("200000");
			Medico med = medicoejb.buscarMedico(cedulaMedico);
			Horario horario = horarioejb.buscarHorario(codigoHorario);
			itemHorario item = new itemHorario(med, horario, fecha, false);
			citaejb.asignarHorarioMedico(item,paciente1,numero);

			Messages.addFlashGlobalInfo("Cita asignada el dia " + fecha + " a la hora " + horario.getHoraInicio().getTime());
		} catch (ExcepcionNegocio e) {
			Messages.addGlobalError(e.getMessage());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			Messages.addGlobalError(e.getMessage());
		}
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha
	 *            the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the codigoHorario
	 */
	public int getCodigoHorario() {
		return codigoHorario;
	}

	/**
	 * @param codigoHorario
	 *            the codigoHorario to set
	 */
	public void setCodigoHorario(int codigoHorario) {
		this.codigoHorario = codigoHorario;
	}

	/**
	 * @return the cedulaMedico
	 */

	/**
	 * @return the medicos
	 */
	public List<Medico> getMedicos() {
		return medicos;
	}

	/**
	 * @param medicos
	 *            the medicos to set
	 */
	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}

	/**
	 * @return the especializacion
	 */
	public int getEspecializacion() {
		return especializacion;
	}

	/**
	 * @param especializacion
	 *            the especializacion to set
	 */
	public void setEspecializacion(int especializacion) {
		this.especializacion = especializacion;
	}

	/**
	 * @return the especializaciones
	 */
	public List<Especializacion> getEspecializaciones() {
		return especializaciones;
	}

	/**
	 * @param especializaciones
	 *            the especializaciones to set
	 */
	public void setEspecializaciones(List<Especializacion> especializaciones) {
		this.especializaciones = especializaciones;
	}

	/**
	 * @return the medicos2
	 */
	public List<Medico> getMedicos2() {
		return medicos2;
	}

	/**
	 * @param medicos2
	 *            the medicos2 to set
	 */
	public void setMedicos2(List<Medico> medicos2) {
		this.medicos2 = medicos2;
	}

	/**
	 * @return the primeracita
	 */
	public boolean isPrimeracita() {
		return primeracita;
	}

	/**
	 * @param primeracita
	 *            the primeracita to set
	 */
	public void setPrimeracita(boolean primeracita) {
		this.primeracita = primeracita;
	}

	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @param numero
	 *            the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * @return the cedulaMedico
	 */
	public String getCedulaMedico() {
		return cedulaMedico;
	}

	/**
	 * @param cedulaMedico
	 *            the cedulaMedico to set
	 */
	public void setCedulaMedico(String cedulaMedico) {
		this.cedulaMedico = cedulaMedico;
	}

	/**
	 * @return the paciente
	 */
	public Paciente getPaciente() {
		return paciente;
	}

	/**
	 * @param paciente
	 *            the paciente to set
	 */
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	/**
	 * @return the fechaString
	 */
	public String getFechaString() {
		return fechaString;
	}

	/**
	 * @param fechaString
	 *            the fechaString to set
	 */
	public void setFechaString(String fechaString) {
		this.fechaString = fechaString;
	}

	/**
	 * @return the cedulaMedico2
	 */
	public String getCedulaMedico2() {
		return cedulaMedico2;
	}

	/**
	 * @param cedulaMedico2
	 *            the cedulaMedico2 to set
	 */
	public void setCedulaMedico2(String cedulaMedico2) {
		this.cedulaMedico2 = cedulaMedico2;
	}

	/**
	 * @return the codigoHorario2
	 */
	public int getCodigoHorario2() {
		return codigoHorario2;
	}

	/**
	 * @param codigoHorario2
	 *            the codigoHorario2 to set
	 */
	public void setCodigoHorario2(int codigoHorario2) {
		this.codigoHorario2 = codigoHorario2;
	}

	/**
	 * @return the numero2
	 */
	public int getNumero2() {
		return numero2;
	}

	/**
	 * @param numero2 the numero2 to set
	 */
	public void setNumero2(int numero2) {
		this.numero2 = numero2;
	}

}
