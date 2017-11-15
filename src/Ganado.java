import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
/**
 * Esta es la clase modelo que contiene las caracter�sticas que definen al bobino. Implementa la interfaz Comparable para ordenar el arreglo de objetos Ganado de forma
 * alfab�tica por su nombre. 
 * @file Ganado.java
 * @author Jos� Guillermo Qui��nez Castillo (qui17775@uvg.edu.gt)
 * @author Carlo Humberto Chew (che17507@uvg.edu.gt)
 * @date 14.11.2017
 */
@Entity
public class Ganado implements Comparable <Ganado>{
	//Informaci�n de cada animal  
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
	 * Constructor sin par�metros 
	 */
	public Ganado() {	
	}//Cierre del constructor
	
	/**
	 * Constructor con par�metros de la clase
	 * @param Nombre String que almacena el nombre del bovino
	 * @param Numero int que almacena el n�mero de correlaci�n que identifica al bovino en el registro de la gander�a
	 * @param Propietario String que almacena el nombre del propietario del bovino
	 * @param FechaNac String que alamacena la fecha de nacimiento del bovino
	 * @param Sexo String que contiene el sexo del bovino (Macho o Hembra)
	 * @param Color String que contiene el color que pelaje del bovino
	 * @param Peso float que contiene el peso del bovino en libras
	 * @param Procedencia String que indica cu�l es la ganader�a de origen de la res
	 * @param Progenitor String que contiene el nombre del padre
	 * @param Progenitora String que contiene el nombre de la madre
	 * @param Estado String que almacena el estado del animal, es decir, a qu� grupo de la gander�a pertence (Engorde, Producci�n Lechera, Enfermer�a, Preparto u Otro)
	 * @param ProduccionLechera float que almacena la cantidad de leche que est� produciendo una vaca en producci�n lechera
	 * @param GananciaPeso float que almacena las libras que un bovino en engorde ha ganado desde la �ltima pesa. 
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
	}//Cierre del m�todo

	/**
	 * @param id the id to set
	 */
	public void setId(ObjectId id) {
		this.id = id;
	}//Cierre del m�todo

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return Nombre;
	}//Cierre del m�todo

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		Nombre = nombre;
	}//Cierre del m�todo

	/**
	 * @return the numero
	 */
	public int getNumero() {
		return Numero;
	}//Cierre del m�todo

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		Numero = numero;
	}//Cierre del m�todo

	/**
	 * @return the propietario
	 */
	public String getPropietario() {
		return Propietario;
	}//Cierre del m�todo

	/**
	 * @param propietario the propietario to set
	 */
	public void setPropietario(String propietario) {
		Propietario = propietario;
	}//Cierre del m�todo

	/**
	 * @return the fechaNac
	 */
	public String getFechaNac() {
		return FechaNac;
	}//Cierre del m�todo

	/**
	 * @param fechaNac the fechaNac to set
	 */
	public void setFechaNac(String fechaNac) {
		FechaNac = fechaNac;
	}//Cierre del m�todo

	/**
	 * @return the sexo
	 */
	public String getSexo() {
		return Sexo;
	}//Cierre del m�todo

	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(String sexo) {
		Sexo = sexo;
	}//Cierre del m�todo

	/**
	 * @return the color
	 */
	public String getColor() {
		return Color;
	}//Cierre del m�todo

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		Color = color;
	}//Cierre del m�todo

	/**
	 * @return the peso
	 */
	public float getPeso() {
		return Peso;
	}//Cierre del m�todo

	/**
	 * @param peso the peso to set
	 */
	public void setPeso(float peso) {
		Peso = peso;
	}//Cierre del m�todo

	/**
	 * @return the procedencia
	 */
	public String getProcedencia() {
		return Procedencia;
	}//Cierre del m�todo

	/**
	 * @param procedencia the procedencia to set
	 */
	public void setProcedencia(String procedencia) {
		Procedencia = procedencia;
	}//Cierre del m�todo

	/**
	 * @return the progenitor
	 */
	public String getProgenitor() {
		return Progenitor;
	}//Cierre del m�todo

	/**
	 * @param progenitor the progenitor to set
	 */
	public void setProgenitor(String progenitor) {
		Progenitor = progenitor;
	}//Cierre del m�todo

	/**
	 * @return the progenitora
	 */
	public String getProgenitora() {
		return Progenitora;
	}//Cierre del m�todo

	/**
	 * @param progenitora the progenitora to set
	 */
	public void setProgenitora(String progenitora) {
		Progenitora = progenitora;
	}//Cierre del m�todo

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return Estado;
	}//Cierre del m�todo

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		Estado = estado;
	}//Cierre del m�todo

	/**
	 * @return the produccionLechera
	 */
	public float getProduccionLechera() {
		return ProduccionLechera;
	}//Cierre del m�todo

	/**
	 * @param produccionLechera the produccionLechera to set
	 */
	public void setProduccionLechera(float produccionLechera) {
		ProduccionLechera = produccionLechera;
	}//Cierre del m�todo

	/**
	 * @return the gananciaPeso
	 */
	public float getGananciaPeso() {
		return GananciaPeso;
	}//Cierre del m�todo

	/**
	 * @param gananciaPeso the gananciaPeso to set
	 */
	public void setGananciaPeso(float gananciaPeso) {
		GananciaPeso = gananciaPeso;
	}//Cierre del m�todo

	/**
	 * @return the historial
	 */
	public String getHistorial() {
		return Historial;
	}//Cierre del m�todo

	/**
	 * @param historial the historial to set
	 */
	public void setHistorial(String historial) {
		Historial = historial;
	}//Cierre del m�todo

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
	}//Cierre del m�todo

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Ganado g) {
		return this.getNombre().compareTo(g.getNombre());   
	}//Cierre del m�todo

}//Fin de la clase
