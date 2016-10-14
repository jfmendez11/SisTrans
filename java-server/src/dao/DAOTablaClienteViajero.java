package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.ClienteViajero;
import vos.NacionalidadCliente;

public class DAOTablaClienteViajero {

	private ArrayList<Object> recursos;

	private Connection conn;
	
	private final static String USUARIO = "ISIS2304B131620.CLIENTE_VIAJERO" ;

	public DAOTablaClienteViajero(){

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
	
	
	public ArrayList<ClienteViajero> darClientesViajeros() throws SQLException, Exception {
		ArrayList<ClienteViajero> clientesViajeros = new ArrayList<ClienteViajero>();

		String sql = "SELECT * FROM " + USUARIO;

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		
		DAOTablaNacionalidadCliente daoNC = new DAOTablaNacionalidadCliente();
		daoNC.setConn(conn);
		ArrayList<NacionalidadCliente> nacionalidades = daoNC.darNacionalidadCliente();

		while (rs.next()) {
			String nombre = rs.getString("NOMBRE");
			String idViajero = rs.getString("ID_VIAJERO");
			String nacionalidad = "";
			for (int i = 0; i < nacionalidades.size(); i++) {
				if (nacionalidades.get(i).getIdCliente().equals(idViajero)) {
					nacionalidad += nacionalidades.get(i).getNacionalidad() + ";";
				}
			}
			String identificacion = rs.getString("IDENTIFICACION");
			String tipoIdentificacion = rs.getString("TIPO_IDENTIFICACION");
			String correoElectronico = rs.getString("CORREO_ELECTRONICO");
			clientesViajeros.add(new ClienteViajero(idViajero, nombre, identificacion, tipoIdentificacion, correoElectronico, nacionalidad));
		}
		return clientesViajeros;
	}
	
	public void addClienteViajero(ClienteViajero clienteViajero) throws SQLException, Exception {

		int newId = 1;
		for (ClienteViajero cv : darClientesViajeros()) {
			if (newId <= Integer.parseInt(cv.getIdViajero())) {
				newId = Integer.parseInt(cv.getIdViajero()) + 1;
			}
		}
		System.out.println(newId);
		String strNewId = newId + "";
		
		String sql = "INSERT INTO " + USUARIO + " VALUES ('";
		sql += strNewId + "','";
		sql += clienteViajero.getNombre() + "','";
		sql += clienteViajero.getIdentificacion() + "','";
		sql += clienteViajero.getTipoIdentificacion() + "','";
		sql += clienteViajero.getCorreoElectronico() + "' )";
		
		clienteViajero.setIdViajero(strNewId);

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
	public void updateClienteViajero(ClienteViajero clienteViajero) throws SQLException, Exception {

		String sql = "UPDATE " + USUARIO + " SET ";
		sql += "nombre='" + clienteViajero.getNombre() + "',";
		sql += "identificacion=" + clienteViajero.getIdentificacion() + "',";
		sql += "tipo_identificacion='" + clienteViajero.getTipoIdentificacion() + "',";
		sql += "correo_electronico='" + clienteViajero.getCorreoElectronico() + "'";
		sql += " WHERE id_viajero= '" + clienteViajero.getIdViajero() + "'";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
	public void deleteClienteViajero(ClienteViajero clienteViajero) throws SQLException, Exception {

		String sql = "DELETE FROM " + USUARIO;
		sql += " WHERE id_viajero = " + clienteViajero.getIdViajero();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
}
