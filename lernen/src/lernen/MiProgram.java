package lernen;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
		JMenuItem guardarMenuItem = new JMenuItem("Guardar");
		cargar.addActionListener(new AccionAbrir());
		menu.add(cargar);
		menu.add(guardarMenuItem);
		menu.addSeparator();
		menu.add(exit);
		menuBar.add(menu);
		setJMenuBar(menuBar);

		panelTexto = new PanelTexto();
		add(panelTexto);
		guardarMenuItem.addActionListener(new GuardarCSVActionListener(panelTexto.table));
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
			DefaultTableModel model = new DefaultTableModel(datos, columnas) {

				@Override
				public boolean isCellEditable(int row, int column) {
					return false; // Hacer que las celdas no sean editables
				}
			};

			table.setModel(model);

			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
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
							datos[i - 1] = columnasSplit;
						}
					}

					panelTexto.cargarTabla(datos, columnas);
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
			}
		}
	}

	class GuardarCSVActionListener implements ActionListener {
		private final JTable table;

		public GuardarCSVActionListener(JTable table) {
			this.table = table;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser saveFileChooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo CSV", "csv");
			saveFileChooser.setFileFilter(filter);
			int saveReturnVal = saveFileChooser.showSaveDialog(null);
			if (saveReturnVal == JFileChooser.APPROVE_OPTION) {
				String saveFilePath = saveFileChooser.getSelectedFile().getAbsolutePath();
				guardarTablaComoCSV(saveFilePath);
//				establecerSoloLectura(saveFilePath);
			}
		}

		private void guardarTablaComoCSV(String filePath) {
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
				int rowCount = table.getRowCount();
				int columnCount = table.getColumnCount();

				// Escribir los nombres de las columnas
				for (int i = 0; i < columnCount; i++) {
					writer.write(table.getColumnName(i));
					if (i < columnCount - 1) {
						writer.write(";");
					}
				}
				writer.newLine();

				// Escribir los datos de las celdas
				for (int i = 0; i < rowCount; i++) {
					for (int j = 0; j < columnCount; j++) {
						Object value = table.getValueAt(i, j);
						writer.write(value != null ? value.toString() : "");
						if (j < columnCount - 1) {
							writer.write(";");
						}
					}
					writer.newLine();
				}

				System.out.println("Tabla guardada como archivo CSV: " + filePath);
			} catch (IOException ex) {
				System.out.println("Error al guardar la tabla como archivo CSV: " + ex.getMessage());
			}
		}

//		private void establecerSoloLectura(String filePath) {
//			try {
//				Path path = Path.of(filePath);
//
//				// Establecer atributos de solo lectura
//				Set<PosixFilePermission> permissions = new HashSet<>();
//				permissions.add(PosixFilePermission.OWNER_READ);
//				permissions.add(PosixFilePermission.OWNER_WRITE);
//				permissions.add(PosixFilePermission.GROUP_READ);
//				permissions.add(PosixFilePermission.GROUP_WRITE);
//				permissions.add(PosixFilePermission.OTHERS_READ);
//				permissions.add(PosixFilePermission.OTHERS_WRITE);
//				Files.setPosixFilePermissions(path, permissions);
//				System.out.println("Archivo establecido como solo lectura: " + filePath);
//			} catch (IOException ex) {
//				System.out.println("Error al establecer el archivo como solo lectura: " + ex.getMessage());
//			}
//		}
	}
}
