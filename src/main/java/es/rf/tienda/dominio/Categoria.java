package es.rf.tienda.dominio;

import es.rf.tienda.exception.DomainException;
import es.rf.tienda.util.ErrorMessages;
import es.rf.tienda.util.Validator;

public class Categoria {

	private int id_categoria;
	private String cat_nombre;
	private String cat_descripcion;

	private final int LONGITUD_MAX_CAT_NOMBRE = 50;
	private final int LONGITUD_MIN_CAT_NOMBRE = 3;
	private final int LONGITUD_MAX_CAT_DESCRIPCION = 200;
	private final int LONGITUD_MIN_CAT_DESCRIPCION = 3;

	public Categoria() {

	}

	public Categoria(int id, String nombre, String descripcion) {
		this.setId_categoria(id);
		this.setCat_nombre(nombre);
		this.setCat_descripcion(descripcion);

	}

	public boolean isValid() throws DomainException {
		if (Validator.isVacio(cat_nombre) && id_categoria < 0 && Validator.isVacio(cat_descripcion)) {
			throw new DomainException(ErrorMessages.CATERR_001);
		}
		if (!Validator.cumpleLongitud(cat_nombre, LONGITUD_MIN_CAT_NOMBRE, LONGITUD_MAX_CAT_NOMBRE)) {
			throw new DomainException(ErrorMessages.CATERR_002);
		}
		if (!Validator.isAlfanumeric(cat_nombre)) {
			throw new DomainException(ErrorMessages.CATERR_003);
		}
		if (!Validator.cumpleLongitud(cat_descripcion, LONGITUD_MIN_CAT_DESCRIPCION, LONGITUD_MAX_CAT_DESCRIPCION)) {
			throw new DomainException(ErrorMessages.CATERR_004);
		}
		if (!Validator.isAlfanumeric(cat_nombre)) {
			throw new DomainException(ErrorMessages.CATERR_005);
		}
		return true;
	}

	public int getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}

	public String getCat_nombre() {
		return cat_nombre;
	}

	public void setCat_nombre(String cat_nombre) {
		this.cat_nombre = cat_nombre;
	}

	public String getCat_descripcion() {
		return cat_descripcion;
	}

	public void setCat_descripcion(String cat_descripcion) {
		this.cat_descripcion = cat_descripcion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cat_descripcion == null) ? 0 : cat_descripcion.hashCode());
		result = prime * result + ((cat_nombre == null) ? 0 : cat_nombre.hashCode());
		result = prime * result + id_categoria;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (cat_descripcion == null) {
			if (other.cat_descripcion != null)
				return false;
		} else if (!cat_descripcion.equals(other.cat_descripcion))
			return false;
		if (cat_nombre == null) {
			if (other.cat_nombre != null)
				return false;
		} else if (!cat_nombre.equals(other.cat_nombre))
			return false;
		if (id_categoria != other.id_categoria)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return id_categoria + " || " + cat_nombre;
	}

}
