package lernen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CasillaVerificacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Marco5 marco5 = new Marco5();

	}

}

class Marco5 extends JFrame {

	public Marco5() {

		setBounds(50, 50, 200, 200);
		setTitle("casilla de check");
		setVisible(true);
		setDefaultCloseOperation(3);
		Lamina5 lamina5 = new Lamina5();
		add(lamina5);
	}
}

class Lamina5 extends JPanel {
	boolean selected = false;

	JCheckBox boxCursiva;
	JCheckBox boxNegrita;
	JTextField texto;

	public Lamina5() {

		setLayout(new BorderLayout());

		JPanel panelTexto = new JPanel();
		JPanel panelCasillas = new JPanel();

		panelTexto.setLayout(new FlowLayout());
		panelCasillas.setLayout(new FlowLayout());

		Font miLetra = new Font("Serif", Font.PLAIN, 12);

		JLabel label = new JLabel("un texto");

		texto = new JTextField("este es un texto eski", 20);

		texto.setFont(miLetra);

		panelTexto.add(label);
		panelTexto.add(texto);

		boxCursiva = new JCheckBox("Cursiva");
		boxNegrita = new JCheckBox("Negrita");

		panelCasillas.add(boxCursiva);
		panelCasillas.add(boxNegrita);

		Escucha escucha = new Escucha();
		boxCursiva.addActionListener(escucha);
		boxNegrita.addActionListener(escucha);

		add(panelTexto, BorderLayout.NORTH);
		add(panelCasillas, BorderLayout.CENTER);
	}

	class Escucha implements ActionListener {

		public Escucha() {

		}

		@Override
		public void actionPerformed(ActionEvent e) {                                                                            

			if (boxNegrita.isSelected()) {
				if (boxCursiva.isSelected()) {
					texto.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 12)); // en vez de ponerle Font.BOLD + Font.ITALIC tb se puede poner la variable 3 q es la q alica las dos 
				} else {
					texto.setFont(new Font("Arial", Font.BOLD, 12));
				}
			} else if (boxCursiva.isSelected() && !boxNegrita.isSelected()) {
				texto.setFont(new Font("Arial", Font.ITALIC, 12));
			} else {
				texto.setFont(new Font("Arial", Font.PLAIN, 12));
			}
		}

	}
}