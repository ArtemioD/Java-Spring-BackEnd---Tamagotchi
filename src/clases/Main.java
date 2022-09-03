package clases;

import java.util.Scanner;

public class Main {
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	private static Scanner entrada;

	public static void main(String[] args) {
		start();

	}

	private static void start() {
		entrada = new Scanner(System.in);
		
		System.out.println(ANSI_GREEN + "*** Bienvenido a Tamagotchi, tu Mascota Virtual ***");
		System.out.println(ANSI_YELLOW + "Para empezar debe dar un nombre a tu mascota...");

		String nombre = entrada.nextLine();
		Tamagotchi tama = new Tamagotchi(nombre);
		System.out.println(ANSI_GREEN + "*** MENU ***");
		
		int opcion = validarOpcion();
		while (opcion != 3) {
			switch (opcion) {
			case 1:
				tama.jugar();
				break;
			case 2:
				tama.comer();
				;
				break;
			}
			opcion = validarOpcion();
		}
		entrada.close();
		System.out.println("*** fin ***");

	}

	private static int validarOpcion() {
		String opcion = "";
		do {
			if (opcion != "") {
				System.out.println(ANSI_RED + opcion + " es una opcicon encorecta, proba otra vez...");
			}
			System.out.println(ANSI_GREEN + "Elige una opcion:");
			System.out.println("1 -> para jugar");
			System.out.println("2 -> para comer");
			System.out.println("3 -> para salir");
			opcion = entrada.nextLine();
			System.out.println(opcion);
		} while (!(opcion.equals("1") || opcion.equals("2") || opcion.equals("3")));
		return Integer.parseInt(opcion);
	}

}
