package lernen;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class MiProgram {
	public static void main(String[] args) {
		Frame frame = new Frame();
		frame.setVisible(true);
	}
}

class Frame extends JFrame {
	String fileName;
	PanelTexto panelTexto;

	public Frame() {
		setTitle("Mi Programa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 600, 600);

		// Crear objetos que contengan características y acciones.
		Action exit = new AbstractAction("Salir") {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		};

		// Crear el menú
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Menú");
		JMenuItem cargar = new JMenuItem("Abrir");
		cargar.addActionListener(new AccionAbrir());
		menu.add(cargar);
		menu.addSeparator();
		menu.add(exit);
		menuBar.add(menu);
		setJMenuBar(menuBar);

		panelTexto = new PanelTexto();
		add(panelTexto);
	}

	class PanelTexto extends JPanel {
		JTextArea textArea;
		JScrollPane scrollPane;
		JTable table;
		JScrollPane tableScrollPane;

		public PanelTexto() {
			setLayout(new BorderLayout());
			table = new JTable();
			tableScrollPane = new JScrollPane(table);
			add(tableScrollPane, BorderLayout.CENTER);
		}

		public void cargarTabla(String[][] datos, String[] columnas) {
			DefaultTableModel model = new DefaultTableModel(datos, columnas);
			table.setModel(model);
		}
	}

	class AccionAbrir implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo CSV", "csv");
			chooser.setFileFilter(filter);
			int returnVal = chooser.showOpenDialog(Frame.this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				fileName = chooser.getSelectedFile().getAbsolutePath();
				try {
					BufferedReader buffer = new BufferedReader(new FileReader(fileName));
					StringBuilder sb = new StringBuilder();
					String linea;

					while ((linea = buffer.readLine()) != null) {
						sb.append(linea);
						sb.append("\n");
					}

					buffer.close();

					String[] lineas = sb.toString().split("\n");
					String[][] datos = new String[lineas.length][];
					String[] columnas = null;

					for (int i = 0; i < lineas.length; i++) {
						String[] columnasSplit = lineas[i].split(";");
						if (i == 0) {
							columnas = columnasSplit;
						} else {
							datos[i] = columnasSplit;
						}
					}

					panelTexto.cargarTabla(datos, columnas);
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
			}
		}
	}
}
