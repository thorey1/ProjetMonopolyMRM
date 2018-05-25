package Model;

import Enum.TypeCarreau;
import java.util.ArrayList;
import java.util.Vector;

public class Carreau {
	private int numCarreau;
	private String nomCarreau;
	private TypeCarreau type;
	private ArrayList<Joueur> joueurs;

	public String getTypeCarreau() {
		throw new UnsupportedOperationException();
	}

	public int getNumCarreau() {
		return this.numCarreau;
	}
}