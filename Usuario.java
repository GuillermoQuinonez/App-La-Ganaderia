import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
/**
 * Usuario es la clase modelo de los obejos usuarios, es decir, contiene las caracteristicas que se requieren conocer de los clientes del programa y sus ganaderias.
 * @file Usuario.java
 * @author Jos� Guillermo Qui��nez Castillo (qui17775@uvg.edu.gt)
 * @author Carlo Humberto Chew (che17507@uvg.edu.gt)
 * @date 14.11.2017
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
	 * Constructor sin par�metros dela clase Usuario
	 */
	public Usuario() {
	}//Cierre del constructor

	/**
	 * Constructor con par�metros de la clase Usuario
	 * @param nombre un String que almacena el nombre del cliente
	 * @param usuario un String que almacena el nombre de usuario del cliente y le permite hacer la validaci�n para ingresar a la ventana principal
	 * @param password un Sring que almacena la clave que elige el usuario y que le permitir� hacer la validci�n para ingresar a la ventana principal
	 * @param movil un long que almacena el n�mero de celular del cliente
	 * @param direccion un String que almacena la direcci�n de residencia del cliente
	 * @param ganaderia un String que almacena el nombre de la ganader�a de la que es due�o el cliente
	 * @param direccionGanaderia un String almacena la ubicacion de la ganader�a del cliente
	 * @param telefono un long que almacena el n�mero de telefono de la ganader�a
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
	}//Cierre del m�todo

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}//Cierre del m�todo

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}//Cierre del m�todo

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}//Cierre del m�todo

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}//Cierre del m�todo

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}//Cierre del m�todo

	/**
	 * @return the movil
	 */
	public long getMovil() {
		return movil;
	}//Cierre del m�todo

	/**
	 * @param movil the movil to set
	 */
	public void setMovil(long movil) {
		this.movil = movil;
	}//Cierre del m�todo

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}//Cierre del m�todo

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}//Cierre del m�todo

	/**
	 * @return the ganaderia
	 */
	public String getGanaderia() {
		return ganaderia;
	}//Cierre del m�todo

	/**
	 * @param ganaderia the ganaderia to set
	 */
	public void setGanaderia(String ganaderia) {
		this.ganaderia = ganaderia;
	}//Cierre del m�todo

	/**
	 * @return the direccionGanaderia
	 */
	public String getDireccionGanaderia() {
		return direccionGanaderia;
	}//Cierre del m�todo

	/**
	 * @param direccionGanaderia the direccionGanaderia to set
	 */
	public void setDireccionGanaderia(String direccionGanaderia) {
		this.direccionGanaderia = direccionGanaderia;
	}//Cierre del m�todo

	/**
	 * @return the telefono
	 */
	public long getTelefono() {
		return telefono;
	}//Cierre del m�todo

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}//Cierre del m�todo

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", usuario=" + usuario + ", password=" + password + ", movil=" + movil
				+ ", direccion=" + direccion + ", ganaderia=" + ganaderia + ", direccionGanaderia=" + direccionGanaderia
				+ ", telefono=" + telefono + "]";
	}//Cierre del m�todo


}//Fin de la clase
