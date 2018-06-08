package Model;

import Controler.UtilsMono.*;
import static Controler.UtilsMono.TypeCarreau.*;

public class Tirage extends Carreau {

    public Tirage(int numCarreau, String nomCarreau, TypeCarreau type) {
        super(numCarreau, nomCarreau, type);
    }
    
    @Override
    public TypeCarreau getTypeCarreau() {
        if (super.getNumCarreau()==3 || super.getNumCarreau()==18 ||super.getNumCarreau()==34){
            return COMMUNAUTE;
        } else if(super.getNumCarreau()==8 || super.getNumCarreau()==23 || super.getNumCarreau()==37){
            return CHANCE;
        }
        return null;
    }

    @Override
    public int getPrix() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setProprietaire(Joueur proprietaire) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Joueur getProprietaire() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getLoyer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    
    
}