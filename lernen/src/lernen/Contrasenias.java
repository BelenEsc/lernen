package lernen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import javax.swing.text.html.BlockView;

public class Contrasenias {

	public static void main(String[] args) {

		Marco3 marco3 = new Marco3();

	}

}

class Marco3 extends JFrame {

	public Marco3() {

		setBounds(50, 50, 500, 500);
		setTitle("contrasenias");
		setVisible(true);
		setDefaultCloseOperation(3);
		Lamina3 lamina3 = new Lamina3();
		add(lamina3);
	}

}

class Lamina3 extends JPanel {

	private JPasswordField textoPassword;
	private JButton aceptar;

	public Lamina3() {

		setLayout(new BorderLayout());
		JPanel panelEmail = new JPanel();
		JPanel panelPassword = new JPanel();

		panelEmail.setLayout(new FlowLayout());
		panelPassword.setLayout(new FlowLayout());

		JTextField textoEmail = new JTextField("Email", 10);
		textoPassword = new JPasswordField("", 10);

		Document puente = textoPassword.getDocument();
		Docu instrucciones = new Docu();
		puente.addDocumentListener(instrucciones);

		JLabel pongaEmail = new JLabel("ponga su email");
		JLabel pongaPassword = new JLabel("ponga su password");
		aceptar = new JButton("aceptar");

		panelEmail.add(pongaEmail);
		panelEmail.add(textoEmail);
		panelPassword.add(pongaPassword);
		panelPassword.add(textoPassword);

		add(panelEmail, BorderLayout.NORTH);
		add(panelPassword, BorderLayout.CENTER);
		add(aceptar, BorderLayout.SOUTH);
	}

	class Docu implements DocumentListener {

		public Docu() {

		}

		@Override
		public void insertUpdate(DocumentEvent e) {

			char[] contrasena;
			contrasena = textoPassword.getPassword();

			if (contrasena.length < 6 || contrasena.length > 12) {
				aceptar.setBackground(Color.blue);
			} else {
				aceptar.setBackground(Color.black);
			}
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			char[] contrasena;
			contrasena = textoPassword.getPassword();

			if (contrasena.length < 6 || contrasena.length > 12) {
				aceptar.setBackground(Color.blue);
			} else {
				aceptar.setBackground(Color.black);
			}
		}

		@Override
		public void changedUpdate(DocumentEvent e) {

		}

	}
}
