package org.iesalandalus.programacion.torreajedrez;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {

	private static Torre torre;

	public static void main(String[] args) {

	// M�todo mostrar Torre
	private static void mostrarTorre() {
		try {
			System.out.println(torre.toString());
		} catch (NullPointerException e) {
			System.out.println("ERROR: La torre no est� creada.");
		}
	}

	// M�todo mostrar Menu
	private static void mostrarMenu() {
		System.out.println(" ");
		System.out.println("1. Crear una torre por defecto.");
		System.out.println("2. Crear una torre eligiendo su color.");
		System.out.println("3. Crear una torre eligiendo su color y posici�n inicial.");
		System.out.println("4. Mover la torre.");
		System.out.println("5. Salir.");
	}

	// M�todo elegir Opcion
	private static int elegirOpcion() {
		int opcionMenu;

		do {
			System.out.print("Elija una de las anteriores opciones: ");

			opcionMenu = Entrada.entero();
		} while (opcionMenu < 1 || opcionMenu > 5);
		return opcionMenu;
	}
	// M�todo elegir Color

	private static Color elegirColor() {

		Color elegircolor = null;
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
			elegircolor = Color.BLANCO;
			break;
		case 2:
			elegircolor = Color.NEGRO;
			break;
		}

		return elegircolor;
	}

	// M�todo elegir Columna Inicial
	private static char elegirColumnaInicial() {

		char columnaInicial = 0;
		do {
			System.out.print("Elija la columna inicial");

			columnaInicial = Entrada.caracter();

		} while (Character.toLowerCase(columnaInicial) != 'a' || Character.toLowerCase(columnaInicial) != 'h');
		return columnaInicial;

	}
	// M�todo mostrar Menu Direcciones

	private static void mostrarMenuDirecciones() {

		System.out.println("============================");
		System.out.println(" ");
		System.out.println("1. Mover arriba.");
		System.out.println("2. Mover abajo.");
		System.out.println("3. Mover izquierda.");
		System.out.println("4. Mover derecha.");
		System.out.println("5. Enroque corto.");
		System.out.println("6. Enroque largo.");
		System.out.println(" ");
		System.out.println("============================");
		
		}

	//M�todo elegir Direccion

	private static Direccion elegirDireccion() {

		Direccion elegirDireccion = null;
		int opcionDireccion = 0;
		do {

			opcionDireccion = Entrada.entero();
		} while (opcionDireccion < 1 || opcionDireccion > 6);

		switch (opcionDireccion) {
		case 1:
			elegirDireccion = Direccion.ARRIBA;
			break;
		case 2:
			elegirDireccion = Direccion.ABAJO;
			break;
		case 3:
			elegirDireccion = Direccion.IZQUIERDA;
			break;
		case 4:
			elegirDireccion = Direccion.DERECHA;
			break;
		case 5:
			elegirDireccion = Direccion.ENROQUE_CORTO;
			break;
		case 6:
			elegirDireccion = Direccion.ENROQUE_LARGO;
			break;
		}

		return elegirDireccion;
	}
	//M�todo crear torre defecto
	
	private static void crearTorreDefecto() {
		
		torre = new Torre();
	}
}

