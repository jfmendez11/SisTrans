package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.AeronaveCarga;


public class DAOTablaAeronaveCarga {
	
	
	
	private ArrayList<Object> recursos;
	
	private Connection conn;
	
	private static final String USUARIO = "ISIS2304B131620.AERONAVE_CARGA";
	
	public DAOTablaAeronaveCarga () {
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
	
	public ArrayList<AeronaveCarga> darAeronavesCarga () throws SQLException, Exception {
		ArrayList <AeronaveCarga> ac = new ArrayList<AeronaveCarga>();
		
		String sql = "SELECT * FROM " + USUARIO;
		
		PreparedStatement ps = conn.prepareStatement(sql);
		recursos.add(ps);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			String numSerie = rs.getString("NUMERO_DE_SERIE");
			double capacidad = rs.getDouble("CAPACIDAD");
			String marca = rs.getString("MARCA");
			String modelo = rs.getString("MODELO");
			int anioFabricacion = rs.getInt("ANO_FABRICACION");
			boolean propiedadAerolinea = rs.getInt("ES_PROPIEDAD_AEROLINEA") == 1;
			int idAerolinea = rs.getInt("ID_AEROLINEA");
			ac.add(new AeronaveCarga(numSerie, capacidad, marca, modelo, anioFabricacion, propiedadAerolinea, idAerolinea));
		}
		return ac;
	}
	
	public void addAeronaveCarga(AeronaveCarga ac) throws SQLException, Exception {

		int esPropiedad = 0;
		if (ac.isPropiedadAerolinea()) esPropiedad = 1;
		
		String sql = "INSERT INTO " + USUARIO + " VALUES ('";
		sql += ac.getNumSerie() + "',";
		sql += ac.getCapacidad() + ",'";
		sql += ac.getMarca() + "','";
		sql += ac.getModelo() + "',";
		sql += ac.getAnoFabricacion() + ","; 
		sql += esPropiedad + ",";
		sql += ac.getIdAerolinea() + ")";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}
	
	public void updateAeronaveCarga (AeronaveCarga ac) throws SQLException, Exception {
		int esPropiedad = 0;
		if (ac.isPropiedadAerolinea()) esPropiedad = 1;
		
		String sql = "UPDATE " + USUARIO + " SET ";
		sql += "capacidad=" + ac.getCapacidad() + ",";
		sql += "marca='" + ac.getMarca() + "',";
		sql += "modelo='" + ac.getModelo() + "',";
		sql += "ano_fabricacion=" + ac.getAnoFabricacion() + ",";
		sql += "es_propidad_aerolinea=" + esPropiedad + ",";
		sql += "id_aerolinea=" + ac.getIdAerolinea();
		sql += " WHERE numero_de_serie = " + ac.getNumSerie();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
	public void deleteAeronaveCarga(AeronaveCarga ac) throws SQLException, Exception {

		String sql = "DELETE FROM " + USUARIO;
		sql += " WHERE numero_de_serie =" + ac.getNumSerie();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
}
