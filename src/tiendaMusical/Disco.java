/**
 * Paquete contenedor de las clases Producto, Disco, Libro, Merchandising, Soporte, G&eacute;nero, Cat&aacute;logo, Usuario, Interfaces y Excepciones.
 */
package tiendaMusical;

import gui.Tienda;

/**
 * Clase Disco
 */
public class Disco extends Producto implements esVendible {

	private static final long serialVersionUID = 1L;
	/**
	 * Campo g&eacute;nero
	 */
	private Genero genero;
	/**
	 * Campo constante n&uacute;mero de escuchas m&aacute;ximas al mes
	 */
	private static final int ESCUCHAS_MAXIMAS_MES = 3;
	/**
	 * Campo n&uacute;mero de escuchas restantes del mes
	 */
	private int escuchasMesRestantes;
	/**
	 * Campo n&uacute;mero de canciones en el disco
	 */
	private String numeroCanciones;
	/**
	 * Campo discoEscuchable
	 */
	private boolean discoEscuchable = true;

	/**
	 * Construye instancias de la clase Disco para añadir a carrito (incluyendo escuchasMesRestantes).
	 * @param autor al que pertenece el disco.
	 * @param categoria la categoria a la que pertenece el disco.
	 * @param soporte el soporte del producto.
	 * @param fechaLanzamiento fecha de lanzamiento del disco.
	 * @param precio el precio del disco.
	 * @param distribuidora la distribuidora, discografica o editorial del producto.
	 * @param t&iacute;tulo el t&iacute;tulo del disco.
	 * @param g&eacute;nero el g&eacute; del disco.
	 * @param escuchasMesRestantes el n&uacute;mero de escuchas que quedan en el mes.
	 * @param numeroCanciones el n&uacute;mero de canciones del disco.
	 * @throws FechaNoValidaException
	 * @throws NumeroCancionesException 
	 * @throws PrecioNoValidoException 
	 * @throws DistribuidoraVacioException 
	 * @throws AutorVacioException 
	 * @throws TituloVacioException 
	 */
	public Disco(String titulo, String autor, Categoria categoria,
			Soporte soporte, String fechaLanzamiento, String precio,
			String distribuidora, Genero genero, int escuchasMesRestantes,
			String numeroCanciones) throws TituloVacioException, AutorVacioException, FechaNoValidaException, DistribuidoraVacioException,
			NumeroCancionesException, PrecioNoValidoException {
		super(titulo, autor, categoria, soporte, fechaLanzamiento, precio,
				distribuidora);
		setGenero(genero);
		setEscuchasMesRestantes(escuchasMesRestantes);
		setNumeroCanciones(numeroCanciones);
	}

	/**
	 * Construye instancias de la clase Disco para añadir a catalogo (sin incluir escuchasMesRestantes).
	 * @param autor al que pertenece el disco.
	 * @param categoria la categoria a la que pertenece el disco.
	 * @param soporte el soporte del producto.
	 * @param fechaLanzamiento fecha de lanzamiento del disco.
	 * @param precio el precio del disco.
	 * @param distribuidora la distribuidora, discografica o editorial del producto.
	 * @param t&iacute;tulo el t&iacute;tulo del disco.
	 * @param g&eacute;nero el g&eacute; del disco.
	 * @param numeroCanciones el n&uacute;mero de canciones del disco.
	 * @throws FechaNoValidaException
	 * @throws NumeroCancionesException 
	 * @throws PrecioNoValidoException 
	 * @throws DistribuidoraVacioException 
	 * @throws AutorVacioException 
	 * @throws TituloVacioException 
	 */
	public Disco(String titulo, String autor, Categoria categoria,
			Soporte soporte, String fechaLanzamiento, String precio,
			String distribuidora, Genero genero, String numeroCanciones)
			throws TituloVacioException, AutorVacioException, FechaNoValidaException, DistribuidoraVacioException,
			NumeroCancionesException, PrecioNoValidoException {
		super(titulo, autor, categoria, soporte, fechaLanzamiento, precio,
				distribuidora);
		setGenero(genero);
		setNumeroCanciones(numeroCanciones);
	}

