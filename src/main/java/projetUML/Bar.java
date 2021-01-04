package projetUML;

import java.util.Random;

public class Bar extends Batiment{

    public Bar() {
    }

    public String getNom(){
        return "Bar";
    }

    public  void ressourcer(Personnage personnage){
        Random chance = new Random();
        int livreDiplome = chance.nextInt(100);
        if (livreDiplome <= 5){
            personnage.setChanceDiplome(personnage.getChanceDiplome()+0.05);
        }
        personnage.setHydratation(personnage.getHydratation()+25);
        personnage.setMoral(personnage.getMoral()+10);
        personnage.setVie(personnage.getVie()-3);


    }
}
