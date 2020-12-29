package projetUML;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Personnage a = new Personnage("Hippie");
        Personnage b = new Personnage("Presse");

        Batiment A = new Bar();
        Batiment B = new FastFood();
        Batiment C = new Bibliotheque();

        a.affiche();
        C.ressourcer(a);
        A.ressourcer(a);
        a.affiche();
    }
}
