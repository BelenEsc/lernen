package lernen;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class miWord {

	public static void main(String[] args) {
		Marco11 marco11 = new Marco11();
	}

}

class Marco11 extends JFrame {
	public Marco11() {

		setTitle("Mi Word precario");
		setVisible(true);
		setDefaultCloseOperation(3);
		setBounds(50, 50, 500, 500);
		LaminaWord laminaWord = new LaminaWord();
		add(laminaWord);

	}

}

class LaminaWord extends JPanel {
	JTextArea areaTexto;
	JMenu fuente, tamanio, estilo;
	Font font;

	public LaminaWord() {

		setLayout(new BorderLayout());

		areaTexto = new JTextArea();

		JMenuBar barraMenu = new JMenuBar();

		fuente = new JMenu("Fuente");

//		JMenuItem arial = new JMenuItem("Arial");
//		JMenuItem verdana = new JMenuItem("Verdana");
//		JMenuItem serif = new JMenuItem("Serif");

		estilo = new JMenu("Estilo");
//		JMenuItem negrita = new JMenuItem("Negrita");
//		JMenuItem cursiva = new JMenuItem("Cursiva");
//
		tamanio = new JMenu("Tamano");
//		JMenuItem doce = new JMenuItem("12");
//		JMenuItem dieciseis = new JMenuItem("16");
//		JMenuItem dieciocho = new JMenuItem("18");
//		JMenuItem veinte = new JMenuItem("20");
//		JMenuItem veintidos = new JMenuItem("22");
//		JMenuItem veinticuatro = new JMenuItem("24");

//		fuente.add(arial);
//		fuente.add(verdana);
//		fuente.add(serif);
//
//		estilo.add(negrita);
//		estilo.add(cursiva);
//
//		tamanio.add(doce);
//		tamanio.add(dieciseis);
//		tamanio.add(dieciocho);
//		tamanio.add(veinte);
//		tamanio.add(veintidos);
//		tamanio.add(veinticuatro);

		crearActuar("Arial", "fuente", "Arial", 3, 52);
		crearActuar("Verdana", "fuente", "Verdana", 3, 52);
		crearActuar("Serif", "fuente", "Serif", 3, 12);
		crearActuar("Negrita", "estilo", "", Font.BOLD, 30);
		crearActuar("Cursiva", "estilo", "", Font.ITALIC, 30);
		crearActuar("12", "tamanio", "", 3, 12);
		crearActuar("20", "tamanio", "", 3, 20);
		crearActuar("28", "tamanio", "", 3, 28);

		barraMenu.add(fuente);
		barraMenu.add(estilo);
		barraMenu.add(tamanio);
		add(barraMenu, BorderLayout.NORTH);
		add(areaTexto, BorderLayout.CENTER);

	}

	public void crearActuar(String rotulo, String menu, String fuente, int estilo, int tamanio) {

		JMenuItem unItem = new JMenuItem(rotulo);

		if (menu == "fuente") {
			this.fuente.add(unItem);

		} else if (menu == "tamanio") {
			this.tamanio.add(unItem);

		} else {
			this.estilo.add(unItem);
		}

		Acciones acciones = new Acciones(rotulo, fuente, estilo, tamanio);
		unItem.addActionListener(acciones);
	}

	class Acciones implements ActionListener {

		String fuuente, menu;
		int taamano;
		int esstilo;

		public Acciones(String rotulo, String fuentes, int estilo, int tamanio) {
			fuuente = fuentes;
			taamano = tamanio;
			esstilo = estilo;
		///	menu = rotulo;
		}

		public void actionPerformed(ActionEvent e) {

			areaTexto.setFont(new Font(fuuente, esstilo, taamano));

		}

	}
}