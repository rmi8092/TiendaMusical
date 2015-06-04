/**
 * Paquete contenedor de las clases Producto, Disco, Libro, Merchandising, Soporte, G&eacute;nero, Cat&aacute;logo, Usuario, Interfaces y Excepciones.
 */
package tiendaMusical;

import java.util.regex.Pattern;

/**
 * Clase Usuario
 */
public class Usuario {
	/**
	 * Campo nombre
	 */
	private String nombre;
	/**
	 * Campo patr&oacute;n de DNI
	 */
	private static final Pattern patronDNI = Pattern.compile("^[0-9]{8}[-\\s]?[A-Z]$");
	/**
	 * Campo DNI
	 */
	private String DNI;
	/**
	 * Campo cliente premium
	 */
	private boolean clientePremium = true;
	/**
	 * Campo carrito
	 */
	private Catalogo carrito;
	
	/**
	 * Construye instancias de la clase Usuario
	 * @param nombre el nombre del usuario
	 * @param DNI el DNI del usuario
	 * @throws DNINoValidoException 
	 * @throws UsuarioVacioException 
	 */
	public Usuario(String nombre, String DNI, boolean clientePremium) throws DNINoValidoException {
		setNombre(nombre);
		setDNI(DNI);
		setClientePremium(clientePremium);
		setCarrito(new Catalogo());
	}
	
	/**
	 * Construye instancias de la clase Usuario solo con DNI
	 * @param DNI el DNI del usuario
	 * @throws DNINoValidoException 
	 */
	public Usuario(String DNI) throws DNINoValidoException {
		setDNI(DNI);
	}
	
	/**
	 * M&eacute;todo getter para obtener el nombre del usuario.
	 * @return el nombre del usuario.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * M&eacute;todo setter para asignar nombre al usuario.
	 * @param nombre del usuario
	 * @throws UsuarioVacioException 
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * M&eacute;todo que comprueba si el DNI del usuario es v&aacute;lido seg&uacute;n el patr&oacute;n creado.
	 * @param DNI del producto.
	 * @return true si el DNI es v&aacute;lida, false en caso contrario.
	 */
	private static boolean dniValido(String DNI) {
		return patronDNI.matcher(DNI).matches();
	}

	/**
	 * M&eacute;todo setter para asignar DNI al usuario.
	 * @param DNI del usuario
	 * @throws DNINoValidoException 
	 */
	private void setDNI(String dNI) throws DNINoValidoException {
		if(dniValido(dNI))
			this.DNI = dNI;
		else
			throw new DNINoValidoException("El DNI introducido no es valido");
	}
	
	/**
	 * M&eacute;todo getter para obtener si el usuario tiene categor&iacute;a premium.
	 * @return clientePremium Si el usuario es premium o no
	 */
	public boolean isClientePremium() {
		return clientePremium;
	}

	/**
	 * M&eacute;todo setter para asignar al usuario categor&iacute;a premium.
	 * @param clientePremium Si el usuario es premium o no
	 */
	public static void setClientePremium(boolean clientePremium) {
		clientePremium = clientePremium;
	}
	
	/**
	 * M&eacute;todo getter para obtener el carrito del usuario.
	 * @return el carrito del usuario
	 */
	public Catalogo getCarrito() {
		return carrito;
	}

	/**
	 * M&eacute;todo setter para asignar el carrito al usuario.
	 * @param carrito El carrito del usuario
	 */
	public void setCarrito(Catalogo carrito) {
		this.carrito = carrito;
	}
	
	/**
	 * Devuelve el producto del cat&aacute;logo indicado a trav&aecute;s del &iacute;ndice.
	 * @param &iacute;ndice el &iacute;ndice del producto a buscar
	 * @return el producto contenido en el cat&aacute;logo, o null si no existe.
	 */
	public Producto get(int index) {
		if(carrito.size() > 0)
			return null;
		if(index < 0 | index > carrito.size()-1)
			return null;
		return carrito.get(index);
	}
}
