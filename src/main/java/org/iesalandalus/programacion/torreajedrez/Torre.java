package org.iesalandalus.programacion.torreajedrez;

import java.util.Objects;

import javax.naming.OperationNotSupportedException;

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
	// Método mover

	public void mover(Direccion direccion, int pasos) throws OperationNotSupportedException {

		if (pasos < 1) {
			throw new IllegalArgumentException("ERROR: El número de pasos debe ser positivo.");
		} else if (direccion == null) {
			throw new NullPointerException("ERROR: La dirección no puede ser nula.");
		}

		switch (direccion) {

		case ARRIBA:

			if (color.equals(Color.BLANCO)) {
				try {
					setPosicion(new Posicion(posicion.getFila() + pasos, posicion.getColumna()));
				} catch (IllegalArgumentException e) {
					throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
				}
			}

			if (color.equals(Color.NEGRO)) {
				try {
					setPosicion(new Posicion(posicion.getFila() - pasos, posicion.getColumna()));
				} catch (IllegalArgumentException e) {
					throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
				}
			}

			break;

		case ABAJO:

			if (color.equals(Color.BLANCO)) {
				try {
					setPosicion(new Posicion(posicion.getFila() - pasos, posicion.getColumna()));

				} catch (IllegalArgumentException e) {
					throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
				}
			}

			if (color.equals(Color.NEGRO)) {
				try {
					setPosicion(new Posicion(posicion.getFila() + pasos, posicion.getColumna()));

				} catch (IllegalArgumentException e) {
					throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
				}
			}

			break;

		case IZQUIERDA:

			if (color.equals(Color.BLANCO)) {
				try {
					setPosicion(new Posicion(posicion.getFila(), (char) (posicion.getColumna() - pasos)));

				} catch (IllegalArgumentException e) {
					throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
				}
			}

			if (color.equals(Color.NEGRO)) {
				try {
					setPosicion(new Posicion(posicion.getFila(), (char) (posicion.getColumna() + pasos)));

				} catch (IllegalArgumentException e) {
					throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
				}
			}

			break;
		case DERECHA:

			if (color.equals(Color.BLANCO)) {
				try {
					setPosicion(new Posicion(posicion.getFila(), (char) (posicion.getColumna() + pasos)));

				} catch (IllegalArgumentException e) {
					throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
				}
			}
			if (color.equals(Color.NEGRO)) {
				try {
					setPosicion(new Posicion(posicion.getFila(), (char) (posicion.getColumna() - pasos)));

				} catch (IllegalArgumentException e) {
					throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
				}
			}

			break;

		default:
			throw new NullPointerException("ERROR: La dirección no puede ser nula.");

		}
	}

	// Método enrocar
	public void enrocar(Direccion direccion) throws OperationNotSupportedException {
		if (direccion == null) {
			throw new NullPointerException("ERROR: La dirección no puede ser nula.");
		}
		switch (direccion) {
		case ENROQUE_CORTO:
			if (posicion.getColumna() == 'h' && (posicion.getFila() == 1 || posicion.getFila() == 8)) {
				setPosicion(new Posicion(posicion.getFila(), 'f'));
			} else {
				throw new OperationNotSupportedException("ERROR: Movimiento de enroque no válido.");
			}
			break;
		case ENROQUE_LARGO:
			if (posicion.getColumna() == 'a' && (posicion.getFila() == 1 || posicion.getFila() == 8)) {
				setPosicion(new Posicion(posicion.getFila(), 'd'));
			} else {
				throw new OperationNotSupportedException("ERROR: Movimiento de enroque no válido.");
			}
			break;
		default:
			break;
		}
	}

	// Metodos hashCade y equals
	
	@Override
	public int hashCode() {
		return Objects.hash(color, posicion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Torre other = (Torre) obj;
		return color == other.color && Objects.equals(posicion, other.posicion);
	}

}
