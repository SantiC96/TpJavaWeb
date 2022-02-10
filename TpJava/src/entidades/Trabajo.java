package entidades;

import java.util.LinkedList;

public class Trabajo {

	private int idtrabajo;
	private String estado;
	private String fechaIni;
	private String fechaFin;
	private String fechaEstimadaFin;
	private String fechaEstimadaIni;
	private String ubicacionAprox;
	private String observaciones;
	private Double valuacionTrabajo;
	
	private Persona cliente;
	private Persona trabajador;
	private Localidad localidad;
	private Cotizacion cotizacion;
	
	public int getIdtrabajo() {
		return idtrabajo;
	}
	public void setIdtrabajo(int idtrabajo) {
		this.idtrabajo = idtrabajo;
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
	public Persona getCliente() {
		return cliente;
	}
	
	public int getDniCliente() {
		return cliente.getDni();
	}	
	
	public void setCliente(Persona cliente) {
		this.cliente = cliente;
	}
	
	public void setClienteByDni(int Dni) {
		this.cliente.setDni(Dni);
	}
	
	
	public Persona getTrabajador() {
		return trabajador;
	}
	
	public void setTrabajadorByDni(int Dni) {
		this.trabajador.setDni(Dni);
	}
	
	public int getDniTrabajador() {
		return trabajador.getDni();
	}	
	
	public void setTrabajador(Persona trabajador) {
		this.trabajador = trabajador;
	}
	public Localidad getLocalidad() {
		return localidad;
	}
	
	public int getIdLocalidad() {
		return localidad.getIdlocalidad();
	}
	
	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}
	public Cotizacion getCotizacion() {
		return cotizacion;
	}
	
	public int getIdCotizacion() {
		return cotizacion.getIdCotizacion();
	}
	
	public void setCotizacion(Cotizacion cotizacion) {
		this.cotizacion = cotizacion;
	}
	@Override
	public String toString() {
		return "\n Trabajo [idtrabajo=" + idtrabajo + ", estado=" + estado + ", fechaIni=" + fechaIni + ", fechaFin="
				+ fechaFin + ", fechaEstimadaFin=" + fechaEstimadaFin + ", fechaEstimadaIni=" + fechaEstimadaIni
				+ ", ubicacionAprox=" + ubicacionAprox + ", observaciones=" + observaciones + ", valuacionTrabajo="
				+ valuacionTrabajo + ", cliente=" + cliente + ", trabajador=" + trabajador + ", localidad=" + localidad
				+ ", cotizacion=" + cotizacion + "]";
	}
	
	
	
	
	
	
}
