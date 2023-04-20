package lernen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

		c

	}

	private class DameTexto implements ActionListener {
		public DameTexto() {
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(campo.getText().trim());
		}
	}
}
