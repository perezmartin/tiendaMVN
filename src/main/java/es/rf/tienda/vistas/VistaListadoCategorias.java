package es.rf.tienda.vistas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import es.rf.tienda.dominio.Categoria;

public class VistaListadoCategorias extends JFrame implements InterfaceVista {
	private static final long serialVersionUID = 1L;

	private JFrame vistaAnterior;

	public VistaListadoCategorias() {
		super.setTitle("Listado Categorias");
	}

	public void iniciarVista() {
		agregarEventoCierre();
		initComponents();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void setVistaAnterior(JFrame vista) {
		this.vistaAnterior = vista;

	}

	@Override
	public void agregarEventoCierre() {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (vistaAnterior != null)
					vistaAnterior.setVisible(true);
			}
		});
	}

	public void agregarListado(List<Categoria> list) {
		DefaultListModel<Categoria> lista = new DefaultListModel<Categoria>();
		this.listaCategorias.setModel(lista);

		for (Categoria categoria : list) {
			lista.addElement(categoria);
		}

	}

	private void initComponents() {

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(400, 300);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		this.botonNueva.setText("Agregar Nueva Categoria");
		this.botonEliminarSeleccionados.setText("Eliminar Seleccionados");

		this.label.setText("ID || NOMBRE");

		panelTop.add(label);
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelTop.setLayout(new BoxLayout(panelTop, BoxLayout.Y_AXIS));

		panelCentro.add(listaCategorias);

		panelBot.add(botonNueva);
		panelBot.add(botonEliminarSeleccionados);

		this.add(panelTop, BorderLayout.NORTH);
		this.add(scrollPanel, BorderLayout.CENTER);
		this.add(panelBot, BorderLayout.SOUTH);

		this.setVisible(true);

	}

	public void clickEnBotonNueva(ActionListener al) {
		this.botonNueva.addActionListener(al);
	}

	public void clickEnEliminar(ActionListener al) {
		this.botonEliminarSeleccionados.addActionListener(al);
	}

	public void clickEnListadoCategorias(MouseListener al) {
		this.listaCategorias.addMouseListener(al);
	}

	public Categoria obtenerSeleccionado() {
		return this.listaCategorias.getSelectedValue();
	}
	public List<Categoria> obtenerSeleccionados() {
		return this.listaCategorias.getSelectedValuesList();
	}

	private JPanel panelTop = new JPanel();
	private JPanel panelBot = new JPanel();
	private JPanel panelCentro = new JPanel();

	private JScrollPane scrollPanel = new JScrollPane(panelCentro);

	private JButton botonNueva = new JButton();
	private JButton botonEliminarSeleccionados = new JButton();

	private JLabel label = new JLabel();

	private JList<Categoria> listaCategorias = new JList<Categoria>();

}