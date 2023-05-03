package lernen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.text.StyledEditorKit;

public class ProcesadorSimplificado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Marco17 Marco17 = new Marco17();

	}

}

class Marco17 extends JFrame {
	public Marco17() {

		setTitle("Recortar codigo");
		setVisible(true);
		setDefaultCloseOperation(3);
		setBounds(50, 50, 700, 700);
		Lamina17 Lamina17 = new Lamina17();
		add(Lamina17);

	}

}

class Lamina17 extends JPanel {

	JTextPane areaTexto;
	JMenu fuente, tamanio, estilo;
	Font configuracionInicial;
	JLabel output;
	JButton bold;
	JButton italic;
	JButton under;
	JButton verde;
	JButton centrar;
	JButton izquierda;
	JButton derecha;
	JToolBar barraHerramientas;

	public Lamina17() {

//*****Definir la disposicion de la lamina

		setLayout(new BorderLayout());

//******Crear contenedores 

		areaTexto = new JTextPane();
		JMenuBar barraMenu = new JMenuBar();
		output = new JLabel();

//******Crear los elementos de la barra menu

		fuente = new JMenu("Fuente");
		estilo = new JMenu("Estilo");
		tamanio = new JMenu("Tamano");

//******Crear los elementos de cada menu 

		crearActuar2("Arial", "fuente", "Arial", 3, 52, "H://git//lernen//lernen//bin//iconos//paste.jpg");
		crearActuar2("Verdana", "fuente", "Verdana", 3, 52, "H:/git//lernen//lernen//bin//iconos/copy.jpg");
		crearActuar2("Serif", "fuente", "Serif", 3, 12, "H:/git//lernen//lernen//bin//iconos/gpt.png");

		// as checkboxes
		JCheckBoxMenuItem Negrita = new JCheckBoxMenuItem("Negrita",
				new ImageIcon("H:/git//lernen//lernen//bin//iconos/paste.jpg"));
		JCheckBoxMenuItem Cursiva = new JCheckBoxMenuItem("Cursiva");

		// as radio buttons

		// crear el grupo de los bootnes
		ButtonGroup grupoBotones = new ButtonGroup();

		// crear los botones a agruparse entre si
		JRadioButtonMenuItem doce = new JRadioButtonMenuItem("12",
				new ImageIcon("H:/git//lernen//lernen//bin//iconos/paste.jpg"));
		JRadioButtonMenuItem veinte = new JRadioButtonMenuItem("22",
				new ImageIcon("H:/git//lernen//lernen//bin//iconos/paste.jpg"));
		JRadioButtonMenuItem veocho = new JRadioButtonMenuItem("28",
				new ImageIcon("H:/git//lernen//lernen//bin//iconos/paste.jpg"));

		// agrupar los botones
		grupoBotones.add(doce);
		grupoBotones.add(veinte);
		grupoBotones.add(veocho);

//******Crear el menu de pop up 

		JPopupMenu popMenu = new JPopupMenu();
		JMenuItem negrita = new JMenuItem("Negrita");
		JMenuItem cursiva = new JMenuItem("Cursiva");

//******Definir sobre que elemento va a desplegarse el pop up

		areaTexto.setComponentPopupMenu(popMenu);

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

//******Crear los actionListeners 

		Negrita.addActionListener(new StyledEditorKit.BoldAction());
		Cursiva.addActionListener(new StyledEditorKit.ItalicAction());

//******atajos

		Negrita.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
		Cursiva.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, InputEvent.CTRL_DOWN_MASK));

		doce.addActionListener(new StyledEditorKit.FontSizeAction("", 12));
		veinte.addActionListener(new StyledEditorKit.FontSizeAction("", 22));
//		veinte.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_DOWN_MASK));
		veocho.addActionListener(new StyledEditorKit.FontSizeAction("", 28));

		negrita.addActionListener(new StyledEditorKit.BoldAction());

		cursiva.addActionListener(new StyledEditorKit.ItalicAction());

//******Anadir los elementos de cada menu a su respectivo elemento en el menu de la barra 

		estilo.add(Negrita);
		estilo.add(Cursiva);
		tamanio.add(doce);
		tamanio.add(veinte);
		tamanio.add(veocho);

//******Anadir los elementos a la barra de menu 

		barraMenu.add(fuente);
		barraMenu.add(estilo);
		barraMenu.add(tamanio);

//******Anadir los elementos al pop up menu 

		popMenu.add(negrita);
		popMenu.add(cursiva);

///******anadir los elementos a la lamina 

		add(barraMenu, BorderLayout.NORTH);
		add(areaTexto, BorderLayout.CENTER);

