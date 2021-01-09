package projetUML;

import javax.swing.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner utilisateur = new Scanner(System.in);
        System.out.println("Entrez type de personnage");
        String str = utilisateur.nextLine();
        Personnage personnage = new Personnage(str);
        personnage.affiche();
        Plateau jeu = new Plateau(personnage);
        //jeu.affiche();
        System.out.println("Entrez votre moyen de transport");
        str = utilisateur.nextLine();
        MoyenTransport moyenTransport = new MoyenTransport(str);
        jeu.deplacement(personnage,moyenTransport);
    }
}
