package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import vos.Administrador;
import vos.VueloCarga;



public class DAOTablaVueloCarga {
	
	private ArrayList<Object> recursos;
	
	private Connection conn;
	
	private static final String USUARIO = "ISIS2304B131620.VUELO_CARGA";
	
	public DAOTablaVueloCarga () {
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
	
	public ArrayList<VueloCarga> darVuelosCarga () throws SQLException, Exception {
		ArrayList <VueloCarga> vc = new ArrayList<VueloCarga>();
		
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
			double costo = rs.getDouble("COSTO");
			String aeropuertoSalida = rs.getString("AEROPUERTO_SALIDA");
			String aeropuertoLlegada = rs.getString("AEROPUERTO_LLEGADA");
			int idAerolinea = rs.getInt("ID_AEROLINEA");
			String numSerie = rs.getString("NUMERO_SERIE");
			vc.add(new VueloCarga(idVuelo, horaSalida, horaLlegada, frecuencia, distancia, duracion, clasificacion, costo, aeropuertoSalida, aeropuertoLlegada, idAerolinea, numSerie));
		}
		return vc;
	}
	
	public void addVueloCarga(VueloCarga vc) throws SQLException, Exception {
		
		String sql = "INSERT INTO " + USUARIO + " VALUES ('";
		sql += vc.getIdVuelo() + "','";
		sql += vc.getHoraSalida() + "','";
		sql += vc.getHoraLlegada() + "',";
		sql += vc.getFrecuencia() + ",";
		sql += vc.getDistancia() + ",";
		sql += vc.getDuracion() + ",'";
		sql += vc.getClasificacion() + "',";
		sql += vc.getCosto() + ",'";
		sql += vc.getAeropuertoSalida() + "','";
		sql += vc.getAeropuertoLlegada() + "',";
		sql += vc.getIdAerolinea() + ",'";
		sql += vc.getNumSerie()	+ "')";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}
	
	public void updateVueloCarga (VueloCarga vc) throws SQLException, Exception {
		String sql = "UPDATE " + USUARIO + " SET ";
		sql += "hora_salida='" + vc.getHoraSalida() + "',";
		sql += "hora_llegada='" + vc.getHoraLlegada() + "',";
		sql += "frecuencia=" + vc.getFrecuencia() + ",";
		sql += "distancia=" + vc.getDistancia() + ",";
		sql += "duracion=" + vc.getDuracion() + ",";
		sql += "clasificacion='" + vc.getClasificacion() + "',";
		sql += "costo=" + vc.getCosto() + ",";
		sql += "aeropuerto_salida='" + vc.getAeropuertoSalida() + "',";
		sql += "aeropuerto_llegada='" + vc.getAeropuertoLlegada() + "',";
		sql += "id_aerolinea=" + vc.getIdAerolinea() + ",";
		sql += "numero_serie='" + vc.getNumSerie() + "'";
		sql += " WHERE id_vuelo = '" + vc.getIdVuelo() + "'";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
	public void deleteVueloCarga(VueloCarga vc) throws SQLException, Exception {

		String sql = "DELETE FROM " + USUARIO;
		sql += " WHERE id_vuelo = '" + vc.getIdVuelo() + "'";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

}
