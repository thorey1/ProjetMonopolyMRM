package Model;

import Controler.UtilsMono.*;

public class Terrain extends Carreau {
    private int prix;
    private Couleur couleur;
    private Joueur proprietaire;

    public Terrain(int numCarreau, String nomCarreau, TypeCarreau type,int prix, Couleur couleur) {
        super(numCarreau, nomCarreau, type);
        this.prix = prix;
        this.couleur = couleur;
    }
    
    

    public void setProprietaire(Joueur proprietaire) {
        this.proprietaire = proprietaire;
    }
        

    public int getPrix() {
        return prix;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public Joueur getProprietaire() {
        return proprietaire;
    }

    
        
}