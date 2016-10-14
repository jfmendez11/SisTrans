package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import vos.ViajesRealizadosCarga;

public class DAOTablaViajesRealizadosCarga {
	
	private ArrayList<Object> recursos;

	private Connection conn;

	private final static String USUARIO = "ISIS2304B131620.VIAJES_REALIZADOS_CARGA" ;

	public DAOTablaViajesRealizadosCarga(){

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
	
	public ArrayList<ViajesRealizadosCarga> darViajesRealizadosCarga () throws SQLException, Exception {
		ArrayList<ViajesRealizadosCarga> ViajesRealizadosCarga = new ArrayList<ViajesRealizadosCarga>();

		String sql = "SELECT * FROM " + USUARIO;

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		
		while (rs.next()) {
			String idVueloRealCarga = rs.getString("ID_VUELO_REAL_CARGA");
			String idClienteCarga = rs.getString("ID_CLIENTE_CARGA");
			Date horaSalidaVuelo = rs.getTimestamp("HORA_SALIDA_VUELO");
			Date horaLlegadaVuelo = rs.getTimestamp("HORA_LLEGADA_VUELO");
			ViajesRealizadosCarga.add(new ViajesRealizadosCarga ( idVueloRealCarga, idClienteCarga, horaSalidaVuelo, horaLlegadaVuelo));
		}
		return ViajesRealizadosCarga ;
	}

	public void addViajesRealizadosCarga(ViajesRealizadosCarga viajesRealizadosCarga) throws SQLException, Exception {

		String sql = "INSERT " + USUARIO + " VALUES (";
		sql += viajesRealizadosCarga.getIdVueloRealCarga() + "','";
		sql += viajesRealizadosCarga.getIdClienteCarga() + "','";
		sql += viajesRealizadosCarga.getHoraSalidaVuelo() + "','";
		sql += viajesRealizadosCarga.getHoraLlegadaVuelo() + "')";


		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	public void deleteViajesRealizadosCarga(ViajesRealizadosCarga viajesRealizadosCarga) throws SQLException, Exception {

		String sql = "DELETE FROM " + USUARIO;
		sql += " WHERE id_vuelo_carga = " + viajesRealizadosCarga.getIdVueloRealCarga();
		sql += "AND id_cliente_carga = " + viajesRealizadosCarga.getIdClienteCarga();
		sql += "AND hora_salida_vuelo = " + viajesRealizadosCarga.getHoraSalidaVuelo();
		sql += "AND hora_llegada_vuelo = " + viajesRealizadosCarga.getHoraLlegadaVuelo();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

}