//		JToolBar barraHerramientas = new JToolBar("Tools", JToolBar.VERTICAL);
//
////******construir Botones 
//
//		JButton bold = new JButton(new ImageIcon("H:\\git\\lernen\\lernen\\src\\icons\\bold.gif"));
//		JButton italic = new JButton(new ImageIcon("H:\\git\\lernen\\lernen\\src\\icons\\italic.gif"));
//		JButton under = new JButton(new ImageIcon("H:\\git\\lernen\\lernen\\src\\icons\\italic.gif"));
//		JButton verde = new JButton(new ImageIcon("H:\\git\\lernen\\lernen\\src\\icons\\verde.gif"));
//		JButton centrar = new JButton(new ImageIcon("H:\\git\\lernen\\lernen\\src\\icons\\centro.gif"));
//		JButton izquierda= new JButton(new ImageIcon("H:\\git\\lernen\\lernen\\src\\icons\\izq.gif"));
//		JButton derecha = new JButton(new ImageIcon("H:\\git\\lernen\\lernen\\src\\icons\\der.gif"));
//		
////******anadir la funcion a los botones
//
//		bold.addActionListener(new StyledEditorKit.BoldAction());
//		italic.addActionListener(new StyledEditorKit.ItalicAction());
//		under.addActionListener(new StyledEditorKit.UnderlineAction());
//		verde.addActionListener(new StyledEditorKit.ForegroundAction("", Color.green));
//		centrar.addActionListener(new StyledEditorKit.AlignmentAction("", 1));
//		izquierda.addActionListener(new StyledEditorKit.AlignmentAction("", 3));
//		derecha.addActionListener(new StyledEditorKit.AlignmentAction("", 2));
//
////******anadir elementos a la barra de herramientas
//
//		barraHerramientas.add(bold);
//		barraHerramientas.add(italic);
//		barraHerramientas.add(under);
//		barraHerramientas.addSeparator();
//		barraHerramientas.add(verde);
//		barraHerramientas.addSeparator();
//		barraHerramientas.add(centrar);
//		barraHerramientas.add(izquierda);
//		barraHerramientas.add(derecha);
//		
//		
////******anadir barra de herramientas a la lamina

		barraHerramientas = new JToolBar("tools", JToolBar.VERTICAL);
		forToolBar("H:\\git\\lernen\\lernen\\src\\icons\\bold.gif").addActionListener(new StyledEditorKit.BoldAction());
		forToolBar("H:\\git\\lernen\\lernen\\src\\icons\\italic.gif")
				.addActionListener(new StyledEditorKit.ItalicAction());
		forToolBar("H:\\git\\lernen\\lernen\\src\\icons\\italic.gif")
				.addActionListener(new StyledEditorKit.UnderlineAction());
		barraHerramientas.addSeparator();
		forToolBar("H:\\git\\lernen\\lernen\\src\\icons\\verde.gif").addActionListener(new StyledEditorKit.ForegroundAction("", Color.green));
		barraHerramientas.addSeparator();
		forToolBar("H:\\git\\lernen\\lernen\\src\\icons\\centro.gif")
				.addActionListener(new StyledEditorKit.AlignmentAction("", 1));
		forToolBar("H:\\git\\lernen\\lernen\\src\\icons\\der.gif")
				.addActionListener(new StyledEditorKit.AlignmentAction("", 2));
		forToolBar("H:\\git\\lernen\\lernen\\src\\icons\\izq.gif")
				.addActionListener(new StyledEditorKit.AlignmentAction("", 3));

		add(barraHerramientas, BorderLayout.EAST);

	}

	public JButton forToolBar(String rutaImagen) {

		JButton boton = new JButton(new ImageIcon(rutaImagen));
		barraHerramientas.add(boton);
		return boton;

	}

	public void crearActuar2(String rotulo, String menu, String fuente, int estilo, int tamanio, String imagen) {

		ImageIcon icon = new ImageIcon(imagen);
		JMenuItem unItem = new JMenuItem(rotulo, icon);

		if (menu == "fuente") {
			this.fuente.add(unItem);

			if (rotulo == "Arial") {
				unItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.ALT_DOWN_MASK));
			} else if (rotulo == "Verdana") {
				unItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.ALT_DOWN_MASK));

			} else {
				unItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.ALT_DOWN_MASK));
			}

			unItem.addActionListener(new StyledEditorKit.FontFamilyAction("", fuente));

		} else if (menu == "tamanio") {
			this.tamanio.add(unItem);
			unItem.addActionListener(new StyledEditorKit.FontSizeAction("", tamanio));

		} else {
			this.estilo.add(unItem);

			if (rotulo == "Negrita") {

				unItem.addActionListener(new StyledEditorKit.BoldAction());

			} else if (rotulo == "Cursiva") {
				unItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, InputEvent.CTRL_DOWN_MASK));

				unItem.addActionListener(new StyledEditorKit.ItalicAction());

			}
		}
	}

}