package lernen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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

//******Parametros normales para crear un marco

		setTitle("Barra de herramientas");
		setBounds(50, 50, 500, 500);
		setDefaultCloseOperation(3);
		setVisible(true);

//******Crear una lamina
//****** sobre esta lamina va a actuar todo. 

		panelBarra = new JPanel();
		add(panelBarra);

//******Crear los elementos con una clase que define caracteristicas y comportamiento de los objetos que no son botones como tal, son solo objetos

		AccionColor rojo = new AccionColor("Rojo", new ImageIcon("H://git//lernen//lernen//src//icons//rojo.gif"),
				Color.red);

		AccionColor verde = new AccionColor("Verde", new ImageIcon("H://git//lernen//lernen//src//icons//verde.gif"),
				Color.green);
		AccionColor azul = new AccionColor("Azul", new ImageIcon("H://git//lernen//lernen//src//icons//azul.gif"),
				Color.blue);

//******Este elemento se crea diferente, no con la misma clase, sino independientemente con otra clase que tb implementa actionListener		

		Action salir = new AbstractAction("salir", new ImageIcon("H://git//lernen//lernen//src//icons//x.gif")) {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0); // esto cierra el programa
			}
		};
//******Anadir una descripcion corta al objeto (porque no tiene como los anteriores)

		salir.putValue(Action.LONG_DESCRIPTION, "exit");

//******crear una barra de menu donde se van a colgar los elementos "JMenu"

		JMenuBar menuBar = new JMenuBar();

//******crear los elementos del menu principal

		JMenu menu = new JMenu("Color");

//******anadir al UNICO elemento del menu, los subelementos que no son elementos planos como JMenuItem. Esto es lo mismo que decir: 

		// JMenuItem ss= new JMenuItem(rojo);
		// menu.add(ss);

		menu.add(rojo);
		menu.add(azul);
		menu.add(verde);

//******anadir elementos del menu a la barra de menu  

		menuBar.add(menu);

//******definir la barra de menu como el menu principal del marco. Cuando se usa la opcion add(menuBar) se anade a la lamina un meno, pero no esta definido como EL menu principal

		setJMenuBar(menuBar);

//******crear una barra de herramientas, son esas de las que se despegan del marco 

		JToolBar barra = new JToolBar("tools", JToolBar.HORIZONTAL);

//******anadir a la barra de herramientas de nuevo los elementos que ya tenian caracteristicas y acciones

		barra.add(rojo);
		barra.add(azul);
		barra.add(verde);
		barra.addSeparator(); // separador de objetos
		barra.add(salir);

//******anadir el toolbar con una diposicion initial al norte

		add(barra, BorderLayout.NORTH);

	}

	class AccionColor extends AbstractAction {
//Color c;
//******el constructor de esta clase va a recibir 3 parametros 

		public AccionColor(String rotulo, Icon icono, Color color) {
//			c=color;
//******el constructor genera un mapa implicito donde se ponen (put) llaves y valors a un mapa imaginario jajja se toman los argumentos que se les pasa y se los almacena con un identificador. se pueden definir los key y tb hay predeterminados

			putValue(NAME, rotulo);
			putValue(SMALL_ICON, icono);
			putValue(SHORT_DESCRIPTION, "poner lamina de color " + rotulo);
			putValue("color de fondo", color);

		}

		@Override
		public void actionPerformed(ActionEvent e) {

			Color c = (Color) getValue("color de fondo"); // con erl metodo getValue buscas el key y el metodo devuelve
															// el valor correspondiente a la llame: K,V
			panelBarra.setBackground(c); // la que responde a la acciones es el panel, no el marco, o sea hay que
											// definir panel.color

			System.out.println("el boton que pulsamos es: " + getValue(NAME));
		}
	}
}
