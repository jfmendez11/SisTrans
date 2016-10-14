package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.Administrador;
import vos.FuncionarioAerolineaCarga;

public class DAOTablaFuncionarioAerolineaCarga {

	private ArrayList<Object> recursos;

	private Connection conn;

	private final static String USUARIO = "ISIS2304B131620.FUNCIONARIO_AEROLINEA_CARGA" ;

	public DAOTablaFuncionarioAerolineaCarga(){

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

	public ArrayList<FuncionarioAerolineaCarga> darFuncionariosAerolineasCarga() throws SQLException, Exception {
		ArrayList<FuncionarioAerolineaCarga> funcionariosAerolineasCarga = new ArrayList<FuncionarioAerolineaCarga>();

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
			funcionariosAerolineasCarga.add(new FuncionarioAerolineaCarga( idAerolinea, nombre, identificacion, correoElectronico, tipoIdentificacion, id));
		}
		return funcionariosAerolineasCarga;
	}

	public void addFuncionarioAerolineaCarga(FuncionarioAerolineaCarga funcionarioAerolineaCarga) throws SQLException, Exception {

		int newId = 1;
		for (FuncionarioAerolineaCarga fc : darFuncionariosAerolineasCarga()) {
			if (newId <= fc.getId()) {
				newId = fc.getId() + 1;
			}
		}
		
		String sql = "INSERT INTO " + USUARIO + " VALUES (";
		sql += funcionarioAerolineaCarga.getIdAerolinea() + ",'";
		sql += funcionarioAerolineaCarga.getNombre() + "','";
		sql += funcionarioAerolineaCarga.getIdentificacion() + "','";
		sql += funcionarioAerolineaCarga.getCorreoElectronico() + "','";
		sql += funcionarioAerolineaCarga.getTipoIdentificacion() + "',";
		sql += newId + " )";

		System.out.println("SQL stmt:" + sql);
		
		funcionarioAerolineaCarga.setId(newId);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	public void updateFuncionarioAerolineaCarga(FuncionarioAerolineaCarga funcionarioAerolineaCarga) throws SQLException, Exception {

		String sql = "UPDATE " + USUARIO + " SET ";
		sql += "id_aerolinea=" + funcionarioAerolineaCarga.getIdAerolinea() + "";
		sql += "nombre='" + funcionarioAerolineaCarga.getNombre() + "',";
		sql += "identificacion=" + funcionarioAerolineaCarga.getIdentificacion() + "',";
		sql += "correo_electronico='" + funcionarioAerolineaCarga.getCorreoElectronico() + "',";
		sql += "tipo_identificacion='" + funcionarioAerolineaCarga.getTipoIdentificacion() + "'";
		sql += " WHERE id= " + funcionarioAerolineaCarga.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	public void deleteFuncionarioAerolineaCarga(FuncionarioAerolineaCarga funcionarioAerolineaCarga) throws SQLException, Exception {

		String sql = "DELETE FROM " + USUARIO;
		sql += " WHERE id = " + funcionarioAerolineaCarga.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}


}
