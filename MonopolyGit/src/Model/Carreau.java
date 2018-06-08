package Model;

import Controler.UtilsMono.*;
import java.util.ArrayList;
import java.util.Vector;

public abstract class Carreau {
    private int numCarreau;
    private String nomCarreau;
    private TypeCarreau type;
    private ArrayList<Joueur> joueurs;

    public Carreau(int numCarreau, String nomCarreau, TypeCarreau type) {
        this.numCarreau = numCarreau;
        this.nomCarreau = nomCarreau;
        this.type = type;
        joueurs = new ArrayList();
    }

    public TypeCarreau getTypeCarreau() {
            return type;
    }

    public int getNumCarreau() {
            return this.numCarreau;
    }

    public String getNomCarreau() {
        return nomCarreau;
    }
    
    public void addJoueur(Joueur j){
        joueurs.add(j);
    }
    
    public abstract int getPrix();

    public abstract void setProprietaire(Joueur proprietaire);
    
    public abstract Joueur getProprietaire();

    public abstract int getLoyer();
        
}