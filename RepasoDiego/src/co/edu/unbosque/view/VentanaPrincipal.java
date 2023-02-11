/**
 * 
 */
package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author Nicolas Machado
 * 
 *         Ventana principal de la interfaz grafica
 */
public class VentanaPrincipal extends JFrame {

	/**
	 * Panel que contiene el menu
	 */
	private PanelMenu pMenu;

	/**
	 * Panel que muestra la informacion
	 */
	private PanelInformacion pI;

	/**
	 * Icono para el programa
	 */
	private ImageIcon logo;

	/**
	 * Relleno de estetica
	 */
	private Relleno rll;
	/**
	 * fondo
	 */
	private JLabel fondo;

	/**
	 * Metodo constructor <b>pre</b> La existencia de los atributos <br>
	 * <b>post</b> La ventana es creada <br>
	 */
	public VentanaPrincipal() {

		setTitle("recursos humanos");
		setSize(1280, 700);
		JLabel fondo = new JLabel(new ImageIcon("imagenes/Fondo.png"));
		fondo.setLayout(new BorderLayout());
		setContentPane(fondo);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		icono();

		inicializarComponentes();

		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	/**
	 * Metodo para establecer un icono para el programa <b>pre</b> Una imagen
	 * existente en la carpeta <br>
	 * <b>post</b> Se establece un icono <br>
	 */
	private void icono() {
		logo = new ImageIcon("imagenes/aydua.png");
		setIconImage(logo.getImage());

	}

	/**
	 * Metodo para inicializar los atributos <b>pre</b> Los atributos y el espacio
	 * suficiente para agregarlos <br>
	 * <b>post</b> Los atributos son inicializados y añadidos <br>
	 */
	private void inicializarComponentes() {
		pI = new PanelInformacion();
		pMenu = new PanelMenu();
		rll = new Relleno();
	

		add(pMenu, BorderLayout.WEST);
		add(pI, BorderLayout.CENTER);
		add(rll, BorderLayout.EAST);

	}

	/**
	 * Obtiene el panel menu y sus componentes
	 * 
	 * @return the pMenu
	 */
	public PanelMenu getPMenu() {
		return pMenu;
	}

	/**
	 * Asigna el panel menu
	 * 
	 * @param pMenu the pMenu to set
	 */
	public void setPMenu(PanelMenu pMenu) {
		this.pMenu = pMenu;
	}

	/**
	 * Obtiene el panel de informacion y sus componentes
	 * 
	 * @return the pI
	 */
	public PanelInformacion getPI() {
		return pI;
	}

	/**
	 * Asigna el panel informacion
	 * 
	 * @param pI the pI to set
	 */
	public void setPI(PanelInformacion pI) {
		this.pI = pI;
	}

}
