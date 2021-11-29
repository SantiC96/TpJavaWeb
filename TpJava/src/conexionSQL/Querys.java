package conexionSQL;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Querys {
	public static void main(String[] args) {
		Conexion conexion = new Conexion();

		Connection cn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			cn = conexion.conectar();
			stmt = cn.createStatement();
			rs = stmt.executeQuery("Aca va la query que necesitemos");
		} catch (SQLException e) {
		}
	}
}