package lernen;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MiPropiaDisposicion {

	public static void main(String[] args) {
		Marco21 marco21 = new Marco21();
	}
}

class Marco21 extends JFrame {
	public Marco21() {
		setTitle("Mi propia disposicion");
		setVisible(true);
		setDefaultCloseOperation(3);
		setBounds(50, 50, 700, 700);

		Lamina21 lamina21 = new Lamina21();
		add(lamina21);

	}
}

class MiLayout implements LayoutManager {

	private int x = 20;
	private int y = 20;

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
		int conteo = 0;
		int n = parent.getComponentCount();

		for (int i = 0; i < n; i++) {

			conteo++;
			Component c = parent.getComponent(i);
			c.setBounds(x, y, 100, 20);
			x+=100;
			
			if (conteo%2==0) {
				x=20;
				y+=100;	
			}
		}
	}
}

class Lamina21 extends JPanel {


	public Lamina21() {// TODO Auto-generated method stub

		setLayout(new MiLayout());
		JLabel label1 = new JLabel("Nombre");
		JLabel label2 = new JLabel("Apellido");

		JTextField text1 = new JTextField(10);
		JTextField text2 = new JTextField(10);

	
		add(label1);
		add(text1);
		add(label2);
		add(text2);
	}

}
