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
	// Constructor por defecto

	public Torre() {

		setColor(Color.NEGRO);
		setPosicion(new Posicion(8, 'h'));
	}
	// Constructor con parametro color

	public Torre(Color color) {

		setColor(color);

		if (color.equals(Color.BLANCO)) {
			setPosicion(new Posicion(1, 'h'));
		} else {

			setPosicion(new Posicion(8, 'h'));
		}
	}
	// Constructor con parámetros color y columna

	public Torre(Color color, char columna) {

		setColor(color);

		if (Character.toLowerCase(columna) == 'a' || Character.toLowerCase(columna) == 'h') {

			if (color.equals(Color.BLANCO)) {

				setPosicion(new Posicion(1, columna));
			} else {
				setPosicion(new Posicion(8, columna));
			}
		} else
			throw new IllegalArgumentException("ERROR: Columna no válida.");
	}

}
