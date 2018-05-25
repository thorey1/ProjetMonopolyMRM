package Model;

import java.util.Vector;

public class Carreau {
	private int _numCarreau;
	private String _nomCarreau;
	private TypeCarreau _type;
	private Vector<Joueur> _joueurs = new Vector<Joueur>();

	public String getTypeCarreau() {
		throw new UnsupportedOperationException();
	}

	public int getNumCarreau() {
		return this._numCarreau;
	}
}