package lernen;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PruebaTexto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoText marcoTexto = new MarcoText();
	}

}

class MarcoText extends JFrame {

	public MarcoText() {

		setBounds(100, 100, 300, 350);
		setDefaultCloseOperation(3);
		setVisible(true);
		setTitle("texto");
		Layer lamina = new Layer();
		add(lamina); 
		

	}

}

class Layer extends JPanel{
	
	public Layer () {
		
		 
		
	}
	
	
	
	
}