package lernen;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class BarraMenu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Marco10 marco10 = new Marco10();
	}

}

class Marco10 extends JFrame {
	public Marco10() {

		setTitle("menu barras");
		setBounds(50, 50, 500, 500);
		setDefaultCloseOperation(3);
		setVisible(true);
		LaminaBarra laminaBarra = new LaminaBarra();
		add(laminaBarra);

	}
}

class LaminaBarra extends JPanel {

	public LaminaBarra() {

		JMenuBar barraMenu = new JMenuBar();
		JMenu elementoBarra0 = new JMenu("abrir");
		JMenuItem abrir1 = new JMenuItem("abrir1");

		JMenuItem abrir2 = new JMenuItem("abrir2");
		JMenuItem abrir3 = new JMenuItem("abrir3");
		JMenuItem abrir4 = new JMenuItem("abrir4");

		JMenu elementoBarra1 = new JMenu("opciones");
		JMenu opciones1 = new JMenu("opciones1");
		JMenuItem opciones11 = new JMenuItem("opciones1.1");
		JMenu opciones12 = new JMenu("opciones1.2");
		JMenuItem opciones121 = new JMenuItem("opciones1.2.1");
		JMenuItem opciones2 = new JMenuItem("opciones2");

		JMenu elementoBarra2 = new JMenu("ayuda");
		JMenuItem ayuda1 = new JMenuItem("ayuda1");
		JMenuItem ayuda2 = new JMenuItem("ayuda2");
		JMenuItem ayuda3 = new JMenuItem("ayuda3");

		JMenu elementoBarra3 = new JMenu("editar");
		JMenuItem editar1 = new JMenuItem("editar1");

		JMenu elementoBarra5 = new JMenu("cerrar");

		barraMenu.add(elementoBarra0);
		elementoBarra0.add(abrir1);
		elementoBarra0.add(abrir2);
		elementoBarra0.addSeparator();
		elementoBarra0.add(abrir3);
		elementoBarra0.add(abrir4);

		barraMenu.add(elementoBarra1);
		elementoBarra1.add(opciones2);
		elementoBarra1.add(opciones1);
		opciones1.add(opciones11);
		opciones1.add(opciones12);
		opciones12.add(opciones121);

		barraMenu.add(elementoBarra2);
		elementoBarra2.add(ayuda1);
		elementoBarra2.add(ayuda2);
		elementoBarra2.add(ayuda3);

		barraMenu.add(elementoBarra3);
		elementoBarra3.add(editar1);

		barraMenu.add(elementoBarra5);

		add(barraMenu);

	}

}