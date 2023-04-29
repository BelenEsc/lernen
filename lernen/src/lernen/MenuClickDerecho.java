package lernen;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;

public class MenuClickDerecho {

	public static void main(String[] args) {

		Marco15 marco15 = new Marco15();

	}

}

class Marco15 extends JFrame {
	public Marco15() {
		setTitle("menu de click derecho");
		setBounds(50, 50, 500, 500);
		setDefaultCloseOperation(3);
		setVisible(true);
		Lamina15 lamina15 = new Lamina15();
		add(lamina15);
	}
}

class Lamina15 extends JPanel {
	public Lamina15() {

		setLayout(new BorderLayout());
		
		JPanel laminaBarra = new JPanel();
		JMenuBar barraMenu = new JMenuBar();
		JMenu menu = new JMenu("abrir");
		JMenuItem abrir1 = new JMenuItem("abrir2");
		
		JTextField texto = new JTextField();
		
		menu.add(abrir1);
		barraMenu.add(menu);
		
		
		
		

		JPopupMenu popMenu = new JPopupMenu();
		JMenuItem menu1 = new JMenuItem("menu 1");
		JMenuItem menu2 = new JMenuItem("menu 2");
		JMenuItem menu3 = new JMenuItem("menu 3");
		JMenuItem menu4 = new JMenuItem("menu 4");

		popMenu.add(menu1);
		popMenu.add(menu2);
		popMenu.add(menu3);
		popMenu.add(menu4);

		texto.setComponentPopupMenu(popMenu);
		laminaBarra.add(barraMenu);
		add(laminaBarra,BorderLayout.NORTH);
		add(texto,BorderLayout.CENTER);
	}
}