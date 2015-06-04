/**
 * Paquete contenedor de las clases Producto, Disco, Libro, Merchandising, Soporte, G&eacute;nero, Cat&aacute;logo, Usuario, Interfaces y Excepciones.
 */
package tiendaMusical;

/**
 * Excepción lanzada en el caso de que el usuario ya exista.
 */
public class UsuarioYaExisteException extends Exception {

	private static final long serialVersionUID = 1L;

	public UsuarioYaExisteException(String message) {
		super(message);
	}
}