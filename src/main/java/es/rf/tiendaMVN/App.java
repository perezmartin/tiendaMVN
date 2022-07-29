package es.rf.tiendaMVN;

import es.rf.tienda.controladores.ControladorPrincipal;
import es.rf.tienda.vistas.VistaPrincipal;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	VistaPrincipal v = new VistaPrincipal();
		ControladorPrincipal c = new ControladorPrincipal(v);
		c.iniciar();
    }
}
