/**
 * Paquete contenedor de las clases Producto, Disco, Libro, Merchandising, Soporte, G&eacute;nero, Cat&aacute;logo, Usuario, Interfaces y Excepciones.
 */
package tiendaMusical;

/**
 * Interfaz esVendible
 */
interface esVendible {

	/**
	 * Declaraci&oacute;n del m&eacute;todo para calcular el precio de los productos vendibles.
	 */
	String calcularPrecio(String precio);
	
}
