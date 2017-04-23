package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="MEDICAMENTOS")
public class Medicamento implements Serializable{
	
	@Id
	@Column(name="Codigo")
	private Integer codigo;
	
	@Column(name = "Nombre", length =40, nullable=false)
	private String nombre;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "Fecha_expedicion", nullable=false)
	private Date fechaExpedición;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "Fecha_expiracion", nullable=false)
	private Date fechaExpiración;
	
	@Column(name = "Laboratorio", length =40, nullable=false)
	private String laboratorio;
	
	@Column(name = "Cantidad", length = 40, nullable=false)
	private int cantidad;
	
	@Column(name = "Estado", nullable=false)
	private boolean estado;
	
	@ManyToOne
	@JoinColumn(name = "Farmacia_codigo", nullable=false)
	private Farmacia farmaciaCodigo;
	
	public Medicamento(){
		super();
	}

	public Medicamento(Integer codigo, String nombre, Date fechaExpedición, Date fechaExpiración, String laboratorio,
			int cantidad, boolean estado, Farmacia farmaciaCodigo) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.fechaExpedición = fechaExpedición;
		this.fechaExpiración = fechaExpiración;
		this.laboratorio = laboratorio;
		this.cantidad = cantidad;
		this.estado = estado;
		this.farmaciaCodigo = farmaciaCodigo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaExpedición() {
		return fechaExpedición;
	}

	public void setFechaExpedición(Date fechaExpedición) {
		this.fechaExpedición = fechaExpedición;
	}

	public Date getFechaExpiración() {
		return fechaExpiración;
	}

	public void setFechaExpiración(Date fechaExpiración) {
		this.fechaExpiración = fechaExpiración;
	}

	public String getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Farmacia getFarmaciaCodigo() {
		return farmaciaCodigo;
	}

	public void setFarmaciaCodigo(Farmacia farmaciaCodigo) {
		this.farmaciaCodigo = farmaciaCodigo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medicamento other = (Medicamento) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
