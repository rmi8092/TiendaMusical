/**
 * Paquete contenedor de las clases Producto, Disco, Libro, Merchandising, Soporte, G&eacute;nero, Cat&aacute;logo, Usuario, Interfaces y Excepciones.
 */
package tiendaMusical;

/**
 * Excepción lanzada en el caso de que el producto no exista.
 */
public class ProductoNoExisteException extends Exception {

	private static final long serialVersionUID = 1L;

	public ProductoNoExisteException(String message) {
		super(message);
	}
}
