package lernen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AreaTexto {

	public static void main(String[] args) {
		Marco4 marco4 = new Marco4();

	}

}

class Marco4 extends JFrame {

	public Marco4() {

		setBounds(50, 50, 500, 500);
		setTitle("Area de texto");
		setVisible(true);
		setDefaultCloseOperation(3);
		Lamina4 lamina4 = new Lamina4();
		add(lamina4);
	}

}

class Lamina4 extends JPanel {
	JTextArea area;

	public Lamina4() {

		area = new JTextArea(8, 20);
		JScrollPane laminax = new JScrollPane(area);
		area.setLineWrap(true);

		JButton boton = new JButton("aceptar");
		add(laminax);
		add(boton);

		GestionaArea gestionaArea = new GestionaArea();
		boton.addActionListener(gestionaArea);

	}

	class GestionaArea implements ActionListener {

		public GestionaArea() {

		}

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(area.getText());

		}

	}

}
