package Model;

import java.util.ArrayList;

public class Joueur {
	private int numJoueur;
	private String nomJoueur;
	private int solde;
	private boolean prisonnier;
	private Carreau position;
	private ArrayList<Terrain> terrains;

	public boolean getPrison() {
		return prisonnier;
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
            this.terrains.add(prop);
        }
}