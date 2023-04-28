package lernen;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class ModificacionTexto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Marco marco2 = new Marco();
	}

}

class Marco extends JFrame {

	public Marco() {

		setBounds(50, 50, 500, 500);
		setTitle("modificaciones");
		setDefaultCloseOperation(3);
		setVisible(true);
		Layer2 layer = new Layer2();
		add(layer);

	}

}

class Layer2 extends JPanel {

	public Layer2() {

		JTextField texto = new JTextField("aqui un texto", 20);
		add(texto);

		Receptora receptora = new Receptora(); // este objeto tiene todas las instrucciones para cada caso. pe. q pasa
												// si se borra,anade, cambia, etc pero todavia hay que hacer algo con
												// estas instrucciones

		Document midoc = texto.getDocument(); // el metodoo getDocument es de la clase jtextfield que al aplicarlo sobre
												// un elemento de esa clase, devuelve un objeto de tipo document. este
												// objeto contiene el texto del campo texto y sobre este tienen que
												// actuar las acciones cuando se ins/del.
		midoc.addDocumentListener(receptora); // esta linea dice que se van a ahcer con las instrucciones. Osea al
												// cambiar el texto (accion): actuar sobre el objeto midoc y pasarle las
												// instrucciones de que hacer en cada caso

	}

	private class Receptora implements DocumentListener {

		public Receptora() {

		}

		@Override
		public void insertUpdate(DocumentEvent e) {
			System.out.println("introducido");
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			System.out.println("removed");
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub

		}

	}
}
