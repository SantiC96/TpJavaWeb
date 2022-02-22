package entidades;

import java.util.LinkedList;

public class Persona {

	private int dni;
	private String nombre;
	private String apellido;
	private String telefono;
	private String areaTrabajo;
	private Double valuacionPromedio;
	private String contrasenia;
	
	private CategoriaTrabajo categoriasTrabajo;
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

	public String getAreaTrabajo() {
		return areaTrabajo;
	}
	
	public CategoriaTrabajo getCategoriasTrabajo() {
		return categoriasTrabajo;
	}

	public void setCategoriasTrabajo(CategoriaTrabajo categoriasTrabajo) {
		this.categoriasTrabajo = categoriasTrabajo;
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
	
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	public int getIdDireccion() {
		return direccion.getIdDireccion();
	}
	
	public void setDireccionById(int idDireccion) {
		this.direccion.setIdDireccion(idDireccion);
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
}