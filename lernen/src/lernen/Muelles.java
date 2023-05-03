package lernen;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Spring;
import javax.swing.SpringLayout;

public class Muelles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Marco19 marco19 = new Marco19();

	}

}

class Marco19 extends JFrame {
	public Marco19() {
		setTitle("Muelles");
		setVisible(true);
		setDefaultCloseOperation(3);
		setBounds(50, 50, 700, 700);

		Lamina19 lamina19 = new Lamina19();
		add(lamina19);

	}
}

class Lamina19 extends JPanel {

	JButton boton1;
	JButton boton2;
	JButton boton3;

	public Lamina19() {

		boton1 = new JButton("boton 1");
		boton2 = new JButton("boton 2");
		boton3 = new JButton("boton 3");

		SpringLayout spring = new SpringLayout();
		setLayout(spring);

		Spring resorte1 = Spring.constant(10, 50, 100);
		Spring rigido = Spring.constant(5);

		spring.putConstraint(SpringLayout.WEST, boton1, resorte1, SpringLayout.WEST, this); // este muelle lo vamos a
																							// dividir en 3 partes: los
																							// dos primeros parametros
																							// te dicen de donde, los
																							// dos ultimos te dicen
																							// hacia donde. en medio
																							// esta el resorte. Ahora,
																							// dentro de cada parte, el
																							// segundo argumento te dice
																							// el elemento del cual
																							// queremos partir, y el
																							// primer parametro te dice
																							// exactamente la ubicacion
																							// partiendo del elemento
																							// donde queremos partir, en
																							// ese sentido, al decir
																							// west,boton1 significa q
																							// vamos a comenzar en el
																							// borde izq del boton1
		add(boton1);
		spring.putConstraint(SpringLayout.WEST, boton2, rigido, SpringLayout.EAST, boton1);
		add(boton2);
		spring.putConstraint(SpringLayout.WEST, boton3, rigido, SpringLayout.EAST, boton2);
		add(boton3);
		spring.putConstraint(SpringLayout.EAST, this, resorte1, SpringLayout.EAST, boton3);
	}

}