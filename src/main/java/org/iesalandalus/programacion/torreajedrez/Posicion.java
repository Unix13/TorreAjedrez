package org.iesalandalus.programacion.torreajedrez;

import java.util.Objects;

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
//constructor copia

	public Posicion(Posicion p) // throws NullPointerException
	{
		if (p == null)
			throw new NullPointerException("ERROR: No es posible copiar una posición nula.");
		setFila(p.getFila());
		setColumna(p.getColumna());

	}
//m�todos equals y hashCode

	@Override
	public int hashCode() {
		return Objects.hash(columna, fila);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Posicion other = (Posicion) obj;
		return columna == other.columna && fila == other.fila;
	}

//M�todo toString
	@Override
	public String toString() {
		return "fila=" + (fila = 1) + ", columna=" + (columna = 'a') + "";
	}

}
