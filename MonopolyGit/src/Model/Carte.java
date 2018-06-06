package Model;


import Controler.UtilsMono.*;
import static Controler.UtilsMono.TypeCarreau.*;


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
