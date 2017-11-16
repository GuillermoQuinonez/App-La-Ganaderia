import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
/**
 * Usuario es la clase modelo de los obejos usuarios, es decir, contiene las caracteristicas que se requieren conocer de los clientes del programa y sus ganaderias. 
 * Usuario.java
 * @author José Guillermo Quiñónez Castillo (qui17775@uvg.edu.gt)
 * @author Carlo Humberto Chew (che17507@uvg.edu.gt)
 * @version 14.11.2017
 */
@Entity
public class Usuario {
	@Id private ObjectId id; 
	private String nombre; 
	private String usuario; 
	private String password;
	private long movil; 
	private String direccion; 
	private String ganaderia; 
	private String direccionGanaderia; 
	private long telefono; 
	
	/**
	 * Constructor sin parámetros dela clase Usuario
	 */
	public Usuario() {
	}//Cierre del constructor

	/**
	 * Constructor con parámetros de la clase Usuario
	 * @param nombre un String que almacena el nombre del cliente
	 * @param usuario un String que almacena el nombre de usuario del cliente y le permite hacer la validación para ingresar a la ventana principal
	 * @param password un Sring que almacena la clave que elige el usuario y que le permitirá hacer la validción para ingresar a la ventana principal 
	 * @param movil un long que almacena el número de celular del cliente
	 * @param direccion un String que almacena la dirección de residencia del cliente
	 * @param ganaderia un String que almacena el nombre de la ganadería de la que es dueño el cliente
	 * @param direccionGanaderia un String almacena la ubicacion de la ganadería del cliente
	 * @param telefono un long que almacena el número de telefono de la ganadería
	 */
	public Usuario(String nombre, String usuario, String password, long movil, String direccion, String ganaderia, String direccionGanaderia, long telefono) {
		this.nombre = nombre; 
		this.usuario = usuario; 
		this.password = password; 
		this.movil = movil; 
		this.direccion = direccion;
		this.ganaderia = ganaderia;
		this.direccionGanaderia = direccionGanaderia; 
		this.telefono = telefono; 
	}//Cierre del constructor

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}//Cierre del método

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}//Cierre del método

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}//Cierre del método

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}//Cierre del método

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}//Cierre del método

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}//Cierre del método

	/**
	 * @return the movil
	 */
	public long getMovil() {
		return movil;
	}//Cierre del método

	/**
	 * @param movil the movil to set
	 */
	public void setMovil(long movil) {
		this.movil = movil;
	}//Cierre del método

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}//Cierre del método

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}//Cierre del método

	/**
	 * @return the ganaderia
	 */
	public String getGanaderia() {
		return ganaderia;
	}//Cierre del método

	/**
	 * @param ganaderia the ganaderia to set
	 */
	public void setGanaderia(String ganaderia) {
		this.ganaderia = ganaderia;
	}//Cierre del método

	/**
	 * @return the direccionGanaderia
	 */
	public String getDireccionGanaderia() {
		return direccionGanaderia;
	}//Cierre del método

	/**
	 * @param direccionGanaderia the direccionGanaderia to set
	 */
	public void setDireccionGanaderia(String direccionGanaderia) {
		this.direccionGanaderia = direccionGanaderia;
	}//Cierre del método

	/**
	 * @return the telefono
	 */
	public long getTelefono() {
		return telefono;
	}//Cierre del método

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}//Cierre del método

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", usuario=" + usuario + ", password=" + password + ", movil=" + movil
				+ ", direccion=" + direccion + ", ganaderia=" + ganaderia + ", direccionGanaderia=" + direccionGanaderia
				+ ", telefono=" + telefono + "]";
	}//Cierre del método
	
	
}//Fin de la clase