package lernen;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Cajas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Marco18 marco18 = new Marco18();

	}

}

class Marco18 extends JFrame {
	public Marco18() {

		setTitle("Cajas");
		setVisible(true);
		setDefaultCloseOperation(3);
		setBounds(50, 50, 700, 700);

		Box cajaMadre = Box.createVerticalBox();

		Box caja1 = Box.createHorizontalBox();
		Box caja2 = Box.createHorizontalBox();
		Box caja3 = Box.createHorizontalBox();

		JLabel nombre = new JLabel("hola");
		JTextField nom = new JTextField(20);
		nom.setMaximumSize(nom.getPreferredSize());
		JLabel password = new JLabel("pass");
		JPasswordField pass = new JPasswordField(20);
		pass.setMaximumSize(pass.getPreferredSize());

		JButton ok = new JButton("ok");
		JButton cancel = new JButton("cancel");

		caja1.add(nombre);
		caja1.add(Box.createHorizontalStrut(50));
		caja1.add(nom);

		caja2.add(password);
		caja2.add(Box.createHorizontalStrut(50));
		caja2.add(pass);
		
		caja3.add(ok);
		caja3.add(Box.createGlue());
		caja3.add(cancel);
		
		cajaMadre.add(caja1,BorderLayout.NORTH);
		cajaMadre.add(caja2,BorderLayout.CENTER);
		cajaMadre.add(caja3,BorderLayout.SOUTH);

		add(cajaMadre, BorderLayout.CENTER);
	}

}

class Caja1 {

}
