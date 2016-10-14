package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.Administrador;
import vos.AerolineaPasajeros;

public class DAOTablaAerolineaPasajeros {

	private ArrayList<Object> recursos;

	private Connection conn;

	private final static String USUARIO = "ISIS2304B131620.AEROLINEA_PASAJEROS" ;

	public DAOTablaAerolineaPasajeros(){

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


	public ArrayList<AerolineaPasajeros> darAerolineasPasajeros() throws SQLException, Exception {
		ArrayList<AerolineaPasajeros> aerolineasPasajeros = new ArrayList<AerolineaPasajeros>();

		String sql = "SELECT * FROM " + USUARIO;

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			String nombre = rs.getString("NOMBRE");
			String idIATA = rs.getString("ID_IATA");
			String codigo = rs.getString("CODIGO");
			int idAerolinea = Integer.parseInt(rs.getString("ID_AEROLINEA"));
			String paisRadicacion = rs.getString("PAIS_RADICACION");
			aerolineasPasajeros.add(new AerolineaPasajeros( nombre, idIATA, codigo, idAerolinea, paisRadicacion));
		}
		return aerolineasPasajeros;
	}

	public void addAerolineaPasajeros(AerolineaPasajeros aerolineaPasajeros) throws SQLException, Exception {

		int newId = 1;
		for (AerolineaPasajeros aerolinea : darAerolineasPasajeros()) {
			if (newId <= aerolinea.getIdAerolinea()) {
				newId = aerolinea.getIdAerolinea() + 1;
			}
		}
		
		String sql = "INSERT INTO " + USUARIO + " VALUES ('";
		sql += aerolineaPasajeros.getNombre() + "','";
		sql += aerolineaPasajeros.getIdIata() + "','";
		sql += aerolineaPasajeros.getCodigo() + "',";
		sql += newId + ",'";
		sql += aerolineaPasajeros.getPaisRadicacion() + "' )";
		
		aerolineaPasajeros.setIdAerolinea(newId);

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	public void updateAerolineaPasajeros(AerolineaPasajeros aerolineaPasajeros) throws SQLException, Exception {

		String sql = "UPDATE " + USUARIO + " SET ";
		sql += "nombre='" + aerolineaPasajeros.getNombre() + "',";
		sql += "id_iata=" + aerolineaPasajeros.getIdIata() + "',";
		sql += "codigo='" + aerolineaPasajeros.getCodigo() + "',";
		sql += "pais_radicacion='" + aerolineaPasajeros.getPaisRadicacion() + "'";
		sql += " WHERE id_aerolinea= '" + aerolineaPasajeros.getIdAerolinea() + "'";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	public void deleteAerolineaPasajeros(AerolineaPasajeros aerolineaPasajeros) throws SQLException, Exception {

		String sql = "DELETE FROM " + USUARIO;
		sql += " WHERE id_aerolinea = " + aerolineaPasajeros.getIdAerolinea();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

}
