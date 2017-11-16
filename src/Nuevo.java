import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.text.SimpleDateFormat;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.SystemColor;
/**
 * Nuevo es un ventana de la GUI que permite llenar los datos requeridos para crear un registro de la clase Ganado
 * @file Nuevo.java
 * @author José Guillermo Quiñónez Castillo (qui17775@uvg.edu.gt)
 * @author Carlo Humberto Chew (che17507@uvg.edu.gt)
 * @date 15.11.2017
 */
public class Nuevo extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfPropietario;
	private JTextField tfColor;
	private JTextField tfProcedencia;
	private JTextField tfProgenitor;
	private JTextField tfProgenitora;
	private JTextField tfNombre;
	private JComboBox<String> cbEstado; 
	private JButton btnCrear;
	private JButton btnRegresar;
	private JTextArea txtHistorial;
	private ControlGanaderia controlador; 
	private JComboBox<String> cbSexo;
	private JDateChooser dcFecha;
	private JSpinner tfNumero;
	private JSpinner tfPeso;
	private JSpinner tfGananciaPeso;
	private JSpinner tfProduccionLechera;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Nuevo frame = new Nuevo();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}//Cierre del método 
	
	
	/**
	 * Constructor de la clase, despliega el frame y todos los componentes que contiene, paneles, labels,  campos de texto, cobobox o áreas de texto, botones s
	 */
	public Nuevo() {
		setBackground(new Color(160, 82, 45));
		controlador = new ControlGanaderia();
		controlador.Conectar();
		setTitle("La Ganader\u00EDa: Nuevo");
		setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono.jpg")).getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(205, 133, 63));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		 
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new TitledBorder(UIManager.getBorder("CheckBoxMenuItem.border"), "Datos Generales", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(12, 77, 370, 317);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(6, 2, 10, 10));
		
		tfNombre = new JTextField();
		tfNombre.setFont(new Font("Times New Roman", Font.BOLD, 18));
		tfNombre.setHorizontalAlignment(SwingConstants.CENTER);
		tfNombre.setBounds(273, 13, 230, 51);
		contentPane.add(tfNombre);
		tfNombre.setColumns(10);
		
		JLabel lblNmero = new JLabel("N\u00FAmero: ");
		lblNmero.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNmero.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNmero);
		
		tfNumero = new JSpinner();
		tfNumero.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		panel.add(tfNumero);
		
		JLabel lblPropietario = new JLabel("Propietario: ");
		lblPropietario.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPropietario.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblPropietario);
		
		tfPropietario = new JTextField();
		tfPropietario.setBackground(Color.WHITE);
		tfPropietario.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		tfPropietario.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(tfPropietario);
		tfPropietario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha de nac. DD/MM/AA: ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);
		
		dcFecha = new JDateChooser();
		dcFecha.getCalendarButton().setBackground(SystemColor.control);
		panel.add(dcFecha);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblSexo.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblSexo);
		
		cbSexo = new JComboBox<>();
		cbSexo.setBackground(SystemColor.control);
		cbSexo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		cbSexo.addItem("Macho");
		cbSexo.addItem("Hembra");
		panel.add(cbSexo);
		
		JLabel lblColor = new JLabel("Color: ");
		lblColor.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblColor.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblColor);
		
		tfColor = new JTextField();
		tfColor.setBackground(Color.WHITE);
		tfColor.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		tfColor.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(tfColor);
		tfColor.setColumns(10);
		
		JLabel lblPeso = new JLabel("Peso (lb): ");
		lblPeso.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPeso.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblPeso);
		
		tfPeso = new JSpinner();
		tfPeso.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
		panel.add(tfPeso);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("CheckBoxMenuItem.border"), "Informaci\u00F3n de producci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(400, 77, 370, 317);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(6, 2, 10, 10));
		
		JLabel lblProcedencia = new JLabel("Procedencia: ");
		lblProcedencia.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblProcedencia.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblProcedencia);
		
		tfProcedencia = new JTextField();
		tfProcedencia.setBackground(Color.WHITE);
		tfProcedencia.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		tfProcedencia.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(tfProcedencia);
		tfProcedencia.setColumns(10);
		
		JLabel lblProgenitor = new JLabel("Progenitor No./Nombre: ");
		lblProgenitor.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblProgenitor.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblProgenitor);
		
		tfProgenitor = new JTextField();
		tfProgenitor.setBackground(Color.WHITE);
		tfProgenitor.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		tfProgenitor.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(tfProgenitor);
		tfProgenitor.setColumns(10);
		
		JLabel lblProgenitoraNonombre = new JLabel("Progenitora No./Nombre: ");
		lblProgenitoraNonombre.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblProgenitoraNonombre.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblProgenitoraNonombre);
		
		tfProgenitora = new JTextField();
		tfProgenitora.setBackground(Color.WHITE);
		tfProgenitora.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		tfProgenitora.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(tfProgenitora);
		tfProgenitora.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado: ");
		lblEstado.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblEstado.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblEstado);
		
		cbEstado = new JComboBox<>();
		cbEstado.setBackground(SystemColor.control);
		cbEstado.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		//Se llenan los Items del ComboBox de forma predeterminada
		cbEstado.addItem("Otro");
		cbEstado.addItem("Engorde");
		cbEstado.addItem("Producción Lechera");
		cbEstado.addItem("Preparto");
		cbEstado.addItem("Enfermería");
		cbEstado.addItemListener(new ItemListenerNuevo()); //Se implementa el Listener al ComboBox
		panel_1.add(cbEstado);
		
		JLabel lblProduccionLecheral = new JLabel("Produccion lechera (L): ");
		lblProduccionLecheral.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblProduccionLecheral.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblProduccionLecheral);
		
		tfProduccionLechera = new JSpinner();
		tfProduccionLechera.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
		panel_1.add(tfProduccionLechera);
		
		JLabel lblGananciaDePeso = new JLabel("Ganancia de peso (lb): ");
		lblGananciaDePeso.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblGananciaDePeso.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblGananciaDePeso);
		
		tfGananciaPeso = new JSpinner();
		tfGananciaPeso.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
		panel_1.add(tfGananciaPeso);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("CheckBoxMenuItem.border"), "Historial", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(12, 407, 389, 133);
		contentPane.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 1, 0, 0));
		
		txtHistorial = new JTextArea();
		txtHistorial.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtHistorial.setLineWrap(true);
		txtHistorial.setWrapStyleWord(true);
		txtHistorial.append("Espacio para hacer anotaciones y llevar un registros de la actividad del animal: ");
		JScrollPane scroll = new JScrollPane(txtHistorial,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		panel_3.add(scroll);
		
		btnCrear = new JButton("CREAR");
		btnCrear.setBackground(SystemColor.control);
		btnCrear.setForeground(new Color(0, 0, 0));
		btnCrear.setFont(new Font("Dialog", Font.BOLD, 16));
		btnCrear.addActionListener(new ListenerNuevo()); //Se implementa el Listener al botón para Crear
		btnCrear.setBounds(431, 444, 138, 59);
		contentPane.add(btnCrear);
		
		btnRegresar = new JButton("REGRESAR");
		btnRegresar.setBackground(SystemColor.control);
		btnRegresar.setForeground(new Color(0, 0, 0));
		btnRegresar.setFont(new Font("Dialog", Font.BOLD, 16));
		btnRegresar.setBounds(608, 444, 138, 59);
		btnRegresar.addActionListener(new ListenerNuevo()); //Se implementa el Listener al botón para regresar al menú 
		contentPane.add(btnRegresar);
		
		JFormattedTextField PLechera = ((JSpinner.DefaultEditor) tfProduccionLechera.getEditor()).getTextField();
		JFormattedTextField GPeso = ((JSpinner.DefaultEditor) tfGananciaPeso.getEditor()).getTextField();
		PLechera.setEditable(false);
		GPeso.setEditable(false);
	}//Cierre del constuctor
	/**
	 * ListenerNuevo es una clase interna que implementa un ActionListener que escucha los eventos de los botones Guardar y Regresar. Al hacer click en Guardar Cambios verifica que no existan campos de texto en blanco, si esto ocurre llama al método 
	 * que permite crear un instancia de la clase Ganado y persistirlo, despliega un mensaje de confirmación y regresa al principal. Al hacer clock en Regresar se cierra la ventana y se abre de nuevo el Principal. 
	 */
	private class ListenerNuevo implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(arg0.getSource() == btnRegresar) {
				/*
				 * Regresa al principal
				 * */
				controlador.regresar(Nuevo.this);
			}
			if(arg0.getSource() == btnCrear) {
				SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy"); 

				if(tfNombre.getText().compareTo("") == 0 || tfPropietario.getText().compareTo("") == 0 || tfColor.getText().compareTo("") == 0 || tfProcedencia.getText().compareTo("") == 0 || tfProgenitor.getText().compareTo("") == 0 || tfProgenitora.getText().compareTo("") == 0 || txtHistorial.getText().compareTo("") == 0 ) {
					JOptionPane.showMessageDialog(null, "Hay campos vacíos, revise antes de guardar", "Campos vacíos", 2);
					JOptionPane.showMessageDialog(null, "Escriba N/D si no hay información sobre algún campo de texto", "Información", 1);
				}
				if(formatofecha.format(dcFecha.getDate()).compareTo("") == 0) {
					JOptionPane.showMessageDialog(null, "Ingrese la fecha de nacimiento", "Campos vacíos", 2);
				}
				else {
					String Nombre = tfNombre.getText(); 
					String Numero = tfNumero.getValue().toString(); 
					String Propietario = tfPropietario.getText();  
					String FechaNac = formatofecha.format(dcFecha.getDate());
					String Sexo = cbSexo.getSelectedItem().toString(); 
					String Color = tfColor.getText(); 
					String Peso = tfPeso.getValue().toString(); 
					String Procedencia = tfProcedencia.getText(); 
					String Progenitor = tfProgenitor.getText(); 
					String Estado = cbEstado.getSelectedItem().toString();
					String Progenitora = tfProgenitora.getText(); 
					String ProduccionLechera = tfProduccionLechera.getValue().toString();  
					String GananciaPeso = tfGananciaPeso.getValue().toString();  
					String Historial = txtHistorial.getText(); 
					controlador.CrearGanado(Nombre, Integer.parseInt(Numero), Propietario, FechaNac, Sexo, Color, Float.parseFloat(Peso), Procedencia, Progenitor, Progenitora, Estado, Float.parseFloat(ProduccionLechera), Float.parseFloat(GananciaPeso), Historial);
					JOptionPane.showMessageDialog(null, "El registro se ha creado exitosamente", "Creado", 1);
					controlador.regresar(Nuevo.this);
				}
			}
		}//Cierre del método 
		
	}//Cierre de la clase interna
	/**
	 * ItemListenerNuevo es una clase interna que implementa ItemListener y permite escuchar la seleccion del ComboBox para bloquear o habilitar algunos campos según la selección efectuada por el usuario
	 */
		
	private class ItemListenerNuevo implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent arg0) {
			JFormattedTextField ProduccionLechera = ((JSpinner.DefaultEditor) tfProduccionLechera.getEditor()).getTextField();
			JFormattedTextField GananciaPeso = ((JSpinner.DefaultEditor) tfGananciaPeso.getEditor()).getTextField();
			if(cbEstado.getSelectedIndex() == 2) {
				tfProduccionLechera.setValue(0);
				ProduccionLechera.setEditable(true);
				tfGananciaPeso.setValue(0);
				GananciaPeso.setEditable(false);
			}
			
			else {
				GananciaPeso.setEditable(false);
				ProduccionLechera.setValue(0);
				ProduccionLechera.setEditable(false);
				GananciaPeso.setValue(0);
			}
			
		} //Cierre del método
		
	}//Cierre de la clase interna MyItemListener
	
}//Cierre de la clase Nuevo
