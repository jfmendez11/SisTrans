package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.Aeropuerto;



public class DAOTablaAeropuerto {
	
	private ArrayList<Object> recursos;
	
	private Connection conn;
	
	private static final String USUARIO = "ISIS2304B131620.AEROPUERTO";
	
	public DAOTablaAeropuerto () {
		recursos = new ArrayList<Object>();
	}
	
	public void cerrarRecursos () {
		for (Object ob : recursos) {
			if (ob instanceof PreparedStatement) {
				try {
					((PreparedStatement) ob).close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
	
	public void setConn (Connection conn) {
		this.conn = conn;
	}
	
	public ArrayList<Aeropuerto> darAeropuertos () throws SQLException, Exception {
		ArrayList <Aeropuerto> aeropuertos = new ArrayList<Aeropuerto>();
		
		String sql = "SELECT * FROM " + USUARIO;
		
		PreparedStatement ps = conn.prepareStatement(sql);
		recursos.add(ps);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			String codigo = rs.getString("CODIGO");
			String nombre = rs.getString("NOMBRE");
			String capacidad = rs.getString("CAPACIDAD");
			String ciudad = rs.getString("CIUDAD");
			String pais = rs.getString("PAIS");
			aeropuertos.add(new Aeropuerto(codigo, nombre, capacidad, ciudad, pais));
		}
		return aeropuertos;
	}
	
	public void addAeropuerto(Aeropuerto aeropuerto) throws SQLException, Exception {

		String sql = "INSERT INTO " + USUARIO + " VALUES ('";
		sql += aeropuerto.getCodigo() + "','";
		sql += aeropuerto.getNombre() + "','";
		sql += aeropuerto.getCapacidad() + "','";
		sql += aeropuerto.getCiudad() + "','";
		sql += aeropuerto.getPais() + "')";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}
	
	public void updateAeropuerto (Aeropuerto aeropuerto) throws SQLException, Exception {
		String sql = "UPDATE " + USUARIO + ".ADMINISTRADOR SET ";
		sql += "nombre='" + aeropuerto.getNombre() + "',";
		sql += "capacidad='" + aeropuerto.getCapacidad() + "',";
		sql += "ciudad='" + aeropuerto.getCiudad() + "',";
		sql += "pais='" + aeropuerto.getPais() + "'";
		sql += " WHERE codigo = '" + aeropuerto.getCodigo() + "'";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
	public void deleteAeropuerto(Aeropuerto aeropuerto) throws SQLException, Exception {

		String sql = "DELETE FROM " + USUARIO;
		sql += " WHERE codigo = '" + aeropuerto.getCodigo() + "'";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

}
