package logic;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexionSQL.DataPersona;
import entidades.*;

public class pruebas {

public static void main(String[] args) {
	 Persona p=new Persona(41790650, "dwad", "adw", "fwaf", "fewa", "wfa", 150.0, "fwaf", null, null, null, null);
	 System.out.println(p);
}
}


