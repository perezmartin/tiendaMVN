package es.rf.tienda.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Validator {

	private static final String ALFANUMERIC_PATTERN = "^[0-9a-zA-Z]+$";

	private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";

	private final static String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private final static String DNI_PATTERN = "\\d{2}\\.\\d{3}\\.\\d{3}-[TRWAGMYFPDXBNJZSQVHLCKE]";

	private final static String PHONE_PATTERN = "[\\d ]{10,20}";

	private final static int LONGITUD_DNI = 12;

	public static boolean isAlfanumeric(String texto) {
		return !isVacio(texto) && texto.matches(ALFANUMERIC_PATTERN);

	}

	public static boolean isVacio(String prueba) {
		return prueba == null || prueba.equalsIgnoreCase("");

	}

	public static boolean cumplePhoneNumber(String phoneNumber) {
		return !isVacio(phoneNumber) && phoneNumber.matches(PHONE_PATTERN);

	}

	public static boolean isEmailValido(String email) {
		return !isVacio(email) && email.matches(EMAIL_PATTERN);
	}

	public static boolean cumpleDNI(String dni) {
		return !isVacio(dni) && dni.matches(DNI_PATTERN) && cumpleLongitud(dni, LONGITUD_DNI, LONGITUD_DNI);
	}

	public static boolean cumpleRango(int valor, int valorMinimo, int valorMaximo) {
		return (valorMinimo < valor) && (valor < valorMaximo);

	}

	public static boolean cumpleRango(double valor, int valorMinimo, int valorMaximo) {
		return (valorMinimo < valor) && (valor < valorMaximo);

	}

	public static boolean cumpleLongitudMin(String texto, int longitudMinima) {

		return texto.length() >= longitudMinima;

	}

	public static boolean cumpleLongitudMax(String texto, int longitudMaxima) {
		return texto.length() <= longitudMaxima;

	}

	public static boolean cumpleLongitud(String texto, int longitudMinima, int longitudMaxima) {
		return (texto.length() <= longitudMaxima) && (texto.length() >= longitudMinima);

	}

	public static boolean valDateMin(Calendar fecha, Calendar min) {

		if (fecha != null && min != null) {

			return fecha.compareTo(min) >= 0;

		}
		return false;
	}

	public static boolean valDateMax(Calendar fecha, Calendar max) {

		if (fecha != null && max != null) {

			return fecha.compareTo(max) <= 0;

		}
		return false;
	}

	public static boolean esFechaValida(String fecha) {

		if (isVacio(fecha)) {
			return false;
		}

		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		formatoFecha.setLenient(false);

		try {
			formatoFecha.parse(fecha);
			return true;
		} catch (ParseException e) {
			return false;
		}

	}

	public static boolean esPasswordValida(String password) {
		return !isVacio(password) && password.matches(PASSWORD_PATTERN);

	}
}
