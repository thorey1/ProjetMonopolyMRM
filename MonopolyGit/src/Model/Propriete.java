/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controler.UtilsMono;
import Controler.UtilsMono.Couleur;
import java.util.ArrayList;

/**
 *
 * @author hassanyo
 */
public class Propriete extends Terrain{
    private Hotel hotel;
    private ArrayList<Maison> maisons;
    
    public Propriete(int numCarreau, String nomCarreau, UtilsMono.TypeCarreau type, int prix, UtilsMono.Couleur couleur) {
        super(numCarreau, nomCarreau, type, prix, couleur);
        maisons = new ArrayList();
    }
    
    public void addMaison(Maison m){
        maisons.add(m);
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public ArrayList<Maison> getMaisons() {
        return maisons;
    }

    @Override
    public int getPrixMais() {
        Couleur coulCar = super.getCouleur();
        int prixMais = 0;
        if(null != coulCar)switch (coulCar) {
            case MAUVE:
                prixMais = 50;
                break;
            case BLEUCIEL:
                prixMais = 50;
                break;
            case VIOLET:
                prixMais = 100;
                break;
            case ORANGE:
                prixMais = 100;
                break;
            case ROUGE:
                prixMais = 150;
                break;
            case JAUNE:    
                prixMais = 150;
                break;
            case VERT:
                prixMais = 200;
                break;
            case BLEUFONCE:
                prixMais = 200;
                break;
            default:
                break;
        }
        return prixMais;
    }

    @Override
    public int getPrixHotel() {
        Couleur coulCar = super.getCouleur();
        int prixHotel = 0;
        if(null != coulCar)switch (coulCar) {
            case MAUVE:
                prixHotel = 50;
                break;
            case BLEUCIEL:
                prixHotel = 50;
                break;
            case VIOLET:
                prixHotel = 100;
                break;
            case ORANGE:
                prixHotel = 100;
                break;
            case ROUGE:
                prixHotel = 150;
                break;
            case JAUNE:    
                prixHotel = 150;
                break;
            case VERT:
                prixHotel = 200;
                break;
            case BLEUFONCE:
                prixHotel = 200;
                break;
            default:
                break;
        }
        return prixHotel;
    }

    @Override
    public Propriete getPropriete() {
        return this;
    }
    
    
}
