package es.rf.tienda.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {

	private static Connection conn;
	private static JDBC instancia;
	
	// DEBERIA ESTAR EN UN ARCHIVO XML???
	private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USUARIO = "alumno";
	private static final String PASSWORD = "Curso2022";

	public static JDBC getInstance() throws Exception {
		if (instancia == null) {
			instancia = new JDBC();
		}
		return instancia;

	}

	private JDBC() throws Exception {

		this.conexion();

	}

	private void conexion() throws Exception{
		try {

			Class.forName(JDBC_DRIVER);

			conn = DriverManager.getConnection(URL, USUARIO, PASSWORD);

		} catch (Exception e) {
			throw (new Exception("Error! : " + e.getMessage()));
		}
	}

	public int Ejecutar(String sql) throws Exception {

		System.out.println("Ejecutar: " + sql);
		Statement stm = null;
		int retorno;

		try {

			stm = conn.createStatement();
			retorno = stm.executeUpdate(sql);

		} catch (SQLException e) {
			throw (new Exception("error en " + sql));
		} finally {
			// closeStatement(stm);
		}
		return retorno;

	}

	public ResultSet EjecutarQuery(String sql) throws Exception {

		System.out.println("EjecutarQuery: " + sql);
		Statement stm = null;
		ResultSet retorno;

		try {

			stm = conn.createStatement();
			retorno = stm.executeQuery(sql);

		} catch (SQLException e) {
			throw (new Exception("error en " + sql));
		} finally {
			// closeStatement(stm);
		}
		return retorno;

	}

	public void closeConnection() {
		// TODO Auto-generated method stub

	}

}