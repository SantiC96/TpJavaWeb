package conexionSQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entidades.*;
import conexionSQL.*;

public class DataTrabajo {
	DataPersona dp = new DataPersona();
	DataLocalidad dl = new DataLocalidad();
	
	public LinkedList<Trabajo> getAll() {
		Statement stmt = null;
		ResultSet rs = null;
		LinkedList<Trabajo> trab = new LinkedList<>();

		try {
			stmt = DbConnector.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("SELECT * FROM bkwscpfq5sshgak97bp2.trabajo;");
			// intencionalmente no se recupera la password
			if (rs != null) {
				while (rs.next()) {
					Trabajo t = new Trabajo();
					Persona cli = new Persona();
					Persona tra = new Persona();
					Localidad l = new Localidad();
						
					t.setIdTrabajo(rs.getInt("idTrabajo"));
					t.setEstado(rs.getString("estado"));
					t.setFechaIni(rs.getString("fechaIni"));
					t.setFechaFin(rs.getString("fechaFin"));
					t.setFechaEstimadaFin(rs.getString("fechaEstimadaFin"));
					t.setFechaEstimadaIni(rs.getString("fechaEstimadaIni"));
					t.setUbicacionAprox(rs.getString("ubicacionAprox"));
					t.setObservaciones(rs.getString("observaciones"));
					t.setValuacionTrabajo(rs.getDouble("valuacionTrabajo"));
					t.setPrecioFinal(rs.getDouble("precioFinal"));
					
					cli.setDni(rs.getInt("dniCliente"));
					t.setCliente(dp.getByDocumento(cli));
					
					tra.setDni(rs.getInt("dniTrabajador"));
					t.setTrabajador(dp.getByDocumento(tra));
					
					l.setIdLocalidad(rs.getInt("idLocalidad"));
					t.setLocalidad(dl.getById(l)); 
					
					trab.add(t);
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

		return trab;
	}

	public Trabajo getById(Trabajo trab) {
		Trabajo t = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = DbConnector.getInstancia().getConn()
					.prepareStatement("SELECT * FROM bkwscpfq5sshgak97bp2.trabajo where idTrabajo=?");
			stmt.setInt(1, trab.getIdTrabajo());
			rs = stmt.executeQuery();
			if (rs != null && rs.next()) {
				t = new Trabajo();
				Persona cli = new Persona();
				Persona tra = new Persona();
				Localidad l= new Localidad();
				
				t.setIdTrabajo(rs.getInt("idTrabajo"));
				t.setEstado(rs.getString("estado"));
				t.setFechaIni(rs.getString("fechaIni"));
				t.setFechaFin(rs.getString("fechaFin"));
				t.setFechaEstimadaFin(rs.getString("fechaEstimadaFin"));
				t.setFechaEstimadaIni(rs.getString("fechaEstimadaIni"));
				t.setUbicacionAprox(rs.getString("ubicacionAprox"));
				t.setObservaciones(rs.getString("observaciones"));
				t.setValuacionTrabajo(rs.getDouble("valuacionTrabajo"));
				t.setPrecioFinal(rs.getDouble("precioFinal"));

				cli.setDni(rs.getInt("dniCliente"));
				t.setCliente(dp.getByDocumento(cli));
				
				tra.setDni(rs.getInt("dniTrabajador"));
				t.setTrabajador(dp.getByDocumento(tra));
				
				l.setIdLocalidad(rs.getInt("idLocalidad"));
				t.setLocalidad(dl.getById(l));

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
		return t;
	}

	public void add(Trabajo t) {
		PreparedStatement stmt = null;
		ResultSet keyResultSet = null;
		try {
			stmt = DbConnector.getInstancia().getConn()
					.prepareStatement("INSERT INTO `bkwscpfq5sshgak97bp2`.`trabajo` "
							+ "(`Estado`, `FechaIni`, `FechaFin`, `FechaEstimadaFin`, `FechaEstimadaIni`, "
							+ "`UbicacionAprox`, `Observaciones`, `ValuacionTrabajo`, `PrecioFinal`, "
							+ "`DniCliente`, `DniTrabajador`, `IdLocalidad`) " + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?);",
							+PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, t.getEstado());
			stmt.setString(2, t.getFechaIni());
			stmt.setString(3, t.getFechaFin());
			stmt.setString(4, t.getFechaEstimadaFin());
			stmt.setString(5, t.getFechaEstimadaIni());
			stmt.setString(6, t.getUbicacionAprox());
			stmt.setString(7, t.getObservaciones());
			stmt.setDouble(8, t.getValuacionTrabajo());
			stmt.setDouble(9, t.getPrecioFinal());
			stmt.setInt(10, t.getDniCliente());
			stmt.setInt(11, t.getDniTrabajador());
			stmt.setInt(12, t.getIdLocalidad());

			stmt.executeUpdate();

			keyResultSet = stmt.getGeneratedKeys();
			if (keyResultSet != null && keyResultSet.next()) {
				t.setIdTrabajo(keyResultSet.getInt(1));
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

	public void update(int idTrabajo, Trabajo t) {
		PreparedStatement stmt = null;
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement(
					"UPDATE `bkwscpfq5sshgak97bp2`.`trabajo` SET `Estado` =?, `FechaIni` =?, `FechaFin` = ?, `FechaEstimadaFin` =?, `FechaEstimadaIni` =?, `UbicacionAprox` =?, `Observaciones` =?, `ValuacionTrabajo` =?, `PrecioFinal` =?, `DniCliente` =?, `DniTrabajador` =?, `IdLocalidad` =? WHERE (`idTrabajo` =?);");
			stmt.setString(1, t.getEstado());
			stmt.setString(2, t.getFechaIni());
			stmt.setString(3, t.getFechaFin());
			stmt.setString(4, t.getFechaEstimadaFin());
			stmt.setString(5, t.getFechaEstimadaIni());
			stmt.setString(6, t.getUbicacionAprox());
			stmt.setString(7, t.getObservaciones());
			stmt.setDouble(8, t.getValuacionTrabajo());
			stmt.setDouble(9, t.getPrecioFinal());
			stmt.setInt(10, t.getDniCliente());
			stmt.setInt(11, t.getDniTrabajador());
			stmt.setInt(12, t.getIdLocalidad());
			stmt.setInt(13, idTrabajo);

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

	public void drop(Trabajo trab) {
		PreparedStatement stmt = null;
		try {
			stmt = DbConnector.getInstancia().getConn()
					.prepareStatement("DELETE FROM `bkwscpfq5sshgak97bp2`.`trabajo` WHERE (`idTrabajo` =?);");

			stmt.setInt(1, trab.getIdTrabajo());

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