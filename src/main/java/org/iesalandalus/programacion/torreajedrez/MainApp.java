package org.iesalandalus.programacion.torreajedrez;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {

	private static Torre torre;

	public static void main(String[] args) {

		// Método principal

		int control = 1;
		int seleccion;

		System.out.println("=====================================");
		System.out.println("=========Torre de Ajedrez============");
		System.out.println("=====================================");

		do {

			mostrarMenu();
			seleccion = elegirOpcion();
			ejecutarOpcion(seleccion);
			mostrarTorre();

			if (seleccion == 5) {
				control = 0;
			}
		} while (control != 0);
	}

	// Método mostrar Torre
	private static void mostrarTorre() {
		try {
			System.out.println(torre.toString());
		} catch (NullPointerException e) {
			System.out.println("ERROR: La torre no está creada.");
		}
	}

	// Método mostrar Menu
	private static void mostrarMenu() {
		System.out.println(" ");
		System.out.println("1. Crear una torre por defecto.");
		System.out.println("2. Crear una torre eligiendo su color.");
		System.out.println("3. Crear una torre eligiendo su color y posición inicial.");
		System.out.println("4. Mover la torre.");
		System.out.println("5. Salir.");
	}

	// Método elegir Opcion
	private static int elegirOpcion() {
		int opcionMenu;

		do {
			System.out.print("Elija una de las anteriores opciones: ");

			opcionMenu = Entrada.entero();
		} while (opcionMenu < 1 || opcionMenu > 5);
		return opcionMenu;
	}
	// Método elegir Color

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

	// Método elegir Columna Inicial
	private static char elegirColumnaInicial() {

		char columnaInicial = 0;
		do {
			System.out.print("Elija la columna inicial");

			columnaInicial = Entrada.caracter();

		} while (Character.toLowerCase(columnaInicial) != 'a' || Character.toLowerCase(columnaInicial) != 'h');
		return columnaInicial;

	}
	// Método mostrar Menu Direcciones

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

	// Método elegir Direccion

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
	// Método crear torre defecto

	private static void crearTorreDefecto() {

		torre = new Torre();
	}

	// Método crear torre elegir color

	private static void crearTorreColor() {

		torre = new Torre(elegirColor());
	}

	// Método crear torre elegir color y columna inicial

	private static void crearTorreColorColumna() {

		torre = new Torre(elegirColor(), elegirColumnaInicial());
	}
	// Método mover

	private static void mover() {

		Direccion direccion = null;
		int pasos;

		if (torre == null) {
			System.out.println("ERROR: No existe torre. Debe crear una torre.");
		} else {
			mostrarMenuDirecciones();
			direccion = elegirDireccion();

			if (direccion.equals(Direccion.ENROQUE_CORTO) || direccion.equals(Direccion.ENROQUE_LARGO)) {
				try {
					torre.enrocar(direccion);
				} catch (OperationNotSupportedException e) {
					System.out.println(e.getMessage());
				}
			} else {
				System.out.println(" ");
				System.out.print("Introduzca ahora el número de pasos que quiere dar: ");
				pasos = Entrada.entero();

				try {
					torre.mover(direccion, pasos);
				} catch (OperationNotSupportedException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}

	// Método ejecutarOpcion

	private static void ejecutarOpcion(int opcionEjecucion) {

		switch (opcionEjecucion) {
		case 1:
			crearTorreDefecto();
			break;
		case 2:
			crearTorreColor();
			break;
		case 3:
			crearTorreColorColumna();
			break;
		case 4:
			mover();
			break;
		case 5:
			System.out.println("ADIOS!!!");
			break;
		}
	}

}
