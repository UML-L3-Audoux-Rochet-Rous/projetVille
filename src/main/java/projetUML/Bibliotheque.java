package projetUML;

import java.util.Random;

public class Bibliotheque extends Batiment {

    int livre = 20;

    public Bibliotheque() {
    }

    public String getNom(){
        return "Bibliotheque";
    }

    public void ressourcer(Personnage personnage){
        Random nbLivres = new Random();
        int livreDiplome = nbLivres.nextInt(100);
        if (livreDiplome < 5){
            personnage.setChanceDiplome((float) (personnage.getChanceDiplome()+0.10));
        }
        personnage.setMoral(personnage.getMoral()+20);
    }
}
