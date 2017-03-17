/**
 * 
 */
package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Alejandro Ortega
 *
 */
@Entity
@Table(name = "OrdenCitaAvanzada")
public class OrdenCitaAvanzada implements Serializable {

	@Id
	@Column(name = "codigo", length = 10)
	private String codigo;
	
	 @Column(name = "observaciones", length =1000)
		private String observaciones;
	 
	 @Temporal(TemporalType.DATE)
		@Column(name = "fecha", nullable=false)
		private Date fecha;
	    
	    @Temporal(TemporalType.TIMESTAMP)
		@Column(name = "hora_inicio", nullable=false)
		private Date horaInicio;
	    
	    @Temporal(TemporalType.TIMESTAMP)
		@Column(name = "hora_final", nullable=false)
		private Date horaFinal;
	    
	    @ManyToOne
		@JoinColumn(name = "medico_usuario_cedula", nullable=false)
		private Medico medicoUsuarioCedula;
	    
	    @ManyToOne
		@JoinColumn(name = "instalacion_codigo", nullable=true)
		private Instalacion instalacionCodigo;
	    
	    @ManyToOne
		@JoinColumn(name = "cita_codigo", nullable=false)
		private Cita citaCodigo;
	    
	    @ManyToOne
		@JoinColumn(name = "cita_avanzada_codigo", nullable=false)
		private CitaAvanzada citaAvanzadaCodigo;
	    
	    @ManyToOne
		@JoinColumn(name = "resultadoExamen_id", nullable=false, unique=true)
		private ResultadoExamen resultadoExamenId;
	    
	    public OrdenCitaAvanzada(){
	    	
	    }

		public OrdenCitaAvanzada(String codigo, String observaciones, Date fecha, Date horaInicio, Date horaFinal,
				Medico medicoUsuarioCedula, Instalacion instalacionCodigo, Cita citaCodigo,
				CitaAvanzada citaAvanzadaCodigo, ResultadoExamen resultadoExamenId) {
			super();
			this.codigo = codigo;
			this.observaciones = observaciones;
			this.fecha = fecha;
			this.horaInicio = horaInicio;
			this.horaFinal = horaFinal;
			this.medicoUsuarioCedula = medicoUsuarioCedula;
			this.instalacionCodigo = instalacionCodigo;
			this.citaCodigo = citaCodigo;
			this.citaAvanzadaCodigo = citaAvanzadaCodigo;
			this.resultadoExamenId = resultadoExamenId;
		}

		/**
		 * @return the codigo
		 */
		public String getCodigo() {
			return codigo;
		}

		/**
		 * @param codigo the codigo to set
		 */
		public void setCodigo(String codigo) {
			this.codigo = codigo;
		}

		/**
		 * @return the observaciones
		 */
		public String getObservaciones() {
			return observaciones;
		}

		/**
		 * @param observaciones the observaciones to set
		 */
		public void setObservaciones(String observaciones) {
			this.observaciones = observaciones;
		}

		/**
		 * @return the fecha
		 */
		public Date getFecha() {
			return fecha;
		}

		/**
		 * @param fecha the fecha to set
		 */
		public void setFecha(Date fecha) {
			this.fecha = fecha;
		}

		/**
		 * @return the horaInicio
		 */
		public Date getHoraInicio() {
			return horaInicio;
		}

		/**
		 * @param horaInicio the horaInicio to set
		 */
		public void setHoraInicio(Date horaInicio) {
			this.horaInicio = horaInicio;
		}

		/**
		 * @return the horaFinal
		 */
		public Date getHoraFinal() {
			return horaFinal;
		}

		/**
		 * @param horaFinal the horaFinal to set
		 */
		public void setHoraFinal(Date horaFinal) {
			this.horaFinal = horaFinal;
		}

		/**
		 * @return the medicoUsuarioCedula
		 */
		public Medico getMedicoUsuarioCedula() {
			return medicoUsuarioCedula;
		}

		/**
		 * @param medicoUsuarioCedula the medicoUsuarioCedula to set
		 */
		public void setMedicoUsuarioCedula(Medico medicoUsuarioCedula) {
			this.medicoUsuarioCedula = medicoUsuarioCedula;
		}

		/**
		 * @return the instalacionCodigo
		 */
		public Instalacion getInstalacionCodigo() {
			return instalacionCodigo;
		}

		/**
		 * @param instalacionCodigo the instalacionCodigo to set
		 */
		public void setInstalacionCodigo(Instalacion instalacionCodigo) {
			this.instalacionCodigo = instalacionCodigo;
		}

		/**
		 * @return the citaCodigo
		 */
		public Cita getCitaCodigo() {
			return citaCodigo;
		}

		/**
		 * @param citaCodigo the citaCodigo to set
		 */
		public void setCitaCodigo(Cita citaCodigo) {
			this.citaCodigo = citaCodigo;
		}

		/**
		 * @return the citaAvanzadaCodigo
		 */
		public CitaAvanzada getCitaAvanzadaCodigo() {
			return citaAvanzadaCodigo;
		}

		/**
		 * @param citaAvanzadaCodigo the citaAvanzadaCodigo to set
		 */
		public void setCitaAvanzadaCodigo(CitaAvanzada citaAvanzadaCodigo) {
			this.citaAvanzadaCodigo = citaAvanzadaCodigo;
		}

		/**
		 * @return the resultadoExamenId
		 */
		public ResultadoExamen getResultadoExamenId() {
			return resultadoExamenId;
		}

		/**
		 * @param resultadoExamenId the resultadoExamenId to set
		 */
		public void setResultadoExamenId(ResultadoExamen resultadoExamenId) {
			this.resultadoExamenId = resultadoExamenId;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
			return result;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			OrdenCitaAvanzada other = (OrdenCitaAvanzada) obj;
			if (codigo == null) {
				if (other.codigo != null)
					return false;
			} else if (!codigo.equals(other.codigo))
				return false;
			return true;
		}
	    
	    

}
