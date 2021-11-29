package entidades;

public class Cotizacion {

	private int idCotizacion;
	private Double precioHora;
	private Double precioFinal;
	private String fechaCotizacion;
	private String descripcion;
	private String materialesRequeridos;
	private Trabajo trabajo;

	public int getIdCotizacion() {
		return idCotizacion;
	}

	public void setIdCotizacion(int idCotizacion) {
		this.idCotizacion = idCotizacion;
	}

	public Double getPrecioHora() {
		return precioHora;
	}

	public void setPrecioHora(Double precioHora) {
		this.precioHora = precioHora;
	}

	public Double getPrecioFinal() {
		return precioFinal;
	}

	public void setPrecioFinal(Double precioFinal) {
		this.precioFinal = precioFinal;
	}

	public String getFechaCotizacion() {
		return fechaCotizacion;
	}

	public void setFechaCotizacion(String fechaCotizacion) {
		this.fechaCotizacion = fechaCotizacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getMaterialesRequeridos() {
		return materialesRequeridos;
	}

	public void setMaterialesRequeridos(String materialesRequeridos) {
		this.materialesRequeridos = materialesRequeridos;
	}

	public Trabajo getTrabajo() {
		return trabajo;
	}

	public void setTrabajo(Trabajo trabajo) {
		this.trabajo = trabajo;
	}

	@Override
	public String toString() {
		return "Cotizacion [idCotizacion=" + idCotizacion + ", precioHora=" + precioHora + ", precioFinal="
				+ precioFinal + ", fechaCotizacion=" + fechaCotizacion + ", descripcion=" + descripcion
				+ ", materialesRequeridos=" + materialesRequeridos + ", trabajo=" + trabajo + "]";
	}

	public Cotizacion(int idCotizacion, Double precioHora, Double precioFinal, String fechaCotizacion,
			String descripcion, String materialesRequeridos, Trabajo trabajo) {
		super();
		this.idCotizacion = idCotizacion;
		this.precioHora = precioHora;
		this.precioFinal = precioFinal;
		this.fechaCotizacion = fechaCotizacion;
		this.descripcion = descripcion;
		this.materialesRequeridos = materialesRequeridos;
		this.trabajo = trabajo;
	}

	public Cotizacion() {
		super();
	}

}
