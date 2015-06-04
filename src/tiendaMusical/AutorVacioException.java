/**
 * Paquete contenedor de las clases Producto, Disco, Libro, Merchandising, Soporte, G&eacute;nero, Cat&aacute;logo, Usuario, Interfaces y Excepciones.
 */
package tiendaMusical;

/**
 * Clase AutorVacioException
 */
public class AutorVacioException extends Exception {

	private static final long serialVersionUID = 1L;

	public AutorVacioException(String string) {
		super(string);
	}
}
