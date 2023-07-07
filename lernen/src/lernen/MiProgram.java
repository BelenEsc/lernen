package lernen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MiProgram {

	public static void main(String[] args) {

		Frame frame = new Frame();
		frame.setVisible(true);
	}
}

class Frame extends JFrame {
	String fileName;
	PanelTexto panelTexto;
	int conteoByte = 0;
	String[] datos;

	public Frame() {
		setTitle("my program");
		setDefaultCloseOperation(3);
		setBounds(50, 50, 600, 600);

		// set Icon
		String icon = new String("C://Users//belen//git//lernen//lernen//bin//Icons//logoDNA.gif");
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image img = kit.createImage(icon);
		setIconImage(img);

//		crear una lamina		
//		Layout layout = new Layout();
//		add(layout);

		// crear objetos que contengan caracteristicas y acciones. All crear un objeto
		// AbstractAcion se crea un elemento, se le pasa unos parametros "nombre"
		// "icono" y ya se define que es lo que va a hacer, o sea se crea un objeto, ahi
		// mismo se le pone a la escucha y se define q va a hacer. Es como una cajita q
		// llega todo.

		// accion salir

		Action exit = new AbstractAction("salir", new ImageIcon("H://git//lernen//lernen//src//icons//x.gif")) {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		};

		// crear menu
		JMenuBar menuBar = new JMenuBar();

		// elementos de menu

		JMenu menu = new JMenu("menu");

		// elementos de elementos de menu
		JMenuItem cargar = new JMenuItem("open"); // esto en el futuro se va a reemplazar con un objeto accion
													// que haga algo
		// accion cargar archivo
		cargar.addActionListener(new accionAbrir());

		// asignar elementos nivel 1
		menu.add(cargar);
		menu.addSeparator();
		menu.add(exit);

		// asignar elementos nivel 0
		menuBar.add(menu);

		// crear Toolbar

		JToolBar barraHerramientas = new JToolBar("tools");

		// anadir elementos a la toolbar

		barraHerramientas.add(exit);

		// anadir toolbar al marco

		add(barraHerramientas, BorderLayout.NORTH);

		// anadir elementos al marco y definirla como el menu principal

		setJMenuBar(menuBar);

		panelTexto = new PanelTexto();
		add(panelTexto, BorderLayout.CENTER);
	}

	class PanelTexto extends JPanel {
		public static JTextArea textArea;

		public PanelTexto() {
			textArea = new JTextArea(50, 50);
			textArea.setBackground(new Color(150, 50, 50));
			add(textArea);
		}
	}

	class accionAbrir implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("csv", "csv");
			chooser.setFileFilter(filter);
			int returnVal = chooser.showOpenDialog(SwingUtilities.getWindowAncestor((Component) e.getSource()));
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				PanelTexto.textArea
						.setText("You chose to open this file: " + chooser.getSelectedFile().getName() + "\n");
				System.out.println("\n");
				System.out.println(chooser.getSelectedFile().getAbsolutePath());
				fileName = chooser.getSelectedFile().getAbsolutePath();
				System.out.println(fileName);

				try {
					FileReader leerArchivo = new FileReader(fileName);
					System.out.println("si");
					BufferedReader buffer = new BufferedReader(leerArchivo);
					String linea;
					String[] splitet;
					int contador = 1;
					while ((linea = buffer.readLine()) != null) {
						splitet = linea.split(";");
						for (String cells : splitet) {
							
							String formattedCell = String.format("%-" + 50 + "s", cells);
							PanelTexto.textArea.append(formattedCell);
						}
						PanelTexto.textArea.append("\n");
						contador++;
					}

				} catch (Exception ex) {
					ex.getMessage();
				}
			}
		}
	}
}