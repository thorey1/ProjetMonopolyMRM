package Model;

import Controler.UtilsMono.*;
import java.util.HashMap;

public class Joueur {
	private int numJoueur;
	private String nomJoueur;
	private int solde;
	private boolean prisonnier;
	private Carreau position;
	private HashMap<Terrain> proprietes;
        private boolean tour;

        public Joueur(int numJoueur, String nomJoueur, Carreau position) {
            this.numJoueur = numJoueur;
            this.nomJoueur = nomJoueur;
            this.solde = 5000;
            this.prisonnier = false;
            setPosition(position);
            proprietes = new HashMap();
        }
       
        
        
        
	public boolean getPrison() {
		return prisonnier;
	}
        
        public void setPrison(boolean prison) {
		prisonnier=prison;
                
	}

	public Carreau getPosition() {
		return this.position;
	}

	public void setPosition(Carreau position) {
		this.position=position;
	}

        /**
         * @return the numJoueur
         */
        public int getNumJoueur() {
            return numJoueur;
        }

        /**
         * @param numJoueur the numJoueur to set
         */
        public void setNumJoueur(int numJoueur) {
            this.numJoueur = numJoueur;
        }

        /**
         * @return the nomJoueur
         */
        public String getNomJoueur() {
            return nomJoueur;
        }

        /**
         * @param nomJoueur the nomJoueur to set
         */
        public void setNomJoueur(String nomJoueur) {
            this.nomJoueur = nomJoueur;
        }

        /**
         * @return the solde
         */
        public int getSolde() {
            return solde;
        }

        /**
         * @param solde the solde to set
         */
        public void setSolde(int solde) {
            this.solde = solde;
        }
        
        public void addPropriétés (Terrain prop){
            this.proprietes.add(prop);
        }

        public boolean getTour() {
            return tour;
        }
        
        public int getNbProp(Terrain t){
            int nb = 0;
            Couleur c;
            TypeCarreau tc = t.getTypeCarreau();
            
            if(tc == TypeCarreau.GARE || tc == TypeCarreau.COMPAGNIE){              
                for(Terrain terter : proprietes){             
                    if(terter.getTypeCarreau() == tc){
                        nb++;
                    }
                }
            }
            else if(tc == TypeCarreau.TERRAIN){
                c = t.getCouleur();
                for(Terrain terter : proprietes){             
                    if(terter.getCouleur()== c){
                        nb++;
                    }
                }
            }
            return nb;
        }
        
        public void payer(int prix){
            setSolde(solde-prix); 
        }
        
        public void gain(int prix){
            setSolde(solde+prix);
        }
        
}