	/**
	 * M&eacute;todo getter para obtener el g&eacute;nero del disco.
	 * @return el g&eacute;nero del disco
	 */
	public Genero getGenero() {
		return genero;
	}

	/**
	 * M&eacute;todo setter para asignar el g&eacute;nero al disco.
	 * @param g&eacute;nero del disco
	 */
	private void setGenero(Genero genero) {
		this.genero = genero;
	}

	/**
	 * M&eacute;todo getter para obtener el n&uacute;mero de escuchas restantes en el mes.
	 * @return el n&uacute;mero de escuchas restantes el mes en curso.
	 */
	public int getEscuchasMesRestantes() {
		return escuchasMesRestantes;
	}

	/**
	 * M&eacute;todo setter para asignar el n&uacute;mero de escuchas restantes en el mes.
	 * @param n&uacute;mero de escuchas restantes el mes en curso.
	 */
	private void setEscuchasMesRestantes(int escuchasMesRestantes) {
		if (getEscuchasMesRestantes() == 0)
			setDiscoEscuchable(false);
		this.escuchasMesRestantes = escuchasMesRestantes;
	}

	/**
	 * M&eacute;todo getter para obtener el n&uacute;mero de canciones del disco.
	 * @return el n&uacute;mero de canciones del disco
	 */
	public String getNumeroCanciones() {
		return numeroCanciones;
	}

	/**
	 * M&eacute;todo setter para asignar el n&uacute;mero de canciones del disco.
	 * @param n&uacute;mero de canciones del disco
	 * @throws NumeroCancionesException
	 */
	private void setNumeroCanciones(String numeroCanciones)throws NumeroCancionesException {
		if (numeroCanciones.equals(""))
			throw new NumeroCancionesException(
					"Debe introducir un numero de caciones");
		this.numeroCanciones = numeroCanciones;
	}

	/**
	 * M&eacute;todo getter para obtener si el disco puede seguir escuch&aacute;ndose gratis en el mes en curso o no.
	 * @return si el disco puede seguir escuch&aacute;ndose.
	 */
	public boolean isDiscoEscuchable() {
		return discoEscuchable;
	}

	/**
	 * M&eacute;todo setter para asignar si el disco puede seguir escuch&aacute;ndose gratis en el mes en curso o no.
	 * @param si el disco puede seguir escuch&aacute;ndose.
	 */
	public void setDiscoEscuchable(boolean discoEscuchable) {
		this.discoEscuchable = discoEscuchable;
	}

	// _______________________COMPORTAMIENTO__________________________

	/**
	 * M&eacute;todo que descuenta escuchas al disco
	 */
	public void descontarEscuchas() {
		setEscuchasMesRestantes(getEscuchasMesRestantes() - 1);
	}

	/**
	 * M&eacute;todo que resetea las escuchas al disco
	 */
	public void resetearEscuchas() {
		setEscuchasMesRestantes(ESCUCHAS_MAXIMAS_MES);
	}

	/**
	 * M&eacute;todo que convierte al cliente en premium y le otorga escuchas ilimitadas.
	 */
	public void comprarPremium() {
		Usuario.clientePremium = true;
		setDiscoEscuchable(true);
	}

	/**
	 * M&eacute;todo sobrescrito desde interface para calcular el precio del disco en funci&oacute;n de si es cliente premium o no.
	 */
	@Override
	public String calcularPrecio() {
		String precio = "";
		if (Tienda.usuarioSeleccionado.isClientePremium()) {
			precio = Double.toString((Double.parseDouble(getPrecio()) * 0.8));
			return precio;
		} else {
			precio = getPrecio();
			return precio;
		}
	}
}
