package org.iesalandalus.programacion.torreajedrez;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {

	private static Torre torre;

	public static void main(String[] args) {

	// Método mostrarTorre
	private static void mostrarTorre() {
		try {
			System.out.println(torre.toString());
		} catch (NullPointerException e) {
			System.out.println("ERROR: La torre no está creada.");
		}
	}

	// Método mostrarMenu
	private static void mostrarMenu() {
		System.out.println(" ");
		System.out.println("1. Crear una torre por defecto.");
		System.out.println("2. Crear una torre eligiendo su color.");
		System.out.println("3. Crear una torre eligiendo su color y posición inicial.");
		System.out.println("4. Mover la torre.");
		System.out.println("5. Salir.");
	}

	// Método elegirOpcion
	private static int elegirOpcion() {
		int opcionMenu;

		do {
			System.out.print("Elija una de las anteriores opciones: ");

			opcionMenu = Entrada.entero();
		} while (opcionMenu < 1 || opcionMenu > 5);
		return opcionMenu;
	}
	// Método elegirColor

	private static Color elegirColor() {

		Color color = null;
		int opcionColor = 0;
		do {
			System.out.println("===============");
			System.out.println(" ");
			System.out.println("1. Blancas.");
			System.out.println("2. Negras.");
			System.out.println(" ");
			System.out.print("Elija un color: ");

			opcionColor = Entrada.entero();
		} while (opcionColor != 1 && opcionColor != 2);

		switch (opcionColor) {
		case 1:
			color = Color.BLANCO;
			break;
		case 2:
			color = Color.NEGRO;
			break;
		}

		return color;
	}
	
	//Método elegir Columna Inicial
	private static char elegirColumnaInicial() {
		
		char columnaInicial=0;
		do {
			System.out.print("Elija la columna inicial");

			columnaInicial = Entrada.caracter();
			
		} while (Character.toLowerCase(columnaInicial) != 'a' || Character.toLowerCase(columnaInicial) !='h');
		return columnaInicial;
		
	}

}