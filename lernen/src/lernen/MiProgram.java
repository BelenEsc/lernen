package lernen;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

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
		Layout layout = new Layout();
		add(layout);
	}

}

class Layout extends JPanel {
	public Layout() {

		// disposicion
		setLayout(new BorderLayout());

		// crear menu
		JMenuBar menuBar = new JMenuBar();

		// elementos de menu
		JMenu abrir = new JMenu("abrir");

		// elementos de elementos de menu
		JMenuItem cargar = new JMenuItem("cargar archivo");

		// asignar elementos nivel 1
		abrir.add(cargar);

		// asignar elementos nivel 0
		menuBar.add(abrir);

		// anadir elementos a la lamina
		add(menuBar, BorderLayout.NORTH);

	}

}