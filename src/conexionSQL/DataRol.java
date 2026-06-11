package conexionSQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entidades.*;

public class DataRol {
	
	public LinkedList<Rol> getAll() {
		Statement stmt = null;
		ResultSet rs = null;
		LinkedList<Rol> cat = new LinkedList<>();

		try {
			stmt = DbConnector.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("SELECT * FROM tpjava.rol;");
			if (rs != null) {
				while (rs.next()) {
					Rol r = new Rol();
						
					r.setIdRol(rs.getInt("idRol"));
					r.setDescripcion(rs.getString("descripcion"));
					
					cat.add(r);
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

		return cat;
	}

	public Rol getById(Rol r) {
		Rol rol = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = DbConnector.getInstancia().getConn()
					.prepareStatement("SELECT * FROM tpjava.rol where idRol=?");
			stmt.setInt(1, r.getIdRol());
			rs = stmt.executeQuery();
			if (rs != null && rs.next()) {
				rol = new Rol();
				
				rol.setIdRol(rs.getInt("idRol"));
				rol.setDescripcion(rs.getString("descripcion"));

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
		return rol;
	}
	
	public Rol getDescById(Rol r) {
		Rol rol = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = DbConnector.getInstancia().getConn()
					.prepareStatement("SELECT descripcion FROM tpjava.rol where idRol=?");
			stmt.setInt(1, r.getIdRol());
			rs = stmt.executeQuery();
			if (rs != null && rs.next()) {
				rol = new Rol();
				
				rol.setDescripcion(rs.getString("descripcion"));

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
		return rol;
	}

	public void add(Rol rol) {
		PreparedStatement stmt = null;
		ResultSet keyResultSet = null;
		try {
			stmt = DbConnector.getInstancia().getConn()
					.prepareStatement("INSERT INTO `tpjava`.`rol` "
							+ "(`Descripcion`) " + "VALUES (?);",
							 PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, rol.getDescripcion());

			stmt.executeUpdate();

			keyResultSet = stmt.getGeneratedKeys();
			if (keyResultSet != null && keyResultSet.next()) {
				rol.setIdRol(keyResultSet.getInt(1));
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

	public void update(int idCRol, Rol rol) {
		PreparedStatement stmt = null;
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement(
					"UPDATE `tpjava`.`rol` SET `Descripcion` =? WHERE (`idRol` =?);");
			stmt.setString(1, rol.getDescripcion());
			stmt.setInt(2, idCRol);

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

	public void drop(Rol rol) {
		PreparedStatement stmt = null;
		try {
			stmt = DbConnector.getInstancia().getConn()
					.prepareStatement("DELETE FROM `tpjava`.`rol` WHERE (`idRol` =?);");

			stmt.setInt(1, rol.getIdRol());

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