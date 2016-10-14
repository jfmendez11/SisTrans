package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import vos.VueloCarga;
import vos.VueloPasajero;


public class DAOTablaVueloPasajero {
	
	
	private ArrayList<Object> recursos;
	
	private Connection conn;
	
	private static final String USUARIO = "ISIS2304B131620.VUELO_PASAJERO";
	
	public DAOTablaVueloPasajero () {
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
	
	public ArrayList<VueloPasajero> darVuelosPasajero () throws SQLException, Exception {
		ArrayList <VueloPasajero> vp = new ArrayList<VueloPasajero>();
		
		String sql = "SELECT * FROM " + USUARIO;
		
		PreparedStatement ps = conn.prepareStatement(sql);
		recursos.add(ps);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			String idVuelo = rs.getString("ID_VUELO");
			Date horaSalida = rs.getDate("HORA_SALIDA");
			Date horaLlegada = rs.getDate("HORA_LLEGADA");
			int frecuencia = rs.getInt("FRECUENCIA");
			double distancia = rs.getDouble("DISTANCIA");
			double duracion = rs.getDouble("DURACION");
			String clasificacion = rs.getString("CLASIFICACION");
			double costoEconomica = rs.getDouble("COSTO_ECONOMICA");
			double costoEjecutiva = rs.getDouble("COSTO_EJECUTIVA");
			String aeropuertoSalida = rs.getString("AEROPUERTO_SALIDA");
			String aeropuertoLlegada = rs.getString("AEROPUERTO_LLEGADA");
			int idAerolinea = rs.getInt("ID_AEROLINEA");
			String numSerie = rs.getString("NUMERO_SERIE");
			vp.add(new VueloPasajero(idVuelo, horaSalida, horaLlegada, frecuencia, distancia, duracion, clasificacion, costoEconomica, costoEjecutiva, aeropuertoSalida, aeropuertoLlegada, idAerolinea, numSerie));
		}
		return vp;
	}
	
	public void addVueloPasajero(VueloPasajero vp) throws SQLException, Exception {
		
		String sql = "INSERT INTO " + USUARIO + " VALUES ('";
		sql += vp.getIdVuelo() + "','";
		sql += vp.getHoraSalida() + "','";
		sql += vp.getHoraLlegada() + "',";
		sql += vp.getFrecuencia() + ",";
		sql += vp.getDistancia() + ",";
		sql += vp.getDuracion() + ",'";
		sql += vp.getClasificacion() + "',";
		sql += vp.getCostoEconomica() + ",";
		sql += vp.getCostoEjecutiva() + ",'";
		sql += vp.getAeropuertoSalida() + "','";
		sql += vp.getAeropuertoLlegada() + "',";
		sql += vp.getIdAerolinea() + ",'";
		sql += vp.getNumSerie()	+ "')";
		

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}
	
	public void updateVueloPasajero (VueloPasajero vp) throws SQLException, Exception {
		String sql = "UPDATE " + USUARIO + " SET ";
		sql += "hora_salida='" + vp.getHoraSalida() + "',";
		sql += "hora_llegada='" + vp.getHoraLlegada() + "',";
		sql += "frecuencia=" + vp.getFrecuencia() + ",";
		sql += "distancia=" + vp.getDistancia() + ",";
		sql += "duracion=" + vp.getDuracion() + ",";
		sql += "clasificacion='" + vp.getClasificacion() + "',";
		sql += "costo_economica=" + vp.getCostoEconomica() + ",";
		sql += "costo_ejecutiva=" + vp.getCostoEjecutiva() + ",";
		sql += "aeropuerto_salida='" + vp.getAeropuertoSalida() + "',";
		sql += "aeropuerto_llegada='" + vp.getAeropuertoLlegada() + "',";
		sql += "id_aerolinea=" + vp.getIdAerolinea() + ",";
		sql += "numero_serie='" + vp.getNumSerie() + "'";
		sql += " WHERE id_vuelo = '" + vp.getIdVuelo() + "'";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
	public void deleteVueloPasajero(VueloPasajero vp) throws SQLException, Exception {

		String sql = "DELETE FROM " + USUARIO;
		sql += " WHERE id_vuelo = '" + vp.getIdVuelo() + "'";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
}
