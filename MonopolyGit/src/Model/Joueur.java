package Model;

import java.util.Vector;

public class Joueur {
	private int _numJoueur;
	private String _nomJoueur;
	private int _solde;
	private boolean _prisonnier;
	private Carreau _position;
	private Vector<Terrain> _terrains = new Vector<Terrain>();

	public boolean getPrison() {
		throw new UnsupportedOperationException();
	}

	public Carreau getPosition() {
		return this._position;
	}

	public void setPosition(Object aP) {
		throw new UnsupportedOperationException();
	}
}