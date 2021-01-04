package projetUML;

import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner utilisateur = new Scanner(System.in);
        System.out.println("Entrez type de personnage");
        String str = utilisateur.nextLine();
        Personnage personnage = new Personnage(str);
        personnage.affiche();
        System.out.println("Taper Plateau pour commencer");
        str = utilisateur.nextLine();
        if (str.equals("Plateau")){
            Plateau jeu = new Plateau(personnage);
            jeu.deplacement(personnage);
        }
    }
}
