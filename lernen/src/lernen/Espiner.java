package lernen;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class Espiner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Marco9 marco = new Marco9();

	}
}

class Marco9 extends JFrame {
	public Marco9() {
		setTitle("Espiner");
		setBounds(50, 50, 400, 400);
		setVisible(true);
		setDefaultCloseOperation(3);
		LaminaSpinner laminaSpinner = new LaminaSpinner();
		add(laminaSpinner);
	}

	class LaminaSpinner extends JPanel {

		public LaminaSpinner() {

			String[] objetos = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

			JSpinner espiner1 = new JSpinner(new miModelSpinner());
//			JSpinner espiner1 = new JSpinner(new SpinnerNumberModel(5,0,10,1));

			espiner1.setPreferredSize(new Dimension(200, 20));

			add(espiner1);

		}

		private class miModelSpinner extends SpinnerNumberModel {
			public miModelSpinner() {
				super(5, 0, 10, 1);

			}

			public Object getNextValue() {

				return super.getPreviousValue();

			}

			public Object getPreviousValue() {
				return super.getNextValue();
			}
		}

	}
}
