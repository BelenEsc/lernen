package lernen;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GeneradorFasta {

	public static void main(String[] args) {

		Marco2 marco = new Marco2();
		marco.setDefaultCloseOperation(3);
		marco.setVisible(true);
	}
}

class Marco2 extends JFrame {

	JMenuBar barraMenu2 = new JMenuBar();
	JMenu menu = new JMenu("menu");
	JMenuItem itemAbrir = new JMenuItem("abrir");
	public Marco2() {
		setTitle("Generador Fasta");
		setBounds(50, 50, 500, 500);

		Action exit = new AbstractAction("Salir") {
			@Override
			public void actionPerformed(ActionEvent e) {

				System.exit(0);

			}
		};

		// crear menu
		barraMenu2.add(itemAbrir);



	}
}
