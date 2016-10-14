package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.NacionalidadCliente;

public class DAOTablaNacionalidadCliente {
	
	private ArrayList<Object> recursos;

	private Connection conn;

	private final static String USUARIO = "ISIS2304B131620.NACIONALIDAD_CLIENTE" ;

	public DAOTablaNacionalidadCliente(){

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
	
	public ArrayList<NacionalidadCliente> darNacionalidadCliente() throws SQLException, Exception {
		ArrayList<NacionalidadCliente> nacionalidadCliente = new ArrayList<NacionalidadCliente>();

		String sql = "SELECT * FROM " + USUARIO;

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			String idCliente = rs.getString("ID_CLIENTE");
			String nacionalidad = rs.getString("NACIONALIDAD");
			nacionalidadCliente.add(new NacionalidadCliente( idCliente, nacionalidad));
		}
		return nacionalidadCliente;
	}

	public void addNacionalidadCliente(NacionalidadCliente nacionalidadCliente) throws SQLException, Exception {

		String sql = "INSERT INTO " + USUARIO + " VALUES ('";
		sql += nacionalidadCliente.getIdCliente() + "','";
		sql += nacionalidadCliente.getNacionalidad() + "')";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
	public void deleteNacionalidadCliente(NacionalidadCliente nacionalidaCliente) throws SQLException, Exception {

		String sql = "DELETE FROM " + USUARIO;
		sql += " WHERE id_cliente = '" + nacionalidaCliente.getIdCliente() + "'";
		sql += " AND nacionalidad = '" + nacionalidaCliente.getNacionalidad() + "'";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

}
