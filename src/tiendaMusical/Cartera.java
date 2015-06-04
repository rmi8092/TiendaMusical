/**
 * Paquete contenedor de las clases Producto, Disco, Libro, Merchandising, Soporte, G&eacute;nero, Cat&aacute;logo, Usuario, Interfaces y Excepciones.
 */
package tiendaMusical;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 * Clase Tienda
 */
public class Cartera {
	/**
	 * Campo catalogo.
	 */
	private Catalogo catalogo;
	/**
	 * Campo usuarioPremium.
	 */
	static private Usuario usuarioPremium;
	/**
	 * Campo usuarioStandard.
	 */
	static private Usuario usuarioStandard;
	/**
	 * Campo contenedor.
	 */
	private Component contenedor;
	
	/**
	 * Construye instancias de la clase Tienda.
	 */
	public Cartera(){
		this.catalogo = new Catalogo();
		try {
			usuarioPremium = new Usuario("Rafa", "52368412D", true);
		} catch (DNINoValidoException e) {
			JOptionPane.showMessageDialog(contenedor, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		try {
			usuarioStandard = new Usuario("Pedro", "21452256F", false);
		} catch (DNINoValidoException e) {
			JOptionPane.showMessageDialog(contenedor, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * M&eacute;todo que devuelve el usuario premium
	 * @return el usuario premium
	 */
	public Usuario getUsuarioPremium() {
		return usuarioPremium;
	}

	/**
	 * M&eacute;todo que asigna la tipolog&iacute;a premium al usuario
	 * @param usuarioPremium El usuario premium
	 */
	public void setUsuarioPremium(Usuario usuarioPremium) {
		this.usuarioPremium = usuarioPremium;
	}

	/**
	 * M&eacute;todo que devuelve el usuario estandard
	 * @return el usuario estandard
	 */
	public Usuario getUsuarioStandard() {
		return usuarioStandard;
	}

	/**
	 * M&eacute;todo que asigna la tipolog&iacute;a estandard al usuario
	 * @param usuarioEstandard El usuario estandard
	 */
	public void setUsuarioStandard(Usuario usuarioStandard) {
		this.usuarioStandard = usuarioStandard;
	}
	
	/**
	 * M&eacute;todo que devuelve el cat&aacute;logo
	 * @return el cat&aacute;logo
	 */
	public Catalogo getCatalogo() {
		return catalogo;
	}

	/**
	 * M&eacute;todo que asigna el cat&aacute;logo
	 * @param cat&aacute;logo El cat&aacute;logo
	 */
	public void setCatalogo(Catalogo catalogo) {
		this.catalogo = catalogo;
	}

}

