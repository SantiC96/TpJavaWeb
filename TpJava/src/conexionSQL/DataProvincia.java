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
			rs = stmt.executeQuery("SELECT * FROM bkwscpfq5sshgak97bp2.provincia;");
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
					.prepareStatement("SELECT * FROM bkwscpfq5sshgak97bp2.provincia where idProvincia=?");
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
}