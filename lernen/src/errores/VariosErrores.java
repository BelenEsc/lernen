package errores;

import javax.swing.JOptionPane;

public class VariosErrores {

	public static void main(String[] args) {

		try {
			division();
		} catch (ArithmeticException e) {

			System.out.println("no entre cero");
		} catch (NumberFormatException e) {
			System.out.println("no es entero");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
			System.out.println(e.getCause());
			System.out.println(e.getClass());
		}

	}

	static void division() {

		int x = Integer.parseInt(JOptionPane.showInputDialog("un numero"));
		int y = Integer.parseInt(JOptionPane.showInputDialog("otro numero"));

		System.out.println(x / y);
	}
}