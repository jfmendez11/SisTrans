package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.Administrador;
import vos.ClienteViajero;

public class DAOTablaAdministrador {
	
	private ArrayList<Object> recursos;
	
	private Connection conn;
	
	private static final String USUARIO = "ISIS2304B131620.ADMINISTRADOR";
	
	public DAOTablaAdministrador () {
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
	
	public ArrayList<Administrador> darAdministradores () throws SQLException, Exception {
		ArrayList <Administrador> administradores = new ArrayList<Administrador>();
		
		String sql = "SELECT * FROM " + USUARIO;
		
		PreparedStatement ps = conn.prepareStatement(sql);
		recursos.add(ps);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("ID");
			String nombre = rs.getString("NOMBRE");
			String identificacion = rs.getString("IDENTIFICACION");
			String tipoIdentificacion = rs.getString("TIPO_IDENTIFICACION");
			String correoElectronico = rs.getString("CORREO_ELECTRONICO");
			administradores.add(new Administrador(id, nombre, identificacion, tipoIdentificacion, correoElectronico));
		}
		return administradores;
	}
	
	public void addAdministrador(Administrador admin) throws SQLException, Exception {

		int newId = 1;
		for (Administrador a : darAdministradores()) {
			if (newId <= a.getId()) {
				newId = a.getId() + 1;
			}
		}
		
		String sql = "INSERT INTO " + USUARIO + " VALUES (";
		sql += newId + ",'";
		sql += admin.getNombre() + "','";
		sql += admin.getIdentificacion() + "','";
		sql += admin.getTipoIdentificacion() + "','";
		sql += admin.getCorreoElectronico() + "')";
		
		admin.setId(newId);

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}
	
	public void updateAdministrador (Administrador admin) throws SQLException, Exception {
		String sql = "UPDATE " + USUARIO + " SET ";
		sql += "nombre='" + admin.getNombre() + "',";
		sql += "identificacion='" + admin.getIdentificacion() + "',";
		sql += "tipo_identificacion='" + admin.getTipoIdentificacion() + "',";
		sql += "correo_electronico='" + admin.getCorreoElectronico() + "'";
		sql += " WHERE id = " + admin.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
	public void deleteAdministrador(Administrador admin) throws SQLException, Exception {

		String sql = "DELETE FROM " + USUARIO;
		sql += " WHERE id = " + admin.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

}
