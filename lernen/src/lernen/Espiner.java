package lernen;

import java.awt.BorderLayout;

import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.border.Border;

public class Espiner extends LaminaMolde {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClaseMolde marco = new ClaseMolde(); 
		marco.setTitle("espiner");
		marco.setLayout(new BorderLayout());
		
		JSpinner espiner1 = new JSpinner(new SpinnerDateModel());
		
		marco.add(espiner1,BorderLayout.NORTH);
	}

}
