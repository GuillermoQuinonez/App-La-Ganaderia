import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.toedter.calendar.JDateChooser;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
/**
 * Esta clase contiene un frame con campos de texto y un ComboBox que muestran informacion del ganado seleccionado, además es editale y actualiza la iformación ingresada en la base de datos. 
 * @file Editar.java
 * @author José Guillermo Quiñónez Castillo <qui17775@uvg.edu.gt>
 * @author Carlo Humberto Chew <che17507@uvg.edu.gt>
 * @version 28.09.2017/A
 */
public class Editar extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Campos de la clase
	private JPanel contentPane;
	private JTextField tfPropietario;
	private JTextField tfColor;
	private JTextField tfProcedencia;
	private JTextField tfProgenitor;
	private JTextField tfProgenitora;
	private JTextField tfNombre;
	private JComboBox<String> cbEstado;
	private float Peso;
	private float ProduccionLechera; 
	private JTextArea txtHistorial;
	private JButton btnGuardar;
	private JButton btnRegresar;
	private ControlGanaderia controlador;
	private JComboBox<String> cbSexo;
	private JDateChooser dcFecha;
	private Date FechaActual; 
	private JSpinner tfNumero;
	private JSpinner tfPeso;
	private JSpinner tfPLechera;
	private JSpinner tfGPeso;
	private Ganado ganadoActual; 
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Editar frame = new Editar("");
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}//Cierre del método

	/**
	 * Construtor de la clase, despliega el frame y todos los componentes en él: paneles, campos de texto, labels, áreas de texto, botones.
	 * @throws SQLException 
	 * @throws ParseException 
	 */
	public Editar(String codigo) throws ParseException{
		controlador=new ControlGanaderia();
		controlador.Conectar();
		FechaActual = new Date(); 
		setTitle("La Ganader\u00EDa: Edición");
		setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono.jpg")).getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("ScrollBar.foreground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		 
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos Generales", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
		panel.add(dcFecha);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblSexo.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblSexo);
		
		cbSexo = new JComboBox<>();
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
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n de producci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
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
		cbEstado.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		//Se añaden Items al ComboBox con las opciones predeterminadas
		cbEstado.addItem("Otro");
		cbEstado.addItem("Engorde");
		cbEstado.addItem("Producción Lechera");
		cbEstado.addItem("Preparto");
		cbEstado.addItem("Enfermería");
		cbEstado.addActionListener(new ListenerEditar());
		panel_1.add(cbEstado);
		
		JLabel lblProduccionLecheral = new JLabel("Produccion lechera (L): ");
		lblProduccionLecheral.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblProduccionLecheral.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblProduccionLecheral);
		
		tfPLechera = new JSpinner();
		tfPLechera.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
		panel_1.add(tfPLechera);
		
		JLabel lblGananciaDePeso = new JLabel("Ganancia de peso (lb): ");
		lblGananciaDePeso.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblGananciaDePeso.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblGananciaDePeso);
		
		tfGPeso = new JSpinner();
		tfGPeso.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
		panel_1.add(tfGPeso);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Historial", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(12, 407, 389, 133);
		contentPane.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 1, 0, 0));
		
		txtHistorial = new JTextArea();
		txtHistorial.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtHistorial.setLineWrap(true);
		txtHistorial.setWrapStyleWord(true);
		JScrollPane scroll = new JScrollPane(txtHistorial,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		panel_3.add(scroll);
		
		btnRegresar = new JButton("REGRESAR");
		btnRegresar.setFont(new Font("Dialog", Font.BOLD, 16));
		btnRegresar.setBounds(608, 444, 138, 59);
		btnRegresar.addActionListener(new ListenerEditar()); //Se implementa el Listener al botón 
		contentPane.add(btnRegresar);
		
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setFont(new Font("Dialog", Font.BOLD, 16));
		btnGuardar.setBounds(438, 444, 138, 59);
		btnGuardar.addActionListener(new ListenerEditar());
		contentPane.add(btnGuardar);
		
		JFormattedTextField PLechera = ((JSpinner.DefaultEditor) tfPLechera.getEditor()).getTextField();
		JFormattedTextField GPeso = ((JSpinner.DefaultEditor) tfGPeso.getEditor()).getTextField();
		PLechera.setEditable(false);
		GPeso.setEditable(false);
		
		//Se llena la información del animal con los datos que provienene de la base de datos
		ArrayList<Ganado> Miganado = controlador.getGanado();
		for(Ganado res: Miganado) {
			if(codigo.equals(res.getId().toString())) {
				ganadoActual = res; 
				tfNombre.setText(res.getNombre());
				tfNumero.setValue(res.getNumero());
				tfPropietario.setText(res.getPropietario());
				SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy"); 
				String fecha = res.getFechaNac();
				dcFecha.setDate(formatofecha.parse(fecha));
				if(res.getSexo().equals("Masculino")) {
					cbSexo.setSelectedIndex(0);
				}
				else {
					cbSexo.setSelectedIndex(1);
				}
				tfColor.setText(res.getColor());
				Peso = res.getPeso();
				tfPeso.setValue(Peso); 
				tfProcedencia.setText(res.getProcedencia());
				tfProgenitor.setText(res.getProgenitor());
				tfProgenitora.setText(res.getProgenitora());
				if(res.getEstado().equals("Otro")) {
					cbEstado.setSelectedIndex(0);
				}
				if(res.getEstado().equals("Engorde")) {
					cbEstado.setSelectedIndex(1);
				}
				if(res.getEstado().equals("Producción Lechera")) {
					cbEstado.setSelectedIndex(2);
				}
				if(res.getEstado().equals("Preparto")) {
					cbEstado.setSelectedIndex(3);
				}
				if(res.getEstado().equals("Enfermería")) {
					cbEstado.setSelectedIndex(4);
				}
				ProduccionLechera = res.getProduccionLechera();
				tfPLechera.setValue(ProduccionLechera);
				tfGPeso.setValue(res.getGananciaPeso());
				txtHistorial.setText(res.getHistorial());
			}
	}

}//Fin del constructor
	
	/**
	 * Esta clase interna es la que se encarga de escuchar los eventos de los botones para llamar a los método que permiten crear cambiar los datos en la base de datos con
	 * los datos ingresados y regresar al menú principal, también permiten validad si los campos están llenos para evitar errores en tiempo de ejecución
	 * @file Nuevo.java
	 * @author José Guillermo Quiñónez Castillo <qui17775@uvg.edu.gt>
	 * @author Carlo Humberto Chew <che17507@uvg.edu.gt>
	 * @version 28.09.2017/A
	 */
	public class ListenerEditar implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(arg0.getSource() == btnGuardar) {
				SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy"); 
				if(tfNombre.getText().compareTo("") == 0 || tfPropietario.getText().compareTo("") == 0 || tfColor.getText().compareTo("") == 0 || tfProcedencia.getText().compareTo("") == 0 || tfProgenitor.getText().compareTo("") == 0 || tfProgenitora.getText().compareTo("") == 0 || txtHistorial.getText().compareTo("") == 0 ) {
					JOptionPane.showMessageDialog(null, "Hay campos vacíos, revise antes de guardar", "Campos vacíos", 2);
					JOptionPane.showMessageDialog(null, "Escriba N/D si no hay información sobre algún campo de texto", "Información", 1);
				}
				if(formatofecha.format(dcFecha.getDate()).compareTo("") == 0) {
					JOptionPane.showMessageDialog(null, "Ingrese la fecha de nacimiento", "Campos vacíos", 2);
				}
				else {
					if(cbEstado.getSelectedIndex() == 2) {
						int l = controlador.CantidadMayor(Float.parseFloat(tfPLechera.getValue().toString()),  ProduccionLechera); 
						float CambioProduccionLechera = Math.abs(controlador.CambioCantidad(Float.parseFloat(tfPLechera.getValue().toString()), ProduccionLechera)); 
						if(l == 1) {
							String MensajeFelicitacion = "La vaca aumentó su producción lechera en " + CambioProduccionLechera  + " L"; 
							JOptionPane.showMessageDialog(null, MensajeFelicitacion, "¡Felicitaciones!", 1);
							txtHistorial.append("\n"+new SimpleDateFormat("dd/MM/yyyy").format(FechaActual)+": "+ MensajeFelicitacion);
						}
						if(l == 2){
							String MensajeAdvertencia = "La vaca disminuyó su producción lechera en " + CambioProduccionLechera  + " L"; 
							JOptionPane.showMessageDialog(null, MensajeAdvertencia, "¡Advertencia!", 2);
							txtHistorial.append("\n"+new SimpleDateFormat("dd/MM/yyyy").format(FechaActual)+": "+ MensajeAdvertencia);
							
						}
					}
					if (cbEstado.getSelectedIndex() == 1) {
						int p = controlador.CantidadMayor(Float.parseFloat(tfPeso.getValue().toString()), Peso); 
						float Ganancia = controlador.CambioCantidad(Float.parseFloat(tfPeso.getValue().toString()), Peso); 
						tfGPeso.setValue(Ganancia);
						float CambioPeso = Math.abs(Ganancia); 
						if(p == 1) {
							String MensajeFelicitacion = "El animal ha ganado " + CambioPeso  + " libras desde la última pesada"; 
							JOptionPane.showMessageDialog(null, MensajeFelicitacion, "¡Felicitaciones!", 1);
							txtHistorial.append("\n"+"Pesada "+ new SimpleDateFormat("dd/MM/yyyy").format(FechaActual)+": "+ MensajeFelicitacion);
						}
						if(p == 2) {
							String MensajeAdvertencia = "El animal ha perdido " + CambioPeso  + " libras desde la última pesada"; 
							JOptionPane.showMessageDialog(null, MensajeAdvertencia, "¡Advertencia!", 2);
							txtHistorial.append("\n"+"Pesada "+ new SimpleDateFormat("dd/MM/yyyy").format(FechaActual)+": "+ MensajeAdvertencia);
						}
						
					}
					else {
						tfGPeso.setValue(0);
					}
					controlador.ActualizarInformacion(ganadoActual, tfNombre.getText(), Integer.parseInt(tfNumero.getValue().toString()), tfPropietario.getText(), formatofecha.format(dcFecha.getDate()),cbSexo.getSelectedItem().toString(),tfColor.getText(),Float.parseFloat(tfPeso.getValue().toString()),tfProcedencia.getText(),tfProgenitor.getText(),tfProgenitora.getText(), String.valueOf(cbEstado.getSelectedItem()),Float.parseFloat(tfPLechera.getValue().toString()),Float.parseFloat(tfGPeso.getValue().toString()), txtHistorial.getText());
					JOptionPane.showMessageDialog(null, "El registro se ha actualizado", "Hecho", 1);
				    /*
					 * Regresa al principal
					 * */
				    controlador.regresar(Editar.this);
					
				}
			}
			if(arg0.getSource() == btnRegresar) {
				/*
				 * Regresa al principal
				 * */
				controlador.regresar(Editar.this);
			}
			
			if(arg0.getSource() == cbEstado) {
				JFormattedTextField ProduccionLechera = ((JSpinner.DefaultEditor) tfPLechera.getEditor()).getTextField();
				if(cbEstado.getSelectedIndex() == 1) {
					txtHistorial.append("\n"+ new SimpleDateFormat("dd/MM/yyyy").format(FechaActual)+ ": El animal entró en Engorde");
					tfPLechera.setValue(0);
					ProduccionLechera.setEditable(false);
					tfGPeso.setValue(0);	
				}
				if(cbEstado.getSelectedIndex() == 2) {
					txtHistorial.append("\n"+ new SimpleDateFormat("dd/MM/yyyy").format(FechaActual)+ ": El animal entró en Producción Lechera");
					tfPLechera.setValue(0);
					ProduccionLechera.setEditable(true);
					tfGPeso.setValue(0);
				}
				if(cbEstado.getSelectedIndex() == 0 || cbEstado.getSelectedIndex() == 3 || cbEstado.getSelectedIndex() == 4){
					txtHistorial.append("\n"+ new SimpleDateFormat("dd/MM/yyyy").format(FechaActual)+ ": El animal ha dejado Producción Lechera o Engorde y ha entrado a " + cbEstado.getSelectedItem().toString());
					ProduccionLechera.setEditable(false);
					tfPLechera.setValue(0);
					tfGPeso.setValue(0);	
				}
			}
		}
		
	}
	
}//Cierre de la clase Editar
