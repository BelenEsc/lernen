package lernen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PruebaTexto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoText marcoTexto = new MarcoText();
	}

}

class MarcoText extends JFrame {

	public MarcoText() {

		setBounds(100, 100, 300, 350);
		setDefaultCloseOperation(3);
		setVisible(true);
		setTitle("texto");

		Layer lamina = new Layer();
		add(lamina);
	}

}

class Layer extends JPanel {

	private JTextField campo;

	public Layer() {

		campo = new JTextField(6);
		add(campo);
		JButton boton1 = new JButton("aceptar");
		DameTexto mievento = new DameTexto();
		boton1.addActionListener(mievento);
		add(boton1);

	}

	private class DameTexto implements ActionListener {
		public DameTexto() {

		}

		@Override
		public void actionPerformed(ActionEvent e) {
			String result = campo.getText().trim();

			Integer positionPoint = null;
			Integer positionArroba = null;
			boolean point = false;
			boolean arroba = false;
			int countpoint = 0;
			int countarroba = 0;

			for (int i = 0; i < result.length(); i++) {
				if (result.charAt(i) == '.') {
					countpoint++;
					positionPoint = i;
				}
				if (result.charAt(i) == '@') {
					countarroba++;
					positionArroba = result.indexOf("@");
				}
			}
			if (countpoint != 0 && countarroba == 1) {
				if (positionArroba != null && positionPoint != null && positionArroba < positionPoint
						&& positionArroba != 0) {
					System.out.println("correo valido");
				} else {
					System.out.println("correo invalido1");
				}
			} else {
				System.out.println("correo invalido2");
			}
		}
	}
}