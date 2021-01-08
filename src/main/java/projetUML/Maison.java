package projetUML;

public class Maison extends Batiment{

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
}
