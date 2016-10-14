package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.Administrador;
import vos.FuncionarioAeropuerto;


public class DAOTablaFuncionarioAeropuerto {
	
	private ArrayList<Object> recursos;
	
	private Connection conn;
	
	private static final String USUARIO = "ISIS2304B131620.FUNCIONARIO_AEROPUERTO";
	
	public DAOTablaFuncionarioAeropuerto () {
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
	
	public ArrayList<FuncionarioAeropuerto> darFuncionariosAeropuerto () throws SQLException, Exception {
		ArrayList <FuncionarioAeropuerto> funcionariosAeropuerto = new ArrayList<FuncionarioAeropuerto>();
		
		String sql = "SELECT * FROM " + USUARIO;
		
		PreparedStatement ps = conn.prepareStatement(sql);
		recursos.add(ps);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			String codigoAeropuerto = rs.getString("CODIGO_AEROPUERTO");
			String nombre = rs.getString("NOMBRE");
			String identificacion = rs.getString("IDENTIFICACION");
			String correoElectronico = rs.getString("CORREO_ELECTRONICO");
			String tipoIdentificacion = rs.getString("TIPO_IDENTIFICACION");
			int id = rs.getInt("ID");
			funcionariosAeropuerto.add(new FuncionarioAeropuerto(codigoAeropuerto, nombre, identificacion, correoElectronico, tipoIdentificacion, id));
		}
		return funcionariosAeropuerto;
	}
	
	public void addFuncionarioAeropuerto(FuncionarioAeropuerto fa) throws SQLException, Exception {
		
		int newId = 1;
		for (FuncionarioAeropuerto funcionario : darFuncionariosAeropuerto()) {
			if (newId <= funcionario.getId()) {
				newId = funcionario.getId() + 1;
			}
		}
		
		String sql = "INSERT INTO " + USUARIO + " VALUES ('";
		sql += fa.getCodigoAeropuerto() + "','";
		sql += fa.getNombre() + "','";
		sql += fa.getIdentificacion() + "','";
		sql += fa.getCorreoElectronico() + "','";
		sql += fa.getTipoIdentificacion() + "',"; 
		sql += newId + ")";

		System.out.println("SQL stmt:" + sql);
		
		fa.setId(newId);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}
	
	public void updateFuncionarioAeropuerto (FuncionarioAeropuerto fa) throws SQLException, Exception {
		String sql = "UPDATE " + USUARIO + " SET ";
		sql += "codigo_aeropuerto='" + fa.getCodigoAeropuerto() + "',";
		sql += "nombre='" + fa.getNombre() + "',";
		sql += "identificacion='" + fa.getIdentificacion() + "',";
		sql += "correo_electronico='" + fa.getCorreoElectronico() + "',";
		sql += "tipo_identificacion='" + fa.getTipoIdentificacion() + "'";
		sql += " WHERE id = " + fa.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
	public void deleteFuncionarioAeropuerto(FuncionarioAeropuerto fa) throws SQLException, Exception {

		String sql = "DELETE FROM " + USUARIO;
		sql += " WHERE id = " + fa.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
}
