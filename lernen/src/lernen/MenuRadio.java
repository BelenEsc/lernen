package lernen;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.StyledEditorKit;

public class MenuRadio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Marco14 marco14 = new Marco14();

	}

}

class Marco14 extends JFrame {
	public Marco14() {

		setTitle("Menus con checkboxes y botones radio");
		setVisible(true);
		setDefaultCloseOperation(3);
		setBounds(50, 50, 500, 500);
		Lamina14 lamina14 = new Lamina14();
		add(lamina14);

	}

}

class Lamina14 extends JPanel {

	JTextPane areaTexto;
	JMenu fuente, tamanio, estilo;
	Font configuracionInicial;
	JLabel output;
	JPanel paneOut;

	public Lamina14() {

		setLayout(new BorderLayout());

		areaTexto = new JTextPane();

		JMenuBar barraMenu = new JMenuBar();

		output = new JLabel();
		paneOut = new JPanel();

		int alto = paneOut.getHeight();
		final int ancho = 20;
		paneOut.setSize(ancho, alto);

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

		crearActuar("Arial", "fuente", "Arial", 3, 52, "H://git//lernen//lernen//bin//iconos//paste.jpg");
		crearActuar("Verdana", "fuente", "Verdana", 3, 52, "H:/git//lernen//lernen//bin//iconos/copy.jpg");
		crearActuar("Serif", "fuente", "Serif", 3, 12, "H:/git//lernen//lernen//bin//iconos/gpt.png");
		// crearActuar("Negrita", "estilo", "", Font.BOLD, 30,
		// "H:/git//lernen//lernen//bin//iconos/paste.jpg");
		// crearActuar("Cursiva", "estilo", "", Font.ITALIC, 30,
		// "H:/git//lernen//lernen//bin//iconos/paste.jpg");

		JCheckBoxMenuItem Negrita = new JCheckBoxMenuItem("Negrita",
				new ImageIcon("H:/git//lernen//lernen//bin//iconos/paste.jpg"));
		JCheckBoxMenuItem Cursiva = new JCheckBoxMenuItem("Cursiva");

		Negrita.addActionListener(new StyledEditorKit.BoldAction());
		Cursiva.addActionListener(new StyledEditorKit.ItalicAction());

		estilo.add(Negrita);
		estilo.add(Cursiva);

		crearActuar("12", "tamanio", "", 3, 12, "H:/git//lernen//lernen//bin//iconos/paste.jpg");
		crearActuar("20", "tamanio", "", 3, 20, "H:/git//lernen//lernen//bin//iconos/paste.jpg");
		crearActuar("28", "tamanio", "", 3, 28, "H:/git//lernen//lernen//bin//iconos/paste.jpg");

		barraMenu.add(fuente);
		barraMenu.add(estilo);

		barraMenu.add(tamanio);
		paneOut.add(output);
		add(barraMenu, BorderLayout.NORTH);
		add(areaTexto, BorderLayout.CENTER);
		add(paneOut, BorderLayout.SOUTH);

	}

	public void crearActuar(String rotulo, String menu, String fuente, int estilo, int tamanio, String imagen) {

		ImageIcon icon = new ImageIcon(imagen);
		JMenuItem unItem = new JMenuItem(rotulo, icon);

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