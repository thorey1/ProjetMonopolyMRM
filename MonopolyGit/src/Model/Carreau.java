package Model;

import Enum.TypeCarreau;
import java.util.ArrayList;
import java.util.Vector;

public class Carreau {
    private int numCarreau;
    private String nomCarreau;
    private TypeCarreau type;
    private ArrayList<Joueur> joueurs;

    public Carreau(int numCarreau, String nomCarreau, TypeCarreau type) {
        this.numCarreau = numCarreau;
        this.nomCarreau = nomCarreau;
        this.type = type;
        joueurs = new ArrayList();
    }

    public TypeCarreau getTypeCarreau() {
            return type;
    }

    public int getNumCarreau() {
            return this.numCarreau;
    }

    public String getNomCarreau() {
        return nomCarreau;
    }
        
        
}