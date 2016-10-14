package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import vos.ReservaCarga;

public class DAOTablaReservaCarga {

	private ArrayList<Object> recursos;

	private Connection conn;

	private final static String USUARIO = "ISIS2304B131620.RESERVA_CARGA" ;

	public DAOTablaReservaCarga(){

		recursos = new ArrayList<Object>();
	}

	public void cerrarRecursos() {
		for(Object ob : recursos){
			if(ob instanceof PreparedStatement)
				try {
					((PreparedStatement) ob).close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
		}
	}

	public void setConn(Connection con){
		this.conn = con;
	}
	
	public ArrayList<ReservaCarga> darReservaCarga() throws SQLException, Exception {
		ArrayList<ReservaCarga> reservasCarga = new ArrayList<ReservaCarga>();

		String sql = "SELECT * FROM " + USUARIO;

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			int id = rs.getInt("ID");
			String idVuelo = rs.getString("ID_VUELO");
			Date fechaSalidaVuelo = rs.getDate("FECHA_SALIDA_VUELO");
			Date fechaLlegadaVuelo = rs.getDate("FECHA_LLEGADA_VUELO");
			String contenido = rs.getString("CONTENIDO");
			Double volumen = rs.getDouble("VOLUMEN");
			Double peso = rs.getDouble("PESO");
			String idCliente = rs.getString("ID_CLIENTE");
			reservasCarga.add(new ReservaCarga( id, idVuelo, fechaSalidaVuelo, fechaLlegadaVuelo, contenido, volumen, peso, idCliente));
		}
		return reservasCarga;
	}

	public void addReservaCarga(ReservaCarga reservaCarga) throws SQLException, Exception {

		String sql = "INSERT " + USUARIO + " VALUES (";
		sql += reservaCarga.getId() + ",'";
		sql += reservaCarga.getIdVuelo() + "','";
		sql += reservaCarga.getFechaSalidaVuelo() + "','";
		sql += reservaCarga.getFechaLlegadaVuelo() + "','";
		sql += reservaCarga.getContenido() + "',";
		sql += reservaCarga.getVolumen() + ",";
		sql += reservaCarga.getPeso() + ",'";
		sql += reservaCarga.getIdCliente() + "')";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	public void updateReservaCarga(ReservaCarga reservaCarga) throws SQLException, Exception {

		String sql = "UPDATE " + USUARIO + " SET ";
		sql += "id_vuelo='" + reservaCarga.getIdVuelo() + "',";
		sql += "fecha_salida_vuelo=" + reservaCarga.getFechaSalidaVuelo() + "',";
		sql += "fecha_llegada_vuelo='" + reservaCarga.getFechaLlegadaVuelo() + "',";
		sql += "contenido='" + reservaCarga.getContenido() + "',";
		sql += "volumen=" + reservaCarga.getVolumen() + ",";
		sql += "peso=" + reservaCarga.getPeso() + ",";
		sql += "id_cliente='" + reservaCarga.getIdCliente() + "',"; 
		sql += " WHERE id= " + reservaCarga.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	public void deleteReservaCarga(ReservaCarga reservaCarga) throws SQLException, Exception {

		String sql = "DELETE FROM " + USUARIO;
		sql += " WHERE id = " + reservaCarga.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
}
