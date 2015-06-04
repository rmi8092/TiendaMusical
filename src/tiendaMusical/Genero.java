/**
 * Paquete contenedor de las clases Producto, Disco, Libro, Merchandising, Soporte, G&eacute;nero, Cat&aacute;logo, Usuario, Interfaces y Excepciones.
 */
package tiendaMusical;
/**
 * Enumeraci&oacute;n G&eacute;nero
 */
public enum Genero {
	/**
	 * G&eacute;nero Rock
	 * @param categoria Musica
	 */
	ROCK(Categoria.MUSICA),
	/**
	 * G&eacute;nero Pop
	 * @param categoria Musica
	 */
	POP(Categoria.MUSICA),
	/**
	 * G&eacute;nero Jazz
	 * @param categoria Musica
	 */
	JAZZ(Categoria.MUSICA),
	/**
	 * G&eacute;nero Indie-Alternative
	 * @param categoria Musica
	 */
	INDIE_ALTERNATIVE(Categoria.MUSICA),
	/**
	 * G&eacute;nero Otros
	 * @param categoria Musica
	 */
	OTROS(Categoria.MUSICA),
	/**
	 * G&eacute;nero Biograf&iacute;a
	 * @param categoria Libro
	 */
	BIOGRAFIA(Categoria.LIBRO),
	/**
	 * G&eacute;nero Aprendizaje
	 * @param categoria Libro
	 */
	APRENDIZAJE(Categoria.LIBRO),
	/**
	 * G&eacute;nero Historia de un g&eacute;nero
	 * @param categoria Libro
	 */
	HISTORIA_GENERO(Categoria.LIBRO);
	
	/**
	 * Campo categoria
	 */
	private Categoria categoria;

	/**
	 * M&eacute;todo setter para asignar g&eacute;nero a la categoria
	 * @param categoria La categoria correspondiente.
	 */
	private Genero(Categoria categoria) {
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
