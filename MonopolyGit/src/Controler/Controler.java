package Controler;

import Controler.UtilsMono.*;
import static Controler.UtilsMono.Couleur.*;
import static Controler.UtilsMono.TypeCarreau.*;
import Model.*;
import View.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Controler {
    private HashMap<Integer, Joueur> joueurs;
    public VuePlateau vuePlateau;
    public VueJoueurEtudiant vueJoueur;
    private HashMap<Integer, Carte> cartes;
    private HashMap<Integer, Carreau> carreaux;

    public Controler(HashMap<Integer, Joueur> joueurs, VuePlateau vuePlateau, VueJoueurEtudiant vueJoueur, HashMap<Integer, Carte> cartes, HashMap<Integer, Carreau> carreaux) {
        this.vuePlateau = vuePlateau;
        this.vueJoueur = vueJoueur;
        cartes = new HashMap();
        carreaux = new HashMap();
    }        
        

    public void deplacement() {
            boolean ddouble = true;
            int compteur=0;
            Joueur j = this.getJoueur();
            
            while(ddouble){
                ddouble = false;
                int d1 = this.lancerDe();
                int d2 = this.lancerDe();
                
                if(d1==d2){
                    ddouble=true;
                    compteur = compteur+1;
                }
                if (compteur==3){
                    j.setPrison(true);
                    j.setPosition(carreaux.get(11)); 
                    break;
                }
                
                int pos=j.getPosition().getNumCarreau();
                j.setPosition(carreaux.get(pos));
                
                //faireAction(carreaux.get(pos), j);
            }
    }

    public Carte tirerCarte() {
        ArrayList pilecartes = this.getCartes(this.getJoueur().getPosition().getTypeCarreau());
        return this.getCarteAlea(pilecartes);
    }

    public Carreau getCarreau(int position) {
            return carreaux.get(position);
    }

    public Carte getCarteAlea(ArrayList<Carte> pileCartes) {
            int nbcartes = pileCartes.size();
            Carte carte = null;
            for (int i = 0 ; i<nbcartes ; i++){
                if ( i== (int) (Math.random()*nbcartes)){
                    carte = pileCartes.get(i);
                }
            }
            return carte;       
    }

    public Carte getCarte(int numCarte){
        return cartes.get(numCarte);
    }

   
    public ArrayList<Carte> getCartes(TypeCarreau tc) {
        ArrayList pilecarte = new ArrayList();
        for (int i=0;i<cartes.size();i++){
            if (cartes.get(i).getTypeCarte()==tc){
                pilecarte.add(cartes.get(i));
            }
        }
        return pilecarte;
    }       

    public Joueur getJoueur() {
        Joueur j = null;
        for (int i = 0;i<joueurs.size();i++){
            if (joueurs.get(i).getTour()){
                j = joueurs.get(i);
            }
        }
        return j;
    }

    public void traiterMessage() {
            throw new UnsupportedOperationException();
    }

    public int lancerDe() {
            return (int) ((Math.random()*6)+1);
    }

    public int getNewPosition() {
            throw new UnsupportedOperationException();
    } 


    private Special t1 = new Special(1,"Départ",DEPART);
    private Terrain t2 = new Terrain(2,"Boulevard de Belleville",TERRAIN,60,MAUVE);
    private Special t3 = new Special(3,"Caisse de communauté",COMMUNAUTE);
    private Terrain t4 = new Terrain(4,"Rue Lecourbe",TERRAIN,60,MAUVE);
    private Malus t5 = new Malus(5, "Impôts sur le revenu", MALUS, 200);
    private Terrain t6 = new Terrain(6, "Gare Montparnasse", GARE, 200,GRIS);
    private Terrain t7 = new Terrain(7,"Rue de Vaugirard",TERRAIN,100,BLEUCIEL);
    private Special t8 = new Special(8,"Chance",CHANCE);
    private Terrain t9 = new Terrain(9,"Rue de Courcelles",TERRAIN,100,BLEUCIEL);
    private Terrain t10 = new Terrain(10,"Avenue de la République",TERRAIN,120,BLEUCIEL);
    private Special t11 = new Special(11,"En prison/Simple visite", PRISON);
    private Terrain t12 = new Terrain(12,"Boulevard de la Villette",TERRAIN,140,VIOLET);
    private Terrain t13 = new Terrain(13, "Compagnie de distribution d'électricité",COMPAGNIE,150,GRIS);
    private Terrain t14 = new Terrain(14,"Avenue de Neuilly",TERRAIN,140,VIOLET);
    private Terrain t15 = new Terrain(15,"Rue de Paradis",TERRAIN,160,VIOLET);
    private Terrain t17 = new Terrain(17,"Avenue Mozart",TERRAIN,180,ORANGE);
    
    private Terrain t19 = new Terrain(19,"Boulevard Saint-Michel",TERRAIN,180,ORANGE);
    private Terrain t20 = new Terrain(20,"Place Pigalle",TERRAIN,200,ORANGE);
    
    private Terrain t22 = new Terrain(22,"Avenue Matignon",TERRAIN,220,ROUGE);
    
    private Terrain t24 = new Terrain(24,"Boulevard Malesherbes",TERRAIN,220,ROUGE);
    private Terrain t25 = new Terrain(25,"Avenue Henri-Martin",TERRAIN,240,ROUGE);
    
    private Terrain t27 = new Terrain(27,"Faubourg Saint-Honoré",TERRAIN,260,JAUNE);
    private Terrain t28 = new Terrain(28,"Place de la Bourse",TERRAIN,260,JAUNE);
    
    private Terrain t30 = new Terrain(30,"Rue de la Fayette",TERRAIN,280,JAUNE); 
    
    private Terrain t32 = new Terrain(32,"Avenue de Breteuil",TERRAIN,300,VERT);    
    private Terrain t33 = new Terrain(33,"Avenue Foch",TERRAIN,300,VERT);    
    
    private Terrain t35 = new Terrain(35,"Boulevard des Capucines",TERRAIN,320,VERT);   
    
    private Terrain t38 = new Terrain(38,"Avenue des Champs-Elysées",TERRAIN,350,BLEUFONCE); 
    
    private Terrain t40 = new Terrain(40,"Rue de la Paix",TERRAIN,400,BLEUFONCE);    
  
}
