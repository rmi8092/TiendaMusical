/**
 * Paquete contenedor de las clases que implementan la interfaz gr&aacute;fica.
 * @author Rafa Miranda Ib&aacute;&nacute;ez
 * @version 1.0
 */
package gui;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;
import tiendaMusical.AccionFichero;
import tiendaMusical.Catalogo;
import tiendaMusical.DNINoValidoException;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

/**
 * Clase Principal
 */
public class Principal {
	/**
	 * Campo frame.
	 */
	private JFrame frame;
	/**
	 * Campo tienda.
	 */
	public static Tienda tienda = new Tienda();
	/**
	 * Campo annadirProducto.
	 */
	private AnnadirProducto annadirProducto;
	/**
	 * Campo frame.
	 */
	private EliminarProducto eliminarProducto;
	/**
	 * Campo buscarMusicaAutor.
	 */
	private BuscarMusica buscarMusica;
	/**
	 * Campo buscarLibrosAutor.
	 */
	private BuscarLibros buscarLibros;
	/**
	 * Campo buscarMerchandisingAutor.
	 */
	private BuscarMerchandising buscarMerchandising;
	/**
	 * Campo mostrarCatalogo.
	 */	
	private MostrarCatalogo mostrarCatalogo;
	/**
	 * Campo acercaDe.
	 */
	private AcercaDe acercaDe;
	/**
	 * Campo elegirUsuarioMostrarCarrito.
	 */
	private ElegirUsuarioMostrarCarrito elegirUsuarioMostrarCarrito;
	/**
	 * Campo barraMenu.
	 */
	private JMenuBar barraMenu;
	/**
	 * Campo archivo.
	 */
	private JMenu archivo;
	/**
	 * Campo archivoNuevo.
	 */
	private JMenuItem archivoNuevo;
	/**
	 * Campo abrir.
	 */
	private JMenuItem abrir;
	/**
	 * Campo guardar.
	 */
	private JMenuItem guardar;
	/**
	 * Campo guardarComo.
	 */
	private JMenuItem guardarComo;
	/**
	 * Campo separator.
	 */
	private JSeparator separator;
	/**
	 * Campo salir.
	 */
	private JMenuItem salir;
	/**
	 * Campo catalogo.
	 */
	private JMenu catalogo;
	/**
	 * Campo gestion.
	 */
	private JMenu gestion;
	/**
	 * Campo annadir.
	 */
	private JMenuItem annadir;
	/**
	 * Campo eliminar.
	 */
	private JMenuItem eliminar;
	/**
	 * Campo separator_1.
	 */
	private JSeparator separator_1;
	/**
	 * Campo buscar.
	 */
	private JMenu buscar;
	/**
	 * Campo musica.
	 */
	private JMenuItem musica;
	/**
	 * Campo libros.
	 */
	private JMenuItem libros;
	/**
	 * Campo merchandising.
	 */
	private JMenuItem merchandising;
	/**
	 * Campo separator_2.
	 */
	private JSeparator separator_2;
	/**
	 * Campo ayuda.
	 */
	private JMenu ayuda;
	/**
	 * Campo menuAcercaDe.
	 */
	private JMenuItem menuAcercaDe;
	/**
	 * Campo menuMostrarCatalogo.
	 */
	private JMenuItem menuMostrarCatalogo;
	/**
	 * Campo menuTienda.
	 */
	private JMenu menuTienda;
	/**
	 * Campo menuMostrarCarrito.
	 */
	private JMenuItem menuMostrarCarrito;
	/**
	 * Campo titulo.
	 */
	private AbstractButton titulo;
	/**
	 * Campo elegirTitulo.
	 */
	private ElegirTitulo elegirTitulo;
	/**
	 * Campo mnVerAyuda.
	 */
	private JMenu mnVerAyuda;
	/**
	 * Campo ayudaMostrarCatalogo.
	 */
	private AyudaMostrarCatalogo ayudaMostrarCatalogo;
	/**
	 * Campo ayudaBuscar.
	 */
	private AyudaBuscar ayudaBuscar;
	/**
	 * Campo ayudaTienda.
	 */
	private AyudaTienda ayudaTienda;
	/**
	 * Campo ayudaGestion.
	 */
	private AyudaGestion ayudaGestion;
	/**
	 * Campo parentComponent.
	 */
	private static Component parentComponent;
	/**
	 * Campo mntmGeneral.
	 */
	private JMenuItem mntmGeneral;
	/**
	 * Campo ayudaGeneral.
	 */
	private AyudaGeneral ayudaGeneral;
	
