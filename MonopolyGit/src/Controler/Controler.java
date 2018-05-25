package Controler;

import Model.Carreau;
import Model.Carte;
import Model.Joueur;
import java.util.Vector;
import View.VuePlateau;
import View.VueJoueur;

public class Controler {
	private Vector<Joueur> _joueurs = new Vector<Joueur>();
	public VuePlateau _vuePlateau;
	public VueJoueur _vueJoueur;
	private Carte _cartes;
	private Carreau _carreaux;

	public void deplacement() {
		throw new UnsupportedOperationException();
	}

	public Carte tirerCarte() {
		throw new UnsupportedOperationException();
	}

	public Carreau getCarreau(Object aPosition) {
		throw new UnsupportedOperationException();
	}

	public int getCarteAlea(Object aCollecC) {
		throw new UnsupportedOperationException();
	}

	public Carte getCarte(Object aNumCarte) {
		throw new UnsupportedOperationException();
	}

	public void appliquerAction() {
		throw new UnsupportedOperationException();
	}

	public void getCartes(Object aT) {
		throw new UnsupportedOperationException();
	}

	public Joueur getJoueur() {
		throw new UnsupportedOperationException();
	}

	public void traiterMessage() {
		throw new UnsupportedOperationException();
	}

	public int lancerDe() {
		throw new UnsupportedOperationException();
	}

	public int getNewPosition() {
		throw new UnsupportedOperationException();
	}
}