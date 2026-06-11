package conexionSQL;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entidades.*;
import conexionSQL.*;

public class DataDireccion {

	DataLocalidad dLoc = new DataLocalidad();
	
	public LinkedList<Direccion> getAll() {
		Statement stmt = null;
		ResultSet rs = null;
		LinkedList<Direccion> direcciones = new LinkedList<>();

		try {
			stmt = DbConnector.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("SELECT * FROM tpjava.direccion;");
			// intencionalmente no se recupera la password
			if (rs != null) {
				while (rs.next()) {
					Direccion dir = new Direccion();
					Localidad loc = new Localidad();
					
					dir.setIdDireccion(rs.getInt("idDireccion"));
					dir.setCalle(rs.getString("calle"));
					dir.setAltura(rs.getString("altura"));
					
					loc.setIdLocalidad(rs.getInt("idLocalidad"));
					dir.setLocalidad(dLoc.getById(loc));
					
					direcciones.add(dir);
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

		return direcciones;
	}

	public Direccion getById(Direccion dirIn) {
		Direccion dir = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = DbConnector.getInstancia().getConn()
					.prepareStatement("SELECT * FROM tpjava.direccion where idDireccion=?");
			stmt.setInt(1, dirIn.getIdDireccion());
			rs = stmt.executeQuery();
			if (rs != null && rs.next()) {
				dir = new Direccion();
				Localidad loc = new Localidad();
				
				dir.setIdDireccion(rs.getInt("idDireccion"));
				dir.setCalle(rs.getString("calle"));
				dir.setAltura(rs.getString("altura"));
				
				loc.setIdLocalidad(rs.getInt("idLocalidad"));
				dir.setLocalidad(dLoc.getById(loc));

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
		return dir;
	}

	public Direccion getByCalle(Direccion dir) {
		Direccion direccion = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = DbConnector.getInstancia().getConn()
					.prepareStatement("SELECT * FROM tpjava.direccion where direccion.calle like ? and direccion.altura like ? and direccion.IdLocalidad like ? ");
			stmt.setString(1, "%"+dir.getCalle()+"%");
			stmt.setString(2, dir.getAltura()+"%");
			stmt.setString(3, Integer.toString(dir.getLocalidad().getIdLocalidad()));
			rs = stmt.executeQuery();
			if (rs != null && rs.next()) {
				direccion = new Direccion();
				Localidad loc = new Localidad();
				
				direccion.setIdDireccion(rs.getInt("idDireccion"));
				direccion.setCalle(rs.getString("calle"));
				direccion.setAltura(rs.getString("altura"));
				
				loc.setIdLocalidad(rs.getInt("idLocalidad"));
				direccion.setLocalidad(dLoc.getById(loc));
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
		return direccion;
	}

	public void add(Direccion dir) {
		PreparedStatement stmt = null;
		ResultSet keyResultSet = null;
		try {
			stmt = DbConnector.getInstancia().getConn()
					.prepareStatement("INSERT INTO `tpjava`.`direccion` "
							+ "(`Calle`, `Altura`, `IdLocalidad`) " + "VALUES (?,?,?);",
							 PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, dir.getCalle());
			stmt.setString(2, dir.getAltura());
			stmt.setInt(3, dir.getLocalidad().getIdLocalidad());

			stmt.executeUpdate();

			keyResultSet = stmt.getGeneratedKeys();
			if (keyResultSet != null && keyResultSet.next()) {
				dir.setIdDireccion(keyResultSet.getInt(1));
			}

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

	public void update(int idDireccion, Direccion dir) {
		PreparedStatement stmt = null;
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement(
					"UPDATE `tpjava`.`direccion` SET `Calle` =?, `Altura` =?, `IdLocalidad` = ? WHERE (`idDireccion` =?);");
			stmt.setString(1, dir.getCalle());
			stmt.setString(2, dir.getAltura());
			stmt.setInt(3, dir.getLocalidad().getIdLocalidad());
			stmt.setInt(4, idDireccion);

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

	public void drop(Direccion dir) {
		PreparedStatement stmt = null;
		try {
			stmt = DbConnector.getInstancia().getConn()
					.prepareStatement("DELETE FROM `tpjava`.`direccion` WHERE (`idDireccion` =?);");

			stmt.setInt(1, dir.getIdDireccion());

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
