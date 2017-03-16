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
	@Column(name="codigo",length=10)
	private String codigo;
	
	@Column(name = "nombre", length =40)
	private String nombre;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_expedición")
	private Date fecha_expedición;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_expiración")
	private Date fecha_expiración;
	
	@Column(name = "laboratorio", length =40)
	private String laboratorio;
	
	@Column(name = "cantidad", length = 40)
	private int cantidad;
	
	@Column(name = "estado")
	private boolean estado;
	
	@ManyToOne
	@JoinColumn(name = "farmacia_codigo")
	private Farmacia farmacia_codigo;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha_expedición() {
		return fecha_expedición;
	}

	public void setFecha_expedición(Date fecha_expedición) {
		this.fecha_expedición = fecha_expedición;
	}

	public Date getFecha_expiración() {
		return fecha_expiración;
	}

	public void setFecha_expiración(Date fecha_expiración) {
		this.fecha_expiración = fecha_expiración;
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

	public Farmacia getFarmacia_codigo() {
		return farmacia_codigo;
	}

	public void setFarmacia_codigo(Farmacia farmacia_codigo) {
		this.farmacia_codigo = farmacia_codigo;
	}

	public Medicamento(String codigo, String nombre, Date fecha_expedición, Date fecha_expiración, String laboratorio,
			int cantidad, boolean estado, Farmacia farmacia_codigo) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.fecha_expedición = fecha_expedición;
		this.fecha_expiración = fecha_expiración;
		this.laboratorio = laboratorio;
		this.cantidad = cantidad;
		this.estado = estado;
		this.farmacia_codigo = farmacia_codigo;
	}
	
	public Medicamento(){
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cantidad;
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
		return true;
	}
	
	

}
