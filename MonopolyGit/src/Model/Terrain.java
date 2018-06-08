package Model;

import Controler.UtilsMono.*;

public class Terrain extends Carreau {
    private int prix;
    private Couleur couleur;
    private Joueur proprietaire ;
    private int loyer = 10; //standard pour l'instant

    public Terrain(int numCarreau, String nomCarreau, TypeCarreau type,int prix, Couleur couleur) {
        super(numCarreau, nomCarreau, type);
        this.prix = prix;
        this.couleur = couleur;
        this.proprietaire = null;
    }
    
    

    @Override
    public void setProprietaire(Joueur proprietaire) {
        this.proprietaire = proprietaire;
    }
        

    @Override
    public int getPrix() {
        return prix;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    @Override
    public Joueur getProprietaire() {
        return proprietaire;
    }

    @Override
    public int getLoyer(){
        return loyer;
    }

  
        
}