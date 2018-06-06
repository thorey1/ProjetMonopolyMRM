package Controler;

import Controler.UtilsMono.*;
import static Controler.UtilsMono.Couleur.*;
import static Controler.UtilsMono.TypeCarreau.*;
import Enum.TypesMessages;
import Model.*;
import View.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Controler implements Observateur {
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
        
        for (int i=1;i<=this.InitialiserHashMapCarreaux().size();i++){
            carreaux.put(i, this.InitialiserHashMapCarreaux().get(i-1));
        }
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

//    public void traiterMessage() {
  //          throw new UnsupportedOperationException();
    //}

    public int lancerDe() {
            return (int) ((Math.random()*6)+1);
    }
    
    
    private void faireAction(Message m) {
        if (m.type==TypesMessages.JOUER){
         
        }
    }
   
// public int getNewPosition() {
     //       throw new UnsupportedOperationException();
    //}
    
    public ArrayList<Carreau> InitialiserHashMapCarreaux(){
        Special t1 = new Special(1,"Départ",DEPART);
        Terrain t2 = new Terrain(2,"Boulevard de Belleville",TERRAIN,60,MAUVE);
        Special t3 = new Special(3,"Caisse de communauté",COMMUNAUTE);
        Terrain t4 = new Terrain(4,"Rue Lecourbe",TERRAIN,60,MAUVE);
        Malus t5 = new Malus(5, "Impôts sur le revenu", MALUS, 200);
        Terrain t6 = new Terrain(6, "Gare Montparnasse", GARE, 200,null);
        Terrain t7 = new Terrain(7,"Rue de Vaugirard",TERRAIN,100,BLEUCIEL);
        Special t8 = new Special(8,"Chance",CHANCE);
        Terrain t9 = new Terrain(9,"Rue de Courcelles",TERRAIN,100,BLEUCIEL);
        Terrain t10 = new Terrain(10,"Avenue de la République",TERRAIN,120,BLEUCIEL);
        Special t11 = new Special(11,"En prison/Simple visite", PRISON);
        Terrain t12 = new Terrain(12,"Boulevard de la Villette",TERRAIN,140,VIOLET);
        Terrain t13 = new Terrain(13, "Compagnie de distribution d'électricité",COMPAGNIE,150,GRIS);
        Terrain t14 = new Terrain(14,"Avenue de Neuilly",TERRAIN,140,VIOLET);
        Terrain t15 = new Terrain(15,"Rue de Paradis",TERRAIN,160,VIOLET);
        Terrain t16 = new Terrain(16, "Gare de Lyon", GARE, 200,null);
        Terrain t17 = new Terrain(17,"Avenue Mozart",TERRAIN,180,ORANGE);
        Special t18 = new Special(18,"Caisse de communauté",COMMUNAUTE);
        Terrain t19 = new Terrain(19,"Boulevard Saint-Michel",TERRAIN,180,ORANGE);
        Terrain t20 = new Terrain(20,"Place Pigalle",TERRAIN,200,ORANGE);
        Special t21 = new Special(21,"Parc Gratuit",PARC);
        Terrain t22 = new Terrain(22,"Avenue Matignon",TERRAIN,220,ROUGE);
        Special t23 = new Special(23,"Chance",CHANCE);
        Terrain t24 = new Terrain(24,"Boulevard Malesherbes",TERRAIN,220,ROUGE);
        Terrain t25 = new Terrain(25,"Avenue Henri-Martin",TERRAIN,240,ROUGE);
        Terrain t26 = new Terrain(26, "Gare du Nord", GARE, 200,null);
        Terrain t27 = new Terrain(27,"Faubourg Saint-Honoré",TERRAIN,260,JAUNE);
        Terrain t28 = new Terrain(28,"Place de la Bourse",TERRAIN,260,JAUNE);
        Terrain t29 = new Terrain(29, "Compagnie de distribution des eaux",COMPAGNIE,150,GRIS);
        Terrain t30 = new Terrain(30,"Rue de la Fayette",TERRAIN,280,JAUNE); 
        Special t31 = new Special(31,"Allez en Prison",PRISON);
        Terrain t32 = new Terrain(32,"Avenue de Breteuil",TERRAIN,300,VERT);    
        Terrain t33 = new Terrain(33,"Avenue Foch",TERRAIN,300,VERT);    
        Special t34 = new Special(34,"Caisse de communauté",COMMUNAUTE);
        Terrain t35 = new Terrain(35,"Boulevard des Capucines",TERRAIN,320,VERT);   
        Terrain t36 = new Terrain(36, "Gare Saint-Lazare", GARE, 200,null);
        Special t37 = new Special(37,"Chance",CHANCE);
        Terrain t38 = new Terrain(38,"Avenue des Champs-Elysées",TERRAIN,350,BLEUFONCE); 
        Malus t39 = new Malus(39, "Taxe de Luxe", MALUS, 200);
        Terrain t40 = new Terrain(40,"Rue de la Paix",TERRAIN,400,BLEUFONCE);    
        ArrayList<Carreau> casecar = new ArrayList();
        casecar.add(t1);
        casecar.add(t2);
        casecar.add(t3);
        casecar.add(t4);
        casecar.add(t5);
        casecar.add(t6);
        casecar.add(t7);
        casecar.add(t8);
        casecar.add(t9);
        casecar.add(t10);
        casecar.add(t11);
        casecar.add(t12);
        casecar.add(t13);
        casecar.add(t14);
        casecar.add(t15);
        casecar.add(t16);
        casecar.add(t17);
        casecar.add(t18);
        casecar.add(t19);
        casecar.add(t20);
        casecar.add(t21);
        casecar.add(t22);
        casecar.add(t23);
        casecar.add(t24);
        casecar.add(t25);
        casecar.add(t26);
        casecar.add(t27);
        casecar.add(t28);
        casecar.add(t29);
        casecar.add(t30);
        casecar.add(t31);
        casecar.add(t32);
        casecar.add(t33);
        casecar.add(t34);
        casecar.add(t35);
        casecar.add(t36);
        casecar.add(t37);
        casecar.add(t38);
        casecar.add(t39);
        casecar.add(t40);
        return casecar;
    }

    
    

    @Override
    public void traiterMessage(Message m) {
        faireAction(m);
    }
    

    
  
}
