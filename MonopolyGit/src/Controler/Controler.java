package Controler;

import Controler.UtilsMono.*;
import static Controler.UtilsMono.Couleur.*;
import static Controler.UtilsMono.TypeCarreau.*;
import Enum.TypesMessages;
import Model.*;
import View.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Controler implements Observateur {
    private HashMap<Integer, Joueur> joueurs;
    public VuePlateau vuePlateau;
    public VueJoueurEtudiant vueJoueur;
    private HashMap<Integer, Carte> cartes;
    private HashMap<Integer, Carreau> carreaux;
    private HashMap<Couleur, Maison> maisons;
    private HashMap<Couleur, Hotel> hotels;

    public Controler(HashMap<Integer, Joueur> joueurs, VuePlateau vuePlateau, VueJoueurEtudiant vueJoueur, HashMap<Integer, Carte> cartes, HashMap<Integer, Carreau> carreaux) {
        this.vuePlateau = vuePlateau;
        this.vueJoueur = vueJoueur;
        cartes = new HashMap();
        carreaux = new HashMap();
        joueurs = new HashMap();
        
        for (int i=1;i<=this.InitialiserHashMapCarreaux().size();i++){
            carreaux.put(i, this.InitialiserHashMapCarreaux().get(i-1));
        }
        
    }     
    
    
    // POUR TEST JEU
    public Controler() {
        cartes = new HashMap();
        carreaux = new HashMap();
        joueurs = new HashMap();
        maisons = new HashMap();
        maisons = InitialiserHashMapMaison();
        hotels = new HashMap();
        hotels = InitialiserHashMapHotel();
        
        for (int i=1;i<=this.InitialiserHashMapCarreaux().size();i++){
            carreaux.put(i, this.InitialiserHashMapCarreaux().get(i-1));
        }
    }  

    public HashMap<Integer, Joueur> getJoueurs() {
        return joueurs;
    }

    public HashMap<Integer, Carte> getCartes() {
        return cartes;
    }

    public HashMap<Integer, Carreau> getCarreaux() {
        return carreaux;
    }    

    public void deplacement(Joueur j) {
            boolean ddouble = true;
            int compteur=0;
            System.out.println("Au tour de " + j.getNomJoueur());
            
            if (j.getPrison()){
                System.out.println("Tu dois faire un double pour sortir de prison ou payer 50€! \n Quel est ton choix?(payer/dé) ");
                Scanner scanner = new Scanner(System.in);
                String rep = scanner.nextLine();
                if ("dé".equals(rep)){
                    System.out.println("Presser entrée pour lancer le premier dé"+ "\n");
                    this.pause();
                    int d1 = this.lancerDe();
                    System.out.println("Voici le premier dé : " + d1 + "\n");
                    System.out.println("Presser entrée pour lancer le deuxième dé" + "\n");
                    this.pause();
                    int d2 = this.lancerDe();
                    System.out.println("Voici le deuxième dé : " + d2 + "\n");
                    
                    if(d1==d2){
                        System.out.println("Vous avez fait un double, vous sortez de prison !");
                        j.setPrison(false);
                        ddouble=false;
                        Carreau newCar = (carreaux.get(11+d1+d2));
                        j.setPosition(newCar);
                        String nomProp = newCar.getNomCarreau();
                        if(newCar.getTypeCarreau() == TypeCarreau.MALUS || newCar.getTypeCarreau() == TypeCarreau.CHANCE || newCar.getTypeCarreau() == TypeCarreau.COMMUNAUTE || newCar.getTypeCarreau() == TypeCarreau.DEPART || newCar.getTypeCarreau() == TypeCarreau.PRISON || newCar.getTypeCarreau() == TypeCarreau.PARC){
                            System.out.println("Tu es sur la case " + nomProp);
                        }
                        else{
                            Joueur proprio = newCar.getProprietaire();
                            if(proprio == null){
                                System.out.println("Tu es sur la propriété " + nomProp + "\n");  
                                System.out.println("Veux-tu acheter(o/n) " + nomProp);
                                scanner = new Scanner(System.in);
                                rep = scanner.nextLine();
                                if("o".equals(rep)){
                                    int prixProp = newCar.getPrix();
                                    j.payer(prixProp);
                                    newCar.setProprietaire(j);
                                    System.out.printf("Tu paies %d la propriété %s\n", prixProp, nomProp);
                                    System.out.println("Il te reste " + j.getSolde());
                                    
                                }
                            }else if(proprio!=null && proprio != j){
                                System.out.println("Tu es sur la propriété " + nomProp + " qui appartient à " + proprio.getNomJoueur() + "\n");
                                j.payer(newCar.getLoyer());
                                proprio.gain(newCar.getLoyer());
                                System.out.println(j.getNomJoueur() + " perd " + newCar.getLoyer()+ ", Il te reste " + j.getSolde());
                                System.out.println(proprio.getNomJoueur() + " gagne " + newCar.getLoyer() + "\n"); 
                            }else{
                                System.out.println("Tu es sur ta propriété! \n");
                            }
                        }
                    }else{
                        ddouble=false;
                        System.out.println("Tu n'as pas fais de double \n Fin du tour \n");
                    }
                }else if("payer".equals(rep)){
                    j.payer(50);
                    j.setPrison(false);
                    System.out.println("Tu as payé 50€!");
                    ddouble=true;
                }
            }
            
            while(ddouble){
                ddouble = false;
                System.out.println("Presser entrée pour lancer le premier dé"+ "\n");
                this.pause();
                int d1 = this.lancerDe();
                System.out.println("Voici le premier dé : " + d1 + "\n");
                System.out.println("Presser entrée pour lancer le deuxième dé" + "\n");
                this.pause();
                int d2 = this.lancerDe();
                System.out.println("Voici le deuxième dé : " + d2 + "\n");
                
                
                if(d1==d2){
                    System.out.println("Vous avez fait un double !");
                    ddouble=true;
                    compteur = compteur+1;
                }
                if (compteur==3){
                    j.setPrison(true);
                    j.setPosition(carreaux.get(11)); 
                    System.out.println("Vous avez fais 3 double, vous allez directement en prison");
                    System.out.println("Fin du tour");
                    break;
                }
                
                int pos=j.getPosition().getNumCarreau();
                int newPos = pos+d1+d2;
                Carreau newCar;
                
                if(j.getPosition().getNumCarreau()+d1+d2> carreaux.size()){
                    newCar = carreaux.get(newPos%carreaux.size());
                    j.setPosition(newCar);
                    System.out.println("Passage par la case départ, tu gagnes 200€!! \n \t Bilan solde : " + j.getSolde() +"\n");
                    j.gain(200);
                }else{
                    newCar = carreaux.get(newPos);
                    j.setPosition(newCar);
                }         
                
                
                
                
                String nomProp = newCar.getNomCarreau();
                if(newCar.getTypeCarreau() == TypeCarreau.MALUS || newCar.getTypeCarreau() == TypeCarreau.CHANCE || newCar.getTypeCarreau() == TypeCarreau.COMMUNAUTE || newCar.getTypeCarreau() == TypeCarreau.DEPART || newCar.getTypeCarreau() == TypeCarreau.PARC){
                    System.out.println("Tu es sur la case " + nomProp);
                }else if(newCar.getTypeCarreau() == TypeCarreau.PRISON){
                    j.setPrison(true);
                    j.setPosition(carreaux.get(11));
                    System.out.println("Tu es sur la case " + nomProp);
                    System.out.println("Fin du tour \n");
                    break;
                }
                else{
                    Joueur proprio = newCar.getProprietaire();
                    if(proprio == null){
                        System.out.println("Tu es sur la propriété " + nomProp + "\n");  
                        System.out.println("Veux-tu acheter(o/n) " + nomProp);
                        Scanner scanner = new Scanner(System.in);
                        String rep = scanner.nextLine();
                        if("o".equals(rep)){
                            int prixProp = newCar.getPrix();
                            j.payer(prixProp);
                            newCar.setProprietaire(j);
                            System.out.printf("Tu paies %d la propriété %s\n", prixProp, nomProp);
                            System.out.println("Il te reste " + j.getSolde());
                            //
                            
                            System.out.println("Veux tu construire un hotel ?(o/n)");
                                    rep = scanner.nextLine();
                                    if("o".equals(rep)){
                                        this.construire(j, newCar.getPropriete());
                                    }
                        }
                    }else if(proprio!=null && proprio != j){
                        System.out.println("Tu es sur la propriété " + nomProp + " qui appartient à " + proprio.getNomJoueur() + "\n");
                        j.payer(newCar.getLoyer());
                        proprio.gain(newCar.getLoyer());
                        System.out.println(j.getNomJoueur() + " perd " + newCar.getLoyer()+ ", Il te reste " + j.getSolde());
                        System.out.println(proprio.getNomJoueur() + " gagne " + newCar.getLoyer() + "\n"); 
                    }else{
                        System.out.println("Tu es sur ta propriété! \n");
                    }
                }
                System.out.println("Fin du tour \n");
                
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
        for (int i = 1;i<joueurs.size();i++){
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
        Terrain t2 = new Propriete(2,"Boulevard de Belleville",TERRAIN,60,MAUVE);
        Special t3 = new Special(3,"Caisse de communauté",COMMUNAUTE);
        Terrain t4 = new Propriete(4,"Rue Lecourbe",TERRAIN,60,MAUVE);
        Malus t5 = new Malus(5, "Impôts sur le revenu", MALUS, 200);
        Terrain t6 = new Propriete(6, "Gare Montparnasse", GARE, 200,null);
        Terrain t7 = new Propriete(7,"Rue de Vaugirard",TERRAIN,100,BLEUCIEL);
        Special t8 = new Special(8,"Chance",CHANCE);
        Terrain t9 = new Propriete(9,"Rue de Courcelles",TERRAIN,100,BLEUCIEL);
        Terrain t10 = new Propriete(10,"Avenue de la République",TERRAIN,120,BLEUCIEL);
        Special t11 = new Special(11,"En prison/Simple visite", PARC);
        Terrain t12 = new Propriete(12,"Boulevard de la Villette",TERRAIN,140,VIOLET);
        Terrain t13 = new Propriete(13, "Compagnie de distribution d'électricité",COMPAGNIE,150,GRIS);
        Terrain t14 = new Propriete(14,"Avenue de Neuilly",TERRAIN,140,VIOLET);
        Terrain t15 = new Propriete(15,"Rue de Paradis",TERRAIN,160,VIOLET);
        Terrain t16 = new Propriete(16, "Gare de Lyon", GARE, 200,null);
        Terrain t17 = new Propriete(17,"Avenue Mozart",TERRAIN,180,ORANGE);
        Special t18 = new Special(18,"Caisse de communauté",COMMUNAUTE);
        Terrain t19 = new Propriete(19,"Boulevard Saint-Michel",TERRAIN,180,ORANGE);
        Terrain t20 = new Propriete(20,"Place Pigalle",TERRAIN,200,ORANGE);
        Special t21 = new Special(21,"Parc Gratuit",PARC);
        Terrain t22 = new Propriete(22,"Avenue Matignon",TERRAIN,220,ROUGE);
        Special t23 = new Special(23,"Chance",CHANCE);
        Terrain t24 = new Propriete(24,"Boulevard Malesherbes",TERRAIN,220,ROUGE);
        Terrain t25 = new Propriete(25,"Avenue Henri-Martin",TERRAIN,240,ROUGE);
        Terrain t26 = new Propriete(26, "Gare du Nord", GARE, 200,null);
        Terrain t27 = new Propriete(27,"Faubourg Saint-Honoré",TERRAIN,260,JAUNE);
        Terrain t28 = new Propriete(28,"Place de la Bourse",TERRAIN,260,JAUNE);
        Terrain t29 = new Propriete(29, "Compagnie de distribution des eaux",COMPAGNIE,150,GRIS);
        Terrain t30 = new Propriete(30,"Rue de la Fayette",TERRAIN,280,JAUNE); 
        Special t31 = new Special(31,"Allez en Prison",PRISON);
        Terrain t32 = new Propriete(32,"Avenue de Breteuil",TERRAIN,300,VERT);    
        Terrain t33 = new Propriete(33,"Avenue Foch",TERRAIN,300,VERT);    
        Special t34 = new Special(34,"Caisse de communauté",COMMUNAUTE);
        Terrain t35 = new Propriete(35,"Boulevard des Capucines",TERRAIN,320,VERT);   
        Terrain t36 = new Propriete(36, "Gare Saint-Lazare", GARE, 200,null);
        Special t37 = new Special(37,"Chance",CHANCE);
        Terrain t38 = new Propriete(38,"Avenue des Champs-Elysées",TERRAIN,350,BLEUFONCE); 
        Malus t39 = new Malus(39, "Taxe de Luxe", MALUS, 200);
        Terrain t40 = new Propriete(40,"Rue de la Paix",TERRAIN,400,BLEUFONCE);    
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
    
    public HashMap<Couleur, Maison> InitialiserHashMapMaison(){
        Maison m1 = new Maison(Couleur.MAUVE, 50);
        Maison m2 = new Maison(Couleur.BLEUCIEL, 50);
        Maison m3 = new Maison(Couleur.VIOLET, 100);
        Maison m4 = new Maison(Couleur.ORANGE, 100);
        Maison m5 = new Maison(Couleur.ROUGE, 150);
        Maison m6 = new Maison(Couleur.JAUNE, 150);
        Maison m7 = new Maison(Couleur.VERT, 200);
        Maison m8 = new Maison(Couleur.BLEUFONCE, 200);
        
        HashMap<Couleur, Maison> maisons = new HashMap();
        
        maisons.put(Couleur.MAUVE, m1);
        maisons.put(Couleur.BLEUCIEL, m2);
        maisons.put(Couleur.VIOLET, m3);
        maisons.put(Couleur.ORANGE, m4);
        maisons.put(Couleur.ROUGE, m5);
        maisons.put(Couleur.JAUNE, m6);
        maisons.put(Couleur.VERT, m7);
        maisons.put(Couleur.BLEUFONCE, m8);
        
        return maisons;
    }
    
    public HashMap<Couleur, Hotel> InitialiserHashMapHotel(){
        Hotel m1 = new Hotel(Couleur.MAUVE, 50);
        Hotel m2 = new Hotel(Couleur.BLEUCIEL, 50);
        Hotel m3 = new Hotel(Couleur.VIOLET, 100);
        Hotel m4 = new Hotel(Couleur.ORANGE, 100);
        Hotel m5 = new Hotel(Couleur.ROUGE, 150);
        Hotel m6 = new Hotel(Couleur.JAUNE, 150);
        Hotel m7 = new Hotel(Couleur.VERT, 200);
        Hotel m8 = new Hotel(Couleur.BLEUFONCE, 200);
        
        HashMap<Couleur, Hotel> hotels = new HashMap();
        
        hotels.put(Couleur.MAUVE, m1);
        hotels.put(Couleur.BLEUCIEL, m2);
        hotels.put(Couleur.VIOLET, m3);
        hotels.put(Couleur.ORANGE, m4);
        hotels.put(Couleur.ROUGE, m5);
        hotels.put(Couleur.JAUNE, m6);
        hotels.put(Couleur.VERT, m7);
        hotels.put(Couleur.BLEUFONCE, m8);
        
        return hotels;
    }
    
    public void pause(){
        System.out.println("Press \"ENTER\" to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
    
    public void commencerJeu(){
        Joueur j1 = new Joueur(1, "Malo", this.getCarreaux().get(1));
        Joueur j2 = new Joueur(2, "Youssef", this.getCarreaux().get(1));
        //Joueur j3 = new Joueur(3, "O'Neal", this.getCarreaux().get(1));
        //Joueur j4 = new Joueur(4, "Rémi", this.getCarreaux().get(1));
        //Joueur j5 = new Joueur(5, "Yann", this.getCarreaux().get(1));
        //Joueur j6 = new Joueur(6, "Quentin", this.getCarreaux().get(1));
        
        
        joueurs.put(1, j1);
        joueurs.put(2, j2);
        //joueurs.put(3, j3);
        //joueurs.put(4, j4);
        //joueurs.put(5, j5);
        //joueurs.put(6, j6);
        
        for (int j=0; j<50;j++){
            for (int i = 1; i<=joueurs.size();i++){
                System.out.println("------------------------------------------------");
                deplacement(joueurs.get(i));
                System.out.println("------------------------------------------------");
            }
        }
    }
    
    public void construire(Joueur j, Propriete p){
        Carreau carCourant = carreaux.get(p.getNumCarreau());
        Couleur coul = carCourant.getPropriete().getCouleur(); 
        
        if(p.getMaisons().isEmpty()){   
            Maison maison = maisons.get(coul);
            j.payer(maison.getPrix());
            carCourant.getPropriete().addMaison(maison);
            
        } else if(p.getMaisons().size() == 4){
            p.getMaisons().clear();
            Hotel hotel = hotels.get(coul);
            carCourant.getPropriete().setHotel(hotel);
            j.payer(hotel.getPrix());
        }    
    }

    @Override
    public void traiterMessage(Message m) {
        faireAction(m);
    }   
      
}
