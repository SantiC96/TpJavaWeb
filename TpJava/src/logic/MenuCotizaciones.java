package logic;

import java.util.Scanner;

import conexionSQL.DataCotizacion;
import conexionSQL.DataPersona;
import entidades.Cotizacion;
import entidades.Persona;

public class MenuCotizaciones {
	
	public void listadoCotizaciones() {
		DataCotizacion dt=new DataCotizacion();
		System.out.println("Listado de todas las cotizaciones");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println(dt.getAll());
	}
	
	public void buscarCotizacion() {
		Scanner lector = new Scanner(System.in);
		DataCotizacion dc=new DataCotizacion();
		Cotizacion c=new Cotizacion();
		System.out.println("Buscar a una cotización por ID");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("Ingrese el ID: ");
		c.setIdCotizacion(Integer.parseInt(lector.next()));
		System.out.println((dc.getById(c)));
		lector.close();
	}
	
	public void aniadirCotizacion() {
		Scanner lector = new Scanner(System.in);
		DataCotizacion dc=new DataCotizacion();
		Cotizacion c=new Cotizacion();
		System.out.println("Cargar a una cotización nueva");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("Ingrese el precio por hora: ");
		c.setPrecioHora(Double.parseDouble(lector.next()));
		System.out.println("Ingrese el precio final: ");
		c.setPrecioFinal(Double.parseDouble(lector.next()));
		System.out.println("Ingrese la fecha de cotización: ");
		c.setFechaCotizacion(lector.next());
		System.out.println("Ingrese la descripción: ");
		c.setDescripcion(lector.next());
		System.out.println("Ingrese los materiales requeridos: ");
		c.setMaterialesRequeridos(lector.next());

		dc.add(c);
		System.out.println(c);
		lector.close();
	}
	
	public void actualizarCotizacion() {
		Scanner lector = new Scanner(System.in);
		DataCotizacion dc = new DataCotizacion();
		Cotizacion c= new Cotizacion();
		System.out.println("Actualizar una cotización");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("Ingrese el ID de la cotización: ");
		c.setIdCotizacion(Integer.parseInt(lector.next()));
		if (null!=dc.getById(c)) {
			System.out.println("Los datos actuales de la cotización son los siguientes:");
			System.out.println(dc.getById(c));
			System.out.println("");
			System.out.println("Ingrese el nuevo precio por hora: ");
			c.setPrecioHora(Double.parseDouble(lector.next()));
			System.out.println("Ingrese el nuevo precio final: ");
			c.setPrecioFinal(Double.parseDouble(lector.next()));
			System.out.println("Ingrese la nueva fecha de cotización: ");
			c.setFechaCotizacion(lector.next());
			System.out.println("Ingrese la nueva descripción: ");
			c.setDescripcion(lector.next());
			System.out.println("Ingrese los nuevos materiales requeridos: ");
			c.setMaterialesRequeridos(lector.next());

		dc.update(c.getIdCotizacion(), c);
		System.out.println(c);
		
		} else {
			System.out.println("El ID ingresado no existe.");
		}
		lector.close();
	}
}
