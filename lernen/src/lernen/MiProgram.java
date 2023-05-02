package lernen;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class MiProgram {

	public static void main(String[] args) {

		Frame frame = new Frame();
	}
}

class Frame extends JFrame {
	public Frame() {
		setTitle("my program");
		setVisible(true);
		setDefaultCloseOperation(3);
		setBounds(50, 50, 600, 600);

		// set Icon
		String icon = new String("C://Users//belen//git//lernen//lernen//bin//Icons//logoDNA.gif");
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image img = kit.createImage(icon);
		setIconImage(img);
		
		
//		crear una lamina		
//		Layout layout = new Layout();
//		add(layout);

		// crear objetos que contengan caracteristicas y acciones. All crear un objeto
		// AbstractAcion se crea un elemento, se le pasa unos parametros "nombre"
		// "icono" y ya se define que es lo que va a hacer, o sea se crea un objeto, ahi
		// mismo se le pone a la escucha y se define q va a hacer. Es como una cajita q
		// llega todo.

		// accion cargar archivo 
		
		Action cargarArchivo = new AbstractAction("Open", new ImageIcon()) {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
		
				
		// accion salir
		
		Action exit = new AbstractAction("salir", new ImageIcon("H://git//lernen//lernen//src//icons//x.gif")) {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		};

		// crear menu
		JMenuBar menuBar = new JMenuBar();

		// elementos de menu

		JMenu menu = new JMenu("menu");

		// elementos de elementos de menu
		JMenuItem cargar = new JMenuItem(cargarArchivo); // esto en el futuro se va a reemplazar con un objeto accion
															// que haga algo

		// asignar elementos nivel 1
		menu.add(cargar);
		menu.addSeparator();
		menu.add(exit);

		// asignar elementos nivel 0
		menuBar.add(menu);

		// crear Toolbar

		JToolBar barraHerramientas = new JToolBar("tools");

		// anadir elementos a la toolbar

		barraHerramientas.add(exit);

		// anadir toolbar al marco

		add(barraHerramientas, BorderLayout.NORTH);

		// anadir elementos al marco y definirla como el menu principal 
		
		setJMenuBar(menuBar);

	}

}

class Layout extends JPanel {
	public Layout() {

		// disposicion
		setLayout(new BorderLayout());

	}

}