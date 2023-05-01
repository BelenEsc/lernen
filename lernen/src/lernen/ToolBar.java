package lernen;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.security.KeyStore;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class ToolBar extends TemplateMarco {

	public ToolBar(String titulo) {
		super(titulo);
	}

	public static void main(String[] args) {
		TemplateMarco marco13 = new TemplateMarco("Barra de herramientas");
		JPanel panelbarra = new PanelBarra();
		marco13.add(panelbarra);

	}

}

class PanelBarra extends JPanel {
	

	public PanelBarra() {

		ActionColor rojo = new ActionColor("Rojo", new ImageIcon("H://git//lernen//lernen//bin//iconos//rojo.png"),
				Color.red);
		ActionColor verde = new ActionColor("Verde", new ImageIcon("H://git//lernen//lernen//bin//iconos//verde.png"),
				Color.green);
		ActionColor azul = new ActionColor("Azul", new ImageIcon("H://git//lernen//lernen//bin//iconos//azul.png"),
				Color.blue);

		JButton red = new JButton(rojo);
		JButton green = new JButton(verde);
		JButton blue = new JButton(azul);
		
//******Mapa de entrada
		
		InputMap mapa = getInputMap(WHEN_IN_FOCUSED_WINDOW);
		
		
		
		
//******Definir teclar
		
		KeyStroke atajoRojo = KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK);
		KeyStroke atajoVerde= KeyStroke.getKeyStroke(KeyEvent.VK_K, InputEvent.CTRL_DOWN_MASK);
		KeyStroke atajoAzul = KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.CTRL_DOWN_MASK);
		
		
//******Asignar combinacion de teclas a un objeto que sirve como puente
		
		
		
		
		
//******Asignar objeto a accion
		
		
		
		
		

		add(red);
		add(green);
		add(blue);

	}

	class ActionColor extends AbstractAction {

		public ActionColor(String rotulo, Icon icono, Color color) {

			putValue(NAME, rotulo);
			putValue(SMALL_ICON, icono);
			putValue(SHORT_DESCRIPTION, "poner lamina de color " + rotulo);
			putValue("color de fondo", color);

		}

		@Override
		public void actionPerformed(ActionEvent e) {

			Color c = (Color) getValue("color de fondo");
			setBackground(c);
			
			System.out.println("el boton que pulsamos es: " + getValue(NAME));
		}
	}
}
