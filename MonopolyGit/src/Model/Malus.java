package Model;

import Enum.TypeCarreau;

public class Malus extends Carreau {
    private int taxe;

    public Malus(int numCarreau, String nomCarreau, TypeCarreau type, int taxe) {
        super(numCarreau, nomCarreau, type);
        this.taxe=taxe;
    }

    public int getTaxe() {
        return taxe;
    }
    
    
    
}