package Controler;

import Enum.TypeCarreau;
import Model.*;
import View.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Controler {
	private HashMap<Integer, Joueur> joueurs;
	public VuePlateau vuePlateau;
	public VueJoueurEtudiant vueJoueur;
	private HashMap<Integer, Carte> cartes;
	private HashMap<Integer, Carreau> carreaux;

	public void deplacement() {
		throw new UnsupportedOperationException();
	}

	public Carte tirerCarte() {
            
            
            
            return cartes.get(this.getCarteAlea(cartes.size()));
	}

	public Carreau getCarreau(int position) {
		return carreaux.get(position);
	}

	public int getCarteAlea(ArrayList<Carte> pileCartes) {
		int nbcartes = pileCartes.size();
                return (int) ((Math.random()*nbcartes)+1);
	}

	public Carte getCarte(int numCarte) {
		return cartes.get(numCarte);
	}

	public void appliquerAction() {
		throw new UnsupportedOperationException();
	}

	public ArrayList<Carte> getCartes(TypeCarreau tc) {
            ArrayList pilecarte = new ArrayList();
            for (int i=0;i<cartes.size();i++){
                if (cartes.get(i).getTypeCarte()==tc){
                    pilecarte.add(cartes.get(i));
                }
            }
            return pilecarte;
        }       
                
	public Joueur getJoueur(int numJoueur) {
		return joueurs.get(numJoueur);
	}

	public void traiterMessage() {
		throw new UnsupportedOperationException();
	}

	public int lancerDe() {
		return (int) ((Math.random()*6)+1);
        }

	public int getNewPosition() {
		throw new UnsupportedOperationException();
	} 
       
        
        
        //ui
        
}
