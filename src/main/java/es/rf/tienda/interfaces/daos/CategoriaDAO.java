package es.rf.tienda.interfaces.daos;

import java.util.List;

import es.rf.tienda.dominio.Categoria;

public interface CategoriaDAO extends InterfacesDAO<Categoria> {

	List<Categoria> listarTodo() throws Exception;

	boolean crear(Categoria c) throws Exception;

	boolean editar(Categoria c) throws Exception;

	boolean eliminar(int id) throws Exception;

	List<Categoria> buscar(Categoria c) throws Exception;
}
