package tm;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import dao.*;
import vos.*;



public class VuelAndesMaster {
	
	private static final String CONNECTION_DATA_FILE_NAME_REMOTE = "/conexion.properties";
	
	private  String connectionDataPath;
	
	private String user;
	
	private String password;
	
	private String url;
	
	private String driver;
	
	private Connection conn;
	
	public VuelAndesMaster(String contextPathP) {
		connectionDataPath = contextPathP + CONNECTION_DATA_FILE_NAME_REMOTE;
		initConnectionData();
	}
	
	private void initConnectionData() {
		try {
			File file = new File(this.connectionDataPath);
			Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(file);
			prop.load(fis);
			fis.close();
			this.url = prop.getProperty("url");
			this.user = prop.getProperty("usuario");
			this.password = prop.getProperty("clave");
			this.driver = prop.getProperty("driver");
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Connection darConexion() throws SQLException {
		System.out.println("Connecting to: " + url + " With user: " + user);
		return DriverManager.getConnection(url, user, password);
	}
	
	public ListaAdministrador darAdministradores() throws Exception {
		ArrayList<Administrador> admins;
		DAOTablaAdministrador daoAdmin = new DAOTablaAdministrador();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoAdmin.setConn(conn);
			admins = daoAdmin.darAdministradores();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoAdmin.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaAdministrador(admins);
	}
	
	public void addAdministrador (Administrador admin) throws Exception {
		DAOTablaAdministrador daoAdmin = new DAOTablaAdministrador();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoAdmin.setConn(conn);
			daoAdmin.addAdministrador(admin);
			conn.commit();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoAdmin.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void addAdministradores (ListaAdministrador admins) throws Exception {
		DAOTablaAdministrador daoAdmin = new DAOTablaAdministrador();
		try 
		{
			//////Transacción - ACID Example
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoAdmin.setConn(conn);
			for(Administrador admin : admins.getAdministradores())
				daoAdmin.addAdministrador(admin);
			conn.commit();
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} finally {
			try {
				daoAdmin.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void updateAdiministrador (Administrador admin) throws Exception {
		DAOTablaAdministrador daoAdmin = new DAOTablaAdministrador();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoAdmin.setConn(conn);
			daoAdmin.updateAdministrador(admin);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoAdmin.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void deleteAdministrador (Administrador admin) throws Exception {
		DAOTablaAdministrador daoAdmin = new DAOTablaAdministrador();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoAdmin.setConn(conn);
			daoAdmin.deleteAdministrador(admin);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoAdmin.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public ListaAerolineaCarga darAerolineasCarga() throws Exception {
		ArrayList<AerolineaCarga> aerolineas;
		DAOTablaAerolineaCarga daoAC = new DAOTablaAerolineaCarga();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoAC.setConn(conn);
			aerolineas = daoAC.darAerolineasCarga();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoAC.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaAerolineaCarga(aerolineas);
	}
	
	public void addAerolineaCarga (AerolineaCarga ac) throws Exception {
		DAOTablaAerolineaCarga daoAC = new DAOTablaAerolineaCarga();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoAC.setConn(conn);
			daoAC.addAerolineaCarga(ac);
			conn.commit();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoAC.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void addAerolineasCarga (ListaAerolineaCarga aerolineas) throws Exception {
		DAOTablaAerolineaCarga daoAC = new DAOTablaAerolineaCarga();
		try 
		{
			//////Transacción - ACID Example
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoAC.setConn(conn);
			for(AerolineaCarga ac : aerolineas.getAerolineasCarga())
				daoAC.addAerolineaCarga(ac);
			conn.commit();
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} finally {
			try {
				daoAC.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void updateAerolineaCarga (AerolineaCarga ac) throws Exception {
		DAOTablaAerolineaCarga daoAC = new DAOTablaAerolineaCarga();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoAC.setConn(conn);
			daoAC.updateAerolineaCarga(ac);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoAC.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void deleteAerolineaCarga (AerolineaCarga ac) throws Exception {
		DAOTablaAerolineaCarga daoAC = new DAOTablaAerolineaCarga();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoAC.setConn(conn);
			daoAC.deleteAerolineaCarga(ac);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoAC.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public ListaAerolineaPasajeros darAerolineasPasajero() throws Exception {
		ArrayList<AerolineaPasajeros> aerolineas;
		DAOTablaAerolineaPasajeros daoAP = new DAOTablaAerolineaPasajeros();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoAP.setConn(conn);
			aerolineas = daoAP.darAerolineasPasajeros();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoAP.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaAerolineaPasajeros(aerolineas);
	}
	
	public void addAerolineaPasajero (AerolineaPasajeros ap) throws Exception {
		DAOTablaAerolineaPasajeros daoAP = new DAOTablaAerolineaPasajeros();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoAP.setConn(conn);
			daoAP.addAerolineaPasajeros(ap);
			conn.commit();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoAP.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void addAerolineasPasajero (ListaAerolineaPasajeros aerolineas) throws Exception {
		DAOTablaAerolineaPasajeros daoAP = new DAOTablaAerolineaPasajeros();
		try 
		{
			//////Transacción - ACID Example
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoAP.setConn(conn);
			for(AerolineaPasajeros ap : aerolineas.getAerolineaPasajeros())
				daoAP.addAerolineaPasajeros(ap);
			conn.commit();
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} finally {
			try {
				daoAP.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void updateAerolineaPasajero (AerolineaPasajeros ap) throws Exception {
		DAOTablaAerolineaPasajeros daoAP = new DAOTablaAerolineaPasajeros();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoAP.setConn(conn);
			daoAP.updateAerolineaPasajeros(ap);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoAP.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void deleteAerolineaPasajero (AerolineaPasajeros ap) throws Exception {
		DAOTablaAerolineaPasajeros daoAP = new DAOTablaAerolineaPasajeros();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoAP.setConn(conn);
			daoAP.deleteAerolineaPasajeros(ap);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoAP.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public ListaAeronavePasajero darAeronavesPasajero() throws Exception {
		ArrayList<AeronavePasajero> aeronaves;
		DAOTablaAeronavePasajero daoAP = new DAOTablaAeronavePasajero();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoAP.setConn(conn);
			aeronaves = daoAP.darAeronavesPasajero();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoAP.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaAeronavePasajero(aeronaves);
	}
	
	public void addAeronavePasajero (AeronavePasajero ap) throws Exception {
		DAOTablaAeronavePasajero daoAP = new DAOTablaAeronavePasajero();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoAP.setConn(conn);
			daoAP.addAeronavePasajero(ap);
			conn.commit();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoAP.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void addAeronavesPasajero (ListaAeronavePasajero aeronaves) throws Exception {
		DAOTablaAeronavePasajero daoAP = new DAOTablaAeronavePasajero();
		try 
		{
			//////Transacción - ACID Example
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoAP.setConn(conn);
			for(AeronavePasajero ap : aeronaves.getAeronavesPasajero())
				daoAP.addAeronavePasajero(ap);
			conn.commit();
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} finally {
			try {
				daoAP.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void updateAeronavePasajero (AeronavePasajero ap) throws Exception {
		DAOTablaAeronavePasajero daoAP = new DAOTablaAeronavePasajero();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoAP.setConn(conn);
			daoAP.updateAeronavePasajero(ap);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoAP.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void deleteAeronavePasajero (AeronavePasajero ap) throws Exception {
		DAOTablaAeronavePasajero daoAP = new DAOTablaAeronavePasajero();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoAP.setConn(conn);
			daoAP.deleteAeronavePasajero(ap);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoAP.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public ListaAeropuerto darAeropuertos() throws Exception {
		ArrayList<Aeropuerto> aeropuertos;
		DAOTablaAeropuerto daoAeropuerto = new DAOTablaAeropuerto();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoAeropuerto.setConn(conn);
			aeropuertos = daoAeropuerto.darAeropuertos();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoAeropuerto.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaAeropuerto(aeropuertos);
	}
	
	public void addAeropuerto (Aeropuerto aeropuerto) throws Exception {
		DAOTablaAeropuerto daoAeropuerto = new DAOTablaAeropuerto();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoAeropuerto.setConn(conn);
			daoAeropuerto.addAeropuerto(aeropuerto);
			conn.commit();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoAeropuerto.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void addAeropuerto (ListaAeropuerto aeropuertos) throws Exception {
		DAOTablaAeropuerto daoAeropuerto = new DAOTablaAeropuerto();
		try 
		{
			//////Transacción - ACID Example
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoAeropuerto.setConn(conn);
			for(Aeropuerto aeropuerto : aeropuertos.getAeropuertos())
				daoAeropuerto.addAeropuerto(aeropuerto);
			conn.commit();
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} finally {
			try {
				daoAeropuerto.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void updateAeropuerto(Aeropuerto aeropuerto) throws Exception {
		DAOTablaAeropuerto daoAeropuerto = new DAOTablaAeropuerto();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoAeropuerto.setConn(conn);
			daoAeropuerto.updateAeropuerto(aeropuerto);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoAeropuerto.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void deleteAeropuerto (Aeropuerto aeropuerto) throws Exception {
		DAOTablaAeropuerto daoAeropuerto = new DAOTablaAeropuerto();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoAeropuerto.setConn(conn);
			daoAeropuerto.deleteAeropuerto(aeropuerto);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoAeropuerto.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public ListaAeronaveCarga darAeronavesCarga() throws Exception {
		ArrayList<AeronaveCarga> aeronaves;
		DAOTablaAeronaveCarga daoAC = new DAOTablaAeronaveCarga();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoAC.setConn(conn);
			aeronaves = daoAC.darAeronavesCarga();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoAC.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaAeronaveCarga(aeronaves);
	}
	
	public void addAeronaveCarga (AeronaveCarga ac) throws Exception {
		DAOTablaAeronaveCarga daoAC = new DAOTablaAeronaveCarga();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoAC.setConn(conn);
			daoAC.addAeronaveCarga(ac);
			conn.commit();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoAC.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void addAeronavesCarga (ListaAeronaveCarga aeronaves) throws Exception {
		DAOTablaAeronaveCarga daoAC = new DAOTablaAeronaveCarga();
		try 
		{
			//////Transacción - ACID Example
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoAC.setConn(conn);
			for(AeronaveCarga ac : aeronaves.getAeronavesCarga())
				daoAC.addAeronaveCarga(ac);
			conn.commit();
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} finally {
			try {
				daoAC.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void updateAeronaveCarga (AeronaveCarga ac) throws Exception {
		DAOTablaAeronaveCarga daoAC = new DAOTablaAeronaveCarga();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoAC.setConn(conn);
			daoAC.updateAeronaveCarga(ac);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoAC.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void deleteAeronaveCarga (AeronaveCarga ac) throws Exception {
		DAOTablaAeronaveCarga daoAC = new DAOTablaAeronaveCarga();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoAC.setConn(conn);
			daoAC.deleteAeronaveCarga(ac);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoAC.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public ListaClienteCarga darClienteCarga() throws Exception {
		ArrayList<ClienteCarga> clientes;
		DAOTablaClienteCarga daoCC = new DAOTablaClienteCarga();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoCC.setConn(conn);
			clientes = daoCC.darClientesCarga();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoCC.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaClienteCarga(clientes);
	}
	
	public void addClienteCarga (ClienteCarga cc) throws Exception {
		DAOTablaClienteCarga daoCC = new DAOTablaClienteCarga();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoCC.setConn(conn);
			daoCC.addClienteCarga(cc);
			conn.commit();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoCC.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void addClientesCarga (ListaClienteCarga clientes) throws Exception {
		DAOTablaClienteCarga daoCC = new DAOTablaClienteCarga();
		try 
		{
			//////Transacción - ACID Example
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoCC.setConn(conn);
			for(ClienteCarga cc : clientes.getClientesCarga())
				daoCC.addClienteCarga(cc);
			conn.commit();
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} finally {
			try {
				daoCC.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void updateClienteCarga (ClienteCarga cc) throws Exception {
		DAOTablaClienteCarga daoCC = new DAOTablaClienteCarga();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoCC.setConn(conn);
			daoCC.updateClienteCarga(cc);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoCC.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void deleteClienteCarga (ClienteCarga cc) throws Exception {
		DAOTablaClienteCarga daoCC = new DAOTablaClienteCarga();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoCC.setConn(conn);
			daoCC.deleteClienteCarga(cc);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoCC.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public ListaClienteViajero darClienteViajero() throws Exception {
		ArrayList<ClienteViajero> clientes;
		DAOTablaClienteViajero daoCV = new DAOTablaClienteViajero();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoCV.setConn(conn);
			clientes = daoCV.darClientesViajeros();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoCV.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaClienteViajero(clientes);
	}
	
	public void addClienteViajero (ClienteViajero cv) throws Exception {
		DAOTablaClienteViajero daoCV = new DAOTablaClienteViajero();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoCV.setConn(conn);
			daoCV.addClienteViajero(cv);
			conn.commit();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoCV.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void addClientesViajero (ListaClienteViajero clientes) throws Exception {
		DAOTablaClienteViajero daoCV = new DAOTablaClienteViajero();
		try 
		{
			//////Transacción - ACID Example
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoCV.setConn(conn);
			for(ClienteViajero cv : clientes.getClienteViajero())
				daoCV.addClienteViajero(cv);
			conn.commit();
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} finally {
			try {
				daoCV.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void updateClienteViajero (ClienteViajero cv) throws Exception {
		DAOTablaClienteViajero daoCV = new DAOTablaClienteViajero();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoCV.setConn(conn);
			daoCV.updateClienteViajero(cv);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoCV.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void deleteClienteViajero (ClienteViajero cv) throws Exception {
		DAOTablaClienteViajero daoCV = new DAOTablaClienteViajero();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoCV.setConn(conn);
			daoCV.deleteClienteViajero(cv);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoCV.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public ListaFuncionarioAeropuerto darFuncionariosAeropuerto() throws Exception {
		ArrayList<FuncionarioAeropuerto> funcionarios;
		DAOTablaFuncionarioAeropuerto daoFA = new DAOTablaFuncionarioAeropuerto();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoFA.setConn(conn);
			funcionarios = daoFA.darFuncionariosAeropuerto();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoFA.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaFuncionarioAeropuerto(funcionarios);
	}
	
	public void addFuncionarioAeropuerto (FuncionarioAeropuerto fa) throws Exception {
		DAOTablaFuncionarioAeropuerto daoFA = new DAOTablaFuncionarioAeropuerto();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoFA.setConn(conn);
			daoFA.addFuncionarioAeropuerto(fa);
			conn.commit();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoFA.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void addFuncionariosAeropuerto (ListaFuncionarioAeropuerto funcionarios) throws Exception {
		DAOTablaFuncionarioAeropuerto daoFA = new DAOTablaFuncionarioAeropuerto();
		try 
		{
			//////Transacción - ACID Example
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoFA.setConn(conn);
			for(FuncionarioAeropuerto fa : funcionarios.getFuncionariosAeropuerto())
				daoFA.addFuncionarioAeropuerto(fa);
			conn.commit();
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} finally {
			try {
				daoFA.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void updateFuncionarioAeropuerto (FuncionarioAeropuerto fa) throws Exception {
		DAOTablaFuncionarioAeropuerto daoFA = new DAOTablaFuncionarioAeropuerto();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoFA.setConn(conn);
			daoFA.updateFuncionarioAeropuerto(fa);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoFA.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void deleteFuncionarioAeropuerto (FuncionarioAeropuerto fa) throws Exception {
		DAOTablaFuncionarioAeropuerto daoFA = new DAOTablaFuncionarioAeropuerto();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoFA.setConn(conn);
			daoFA.deleteFuncionarioAeropuerto(fa);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoFA.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public ListaFuncionarioAerolineaCarga darFuncionariosAerolineaCarga() throws Exception {
		ArrayList<FuncionarioAerolineaCarga> funcionarios;
		DAOTablaFuncionarioAerolineaCarga daoFAC = new DAOTablaFuncionarioAerolineaCarga();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoFAC.setConn(conn);
			funcionarios = daoFAC.darFuncionariosAerolineasCarga();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoFAC.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaFuncionarioAerolineaCarga(funcionarios);
	}
	
	public void addFuncionarioAerolineaCarga (FuncionarioAerolineaCarga fac) throws Exception {
		DAOTablaFuncionarioAerolineaCarga daoFAC = new DAOTablaFuncionarioAerolineaCarga();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoFAC.setConn(conn);
			daoFAC.addFuncionarioAerolineaCarga(fac);
			conn.commit();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoFAC.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void addFuncionariosAerolineaCarga (ListaFuncionarioAerolineaCarga funcionarios) throws Exception {
		DAOTablaFuncionarioAerolineaCarga daoFAC = new DAOTablaFuncionarioAerolineaCarga();
		try 
		{
			//////Transacción - ACID Example
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoFAC.setConn(conn);
			for(FuncionarioAerolineaCarga fac : funcionarios.getFuncionarioAerolineaCarga())
				daoFAC.addFuncionarioAerolineaCarga(fac);
			conn.commit();
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} finally {
			try {
				daoFAC.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void updateFuncionarioAerolineaCarga (FuncionarioAerolineaCarga fac) throws Exception {
		DAOTablaFuncionarioAerolineaCarga daoFAC = new DAOTablaFuncionarioAerolineaCarga();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoFAC.setConn(conn);
			daoFAC.updateFuncionarioAerolineaCarga(fac);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoFAC.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void deleteFuncionarioAerolineaCarga (FuncionarioAerolineaCarga fa ) throws Exception {
		DAOTablaFuncionarioAerolineaCarga daoFAC = new DAOTablaFuncionarioAerolineaCarga();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoFAC.setConn(conn);
			daoFAC.deleteFuncionarioAerolineaCarga(fa);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoFAC.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public ListaFuncionarioAerolineaPasajero darFuncionariosAerolineaPasajero() throws Exception {
		ArrayList<FuncionarioAerolineaPasajero> funcionarios;
		DAOTablaFuncionarioAerolineaPasajero daoFAP = new DAOTablaFuncionarioAerolineaPasajero();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoFAP.setConn(conn);
			funcionarios = daoFAP.darFuncionariosAerolineasPasajero();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoFAP.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaFuncionarioAerolineaPasajero(funcionarios);
	}
	
	public void addFuncionarioAerolineaPasajero (FuncionarioAerolineaPasajero fap) throws Exception {
		DAOTablaFuncionarioAerolineaPasajero daoFAP = new DAOTablaFuncionarioAerolineaPasajero();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoFAP.setConn(conn);
			daoFAP.addFuncionarioAerolineaPasajero(fap);
			conn.commit();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoFAP.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void addFuncionariosAerolineaPasajero (ListaFuncionarioAerolineaPasajero funcionarios) throws Exception {
		DAOTablaFuncionarioAerolineaPasajero daoFAP = new DAOTablaFuncionarioAerolineaPasajero();
		try 
		{
			//////Transacción - ACID Example
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoFAP.setConn(conn);
			for(FuncionarioAerolineaPasajero fap : funcionarios.getFuncionarioAerolineaPasajero())
				daoFAP.addFuncionarioAerolineaPasajero(fap);
			conn.commit();
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} finally {
			try {
				daoFAP.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void updateFuncionarioAerolineaPasajero (FuncionarioAerolineaPasajero fap) throws Exception {
		DAOTablaFuncionarioAerolineaPasajero daoFAP = new DAOTablaFuncionarioAerolineaPasajero();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoFAP.setConn(conn);
			daoFAP.updateFuncionarioAerolineaPasajero(fap);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoFAP.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void deleteFuncionarioAerolineaPasajero (FuncionarioAerolineaPasajero fap) throws Exception {
		DAOTablaFuncionarioAerolineaPasajero daoFAP = new DAOTablaFuncionarioAerolineaPasajero();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoFAP.setConn(conn);
			daoFAP.deleteFuncionarioAerolineaPasajero(fap);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoFAP.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public ListaVueloCarga darVuelosCarga() throws Exception {
		ArrayList<VueloCarga> vuelos;
		DAOTablaVueloCarga daoVC = new DAOTablaVueloCarga();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoVC.setConn(conn);
			vuelos = daoVC.darVuelosCarga();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoVC.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaVueloCarga(vuelos);
	}
	
	public void addVueloCarga (VueloCarga vc) throws Exception {
		DAOTablaVueloCarga daoVC = new DAOTablaVueloCarga();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoVC.setConn(conn);
			daoVC.addVueloCarga(vc);
			conn.commit();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoVC.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void addVuelosCarga (ListaVueloCarga vuelos) throws Exception {
		DAOTablaVueloCarga daoVC = new DAOTablaVueloCarga();
		try 
		{
			//////Transacción - ACID Example
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoVC.setConn(conn);
			for(VueloCarga vc : vuelos.getVuelosCarga())
				daoVC.addVueloCarga(vc);
			conn.commit();
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} finally {
			try {
				daoVC.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void updateVueloCarga (VueloCarga vc) throws Exception {
		DAOTablaVueloCarga daoVC = new DAOTablaVueloCarga();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoVC.setConn(conn);
			daoVC.updateVueloCarga(vc);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoVC.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void deleteVueloCarga (VueloCarga vc) throws Exception {
		DAOTablaVueloCarga daoVC = new DAOTablaVueloCarga();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoVC.setConn(conn);
			daoVC.deleteVueloCarga(vc);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoVC.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public ListaVueloPasajero darVuelosPasajero() throws Exception {
		ArrayList<VueloPasajero> vuelos;
		DAOTablaVueloPasajero daoVP = new DAOTablaVueloPasajero();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoVP.setConn(conn);
			vuelos = daoVP.darVuelosPasajero();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoVP.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaVueloPasajero(vuelos);
	}
	
	public void addVueloPasajero (VueloPasajero vp) throws Exception {
		DAOTablaVueloPasajero daoVP = new DAOTablaVueloPasajero();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoVP.setConn(conn);
			daoVP.addVueloPasajero(vp);
			conn.commit();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoVP.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void addVuelosPasajero (ListaVueloPasajero vuelos) throws Exception {
		DAOTablaVueloPasajero daoVP = new DAOTablaVueloPasajero();
		try 
		{
			//////Transacción - ACID Example
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoVP.setConn(conn);
			for(VueloPasajero vp : vuelos.getVuelosPasajero())
				daoVP.addVueloPasajero(vp);
			conn.commit();
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} finally {
			try {
				daoVP.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void updateVueloPasajero (VueloPasajero vp) throws Exception {
		DAOTablaVueloPasajero daoVP = new DAOTablaVueloPasajero();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoVP.setConn(conn);
			daoVP.updateVueloPasajero(vp);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoVP.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void deleteVueloPasajero (VueloPasajero vp) throws Exception {
		DAOTablaVueloPasajero daoVP = new DAOTablaVueloPasajero();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoVP.setConn(conn);
			daoVP.deleteVueloPasajero(vp);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoVP.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public ListaViajesRealizadosCarga darViajesRealizadosCarga() throws Exception {
		ArrayList<ViajesRealizadosCarga> viajes;
		DAOTablaViajesRealizadosCarga daoVRC = new DAOTablaViajesRealizadosCarga();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoVRC.setConn(conn);
			viajes = daoVRC.darViajesRealizadosCarga();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoVRC.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaViajesRealizadosCarga(viajes);
	}
	
	public void addViajeRealizadoCarga (ViajesRealizadosCarga vrc) throws Exception {
		DAOTablaViajesRealizadosCarga daoVRC = new DAOTablaViajesRealizadosCarga();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoVRC.setConn(conn);
			daoVRC.addViajesRealizadosCarga(vrc);
			conn.commit();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoVRC.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void addViajesRealizadosCarga (ListaViajesRealizadosCarga viajes) throws Exception {
		DAOTablaViajesRealizadosCarga daoVRC = new DAOTablaViajesRealizadosCarga();
		try 
		{
			//////Transacción - ACID Example
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoVRC.setConn(conn);
			for(ViajesRealizadosCarga vcr : viajes.getviajesRealizadosCarga())
				daoVRC.addViajesRealizadosCarga(vcr);
			conn.commit();
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} finally {
			try {
				daoVRC.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	
	public void deleteViajeRealizadosCarga (ViajesRealizadosCarga vcr) throws Exception {
		DAOTablaViajesRealizadosCarga daoVCR = new DAOTablaViajesRealizadosCarga();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoVCR.setConn(conn);
			daoVCR.deleteViajesRealizadosCarga(vcr);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoVCR.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public ListaViajesRealizadosPasajero darViajesRealizadosPasajero() throws Exception {
		ArrayList<ViajesRealizadosPasajero> viajes;
		DAOTablaViajesRealizadosPasajero daoVRP = new DAOTablaViajesRealizadosPasajero();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoVRP.setConn(conn);
			viajes = daoVRP.darViajesRealizadosPasajero();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoVRP.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaViajesRealizadosPasajero(viajes);
	}
	
	public void addViajeRealizadoPasajero (ViajesRealizadosPasajero vrc) throws Exception {
		DAOTablaViajesRealizadosPasajero daoVRP = new DAOTablaViajesRealizadosPasajero();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoVRP.setConn(conn);
			daoVRP.addViajesRealizadosPasajero(vrc);
			conn.commit();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoVRP.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void addViajesRealizadosPasajero (ListaViajesRealizadosPasajero viajes) throws Exception {
		DAOTablaViajesRealizadosPasajero daoVRP = new DAOTablaViajesRealizadosPasajero();
		try 
		{
			//////Transacción - ACID Example
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoVRP.setConn(conn);
			for(ViajesRealizadosPasajero vrp : viajes.getviajesRealizadosPasajero())
				daoVRP.addViajesRealizadosPasajero(vrp);
			conn.commit();
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} finally {
			try {
				daoVRP.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	
	public void deleteViajeRealizadosPasajero (ViajesRealizadosPasajero vrp) throws Exception {
		DAOTablaViajesRealizadosPasajero daoVRP = new DAOTablaViajesRealizadosPasajero();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoVRP.setConn(conn);
			daoVRP.deleteViajesRealizadosPasajero(vrp);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoVRP.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public ListaNacionalidadCliente darNacionalidadCliente() throws Exception {
		ArrayList<NacionalidadCliente> nacionalidades;
		DAOTablaNacionalidadCliente daoNC = new DAOTablaNacionalidadCliente();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoNC.setConn(conn);
			nacionalidades = daoNC.darNacionalidadCliente();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoNC.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaNacionalidadCliente(nacionalidades);
	}
	
	public void addNacionalidadCliente (NacionalidadCliente nc) throws Exception {
		DAOTablaNacionalidadCliente daoNC = new DAOTablaNacionalidadCliente();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoNC.setConn(conn);
			daoNC.addNacionalidadCliente(nc);
			conn.commit();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoNC.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void addNacionalidadesClientes (ListaNacionalidadCliente nacionalidades) throws Exception {
		DAOTablaNacionalidadCliente daoNC = new DAOTablaNacionalidadCliente();
		try 
		{
			//////Transacción - ACID Example
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoNC.setConn(conn);
			for(NacionalidadCliente nc : nacionalidades.getnacionalidadCliente())
				daoNC.addNacionalidadCliente(nc);
			conn.commit();
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} finally {
			try {
				daoNC.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void deleteNacionalidadCliente (NacionalidadCliente nc) throws Exception {
		DAOTablaNacionalidadCliente daoNC = new DAOTablaNacionalidadCliente();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoNC.setConn(conn);
			daoNC.deleteNacionalidadCliente(nc);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoNC.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public ListaReservaCarga darReservasCarga() throws Exception {
		ArrayList<ReservaCarga> reservas;
		DAOTablaReservaCarga daoRC = new DAOTablaReservaCarga();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoRC.setConn(conn);
			reservas = daoRC.darReservaCarga();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoRC.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaReservaCarga(reservas);
	}
	
	public void addReservaCarga (ReservaCarga rc) throws Exception {
		DAOTablaReservaCarga daoRC = new DAOTablaReservaCarga();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoRC.setConn(conn);
			daoRC.addReservaCarga(rc);
			conn.commit();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoRC.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void addReservasCarga (ListaReservaCarga reservas) throws Exception {
		DAOTablaReservaCarga daoRC = new DAOTablaReservaCarga();
		try 
		{
			//////Transacción - ACID Example
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoRC.setConn(conn);
			for(ReservaCarga rc : reservas.getreservaCarga())
				daoRC.addReservaCarga(rc);
			conn.commit();
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} finally {
			try {
				daoRC.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void updateReservaCarga (ReservaCarga rc) throws Exception {
		DAOTablaReservaCarga daoRC = new DAOTablaReservaCarga();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoRC.setConn(conn);
			daoRC.updateReservaCarga(rc);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoRC.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void deleteReservaCarga (ReservaCarga rc) throws Exception {
		DAOTablaReservaCarga daoRC = new DAOTablaReservaCarga();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoRC.setConn(conn);
			daoRC.deleteReservaCarga(rc);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoRC.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public ListaReservaViaje darReservasViaje() throws Exception {
		ArrayList<ReservaViaje> reservas;
		DAOTablaReservaViaje daoRV = new DAOTablaReservaViaje();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoRV.setConn(conn);
			reservas = daoRV.darReservasViaje();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoRV.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaReservaViaje(reservas);
	}
	
	public void addReservaViaje (ReservaViaje rv) throws Exception {
		DAOTablaReservaViaje daoRV = new DAOTablaReservaViaje();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoRV.setConn(conn);
			daoRV.addReservaViaje(rv);
			conn.commit();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoRV.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void addReservasViaje (ListaReservaViaje reservas) throws Exception {
		DAOTablaReservaViaje daoRV = new DAOTablaReservaViaje();
		try 
		{
			//////Transacción - ACID Example
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoRV.setConn(conn);
			for(ReservaViaje rv : reservas.getreservaViaje())
				daoRV.addReservaViaje(rv);
			conn.commit();
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} finally {
			try {
				daoRV.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void updateReservaViaje (ReservaViaje rv) throws Exception {
		DAOTablaReservaViaje daoRV = new DAOTablaReservaViaje();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoRV.setConn(conn);
			daoRV.updateReservaViaje(rv);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoRV.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void deleteReservaViaje (ReservaViaje rv) throws Exception {
		DAOTablaReservaViaje daoRV = new DAOTablaReservaViaje();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoRV.setConn(conn);
			daoRV.deleteReservaViaje(rv);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoRV.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
}