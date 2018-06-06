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

    

    
    
}