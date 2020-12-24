package projetUML;

public class Personnage {
    private String type;
    private int vie;
    private int hydratation;
    private int satiete;
    private int nbDiplome;
    private int moral;
    private boolean permis;


    public Personnage(String type){
        if(type == "Standard"){
            this.vie = 75;
            this.hydratation = 75;
            this.satiete = 75;
            this.moral = 75;
            this.permis = true;
        }

        else if (type == "Hippie"){
            this.vie = 75;
            this.hydratation = 50;
            this.satiete = 50;
            this.moral = 100;
            this.permis = false;
        }

        else if (type == "Presse"){
            this.vie = 100;
            this.hydratation = 75;
            this.satiete = 75;
            this.moral = 50;
            this.permis = true;
        }
    }

    void Affiche(){
        System.out.println("vie = " + this.vie + "hydra = " + this.hydratation);
    }

}

