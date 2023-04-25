package lernen;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ClaseMolde extends JFrame {

	public ClaseMolde() {

		setBounds(50, 50, 400, 400);
		setVisible(true);
		setDefaultCloseOperation(3);
		LaminaMolde laminaMolde = new LaminaMolde();
		add(laminaMolde);
	}

}

class LaminaMolde extends JPanel {

	public LaminaMolde() {
		setLayout(new BorderLayout());
	}
}