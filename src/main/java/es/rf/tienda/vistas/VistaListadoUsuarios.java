package es.rf.tienda.vistas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import es.rf.tienda.dominio.Usuario;

public class VistaListadoUsuarios extends JFrame {
	private static final long serialVersionUID = 1L;

	public VistaListadoUsuarios() {
		super.setTitle("Listado Usuarios");
	}

	public void iniciarVista() {

		initComponents(); // inicio los componentes
		setLocationRelativeTo(null); // centro la VistaSwing a la pantalla
		setVisible(true); // hago visible la VistaSwing
	}

	public void volverALaVistaAnterior(JFrame vista) {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				vista.setVisible(true);
			}
		});
	}

	public void agregarListado(ArrayList<Usuario> users) {
		DefaultListModel<Usuario> lista = new DefaultListModel<Usuario>();
		this.listaUsuarios.setModel(lista);

		for (Usuario usuario : users) {
			lista.addElement(usuario);
		}

	}

	private void initComponents() {

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(400, 300);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		this.botonAgregar.setText("Agregar Nueva Categoria");
		this.botonEliminarSeleccionados.setText("Eliminar Seleccionados");

		this.label.setText("ID || NOMBRE || EMAIL");

		panelTop.add(label);
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelTop.setLayout(new BoxLayout(panelTop, BoxLayout.Y_AXIS));

		panelCentro.add(listaUsuarios);

		panelBot.add(botonAgregar);
		panelBot.add(botonEliminarSeleccionados);

		this.add(panelTop, BorderLayout.NORTH);
		this.add(scrollPanel, BorderLayout.CENTER);
		this.add(panelBot, BorderLayout.SOUTH);

		this.setVisible(true);

	}

	public void clickEnBotonAceptar(ActionListener al) {
		this.botonAgregar.addActionListener(al);
	}

	public void clickEnEliminar(ActionListener al) {
		this.botonEliminarSeleccionados.addActionListener(al);
	}

	public void clickEnListadoUsuarios(MouseListener al) {
		this.listaUsuarios.addMouseListener(al);
	}

	private JPanel panelTop = new JPanel();
	private JPanel panelBot = new JPanel();
	private JPanel panelCentro = new JPanel();

	private JScrollPane scrollPanel = new JScrollPane(panelCentro);

	private JButton botonAgregar = new JButton();
	private JButton botonEliminarSeleccionados = new JButton();

	private JLabel label = new JLabel();

	private JList<Usuario> listaUsuarios = new JList<Usuario>();

}