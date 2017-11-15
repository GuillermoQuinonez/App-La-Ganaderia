import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JFrame;
/**
 * ControlGanaderia contiene los m�todo que permiten cumplir con los requisitos funcionales del programa manipulando arreglos que contienen el registro de animales en la gander�a
 * y usuarios que emplean el programa. Permite guardar, obtener, editar y eliminar los registros de los bovinos de la gander�a. Tambi�n crear, editar y autenticar a los usuarios y sus contrase�as
 * para lograr ingresar al programa. 
 * @file ControlGanaderia.java
 * @author Jos� Guillermo Qui��nez Castillo (qui17775@uvg.edu.gt)
 * @author Carlo Humberto Chew (che17507@uvg.edu.gt)
 * @date 14.11.2017
 */
public class ControlGanaderia {
	private ArrayList<Ganado> ganado; 
	private Persistencia persistencia;
	private ArrayList<Usuario> usuarios; 
	private static int indice; 
	
	/**
	 * Constructor sin par�metros de la clase, incializa los arreglos que contienen la informaci�n que manipula el programa y la clase que interact�a con el modelo 
	 * de persistencia de datos
	 */
	public ControlGanaderia() { 
		ganado = new ArrayList<Ganado>(); 
		persistencia = new Persistencia();
		usuarios = new ArrayList<Usuario>(); 
		
	}//Cierre del constructor
	
	/**
	 * @return the ganado
	 */
	public ArrayList<Ganado> getGanado() {
		Registros(); 
		return ganado;
	}//Cierre del m�todo 

	/**
	 * @param ganado the ganado to set
	 */
	public void setGanado(ArrayList<Ganado> ganado) {
		this.ganado = ganado;
	}//Cierre del m�todo
	
	/**
	 * @return the usuarios
	 */
	public ArrayList<Usuario> getUsuarios() {
		RegistroUsuarios(); 
		return usuarios;
	}//Cierre del m�todo

