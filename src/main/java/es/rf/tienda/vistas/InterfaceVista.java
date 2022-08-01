package es.rf.tienda.vistas;

import javax.swing.JFrame;

public interface InterfaceVista {

	void agregarEventoCierre();

	void iniciarVista();

	void setVistaAnterior(JFrame vista);
}
