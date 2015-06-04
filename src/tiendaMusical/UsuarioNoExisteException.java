/**
 * Paquete contenedor de las clases Producto, Disco, Libro, Merchandising, Soporte, G&eacute;nero, Cat&aacute;logo, Usuario, Interfaces y Excepciones.
 */
package tiendaMusical;

/**
 * Excepción lanzada en el caso de que el usuario no exista en su cartera de clientes.
 */
public class UsuarioNoExisteException extends Exception {

	private static final long serialVersionUID = 1L;

	public UsuarioNoExisteException(String message) {
		super(message);
	}
}
