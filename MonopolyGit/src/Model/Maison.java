/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controler.UtilsMono.Couleur;

/**
 *
 * @author hassanyo
 */
public class Maison {
    private int prix;
    private Propriete propriete;
    private Couleur couleur;
    
    public Maison(Couleur couleur, int prix){
        this.couleur = couleur;
        this.prix = prix;
    }

    public int getPrix() {
        return prix;
    }

    public Couleur getCouleur() {
        return couleur;
    }  

    public Propriete getPropriete() {
        return propriete;
    }      
    
}
