package entidades;

import java.util.LinkedList;

public class Localidad {

	private int idLocalidad;
	private String codPostal;
	private String descripcion;
	private LinkedList<Persona> personas;
	private LinkedList<Direccion> direcciones;
	private LinkedList<Trabajo> trabajos;
	private Provincia provincia;

	public int getIdLocalidad() {
		return idLocalidad;
	}

	public void setIdLocalidad(int idLocalidad) {
		this.idLocalidad = idLocalidad;
	}

	public String getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LinkedList<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(LinkedList<Persona> personas) {
		this.personas = personas;
	}

	public LinkedList<Direccion> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(LinkedList<Direccion> direcciones) {
		this.direcciones = direcciones;
	}

	public LinkedList<Trabajo> getTrabajos() {
		return trabajos;
	}

	public void setTrabajos(LinkedList<Trabajo> trabajos) {
		this.trabajos = trabajos;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
	
	public int getIdProvincia() {
		return provincia.getIdProvincia();
	}

	public void setIdProvincia(int idProvincia) {
		this.provincia.setIdProvincia(idProvincia);
	}
}
