package errores;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PruebaEmail {
	public static void main(String[] args) { // TODO Auto-generated method stub
		MarcoText marcoTexto = new MarcoText();
		marcoTexto.setDefaultCloseOperation(3);
	}
}

class MarcoText extends JFrame {

	public MarcoText() {

		setBounds(600, 300, 600, 350);
		setTitle("Error en contrasenia");
		Layer lamina = new Layer();
		add(lamina);
		setVisible(true);
	}

}

class Layer extends JPanel {

	private JTextField campo;
	private JLabel output;

	public Layer() {

		setLayout(new BorderLayout()); // con este metodo estamos dividiendo la capa Layer en 5 partes, a,i,d,a,centro

		JPanel arriba = new JPanel(); // crear una nueva capa
		arriba.setLayout(new FlowLayout()); // en esta capa. setearle un layout de tipo flowlayout q es en una misma
											// fila. quiere decir que todos los elementos que se anadan a esta capa van
											// a tener una alineacion en una fila la sitaxis es
											// objetoSobreElQueSeQuiereHacerAlgo.loQueSeLeQuiereHacer(UsandoQue)

		JLabel etiqueta = new JLabel("introducir el correo"); // se crea otra capa con texto;
		arriba.add(etiqueta); // a la capa "arriba" addear la etiqueta. como arriba se ha descrito, este
								// elemento anadido a la capa se va a alinear en una fila con todos los demas q
								// se le agrege a esta capa
		campo = new JTextField(20); // se crea un recuadro de texto de tamanio 6
		arriba.add(campo); // a la capa "arriba tb se le agrega este elemento

		JButton boton1 = new JButton("aceptar"); // se crea un boton q se tiene como texto aceptar
		arriba.add(boton1); // se le agrega este elemento a la capa "arriba" tb

		DameTexto mievento = new DameTexto(); // crear un objeto de tipo ActionListener por que el metodo
												// addactionlistener NECESITA un objeto de ese tipo con todas las
		boton1.addActionListener(mievento); // sobre el boton1. la accion a ejecutar es click y se le pasa las
											// lleva el metodo actionperformed
		output = new JLabel("", JLabel.CENTER); // JLabel es una capa para agregar texto. Se inicia sin texto y ubicado
												// en el centro
		add(output, BorderLayout.CENTER); // finalmente se dice que posicion va a tener la capa output( que es un solo
											// texto)
		add(arriba, BorderLayout.NORTH); // se dice que posicion va a tener la capa arriba que contiene 3 elementos

	}

	private class DameTexto implements ActionListener {
		public DameTexto() {
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			Integer positionPoint = null;
			Integer positionArroba = null;
			boolean point = false;
			boolean arroba = false;
			int countpoint = 0;
			int countarroba = 0;

			String result = campo.getText().trim();

			try {
				extracted(positionPoint, positionArroba, countpoint, countarroba, result);
			} catch (LongitudMailErrornea r) {
				r.printStackTrace();
				System.out.println("esta muy corto");

			}
		}

		private void extracted(Integer positionPoint, Integer positionArroba, int countpoint, int countarroba,
				String result) throws LongitudMailErrornea {
			if (result.length() <= 3) {
				throw new LongitudMailErrornea("esto es en el contrsuctor");

			} else {

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
						output.setText("valido"); // este metodo dice sobre el elemento output (q es una capa de
													// texto libre
													// settearle el texto Valido
					} else {
						output.setText("invalido");
					}
				} else {
					output.setText("invalido");
				}
			}
		}
	}
}

class LongitudMailErrornea extends Exception {
	public LongitudMailErrornea() {
	}

	public LongitudMailErrornea(String mensajeError) {
		super(mensajeError);
	}

}