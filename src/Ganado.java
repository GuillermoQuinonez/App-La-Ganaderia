import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
/**
 * Esta es la clase modelo que contiene las características que definen al bobino. Implementa la interfaz Comparable para ordenar el arreglo de objetos Ganado de forma
 * alfabética por su nombre. 
 * @file Ganado.java
 * @author José Guillermo Quiñónez Castillo (qui17775@uvg.edu.gt)
 * @author Carlo Humberto Chew (che17507@uvg.edu.gt)
 * @date 14.11.2017
 */
@Entity
public class Ganado implements Comparable <Ganado>{
	//Información de cada animal  
	@Id private ObjectId id;
	private String Nombre; 
	private int Numero; 
	private String Propietario; 
	private String FechaNac; 
	private String Sexo; 
	private String Color; 
	private float Peso; 
	private String Procedencia; 
	private String Progenitor; 
	private String Progenitora; 
	private String Estado; 
	private float ProduccionLechera; 
	private float GananciaPeso; 
	private String Historial; 
	
	/**
	 * Constructor sin parámetros 
	 */
	public Ganado() {	
	}//Cierre del constructor
	
	/**
	 * Constructor con parámetros de la clase
	 * @param Nombre String que almacena el nombre del bovino
	 * @param Numero int que almacena el número de correlación que identifica al bovino en el registro de la gandería
	 * @param Propietario String que almacena el nombre del propietario del bovino
	 * @param FechaNac String que alamacena la fecha de nacimiento del bovino
	 * @param Sexo String que contiene el sexo del bovino (Macho o Hembra)
	 * @param Color String que contiene el color que pelaje del bovino
	 * @param Peso float que contiene el peso del bovino en libras
	 * @param Procedencia String que indica cuál es la ganadería de origen de la res
	 * @param Progenitor String que contiene el nombre del padre
	 * @param Progenitora String que contiene el nombre de la madre
	 * @param Estado String que almacena el estado del animal, es decir, a qué grupo de la gandería pertence (Engorde, Producción Lechera, Enfermería, Preparto u Otro)
	 * @param ProduccionLechera float que almacena la cantidad de leche que está produciendo una vaca en producción lechera
	 * @param GananciaPeso float que almacena las libras que un bovino en engorde ha ganado desde la última pesa. 
	 * @param Historial String que contiene diversas antoaciones que pueden ser relevantes en la historia del animal para llevar un mejor registros de su productividad. 
	 */
	public Ganado(String Nombre, int Numero, String Propietario, String FechaNac, String Sexo, String Color, float Peso, String Procedencia, String Progenitor, String Progenitora, String Estado, float ProduccionLechera, float GananciaPeso, String Historial) {
		this.Nombre = Nombre; 
		this.Numero = Numero; 
		this.Propietario = Propietario; 
		this.FechaNac = FechaNac;
		this.Sexo = Sexo; 
		this.Color = Color; 
		this.Peso = Peso; 
		this.Procedencia = Procedencia; 
		this.Progenitor = Progenitor; 
		this.Progenitora = Progenitora; 
		this.Estado = Estado; 
		this.ProduccionLechera = ProduccionLechera; 
		this.GananciaPeso = GananciaPeso; 
		this.Historial = Historial; 
	}//Cierre del constructor

	/**
	 * @return the id
	 */
	public ObjectId getId() {
		return id;
	}//Cierre del método

	/**
	 * @param id the id to set
	 */
	public void setId(ObjectId id) {
		this.id = id;
	}//Cierre del método

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return Nombre;
	}//Cierre del método

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		Nombre = nombre;
	}//Cierre del método

	/**
	 * @return the numero
	 */
	public int getNumero() {
		return Numero;
	}//Cierre del método

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		Numero = numero;
	}//Cierre del método

	/**
	 * @return the propietario
	 */
	public String getPropietario() {
		return Propietario;
	}//Cierre del método

	/**
	 * @param propietario the propietario to set
	 */
	public void setPropietario(String propietario) {
		Propietario = propietario;
	}//Cierre del método

	/**
	 * @return the fechaNac
	 */
	public String getFechaNac() {
		return FechaNac;
	}//Cierre del método

	/**
	 * @param fechaNac the fechaNac to set
	 */
	public void setFechaNac(String fechaNac) {
		FechaNac = fechaNac;
	}//Cierre del método

	/**
	 * @return the sexo
	 */
	public String getSexo() {
		return Sexo;
	}//Cierre del método

	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(String sexo) {
		Sexo = sexo;
	}//Cierre del método

	/**
	 * @return the color
	 */
	public String getColor() {
		return Color;
	}//Cierre del método

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		Color = color;
	}//Cierre del método

	/**
	 * @return the peso
	 */
	public float getPeso() {
		return Peso;
	}//Cierre del método

	/**
	 * @param peso the peso to set
	 */
	public void setPeso(float peso) {
		Peso = peso;
	}//Cierre del método

	/**
	 * @return the procedencia
	 */
	public String getProcedencia() {
		return Procedencia;
	}//Cierre del método

	/**
	 * @param procedencia the procedencia to set
	 */
	public void setProcedencia(String procedencia) {
		Procedencia = procedencia;
	}//Cierre del método

	/**
	 * @return the progenitor
	 */
	public String getProgenitor() {
		return Progenitor;
	}//Cierre del método

	/**
	 * @param progenitor the progenitor to set
	 */
	public void setProgenitor(String progenitor) {
		Progenitor = progenitor;
	}//Cierre del método

	/**
	 * @return the progenitora
	 */
	public String getProgenitora() {
		return Progenitora;
	}//Cierre del método

	/**
	 * @param progenitora the progenitora to set
	 */
	public void setProgenitora(String progenitora) {
		Progenitora = progenitora;
	}//Cierre del método

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return Estado;
	}//Cierre del método

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		Estado = estado;
	}//Cierre del método

	/**
	 * @return the produccionLechera
	 */
	public float getProduccionLechera() {
		return ProduccionLechera;
	}//Cierre del método

	/**
	 * @param produccionLechera the produccionLechera to set
	 */
	public void setProduccionLechera(float produccionLechera) {
		ProduccionLechera = produccionLechera;
	}//Cierre del método

	/**
	 * @return the gananciaPeso
	 */
	public float getGananciaPeso() {
		return GananciaPeso;
	}//Cierre del método

	/**
	 * @param gananciaPeso the gananciaPeso to set
	 */
	public void setGananciaPeso(float gananciaPeso) {
		GananciaPeso = gananciaPeso;
	}//Cierre del método

	/**
	 * @return the historial
	 */
	public String getHistorial() {
		return Historial;
	}//Cierre del método

	/**
	 * @param historial the historial to set
	 */
	public void setHistorial(String historial) {
		Historial = historial;
	}//Cierre del método

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Ganado [id=" + id + ", Nombre=" + Nombre + ", Numero=" + Numero + ", Propietario=" + Propietario
				+ ", FechaNac=" + FechaNac + ", Sexo=" + Sexo + ", Color=" + Color + ", Peso=" + Peso + ", Procedencia="
				+ Procedencia + ", Progenitor=" + Progenitor + ", Progenitora=" + Progenitora + ", Estado=" + Estado
				+ ", ProduccionLechera=" + ProduccionLechera + ", GananciaPeso=" + GananciaPeso + ", Historial="
				+ Historial + "]";
	}//Cierre del método

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Ganado g) {
		return this.getNombre().compareTo(g.getNombre());   
	}//Cierre del método

}//Fin de la clase
