package org.iesalandalus.programacion.torreajedrez;

public class Posicion {

	// Atributos

	private int fila;
	private char columna;

	// Getters y setters

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {

		if (fila >= 1 && fila <= 8) {

			this.fila = fila;

		} else {
			throw new IllegalArgumentException("ERROR: Fila no válida.");
		}

	}

	public char getColumna() {
		return columna;
	}

	public void setColumna(char columna) {

		if (Character.toLowerCase(columna) >= 'a' && Character.toLowerCase(columna) <= 'h') {

			this.columna = columna;

		} else {
			throw new IllegalArgumentException("ERROR: Columna no válida.");
		}

	}
//Constructor que acepta como par�metros fila y columna

	public Posicion(int fila, char columna) {

		setFila(fila);
		setColumna(columna);

	}

}
