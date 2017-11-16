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
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
/**
 * Registro es una ventana de la GUI que permite ingresar la información requerida para un usuario y guardarla en los registros para crear un nuevo usuario
 * @file Registros.java
 * @author José Guillermo Quiñónez Castillo (qui17775@uvg.edu.gt)
 * @author Carlo Humberto Chew (che17507@uvg.edu.gt)
 * @date 14.11.2017
 */
public class Registro extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNombre;
	private JTextField tfUsuario;
	private JTextField tfDireccion;
	private JTextField tfNombreGanaderia;
	private JTextField tfDireccionGanaderia;
	private JFormattedTextField tfMovil;
	private JFormattedTextField tfTelefono;
	private JButton btnRegistrarme;
	private ControlGanaderia controlador; 
	private JButton btnRegresar;
	private JPasswordField tfPassword;
	private JPasswordField tfPassword2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
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
	public Registro() throws ParseException {
		controlador = new ControlGanaderia();
		controlador.ConectarUsuarios();
		setResizable(true);
		setTitle("LA GANADERIA");
		setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono.jpg")).getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 587);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(205, 133, 63));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(10, 2, 5, 5));
		
		JLabel lblNombreCompleto = new JLabel("Nombre Completo");
		lblNombreCompleto.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNombreCompleto.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNombreCompleto);
		
		tfNombre = new JTextField();
		tfNombre.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		tfNombre.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(tfNombre);
		tfNombre.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblUsuario);
		
		tfUsuario = new JTextField();
		tfUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		tfUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblContrasea);
		
		tfPassword = new JPasswordField();
		tfPassword.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		tfPassword.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(tfPassword);
		
		JLabel lblVerificarContrasea = new JLabel("Verificar Contrase\u00F1a");
		lblVerificarContrasea.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblVerificarContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblVerificarContrasea);
		
		tfPassword2 = new JPasswordField();
		tfPassword2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		tfPassword2.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(tfPassword2);
		
		JLabel lblNewLabel = new JLabel("M\u00F3vil");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		MaskFormatter mascara = new MaskFormatter("########");
		tfMovil = new JFormattedTextField(mascara);
		tfMovil.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		tfMovil.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(tfMovil);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n");
		lblDireccin.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDireccin.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblDireccin);
		
		tfDireccion = new JTextField();
		tfDireccion.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		tfDireccion.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(tfDireccion);
		tfDireccion.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre de la Ganaderia");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_1);
		
		tfNombreGanaderia = new JTextField();
		tfNombreGanaderia.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		tfNombreGanaderia.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(tfNombreGanaderia);
		tfNombreGanaderia.setColumns(10);
		
		JLabel lblDireccionDeLa = new JLabel("Direccion de la Ganaderia");
		lblDireccionDeLa.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDireccionDeLa.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblDireccionDeLa);
		
		tfDireccionGanaderia = new JTextField();
		tfDireccionGanaderia.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		tfDireccionGanaderia.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(tfDireccionGanaderia);
		tfDireccionGanaderia.setColumns(10);
		
		JLabel lblTelfonoDeLa = new JLabel("Tel\u00E9fono de la Ganader\u00EDa");
		lblTelfonoDeLa.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTelfonoDeLa.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTelfonoDeLa);		
		tfTelefono = new JFormattedTextField(mascara);
		tfTelefono.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		tfTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(tfTelefono);
		
		btnRegistrarme = new JButton("REGISTRARME");
		btnRegistrarme.setBackground(SystemColor.control);
		btnRegistrarme.setFont(new Font("Dialog", Font.BOLD, 14));
		btnRegistrarme.addActionListener(new ListenerRegistro());
		
		btnRegresar = new JButton("REGRESAR");
		btnRegresar.setBackground(SystemColor.control);
		btnRegresar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnRegresar.addActionListener(new ListenerRegistro());
		contentPane.add(btnRegresar);
		contentPane.add(btnRegistrarme);
	}//Cierre del constructor
	/**
	 * ListenerRegistro es una clase interna que implementa un ActionListener que escucha los eventos de los botones Registrarme y Regresar al sobrescribir el método actionPerformed. Verifica que no existan campos de texto en blanco, si esto ocurre llama al método 
	 * que permite crear un nuevo usuario y persistir la información, despliega un mensaje de confirmación y regresa a la ventana de ingreso
	 */
	private class ListenerRegistro implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(arg0.getSource() == btnRegistrarme) {
				char[] ArrPassword = tfPassword.getPassword();
				String password = new String(ArrPassword);
				char[] ArrPassword2 = tfPassword2.getPassword();
				String password2 = new String(ArrPassword2);
				if(tfNombre.getText().compareTo("") == 0 || tfUsuario.getText().compareTo("") == 0 || password.compareTo("") == 0 || password2.compareTo("") == 0|| tfUsuario.getText().compareTo("") == 0|| tfDireccion.getText().compareTo("") == 0|| tfNombreGanaderia.getText().compareTo("") == 0 || tfDireccionGanaderia.getText().compareTo("") == 0 || tfTelefono.getText().compareTo("") == 0) {
					JOptionPane.showMessageDialog(null, "1.1 Ha dejado en blanco uno o más campos", "Campos vacíos", 2);
				} 
				else {
					if(password.equals(password2)) {
						String nombre = tfNombre.getText(); 
						String usuario = tfUsuario.getText(); 
						long movil = Long.parseLong(tfMovil.getText());
						String direccion = tfDireccion.getText();  
						String ganaderia = tfNombreGanaderia.getText(); 
						String direccionGanaderia = tfDireccionGanaderia.getText(); 
						long telefono = Long.parseLong(tfTelefono.getText());
						controlador.CrearUsuario(nombre, usuario, password, movil, direccion, ganaderia, direccionGanaderia, telefono);
						JOptionPane.showMessageDialog(null, nombre + " ahora está registrado", "Registrado", 1);
						Login login = new Login(); 
						login.setVisible(true);
						login.setLocationRelativeTo(null);
						setVisible(false);
						
					}
					else {
						JOptionPane.showMessageDialog(null, "No se pudo validar la contraseña", "Error", 0);
						tfPassword.setText("");
						tfPassword2.setText("");
					}
				}
			}
			if(arg0.getSource() == btnRegresar) {
				Login login = null;
				login = new Login(); 
				login.setVisible(true);
				login.setLocationRelativeTo(null);
				setVisible(false);
			}
		}//Cierre del método
		
	}//Cierre de la clase interna

}//Fin de la clase





