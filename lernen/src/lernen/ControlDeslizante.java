package lernen;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ControlDeslizante {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Marco8 marco8 = new Marco8();
	}

}

class Marco8 extends JFrame {
	public Marco8() {

		setTitle("Control Deslizante");
		setBounds(50, 50, 400, 400);
		setVisible(true);
		setDefaultCloseOperation(3);
		Lamina8 lamina8 = new Lamina8();
		add(lamina8);
	}

}

class Lamina8 extends JPanel {

	public Lamina8() {

		setLayout(new BorderLayout());

		JSlider slider = new JSlider(8, 50, 12); // valor minimo, valos maximo, donde comienza

		slider.setOrientation(SwingConstants.HORIZONTAL);// orientaicion
		slider.setMajorTickSpacing(10);// las rayitas grandes
		slider.setMinorTickSpacing(5);// las rayitas cortitas
		slider.setPaintLabels(true);// poner los valores de las rayitas
		slider.setPaintTicks(true); // poner las rayitas en el plano
		slider.setFont(new Font("Arial", Font.ITALIC, 8));// fuente
		slider.setSnapToTicks(true);// iman

		JPanel panelSlider = new JPanel();
		JLabel texto = new JLabel("un texto equis");

		panelSlider.add(slider);
		add(panelSlider, BorderLayout.NORTH);
		add(texto, BorderLayout.CENTER); // anadir

		ChangeListener instrucciones = new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				int fuente = slider.getValue();

				texto.setFont(new Font("Arial", Font.BOLD, fuente));
			}
		};
		slider.addChangeListener(instrucciones);

	}

}