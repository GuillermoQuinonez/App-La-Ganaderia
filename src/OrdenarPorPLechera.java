import java.util.Comparator;
/**
 * Esta clase implementa la interfaz Comparator y sobrescribe el m�todo compare para ordenar a los elementos Ganado de un ArrayList de mayor a menor por su producci�n lechera 
 * OrdenarPorPLechera.java
 * @author Jos� Guillermo Qui��nez Castillo (qui17775@uvg.edu.gt)
 * @author Carlo Humberto Chew (che17507@uvg.edu.gt)
 * @version 14.11.2017
 */
public class OrdenarPorPLechera implements Comparator<Ganado>{
	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Ganado o1, Ganado o2) {
		if (o1.getProduccionLechera() > o2.getProduccionLechera()) return -1;
		if (o1.getProduccionLechera() < o2.getProduccionLechera()) return 1;
		else return 0; 
	}//Cierre del m�todo
	
}//Fin de la clase