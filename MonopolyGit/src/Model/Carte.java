package Model;


import Enum.TypeCarreau;
import static Enum.TypeCarreau.*;

public class Carte {
	private int numCarte;
	private TypeCarreau type;
        
        public TypeCarreau getTypeCarte(){
            if(type==CHANCE||type==COMMUNAUTE){
                return type;
            }
            return null;
        }
}