	/**
	 * Main de la aplicaci&oacute;n.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructor de la aplicaci&oacute;n.
	 * @throws DNINoValidoException 
	 */
	public Principal() throws DNINoValidoException {
		initialize();
		tienda = new Tienda();
	}

	/**
	 * Inicializa la aplicaci&oacute;n.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Tienda Musical");
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		Image img= new ImageIcon(this.getClass().getResource("/images/image.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(0, 0, 584, 340);
		frame.getContentPane().add(label);
		
		barraMenu = new JMenuBar();
		frame.setJMenuBar(barraMenu);
		
		archivo = new JMenu("Archivo");
		archivo.setMnemonic('A');
		barraMenu.add(archivo);
		
		archivoNuevo = new JMenuItem("Nuevo");
		archivoNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Tienda.modificado){
					Nuevo nuevo = new Nuevo();
					frame.setTitle("Sin titulo");
					nuevo.setVisible(true);
				}
				else{
					Nuevo.crearNuevoCatalogo();
					frame.setTitle("Sin titulo");
				}
			}
		});
		archivoNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		archivo.add(archivoNuevo);
		
		abrir = new JMenuItem("Abrir");
		abrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirArchivo();
			}
		});
		abrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		archivo.add(abrir);
		
		guardar = new JMenuItem("Guardar");
		guardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		guardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK));
		archivo.add(guardar);
		
		guardarComo = new JMenuItem("Guardar Como");
		guardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarComo();
			}
		});
		guardarComo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		archivo.add(guardarComo);
		
		separator = new JSeparator();
		archivo.add(separator);
		
		salir = new JMenuItem("Salir");
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int eleccion = JOptionPane.showConfirmDialog(parentComponent, "Confirma que desea salir del programa?",
						"Salir", JOptionPane.YES_NO_OPTION);
				if(eleccion == JOptionPane.YES_OPTION)
					System.exit(0);
				else
					return;
			}
		});
		salir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		archivo.add(salir);
		
		catalogo = new JMenu("Catalogo");
		catalogo.setMnemonic('T');
		barraMenu.add(catalogo);
		
		gestion = new JMenu("Gesti\u00F3n");
		gestion.setMnemonic('G');
		catalogo.add(gestion);
		
		annadir = new JMenuItem("A\u00F1adir");
		annadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				annadirProducto();
				Tienda.modificado = true;
			}
		});
		annadir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.ALT_MASK));
		gestion.add(annadir);
		
		eliminar = new JMenuItem("Eliminar");
		eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarProducto();
				Tienda.modificado = true;
			}
		});
		eliminar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.ALT_MASK));
		gestion.add(eliminar);
		
		menuTienda = new JMenu("Tienda");
		menuTienda.setMnemonic('T');
		catalogo.add(menuTienda);
		
		menuMostrarCarrito = new JMenuItem("Mostrar Carrito");
		menuMostrarCarrito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				elegirUsuarioMostrarCarrito();
			}
		});
		menuMostrarCarrito.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.SHIFT_MASK));
		menuTienda.add(menuMostrarCarrito);
		
		separator_1 = new JSeparator();
		catalogo.add(separator_1);
		
		buscar = new JMenu("Buscar");
		buscar.setMnemonic('B');
		catalogo.add(buscar);
		
		musica = new JMenuItem("Musica");
		musica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscarMusica();
			}
		});
		musica.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.ALT_MASK));
		buscar.add(musica);
		
		libros = new JMenuItem("Libros");
		libros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarLibros();
			}
		});
		libros.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.ALT_MASK));
		buscar.add(libros);
		
		merchandising = new JMenuItem("Merchandising");
		merchandising.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarMerchandising();
			}
		});
		merchandising.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_MASK));
		buscar.add(merchandising);
		
		titulo = new JMenuItem("Titulo");
		titulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarTitulo();
			}
		});
		buscar.add(titulo);
		
		separator_2 = new JSeparator();
		catalogo.add(separator_2);
		
		menuMostrarCatalogo = new JMenuItem("Mostrar Catalogo");
		menuMostrarCatalogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarCatalogo();
			}
		});
		menuMostrarCatalogo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.ALT_MASK));
		catalogo.add(menuMostrarCatalogo);
		
		ayuda = new JMenu("Ayuda");
		ayuda.setMnemonic('H');
		barraMenu.add(ayuda);
		
		mnVerAyuda = new JMenu("Ver Ayuda");
		mnVerAyuda.setMnemonic('V');
		ayuda.add(mnVerAyuda);
		
		JMenuItem mntmGestin = new JMenuItem("Gesti\u00F3n");
		mntmGestin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ayudaGestion();
			}
		});
		
		mntmGeneral = new JMenuItem("General");
		mntmGeneral.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.ALT_GRAPH_MASK));
		mntmGeneral.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ayudaGeneral();
			}
		});
		mnVerAyuda.add(mntmGeneral);
		
		mntmGestin.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.ALT_MASK));
		mnVerAyuda.add(mntmGestin);
		
		JMenuItem mntmTienda = new JMenuItem("Tienda");
		mntmTienda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ayudaTienda();
			}
		});
		mntmTienda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.ALT_MASK));
		mnVerAyuda.add(mntmTienda);
		
		JMenuItem mntmBuscar = new JMenuItem("Buscar");
		mntmBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ayudaBuscar();
			}
		});
		mntmBuscar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.ALT_MASK));
		mnVerAyuda.add(mntmBuscar);
		
		JMenuItem mntmMostrarCatlogo = new JMenuItem("Mostrar Cat\u00E1logo");
		mntmMostrarCatlogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ayudaMostrarCatalogo();
			}
		});
		mntmMostrarCatlogo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.ALT_MASK));
		mnVerAyuda.add(mntmMostrarCatlogo);
		
		menuAcercaDe = new JMenuItem("Acerca De");
		menuAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acercaDe();
			}
		});
		menuAcercaDe.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.ALT_MASK));
		ayuda.add(menuAcercaDe);
	}

	/**
	 * M&eacute;todo que guarda un archivo que ya ex&iacute;stia previamente o no. El programa detecta esta circunstancia.
	 */
	protected void guardar() {
		if(Tienda.guardado){
			try {
				AccionFichero.guardarComoFichero(Tienda.cartera.getCatalogo(), Tienda.seleccion);
				frame.setTitle(Tienda.seleccion.getName());
				Tienda.guardado = true;
				Tienda.modificado = false;
			} catch (IOException e) {
				JOptionPane.showMessageDialog(parentComponent, e, "Error.", JOptionPane.ERROR_MESSAGE);
			}
		}
		else {
			try {
				if(Tienda.seleccion != null){
					FileNameExtensionFilter filter = new FileNameExtensionFilter("*.obj", "obj");
					JFileChooser fileChooser = new JFileChooser();
					fileChooser.setFileFilter(filter);
			        int respuesta = fileChooser.showSaveDialog(null);
			        
			        if (respuesta == JFileChooser.APPROVE_OPTION)
			        	Tienda.seleccion = fileChooser.getSelectedFile();
			        if (respuesta == JFileChooser.CANCEL_OPTION){
			        	fileChooser.setVisible(false);
			        	return ;
			        }
					AccionFichero.guardarComoFichero(Tienda.cartera.getCatalogo(), Tienda.seleccion);
					frame.setTitle(Tienda.seleccion.getName());
					Tienda.guardado = true;
					Tienda.modificado = false;
				}
				else
					JOptionPane.showMessageDialog(guardarComo, "Debe indicar el nombre con el que desea guardar el archivo");
			} catch (IOException e) {
				JOptionPane.showMessageDialog(parentComponent, e, "Error.", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	/**
	 * M&eacute;todo que guarda un archivo nuevo que no ex&iacute;stia previamente.
	 */
	protected void guardarComo() {
		try {
			FileNameExtensionFilter filter = new FileNameExtensionFilter("*.obj", "obj");
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setFileFilter(filter);
	        int respuesta = fileChooser.showSaveDialog(null);
	        
	        if (respuesta == JFileChooser.APPROVE_OPTION)
	        	Tienda.seleccion = fileChooser.getSelectedFile();
	        if (respuesta == JFileChooser.CANCEL_OPTION){
	        	fileChooser.setVisible(false);
	        	return ;
	        }
			if(Tienda.seleccion != null){
				AccionFichero.guardarComoFichero(Tienda.cartera.getCatalogo(), Tienda.seleccion);
				frame.setTitle(Tienda.seleccion.getName());
				Tienda.guardado=true;
				Tienda.modificado = false;
			}
			else
				JOptionPane.showMessageDialog(guardarComo, "Debe indicar el nombre con el que desea guardar el archivo");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(parentComponent, e, "Error.", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * M&eacute;todo que abre un archivo ya guardado previamente.
	 */
	protected void abrirArchivo() {
		try {
			AbrirArchivo abrir= new AbrirArchivo();
			if(Tienda.seleccion == null)
				return;
			else {
				Tienda.cartera.setCatalogo((Catalogo)AccionFichero.abrirFichero(Tienda.seleccion));
				frame.setTitle(Tienda.seleccion.getName());
				Tienda.guardado=true;
			}
		} catch(ClassNotFoundException | IOException e1){
			JOptionPane.showMessageDialog(parentComponent, e1, "Error.", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * M&eacute;todo que abre la ventana para a&nacute;adir un producto.
	 */
	protected void annadirProducto() {
		annadirProducto = new AnnadirProducto();
		annadirProducto.setVisible(true);
	}
	
	/**
	 * M&eacute;todo que abre la ventana para eliminar un producto.
	 */
	protected void eliminarProducto() {
		eliminarProducto = new EliminarProducto();
		eliminarProducto.setVisible(true);
	}
	
	/**
	 * M&eacute;todo que abre la ventana para buscar m&uacute;sica.
	 */
	protected void buscarMusica() {
		buscarMusica = new BuscarMusica();
		buscarMusica.setVisible(true);
	}

	/**
	 * M&eacute;todo que abre la ventana para buscar libros.
	 */
	protected void buscarLibros() {
		buscarLibros = new BuscarLibros();
		buscarLibros.setVisible(true);
	}
	
	/**
	 * M&eacute;todo que abre la ventana para buscar merchandising.
	 */
	protected void buscarMerchandising() {
		buscarMerchandising = new BuscarMerchandising();
		buscarMerchandising.setVisible(true);
	}
	
	/**
	 * M&eacute;todo que abre la ventana para buscar por t&iacute;tulo.
	 */
	protected void buscarTitulo() {
		elegirTitulo = new ElegirTitulo();
		elegirTitulo.setVisible(true);
	}
	
	/**
	 * M&eacute;todo que abre la ventana para elegir el usuario del que mostrar su carrito.
	 */
	protected void elegirUsuarioMostrarCarrito() {
		elegirUsuarioMostrarCarrito = new ElegirUsuarioMostrarCarrito();
		elegirUsuarioMostrarCarrito.setVisible(true);
	}
	
	/**
	 * M&eacute;todo que abre la ventana para mostrar el c&aacute;talogo al completo.
	 */
	protected void mostrarCatalogo() {
		mostrarCatalogo = new MostrarCatalogo();
		mostrarCatalogo.setVisible(true);
	}
	
	/**
	 * M&eacute;todo que abre la ventana para obtener ayuda general sobre la aplicaci&oacute;n Tienda Musical.
	 */
	protected void ayudaGeneral() {
		ayudaGeneral = new AyudaGeneral();
		ayudaGeneral.setVisible(true);
	}
	
	/**
	 * M&eacute;todo que abre la ventana para obtener ayuda sobre la visualizaci&oacute;n del cat&aacute;logo.
	 */
	protected void ayudaMostrarCatalogo() {
		ayudaMostrarCatalogo = new AyudaMostrarCatalogo();
		ayudaMostrarCatalogo.setVisible(true);
	}

	/**
	 * M&eacute;todo que abre la ventana para obtener ayuda sobre la b&uacute;squeda de productos en el cat&aacute;logo.
	 */
	protected void ayudaBuscar() {
		ayudaBuscar = new AyudaBuscar();
		ayudaBuscar.setVisible(true);
	}

	/**
	 * M&eacute;todo que abre la ventana para obtener ayuda sobre la gesti&oacute;n de la tienda.
	 */
	protected void ayudaTienda() {
		ayudaTienda = new AyudaTienda();
		ayudaTienda.setVisible(true);
	}

	/**
	 * M&eacute;todo que abre la ventana para obtener ayuda sobre la gesti&oacute;n del cat&aacute;logo.
	 */
	protected void ayudaGestion() {
		ayudaGestion = new AyudaGestion();
		ayudaGestion.setVisible(true);
	}
	
	/**
	 * M&eacute;todo que abre la ventana para informarse acerca del autor.
	 */
	protected void acercaDe() {
		acercaDe = new AcercaDe();
		acercaDe.setVisible(true);
	}
}
