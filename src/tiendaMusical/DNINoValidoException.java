/**
 * Paquete contenedor de las clases Producto, Disco, Libro, Merchandising, Soporte, G&eacute;nero, Cat&aacute;logo, Usuario, Interfaces y Excepciones.
 */
package tiendaMusical;

/**
 * Excepción lanzada en el caso de que el DNI del usuario no sea v&aacute;lido.
 */
public class DNINoValidoException extends Exception {

	private static final long serialVersionUID = 1L;

	public DNINoValidoException(String message) {
		super(message);
	}
}
