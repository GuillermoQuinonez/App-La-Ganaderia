import java.util.Comparator;
/**
 * Esta clase implementa la intertfaz Comparator y sobreescribe el m�todo compare para ordenar a los elementos Ganado de un ArrayList de forma ascendente por su atributro n�mero 
 * @file OrdenarPorNumero.java
 * @author Jos� Guillermo Qui��nez Castillo (qui17775@uvg.edu.gt)
 * @author Carlo Humberto Chew (che17507@uvg.edu.gt)
 * @version 14.11.2017
 */
public class OrdenarPorNumero implements Comparator<Ganado>{
	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Ganado o1, Ganado o2) {
		if (o1.getNumero() > o2.getNumero()) return 1;
		if (o1.getNumero() < o2.getNumero()) return -1;
		else return 0; 
	}//Cierre del m�todo 

}//Cierre de la clase
