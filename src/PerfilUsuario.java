import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JRadioButton;
/**
 * PerfilUsuario es una ventana de la GUI que permite ver la información que identifica a un usuario y su ganaderia. Además permite editar los datos y guardar la actualización en 
 * el modelo de persistencia
 * @file Registros.java
 * @author José Guillermo Quiñónez Castillo (qui17775@uvg.edu.gt)
 * @author Carlo Humberto Chew (che17507@uvg.edu.gt)
 * @date 14.11.2017
 */
public class PerfilUsuario extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNombre;
	private JTextField tfUsuario;
	private JTextField tfPassword;
	private JTextField tfDireccion;
	private JTextField tfNombreGanaderia;
	private JTextField tfDireccionGanaderia;
	private JFormattedTextField tfMovil;
	private JFormattedTextField tfTelefono;
	private JButton btnGuardarCambios;
	private ControlGanaderia controlador; 
	private JRadioButton rdbtnEditar;
	private static Usuario usuario; 
	private JLabel lblNmeroDeAnimales;
	private JTextField tfAnimales;
	private JLabel lblNewLabel_2;
	private JButton btnRegresar;

	/**
	 * @return the usuario
	 */
	public static Usuario getUsuario() {
		return usuario;
	}//Cierre del método

	/**
	 * @param usuario the usuario to set
	 */
	public static void setUsuario(Usuario usuario) {
		PerfilUsuario.usuario = usuario;
	}//Cierre del método

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PerfilUsuario frame = new PerfilUsuario();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}//Cierre del método

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public PerfilUsuario() throws ParseException {
		controlador = new ControlGanaderia();
		controlador.Conectar();
		setResizable(true);
		setTitle("INFORMACIÓN DEL GANADERO");
		setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono.jpg")).getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 587);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(11, 2, 5, 5));
		
		JLabel lblNombreCompleto = new JLabel("Nombre Completo");
		lblNombreCompleto.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNombreCompleto);
		
		tfNombre = new JTextField();
		tfNombre.setEditable(false);
		tfNombre.setBackground(Color.WHITE);
		tfNombre.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(tfNombre);
		tfNombre.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblUsuario);
		
		tfUsuario = new JTextField();
		tfUsuario.setBackground(Color.WHITE);
		tfUsuario.setEditable(false);
		tfUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblContrasea);
		
		tfPassword = new JTextField();
		tfPassword.setBackground(Color.WHITE);
		tfPassword.setEditable(false);
		tfPassword.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(tfPassword);
		tfPassword.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("M\u00F3vil");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		MaskFormatter mascara = new MaskFormatter("########");
		tfMovil = new JFormattedTextField(mascara);
		tfMovil.setBackground(Color.WHITE);
		tfMovil.setEditable(false);
		tfMovil.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(tfMovil);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n");
		lblDireccin.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblDireccin);
		
		tfDireccion = new JTextField();
		tfDireccion.setBackground(Color.WHITE);
		tfDireccion.setEditable(false);
		tfDireccion.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(tfDireccion);
		tfDireccion.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre de la Ganaderia");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_1);
		
		tfNombreGanaderia = new JTextField();
		tfNombreGanaderia.setBackground(Color.WHITE);
		tfNombreGanaderia.setEditable(false);
		tfNombreGanaderia.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(tfNombreGanaderia);
		tfNombreGanaderia.setColumns(10);
		
		JLabel lblDireccionDeLa = new JLabel("Direccion de la Ganaderia");
		lblDireccionDeLa.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblDireccionDeLa);
		
		tfDireccionGanaderia = new JTextField();
		tfDireccionGanaderia.setBackground(Color.WHITE);
		tfDireccionGanaderia.setEditable(false);
		tfDireccionGanaderia.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(tfDireccionGanaderia);
		tfDireccionGanaderia.setColumns(10);
		
		JLabel lblTelfonoDeLa = new JLabel("Tel\u00E9fono de la Ganader\u00EDa");
		lblTelfonoDeLa.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTelfonoDeLa);		
		tfTelefono = new JFormattedTextField(mascara);
		tfTelefono.setBackground(Color.WHITE);
		tfTelefono.setEditable(false);
		tfTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(tfTelefono);
		
		btnGuardarCambios = new JButton("GUARDAR CAMBIOS");
		btnGuardarCambios.addActionListener(new ListenerPerfilUsuario());
		
		rdbtnEditar = new JRadioButton("Editar");
		rdbtnEditar.addActionListener(new ListenerPerfilUsuario());
		
		lblNmeroDeAnimales = new JLabel("N\u00FAmero de animales");
		contentPane.add(lblNmeroDeAnimales);
		
		tfAnimales = new JTextField();
		tfAnimales.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(tfAnimales);
		tfAnimales.setColumns(10);
		
		lblNewLabel_2 = new JLabel("");
		contentPane.add(lblNewLabel_2);
		contentPane.add(rdbtnEditar);
		
		btnRegresar = new JButton("REGRESAR");
		btnRegresar.addActionListener(new ListenerPerfilUsuario());
		contentPane.add(btnRegresar);
		contentPane.add(btnGuardarCambios);
		
		tfNombre.setText(usuario.getNombre());
		tfUsuario.setText(usuario.getUsuario());
		tfPassword.setText(usuario.getPassword());
		tfMovil.setText(String.valueOf(usuario.getMovil()));
		tfDireccion.setText(usuario.getDireccion());
		tfNombreGanaderia.setText(usuario.getGanaderia());
		tfDireccionGanaderia.setText(usuario.getDireccionGanaderia());
		tfTelefono.setText(String.valueOf(usuario.getTelefono()));
		tfAnimales.setText(String.valueOf(controlador.getGanado().size()));
	}//Cierre del constructor
	/**
	 * ListenerPerfilUsuario es una clase interna que implementa un ActionListener que escucha los eventos de los botones Guardar Cambios y Regresar al sobrescribir el método actionPerformed y el JRaddioButton Editar. Al hacer click en Guardar Cambios verifica que no existan campos de texto en blanco, si esto ocurre llama al método 
	 * que permite guardar los cambios hechos a un usuario y persistir la información, despliega un mensaje de confirmación y regresa al principal. Al hacer clock en Regresar se cierra la ventana y se abre de nuevo el Principal. Al marcar Editar
	 * los campos de texto que muestran la información permiten ser editados
	 */
	public class ListenerPerfilUsuario implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(arg0.getSource() == btnGuardarCambios) {
				if (rdbtnEditar.isSelected() == false){
					JOptionPane.showMessageDialog(null, "Marque la opción de edición", "Información", 1);
				}
				else {
					if(tfNombre.getText().compareTo("") == 0 || tfUsuario.getText().compareTo("") == 0 || tfPassword.getText().compareTo("") == 0 || tfUsuario.getText().compareTo("") == 0|| tfDireccion.getText().compareTo("") == 0|| tfNombreGanaderia.getText().compareTo("") == 0 || tfDireccionGanaderia.getText().compareTo("") == 0 || tfTelefono.getText().compareTo("") == 0) {
						JOptionPane.showMessageDialog(null, "1.1 Ha dejado en blanco uno o más campos", "Campos vacíos", 2);
					}
					else{
						controlador.ActualizarUsuario(usuario, tfNombre.getText(), tfUsuario.getText(), tfPassword.getText(), Long.parseLong(tfMovil.getText()), tfDireccion.getText(), tfNombreGanaderia.getText(), tfDireccionGanaderia.getText(), Long.parseLong(tfTelefono.getText()));
						JOptionPane.showMessageDialog(null, "El registro se ha actualizado", "Hecho", 1);
						setVisible(false);	
					}
				}
			}
			if(arg0.getSource() == btnRegresar) {
				controlador.regresar(PerfilUsuario.this);
			}
			if(arg0.getSource() == rdbtnEditar) {
				tfNombre.setEditable(true);
				tfUsuario.setEditable(true);
				tfPassword.setEditable(true);
				tfMovil.setEditable(true);
				tfDireccion.setEditable(true);
				tfNombreGanaderia.setEditable(true);
				tfDireccionGanaderia.setEditable(true);
				tfTelefono.setEditable(true);
			}
			
		}//Cierre del método

	}//Cierre de la clase interna
	
}//Fin de la clase
