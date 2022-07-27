package es.rf.tienda.vistas;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class VistaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;

	public void iniciarVista() {
		initComponents(); // inicio los componentes
		setLocationRelativeTo(null); // centro la VistaSwing a la pantalla
		setVisible(true); // hago visible la VistaSwing
	}

	private void initComponents() {

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(400, 300);

		this.setLayout(new GridLayout(5, 2));

		this.botonListadoUsuarios.setText("Usuarios");
		this.botonNuevoUsuario.setText("Usuario");
		this.botonListadoProductos.setText("Productos");
		this.botonNuevoProducto.setText("Producto");
		this.botonListadoCategorias.setText("Categorias");
		this.botonNuevaCategoria.setText("Categoria");
		this.botonListadoDirecciones.setText("Direcciones");
		this.botonNuevaDireccion.setText("Direccion");

		this.listados.setText("Listado de");

		this.listados.setHorizontalAlignment(SwingConstants.CENTER);
		this.nuevos.setText("Nuevo/Nueva");
		this.nuevos.setHorizontalAlignment(SwingConstants.CENTER);

		this.add(listados);
		this.add(nuevos);
		this.add(botonListadoUsuarios);
		this.add(botonNuevoUsuario);
		this.add(botonListadoCategorias);
		this.add(botonNuevaCategoria);
		this.add(botonListadoProductos);
		this.add(botonNuevoProducto);
		this.add(botonListadoDirecciones);
		this.add(botonNuevaDireccion);

	}

	public void clickEnBotonListadoUsuarios(ActionListener al) {
		this.botonListadoUsuarios.addActionListener(al);
	}

	public void clickEnBotonNuevoUsuario(ActionListener al) {
		this.botonNuevoUsuario.addActionListener(al);
	}

	public void clickEnBotonListadoProductos(ActionListener al) {
		this.botonListadoProductos.addActionListener(al);
	}

	public void clickEnBotonNuevoProducto(ActionListener al) {
		this.botonNuevoProducto.addActionListener(al);
	}

	public void clickEnBotonListadoCategorias(ActionListener al) {
		this.botonListadoCategorias.addActionListener(al);
	}

	public void clickEnBotonNuevaCategoria(ActionListener al) {
		this.botonNuevaCategoria.addActionListener(al);
	}

	public void clickEnBotonListadoDirecciones(ActionListener al) {
		this.botonListadoDirecciones.addActionListener(al);
	}

	public void clickEnBotonNuevaDireccion(ActionListener al) {
		this.botonNuevaDireccion.addActionListener(al);
	}

	private JButton botonListadoUsuarios = new JButton();
	private JButton botonNuevoUsuario = new JButton();
	private JButton botonListadoProductos = new JButton();
	private JButton botonNuevoProducto = new JButton();
	private JButton botonListadoCategorias = new JButton();
	private JButton botonNuevaCategoria = new JButton();
	private JButton botonListadoDirecciones = new JButton();
	private JButton botonNuevaDireccion = new JButton();

	private JLabel listados = new JLabel();
	private JLabel nuevos = new JLabel();

}
