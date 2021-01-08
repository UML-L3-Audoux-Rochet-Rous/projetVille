package projetUML;

import java.util.Random;

public class MoyenTransport {

    private String moyenTransport;

    public String getMoyenTransport() {
        return moyenTransport;
    }

    public void setMoyenTransport(String moyenTransport) {
        this.moyenTransport = moyenTransport;
    }

    public void deplacer(Personnage personnage, String moyenTransport){

        personnage.actionDeplacer();

        if (moyenTransport.equals("Voiture") && personnage.isPermis()){
            Random chance = new Random();
            int chanceMourir = chance.nextInt(100);
            personnage.setMoral(personnage.getMoral()-2);

            if(chanceMourir <= 2){
                personnage.setVie(0);
                personnage.gameOver();
            }

            Random chanceArrest = new Random();
            int arrestation = chanceArrest.nextInt(100);
            if (arrestation <= 5){
                personnage.setNbArrestation(personnage.getNbArrestation()+1);
                personnage.gameOver();
            }
        }

        else if(moyenTransport.equals("A pied")){
            personnage.setSatiete(personnage.getSatiete()-10);
            personnage.setHydratation(personnage.getHydratation()-10);
        }

        else if(moyenTransport.equals("Velo")){
            personnage.setSatiete(personnage.getSatiete()-5);
            personnage.setHydratation(personnage.getHydratation()-5);
            Random chance = new Random();
            double chanceMourir = chance.nextDouble();
            if(chanceMourir <= 0.0005){
                personnage.setVie(0);
                personnage.gameOver();
            }
        }
    }

}
