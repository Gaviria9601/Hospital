/**
 * 
 */
package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Alejandro Ortega
 *
 */
 @Entity
 @Table(name="Cirugia")
public class Cirugia extends CitaAvanzada implements Serializable{

		@Column(name="recuperacion",  length=60)
		private String recuperacion;
	 
		@Column(name="anestesia")
		private boolean anestesia;
		
		@JoinColumn(name = "tipoCirugia_codigo")
		@ManyToOne
		private TipoCirugia tipoCirugia;
		
		@JoinColumn(name = "especializacion_codigo")
		@ManyToOne
		private TipoCirugia especializacionCodigo;
		
		
		public Cirugia(){
			
		}


		public Cirugia(String recuperacion, boolean anestesia, TipoCirugia tipoCirugia,
				TipoCirugia especializacionCodigo) {
			super();
			this.recuperacion = recuperacion;
			this.anestesia = anestesia;
			this.tipoCirugia = tipoCirugia;
			this.especializacionCodigo = especializacionCodigo;
		}


		/**
		 * @return the recuperacion
		 */
		public String getRecuperacion() {
			return recuperacion;
		}


		/**
		 * @param recuperacion the recuperacion to set
		 */
		public void setRecuperacion(String recuperacion) {
			this.recuperacion = recuperacion;
		}


		/**
		 * @return the anestesia
		 */
		public boolean isAnestesia() {
			return anestesia;
		}


		/**
		 * @param anestesia the anestesia to set
		 */
		public void setAnestesia(boolean anestesia) {
			this.anestesia = anestesia;
		}


		/**
		 * @return the tipoCirugia
		 */
		public TipoCirugia getTipoCirugia() {
			return tipoCirugia;
		}


		/**
		 * @param tipoCirugia the tipoCirugia to set
		 */
		public void setTipoCirugia(TipoCirugia tipoCirugia) {
			this.tipoCirugia = tipoCirugia;
		}


		/**
		 * @return the especializacionCodigo
		 */
		public TipoCirugia getEspecializacionCodigo() {
			return especializacionCodigo;
		}


		/**
		 * @param especializacionCodigo the especializacionCodigo to set
		 */
		public void setEspecializacionCodigo(TipoCirugia especializacionCodigo) {
			this.especializacionCodigo = especializacionCodigo;
		}
		
		
		
		
	 
}
