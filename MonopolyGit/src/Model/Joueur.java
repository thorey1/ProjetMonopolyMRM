package Model;

import java.util.ArrayList;

public class Joueur {
	private int numJoueur;
	private String nomJoueur;
	private int solde;
	private boolean prisonnier;
	private Carreau position;
	private ArrayList<Terrain> terrains;

	public boolean getPrison() {
		throw new UnsupportedOperationException();
	}

	public Carreau getPosition() {
		return this.position;
	}

	public void setPosition(Carreau position) {
		throw new UnsupportedOperationException();
	}
}