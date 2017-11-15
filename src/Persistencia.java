import java.util.ArrayList;
import java.util.List;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;
import com.mongodb.MongoClient;
/**
 * Esta clase establece la conexi�n con la base de datos MongoDB y contiene los m�todo que permiten guardar y eliminar documentos. As� como obtener los datos para ser
 * usados por los m�todo del programa
 * @file Persistencia.java
 * @author Jos� Guillermo Qui��nez Castillo <qui17775@uvg.edu.gt>
 * @author Carlo Humberto Chew <che17507@uvg.edu.gt>
 * @date 15.11.2017
 */
public class Persistencia {
	private Datastore ds; //NoSQL Datastore
	private Datastore dsu; 
	private static String nombreDB;	
	
	/**
	 * Constructor de la clase persistencia
	 */
	public Persistencia() {
	}//Fin del constructor
	
	/**
	 * @return the nombreDB
	 */
	public static String getNombreDB() {
		return nombreDB;
	}

	/**
	 * @param nombreDB the nombreDB to set
	 */
	public static void setNombreDB(String nombreDB) {
		Persistencia.nombreDB = nombreDB;
	}

	/**
	 * Este m�todo establece la conexi�n con la base de datos especifica del usuario y crea el objeto ds que permitir� la interaccion entre Java y MongoDB
	 */
	public void Conexion() {
		MongoClient mongo = new MongoClient();
	    Morphia morphia = new Morphia();
	    morphia.map(Ganado.class).map(Usuario.class); // clases a guardar
	    ds = morphia.createDatastore(mongo, nombreDB); // Se establece la conexi�n con la base de datos
	}//Fin del m�todo
	
	/**
	 * Este m�todo establece la conexi�n con la base de datos Usuarios donde se persiste la informaci�n 
	 * de los usuarios registrados
	 */
	public void ConexionUsuarios() {
		MongoClient mongo = new MongoClient();
	    Morphia morphia = new Morphia();
	    morphia.map(Ganado.class).map(Usuario.class); // clases a guardar
	    dsu = morphia.createDatastore(mongo, "Usuarios"); // Se establece la conexi�n con la base de datos
	}//Fin del m�todo
	
	/**
	 * Este m�todo recibe como par�metro una instancia de la clase Ganado y la guarda en la base de datos
	 * @param res Ganado que se desea guardar
	 */
	public void GuardarRegistro(Ganado res) {
		ds.save(res); 
	}//Fin del m�todo
	
	/**
	 * Este m�todo recibe como par�metro un instancia de la clase Usuario y la guarda en la base de datos
	 * @param usuario Usuario que se desea Guardar
	 */
	public void GuardarUsuario(Usuario usuario) {
		dsu.save(usuario);
	}//Fin del m�todo
	
	/**
	 * Este m�todo permite consultaro los registros de la clase de Ganado que se encuentra en la base de datos para ser manipulados por el programa
	 * @return ganado ArrayList<Ganado> que contiene los objetos Ganado que se encuentran guardados en la base de datos
	 */
	public ArrayList<Ganado> ObtenerRegistros(){
		ArrayList<Ganado> registros = new ArrayList<Ganado>();
		Query<Ganado> query = ds.createQuery(Ganado.class); 
		List<Ganado> Miganado = query.asList();
		for (Ganado res: Miganado){
            registros.add(res); 
        }
		return registros; 
	}//Fin del m�todo
	
	/**
	 * Este m�todo permite consultaro los registros de la clase de Usuario que se encuentra en la base de datos
	 * @return usuarios ArrayList<Usuario> que contiene los objetos Usuario que se encuentran guardados en la base de datos para ser manipulados por el programa
	 */
	public ArrayList<Usuario> ObtenerUsuario(){
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		Query<Usuario> query = dsu.createQuery(Usuario.class); 
		List<Usuario> Miusuario = query.asList();
		for (Usuario u: Miusuario){
            usuarios.add(u);
        }
		return usuarios; 
	}//Fin del m�todo
	
	/**
	 * Este m�todo permite eliminar un registro (Documento) contenido en la base de datos
	 * @param ganado
	 */
	public void EliminarRegistroGanado(Ganado ganado) {
		ds.delete(ganado);
	}//Cierre del m�todo

}//Fin de la clase
