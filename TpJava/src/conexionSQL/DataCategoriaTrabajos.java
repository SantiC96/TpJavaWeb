package conexionSQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entidades.*;

public class DataCategoriaTrabajos {
	
	public LinkedList<CategoriaTrabajo> getAll() {
		Statement stmt = null;
		ResultSet rs = null;
		LinkedList<CategoriaTrabajo> cat = new LinkedList<>();

		try {
			stmt = DbConnector.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("SELECT * FROM bkwscpfq5sshgak97bp2.categoriatrabajo;");
			// intencionalmente no se recupera la password
			if (rs != null) {
				while (rs.next()) {
					CategoriaTrabajo ct = new CategoriaTrabajo();
						
					ct.setIdCategoria(rs.getInt("idCategoria"));
					ct.setDescripcion(rs.getString("descripcion"));
					
					cat.add(ct);
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

	public CategoriaTrabajo getById(CategoriaTrabajo cat) {
		CategoriaTrabajo ct = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = DbConnector.getInstancia().getConn()
					.prepareStatement("SELECT * FROM bkwscpfq5sshgak97bp2.categoriatrabajo where IdCategoria=?");
			stmt.setInt(1, cat.getIdCategoria());
			rs = stmt.executeQuery();
			if (rs != null && rs.next()) {
				ct = new CategoriaTrabajo();
				
				ct.setIdCategoria(rs.getInt("idCategoria"));
				ct.setDescripcion(rs.getString("descripcion"));

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
		return ct;
	}

	public void add(CategoriaTrabajo cat) {
		PreparedStatement stmt = null;
		ResultSet keyResultSet = null;
		try {
			stmt = DbConnector.getInstancia().getConn()
					.prepareStatement("INSERT INTO `bkwscpfq5sshgak97bp2`.`categoriatrabajo` "
							+ "(`Descripcion`) " + "VALUES (?);",
							+PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, cat.getDescripcion());

			stmt.executeUpdate();

			keyResultSet = stmt.getGeneratedKeys();
			if (keyResultSet != null && keyResultSet.next()) {
				cat.setIdCategoria(keyResultSet.getInt(1));
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

	public void update(int idCategoria, CategoriaTrabajo ct) {
		PreparedStatement stmt = null;
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement(
					"UPDATE `bkwscpfq5sshgak97bp2`.`categoriatrabajo` SET `Descripcion` =? WHERE (`IdCategoria` =?);");
			stmt.setString(1, ct.getDescripcion());
			stmt.setInt(2, idCategoria);

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

	public void drop(CategoriaTrabajo cat) {
		PreparedStatement stmt = null;
		try {
			stmt = DbConnector.getInstancia().getConn()
					.prepareStatement("DELETE FROM `bkwscpfq5sshgak97bp2`.`categoriatrabajo` WHERE (`IdCategoria` =?);");

			stmt.setInt(1, cat.getIdCategoria());

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