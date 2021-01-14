package projetUML;

import static java.lang.System.exit;

public class Personnage {

    private String type;
    private double vie;
    private double hydratation;
    private double satiete;
    private int nbDiplome;
    private double chanceDiplome;
    private double moral;
    private boolean permis;
    private  int nbArrestation;
    private int persoX;
    private int persoY;


    public Personnage(String type){
        this.type = type;
        switch (type) {
            case "Standard" -> {
                this.vie = 75;
                this.hydratation = 75;
                this.satiete = 75;
                this.moral = 75;
                this.permis = true;
                this.nbArrestation = 0;
            }
            case "Hippie" -> {
                this.vie = 75;
                this.hydratation = 50;
                this.satiete = 50;
                this.moral = 100;
                this.permis = false;
            }
            case "Presse" -> {
                this.vie = 100;
                this.hydratation = 75;
                this.satiete = 75;
                this.moral = 50;
                this.permis = true;
                this.nbArrestation = 0;
            }
            default -> System.out.println("Non valide");
        }
    }

    public double getVie() {
        return vie;
    }

    public void setVie(double vie) {
        this.vie = vie;
        if (this.vie > 100){
            this.vie = 100;
        }
        else if(this.vie == 0){
            System.out.println("Personnage mort fin de la simulation");
            gameOver();
        }
    }

    public double getHydratation() {
        return hydratation;
    }

    public void setHydratation(double hydratation) {
        this.hydratation = hydratation;
        if (this.hydratation > 100){
            this.hydratation = 100;
        }
        else if (this.hydratation == 0){
            gameOver();
        }
    }

    public double getSatiete() {
        return satiete;
    }

    public void setSatiete(double satiete) {
        this.satiete = satiete;
        if (this.satiete > 100){
            this.satiete = 100;
        }
        else if(this.satiete == 0){
            gameOver();
        }
    }

    public int getNbDiplome() {
        return nbDiplome;
    }

    public void setNbDiplome(int nbDiplome) {
        this.nbDiplome = nbDiplome;
    }

    public double getMoral() {
        return moral;
    }

    public void setMoral(double moral) {
        this.moral = moral;
        if (this.moral > 100){
            this.moral = 100;
        }
        else if (this.moral == 0){
            gameOver();
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isPermis() {
        return permis;
    }

    public void setPermis(boolean permis) {
        this.permis = permis;
    }

    public int getNbArrestation() {
        return nbArrestation;
    }

    public void setNbArrestation(int nbArrestation) {
        this.nbArrestation = nbArrestation;
    }

    public double getChanceDiplome() {
        return chanceDiplome;
    }

    public void setChanceDiplome(double chanceDiplome) {
        this.chanceDiplome = chanceDiplome;
    }

    public void affiche(){
        System.out.println(" Vie : " + this.vie + "\t | \t Moral : " + this.moral + "\n Satiete : " + this.satiete + "\t | \t Hydratation : " + this.hydratation
        + "\n Diplomes : " + this.nbDiplome + "\t | \t Intelligence : " + this.chanceDiplome + "\n Position perso : " + this.getPersoX() + " " + this.getPersoY());

    }

    public void gameOver(){
        if (this.vie == 0 || this.moral == 0 || this.hydratation == 0 || this.satiete == 0 || nbArrestation >= 3) {
            System.out.println("Jeu terminé personnage mort");
            exit(0);
        }
    }

    public void action(){
        if(this.type.equals("Standard") || this.type.equals("Presse")){
            this.setVie(this.getVie()-1);
            this.setMoral(this.getMoral()-1);
            this.setHydratation(this.getHydratation()-1);
            this.setSatiete(this.getSatiete()-1);
        }
        else if(this.type.equals("Hippie")){
            this.setVie(this.getVie()-0.5);
            this.setHydratation(this.getHydratation()-0.5);
            this.setSatiete(this.getSatiete()-0.5);
        }
    }

    public void actionDeplacer(){

        if(this.getType().equals("Standard")){
            this.action();
        }

        else if(this.getType().equals("Hippie")){
            this.setVie(this.getVie()-2);
            this.setHydratation(this.getHydratation()-2);
            this.setSatiete(this.getSatiete()-2);
        }
        else{
            this.setMoral(this.getMoral()-2);
        }
    }

    public int getPersoX() {
        return persoX;
    }

    public void setPersoX(int persoX) {
        this.persoX = persoX;
    }

    public int getPersoY() {
        return persoY;
    }

    public void setPersoY(int persoY) {
        this.persoY = persoY;
    }
}

