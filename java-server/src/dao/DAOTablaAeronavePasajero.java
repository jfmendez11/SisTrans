package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.AeronaveCarga;
import vos.AeronavePasajero;


public class DAOTablaAeronavePasajero {
	
	
	
	private ArrayList<Object> recursos;
	
	private Connection conn;
	
	private static final String USUARIO = "ISIS2304B131620.AERONAVE_PASAJEROS";
	
	public DAOTablaAeronavePasajero () {
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
	
	public ArrayList<AeronavePasajero> darAeronavesPasajero () throws SQLException, Exception {
		ArrayList <AeronavePasajero> ap = new ArrayList<AeronavePasajero>();
		
		String sql = "SELECT * FROM " + USUARIO;
		
		PreparedStatement ps = conn.prepareStatement(sql);
		recursos.add(ps);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			String numSerie = rs.getString("NUMERO_DE_SERIE");
			int capacidadEconomica = rs.getInt("CAPACIDAD_ECONOMICA");
			int capacidadEjecutiva = rs.getInt("CAPACIDAD_EJECUTIVA");
			String marca = rs.getString("MARCA");			
			int anioFabricacion = rs.getInt("ANO_FABRICACION");
			boolean propiedadAerolinea = rs.getInt("ES_PROPIEDAD_AEROLINEA") == 1;
			String modelo = rs.getString("MODELO");
			int idAerolinea = rs.getInt("ID_AEROLINEA");
			ap.add(new AeronavePasajero(numSerie, capacidadEconomica, capacidadEjecutiva, marca, anioFabricacion, propiedadAerolinea, modelo, idAerolinea));
		}
		return ap;
	}
	
	public void addAeronavePasajero(AeronavePasajero ap) throws SQLException, Exception {

		int esPropiedad = 0;
		if (ap.isPropiedadAerolinea()) esPropiedad = 1;
		
		String sql = "INSERT INTO " + USUARIO + " VALUES ('";
		sql += ap.getNumSerie() + "',";
		sql += ap.getCapacidadEconomica() + ",";
		sql += ap.getCapacidadEjecutiva() + ",'";
		sql += ap.getMarca() + "',";
		sql += ap.getAnoFabricacion() + ","; 
		sql += esPropiedad + ",'";
		sql += ap.getModelo() + "',";
		sql += ap.getIdAerolinea() + ")";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}
	
	public void updateAeronavePasajero (AeronavePasajero ap) throws SQLException, Exception {
		int esPropiedad = 0;
		if (ap.isPropiedadAerolinea()) esPropiedad = 1;
		
		String sql = "UPDATE " + USUARIO + " SET ";
		sql += "capacidadEconomica=" + ap.getCapacidadEconomica() + ",";
		sql += "capacidadEjecutiva=" + ap.getCapacidadEjecutiva() + ",";
		sql += "marca='" + ap.getMarca() + "',";
		sql += "ano_fabricacion=" + ap.getAnoFabricacion() + ",";
		sql += "es_propidad_aerolinea=" + esPropiedad + ",";
		sql += "modelo='" + ap.getModelo() + "',";
		sql += "id_aerolinea=" + ap.getIdAerolinea();
		sql += " WHERE numero_de_serie = " + ap.getNumSerie();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
	public void deleteAeronavePasajero(AeronavePasajero ap) throws SQLException, Exception {

		String sql = "DELETE FROM " + USUARIO;
		sql += " WHERE numero_de_serie =" + ap.getNumSerie();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
}
