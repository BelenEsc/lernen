package lernen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class BarraHerramientas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Marco16 marco = new Marco16();


	}
}

class Marco16 extends JFrame {
	JPanel panelBarra;
	
	public Marco16() {

		setTitle("Barra de herramientas");
		setBounds(50, 50, 500, 500);
		setDefaultCloseOperation(3);
		setVisible(true);
		panelBarra = new JPanel();
		add(panelBarra);
		

		AccionColor rojo = new AccionColor("Rojo", new ImageIcon("H://git//lernen//lernen//src//icons//negro.gif"),
				Color.red);

		AccionColor verde = new AccionColor("Verde", new ImageIcon("H://git//lernen//lernen//bin//iconos//verde.png"),
				Color.green);
		AccionColor azul = new AccionColor("Azul", new ImageIcon("H://git//lernen//lernen//bin//iconos//azul.png"),
				Color.blue);
		//AccionColor salir = new AccionColor("salir",  new , getForeground())


		JMenu menu = new JMenu("Color");
		menu.add(rojo);
		menu.add(azul);
		menu.add(verde);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(menu);
		setJMenuBar(menuBar);
		
		JToolBar barra= new JToolBar("hola", JToolBar.HORIZONTAL);
		barra.add(rojo);
		barra.add(azul);		
		barra.add(verde);
		barra.addSeparator();
		//barra.add();
		
		
		add(barra,BorderLayout.NORTH);
		
//		JMenuItem itemRojo = new JMenuItem("rojo");
//		JMenuItem itemVerde = new JMenuItem("verde");
//		JMenuItem itemAzul = new JMenuItem("azul");
//
//		itemRojo.addActionListener(rojo);
//		itemAzul.addActionListener(azul);
//		itemVerde.addActionListener(verde);
//		menuBarColor.add(menu);
//		
//		menu.add(itemAzul);
//		menu.add(itemRojo);
//		menu.add(itemVerde);

		// MenuBarColor.add(menu);

		

	}

	class AccionColor extends AbstractAction {

		public AccionColor(String rotulo, Icon icono, Color color) {

			putValue(NAME, rotulo);
			putValue(SMALL_ICON, icono);
			putValue(SHORT_DESCRIPTION, "poner lamina de color " + rotulo);
			putValue("color de fondo", color);

		}

		@Override
		public void actionPerformed(ActionEvent e) {

			Color c = (Color) getValue("color de fondo");
			panelBarra.setBackground(c);

			System.out.println("el boton que pulsamos es: " + getValue(NAME));
		}
	}
}
