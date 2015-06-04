/**
 * Paquete contenedor de las clases Producto, Disco, Libro, Merchandising, Soporte, G&eacute;nero, Cat&aacute;logo, Usuario, Interfaces y Excepciones.
 */
package tiendaMusical;

/**
 * Excepción lanzada en el caso de que el precio del producto no sea v&aacute;lido.
 */
public class PrecioNoValidoException extends Exception {

	private static final long serialVersionUID = 1L;

	public PrecioNoValidoException(String string) {
		super(string);
	}

}
