/**
 * 
 */
package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author Alejandro Ortega
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name=Cirugia.LISTAR_CIRUGIAS,query= "select ciru from Cirugia ciru")
})
@Table(name = "Cirugia")
public class Cirugia extends CitaAvanzada implements Serializable {
	
	public static final String LISTAR_CIRUGIAS = "ListarCirugias";

	@Column(name = "recuperacion", length = 200, nullable = false)
	private String recuperacion;

	@Column(name = "anestesia")
	private boolean anestesia;

	@ManyToOne
	@JoinColumn(name = "tipoCirugia_codigo", nullable = false)
	private TipoCirugia tipoCirugia;

	@ManyToOne
	@JoinColumn(name = "especializacion_codigo", nullable = false)
	private Especializacion especializacionCodigo;

	public Cirugia() {

	}

	public Cirugia(String recuperacion, boolean anestesia, TipoCirugia tipoCirugia,
			Especializacion especializacionCodigo) {
		super();
		this.recuperacion = recuperacion;
		this.anestesia = anestesia;
		this.tipoCirugia = tipoCirugia;
		this.especializacionCodigo = especializacionCodigo;
	}

	public String getRecuperacion() {
		return recuperacion;
	}

	public void setRecuperacion(String recuperacion) {
		this.recuperacion = recuperacion;
	}

	public boolean isAnestesia() {
		return anestesia;
	}

	public void setAnestesia(boolean anestesia) {
		this.anestesia = anestesia;
	}

	public TipoCirugia getTipoCirugia() {
		return tipoCirugia;
	}

	public void setTipoCirugia(TipoCirugia tipoCirugia) {
		this.tipoCirugia = tipoCirugia;
	}

	public Especializacion getEspecializacionCodigo() {
		return especializacionCodigo;
	}

	public void setEspecializacionCodigo(Especializacion especializacionCodigo) {
		this.especializacionCodigo = especializacionCodigo;
	}

}
