package es.rf.tienda.util;

/* *****************************************************
 * NOMBRE: ErrorMessages.java
 * 
 * DESCRIPCION:  
 * 			Clase con los String que contienen los mensajes de error 
 * 			especificados por las reglas de negocio.
 * 
 *  @version	Enero 2016
 *  
 *  @author 	Miguel Garcia
 *  
 *  *****************************************************/
public class ErrorMessages {

	/**
	 * Codigo de producto
	 */
	public final static String PROERR_001 = "Formato codigo erroneo";
	public final static String PROERR_002 = "Longitud de codigo erroneo";

	/**
	 * Campo con longitud erronea
	 */
	public final static String PROERR_003 = "La longitud de ? ha de estar entre ? y ?";
	
	public final static String CONNERR_001 = "Error con la Conexion a la base de datos";
	public final static String CONNERR_002 = "Error con la Query de la base de datos";

}
