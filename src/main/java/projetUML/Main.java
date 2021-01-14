package projetUML;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Main {

    private Color color;

    public static void main(String[] args) {
        List<String> moyenDepla = new ArrayList<>(Arrays.asList("Voiture","Velo","A Pied"));
        List<String> perso = new ArrayList<>(Arrays.asList("Standard","Hippie","Presse"));
        Scanner utilisateur = new Scanner(System.in);
        System.out.println("Entrez type de personnage parmis la liste : " + perso);
        String str = utilisateur.nextLine();
        while(!perso.contains(str)){
            System.out.println("Entrez type de personnage parmis la liste : " + perso);
            str = utilisateur.nextLine();
    }
        Personnage personnage = new Personnage(str);
        Plateau jeu = new Plateau(personnage);
        jeu.affiche();
        personnage.affiche();
        System.out.println("Choissiez transport parmis la liste : " + moyenDepla);
        str = utilisateur.nextLine();
        while(!moyenDepla.contains(str)){
            System.out.println("Choissiez transport parmis la liste : " + moyenDepla);
            str = utilisateur.nextLine();
        }
        MoyenTransport moyenTransport = new MoyenTransport(str);
        jeu.deplacement(personnage,moyenTransport);
    }
}
