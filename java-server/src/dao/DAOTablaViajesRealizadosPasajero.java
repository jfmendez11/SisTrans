package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import vos.ViajesRealizadosPasajero;

public class DAOTablaViajesRealizadosPasajero {
		
		private ArrayList<Object> recursos;

		private Connection conn;

		private final static String USUARIO = "ISIS2304B131620.VIAJES_REALIZADOS_PASAJERO" ;

		public DAOTablaViajesRealizadosPasajero(){

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
		
		public ArrayList<ViajesRealizadosPasajero> darViajesRealizadosPasajero () throws SQLException, Exception {
			ArrayList<ViajesRealizadosPasajero> ViajesRealizadosPasajero = new ArrayList<ViajesRealizadosPasajero>();

			String sql = "SELECT * FROM " + USUARIO;

			PreparedStatement prepStmt = conn.prepareStatement(sql);
			recursos.add(prepStmt);
			ResultSet rs = prepStmt.executeQuery();

			while (rs.next()) {
				String idVueloRealCarga = rs.getString("ID_VUELO_REAL_PAS");
				String idClienteCarga = rs.getString("ID_CLIENTE_PAS");
				Date horaSalidaVuelo = rs.getDate("HORA_SALIDA_VUELO");
				Date horaLlegadaVuelo = rs.getDate("HORA_LLEGADA_VUELO");
				ViajesRealizadosPasajero.add(new ViajesRealizadosPasajero ( idVueloRealCarga, idClienteCarga, horaSalidaVuelo, horaLlegadaVuelo));
			}
			return ViajesRealizadosPasajero ;
		}

		public void addViajesRealizadosPasajero(ViajesRealizadosPasajero viajesRealizadosPasajero) throws SQLException, Exception {

			String sql = "INSERT " + USUARIO + " VALUES (";
			sql += viajesRealizadosPasajero.getIdVueloRealPas() + "','";
			sql += viajesRealizadosPasajero.getIdClientePas() + "','";
			sql += viajesRealizadosPasajero.getHoraSalidaVuelo() + "','";
			sql += viajesRealizadosPasajero.getHoraLlegadaVuelo() + "')";


			System.out.println("SQL stmt:" + sql);

			PreparedStatement prepStmt = conn.prepareStatement(sql);
			recursos.add(prepStmt);
			prepStmt.executeQuery();
		}

		public void deleteViajesRealizadosPasajero(ViajesRealizadosPasajero viajesRealizadosPasajero) throws SQLException, Exception {

			String sql = "DELETE FROM " + USUARIO;
			sql += " WHERE id_vuelo_carga = " + viajesRealizadosPasajero.getIdVueloRealPas();
			sql += "AND id_cliente_carga = " + viajesRealizadosPasajero.getIdClientePas();
			sql += "AND hora_salida_vuelo = " + viajesRealizadosPasajero.getHoraSalidaVuelo();
			sql += "AND hora_llegada_vuelo = " + viajesRealizadosPasajero.getHoraLlegadaVuelo();

			System.out.println("SQL stmt:" + sql);

			PreparedStatement prepStmt = conn.prepareStatement(sql);
			recursos.add(prepStmt);
			prepStmt.executeQuery();
		}

}
