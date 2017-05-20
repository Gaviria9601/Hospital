package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import co.edu.eam.ingesoft.hospital.enumeraciones.LaboratorioEnum;





@Entity
@Table(name="MEDICAMENTO")
@NamedQueries({
@NamedQuery (name=Medicamento.LISTAR_MEDI, query="select m from Medicamento m")
})
public class Medicamento implements Serializable{
	
	public static final String LISTAR_MEDI = "ListarMedi";
	
	@Id
	@Column(name="Codigo")
	private int codigo;
	
	@Column(name = "Nombre", length =40, nullable=false)
	private String nombre;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_expedicion", nullable=false)
	private Date fechaExpedicion;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_expiracion", nullable=false)
	private Date fechaExpiracion;
	
	
	@Enumerated(EnumType.STRING)
	@Column(name = "Laboratorio", length =40, nullable=false)
	private LaboratorioEnum laboratorio;
	
	@Column(name = "Cantidad", length = 40, nullable=false)
	private int cantidad;
	
	@Column(name = "Estado", nullable=false)
	private boolean estado;
	
	@ManyToOne
	@JoinColumn(name = "Farmacia_codigo", nullable=false)
	private Farmacia farmaciaCodigo;

	public void setLaboratorio(LaboratorioEnum laboratorio) {
		this.laboratorio = laboratorio;
	}

	public LaboratorioEnum getLaboratorio() {
		return laboratorio;
	}


	public Medicamento() {
		super();
	}

	public Medicamento(String nombre, Date fechaExpedicion, Date fechaExpiracion,
			LaboratorioEnum laboratorio, int cantidad, boolean estado, Farmacia farmaciaCodigo) {
		super();
		
		this.nombre = nombre;
		this.fechaExpedicion = fechaExpedicion;
		this.fechaExpiracion = fechaExpiracion;
		this.laboratorio = laboratorio;
		this.cantidad = cantidad;
		this.estado = estado;
		this.farmaciaCodigo = farmaciaCodigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaExpedicion() {
		return fechaExpedicion;
	}

	public void setFechaExpedicion(Date fechaExpedicion) {
		this.fechaExpedicion = fechaExpedicion;
	}

	public Date getFechaExpiracion() {
		return fechaExpiracion;
	}

	public void setFechaExpiracion(Date fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
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

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cantidad;
		result = prime * result + codigo;
		result = prime * result + (estado ? 1231 : 1237);
		result = prime * result + ((farmaciaCodigo == null) ? 0 : farmaciaCodigo.hashCode());
		result = prime * result + ((fechaExpedicion == null) ? 0 : fechaExpedicion.hashCode());
		result = prime * result + ((fechaExpiracion == null) ? 0 : fechaExpiracion.hashCode());
		result = prime * result + ((laboratorio == null) ? 0 : laboratorio.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		if (cantidad != other.cantidad)
			return false;
		if (codigo != other.codigo)
			return false;
		if (estado != other.estado)
			return false;
		if (farmaciaCodigo == null) {
			if (other.farmaciaCodigo != null)
				return false;
		} else if (!farmaciaCodigo.equals(other.farmaciaCodigo))
			return false;
		if (fechaExpedicion == null) {
			if (other.fechaExpedicion != null)
				return false;
		} else if (!fechaExpedicion.equals(other.fechaExpedicion))
			return false;
		if (fechaExpiracion == null) {
			if (other.fechaExpiracion != null)
				return false;
		} else if (!fechaExpiracion.equals(other.fechaExpiracion))
			return false;
		if (laboratorio != other.laboratorio)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	
	

	

}
