package projetUML;

public class Maison extends Batiment{

    private Case position;
    public Maison() {
    }

    public String getNom(){
        return "Maison";
    }

    public void ressourcer(Personnage personnage){
        personnage.setVie(personnage.getVie()+10);
        personnage.setSatiete(personnage.getSatiete()+10);
        personnage.setHydratation(personnage.getHydratation()+10);
    }

    public Case getPosition() {
        return position;
    }

    public void setPosition(Case position) {
        this.position = position;
    }
}
