package entidades;

import java.util.LinkedList;

public class Persona {

	private int dni;
	private String nombre;
	private String apellido;
	private String telefono;
	private String oficio;
	private String areaTrabajo;
	private Double valuacionPromedio;
	private String contrasenia;
	private LinkedList<CategoriaTrabajo> categoriasTrabajo;
	private Direccion direccion;
	private LinkedList<Localidad> localidades;
	private LinkedList<Trabajo> trabajos;

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getOficio() {
		return oficio;
	}

	public void setOficio(String oficio) {
		this.oficio = oficio;
	}

	public String getAreaTrabajo() {
		return areaTrabajo;
	}

	public void setAreaTrabajo(String areaTrabajo) {
		this.areaTrabajo = areaTrabajo;
	}

	public Double getValuacionPromedio() {
		return valuacionPromedio;
	}

	public void setValuacionPromedio(Double valuacionPromedio) {
		this.valuacionPromedio = valuacionPromedio;
	}
	
	public String getContrasenia() {
		return contrasenia;
	}
	
	public void setContraseña(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public LinkedList<CategoriaTrabajo> getCategoriasTrabajo() {
		return categoriasTrabajo;
	}

	public void setCategoriasTrabajo(LinkedList<CategoriaTrabajo> categoriasTrabajo) {
		this.categoriasTrabajo = categoriasTrabajo;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public LinkedList<Localidad> getLocalidades() {
		return localidades;
	}

	public void setLocalidades(LinkedList<Localidad> localidades) {
		this.localidades = localidades;
	}

	public LinkedList<Trabajo> getTrabajos() {
		return trabajos;
	}

	public void setTrabajos(LinkedList<Trabajo> trabajos) {
		this.trabajos = trabajos;
	}

	public Persona(int dni, String nombre, String apellido, String telefono, String oficio, String areaTrabajo,
			Double valuacionPromedio, String contrasenia, LinkedList<CategoriaTrabajo> categoriasTrabajo, Direccion direccion,
			LinkedList<Localidad> localidades, LinkedList<Trabajo> trabajos) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.oficio = oficio;
		this.areaTrabajo = areaTrabajo;
		this.valuacionPromedio = valuacionPromedio;
		this.contrasenia = contrasenia;
		this.categoriasTrabajo = categoriasTrabajo;
		this.direccion = direccion;
		this.localidades = localidades;
		this.trabajos = trabajos;
	}

	public Persona() {
		super();
	}

	@Override
	public String toString() {
		return "\n Persona [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono
				+ ", oficio=" + oficio + ", areaTrabajo=" + areaTrabajo + ", contraseña=" + contrasenia + ", valuacionPromedio=" + valuacionPromedio
				+ ", categoriasTrabajo=" + categoriasTrabajo + ", direccion=" + direccion + ", localidades="
				+ localidades + ", trabajos=" + trabajos + "]";
	}
}
