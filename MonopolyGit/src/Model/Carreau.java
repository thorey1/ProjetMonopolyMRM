package Model;

import Enum.TypeCarreau;
import java.util.ArrayList;
import java.util.Vector;

public class Carreau {
	private int numCarreau;
	private String nomCarreau;
	private TypeCarreau type;
	private ArrayList<Joueur> joueurs;

	public TypeCarreau getTypeCarreau() {
		return type;
	}

	public int getNumCarreau() {
		return this.numCarreau;
	}
}