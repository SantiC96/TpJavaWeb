package entidades;

import java.util.LinkedList;

public class Localidad {

	private int idlocalidad;
	private String odPostal;
	private String descripcion;
	private int idProvincia;
	private LinkedList<Persona> personas;
	private LinkedList<Direccion> direcciones;
	private LinkedList<Trabajo> trabajos;
	private Provincia provincia;

	public int getIdlocalidad() {
		return idlocalidad;
	}

	public void setIdlocalidad(int idlocalidad) {
		this.idlocalidad = idlocalidad;
	}

	public String getOdPostal() {
		return odPostal;
	}

	public void setOdPostal(String odPostal) {
		this.odPostal = odPostal;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
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
}
