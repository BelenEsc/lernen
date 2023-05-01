package lernen;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class EventoMaus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoRaton marcoRaton = new MarcoRaton();
	}

}

class MarcoRaton extends JFrame {

	public MarcoRaton() {

		setTitle("evento de raton");
		setBounds(50, 50, 500, 500);
		setVisible(true);
		setDefaultCloseOperation(3);
		EventoRaton eventoRaton = new EventoRaton();
		addMouseListener(eventoRaton);
		addMouseMotionListener(eventoRaton);

	}
}

class EventoRaton  extends MouseAdapter implements MouseMotionListener{
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("x " + e.getX() + " Y " + e.getY());

		if (e.getModifiersEx() == MouseEvent.BUTTON1_DOWN_MASK) {
			System.out.println("derecho");

		} else if (e.getModifiersEx()==2048) {
			System.out.println("ruedita");
		} else if ( e.getModifiersEx()==4096) {
			
			System.out.println("izquierdo");
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getModifiersEx() == MouseEvent.BUTTON1_DOWN_MASK) {
			System.out.println("derecho");
			System.out.println(e.getX() + e.getY());
		}
		
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}