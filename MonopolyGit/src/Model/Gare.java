/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Enum.TypeCarreau;
import java.awt.Color;



/**
 *
 * @author hassanyo
 */
public class Gare extends Terrain{
    
    private int loyer;
    public Gare(int numCarreau, String nomCarreau, TypeCarreau type, int prix, Color couleur) {
        super(numCarreau, nomCarreau, type, prix, couleur);       
    }
    
    public int getloyer(){
        return loyer;
    } 
}
