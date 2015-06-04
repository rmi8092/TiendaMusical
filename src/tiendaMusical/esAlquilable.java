/**
 * Paquete contenedor de las clases Producto, Disco, Libro, Merchandising, Soporte, G&eacute;nero, Cat&aacute;logo, Usuario, Interfaces y Excepciones.
 */
package tiendaMusical;

/**
 * Interface esAlquilable
 */
interface esAlquilable {

	/**
	 * Declaraci&oacute;n del m&eacute;todo para bajar los dias restantes al pr&eacute;stamo del libro.
	 */
	void bajarDiasRestantes();
	
	/**
	 * Declaraci&oacute;n del m&eacute;todo para activar la disponibilidad del libro.
	 */
	void libroDisponible();
	
	/**
	 * Declaraci&oacute;n del m&eacute;todo para calcular el precio de los productos vendibles.
	 */
	String calcularPrecio();
}
