package lernen;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.StyledEditorKit;

public class miWordV2 {

	public static void main(String[] args) {
		Marco12 marco12 = new Marco12();
	}

}

class Marco12 extends JFrame {
	public Marco12() {

		setTitle("Mi Word precario");
		setVisible(true);
		setDefaultCloseOperation(3);
		setBounds(50, 50, 500, 500);
		LaminaWord2 laminaWord2 = new LaminaWord2();
		add(laminaWord2);

	}

}

class LaminaWord2 extends JPanel {
	JTextPane areaTexto;
	JMenu fuente, tamanio, estilo;
	Font configuracionInicial;

	public LaminaWord2() {

		setLayout(new BorderLayout());

		areaTexto = new JTextPane();

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

		crearActuar("Arial", "fuente", "Arial", 3, 52, "H://git//lernen//lernen//bin//iconos//paste.jpg" );
		crearActuar("Verdana", "fuente", "Verdana", 3, 52,"H:/git//lernen//lernen//bin//iconos/copy.jpg");
		crearActuar("Serif", "fuente", "Serif", 3, 12,"H:/git//lernen//lernen//bin//iconos/gpt.png");
		crearActuar("Negrita", "estilo", "", Font.BOLD, 30,"H:/git//lernen//lernen//bin//iconos/paste.jpg");
		crearActuar("Cursiva", "estilo", "", Font.ITALIC, 30,"H:/git//lernen//lernen//bin//iconos/paste.jpg");
		crearActuar("12", "tamanio", "", 3, 12,"H:/git//lernen//lernen//bin//iconos/paste.jpg");
		crearActuar("20", "tamanio", "", 3, 20,"H:/git//lernen//lernen//bin//iconos/paste.jpg");
		crearActuar("28", "tamanio", "", 3, 28,"H:/git//lernen//lernen//bin//iconos/paste.jpg");

		barraMenu.add(fuente);
		barraMenu.add(estilo);
		barraMenu.add(tamanio);
		add(barraMenu, BorderLayout.NORTH);
		add(areaTexto, BorderLayout.CENTER);

	}

	public void crearActuar(String rotulo, String menu, String fuente, int estilo, int tamanio, String imagen) {

		ImageIcon icon = new ImageIcon(imagen);
		JMenuItem unItem = new JMenuItem(rotulo,icon);

		if (menu == "fuente") {
			this.fuente.add(unItem);
			unItem.addActionListener(new StyledEditorKit.FontFamilyAction("", fuente));

		} else if (menu == "tamanio") {
			this.tamanio.add(unItem);
			unItem.addActionListener(new StyledEditorKit.FontSizeAction("", tamanio));

		} else {
			this.estilo.add(unItem);

			if (rotulo == "Negrita") {

				unItem.addActionListener(new StyledEditorKit.BoldAction());
			} else if (rotulo == "Cursiva") {
				unItem.addActionListener(new StyledEditorKit.ItalicAction());

			}
		}
	}
}