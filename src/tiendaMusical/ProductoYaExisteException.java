/**
 * Paquete contenedor de las clases Producto, Disco, Libro, Merchandising, Soporte, G&eacute;nero, Cat&aacute;logo, Usuario, Interfaces y Excepciones.
 */
package tiendaMusical;

/**
 * Excepción lanzada en el caso de que el producto ya exista en el cat&aacute;logo.
 */
public class ProductoYaExisteException extends Exception {

	private static final long serialVersionUID = 1L;

	public ProductoYaExisteException(String message) {
		super(message);
	}
}
