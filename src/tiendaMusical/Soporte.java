/**
 * Paquete contenedor de las clases Producto, Disco, Libro, Merchandising, Soporte, G&eacute;nero, Cat&aacute;logo, Usuario, Interfaces y Excepciones.
 */
package tiendaMusical;

/**
 * Enumeraci&oacute;n Soporte
 */
public enum Soporte {
	/**
	 * Soporte CD
	 * @param categoria Musica
	 */
	CD(Categoria.MUSICA),
	/**
	 * Soporte MP3
	 * @param categoria Musica
	 */
	MP3(Categoria.MUSICA),
	/**
	 * Soporte Libro
	 * @param categoria Libro
	 */
	LIBRO(Categoria.LIBRO),
	/**
	 * Soporte Digital
	 * @param categoria Libro
	 */
	DIGITAL(Categoria.LIBRO),
	/**
	 * Soporte Camisetas
	 * @param categoria Merchandising
	 */
	CAMISETA(Categoria.MERCHANDISING),
	/**
	 * Soporte Gorras
	 * @param categoria Merchandising
	 */
	GORRA(Categoria.MERCHANDISING),
	/**
	 * Soporte Posters
	 * @param categoria Merchandising
	 */
	POSTER(Categoria.MERCHANDISING),
	/**
	 * Soporte Chapas
	 * @param categoria Merchandising
	 */
	CHAPA(Categoria.MERCHANDISING);
	
	/**
	 * Campo categoria
	 */
	private Categoria categoria;

	/**
	 * M&eacute;todo setter para asignar soporte a la categoria
	 * @param categoria La categoria correspondiente.
	 */
	private Soporte(Categoria categoria) {
		this.categoria = categoria;
	}

	/**
	 * M&eacute;todo getter para obtener la categoria.
	 * @return la categoria correspondiente.
	 */
	public Categoria getCategoria() {
		return categoria;
	}
}
