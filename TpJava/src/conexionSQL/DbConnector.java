package conexionSQL;

import java.sql.*;

public class DbConnector {

	private static DbConnector instancia;

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String host = "bkwscpfq5sshgak97bp2-mysql.services.clever-cloud.com";
	private String port = "3306";
	private String user = "uyn2jpxs2dreeicw";
	private String password = "d2D3L11EHkHjrlFxc3Qe";
	private String db = "bkwscpfq5sshgak97bp2";
	private int conectados = 0;
	private Connection conn = null;

	private DbConnector() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static DbConnector getInstancia() {
		if (instancia == null) {
			instancia = new DbConnector();
		}
		return instancia;
	}

	public Connection getConn() {
		try {
			if (conn == null || conn.isClosed()) {
				conn = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + db, user, password);
				conectados = 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conectados++;
		return conn;
	}

	public void releaseConn() {
		conectados--;
		try {
			if (conectados <= 0) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}