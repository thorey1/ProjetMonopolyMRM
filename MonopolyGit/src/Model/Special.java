package Model;

import Enum.TypeCarreau;

public class Special extends Carreau {

    public Special(int numCarreau, String nomCarreau, TypeCarreau type) {
        super(numCarreau, nomCarreau, type);
    }
    
    public int getActionCarreauSpecial(){
        if(super.getNumCarreau()==1){
            return 200;
        }
        return 0;
    }
}