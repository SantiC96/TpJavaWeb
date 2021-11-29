package conexionSQL;

import java.sql.*;

public class Conexion {

	private static final String Controlador = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/tp_java";
	private static final String Usuario = "root";
	private static final String Contraseña = "1234";

	static {
		try {
			Class.forName(Controlador);
		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el controlador.");
			e.printStackTrace();
		}
	}

	public Connection conectar() {
		Connection conexion = null;
		try {
			conexion = DriverManager.getConnection(URL, Usuario, Contraseña);

			System.out.println("Conexión establecida.");

		} catch (SQLException e) {
			System.out.println("Error en la conexión.");
			e.printStackTrace();
		}

		return conexion;
	}
}