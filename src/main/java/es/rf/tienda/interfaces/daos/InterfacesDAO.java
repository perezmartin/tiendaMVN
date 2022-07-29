package es.rf.tienda.interfaces.daos;

import java.util.List;

public interface InterfacesDAO<T> {

	List<T> listarTodo();

	boolean crear(T t);

	boolean editar(int id, T t);

	boolean eliminar(int id);

	List<T> buscar(T t);
}
