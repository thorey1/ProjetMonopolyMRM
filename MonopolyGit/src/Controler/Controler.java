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

    public Controler(HashMap<Integer, Joueur> joueurs, VuePlateau vuePlateau, VueJoueurEtudiant vueJoueur, HashMap<Integer, Carte> cartes, HashMap<Integer, Carreau> carreaux) {
        this.vuePlateau = vuePlateau;
        this.vueJoueur = vueJoueur;
        cartes = new HashMap();
        carreaux = new HashMap();
    }        
        

    public void deplacement() {
            boolean ddouble = true;
            Joueur j = this.getJoueur();
            
            while(ddouble){
                ddouble = false;
                int d1 = this.lancerDe();
                int d2 = this.lancerDe();
                
                if(d1==d2){
                    ddouble=true;
                }
            }
    }

    public Carte tirerCarte() {
        ArrayList pilecartes = this.getCartes(this.getJoueur().getPosition().getTypeCarreau());
        return this.getCarteAlea(pilecartes);
    }

    public Carreau getCarreau(int position) {
            return carreaux.get(position);
    }

    public Carte getCarteAlea(ArrayList<Carte> pileCartes) {
            int nbcartes = pileCartes.size();
            Carte carte = null;
            for (int i = 0 ; i<nbcartes ; i++){
                if ( i== (int) (Math.random()*nbcartes)){
                    carte = pileCartes.get(i);
                }
            }
            return carte;       
    }

    public Carte getCarte(int numCarte){
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

    public Joueur getJoueur() {
        Joueur j = null;
        for (int i = 0;i<joueurs.size();i++){
            if (joueurs.get(i).getTour()){
                j = joueurs.get(i);
            }
        }
        return j;
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
