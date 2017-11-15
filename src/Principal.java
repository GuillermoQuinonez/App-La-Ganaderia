import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import org.jfree.ui.RefineryUtilities;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
/**
 * Esta clase contiene un menú con botones para efectuar las diferentes acciones que el programa realiza y además contiene una tabla con la información de cada ganado creado
 * @file Principal.java
 * @author José Guillermo Quiñónez Castillo <qui17775@uvg.edu.gt>
 * @author Carlo Humberto Chew <che17507@uvg.edu.gt>
 * @version 19.10.2017/A
 */
public class Principal extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	//Campos de la clase
	private JPanel contentPane;
	private JTable table; 
	private JButton btnVer;
	private JButton btnEditar;
	private JButton btnCrear;
	private JButton btnEliminar;
	private JButton btnCerrarSesion;
	private JButton btnIrBusqueda; 
	private JComboBox<String> cbOrdenar; 
	private JButton btnOrdenar; 
	private JButton btnMostrarGrafica; 
	private ControlGanaderia controlador;  
	private JSpinner tfBusqueda;
	private static int busqueda; 
	private JButton btnDatos;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}//Ciere del método

	/**
	 * Constructor del Principal, despliega el frame, y los componentes diseñados en él. 
	 */
	public Principal() {
		setResizable(false);
		controlador = new ControlGanaderia();
		controlador.Conectar();
		setTitle("La Ganaderia");
		setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono.jpg")).getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(160, 82, 45));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(UIManager.getBorder("CheckBoxMenuItem.border"), "Men\u00FA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(12, 7, 450, 360);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(34, 39, 389, 278);
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(3, 2, 10, 10));
		
		btnVer = new JButton("VER");
		btnVer.setBackground(new Color(255, 255, 255));
		btnVer.addActionListener(new ListenerPrincipal()); //Se implementa el Listener en el botón
		
		btnCrear = new JButton("CREAR");
		btnCrear.addActionListener(new ListenerPrincipal()); //Se implementa el Listener en el botón
		btnCrear.setFont(new Font("Dialog", Font.BOLD, 18));
		btnCrear.setBackground(new Color(255, 255, 255));
		panel_3.add(btnCrear);
		btnVer.setFont(new Font("Dialog", Font.BOLD, 18));
		panel_3.add(btnVer);
		
		btnEditar = new JButton("EDITAR");
		btnEditar.setBackground(new Color(255, 255, 255));
		btnEditar.addActionListener(new ListenerPrincipal()); //Se implementa el Listener en el botón
		btnEditar.setFont(new Font("Dialog", Font.BOLD, 18));
		panel_3.add(btnEditar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBackground(new Color(255, 255, 255));
		btnEliminar.setFont(new Font("Dialog", Font.BOLD, 18));
		btnEliminar.addActionListener(new ListenerPrincipal()); //Se implementa el Listener en el botón
		panel_3.add(btnEliminar);
		
		btnDatos = new JButton("INFORMACI\u00D3N");
		btnDatos.addActionListener(new ListenerPrincipal());
		btnDatos.setBackground(Color.WHITE);
		btnDatos.setFont(new Font("Dialog", Font.BOLD, 17));
		panel_3.add(btnDatos);
		
		btnCerrarSesion = new JButton("CERRAR SESI\u00D3N");
		panel_3.add(btnCerrarSesion);
		btnCerrarSesion.addActionListener(new ListenerPrincipal());
		btnCerrarSesion.setBackground(new Color(255, 255, 255));
		btnCerrarSesion.setFont(new Font("Dialog", Font.BOLD, 17));
		btnCerrarSesion.addActionListener(new ListenerPrincipal());
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("CheckBoxMenuItem.border"), "B\u00FAsqueda", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(12, 380, 450, 360);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("B\u00DASQUEDA POR N\u00DAMERO");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 20, 209, 66);
		panel_1.add(lblNewLabel);
		
		btnIrBusqueda = new JButton("IR");
		btnIrBusqueda.addActionListener(new ListenerPrincipal());
		btnIrBusqueda.setBackground(new Color(255, 255, 255));
		btnIrBusqueda.setFont(new Font("Dialog", Font.BOLD, 14));
		btnIrBusqueda.setBounds(154, 99, 129, 39);
		panel_1.add(btnIrBusqueda);
		
		JLabel lblOrdenarPor = new JLabel("ORDENAR POR");
		lblOrdenarPor.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblOrdenarPor.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrdenarPor.setBounds(12, 162, 197, 47);
		panel_1.add(lblOrdenarPor);
		
		cbOrdenar = new JComboBox<>();
		cbOrdenar.setBackground(new Color(255, 255, 255));
		cbOrdenar.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		cbOrdenar.setBounds(241, 162, 197, 47);
		cbOrdenar.addItem("Número");
		cbOrdenar.addItem("Nombre");
		cbOrdenar.addItem("Producción Lechera");
		cbOrdenar.addItem("Ganancia de Carne");
		cbOrdenar.addItem("Orden de Creación");
		cbOrdenar.addActionListener(new ListenerPrincipal());
		panel_1.add(cbOrdenar);
		
		btnOrdenar = new JButton("ORDENAR");
		btnOrdenar.setBackground(new Color(255, 255, 255));
		btnOrdenar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnOrdenar.addActionListener(new ListenerPrincipal());
		btnOrdenar.setBounds(154, 237, 129, 39);
		panel_1.add(btnOrdenar);
		
		btnMostrarGrafica = new JButton("ESTAD\u00CDSTICAS DE POBLACI\u00D3N");
		btnMostrarGrafica.addActionListener(new ListenerPrincipal());
		btnMostrarGrafica.setBackground(new Color(255, 255, 255));
		btnMostrarGrafica.setFont(new Font("Dialog", Font.BOLD, 12));
		btnMostrarGrafica.setBounds(113, 300, 218, 47);
		panel_1.add(btnMostrarGrafica);
		
		tfBusqueda = new JSpinner();
		tfBusqueda.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		tfBusqueda.setBounds(217, 28, 221, 39);
		panel_1.add(tfBusqueda);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("CheckBoxMenuItem.border"), "Ganado", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(474, 7, 708, 733);
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 1, 5, 5));
		/*
		 * Muestra datos de la base de datos en la tabla
		 * */
		table = new JTable();
		table.setBounds(0, 0, 353, 292);
		ArrayList<Ganado> Miganado = controlador.ObtenerDatos(ControlGanaderia.getIndice(), busqueda); 
		String titulos[] = new String[] {"Codigo", "Número", "Nombre", "Propietario", "Estado"}; 
		DefaultTableModel modelo = new DefaultTableModel(null, titulos); 
		String fila[]=new String[5]; 
		for(Ganado res: Miganado){
			fila[0] = res.getId().toString(); 
			fila[1] = String.valueOf(res.getNumero());
			fila[2] = res.getNombre(); 
			fila[3] = res.getPropietario(); 
			fila[4] = res.getEstado();  
			modelo.addRow(fila);
		}
		table.setModel(modelo);
		JScrollPane scrollPane = new JScrollPane(table, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setViewportView(table);
		scrollPane.setBackground(Color.WHITE);
		panel_2.add(scrollPane);
		/*
		 * Fin tabla
		 * */
	
	}//Cierre del constructor 
	
	/**
	 * Esta clase interna es la que se encarga de esuchar los eventos relacionados a los botones del menú y despliega los diferentes ventanas que requiere el programa 
	 * @file Principal.java
	 * @author José Guillermo Quiñónez Castillo <qui17775@uvg.edu.gt>
	 * @author Carlo Humberto Chew <che17507@uvg.edu.gt>
	 * @version 28.09.2017/A
	 */
	public class ListenerPrincipal implements ActionListener{
		@Override
		/*
		 * Este método detecta los eventos del click 
		 * */
		public void actionPerformed(ActionEvent arg0) {
			if(arg0.getSource() == btnVer) {
				if(table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "1.3 Debe seleccionar un registro");
				}
				else {
					Ver ver = null;
					try {
						ver = new Ver(table.getModel().getValueAt(table.getSelectedRow(),0).toString());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					ver.setVisible(true);
					ver.setLocationRelativeTo(null);
					setVisible(false);  
				
				}
			}
			if(arg0.getSource() == btnEditar) {
				if(table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "1.3 Debe seleccionar un registro");
				}
				else {
					Editar editar = null;
					try {
						editar = new Editar(table.getModel().getValueAt(table.getSelectedRow(),0).toString());
					} catch (ParseException e) {
						e.printStackTrace();
					}
					editar.setVisible(true);
					editar.setLocationRelativeTo(null);
					setVisible(false);
				}
			}
			if(arg0.getSource() == btnEliminar) {
				if(table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "1.3 Debe seleccionar un registro", "", 2);
				} 
				else {
					controlador.EliminarGanado(table.getModel().getValueAt(table.getSelectedRow(),0).toString());
					
					controlador.regresar(Principal.this);
					
				
				}
			}
			if(arg0.getSource() == btnCrear) {
				Nuevo nuevo = new Nuevo(); 
				nuevo.setVisible(true);
				nuevo.setLocationRelativeTo(null);
				setVisible(false); 	
			}
			if(arg0.getSource() == btnOrdenar) {
				int indice = cbOrdenar.getSelectedIndex(); 
				ControlGanaderia.setIndice(indice); 
				controlador.regresar(Principal.this);
			}
			if(arg0.getSource() == btnIrBusqueda) {
				ControlGanaderia.setIndice(5);
				int Valor = Integer.parseInt(tfBusqueda.getValue().toString());
				System.out.println(Valor);
				busqueda = Valor; 
				controlador.regresar(Principal.this);
			}
			if(arg0.getSource() == btnCerrarSesion) {
				Login login = null;
				login = new Login(); 
				login.setVisible(true);
				login.setLocationRelativeTo(null);
				setVisible(false);
			}
			if(arg0.getSource() == btnMostrarGrafica) {
				GraficaDeEstados chart = new GraficaDeEstados(controlador.Dataset()); 
				chart.getVentanaGrafica().pack( );
				RefineryUtilities.centerFrameOnScreen( chart.getVentanaGrafica() );
				chart.getVentanaGrafica().setVisible( true );
			}
			if(arg0.getSource() == btnDatos) {
				PerfilUsuario perfil = null;
				try {
					perfil = new PerfilUsuario();
				} catch (ParseException e) {
					e.printStackTrace();
				}
				perfil.setVisible(true);
				perfil.setLocationRelativeTo(null);
				setVisible(false);
			}
			
		}//Cierre del método
		
	}  //Cierre de la clase interna MyListener
	
}//Cierre de la clase Principal
