package Model;


import Controler.UtilsMono.*;
import static Controler.UtilsMono.TypeCarreau.*;


public class Carte {
	private int numCarte, prix;
        private String description;
	private TypeCarreau type;
        
        Carte(int numCarte, TypeCarreau type, String description, int prix){
            this.numCarte=numCarte;
            this.type=type;
            this.description=description;
            this.prix=prix;
        }
        
        public TypeCarreau getTypeCarte(){
            if(getType()==CHANCE||getType()==COMMUNAUTE){
                return getType();
            }
            return null;
        }


    public int getNumCarte() {
        return numCarte;
    }


    public int getPrix() {
        return prix;
    }


    public String getDescription() {
        return description;
    }

    
    public TypeCarreau getType() {
        return type;
    }
}
