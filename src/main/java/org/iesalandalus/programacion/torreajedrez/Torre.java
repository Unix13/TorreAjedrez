package org.iesalandalus.programacion.torreajedrez;

public class Torre {
	
	
	// Atributos
	private Color color;
	private Posicion posicion;

	// getters y setters

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		if (color == null) {
			throw new NullPointerException("ERROR: No se puede asignar un color nulo.");
		}
		this.color = color;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {

		if (posicion == null) {
			throw new IllegalArgumentException("La posición no es la esperada.");
		} else {

			this.posicion = posicion;
		}
	}

}
