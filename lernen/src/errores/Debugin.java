package errores;

import javax.swing.JOptionPane;

public class Debugin {

	public static void main(String[] args) {

		int numeros = Integer.parseInt(JOptionPane.showInputDialog("una matriz de ---- numeros"));
		
		int aleatorios [] = new int[numeros];
		
		for (int i = 0 ; i<aleatorios.length ; i++) {
			
			aleatorios[i]=(int)(Math.random()*100);
		}
		
		for (int x:aleatorios) {
			System.err.println(x);
		}
	}

}
