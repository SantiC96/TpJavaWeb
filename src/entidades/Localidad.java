package entidades;

import java.util.LinkedList;

public class Localidad {

	private int idLocalidad;
	private String codPostal;
	private String descripcion;
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
