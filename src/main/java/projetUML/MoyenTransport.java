package projetUML;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Random;

public class MoyenTransport {

    private String moyenTransport;

    public String getMoyenTransport() {
        return moyenTransport;
    }

    public MoyenTransport(String moyenTransport){
        switch (moyenTransport) {
            case "Voiture" -> this.moyenTransport = "Voiture";
            case "A Pied" -> this.moyenTransport = "A Pied";
            case "Velo" -> this.moyenTransport = "Velo";
        }
    }

    public void deplacer(Personnage personnage){

        personnage.actionDeplacer();

        if (this.moyenTransport.equals("Voiture") && personnage.isPermis()){
            Random chance = new Random();
            int chanceMourir = chance.nextInt(100);
            personnage.setMoral(personnage.getMoral()-2.0);
            if(chanceMourir <= 2){
                System.out.println("Tu t'es mangé un poid lourd fdp apprend a conduire");
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

        else if(this.moyenTransport.equals("A pied")){
            personnage.setSatiete(personnage.getSatiete()-10);
            personnage.setHydratation(personnage.getHydratation()-10);
        }

        else if(this.moyenTransport.equals("Velo")){
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
