import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.SwingConstants;
/**
 * Esta clase contiene una ventana en donde se pide al usuario la información necesaria para la validación de la cuenta (usuario y contraseña) y poder acceder al menú del programa La Ganaderia. Además
 * contiene un botón que permite ingresar a la venana de registro de usurio 
 * @file Login.java
 * @author José Guillermo Quiñónez Castillo (qui17775@uvg.edu.gt)
 * @author Carlo Humberto Chew (che17507@uvg.edu.gt)
 * @date 14.11.2017
 */
public class Login extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfUsuario;
	private JPasswordField pwContrasena; 
	private ControlGanaderia controlador; 
	private JButton btnRegistrarse;
	private JButton btnIngresar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} //Cierre del método

	/**
	 * Se crea el JFrame con todos los componentes insertados
	 * Constructor de la clase
	 */
	public Login() {
		controlador = new ControlGanaderia(); 
		controlador.ConectarUsuarios();
		setResizable(false);
		setTitle("LA GANADERIA");
		setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono.jpg")).getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		((JPanel)getContentPane()).setOpaque(false);
        ImageIcon uno = new ImageIcon(this.getClass().getResource("/imagenes/fondo.jpg"));
        JLabel fondo = new JLabel();
        fondo.setIcon(uno);
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("USUARIO");
		lblUsuario.setFont(new Font("Georgia", Font.BOLD, 16));
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setBounds(63, 84, 140, 40);
		contentPane.add(lblUsuario);
		
		tfUsuario = new JTextField();
		tfUsuario.setFont(new Font("Georgia", Font.PLAIN, 14));
		tfUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		tfUsuario.setBounds(251, 89, 175, 30);
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		JLabel lblCotrasena = new JLabel("CONTRASE\u00D1A");
		lblCotrasena.setHorizontalAlignment(SwingConstants.CENTER);
		lblCotrasena.setFont(new Font("Georgia", Font.BOLD, 16));
		lblCotrasena.setBounds(63, 149, 140, 40);
		contentPane.add(lblCotrasena);
		
		pwContrasena = new JPasswordField();
		pwContrasena.setFont(new Font("Georgia", Font.PLAIN, 14));
		pwContrasena.setHorizontalAlignment(SwingConstants.CENTER);
		pwContrasena.setBounds(251, 154, 175, 30);
		contentPane.add(pwContrasena);
		
		btnIngresar = new JButton("INGRESAR");
		btnIngresar.setForeground(Color.BLACK);
		btnIngresar.setFont(new Font("Georgia", Font.BOLD, 16));
		btnIngresar.addActionListener(new ListenerLogin()); //Se implementa el Listener al botón
		btnIngresar.setBounds(73, 232, 163, 47);
		contentPane.add(btnIngresar);
		
		btnRegistrarse = new JButton("REGISTRARSE");
		btnRegistrarse.addActionListener(new ListenerLogin());
		btnRegistrarse.setFont(new Font("Georgia", Font.BOLD, 16));
		btnRegistrarse.setBounds(263, 233, 163, 47);
		contentPane.add(btnRegistrarse);
	} //Cierre del constructor
	
	/**
	 * Esta clase interna escucha el evento de hacer click sobre el botón ingresar y registro. Envía el usuario y contraseña al método de validación si el se hace click en ingresar y abre el menú si coinciden, en caso contrario muestra un mensaje
	 * de error. Permite abrir la ventana de registro al dar click en el bontón registro
	 */
	public class ListenerLogin implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			//Evento de botón ingresar
			if(arg0.getSource() == btnIngresar) {
				char[] ArrContrasena = pwContrasena.getPassword();
				String contrasena = new String(ArrContrasena);
				if(tfUsuario.getText().compareTo("") == 0 || contrasena.compareTo("")== 0) {
					JOptionPane.showMessageDialog(null, "1.1 Ha dejado en blanco uno o más campos", "Campos vacíos", 2);
				}
				else {
					if(controlador.AutenticarIngreso(tfUsuario.getText(),contrasena) == true) {
						Persistencia.setNombreDB(tfUsuario.getText());
						controlador.regresar(Login.this);
					}
					else {
						JOptionPane.showMessageDialog(null, "1.2 El usuario y/o la contraseña no coinciden", "Error de validación", 0);
						tfUsuario.setText("");
						pwContrasena.setText("");
					}
				
				}
			}
			//Evento de botón registro 
			if(arg0.getSource() == btnRegistrarse) {
				Registro registro = null;
				try {
					registro = new Registro();
				} catch (ParseException e) {
					e.printStackTrace();
				}
				registro.setVisible(true);
				registro.setLocationRelativeTo(null);
				Login.this.setVisible(false);
				
			}
				
		} //Ciere del método	
		
	}//Cierre de la clase interna
	
}//Cierre de la clase