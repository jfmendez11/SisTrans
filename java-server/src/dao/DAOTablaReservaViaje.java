package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import vos.ReservaViaje;

public class DAOTablaReservaViaje {
	
	private ArrayList<Object> recursos;

	private Connection conn;

	private final static String USUARIO = "ISIS2304B131620.RESERVA_VIAJE" ;

	public DAOTablaReservaViaje(){

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
	
	public ArrayList<ReservaViaje> darReservasViaje() throws SQLException, Exception {
		ArrayList<ReservaViaje> reservasViaje = new ArrayList<ReservaViaje>();

		String sql = "SELECT * FROM " + USUARIO;

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			int id = rs.getInt("ID");
			String idVuelo = rs.getString("ID_VUELO");
			Date fechaSalidaVuelo = rs.getDate("FECHA_SALIDA_VUELO");
			Date fechaLlegadaVuelo = rs.getDate("FECHA_LLEGADA_VUELO");
			String numeroSilla = rs.getString("NUMERO_SILLA");
			String claseSilla = rs.getString("CLASE_SILLA");
			String idCliente = rs.getString("ID_CLIENTE");
			reservasViaje.add(new ReservaViaje( id, idVuelo, fechaSalidaVuelo, fechaLlegadaVuelo, numeroSilla, claseSilla, idCliente));
		}
		return reservasViaje;
	}

	public void addReservaViaje(ReservaViaje reservaViaje) throws SQLException, Exception {

		String sql = "INSERT " + USUARIO + " VALUES (";
		sql += reservaViaje.getId() + ",'";
		sql += reservaViaje.getIdVuelo() + "','";
		sql += reservaViaje.getFechaSalidaVuelo() + "','";
		sql += reservaViaje.getFechaLlegadaVuelo() + "','";
		sql += reservaViaje.getNumeroSilla() + "',";
		sql += reservaViaje.getClaseSilla() + ",";
		sql += reservaViaje.getIdCliente() + "')";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	public void updateReservaViaje(ReservaViaje reservaViaje) throws SQLException, Exception {

		String sql = "UPDATE " + USUARIO + " SET ";
		sql += "id_vuelo='" + reservaViaje.getIdVuelo() + "',";
		sql += "fecha_salida_vuelo=" + reservaViaje.getFechaSalidaVuelo() + "',";
		sql += "fecha_llegada_vuelo='" + reservaViaje.getFechaLlegadaVuelo() + "',";
		sql += "numero_silla='" + reservaViaje.getNumeroSilla()+ "',";
		sql += "clase_silla='" + reservaViaje.getClaseSilla()+ "',";
		sql += "id_cliente='" + reservaViaje.getIdCliente() + "',"; 
		sql += " WHERE id= " + reservaViaje.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	public void deleteReservaViaje(ReservaViaje reservaViaje) throws SQLException, Exception {

		String sql = "DELETE FROM " + USUARIO;
		sql += " WHERE id = " + reservaViaje.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

}
