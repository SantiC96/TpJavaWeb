package entidades;

import java.util.LinkedList;

public class Provincia {

	private int idProvincia;
	private String descripcion;
	private LinkedList<Localidad> localidades;

	public int getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LinkedList<Localidad> getLocalidades() {
		return localidades;
	}

	public void setLocalidades(LinkedList<Localidad> localidades) {
		this.localidades = localidades;
	}
}
