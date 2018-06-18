/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author tostonr
 */
public class IHM {

    /**
     * @param args the command line arguments
     */
     
    public static void main(String[] args) {
        // TODO code application logic here
   JFrame fenetre = new JFrame();
   fenetre.setTitle("Monopoly");
   fenetre.setSize(1920, 1080);
   fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
   JLabel nom = new JLabel("Nom joueur");
   JLabel argent = new JLabel("Argent joueur");
   JButton lancer = new JButton("Lancer les dès");
   JButton acheter = new JButton("Acheter");
   JButton b3 = new JButton("Bouton 3");
   JButton b4 = new JButton("Bouton 4");
   JButton fin = new JButton("Fin du tour");
   JTextField p1 = new JTextField("Propriété 1");
   JTextField p2 = new JTextField("Propriété 2");
   JTextField p3 = new JTextField("Propriété 3");
   JTextField p4 = new JTextField("Propriété 4");
   JTextField p5 = new JTextField("Propriété 5");
   JTextField p6 = new JTextField("Propriété 6");
   JPanel commande = new JPanel();
   commande.setLayout(new GridLayout(13,0));
   commande.add(nom);
   commande.add(argent);
   commande.add(lancer);
   commande.add(acheter);
   commande.add(b3);
   commande.add(b4);
   commande.add(fin);
   commande.add(p1);
   commande.add(p2);
   commande.add(p3);
   commande.add(p4);
   commande.add(p5);
   commande.add(p6);
   Dimension dim = new Dimension(600,1080);
   commande.setPreferredSize(dim);
   Border cadre = BorderFactory.createLineBorder(Color.black);
   commande.setBorder(cadre);
   fenetre.add(commande, BorderLayout.WEST);
   
   
   
   
   
   JPanel plateau = new JPanel();
   
   plateau.setLayout(new GridLayout(11,11));
   
   
   
   
   
   for( int i = 1; i <= 121;i++){
       JPanel car = new JPanel();
       JPanel carLab = new JPanel();
       switch(i){
           case 1 : car.setLayout(new BorderLayout());
                     //carLab.setBorder(cadre);
                     //carLab.setBackground(Color.red);
                     car.setBorder(cadre);
                     car.add(carLab, BorderLayout.SOUTH);
                     plateau.add(car);
                     break;   
           
           case 2 : car.setLayout(new BorderLayout());
                     carLab.setBorder(cadre);
                     carLab.setBackground(Color.red);
                     car.setBorder(cadre);
                     car.add(carLab, BorderLayout.SOUTH);
                     plateau.add(car);
                     break;
           case 3 : car.setLayout(new BorderLayout());
                     //carLab.setBorder(cadre);
                     //carLab.setBackground(Color.red);
                     car.setBorder(cadre);
                     car.add(carLab, BorderLayout.SOUTH);
                     plateau.add(car);
                     break;   
            case 4 : car.setLayout(new BorderLayout());
                     carLab.setBorder(cadre);
                     carLab.setBackground(Color.red);
                     car.setBorder(cadre);
                     car.add(carLab, BorderLayout.SOUTH);
                     plateau.add(car);
                     break;
                     
            case 5 : car.setLayout(new BorderLayout());
                     carLab.setBorder(cadre);
                     carLab.setBackground(Color.red);
                     car.setBorder(cadre);
                     car.add(carLab, BorderLayout.SOUTH);
                     plateau.add(car);
                     break;
            case 6 : car.setLayout(new BorderLayout());
                     //carLab.setBorder(cadre);
                     //carLab.setBackground(Color.red);
                     car.setBorder(cadre);
                     car.add(carLab, BorderLayout.SOUTH);
                     plateau.add(car);
                     break;   
            case 7 : car.setLayout(new BorderLayout());
                     carLab.setBorder(cadre);
                     carLab.setBackground(Color.yellow);
                     car.setBorder(cadre);
                     car.add(carLab, BorderLayout.SOUTH);
                     plateau.add(car);
                     break;
                     
            case 8 : car.setLayout(new BorderLayout());
                     carLab.setBorder(cadre);
                     carLab.setBackground(Color.yellow);
                     car.setBorder(cadre);
                     car.add(carLab, BorderLayout.SOUTH);
                     plateau.add(car);
                     break;
            case 9 : car.setLayout(new BorderLayout());
                     //carLab.setBorder(cadre);
                     //carLab.setBackground(Color.red);
                     car.setBorder(cadre);
                     car.add(carLab, BorderLayout.SOUTH);
                     plateau.add(car);
                     break;   
            case 10 : car.setLayout(new BorderLayout());
                     carLab.setBorder(cadre);
                     carLab.setBackground(Color.yellow);
                     car.setBorder(cadre);
                     car.add(carLab, BorderLayout.SOUTH);
                     plateau.add(car);
                     break;
            case 11 : car.setLayout(new BorderLayout());
                     //carLab.setBorder(cadre);
                     //carLab.setBackground(Color.red);
                     car.setBorder(cadre);
                     car.add(carLab, BorderLayout.SOUTH);
                     plateau.add(car);
                     break;
            case 12 : car.setLayout(new BorderLayout());
                     carLab.setBorder(cadre);
                     carLab.setBackground(Color.orange);
                     car.setBorder(cadre);
                     car.add(carLab, BorderLayout.EAST);
                     plateau.add(car);
                     break;
            case 22 : car.setLayout(new BorderLayout());
                     carLab.setBorder(cadre);
                     carLab.setBackground(Color.green);
                     car.setBorder(cadre);
                     car.add(carLab, BorderLayout.WEST);
                     plateau.add(car);
                     break;   
           
           case 23 : car.setLayout(new BorderLayout());
                     carLab.setBorder(cadre);
                     carLab.setBackground(Color.orange);
                     car.setBorder(cadre);
                     car.add(carLab, BorderLayout.EAST);
                     plateau.add(car);
                     break;
           case 33 : car.setLayout(new BorderLayout());
                     carLab.setBorder(cadre);
                     carLab.setBackground(Color.green);
                     car.setBorder(cadre);
                     car.add(carLab, BorderLayout.WEST);
                     plateau.add(car);
                     break;   
            case 34 : car.setLayout(new BorderLayout());
                     //carLab.setBorder(cadre);
                     //carLab.setBackground(Color.orange);
                     car.setBorder(cadre);
                     car.add(carLab, BorderLayout.EAST);
                     plateau.add(car);
                     break;
                     
            case 44 : car.setLayout(new BorderLayout());
                     //carLab.setBorder(cadre);
                     //carLab.setBackground(Color.green);
                     car.setBorder(cadre);
                     car.add(carLab, BorderLayout.WEST);
                     plateau.add(car);
                     break;
            case 45 : car.setLayout(new BorderLayout());
                     carLab.setBorder(cadre);
                     carLab.setBackground(Color.orange);
                     car.setBorder(cadre);
                     car.add(carLab, BorderLayout.EAST);
                     plateau.add(car);
                     break;   
            case 55 : car.setLayout(new BorderLayout());
                     carLab.setBorder(cadre);
                     carLab.setBackground(Color.green);
                     car.setBorder(cadre);
                     car.add(carLab, BorderLayout.WEST);
                     plateau.add(car);
                     break;
                     
            case 56 : car.setLayout(new BorderLayout());
                     //carLab.setBorder(cadre);
                     //carLab.setBackground(Color.yellow);
                     car.setBorder(cadre);
                     car.add(carLab, BorderLayout.SOUTH);
                     plateau.add(car);
                     break;
            case 66 : car.setLayout(new BorderLayout());
                     //carLab.setBorder(cadre);
                     //carLab.setBackground(Color.red);
                     car.setBorder(cadre);
                     car.add(carLab, BorderLayout.SOUTH);
                     plateau.add(car);
                     break;   
            case 67 : car.setLayout(new BorderLayout());
                     carLab.setBorder(cadre);
                     carLab.setBackground(Color.MAGENTA);
                     car.setBorder(cadre);
                     car.add(carLab, BorderLayout.EAST);
                     plateau.add(car);
                     break;
            case 61 :JLabel lab = new JLabel(new ImageIcon("/users/info/etu-s2/tostonr/Downloads/index.jpeg"));
                    Dimension dim2 = new Dimension(150,150);
                     Dimension dim3 = new Dimension(310,282);
                     car.setPreferredSize(dim3);
                     lab.setPreferredSize(dim2);
                     car.add(lab);
                     plateau.add(car);
                     break;         
            case 77 : car.setLayout(new BorderLayout());
                     //carLab.setBorder(cadre);
                     //carLab.setBackground(Color.red);
                     car.setBorder(cadre);
                     car.add(carLab, BorderLayout.SOUTH);
                     plateau.add(car);
                     break;
            case 78 : car.setLayout(new BorderLayout());
                     carLab.setBorder(cadre);
                     carLab.setBackground(Color.magenta);
                     car.setBorder(cadre);
                     car.add(carLab, BorderLayout.EAST);
                     plateau.add(car);
                     break; 
            case 88 : car.setLayout(new BorderLayout());
                     carLab.setBorder(cadre);
                     carLab.setBackground(Color.blue);
                     car.setBorder(cadre);
                     car.add(carLab, BorderLayout.WEST);
                     plateau.add(car);
                     break;
                     
             case 89 : car.setLayout(new BorderLayout());
                     carLab.setBorder(cadre);
                     carLab.setBackground(Color.magenta);
                     car.setBorder(cadre);
                     car.add(carLab, BorderLayout.EAST);
                     plateau.add(car);
                     break;
            case 99 : car.setLayout(new BorderLayout());
                     //carLab.setBorder(cadre);
                     //carLab.setBackground(Color.red);
                     car.setBorder(cadre);
                     car.add(carLab, BorderLayout.SOUTH);
                     plateau.add(car);
                     break;
            case 100 : car.setLayout(new BorderLayout());
                    // carLab.setBorder(cadre);
                     //carLab.setBackground(Color.orange);
                     car.setBorder(cadre);
                     car.add(carLab, BorderLayout.EAST);
                     plateau.add(car);
                     break;
            case 110 : car.setLayout(new BorderLayout());
                     carLab.setBorder(cadre);
                     carLab.setBackground(Color.blue);
                     car.setBorder(cadre);
                     car.add(carLab, BorderLayout.WEST);
                     plateau.add(car);
                     break;   
        //case bas gauche   
           case 111 : car.setLayout(new BorderLayout());
                    // carLab.setBorder(cadre);
                    // carLab.setBackground(Color.orange);
                     car.setBorder(cadre);
                     car.add(carLab, BorderLayout.EAST);
                     plateau.add(car);
                     break;
           case 112 : car.setLayout(new BorderLayout());
                     carLab.setBorder(cadre);
                     carLab.setBackground(Color.cyan);
                     car.setBorder(cadre);
                     car.add(carLab, BorderLayout.NORTH);
                     plateau.add(car);
                     break;   
            case 113 : car.setLayout(new BorderLayout());
                     carLab.setBorder(cadre);
                     carLab.setBackground(Color.cyan);
                     car.setBorder(cadre);
                     car.add(carLab, BorderLayout.NORTH);
                     plateau.add(car);
                     break;
                     
            case 114: car.setLayout(new BorderLayout());
                     //carLab.setBorder(cadre);
                     //carLab.setBackground(Color.green);
                     car.setBorder(cadre);
                     car.add(carLab, BorderLayout.WEST);
                     plateau.add(car);
                     break;
            case 115 : car.setLayout(new BorderLayout());
                     carLab.setBorder(cadre);
                     carLab.setBackground(Color.cyan);
                     car.setBorder(cadre);
                     car.add(carLab, BorderLayout.NORTH);
                     plateau.add(car);
                     break;
                     
            case 116 : car.setLayout(new BorderLayout());
                    // carLab.setBorder(cadre);
                     //carLab.setBackground(Color.yellow);
                     car.setBorder(cadre);
                     car.add(carLab, BorderLayout.SOUTH);
                     plateau.add(car);
                     break;
                     
            case 117 : car.setLayout(new BorderLayout());
                     //carLab.setBorder(cadre);
                     //carLab.setBackground(Color.yellow);
                     car.setBorder(cadre);
                     car.add(carLab, BorderLayout.SOUTH);
                     plateau.add(car);
                     break;
            case 118 : car.setLayout(new BorderLayout());
                     carLab.setBorder(cadre);
                     carLab.setBackground(Color.pink);
                     car.setBorder(cadre);
                     car.add(carLab, BorderLayout.NORTH);
                     plateau.add(car);
                     break;   
            case 119 : car.setLayout(new BorderLayout());
                     //carLab.setBorder(cadre);
                     //carLab.setBackground(Color.pink);
                     car.setBorder(cadre);
                     car.add(carLab, BorderLayout.NORTH);
                     plateau.add(car);
                     break;   
            case 120 : car.setLayout(new BorderLayout());
                     carLab.setBorder(cadre);
                     carLab.setBackground(Color.pink);
                     car.setBorder(cadre);
                     car.add(carLab, BorderLayout.NORTH);
                     plateau.add(car);
                     break;   
                     
            case 121 : car.setLayout(new BorderLayout());
                     //carLab.setBorder(cadre);
                     //carLab.setBackground(Color.magenta);
                     car.setBorder(cadre);
                     car.add(carLab, BorderLayout.EAST);
                     plateau.add(car);
                     break; 
            
                    
                     
            default: plateau.add(new JPanel());
                     break;
       }
       
   }
   
   
   fenetre.add(plateau, BorderLayout.CENTER);
   
   fenetre.setVisible(true);
   
   
   
    
    
    
    
    
    
    
    
    }
    
}
