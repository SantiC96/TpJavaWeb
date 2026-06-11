package conexionSQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entidades.*;

public class DataProvincia {
	
	public LinkedList<Provincia> getAll() {
		Statement stmt = null;
		ResultSet rs = null;
		LinkedList<Provincia> prov = new LinkedList<>();

		try {
			stmt = DbConnector.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("SELECT * FROM tpjava.provincia;");
			// intencionalmente no se recupera la password
			if (rs != null) {
				while (rs.next()) {
					Provincia p = new Provincia();
					
					p.setIdProvincia(rs.getInt("idProvincia"));
					p.setDescripcion(rs.getString("descripcion"));
					
					prov.add(p);
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

		return prov;
	}

	public Provincia getById(Provincia prov) {
		Provincia p = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = DbConnector.getInstancia().getConn()
					.prepareStatement("SELECT * FROM tpjava.provincia where idProvincia=?");
			stmt.setInt(1, prov.getIdProvincia());
			rs = stmt.executeQuery();
			if (rs != null && rs.next()) {
				p = new Provincia();
				
				p.setIdProvincia(rs.getInt("idProvincia"));
				p.setDescripcion(rs.getString("descripcion"));

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
	
	public Provincia getProvByDesc(Provincia prov) {
		Provincia p = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = DbConnector.getInstancia().getConn()
					.prepareStatement("SELECT * FROM tpjava.provincia where provincia.Descripcion like ?");
			stmt.setString(1, "%"+prov.getDescripcion()+"%");
			rs = stmt.executeQuery();
			if (rs != null && rs.next()) {
				p = new Provincia();
				
				p.setIdProvincia(rs.getInt("idProvincia"));
				p.setDescripcion(rs.getString("descripcion"));

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
	
	
	public void add(Provincia prov) {
		PreparedStatement stmt = null;
		ResultSet keyResultSet = null;
		try {
			stmt = DbConnector.getInstancia().getConn()
					.prepareStatement("INSERT INTO `tpjava`.`provincia` "
							+ "(`Descripcion`) " + "VALUES (?);",
							 PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, prov.getDescripcion());

			stmt.executeUpdate();

			keyResultSet = stmt.getGeneratedKeys();
			if (keyResultSet != null && keyResultSet.next()) {
				prov.setIdProvincia(keyResultSet.getInt(1));
			}
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
	
	
	public void update(int idProvincia, Provincia prov) {
		PreparedStatement stmt = null;
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement(
					"UPDATE `tpjava`.`provincia` SET  `Descripcion` =?  WHERE (`idProvincia` =?);");
			stmt.setString(1, prov.getDescripcion());
			stmt.setInt(2, idProvincia);

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

	public void drop(Provincia prov) {
		PreparedStatement stmt = null;
		try {
			stmt = DbConnector.getInstancia().getConn()
					.prepareStatement("DELETE FROM `tpjava`.`provincia` WHERE (`idProvincia` =?);");

			stmt.setInt(1, prov.getIdProvincia());

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