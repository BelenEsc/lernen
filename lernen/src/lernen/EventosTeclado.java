package lernen;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class EventosTeclado {

	public static void main(String[] args) {

		MarcoTeclado marcoTeclado = new MarcoTeclado();

	}

}

class MarcoTeclado extends JFrame {
	public MarcoTeclado() {
		setTitle("Eventos de teclado");
		setBounds(50, 50, 500, 500);
		setVisible(true);
		setDefaultCloseOperation(3);
		InstruccionesTeclado instrucciones = new InstruccionesTeclado();
		addKeyListener(instrucciones);

	}
}



class InstruccionesTeclado implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {

		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
System.out.println(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

}