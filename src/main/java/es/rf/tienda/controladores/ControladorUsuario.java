package es.rf.tienda.controladores;

import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import es.rf.tienda.dominio.Usuario;
import es.rf.tienda.util.ErrorMessages;
import es.rf.tienda.util.JDBC;

public class ControladorUsuario{

	private List<Usuario> generarListadoUsuarios(String query) {
		List<Usuario> lista = new ArrayList<Usuario>();

		try {
			ResultSet rs = JDBC.getInstance().EjecutarQuery(query);
			while (rs.next()) {

				Usuario u = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(9));

				lista.add(u);

			}
		} catch (Exception e) {
			ErrorMessages.mostrarMensajeError(e.getMessage());
			e.printStackTrace();
		}

		return lista;

	}


}
