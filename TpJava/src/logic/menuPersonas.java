package logic;

import java.util.Scanner;
import conexionSQL.DataPersona;
import entidades.Persona;

public class menuPersonas {
	
	public void listadoPersonas() {
		DataPersona dt=new DataPersona();
		System.out.println("Listado de todas las personas");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println(dt.getAll());
	}
	
	public void buscarPersona() {
		Scanner lector = new Scanner(System.in);
		DataPersona dp=new DataPersona();
		Persona p=new Persona();
		System.out.println("Buscar a una persona por DNI");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("Ingrese el Dni: ");
		p.setDni(Integer.parseInt(lector.next()));
		System.out.println((dp.getByDocumento(p)));
		lector.close();
	}
	
	public void aniadirPersona() {
		Scanner lector = new Scanner(System.in);
		DataPersona dp=new DataPersona();
		Persona p=new Persona();
		System.out.println("Cargar a una persona nueva");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("Ingrese el Dni: ");
		p.setDni(Integer.parseInt(lector.next()));
		if (null==dp.getByDocumento(p)) {
			System.out.println("Ingrese el Nombre: ");
			p.setNombre(lector.next());
			System.out.println("Ingrese el Apellido: ");
			p.setApellido(lector.next());
			System.out.println("Ingrese el Telefono: ");
			p.setTelefono(lector.next());
			System.out.println("Ingrese el Area de trabajo: ");
			p.setAreaTrabajo(lector.next());
			System.out.println("Ingrese la Valuacion Promedio : ");
			p.setValuacionPromedio(Double.parseDouble(lector.next()));

			dp.add(p);
			System.out.println(p);
			
		} else {
			System.out.println("El DNI ingresado ya se encuentra registrado.");
		}
		lector.close();
	}
	
}
