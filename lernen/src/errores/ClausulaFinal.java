package errores;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ClausulaFinal {
	static int figura;

	public static void main(String[] args) {

		System.out.println("figura: \n1. cuadrado \n2. circulo");
		Scanner entrada = new Scanner(System.in);

		try {
			figura = entrada.nextInt();
			System.out.println("medio");
		} catch (Exception e) {
			System.out.println("tiene q ser un numero");
		} finally {
			System.out.println("hola");
		}
		
		if (figura == 1) {
			System.out.println("lado del cuadrado para calcular el area");
			Scanner x = new Scanner(System.in);
			int lado = x.nextInt();
			x.close();
			System.out.println("el area del cuadrado es: " + Math.pow(lado, 2));

		} else if (figura == 2) {
			System.out.println("radio del circulo: ");
			Scanner y = new Scanner(System.in);
			int radio = y.nextInt();
			y.close();
			System.out.println("el area del circulo es: " + Math.PI * radio);

		}

		String sexo = JOptionPane.showInputDialog("sexo \n1. M \n2. F");
		int altura = Integer.parseInt(JOptionPane.showInputDialog("altura"));
		if (sexo == "m") {

			System.out.println("tu peso ideal es: "  + (altura - 100));

		} else {
			System.out.println("tu peso ideal es: " + (altura - 80));

		}
	}
}
