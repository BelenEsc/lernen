package lernen;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class MiProgram {
	public static void main(String[] args) {
		Frame frame = new Frame();
		frame.setVisible(true);
	}
}

class Frame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String fileName;
	PanelTexto panelTexto;

	public Frame() {
		setTitle("Mi Programa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 600, 600);

		// Crear objetos que contengan características y acciones.
		Action exit = new AbstractAction("Salir") {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

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
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		CustomTableModel model;
		JTable table;
		JScrollPane tableScrollPane;
		Stack<TableState> undoStack;

		public PanelTexto() {
			setLayout(new BorderLayout());
			table = new JTable();
			tableScrollPane = new JScrollPane(table);
			model = new CustomTableModel();
			table.setModel(model);
			undoStack = new Stack<>();

			add(tableScrollPane, BorderLayout.CENTER);

			JButton undoButton = new JButton("Undo Columns");
			undoButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					undo();
				}
			});
			JButton undoRowsButton = new JButton("Undo Rows");
			undoRowsButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					undoRowsDeletion();
				}
			});

			JButton eliminarFilas = new JButton("Eliminar Filas");
			JButton eliminarColumnas = new JButton("Eliminar Columnas");
			eliminarColumnas.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					panelTexto.eliminarColumnasSeleccionadas();
				}
			});
			eliminarFilas.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					panelTexto.eliminarFilasSeleccionadas();
				}
			});

			JPanel x = new JPanel();
			x.setLayout(new FlowLayout());
			x.add(eliminarFilas);
			x.add(undoRowsButton);
			x.add(eliminarColumnas);
			x.add(undoButton);
			add(x, BorderLayout.SOUTH);
		}

		public void cargarTabla(String[][] datos, String[] columnas) {
			DefaultTableModel model = new DefaultTableModel(datos, columnas) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				@Override
				public boolean isCellEditable(int row, int column) {
					return false; // Hacer que las celdas no sean editables
				}
			};

			table.setModel(model);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		}

		private List<String[]> deletedRows = new ArrayList<>();

		public void eliminarFilasSeleccionadas() {
			int[] selectedRows = table.getSelectedRows();
			DefaultTableModel model = (DefaultTableModel) table.getModel();

			// Store the deleted rows in the data structure
			for (int i = selectedRows.length - 1; i >= 0; i--) {
				int row = selectedRows[i];
				String[] rowData = new String[model.getColumnCount()];
				for (int j = 0; j < model.getColumnCount(); j++) {
					rowData[j] = (String) model.getValueAt(row, j);
				}
				deletedRows.add(rowData);
			}

			// Delete the selected rows
			for (int i = selectedRows.length - 1; i >= 0; i--) {
				int row = selectedRows[i];
				model.removeRow(row);
			}
		}

		public void eliminarColumnasSeleccionadas() {
			int[] selectedColumns = table.getSelectedColumns();

			if (selectedColumns.length > 0) {
				TableColumnModel columnModel = table.getColumnModel();
				TableState currentState = new TableState(columnModel);

				for (int i = selectedColumns.length - 1; i >= 0; i--) {
					int selectedColumn = selectedColumns[i];
					TableColumn tableColumn = columnModel.getColumn(selectedColumn);
					columnModel.removeColumn(tableColumn);
					currentState.addDeletedColumn(tableColumn);
				}

				undoStack.push(currentState);
			}
		}

		public void undo() {
			if (!undoStack.isEmpty()) {
				TableState previousState = undoStack.pop();
				TableColumnModel columnModel = table.getColumnModel();

				for (TableColumn tableColumn : previousState.getDeletedColumns()) {
					columnModel.addColumn(tableColumn);
					columnModel.moveColumn(columnModel.getColumnCount() - 1, tableColumn.getModelIndex());
				}

				for (Object[] rowData : previousState.getDeletedRows()) {
					model.addRow(rowData);
				}
			}
		}

		public void undoRowsDeletion() {
			DefaultTableModel model = (DefaultTableModel) table.getModel();

			// Restore the deleted rows
			for (String[] rowData : deletedRows) {
				model.addRow(rowData);
			}

			// Clear the data structure
			deletedRows.clear();
		}

		class CustomTableModel extends DefaultTableModel {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public Object[] getRowData(int row) {
				Object[] rowData = new Object[getColumnCount()];

				for (int i = 0; i < getColumnCount(); i++) {
					rowData[i] = getValueAt(row, i);
				}

				return rowData;
			}
		}

		class TableState {
			private List<Object[]> deletedRows;
			private Stack<TableColumn> deletedColumns;

			public TableState() {
				this.deletedRows = new ArrayList<>();
				this.deletedColumns = new Stack<>();
			}

			public TableState(TableColumnModel columnModel) {
				this.deletedRows = new ArrayList<>();
				this.deletedColumns = new Stack<>();
			}

			public void addDeletedColumn(TableColumn tableColumn) {
				deletedColumns.push(tableColumn);
			}

			public void setDeletedRows(List<Object[]> deletedRows) {
				this.deletedRows = deletedRows;
			}

			public List<Object[]> getDeletedRows() {
				return deletedRows;
			}

			public Stack<TableColumn> getDeletedColumns() {
				return deletedColumns;
			}
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
//              establecerSoloLectura(saveFilePath);
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
	}

	class CustomTableModel extends DefaultTableModel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void removeColumn(int columnIndex) {
			// Remove the column header
			columnIdentifiers.remove(columnIndex);

			// Remove the column data from each row
			for (Vector<Object> row : dataVector) {
				if (columnIndex < row.size()) {
					row.remove(columnIndex);
				}
			}

			// Update the table view
			fireTableStructureChanged();
		}
	}
}
