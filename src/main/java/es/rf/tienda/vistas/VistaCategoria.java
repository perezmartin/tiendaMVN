package es.rf.tienda.vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.util.ErrorMessages;

public class VistaCategoria extends JFrame implements InterfaceVista {

	private static final long serialVersionUID = 1L;
	private Categoria categoria;
	private JFrame vistaAnterior;

	public void iniciarVista() {
		initComponents();
		setLocationRelativeTo(null);
		setVisible(true);
		agregarEventoCierre();
	}

	private void initComponents() {

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setResizable(false);
		setSize(400, 300);

		if (categoria != null) {

			this.setTitle("Editar Categoria");

			this.botonEditar.setText("Editar");

			this.botonEliminar.setText("Eliminar");
			this.botonEliminar.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
			this.botonEliminar.setForeground(Color.WHITE);
			this.botonEliminar.setBackground(Color.RED);

			this.input_cat_id.setText(categoria.getId_categoria() + "");
			this.input_cat_id.setEditable(false);
			this.input_cat_nombre.setText(categoria.getCat_nombre());
			this.textoDescripcion.setText(categoria.getCat_descripcion());

			this.panelBotones.removeAll();
			this.panelBotones.add(botonEditar);
			this.panelBotones.add(botonEliminar);

		} else {

			this.input_cat_id.setEditable(true);

			this.input_cat_id.setText("");
			this.input_cat_nombre.setText("");
			this.textoDescripcion.setText("");

			this.setTitle("Agregar Categoria");
			this.botonCrear.setText("Agregar");

			this.panelBotones.removeAll();
			this.panelBotones.add(botonCrear);

		}

		this.cat_id.setText("ID");
		this.cat_nombre.setText("NOMBRE");
		this.cat_descripcion.setText("DESCRIPCION");

		this.botonCrear.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		this.botonCrear.setBackground(Color.GREEN);
		
		this.botonEditar.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		this.botonEditar.setBackground(Color.GREEN);

		this.panelElementos.setLayout(gridElementos);

		this.panelElementos.add(cat_id);
		this.panelElementos.add(input_cat_id);
		this.panelElementos.add(cat_nombre);
		this.panelElementos.add(input_cat_nombre);
		this.panelElementos.add(cat_descripcion);
		this.panelElementos.add(input_cat_descripcion);

		this.add(panelElementos, BorderLayout.CENTER);
		this.add(new JPanel(), BorderLayout.WEST);
		this.add(new JPanel(), BorderLayout.EAST);
		this.add(panelBotones, BorderLayout.SOUTH);

	}

	public Categoria getCategoria() throws DAOException {

		Categoria c = new Categoria();

		try {
			c.setId_categoria(Integer.parseInt(input_cat_id.getText()));
			c.setCat_nombre(input_cat_nombre.getText());
			c.setCat_descripcion(textoDescripcion.getText());
		} catch (NumberFormatException e) {
			throw new DAOException(ErrorMessages.DAOERR_006);
		}

		return c;
	}

	public void setCategoria(Categoria c) {
		this.categoria = c;
	}

	public void setCategoria(int id, String nombre, String des) {
		this.categoria = new Categoria(id, nombre, des);
	}

	public void clickEnBotonCrear(ActionListener al) {
		this.botonCrear.addActionListener(al);
	}
	
	public void clickEnBotonEditar(ActionListener al) {
		this.botonEditar.addActionListener(al);
	}

	public void clickEnBotonEliminar(ActionListener al) {
		this.botonEliminar.addActionListener(al);
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

	@Override
	public void setVistaAnterior(JFrame v) {
		this.vistaAnterior = v;
	}

	// declaracion de variables

	private JButton botonCrear = new JButton();
	private JButton botonEditar = new JButton();
	private JButton botonEliminar = new JButton();

	private JLabel cat_id = new JLabel();
	private JLabel cat_nombre = new JLabel();
	private JLabel cat_descripcion = new JLabel();
	private JTextField input_cat_id = new JTextField();
	private JTextField input_cat_nombre = new JTextField();
	private JTextArea textoDescripcion = new JTextArea();

	private JScrollPane input_cat_descripcion = new JScrollPane(textoDescripcion);

	private JPanel panelBotones = new JPanel();
	private JPanel panelElementos = new JPanel();

	private GridLayout gridElementos = new GridLayout(6, 1);
}
