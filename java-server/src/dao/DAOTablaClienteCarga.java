package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.ClienteCarga;


public class DAOTablaClienteCarga {
	
	private ArrayList<Object> recursos;
	
	private Connection conn;
	
	private static final String USUARIO = "ISIS2304B131620.CLIENTE_CARGA";
	
	public DAOTablaClienteCarga () {
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
	
	public ArrayList<ClienteCarga> darClientesCarga () throws SQLException, Exception {
		ArrayList <ClienteCarga> clientesCarga = new ArrayList<ClienteCarga>();
		
		String sql = "SELECT * FROM " + USUARIO;
		
		PreparedStatement ps = conn.prepareStatement(sql);
		recursos.add(ps);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			String id = rs.getString("ID");
			String nombre = rs.getString("NOMBRE");
			String tipoIdentificacion = rs.getString("TIPO_IDENTIFICACION");
			String correoElectronico = rs.getString("CORREO_ELECTRONICO");
			String identificacion = rs.getString("IDENTIFICACION");
			clientesCarga.add(new ClienteCarga(id, nombre, tipoIdentificacion, correoElectronico, identificacion));
		}
		return clientesCarga;
	}
	
	public void addClienteCarga(ClienteCarga cc) throws SQLException, Exception {
		
		int newId = 1;
		for (ClienteCarga clienteC : darClientesCarga()) {
			if (newId <= Integer.parseInt(clienteC.getId())) {
				newId = Integer.parseInt(clienteC.getId()) + 1;
			}
		}
		
		String strNewId = newId + "";

		String sql = "INSERT INTO " + USUARIO + " VALUES ('";
		sql += strNewId + "','";
		sql += cc.getNombre() + "','";
		sql += cc.getTipoIdentificacion() + "','";
		sql += cc.getCorreoElectronico() + "','";
		sql += cc.getIdentificacion() + "')";
		
		cc.setId(strNewId);
		
		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}
	
	public void updateClienteCarga (ClienteCarga cc) throws SQLException, Exception {
		String sql = "UPDATE " + USUARIO + " SET ";
		sql += "nombre='" + cc.getNombre() + "',";
		sql += "tipo_identificacion='" + cc.getTipoIdentificacion() + "',";
		sql += "correo_electronico='" + cc.getCorreoElectronico() + "',";
		sql += "identificacion='" + cc.getIdentificacion() + "'";
		sql += " WHERE id = '" + cc.getId() + "'";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
	public void deleteClienteCarga(ClienteCarga cc) throws SQLException, Exception {

		String sql = "DELETE FROM " + USUARIO;
		sql += " WHERE id = '" + cc.getId() + "'";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
}
