package es.rf.tienda.interfaces.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.exception.DomainException;
import es.rf.tienda.util.ErrorMessages;
import es.rf.tienda.util.JDBC;
import es.rf.tienda.util.Validator;

public class CategoriaDAO implements InterfacesDAO<Categoria> {

	private final String SELECT_ALL = "SELECT * FROM CATEGORIA";
	private final String SELECT_CATEGORIAS = "SELECT * FROM CATEGORIA WHERE ";
	private final String INSERT_CATEGORIA = "INSERT INTO CATEGORIA VALUES ";
	private final String UPDATE_CATEGORIA = "UPDATE CATEGORIA SET ";
	private final String DELETE_CATEGORIA = "DELETE FROM CATEGORIA WHERE ID_CATEGORIA = ";

	@Override
	public List<Categoria> listarTodo() throws DAOException {
		return generarListadoCategorias(this.SELECT_ALL);
	}

	@Override
	public boolean crear(Categoria c) throws Exception {
		String query = this.INSERT_CATEGORIA;

		try {

			if (c != null && c.isValid()) {
				query = query + "(" + c.getId_categoria() + ",'" + c.getCat_nombre() + "','" + c.getCat_descripcion()
						+ "')";

				int num = JDBC.getInstance().Ejecutar(query);

				if (num != 0)
					return true;
			}
		} catch (SQLException e) {
			throw (e);
		} catch (DomainException e) {
			throw (e);
		} catch (Exception e) {
			throw (new DAOException(ErrorMessages.DAOERR_002));
		}
		return false;

	}

	@Override
	public boolean editar(Categoria c) throws DAOException, DomainException {
		String query = this.UPDATE_CATEGORIA;
		try {
			if (c != null && c.isValid()) {
				query = query + "CAT_NOMBRE = '" + c.getCat_nombre() + "', CAT_DESCRIPCION = '" + c.getCat_descripcion()
						+ "' WHERE ID_CATEGORIA = " + c.getId_categoria();

				int num = JDBC.getInstance().Ejecutar(query);

				if (num != 0)
					return true;
			}
		} catch (DomainException e) {
			throw (e);

		} catch (Exception e) {
			throw (new DAOException(ErrorMessages.DAOERR_003));
		}
		return false;
	}

	@Override
	public boolean eliminar(int id) throws DAOException, DomainException {
		String query = this.DELETE_CATEGORIA;
		try {
			if (id != 0) {
				query = query + id;

				int num = JDBC.getInstance().Ejecutar(query);

				if (num != 0)
					return true;
			}
		} catch (DomainException e) {
			throw (e);

		} catch (Exception e) {
			throw (new DAOException(ErrorMessages.DAOERR_004));
		}
		return false;
	}

	@Override
	public List<Categoria> buscar(Categoria c) throws DAOException {

		String query = this.SELECT_CATEGORIAS;

		if (c.getId_categoria() > 0) {
			query = query + "ID_CATEGORIA = " + c.getId_categoria();
		} else if (!Validator.isVacio(c.getCat_nombre())) {
			query = query + "CAT_NOMBRE = '" + c.getCat_nombre() + "'";
		} else if (!Validator.isVacio(c.getCat_descripcion())) {
			query = query + "CAT_DESCRIPCION = '" + c.getCat_descripcion() + "'";
		} else {
			throw (new DAOException(ErrorMessages.DAOERR_005));
		}
		return generarListadoCategorias(query);
	}

	private List<Categoria> generarListadoCategorias(String query) throws DAOException {
		List<Categoria> lista = new ArrayList<Categoria>();

		try {
			ResultSet rs = JDBC.getInstance().EjecutarQuery(query);
			while (rs.next()) {

				Categoria c = new Categoria(rs.getInt(1), rs.getString(2), rs.getString(3));
				lista.add(c);

			}
		} catch (Exception e) {
			throw (new DAOException(ErrorMessages.DAOERR_001));
		}

		return lista;

	}
}
