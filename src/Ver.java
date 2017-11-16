import java.awt.EventQueue;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.CompoundBorder;
import java.awt.SystemColor;
/**
 * Esta clase contiene un frame con campos de texto que muestran información proveniente de la base de datos de cada ganado, sin poder editarlos. 
 * @file Ver.java
 * @author José Guillermo Quiñónez Castillo <qui17775@uvg.edu.gt>
 * @author Carlo Humberto Chew <che17507@uvg.edu.gt>
 * @version 28.09.2017/A
 */
public class Ver extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Campos de la clase
	private JPanel contentPane;
	private JTextField tfNumero;
	private JTextField tfPropietario;
	private JTextField tfNac;
	private JTextField tfSexo;
	private JTextField tfColor;
	private JTextField tfPeso;
	private JTextField tfProcedencia;
	private JTextField tfProgenitor;
	private JTextField tfProgenitora;
	private JTextField tfEstado;
	private JTextField tfPLechera;
	private JTextField tfGPeso;
	private DecimalFormat formatodecimal;
	private JButton btnRegresar;
	private JTextArea txtHistorial;
	private ControlGanaderia controlador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ver frame = new Ver("");
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}//Cierre del método

	/**
	 * Constructor de la clase, despliega el frame y todos los componentes en él: paneles, campos de texto, labels, áreas de texto, botones. 
	 * 
	 */
	public Ver(String codigo) throws ParseException{
		controlador=new ControlGanaderia();
		controlador.Conectar();
		setTitle("La Gander\u00EDa: Vista");
		setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono.jpg")).getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(205, 133, 63));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnRegresar = new JButton("REGRESAR");
		btnRegresar.setBackground(SystemColor.control);
		btnRegresar.setFont(new Font("Dialog", Font.BOLD, 16));
		btnRegresar.setBounds(517, 449, 162, 63);
		btnRegresar.addActionListener(new MyListenerVer()); //Se implementa el Listener al botón
		
		JLabel lblnombre = new JLabel("Nombre");
		lblnombre.setBackground(UIManager.getColor("ScrollBar.background"));
		lblnombre.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblnombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblnombre.setBounds(216, 13, 331, 69);
		contentPane.add(lblnombre);
		contentPane.add(btnRegresar);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(new CompoundBorder(null, UIManager.getBorder("CheckBoxMenuItem.border")), "Datos Generales", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(12, 81, 370, 315);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(6, 2, 10, 10));
		
		JLabel lblNmero = new JLabel("N\u00FAmero: ");
		lblNmero.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNmero.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNmero);
		
		tfNumero = new JTextField();
		tfNumero.setBackground(Color.WHITE);
		tfNumero.setEditable(false);
		tfNumero.setFont(new Font("Georgia", Font.PLAIN, 12));
		tfNumero.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(tfNumero);
		tfNumero.setColumns(10);
		
		JLabel lblPropietario = new JLabel("Propietario: ");
		lblPropietario.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPropietario.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblPropietario);
		
		tfPropietario = new JTextField();
		tfPropietario.setBackground(Color.WHITE);
		tfPropietario.setEditable(false);
		tfPropietario.setFont(new Font("Georgia", Font.PLAIN, 12));
		tfPropietario.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(tfPropietario);
		tfPropietario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha de nac. DD/MM/AA: ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);
		
		tfNac = new JTextField();
		tfNac.setBackground(Color.WHITE);
		tfNac.setEditable(false);
		tfNac.setFont(new Font("Georgia", Font.PLAIN, 12));
		tfNac.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(tfNac);
		tfNac.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblSexo.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblSexo);
		
		tfSexo = new JTextField();
		tfSexo.setBackground(Color.WHITE);
		tfSexo.setEditable(false);
		tfSexo.setFont(new Font("Georgia", Font.PLAIN, 12));
		tfSexo.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(tfSexo);
		tfSexo.setColumns(10);
		
		JLabel lblColor = new JLabel("Color: ");
		lblColor.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblColor.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblColor);
		
		tfColor = new JTextField();
		tfColor.setBackground(Color.WHITE);
		tfColor.setEditable(false);
		tfColor.setFont(new Font("Georgia", Font.PLAIN, 12));
		tfColor.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(tfColor);
		tfColor.setColumns(10);
		
		JLabel lblPeso = new JLabel("Peso (lb): ");
		lblPeso.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPeso.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblPeso);
		
		tfPeso = new JTextField();
		tfPeso.setBackground(Color.WHITE);
		tfPeso.setEditable(false);
		tfPeso.setFont(new Font("Georgia", Font.PLAIN, 12));
		tfPeso.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(tfPeso);
		tfPeso.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(new CompoundBorder(null, UIManager.getBorder("CheckBoxMenuItem.border")), "Informaci\u00F3n de producci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(400, 79, 370, 315);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(6, 2, 10, 10));
		
		JLabel lblProcedencia = new JLabel("Procedencia: ");
		lblProcedencia.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblProcedencia.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblProcedencia);
		
		tfProcedencia = new JTextField();
		tfProcedencia.setBackground(Color.WHITE);
		tfProcedencia.setEditable(false);
		tfProcedencia.setFont(new Font("Georgia", Font.PLAIN, 12));
		tfProcedencia.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(tfProcedencia);
		tfProcedencia.setColumns(10);
		
		JLabel lblProgenitor = new JLabel("Progenitor No./Nombre: ");
		lblProgenitor.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblProgenitor.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblProgenitor);
		
		tfProgenitor = new JTextField();
		tfProgenitor.setBackground(Color.WHITE);
		tfProgenitor.setEditable(false);
		tfProgenitor.setFont(new Font("Georgia", Font.PLAIN, 12));
		tfProgenitor.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(tfProgenitor);
		tfProgenitor.setColumns(10);
		
		JLabel lblProgenitoraNonombre = new JLabel("Progenitora No./Nombre: ");
		lblProgenitoraNonombre.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblProgenitoraNonombre.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblProgenitoraNonombre);
		
		tfProgenitora = new JTextField();
		tfProgenitora.setBackground(Color.WHITE);
		tfProgenitora.setEditable(false);
		tfProgenitora.setFont(new Font("Georgia", Font.PLAIN, 12));
		tfProgenitora.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(tfProgenitora);
		tfProgenitora.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado: ");
		lblEstado.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblEstado.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblEstado);
		
		tfEstado = new JTextField();
		tfEstado.setBackground(Color.WHITE);
		tfEstado.setEditable(false);
		tfEstado.setFont(new Font("Georgia", Font.PLAIN, 12));
		tfEstado.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(tfEstado);
		tfEstado.setColumns(10);
		
		JLabel lblProduccionLecheral = new JLabel("Produccion lechera (L): ");
		lblProduccionLecheral.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblProduccionLecheral.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblProduccionLecheral);
		
		tfPLechera = new JTextField();
		tfPLechera.setBackground(Color.WHITE);
		tfPLechera.setEditable(false);
		tfPLechera.setFont(new Font("Georgia", Font.PLAIN, 12));
		tfPLechera.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(tfPLechera);
		tfPLechera.setColumns(10);
		
		JLabel lblGananciaDePeso = new JLabel("Ganancia de peso (lb): ");
		lblGananciaDePeso.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblGananciaDePeso.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblGananciaDePeso);
		
		tfGPeso = new JTextField();
		tfGPeso.setBackground(Color.WHITE);
		tfGPeso.setEditable(false);
		tfGPeso.setFont(new Font("Georgia", Font.PLAIN, 12));
		tfGPeso.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(tfGPeso);
		tfGPeso.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBorder(new TitledBorder(new CompoundBorder(null, UIManager.getBorder("CheckBoxMenuItem.border")), "Historial", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(12, 407, 389, 133);
		contentPane.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 1, 0, 0));
		
		txtHistorial = new JTextArea();
		txtHistorial.setEditable(false);
		txtHistorial.setLineWrap(true);
		txtHistorial.setWrapStyleWord(true);
		JScrollPane scroll = new JScrollPane(txtHistorial,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		panel_3.add(scroll);
		
		//Se llena la información del animal con los datos que provienene de la base de datos 
		formatodecimal  = new DecimalFormat("0.00"); 
		ArrayList<Ganado> Miganado = controlador.getGanado();
		for(Ganado res: Miganado) {
			if(codigo.equals(res.getId().toString())) {
				lblnombre.setText(res.getNombre());
				tfNumero.setText((Integer.toString(res.getNumero())));
				tfPropietario.setText(res.getPropietario());
				tfNac.setText(res.getFechaNac());
				tfSexo.setText(res.getSexo());
				tfColor.setText(res.getColor());
				tfPeso.setText(formatodecimal.format(res.getPeso()));
				tfProcedencia.setText(res.getProcedencia());
				tfProgenitor.setText(res.getProgenitor());
				tfProgenitora.setText(res.getProgenitora());
				tfEstado.setText(res.getEstado());
				tfPLechera.setText(formatodecimal.format(res.getProduccionLechera()));
				tfGPeso.setText(formatodecimal.format(res.getGananciaPeso()));
				txtHistorial.setText(res.getHistorial());
			}
		} //Cierre del constructor 
}
	/**
	 * Esta clase interna es la que se encarga de escuchar el evento del botón regresar
	 * @file Ver.java
	 * @author José Guillermo Quiñónez Castillo <qui17775@uvg.edu.gt>
	 * @author Carlo Humberto Chew <che17507@uvg.edu.gt>
	 * @version 28.09.2017/A
	 */
	private class MyListenerVer implements ActionListener{
		@Override
		/*
		 * Regresa al principal 
		 * */
		public void actionPerformed(ActionEvent arg0) {
			controlador.regresar(Ver.this); 
		}//Cierre del método 
	}//Cierre de la clase interna MyListener
	
}//Cierre de la clase Ver
