import org.jfree.chart.ChartPanel;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
/**
 * Esta clase cotiene una gr�fica de Pastel que porporciona informaci�n gr�fica de la proporci�n de animales en la ganader�a que se encuentran en los diversos estados. Esto
 * le permite ver al usuario la cantidad de bovinos que le generan o generar�n ganancia y con ello visualizar si la ganader�a est� trabajando de forma eficiente
 * @file GraficaDeEstados.java
 * @author Jos� Guillermo Qui��nez Castillo (qui17775@uvg.edu.gt)
 * @author Carlo Humberto Chew (che17507@uvg.edu.gt)
 * @version 14.11.2017
 */
public class GraficaDeEstados {
	private JFrame ventanaGrafica;
	private int[] datos;
	/**
	 * Constructor de la gr�fica
	 * @param datos un arreglo de enteros que contiene la cantidad de bovinos que se encuentran en cada estado
	 */
	public GraficaDeEstados(int[] datos) {
		  ventanaGrafica = new JFrame("Estados");
		  ventanaGrafica.setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono.jpg")).getImage());
		  ventanaGrafica.setTitle("La Ganader�a: Gr�fico");
		  this.datos = datos;
		  //Se crea la gr�fica de pastel
		  JFreeChart Piechart = ChartFactory.createPieChart3D(
	              "Porcentaje de Animales seg�n su estado",
	              Dataset(),
	              true,
	              true,
	              false
	      );
		  ChartPanel chartPanel = new ChartPanel( Piechart );
	      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
	      ventanaGrafica.setContentPane(chartPanel);

	   }//Cierre del constructor
	/**
	 * Este m�todo utiliza el n�mero de bovinos en cada estado porporcionado por el arreglo y lo utiliza para organizar los datos en la gr�fica de Pastel
	 * @return pieDateset DefaultPieDataSet es el conjunto de datos que se graficar�n
	 */
	private DefaultPieDataset Dataset( ) {
		DefaultPieDataset pieDataset = new DefaultPieDataset();
		pieDataset.setValue("Otro: " + String.valueOf(datos[0]), datos[0]);
	    pieDataset.setValue("Engorde: " + String.valueOf(datos[1]), datos[1]);
	    pieDataset.setValue("Producci�n Lechera: " + String.valueOf(datos[2]), datos[2]);
	    pieDataset.setValue("Preparto: " + datos[3], datos[3]);
	    pieDataset.setValue("Enfermer�a: " + datos[4], datos[4]);
	    return pieDataset;
	   }//Cierre del m�todo

	/**
	* @return VentanaGrafica JFrame la ventana que contiene la grafica
	*/
	public JFrame getVentanaGrafica() {
		return ventanaGrafica;
	}//Cierre del m�todo

	/**
	* @param ventanaGrafica JFrame la ventana que contiene la gr�fica
	*/
	public void setVentanaGrafica(JFrame ventanaGrafica) {
		this.ventanaGrafica = ventanaGrafica;
	}//Cierre del m�todo

}//Fin de la clase
