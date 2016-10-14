package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.Administrador;
import vos.AerolineaCarga;


public class DAOTablaAerolineaCarga {
	
	
	private ArrayList<Object> recursos;
	
	private Connection conn;
	
	private static final String USUARIO = "ISIS2304B131620.AEROLINEA_CARGA";
	
	public DAOTablaAerolineaCarga () {
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
	
	public ArrayList<AerolineaCarga> darAerolineasCarga () throws SQLException, Exception {
		ArrayList <AerolineaCarga> ac = new ArrayList<AerolineaCarga>();
		
		String sql = "SELECT * FROM " + USUARIO;
		
		PreparedStatement ps = conn.prepareStatement(sql);
		recursos.add(ps);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("ID");
			String nombre = rs.getString("NOMBRE");
			String idIata = rs.getString("ID_IATA");
			String codigo = rs.getString("CODIGO");
			String paisRadicacion = rs.getString("PAIS_RADICACION");
			ac.add(new AerolineaCarga(id, nombre, idIata, codigo, paisRadicacion));
		}
		return ac;
	}
	
	public void addAerolineaCarga(AerolineaCarga ac) throws SQLException, Exception {

		int newId = 1;
		for (AerolineaCarga aerolinea : darAerolineasCarga()) {
			if (newId <= aerolinea.getId()) {
				newId = aerolinea.getId() + 1;
			}
		}
		
		String sql = "INSERT INTO " + USUARIO + " VALUES (";
		sql += newId + ",'";
		sql += ac.getNombre() + "','";
		sql += ac.getIdIata() + "','";
		sql += ac.getCodigo() + "','";
		sql += ac.getPaisRadicacion() + "')";
		
		ac.setId(newId);

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}
	
	public void updateAerolineaCarga (AerolineaCarga ac) throws SQLException, Exception {
		String sql = "UPDATE " + USUARIO + " SET ";
		sql += "nombre='" + ac.getNombre() + "',";
		sql += "id_iata='" + ac.getIdIata() + "',";
		sql += "codigo='" + ac.getCodigo() + "',";
		sql += "pais_radicacion='" + ac.getPaisRadicacion() + "'";
		sql += " WHERE id = " + ac.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
	public void deleteAerolineaCarga(AerolineaCarga ac) throws SQLException, Exception {

		String sql = "DELETE FROM " + USUARIO;
		sql += " WHERE id =" + ac.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

}
