package lernen;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BarraDespleglabe {

	public static void main(String[] args) {

		Marco7 marco7 = new Marco7();
	}

}

class Marco7 extends JFrame {
	public Marco7() {
		setTitle("Barra desplegable");
		setBounds(50, 50, 300, 300);
		setDefaultCloseOperation(3);
		setVisible(true);
		Lamina7 lamina7 = new Lamina7();
		add(lamina7);
	}

}

class Lamina7 extends JPanel {
	JLabel textoPlano;
	JComboBox cuadroDesplegable;

	public Lamina7() {

		setLayout(new BorderLayout());
		JPanel textoCambiar = new JPanel();
		JPanel desplegable = new JPanel();

		textoPlano = new JLabel("aqui hay un texto equis");
		textoPlano.setFont(new Font("Arial", Font.PLAIN, 22));
		cuadroDesplegable = new JComboBox();

		cuadroDesplegable.addItem("Serif");
		cuadroDesplegable.addItem("Comic Sans MS");
		cuadroDesplegable.addItem("Impact");
		cuadroDesplegable.addItem("Lucida Bright");
		cuadroDesplegable.addItem("Dialog");
		cuadroDesplegable.addItem("Verdana");
		cuadroDesplegable.addItem("Century Gothic");
		cuadroDesplegable.addItem("Book Antiqua");
		cuadroDesplegable.addItem("Cambria");
		cuadroDesplegable.addItem("Garamond");
		cuadroDesplegable.addItem("Franklin Gothic Medium");
		cuadroDesplegable.addItem("Rockwell");

		Instrucciones7 instrucciones7 = new Instrucciones7();
		cuadroDesplegable.addActionListener(instrucciones7);

		desplegable.add(cuadroDesplegable);

		textoCambiar.add(textoPlano);

		add(textoCambiar, BorderLayout.SOUTH);
		add(desplegable, BorderLayout.NORTH);

	}

	class Instrucciones7 implements ActionListener {
		public Instrucciones7() {
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			textoPlano.setFont(new Font((String) cuadroDesplegable.getSelectedItem(), Font.PLAIN, 22));
		}

	}

}