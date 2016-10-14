package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.Administrador;
import vos.FuncionarioAerolineaPasajero;

public class DAOTablaFuncionarioAerolineaPasajero {
	
	private ArrayList<Object> recursos;

	private Connection conn;

	private final static String USUARIO = "ISIS2304B131620.FUNCIONARIO_AEROLINEA_PASAJERO" ;

	public DAOTablaFuncionarioAerolineaPasajero(){

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

	public ArrayList<FuncionarioAerolineaPasajero> darFuncionariosAerolineasPasajero() throws SQLException, Exception {
		ArrayList<FuncionarioAerolineaPasajero> funcionariosAerolineasPasajero = new ArrayList<FuncionarioAerolineaPasajero>();

		String sql = "SELECT * FROM " + USUARIO;

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			int idAerolinea = rs.getInt("ID_AEROLINEA");
			String nombre = rs.getString("NOMBRE");
			String identificacion = rs.getString("IDENTIFICACION");
			String correoElectronico = rs.getString("CORREO_ELECTRONICO");
			String tipoIdentificacion = rs.getString("TIPO_IDENTIFICACION");
			int id = Integer.parseInt(rs.getString("ID"));
			funcionariosAerolineasPasajero.add(new FuncionarioAerolineaPasajero( idAerolinea, nombre, identificacion, correoElectronico, tipoIdentificacion, id));
		}
		return funcionariosAerolineasPasajero;
	}

	public void addFuncionarioAerolineaPasajero(FuncionarioAerolineaPasajero funcionarioAerolineaPasajero) throws SQLException, Exception {

		int newId = 1;
		for (FuncionarioAerolineaPasajero fp : darFuncionariosAerolineasPasajero()) {
			if (newId <= fp.getId()) {
				newId = fp.getId() + 1;
			}
		}
		
		String sql = "INSERT INTO " + USUARIO + " VALUES (";
		sql += funcionarioAerolineaPasajero.getIdAerolinea() + ",'";
		sql += funcionarioAerolineaPasajero.getNombre() + "','";
		sql += funcionarioAerolineaPasajero.getIdentificacion() + "','";
		sql += funcionarioAerolineaPasajero.getCorreoElectronico() + "','";
		sql += funcionarioAerolineaPasajero.getTipoIdentificacion() + "',";
		sql += newId + " )";

		System.out.println("SQL stmt:" + sql);
		
		funcionarioAerolineaPasajero.setId(newId);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	public void updateFuncionarioAerolineaPasajero(FuncionarioAerolineaPasajero funcionarioAerolineaPasajero) throws SQLException, Exception {

		String sql = "UPDATE " + USUARIO + " SET ";
		sql += "id_aerolinea=" + funcionarioAerolineaPasajero.getIdAerolinea() + "";
		sql += "nombre='" + funcionarioAerolineaPasajero.getNombre() + "',";
		sql += "identificacion=" + funcionarioAerolineaPasajero.getIdentificacion() + "',";
		sql += "correo_electronico='" + funcionarioAerolineaPasajero.getCorreoElectronico() + "',";
		sql += "tipo_identificacion='" + funcionarioAerolineaPasajero.getTipoIdentificacion() + "'";
		sql += " WHERE id= " + funcionarioAerolineaPasajero.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	public void deleteFuncionarioAerolineaPasajero(FuncionarioAerolineaPasajero funcionarioAerolineaPasajero) throws SQLException, Exception {

		String sql = "DELETE FROM " + USUARIO;
		sql += " WHERE id = " + funcionarioAerolineaPasajero.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

}
