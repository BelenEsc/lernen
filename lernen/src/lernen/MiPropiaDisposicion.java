package lernen;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
		
	}




}

class Lamina21 extends JPanel {
	JButton boton1;
	JButton boton2;
	JButton boton3;

	public Lamina21() {// TODO Auto-generated method stub

	}

}
