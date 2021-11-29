package conexionSQL;

import entidades.*;

import java.sql.*;
import java.util.LinkedList;

public class DataCotizacion {

	public LinkedList<Cotizacion> getAll() {
		Statement stmt = null;
		ResultSet rs = null;
		LinkedList<Cotizacion> cot = new LinkedList<>();

		try {
			stmt = DbConnector.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("SELECT * FROM bkwscpfq5sshgak97bp2.cotizacion;");
			// intencionalmente no se recupera la password
			if (rs != null) {
				while (rs.next()) {
					Cotizacion c = new Cotizacion();
					c.setIdCotizacion(rs.getInt("idCotizacion"));
					c.setPrecioHora(rs.getDouble("precioHora"));
					c.setPrecioFinal(rs.getDouble("precioFinal"));
					c.setFechaCotizacion(rs.getString("fechaCotizacion"));
					c.setDescripcion(rs.getString("descripcion"));
					c.setMaterialesRequeridos(rs.getString("materialesRequeridos"));
					cot.add(c);
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

		return cot;
	}

	public Cotizacion getById(Cotizacion cot) {
		Cotizacion c = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement(
					"select IdCotizacion, PrecioHora, PrecioFinal, FechaCotizacion, Descripcion, MaterialesRequeridos from cotizacion where IdCotizacion=?");
			stmt.setInt(1, cot.getIdCotizacion());
			rs = stmt.executeQuery();
			if (rs != null && rs.next()) {
				c = new Cotizacion();
				c.setIdCotizacion(rs.getInt("idCotizacion"));
				c.setPrecioHora(rs.getDouble("precioHora"));
				c.setPrecioFinal(rs.getDouble("precioFinal"));
				c.setFechaCotizacion(rs.getString("fechaCotizacion"));
				c.setDescripcion(rs.getString("descripcion"));
				c.setMaterialesRequeridos(rs.getString("materialesRequeridos"));
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
		return c;
	}

	public void add(Cotizacion c) {
		PreparedStatement stmt = null;
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement(
					"insert into persona(idCotizacion, precioHora, precioFinal, fechaCotizacion, descripcion, materialesRequeridos) values(?,?,?,?,?,?)");
			stmt.setInt(1, c.getIdCotizacion());
			stmt.setDouble(2, c.getPrecioHora());
			stmt.setDouble(3, c.getPrecioFinal());
			stmt.setString(4, c.getFechaCotizacion());
			stmt.setString(5, c.getDescripcion());
			stmt.setString(6, c.getMaterialesRequeridos());
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

	public void update(int idCotizacion, Cotizacion c) {
		PreparedStatement stmt = null;
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement(
					"UPDATE `bkwscpfq5sshgak97bp2`.`persona` SET `IdCotizacion`=?, `PrecioHora`=?, `PrecioFinal`=?, `FechaCotizacion`=?, `Descripcion`=?, `MaterialesRequeridos`=? WHERE (`IdCotizacion`=?);");
			stmt.setInt(1, c.getIdCotizacion());
			stmt.setDouble(2, c.getPrecioHora());
			stmt.setDouble(3, c.getPrecioFinal());
			stmt.setString(4, c.getFechaCotizacion());
			stmt.setString(5, c.getDescripcion());
			stmt.setString(6, c.getMaterialesRequeridos());

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

	public void drop(Cotizacion cot) {
		PreparedStatement stmt = null;
		try {
			stmt = DbConnector.getInstancia().getConn()
					.prepareStatement("DELETE FROM cotizacion WHERE (`IdCotizacion`=?);");

			stmt.setInt(1, cot.getIdCotizacion());

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