	/**
	 * @param usuarios the usuarios to set
	 */
	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}//Cierre del m�todo

	/**
	 * @return the indice
	 */
	public static int getIndice() {
		return indice;
	}//Cierre del m�todo

	/**
	 * @param indice the indice to set
	 */
	public static void setIndice(int indice) {
		ControlGanaderia.indice = indice;
	}//Cierre del m�todo

	/**
	 * Este m�todo establece la conexi�n con el modelo de persistencia de datos 
	 */
	public void Conectar() {
		persistencia.Conexion();
	}//Cierre del m�todo
	
	/**
	 * El m�todo recibe como par�metros los atributos de la clase Ganaderia. Crea una nueva isntancia de la clase y utiliza un m�todo de la clase que permite la persistencia
	 * para guardar el objeto creado. 
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
	public void CrearGanado(String Nombre, int Numero, String Propietario, String FechaNac, String Sexo, String Color, float Peso, String Procedencia, String Progenitor, String Progenitora, String Estado, float ProduccionLechera, float GananciaPeso, String Historial) {
		Ganado res = new Ganado(Nombre, Numero, Propietario, FechaNac, Sexo, Color, Peso, Procedencia, Progenitor, Progenitora, Estado, ProduccionLechera, GananciaPeso, Historial ); 
		persistencia.GuardarRegistro(res);
	}//Cierre del m�todo
	
	/**
	 * El m�todo recibe como par�metro una instancia de la clase Ganado y valores para todos sus atributos. Actualiza los atributos con estos nuevos valores y utiliza 
	 * un m�todo de la clase que permite la persistencia de datos para guardar los cambios. 
	 * @param ganado Ganado es la instancia de la clase que se actualizar� 
	 * @param nombre String que almacena el nombre del bovino
	 * @param numero int que almacena el n�mero de correlaci�n que identifica al bovino en el registro de la gander�a
	 * @param propietario String que almacena el nombre del propietario del bovino
	 * @param fechaNac String que alamacena la fecha de nacimiento del bovino
	 * @param sexo String que contiene el sexo del bovino (Macho o Hembra)
	 * @param color String que contiene el color que pelaje del bovino
	 * @param peso float que contiene el peso del bovino en libras
	 * @param procedencia String que indica cu�l es la ganader�a de origen de la res
	 * @param progenitor String que contiene el nombre del padre
	 * @param progenitora String que contiene el nombre de la madre
	 * @param estado String que almacena el estado del animal, es decir, a qu� grupo de la gander�a pertence (Engorde, Producci�n Lechera, Enfermer�a, Preparto u Otro)
	 * @param produccionLechera float que almacena la cantidad de leche que est� produciendo una vaca en producci�n lechera
	 * @param gananciaPeso float que almacena las libras que un bovino en engorde ha ganado desde la �ltima pesa. 
	 * @param historial String que contiene diversas antoaciones que pueden ser relevantes en la historia del animal para llevar un mejor registros de su productividad.
	 */
	public void ActualizarInformacion(Ganado ganado, String nombre, int numero, String propietario, String fechaNac, String sexo, String color, float peso, String procedencia, String progenitor, String progenitora, String estado, float produccionLechera, float gananciaPeso, String historial) {
		ganado.setNombre(nombre);
		ganado.setNumero(numero);
		ganado.setPropietario(propietario);
		ganado.setFechaNac(fechaNac);
		ganado.setSexo(sexo);
		ganado.setColor(color);
		ganado.setPeso(peso);
		ganado.setProcedencia(procedencia);
		ganado.setProgenitor(progenitor);
		ganado.setProgenitora(progenitora);
		ganado.setEstado(estado);
		ganado.setProduccionLechera(produccionLechera);
		ganado.setGananciaPeso(gananciaPeso);
		ganado.setHistorial(historial);
		persistencia.GuardarRegistro(ganado);
	}//Cierre del m�todo
	
	/**
	 * El m�todo permite recuperar los datos persistidos y almacenarlos en el arreglo destinado para alojar los objetos de la clase Ganado
	 */
	public void Registros(){
		 ganado = persistencia.ObtenerRegistros();
	}//Cierre del m�todo
	
	/**
	 * Este m�todo permite recuperar los datos persistidos como un arreglo ordenado de forma particular. Recibe como par�metros do enteros, un �ndice que indica la forma 
	 * en la que se desea ordenado el arreglo con los datos del ganado. Para ordenar el arreglo por nombre se utiliza el m�todo compareTo sobrescrito al implementar la interfaz
	 * Comparable. Para odernar por medio de N�mero, Producci�n Lechera y Ganancia de Peso se utilizan tres clase que implementan la interfaz Comparator. El numero permite no tiene
	 * relevancia al ordenar los datos, pero permite obtener un arreglo que contiene la informaci�n del bovino que se identifica con ese n�mero y con ello permitir b�squedas por medio
	 * de este atributo.  
	 * @param indice int que indica la forma en la que se ordenar�n los elementos en el arreglo
	 * @param numero int que permite buscar y devolver la informaci�n del bovino identificado por este n�mero
	 * @return ganado de tipo ArrayList<Ganado> es el arreglo con la informaci�n ordenada
	 */
	public ArrayList<Ganado> ObtenerDatos(int indice, int numero){
		Registros();
		if(indice == 0) {
			Collections.sort(ganado, new OrdenarPorNumero());
		}
		else if(indice == 1) {
			Collections.sort(ganado);
		}
		else if(indice == 2) {
			ArrayList<Ganado> temp = new ArrayList<Ganado>();
			for(Ganado g: ganado) {
				if(g.getEstado().equals("Producci�n Lechera")) {
					temp.add(g);
				}
			}
			ganado = temp;
			Collections.sort(ganado, new OrdenarPorPLechera());
			
		}
		else if(indice == 3) {
			ArrayList<Ganado> temp = new ArrayList<Ganado>();
			for(Ganado g: ganado) {
				if(g.getEstado().equals("Engorde")) {
					temp.add(g);
				}
			}
			ganado = temp;
			Collections.sort(ganado, new OrdenarPorGPeso());
		}
		else if(indice == 5) {
			ArrayList<Ganado> temp = new ArrayList<Ganado>();
			for(Ganado g: ganado) {
				if(g.getNumero() == numero) {
					temp.add(g);
				
				}
			}
			ganado = temp;
			
		}
		return ganado;
	}//Cierre del m�todo
	
	public void EliminarGanado(String id) {
		Registros(); 
		for(Ganado g: ganado) {
			System.out.println("Hola");
			if(g.getId().toString().equals(id)) {
				persistencia.EliminarRegistroGanado(g);
			}
		}
		
	}

	/**
	 * El m�todo cuenta el n�mero de reces que est�n en cada uno de los estados posibles de la Ganader�a y los almacena en un arreglo. Este arreglo permitir� construir 
	 * el gr�fico de pastel que permite analizar como se distribuyen los animales en los diferentes estados. 
	 * @return datos un arreglo de int que contiene el n�mero de registros que hay en cada uno de los estados. 
	 */
	public int[] Dataset() {
		Registros();
		int[] datos = new int[5];
		int otros = 0; 
		int engorde = 0; 
		int produccionlechera = 0;
		int preparto = 0; 
		int enfermeria = 0; 
		for(Ganado g: ganado) {
			if(g.getEstado().equals("Otro")) otros++;
			if(g.getEstado().equals("Engorde")) engorde++;
			if(g.getEstado().equals("Producci�n Lechera")) produccionlechera++;
			if(g.getEstado().equals("Preparto")) preparto++; 
			if(g.getEstado().equals("Enfermer�a")) enfermeria++; 
		}
		datos[0] = otros; 
		datos[1] = engorde; 
		datos[2] = produccionlechera;
		datos[3] = preparto;
		datos[4] = enfermeria; 
		return datos; 
		
	}//Cierre del m�todo
	
	/**
	 * Este m�todo recibe como par�metros valores para los atributos de un Usurio. Crea una nueva intancia de la clase Usuario y utilia un m�todo de la clase que interact�a 
	 * con el m�todo de persistencia para guardar el objeto creado. 
	 * @param nombre un String que almacena el nombre del cliente
	 * @param usuario un String que almacena el nombre de usuario del cliente y le permite hacer la validaci�n para ingresar a la ventana principal
	 * @param password un Sring que almacena la clave que elige el usuario y que le permitir� hacer la validci�n para ingresar a la ventana principal 
	 * @param movil un long que almacena el n�mero de celular del cliente
	 * @param direccion un String que almacena la direcci�n de residencia del cliente
	 * @param ganaderia un String que almacena el nombre de la ganader�a de la que es due�o el cliente
	 * @param direccionGanaderia un String almacena la ubicacion de la ganader�a del cliente
	 * @param telefono un long que almacena el n�mero de telefono de la ganader�a
	 */
	public void CrearUsuario(String nombre, String usuario, String password, long movil, String direccion, String ganaderia, String direccionGanaderia, long telefono) {
		Usuario Usuario = new Usuario(nombre, usuario, password, movil, direccion, ganaderia, direccionGanaderia, telefono);
		persistencia.GuardarUsuario(Usuario);
	}//Cierre del m�todo
	
	/**
	 * El m�todo recibe como par�metro una instancia de la clase Usuario y valores para todos sus atributos. Actualiza los atributos con estos nuevos valores y utiliza 
	 * un m�todo de la clase que permite la persistencia de datos para guardar los cambios
	 * @param Usuario instancia de la clase Usuario a cual se actualizar�n los datos
	 * @param nombre un String que almacena el nombre del cliente
	 * @param usuario un String que almacena el nombre de usuario del cliente y le permite hacer la validaci�n para ingresar a la ventana principal
	 * @param password un Sring que almacena la clave que elige el usuario y que le permitir� hacer la validci�n para ingresar a la ventana principal 
	 * @param movil un long que almacena el n�mero de celular del cliente
	 * @param direccion un String que almacena la direcci�n de residencia del cliente
	 * @param ganaderia un String que almacena el nombre de la ganader�a de la que es due�o el cliente
	 * @param direccionGanaderia un String almacena la ubicacion de la ganader�a del cliente
	 * @param telefono un long que almacena el n�mero de telefono de la ganader�a
	 */
	public void ActualizarUsuario(Usuario Usuario, String nombre, String usuario, String password, long movil, String direccion, String ganaderia, String direccionGanaderia, long telefono) {
		Usuario.setNombre(nombre);
		Usuario.setUsuario(usuario);
		Usuario.setPassword(password);
		Usuario.setMovil(movil);
		Usuario.setDireccion(direccion);
		Usuario.setGanaderia(ganaderia);
		Usuario.setDireccionGanaderia(direccionGanaderia);
		Usuario.setTelefono(telefono);
		persistencia.GuardarUsuario(Usuario);
	}//Cierre del m�todo
	
	/**
	 * M�todo que permite recuperar la informaci�n de los Usuarios y almacenarlos en el arreglo destinado para contener este tipo de Objetos
	 */
	public void RegistroUsuarios() {
		usuarios = persistencia.ObtenerUsuario();
	}//Cierre del m�todo
	
	
	/**
	 * Este m�todo recibe como par�metros un nombre de usuario y una contrase�a. Busca en el arreglo de Usuarios si hay alguna instancia que coinciden con estos valores y devuelven 
	 * true si lo encuentra, false en caso contrario. 
	 * @param usuario String que indica el nombre de usuario ingresado por el cliente
	 * @param password Sring que indica la contrase�a ingresada por el usuario
	 * @return boolean (true o false) depende si se encuentra o no coincidencia entre el usuario y password ingresados y un usuario y password registrado
	 */
	public boolean AutenticarIngreso(String usuario, String password) {
		RegistroUsuarios(); 
		for (Usuario u: usuarios) {
			if(u.getUsuario().equals(usuario) && u.getPassword().equals(password)) {
				PerfilUsuario.setUsuario(u);
				return true; 
			}
		}
		return false; 
	}//Cierre del m�todo

	/**
	 * Este m�todo recibe dos cantidades, una cantidad antigua (ya sea peso o produccion lechera) y la nueva actualizaci�n. Compara las cantidades y devuelve 1 si la cantidad nueva es mayor, 
	 * 2 si es menor o 0 si ambas son iguales. 
	 * @param Nueva float que indica el nuevo valor ingresado del cantidad
	 * @param Antigua float que indica la cantidad guardada de la cantida 
	 * @return i int que indica si la nueva cantidad es mayor, menor o igual
	 */
	public int CantidadMayor(float Nueva, float Antigua) {
		int i = 0; 
		if(Nueva > Antigua) {
			i = 1; 
		}
		if(Nueva < Antigua) {
			i = 2; 
		}
		return i; 
	}//Cierre del m�todo
	
	/**
	 * Este m�todo recibe dos cantidades, una cantidad antigua (ya sea peso o produccion lechera) y la nueva actualizaci�n. Y encuentra la diferencia entre estas, devuelve el valor. 
	 * @param Nueva float que indica el nuevo valor ingresado del cantidad
	 * @param Antigua float que indica la cantidad guardada de la cantida 
	 * @return Cambio float indica que la diferencia entre la cantidad ingresada y la cantidad que ya estaba guardada
	 */
	public float CambioCantidad(float Nueva, float Antigua) {
		float Cambio = Nueva - Antigua;
		return Cambio;
	}//Cierre del m�todo
	
	/**
	 * Este m�todo permite abriri el JFrame del principal y cerrar el JFrame desde el que se le llam�
	 * @param vista JFrame que llama al m�todo y que es cerrado por el m�todo
	 */
	public void regresar(JFrame vista) {
		Principal principal = new Principal();
		principal.setVisible(true);
		principal.setLocationRelativeTo(null);
		vista.setVisible(false);  
	}//Cierre del m�todo
	
} //Fin de la clase ControlGanaderia
