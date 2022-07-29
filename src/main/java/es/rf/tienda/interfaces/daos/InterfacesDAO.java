package es.rf.tienda.interfaces.daos;

import java.util.List;

public interface InterfacesDAO<T> {

	List<T> listarTodo() throws Exception;

	boolean crear(T t) throws Exception;

	boolean editar(T t) throws Exception;

	boolean eliminar(int id) throws Exception;

	List<T> buscar(T t) throws Exception;
}
