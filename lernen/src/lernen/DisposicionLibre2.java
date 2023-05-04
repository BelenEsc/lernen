package lernen;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DisposicionLibre2 {
	public static void main(String[] args) {
		Marco22 marco22 = new Marco22();
	}
}

class Marco22 extends JFrame {
	public Marco22() {

		setTitle("Mi propia disposicion");
		Lamina22 lamina22 = new Lamina22();
		add(lamina22);
		setBounds(50, 50, 800, 300);
		setDefaultCloseOperation(3);
		setVisible(true);
	}
}

class MiLayout2 implements LayoutManager {

	private int x;
	private int y =20;

	@Override
	public void addLayoutComponent(String name, Component comp) {

	}

	@Override
	public void removeLayoutComponent(Component comp) {
		// TODO Auto-generated method stub

	}

	@Override
	public Dimension preferredLayoutSize(Container parent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dimension minimumLayoutSize(Container parent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void layoutContainer(Container parent) {
		
		int d=parent.getWidth();
		x=d/2-100;
	    int conteo = 0;
	    int n = parent.getComponentCount();

	    for (int i = 0; i < n; i++) {

	        conteo++;
	        Component c = parent.getComponent(i);
	        c.setBounds(x, y, 100, 20);
	        x += 100;

	        if (conteo % 2 == 0) {
	        	x=d/2-100;
	            y += 100;
	        }
//	        if (x > size.width - 100) {
//	    	    x = parent.getWidth()/3;
//	    	    y = parent.getHeight()/3;
//	        }
	    }
	}
}

class Lamina22 extends JPanel {

	public Lamina22() {// TODO Auto-generated method stub

		setLayout(new MiLayout2());
		JLabel nombre = new JLabel("Nombre");
		JLabel apellido = new JLabel("Apellido");
		JLabel edad = new JLabel("Edad");

		JTextField nom = new JTextField(10);
		JTextField ape = new JTextField(10);
		JTextField ed = new JTextField(10);

		add(nombre);
		add(nom);
		add(apellido);
		add(ape);
		add(edad);
		add(ed);
	}

}
