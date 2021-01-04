package projetUML;

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
        if(type.equals("Standard")){
            this.vie = 75;
            this.hydratation = 75;
            this.satiete = 75;
            this.moral = 75;
            this.permis = true;
            this.nbArrestation = 0;
        }

        else if (type.equals("Hippie")){
            this.vie = 75;
            this.hydratation = 50;
            this.satiete = 50;
            this.moral = 100;
            this.permis = false;
        }

        else if (type.equals("Presse")){
            this.vie = 100;
            this.hydratation = 75;
            this.satiete = 75;
            this.moral = 50;
            this.permis = true;
            this.nbArrestation = 0;
        }
        else{
            System.out.println("Non valide");
        }
    }

    public double getVie() {
        return vie;
    }

    public void setVie(double vie) {
        this.vie = vie;
        if (vie > 100){
            this.vie = 100;
        }
        else if(vie == 0){
            System.out.println("Personnage mort fin de la simulation");
            return;
        }
    }

    public double getHydratation() {
        return hydratation;
    }

    public void setHydratation(double hydratation) {
        this.hydratation = hydratation;
        if (hydratation > 100){
            this.hydratation = 100;
        }
    }

    public double getSatiete() {
        return satiete;
    }

    public void setSatiete(double satiete) {
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

    public double getMoral() {
        return moral;
    }

    public void setMoral(double moral) {
        this.moral = moral;
        if (moral > 100){
            this.moral = 100;
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
        System.out.println("vie = " + this.vie + " hydra = " + this.hydratation + " satiete = " + this.satiete + " Nombre diplome = " + this.nbDiplome + " Moral = " + this.moral
        + " Chance diplome " + this.chanceDiplome);
    }

    public void gameOver(){
        if (this.vie == 0 || this.moral == 0 || this.hydratation == 0 || this.satiete == 0){
            System.out.println("Game over, simulation terminé");
            return;
        }
        else if (nbArrestation >= 3){
            System.out.println("Game over, simulation terminé");
            return;
        }
    }

    public void action(){
        if(this.type == "Standard" || this.type == "Presse"){
            this.setVie(this.getVie()-1);
            this.setMoral(this.getMoral()-1);
            this.setHydratation(this.getHydratation()-1);
            this.setSatiete(this.getSatiete()-1);
        }
        else if(this.type == "Hippie"){
            this.setVie(this.getVie()-0.5);
            this.setHydratation(this.getHydratation()-0.5);
            this.setSatiete(this.getSatiete()-0.5);
        }
    }

    public void actionDeplacer(){

        if(this.getType() == "Standard"){
            this.action();
        }

        else if(this.getType() =="Hippie"){
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

