/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controler.UtilsMono;

/**
 *
 * @author hassanyo
 */
public class Gare extends Terrain{
    
    private int loyer;
    public Gare(int numCarreau, String nomCarreau, UtilsMono.TypeCarreau type, int prix, UtilsMono.Couleur couleur) {
        super(numCarreau, nomCarreau, type, prix, couleur);       
    }
    
    public int getloyer(){
        return loyer;
    } 

    
    
    //overrides inutilisés mais requis
    @Override
    public int getPrixMais() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getPrixHotel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Propriete getPropriete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
