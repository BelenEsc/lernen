package lernen;

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
		LaminaTeclado laminaTeclado = new LaminaTeclado();
		add(laminaTeclado);
	}
}

class LaminaTeclado extends JPanel {
	public LaminaTeclado() {
		
		InstruccionesTeclado instrucciones = new InstruccionesTeclado();
		this.addKeyListener(instrucciones);
		
	}

}

class InstruccionesTeclado implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {

		System.out.println("hola");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		System.out.println("hola");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

		System.out.println("hola");
	}

}