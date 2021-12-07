package conexionSQL;

import entidades.*;

import java.sql.*;
import java.util.LinkedList;

public class DataPersona {

	public LinkedList<Persona> getAll() {
		Statement stmt = null;
		ResultSet rs = null;
		LinkedList<Persona> pers = new LinkedList<>();

		try {
			stmt = DbConnector.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("SELECT * FROM bkwscpfq5sshgak97bp2.persona;");
			// intencionalmente no se recupera la password
			if (rs != null) {
				while (rs.next()) {
					Persona p = new Persona();
					p.setDni(rs.getInt("dni"));
					p.setNombre(rs.getString("nombre"));
					p.setApellido(rs.getString("apellido"));
					p.setTelefono(rs.getString("telefono"));
					p.setOficio(rs.getString("oficio"));
					p.setAreaTrabajo(rs.getString("areaTrabajo"));
					p.setValuacionPromedio(rs.getDouble("valuacionPromedio"));
					pers.add(p);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return pers;
	}

	public Persona getByUsuario(Persona per) {
		Persona p = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement(
					"select Dni, Nombre, Apellido, Telefono, Oficio, AreaTrabajo, ValuacionPromedio from persona where Dni=? and Contrasenia=?");
			stmt.setInt(1, per.getDni());
			stmt.setString(2, per.getContrasenia());
			rs = stmt.executeQuery();
			if (rs != null && rs.next()) {
				p = new Persona();
				p.setDni(rs.getInt("Dni"));
				p.setNombre(rs.getString("Nombre"));
				p.setApellido(rs.getString("Apellido"));
				p.setTelefono(rs.getString("Telefono"));
				p.setOficio(rs.getString("Oficio"));
				p.setAreaTrabajo(rs.getString("AreaTrabajo"));
				p.setValuacionPromedio(rs.getDouble("ValuacionPromedio"));
				//
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return p;
	}
	
	public Persona getByDocumento(Persona per) {
		Persona p = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement(
					"select Dni, Nombre, Apellido, Telefono, Oficio, AreaTrabajo, ValuacionPromedio from persona where Dni=?");
			stmt.setInt(1, per.getDni());
			rs = stmt.executeQuery();
			if (rs != null && rs.next()) {
				p = new Persona();
				p.setDni(rs.getInt("Dni"));
				p.setNombre(rs.getString("Nombre"));
				p.setApellido(rs.getString("Apellido"));
				p.setTelefono(rs.getString("Telefono"));
				p.setOficio(rs.getString("Oficio"));
				p.setAreaTrabajo(rs.getString("AreaTrabajo"));
				p.setValuacionPromedio(rs.getDouble("ValuacionPromedio"));
				//
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return p;
	}

	public void add(Persona p) {
		PreparedStatement stmt = null;
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement(
					"insert into persona(dni, nombre, apellido, telefono, oficio, areaTrabajo, valuacionPromedio) values(?,?,?,?,?,?,?)");
			stmt.setInt(1, p.getDni());
			stmt.setString(2, p.getNombre());
			stmt.setString(3, p.getApellido());
			stmt.setString(4, p.getTelefono());
			stmt.setString(5, p.getOficio());
			stmt.setString(6, p.getAreaTrabajo());
			stmt.setDouble(7, p.getValuacionPromedio());
			stmt.executeUpdate();
		}

		catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (stmt != null)
					stmt.close();
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void update(int dni, Persona per) {
		PreparedStatement stmt = null;
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement(
					"UPDATE `bkwscpfq5sshgak97bp2`.`persona` SET `Dni`=?, `Nombre`=?, `Apellido`=?, `Telefono`=?, `Oficio`=?, `AreaTrabajo`=?, `ValuacionPromedio`=? WHERE (`Dni`=?);");
			stmt.setInt(1, per.getDni());
			stmt.setString(2, per.getNombre());
			stmt.setString(3, per.getApellido());
			stmt.setString(4, per.getTelefono());
			stmt.setString(5, per.getOficio());
			stmt.setString(6, per.getAreaTrabajo());
			stmt.setDouble(7, per.getValuacionPromedio());
			stmt.setInt(8, dni);

			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void drop(Persona per) {
		PreparedStatement stmt = null;
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("DELETE FROM persona WHERE (`Dni`=?);");

			stmt.setInt(1, per.getDni());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (stmt != null)
					stmt.close();
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}