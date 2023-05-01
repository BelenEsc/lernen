package lernen;

import java.awt.Rectangle;
import java.lang.module.ModuleDescriptor.Builder;
import java.security.KeyStore;

import javax.net.ssl.KeyStoreBuilderParameters;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class AtajadoTeclado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Marco17 marco17 = new Marco17();
	}

}

class Marco17 extends JFrame {
	public Marco17() {

		setTitle("Atajos de teclado");
		setBounds(new Rectangle(500, 500));
		setVisible(true);
		setDefaultCloseOperation(3);
		Lamina17 lamina17 = new Lamina17();
		add(lamina17);
	}
}

class Lamina17 extends JPanel {
	public Lamina17() {

		JMenuBar barraMenu = new JMenuBar();
		
		JMenuItem item1 = new JMenuItem("item1");
		
		KeyStore tecla = new KeyStore()
		
		
		item1.setAccelerator(tecla);
		
	}

}