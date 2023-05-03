package lernen;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DiposicionLibre {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Marco20 marco20 = new Marco20();
	}
}

class Marco20 extends JFrame {
	public Marco20() {
		setTitle("Disposicion Libre");
		setVisible(true);
		setDefaultCloseOperation(3);
		setBounds(50, 50, 700, 700);

		Lamina20 lamina20 = new Lamina20();
		add(lamina20);

	}
}

class Lamina20 extends JPanel {
	JButton boton1;
	JButton boton2;
	JButton boton3;

	public Lamina20() {

		setLayout(null);

		JLabel label1 = new JLabel("Nombre");
		JLabel label2 = new JLabel("Apellido");

		JTextField text1 = new JTextField(10);
		JTextField text2 = new JTextField(10);

		label1.setBounds(20, 20, 100, 20);
		text1.setBounds(100, 20, 100, 20);
		
		label2.setBounds(20, 50, 100, 20);
		text2.setBounds(100, 50, 100, 20);

		add(label1);
		add(label2);
		add(text1);
		add(text2);
		
	}
}
