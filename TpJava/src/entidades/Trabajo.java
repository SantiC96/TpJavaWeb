package entidades;

import java.util.LinkedList;

public class Trabajo {

	private int idTrabajo;
	private String estado;
	private String fechaIni;
	private String fechaFin;
	private String fechaEstimadaFin;
	private String fechaEstimadaIni;
	private String ubicacionAprox;
	private String observaciones;
	private Double valuacionTrabajo;
	private Double precioFinal;
	
	private Persona cliente;
	private Persona trabajador;
	private Localidad localidad;
	
	public int getIdTrabajo() {
		return idTrabajo;
	}
	public void setIdTrabajo(int idTrabajo) {
		this.idTrabajo = idTrabajo;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getFechaIni() {
		return fechaIni;
	}
	public void setFechaIni(String fechaIni) {
		this.fechaIni = fechaIni;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getFechaEstimadaFin() {
		return fechaEstimadaFin;
	}
	public void setFechaEstimadaFin(String fechaEstimadaFin) {
		this.fechaEstimadaFin = fechaEstimadaFin;
	}
	public String getFechaEstimadaIni() {
		return fechaEstimadaIni;
	}
	public void setFechaEstimadaIni(String fechaEstimadaIni) {
		this.fechaEstimadaIni = fechaEstimadaIni;
	}
	public String getUbicacionAprox() {
		return ubicacionAprox;
	}
	public void setUbicacionAprox(String ubicacionAprox) {
		this.ubicacionAprox = ubicacionAprox;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public Double getValuacionTrabajo() {
		return valuacionTrabajo;
	}
	public void setValuacionTrabajo(Double valuacionTrabajo) {
		this.valuacionTrabajo = valuacionTrabajo;
	}
	
	public Double getPrecioFinal() {
		return precioFinal;
	}
	public void setPrecioFinal(Double precioFinal) {
		this.precioFinal = precioFinal;
	}
	
	public Persona getCliente() {
		return cliente;
	}
	
	public void setCliente(Persona cliente) {
		this.cliente = cliente;
	}
	
	public int getDniCliente() {
		return cliente.getDni();
	}	
	
	public void setClienteByDni(int Dni) {
		this.cliente.setDni(Dni);
	}
	
	public Persona getTrabajador() {
		return trabajador;
	}
	
	public void setTrabajador(Persona trabajador) {
		this.trabajador = trabajador;
	}
	
	public void setTrabajadorByDni(int Dni) {
		this.trabajador.setDni(Dni);
	}
	
	public int getDniTrabajador() {
		return trabajador.getDni();
	}	
	
	public Localidad getLocalidad() {
		return localidad;
	}
	
	public int getIdLocalidad() {
		return localidad.getIdLocalidad();
	}
	
	public void setLocalidadById(int idLocalidad) {
		this.localidad.setIdLocalidad(idLocalidad);
	}
	
	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}
	
	@Override
	public String toString() {
		return "\n Trabajo [idTrabajo=" + idTrabajo + ", estado=" + estado + ", fechaIni=" + fechaIni + ", fechaFin="
				+ fechaFin + ", fechaEstimadaFin=" + fechaEstimadaFin + ", fechaEstimadaIni=" + fechaEstimadaIni
				+ ", ubicacionAprox=" + ubicacionAprox + ", observaciones=" + observaciones + ", valuacionTrabajo="
				+ valuacionTrabajo + ", precio final=" + precioFinal + ", cliente=" + cliente + ", trabajador=" + trabajador + ", localidad=" + localidad
				+ "]";
	}
}