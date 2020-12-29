package projetUML;

public class Personnage {

    private String type;
    private int vie;
    private int hydratation;
    private int satiete;
    private int nbDiplome;
    private float chanceDiplome;
    private int moral;
    private boolean permis;


    public Personnage(String type){

        this.type = type;
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

    public int getVie() {
        return vie;
    }

    public void setVie(int vie) {
        this.vie = vie;
        if (vie > 100){
            this.vie = 100;
        }
        else if(vie == 0){
            System.out.println("Personnage mort fin de la simulation");
            return;
        }
    }

    public int getHydratation() {
        return hydratation;
    }

    public void setHydratation(int hydratation) {
        this.hydratation = hydratation;
        if (hydratation > 100){
            this.hydratation = 100;
        }
    }

    public int getSatiete() {
        return satiete;
    }

    public void setSatiete(int satiete) {
        this.satiete = satiete;
        if (satiete > 100){
            this.satiete = 100;
        }
    }

    public int getNbDiplome() {
        return nbDiplome;
    }

    public void setNbDiplome(int nbDiplome) {
        this.nbDiplome = nbDiplome;
    }

    public int getMoral() {
        return moral;
    }

    public void setMoral(int moral) {
        this.moral = moral;
        if (moral > 100){
            this.moral = 100;
        }
    }

    public float getChanceDiplome() {
        return chanceDiplome;
    }

    public void setChanceDiplome(float chanceDiplome) {
        this.chanceDiplome = chanceDiplome;
    }

    void affiche(){
        System.out.println("vie = " + this.vie + " hydra = " + this.hydratation + " satiete = " + this.satiete + " Nombre diplome = " + this.nbDiplome + " Moral = " + this.moral
        + " Chance diplome " + this.chanceDiplome);
    }

}

