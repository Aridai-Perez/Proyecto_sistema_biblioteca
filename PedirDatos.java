package BibliotecaABMEL;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PedirDatos {
	static private Scanner teclado=new Scanner(System.in);

	static int leerInt(String frase){
		int num=0;
		boolean seguir=true;
		
		do {
			try {
				System.out.println(frase);
				num=teclado.nextInt();
				seguir=false;
				teclado.nextLine();
			} catch (InputMismatchException e) {
				System.out.println(teclado.nextLine()+" no es un número.");
			}
		}while(seguir);
		return num;
	}
        
	static String leerCadena(String frase) {
		String cadena="";
		System.out.println(frase);
		cadena=teclado.nextLine();
		return cadena;
	}
}
