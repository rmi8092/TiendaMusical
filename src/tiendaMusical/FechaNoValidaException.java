/**
 * Paquete contenedor de las clases Producto, Disco, Libro, Merchandising, Soporte, G&eacute;nero, Cat&aacute;logo, Usuario, Interfaces y Excepciones.
 */
package tiendaMusical;

/**
 * Excepción lanzada en el caso de que la fecha de lanzamiento del producto no sea v&aacute;lida.
 */
public class FechaNoValidaException extends Exception {

	private static final long serialVersionUID = 1L;

	public FechaNoValidaException(String message) {
		super(message);
	}
}

