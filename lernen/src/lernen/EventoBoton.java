package lernen;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EventoBoton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoBoton marcoBoton = new MarcoBoton();
	}

}

class MarcoBoton extends JFrame {
	public MarcoBoton() {
		setTitle("evento Boton");
		setDefaultCloseOperation(3);
		setVisible(true);
		setBounds(20, 20, 200, 200);
		LaminaBoton laminaBoton = new LaminaBoton();
		add(laminaBoton);
	}

}

class LaminaBoton extends JPanel {
	JButton botonAzul, botonRojo, botonverde, botonnegro;

	public LaminaBoton() {

		// JPanel fondoLamina = new JPanel();

		botonAzul = new JButton("azul");
		botonRojo = new JButton("rojo");
		botonverde = new JButton("verde");
		botonnegro = new JButton("negro");

		InstruccionesBotones instucciones = new InstruccionesBotones();

		botonAzul.addActionListener(instucciones);
		botonRojo.addActionListener(instucciones);
		botonverde.addActionListener(instucciones);
		botonnegro.addActionListener(instucciones);
		
		add(botonAzul);
		add(botonRojo);
		add(botonverde);
		add(botonnegro);
//		add(fondoLamina);
	}

	private class InstruccionesBotones implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == botonAzul) {
				setBackground(Color.blue);
			} else if (e.getSource() == botonRojo) {
				setBackground(Color.RED);
			} else if (e.getSource() == botonverde) {
				setBackground(Color.GREEN);
			} else if (e.getSource() == botonnegro) {
				setBackground(Color.BLACK);
			}
		}
	}
}
