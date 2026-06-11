package conexionSQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entidades.*;
import conexionSQL.*;

public class DataLocalidad {
	DataProvincia dprov = new DataProvincia();
	
	public LinkedList<Localidad> getAll() {
		Statement stmt = null;
		ResultSet rs = null;
		LinkedList<Localidad> loc = new LinkedList<>();

		try {
			stmt = DbConnector.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("SELECT * FROM tpjava.localidad;");
			// intencionalmente no se recupera la password
			if (rs != null) {
				while (rs.next()) {
					Localidad l = new Localidad();
					Provincia prov = new Provincia();
					
					l.setIdLocalidad(rs.getInt("idLocalidad"));
					l.setCodPostal(rs.getString("codPostal"));
					l.setDescripcion(rs.getString("descripcion"));
					
					prov.setIdProvincia(rs.getInt("idProvincia"));
					l.setProvincia(dprov.getById(prov));
					
					loc.add(l);
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

		return loc;
	}

	public Localidad getById(Localidad loc) {
		Localidad l = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = DbConnector.getInstancia().getConn()
					.prepareStatement("SELECT * FROM tpjava.localidad where idLocalidad=?");
			stmt.setInt(1, loc.getIdLocalidad());
			rs = stmt.executeQuery();
			if (rs != null && rs.next()) {
				l = new Localidad();
				Provincia prov = new Provincia();
				
				l.setIdLocalidad(rs.getInt("idLocalidad"));
				l.setCodPostal(rs.getString("codPostal"));
				l.setDescripcion(rs.getString("descripcion"));

				prov.setIdProvincia(rs.getInt("idProvincia"));
				l.setProvincia(dprov.getById(prov));

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
		return l;
	}

	public Localidad getLocByDesc(Localidad loc) {
		Localidad l = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = DbConnector.getInstancia().getConn()
					.prepareStatement("SELECT * FROM tpjava.localidad where localidad.descripcion like ?");
			stmt.setString(1, "%"+loc.getDescripcion()+"%");
			rs = stmt.executeQuery();
			if (rs != null && rs.next()) {
				l = new Localidad();
				Provincia prov = new Provincia();
				
				l.setIdLocalidad(rs.getInt("idLocalidad"));
				l.setCodPostal(rs.getString("codPostal"));
				l.setDescripcion(rs.getString("descripcion"));

				prov.setIdProvincia(rs.getInt("idProvincia"));
				l.setProvincia(dprov.getById(prov));

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
		return l;
	}

	public void add(Localidad l) {
		PreparedStatement stmt = null;
		ResultSet keyResultSet = null;
		try {
			stmt = DbConnector.getInstancia().getConn()
					.prepareStatement("INSERT INTO `tpjava`.`localidad` "
							+ "(`CodPostal`, `Descripcion`, `IdProvincia`) " + "VALUES (?,?,?);",
							 PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, l.getCodPostal());
			stmt.setString(2, l.getDescripcion());
			stmt.setInt(3, l.getIdProvincia());

			stmt.executeUpdate();

			keyResultSet = stmt.getGeneratedKeys();
			if (keyResultSet != null && keyResultSet.next()) {
				l.setIdLocalidad(keyResultSet.getInt(1));
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

	public void update(int idLocalidad, Localidad l) {
		PreparedStatement stmt = null;
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement(
					"UPDATE `tpjava`.`localidad` SET `CodPostal` =?, `Descripcion` =?, `IdProvincia` = ? WHERE (`idLocalidad` =?);");
			stmt.setString(1, l.getCodPostal());
			stmt.setString(2, l.getDescripcion());
			stmt.setInt(3, l.getIdProvincia());
			stmt.setInt(4, idLocalidad);

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

	public void drop(Localidad loc) {
		PreparedStatement stmt = null;
		try {
			stmt = DbConnector.getInstancia().getConn()
					.prepareStatement("DELETE FROM `tpjava`.`localidad` WHERE (`idLocalidad` =?);");

			stmt.setInt(1, loc.getIdLocalidad());

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