package lernen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CuadroEmergente {

	public static void main(String[] args) {

		Cuadros_Dialogos mimarco = new Cuadros_Dialogos();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);
	}
}

class Cuadros_Dialogos extends JFrame {

	public Cuadros_Dialogos() {
		setTitle("Cuadro de diálogos");
		setBounds(500, 300, 400, 250);

		add(new Lamina_Cuadros_Dialogos());
	}
}

class Lamina_Cuadros_Dialogos extends JPanel {

	public Lamina_Cuadros_Dialogos() {

		boton1 = new JButton("Botón 1");
		boton2 = new JButton("Botón 2");
		boton3 = new JButton("Botón 3");
		boton4 = new JButton("Botón 4");

		boton1.addActionListener(new Accion_botones());
		boton2.addActionListener(new Accion_botones());
		boton3.addActionListener(new Accion_botones());
		boton4.addActionListener(new Accion_botones());

		add(boton1);
		add(boton2);
		add(boton3);
		add(boton4);

	} // Fin constructor

	private class Accion_botones implements ActionListener {

//		JOptionPane inputDialog; 
//		JOptionPane confirmDialog;
//		JOptionPane messageDialog;
//		JOptionPane optionDialog;
//		
//		

		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == boton1) {

				String inputDialog = JOptionPane.showInputDialog(Lamina_Cuadros_Dialogos.this, "aviso en el recuadro",
						"users input", 3);
				System.out.println(inputDialog);

			} else if (e.getSource() == boton2) {

				int respuesta = JOptionPane.showConfirmDialog(Lamina_Cuadros_Dialogos.this, "mensaje", "titulo", 0, 1);

				if (respuesta == 1) {
					System.out.println("nein");
				} else
					System.out.println("ja");

			} else if (e.getSource() == boton3) {

//			JOptionPane.showMessageDialog(Lamina_Cuadros_Dialogos.this,"hola"); //void! no asignar a ninguna variable para usar sysout
//				JOptionPane.showMessageDialog(Lamina_Cuadros_Dialogos.this, ":(","cuadro emergente",3, new ImageIcon("H://git//lernen//lernen//src//icons//azul.gif")); 
				JOptionPane.showMessageDialog(Lamina_Cuadros_Dialogos.this, ":(", "cuadro emergente mensaje",
						JOptionPane.ERROR_MESSAGE); // el icono del mensaje se cambia con este ultimo int que define q
													// tipo de "error" es

			} else {

				JOptionPane.showOptionDialog(Lamina_Cuadros_Dialogos.this,"hola","titulo",1,1, new ImageIcon ("H://git//lernen//lernen//src//icons//azul.gif"),null,null);
			}
		}

	} // FIN CLASE Accion_botones

	private JButton boton1, boton2, boton3, boton4;

}// FIN clase Lamina_Cuadros_Dialogos
