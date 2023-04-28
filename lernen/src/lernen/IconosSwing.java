package lernen;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class IconosSwing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Marco13 marco13 = new Marco13();
	}

}

class Marco13 extends JFrame {

	public Marco13() {

		setTitle("iconos");
		setBounds(50, 50, 500, 500);
		setDefaultCloseOperation(3);
		setVisible(true);
		Lamina13 lamina13 = new Lamina13();
		add(lamina13);

	}
}

class Lamina13 extends JPanel {

	public Lamina13() {
		setLayout(new BorderLayout());
		ImageIcon icon = new ImageIcon(
				"https://www.google.de/images/branding/googlelogo/1x/googlelogo_light_color_272x92dp.png");
		ImageIcon icon2 = new ImageIcon("H://git//lernen//lernen//src//lernen//pngwing.com.png");
		JTextPane textField = new JTextPane();

		JMenuBar barraMenu = new JMenuBar();
		JMenu abrir = new JMenu("abrir");
		JMenuItem abrir1 = new JMenuItem("abrir2", icon2);
		abrir1.setHorizontalTextPosition(SwingConstants.LEFT);

		abrir.add(abrir1);
		barraMenu.add(abrir);
		add(barraMenu, BorderLayout.NORTH);
		add(textField);

	}

}
