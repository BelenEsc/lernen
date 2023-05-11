package errores;

import java.io.IOException;
import java.util.Scanner;

public class EntradaDatos {

	public static void main(String[] args) {
		System.out.println("que quieres hacer");
		System.out.println("1. introducir \n2. salir");
		Scanner decision = new Scanner(System.in);
		int entrada = decision.nextInt();
		if (entrada == 1) {
			
			try {
				introduccion();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else
			System.exit(0);

		decision.close();
	}

	static void introduccion() throws IOException {//con las clases que son IOException, se tiene que poner si o si try cathc para estos metodos, para los otros no, pero SI te sale un error 
		
		System.out.println("ponga nombre ");
		
		Scanner intro = new Scanner(System.in);
		String nombre = intro.next();

		System.out.print("ponga edad ");
		int edad = intro.nextInt();
		
		
		System.out.printf("hola %s tu nombre es y tu edad es %d ", nombre, edad );
		intro.close();
	
	}

}